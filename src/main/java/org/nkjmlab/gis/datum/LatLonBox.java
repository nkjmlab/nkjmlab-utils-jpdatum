package org.nkjmlab.gis.datum;

import java.util.Objects;
import org.nkjmlab.gis.datum.jprect.LatLonWithZone;
import org.nkjmlab.gis.datum.jprect.ZoneId;

public class LatLonBox {

  public static final double PIXEL = 256;

  private final LatLon northWest;
  private final LatLon southEast;

  private final LatLon southWest;
  private final LatLon northEast;

  public LatLonBox(LatLon northWest, LatLon southEast) {
    this.northWest = northWest;
    this.southEast = southEast;
    this.southWest = new LatLon(southEast.getLat(), northWest.getLon(), northWest.basis);
    this.northEast = new LatLon(northWest.getLat(), southEast.getLon(), northWest.basis);
  }

  public LatLon getNorthWest() {
    return northWest;
  }

  public LatLon getSouthEast() {
    return southEast;
  }

  public LatLon getSouthWest() {
    return southWest;
  }

  public LatLon getNorthEast() {
    return northEast;
  }

  public double getNorthEdgeLat(Basis basis) {
    return northWest.getLat(basis);
  }

  public double getSouthEdgeLat(Basis basis) {
    return southEast.getLat(basis);
  }

  public double getWestEdgeLon(Basis basis) {
    return northWest.getLon(basis);
  }

  public double getEastEdgeLon(Basis basis) {
    return southEast.getLon(basis);
  }

  @Override
  public int hashCode() {
    return Objects.hash(northEast, northWest, southEast, southWest);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (!(obj instanceof LatLonBox))
      return false;
    LatLonBox other = (LatLonBox) obj;
    return Objects.equals(northEast, other.northEast) && Objects.equals(northWest, other.northWest)
        && Objects.equals(southEast, other.southEast) && Objects.equals(southWest, other.southWest);
  }

  @Override
  public String toString() {
    return "LatLonBox [northWest=" + northWest + ", southEast=" + southEast + ", southWest="
        + southWest + ", northEast=" + northEast + "]";
  }

  public double getLatDistance(Basis basis) {
    return Math.abs(getNorthEdgeLat(basis) - getSouthEdgeLat(basis));
  }

  public double getLatDistanceByPixel(Basis basis) {
    return getLatDistance(basis) / PIXEL;
  }

  public double getLonDistance(Basis basis) {
    return Math.abs(getEastEdgeLon(basis) - getWestEdgeLon(basis));
  }

  public double getLonDistanceByPixel(Basis basis) {
    return getLonDistance(basis) / PIXEL;
  }

  public double getXDistance(ZoneId zoneId, DistanceUnit distanceUnit) {
    return new LatLonWithZone(getNorthWest(), zoneId)
        .distance(new LatLonWithZone(getSouthWest(), zoneId), distanceUnit);
  }

  public double getYDistance(ZoneId zoneId, DistanceUnit distanceUnit) {
    return new LatLonWithZone(getNorthWest(), zoneId)
        .distance(new LatLonWithZone(getNorthEast(), zoneId), distanceUnit);

  }

}
