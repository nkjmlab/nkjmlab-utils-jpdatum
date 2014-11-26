package org.nkjmlab.latlngxy.util;

/**
 *
 * @author Yuu NAKAJIMA
 *
 */
public class CoordUtils {

	/**
	 * 10進表記(ddd.ddddd)を度分秒表記(ddd.mmsss)に変換
	 */
	public static double degreeToDms(double ddd_ddddd) {
		int ddd = (int) ddd_ddddd;
		double mm = (int) ((ddd_ddddd - ddd) / 100.0 * 60.0);
		double sss = (ddd_ddddd - ddd - mm) / 100.0 * 60.0;
		return ddd + mm + sss;

	}

	/**
	 * 度分秒表記(ddd.mmsss)を10進表記(ddd.ddddd)に変換
	 */
	public static double dmsToDegree(double ddd_mmsss) {
		int ddd = (int) ddd_mmsss;
		double _dd = (int) ((ddd_mmsss - ddd) / 60.0 * 100.0);
		double __ddd = (ddd_mmsss - ddd - _dd) / 60 * 100;

		return ddd + _dd + __ddd;
	}

	public static void main(String[] args) {
		// lng:132.1(132.16666666666666)
		System.out.println(dmsToDegree(132.1));
		System.out.println(degreeToDms(132.16666666666666));
		// lng:134.20000000000002(134.33333333333334)
		System.out.println(dmsToDegree(134.20000000000002));
		System.out.println(degreeToDms(134.33333333333334));
	}

}
