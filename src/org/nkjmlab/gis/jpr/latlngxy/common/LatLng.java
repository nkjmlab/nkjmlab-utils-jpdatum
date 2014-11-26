package org.nkjmlab.gis.jpr.latlngxy.common;

import java.security.InvalidParameterException;

/**
 *
 * @author Yuu NAKAJIMA
 *
 */
public class LatLng extends org.nkjmlab.gis.common.LatLng {

	private int zoneId;

	/**
	 * @param lat
	 *            度分秒(dms: ddd.mmsss)表記
	 * @param lng
	 *            度分秒(dms: ddd.mmsss)表記
	 */

	public LatLng(double lat, double lng, int zoneId) {
		super(lat, lng);
		this.zoneId = zoneId;

		if (zoneId <= 0 || 20 <= zoneId) {
			String s = "zoneId=" + zoneId
					+ " is invalid. The zone id range from 1 to 19.";
			System.err.println(s);
			throw new InvalidParameterException(s);
		}

	}

	public int getZoneId() {
		return zoneId;
	}

	@Override
	public String toString() {
		return super.toString() + "[lat=" + getLat() + ",lng=" + getLng()
				+ ",zoneId=" + zoneId + "]";
	}

}
