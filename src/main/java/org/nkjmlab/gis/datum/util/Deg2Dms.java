package org.nkjmlab.gis.datum.util;

/**
 *
 * @author Yuu NAKAJIMA
 *
 */
public class Deg2Dms {

	/**
	 * 10進表記(ddd.ddddd)を度分秒表記(ddd.mmsss)に変換
	 */
	public static double to(double ddd_ddddd) {
		int ddd = (int) ddd_ddddd;
		double min = (int) ((ddd_ddddd - ddd) * 60.0);
		double sec = (int) ((((ddd_ddddd - ddd) * 60.0) - min) * 60.0);
		double s = (((((ddd_ddddd - ddd) * 60.0) - min) * 60.0) - sec);

		return ddd + min / 100 + sec / 10000 + s / 10000;

	}

}
