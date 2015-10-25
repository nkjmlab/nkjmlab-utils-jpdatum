package org.nkjmlab.gis.datum.util;

/***
 * 簡易的な世界測地系=>旧日本測地系変換(TD: Tokyo Datum) をする．
 *
 * https://web.archive.org/web/20140710182621/http://homepage3.nifty.com/Nowral/
 * 02_DATUM/02_DATUM.html
 * 
 * @author Yuu NAKAJIMA
 */

public class Wgs2TD {

	public static double toLatTD(double latDegWgs, double lonDegWgs) {
		return latDegWgs + latDegWgs * 0.00010696 - lonDegWgs * 0.000017467 - 0.0046020;
	}

	public static double toLonTD(double latDegWgs, double lonDegWgs) {
		return lonDegWgs + latDegWgs * 0.000046047 + lonDegWgs * 0.000083049 - 0.010041;
	}

}
