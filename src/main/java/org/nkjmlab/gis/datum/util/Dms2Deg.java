package org.nkjmlab.gis.datum.util;

/**
 *
 * @author Yuu NAKAJIMA
 *
 */
public class Dms2Deg {

	/**
	 * 度分秒表記(ddd.mmsss)を10進表記(ddd.ddddd)に変換
	 */
	public static double toDeg(double ddd_mmsss) {
		int ddd = (int) ddd_mmsss;
		double min = ((int) ((ddd_mmsss - ddd) * 100.0));
		double sec = (ddd_mmsss - ddd - min / 100) * 10000;

		return ddd + min / 60 + sec / 3600;
	}

}
