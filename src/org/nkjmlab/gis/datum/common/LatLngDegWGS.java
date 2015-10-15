package org.nkjmlab.gis.datum.common;

/***
 * 世界測地系(WGS)を表現するクラス．
 *
 * こでWGSとは，日本測地系2000 (JGD2000, Japanese Geodetic Datum 2011． GRS-80楕円体．
 * ITRF2008座標系） を指すものとする．
 *
 * Google Mapなどが採用しているWGS84とは異なるが日常的に使うならば，許容できる程度の差しかない．
 */

public class LatLngDegWGS extends LatLngDegAbst {
	public LatLngDegWGS(double latDeg, double lngDeg) {
		super(latDeg, lngDeg);
	}

}
