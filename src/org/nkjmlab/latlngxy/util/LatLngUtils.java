package org.nkjmlab.latlngxy.util;

/**
 *
 * @author Yuu NAKAJIMA
 *
 */
public class LatLngUtils {

	/**
	 * 10進表記(ddd.ddddd)を度分秒表記(ddd.mmsss)に変換
	 */
	public static double degToDms(double ddd_ddddd) {
		int ddd = (int) ddd_ddddd;
		double min = (int) ((ddd_ddddd - ddd) * 60.0);
		double sec = (int) ((((ddd_ddddd - ddd) * 60.0) - min) * 60.0);
		double s = (((((ddd_ddddd - ddd) * 60.0) - min) * 60.0) - sec);

		return ddd + min / 100 + sec / 10000 + s / 10000;

	}

	/**
	 * 度分秒表記(ddd.mmsss)を10進表記(ddd.ddddd)に変換
	 */
	public static double dmsToDeg(double ddd_mmsss) {
		int ddd = (int) ddd_mmsss;
		double min = ((int) ((ddd_mmsss - ddd) * 100.0));
		double sec = (ddd_mmsss - ddd - min / 100) * 10000;

		return ddd + min / 60 + sec / 3600;
	}

}
