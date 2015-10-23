package org.nkjmlab.gis.datum.util;

public class Dms2Sec {

	public static void main(String[] args) {

		// System.out.println(Dms2Sec.toSec(1.0));
		System.out.println(Dms2Sec.toSec(1.30));// 3600+1800=5400
		System.out.println(Dms2Sec.toSec(1.3030));// 3600+1800+30=5430

	}

	public static double toSec(double ddd_mmss) {
		int d = (int) ddd_mmss;
		int m = (int) (((ddd_mmss - d) * 100));
		double s = (ddd_mmss * 100 - (int) (ddd_mmss * 100)) * 100;
		return d * 3600 + m * 60 + s;
	}

}
