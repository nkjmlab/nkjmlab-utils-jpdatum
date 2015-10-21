package org.nkjmlab.gis.datum.common;

/***
 * 世界測地系(WGS)を表現するクラス．
 *
 * こでWGSとは，日本測地系2000 (JGD2000, Japanese Geodetic Datum 2011． GRS-80楕円体．
 * ITRF2008座標系） を指すものとする．
 *
 * Google Mapなどが採用しているWGS84とは異なるが日常的に使うならば，許容できる程度の差しかない．
 */

public class LatLonDegWgs extends LatLonDeg {
	public LatLonDegWgs(double latDeg, double lonDeg) {
		super(latDeg, lonDeg);
	}

	/**
	 * 世界測地系の緯度を十進法(degree: ddd.dddd)表記
	 *
	 * @return
	 */
	public double getLat() {
		return lat;
	}

	/**
	 * 世界測地系の経度を十進法(degree: ddd.dddd)表記
	 *
	 * @return
	 */
	public double getLon() {
		return lon;
	}
}
