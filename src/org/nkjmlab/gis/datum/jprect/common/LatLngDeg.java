package org.nkjmlab.gis.datum.jprect.common;

import java.security.InvalidParameterException;

/**
 *
 * @author Yuu NAKAJIMA
 *
 */
public class LatLngDeg extends org.nkjmlab.gis.datum.common.LatLngDegAbst {

	public final int zoneId;

	public LatLngDeg(double lat, double lng, int zoneId) {
		super(lat, lng);
		this.zoneId = zoneId;

		if (zoneId <= 0 || 20 <= zoneId) {
			String s = "zoneId=" + zoneId
					+ " is invalid. The zone id range from 1 to 19.";
			System.err.println(s);
			throw new InvalidParameterException(s);
		}
	}

}
