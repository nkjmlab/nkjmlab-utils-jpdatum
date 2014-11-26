package org.nkjmlab.gis.jpr.latlngxy.common;

import java.security.InvalidParameterException;

/**
 *
 * @author Yuu NAKAJIMA
 *
 */
public class LatLng {

	private double lat;
	private double lng;
	private int zoneId;

	public LatLng(double lat, double lng, int zoneId) {
		this.lat = lat;
		this.lng = lng;
		this.zoneId = zoneId;

		if (zoneId <= 0 || 20 <= zoneId) {
			String s = "zoneId=" + zoneId
					+ " is invalid. The zone id range from 1 to 19.";
			System.err.println(s);
			throw new InvalidParameterException(s);
		}

	}

	public double getLat() {
		return lat;
	}

	public double getLng() {
		return lng;
	}

	public int getZoneId() {
		return zoneId;
	}

	@Override
	public String toString() {
		return super.toString() + "[lat=" + lat + ",lng=" + lng + ",zoneId="
				+ zoneId + "]";
	}

}
