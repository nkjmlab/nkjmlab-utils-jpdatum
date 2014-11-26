package org.nkjmlab.gis.util;

import org.nkjmlab.gis.common.LatLngTD;
import org.nkjmlab.gis.common.LatLngWGS;

/***
 * 日本測地系(TD: Tokyo Datum) から 世界測地系(WGS: JGD2000)へ簡易的な変換をする．
 *
 * @author Yuu NAKAJIMA
 */

public class TD2WGS {

	public static LatLngWGS toWGS(LatLngTD td) {
		double lat = td.getLat() - 0.00010695 * td.getLat() + 0.000017464
				* td.getLng() + 0.0046017;

		double lng = td.getLng() - 0.000046038 * td.getLat() - 0.000083043
				* td.getLng() + 0.010040;
		return new LatLngWGS(lat, lng);
	}

	public static void main(String[] args) {
		// TD(35.71004, 139.81070)=>JGD2000(35.713274983, 139.807461872)
		System.out.println(toWGS(new LatLngTD(35.71004, 139.81070)));

	}
}
