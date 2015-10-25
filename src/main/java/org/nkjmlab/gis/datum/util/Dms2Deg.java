package org.nkjmlab.gis.datum.util;

/**
 *
 * @author Yuu NAKAJIMA
 *
 */
public class Dms2Deg {

	/**
	 * 度分秒単位(dddmmss.s)を10進法度単位(ddd.ddddd)に変換
	 */
	public static double toDeg(double dddmmss_s) {
		double ddd_mmsss = dddmmss_s / 10000;
		int ddd = (int) ddd_mmsss;
		double min = (ddd_mmsss - ddd) * 100.0;
		double sec = (ddd_mmsss - ddd - min / 100) * 10000;

		return ddd + min / 60 + sec / 3600;
	}

}
