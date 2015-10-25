package org.nkjmlab.gis.datum.util;

/***
 * 旧日本測地系(TD: Tokyo Datum) から 世界測地系(WGS: JGD2000)へ簡易的な変換をする．
 *
 * https://web.archive.org/web/20140710182621/http://homepage3.nifty.com/Nowral/
 * 02_DATUM/02_DATUM.html
 *
 * @author Yuu NAKAJIMA
 */

public class TD2Wgs {

	public static double toLatWgs(double latDegTD, double lonDegTD) {
		return latDegTD - 0.00010695 * latDegTD + 0.000017464 * lonDegTD + 0.0046017;
	}

	public static double toLonWgs(double latDegTD, double lonDegTD) {
		return lonDegTD - 0.000046038 * lonDegTD - 0.000083043 * lonDegTD + 0.010040;
	}

}
