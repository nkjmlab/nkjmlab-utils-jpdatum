package org.nkjmlab.gis.datum.common;

/**
 *
 * @author Yuu NAKAJIMA
 *
 */
public class LatLonDeg extends LatLon {

	/**
	 * @param latDeg
	 *            緯度を十進法(degree: ddd.dddd)表記
	 * @param lonDeg
	 *            経度を十進法(degree: ddd.dddd)表記
	 */

	public LatLonDeg(double latDeg, double lonDeg) {
		super(latDeg, lonDeg);
	}

	/**
	 * 緯度の十進法(degree: ddd.dddd)表記
	 *
	 * @return
	 */
	public double getLat() {
		return lat;
	}

	/**
	 * 経度の十進法(degree: ddd.dddd)表記
	 *
	 * @return
	 */
	public double getLon() {
		return lon;
	}
}
