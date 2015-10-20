package org.nkjmlab.gis.datum.util;

import org.nkjmlab.gis.datum.common.LatLngDegWGS;
import org.nkjmlab.gis.datum.jprect.common.LatLngDegTD;

/***
 * 日本測地系(TD: Tokyo Datum) から 世界測地系(WGS: JGD2000)へ簡易的な変換をする．
 *
 * @author Yuu NAKAJIMA
 */

public class TD2WGS {

	public static LatLngDegWGS toWGS(LatLngDegTD td) {
		double lat = td.getLatDeg() - 0.00010695 * td.getLatDeg()
				+ 0.000017464 * td.getLngDeg() + 0.0046017;

		double lng = td.getLngDeg() - 0.000046038 * td.getLatDeg()
				- 0.000083043 * td.getLngDeg() + 0.010040;
		return new LatLngDegWGS(lat, lng);
	}

	public static void main(String[] args) {
		// TD(35.71004, 139.81070)=>JGD2000(35.713274983, 139.807461872)
		System.out.println(toWGS(new LatLngDegTD(35.71004, 139.81070)));

	}
}
