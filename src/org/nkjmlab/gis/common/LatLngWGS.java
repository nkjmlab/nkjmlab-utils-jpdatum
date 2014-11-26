package org.nkjmlab.gis.common;

/***
 * 世界測地系(WGS)を表現するクラス．
 *
 * こでWGSとは，日本測地系2000 (JGD2000, Japanese Geodetic Datum 2011． GRS-80楕円体．
 * ITRF2008座標系） を指すものとする．
 *
 * Google Mapなどが採用しているWGS84とは異なるが日常的に使うならば，許容できる程度の差しかない．
 */

public class LatLngWGS extends LatLng {
	/**
	 * @param lat
	 *            十進法(degree: ddd.dddd)表記
	 * @param lng
	 *            十進法(degree: ddd.dddd)表記
	 */
	public LatLngWGS(double lat, double lng) {
		super(lat, lng);
	}

}
