package org.nkjmlab.gis.common;

/**
 *
 * @author Yuu NAKAJIMA
 *
 */
public abstract class LatLng {

	private double lat;
	private double lng;

	public LatLng(double lat, double lng) {
		this.lat = lat;
		this.lng = lng;
	}

	public double getLat() {
		return lat;
	}

	public double getLng() {
		return lng;
	}

	@Override
	public String toString() {
		return super.toString() + "[lat=" + lat + ",lng=" + lng + "]";
	}

}
