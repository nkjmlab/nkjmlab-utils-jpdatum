package org.nkjmlab.gis.datum.util;

public class Dms2Sec {

	public static void main(String[] args) {

		// System.out.println(Dms2Sec.toSec(1.0));
		System.out.println(Dms2Sec.toSec(1.30));// 3600+1800=5400
		System.out.println(Dms2Sec.toSec(1.3030));// 3600+1800+30=5430

	}

	/**
	 * 度分秒単位(dddmmss.s)を秒に変換
	 */

	public static double toSec(double dddmmss_s) {
		double ddd_mmsss = dddmmss_s / 10000;
		int d = (int) ddd_mmsss;
		int m = (int) (((ddd_mmsss - d) * 100));
		double s = (ddd_mmsss * 100 - (int) (ddd_mmsss * 100)) * 100;
		return d * 3600 + m * 60 + s;
	}

}
