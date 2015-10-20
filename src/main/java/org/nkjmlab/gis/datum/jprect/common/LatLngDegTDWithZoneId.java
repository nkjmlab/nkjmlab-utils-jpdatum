package org.nkjmlab.gis.datum.jprect.common;

import java.security.InvalidParameterException;

/**
 * 日本測地系(TD: Tokyo Datum)
 *
 * @author Yuu NAKAJIMA
 *
 */
public class LatLngDegTDWithZoneId extends LatLngDegTD {

	public final int zoneId;

	public LatLngDegTDWithZoneId(double latDeg, double lngDeg, int zoneId) {
		super(latDeg, lngDeg);
		this.zoneId = zoneId;

		if (20 <= zoneId) {
			String s = "zoneId=" + zoneId
					+ " is invalid. The zone id range from 1 to 19.";
			System.err.println(s);
			throw new InvalidParameterException(s);
		}
	}

}
