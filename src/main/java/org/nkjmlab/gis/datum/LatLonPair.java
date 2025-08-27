package org.nkjmlab.gis.datum;

import java.util.Objects;

public class LatLonPair {
  protected final double lat;
  protected final double lon;

  public LatLonPair(double lat, double lon) {
    this.lat = lat;
    this.lon = lon;
  }

  public LatLonPair(LatLonPair latLon) {
    this(latLon.getLat(), latLon.getLon());
  }

  /**
   * 緯度を返す．
   *
   * @return
   */
  public double getLat() {
    return lat;
  }

  /**
   * 経度を返す．
   *
   * @return
   */
  public double getLon() {
    return lon;
  }

  @Override
  public int hashCode() {
    return Objects.hash(lat, lon);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (!(obj instanceof LatLonPair)) return false;
    LatLonPair other = (LatLonPair) obj;
    return Double.doubleToLongBits(lat) == Double.doubleToLongBits(other.lat)
        && Double.doubleToLongBits(lon) == Double.doubleToLongBits(other.lon);
  }

  @Override
  public String toString() {
    return "LatLonPair [lat=" + lat + ", lon=" + lon + "]";
  }
}
