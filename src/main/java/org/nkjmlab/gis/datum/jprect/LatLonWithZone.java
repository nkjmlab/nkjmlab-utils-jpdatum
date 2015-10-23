package org.nkjmlab.gis.datum.jprect;

import java.security.InvalidParameterException;

import org.nkjmlab.gis.datum.LatLon;

/**
 * Japan Plane Rectangular 平面直角座標系（平成十四年国土交通省告示第九号）の系番号付きの緯度経度
 *
 * @author Yuu NAKAJIMA
 *
 */
public class LatLonWithZone extends LatLon {

	public final int zoneId;

	/**
	 *
	 * @param zoneId
	 */
	public LatLonWithZone(LatLon latLon, int zoneId) {
		super(latLon.getLatDegTD(), latLon.getLonDegTD());
		this.zoneId = zoneId;

		if (20 <= zoneId) {
			String s = "zoneId=" + zoneId
					+ " is invalid. The zone id range from 1 to 19.";
			System.err.println(s);
			throw new InvalidParameterException(s);
		}
	}

	public int getZoneId() {
		return zoneId;
	}

}
