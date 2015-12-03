package org.nkjmlab.gis.datum;

public class LatLonPair {
	protected final double lat;
	protected final double lon;

	public LatLonPair(double lat, double lon) {
		this.lat = lat;
		this.lon = lon;
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
	public boolean equals(Object obj) {
		if (!(obj instanceof LatLon)) {
			return false;
		}
		LatLon l = (LatLon) obj;
		return this.lat == l.lat && this.lon == l.lon;
	}

	@Override
	public int hashCode() {
		return (int) (lat + lon);
	}

}
