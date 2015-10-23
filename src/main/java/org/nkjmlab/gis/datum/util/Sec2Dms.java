package org.nkjmlab.gis.datum.util;

public class Sec2Dms {

	public static void main(String[] args) {
		System.out.println(Sec2Dms.toDms(1));
		System.out.println(Sec2Dms.toDms(3600));
		System.out.println(Sec2Dms.toDms(3601));
		System.out.println(Sec2Dms.toDms(3660));
		System.out.println(Sec2Dms.toDms(3661));
		System.out.println(Sec2Dms.toDms(3670));
		System.out.println(Sec2Dms.toDms(3662));
		System.out.println(Sec2Dms.toDms(3720));
		System.out.println(Sec2Dms.toDms(4800));
		System.out.println(Sec2Dms.toDms(5400));

	}

	/**
	 * ddd.mmss
	 *
	 * @param second
	 * @return
	 */
	public static double toDms(double second) {
		int hour = (int) second / 3600;
		double minute = (int) ((second - hour * 3600) / 60);
		double sec = second - hour * 3600 - minute * 60;

		return hour + minute / 100 + sec / 10000;
	}

}
