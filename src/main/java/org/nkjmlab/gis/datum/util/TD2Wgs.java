package org.nkjmlab.gis.datum.util;

import org.nkjmlab.gis.datum.common.LatLonDegWgs;
import org.nkjmlab.gis.datum.common.LatLonDegTD;

/***
 * 日本測地系(TD: Tokyo Datum) から 世界測地系(WGS: JGD2000)へ簡易的な変換をする．
 *
 * @author Yuu NAKAJIMA
 */

public class TD2Wgs {

	public static LatLonDegWgs toWGS(LatLonDegTD td) {
		double lat = td.getLat() - 0.00010695 * td.getLat()
				+ 0.000017464 * td.getLon() + 0.0046017;

		double lng = td.getLon() - 0.000046038 * td.getLat()
				- 0.000083043 * td.getLon() + 0.010040;
		return new LatLonDegWgs(lat, lng);
	}

	public static void main(String[] args) {

	}
}
