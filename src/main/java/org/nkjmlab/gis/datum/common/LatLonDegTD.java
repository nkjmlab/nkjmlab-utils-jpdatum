package org.nkjmlab.gis.datum.common;

public class LatLonDegTD extends LatLonDeg {

	/**
	 * @param latDeg
	 *            日本測地系の緯度を十進法(degree: ddd.dddd)表記
	 * @param lonDeg
	 *            日本測地系の経度を十進法(degree: ddd.dddd)表記
	 */

	public LatLonDegTD(double latDeg, double lonDeg) {
		super(latDeg, lonDeg);
	}

	/**
	 * 日本測地系の緯度を十進法(degree: ddd.dddd)表記
	 *
	 * @return
	 */
	public double getLat() {
		return lat;
	}

	/**
	 * 日本測地系の経度を十進法(degree: ddd.dddd)表記
	 *
	 * @return
	 */
	public double getLon() {
		return lon;
	}

}
