package org.nkjmlab.gis.datum.util;

/***
 * 簡易的な世界測地系=>旧日本測地系変換(TD: Tokyo Datum) をする．
 *
 * @author Yuu NAKAJIMA
 */

public class Wgs2TD {

	public static double toLatTD(double latDegWgs, double lonDegWgs) {
		return latDegWgs + latDegWgs * 0.00010696 - lonDegWgs * 0.000017467
				- 0.0046020;
	}

	public static double toLonTD(double latDegWgs, double lonDegWgs) {
		return lonDegWgs + latDegWgs * 0.000046047 + lonDegWgs * 0.000083049
				- 0.010041;
	}

}
