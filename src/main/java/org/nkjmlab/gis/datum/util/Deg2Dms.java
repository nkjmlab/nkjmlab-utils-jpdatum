package org.nkjmlab.gis.datum.util;

/**
 *
 * @author Yuu NAKAJIMA
 *
 */
public class Deg2Dms {

	/**
	 * 十進法度単位(ddd.ddddd)を度分秒単位(dddmmss.s)に変換
	 */
	public static double toDms(double ddd_ddddd) {
		int ddd = (int) ddd_ddddd;
		double min = (ddd_ddddd - ddd) * 60.0;
		double sec = (min % 1 * 60.0);
		double _s = sec % 1;

		return carry(ddd * 10000 + (int) min * 100 + (int) sec + _s);

	}

	private static double carry(double dddmmss_s) {
		int ddd = (int) (dddmmss_s / 10000);

		int mm = (int) ((dddmmss_s - ddd * 10000) / 100);

		int ss = (int) ((dddmmss_s - ddd * 10000 - mm * 100));

		double _s = (dddmmss_s - ddd * 10000 - mm * 100 - ss) % 1;

		if (ss == 60) {
			ss = 0;
			mm++;
		}

		if (mm == 60) {
			mm = 0;
			ddd++;
		}

		return ddd * 10000 + mm * 100 + ss + _s;
	}

}
