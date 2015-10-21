package org.nkjmlab.gis.datum.jprect;

import java.security.InvalidParameterException;

import org.nkjmlab.gis.datum.common.LatLonDegTD;

/**
 * 日本測地系(TD: Tokyo Datum)の十進表記
 *
 * @author Yuu NAKAJIMA
 *
 */
public class LatLonWithZone extends LatLonDegTD {

	public final int zoneId;

	/**
	 *
	 * @param latDegTD
	 *            日本測地系の緯度を十進法(degree: ddd.dddd)表記．
	 * @param lngDegTD
	 *            日本測地系の経度を十進法(degree: ddd.dddd)表記．
	 * @param zoneId
	 */
	public LatLonWithZone(double latDegTD, double lngDegTD, int zoneId) {
		super(latDegTD, lngDegTD);
		this.zoneId = zoneId;

		if (20 <= zoneId) {
			String s = "zoneId=" + zoneId
					+ " is invalid. The zone id range from 1 to 19.";
			System.err.println(s);
			throw new InvalidParameterException(s);
		}
	}

}
