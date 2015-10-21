package org.nkjmlab.gis.datum.util;

import org.nkjmlab.gis.datum.common.LatLonDegWgs;
import org.nkjmlab.gis.datum.common.LatLonDegTD;

/***
 * 簡易的な日本測地系=>世界測地系変換をする
 *
 * @author Yuu NAKAJIMA
 */

public class Wgs2TD {

	public static LatLonDegTD toTD(LatLonDegWgs td) {
		double lat = td.getLat() - 0.00010695 * td.getLat()
				+ 0.000017464 * td.getLon() + 0.0046017;

		double lng = td.getLon() - 0.000046038 * td.getLon()
				- 0.000083043 * td.getLon() + 0.010040;
		return new LatLonDegTD(lat, lng);
	}

	public static void main(String[] args) {
		// TD(35.71004, 139.81070)=>JGD2000(35.713274983, 139.807461872)

		System.out.println(toTD(new LatLonDegWgs(35.71004, 139.81070)));

	}
}
