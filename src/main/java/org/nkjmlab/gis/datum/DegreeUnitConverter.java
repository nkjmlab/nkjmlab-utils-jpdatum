package org.nkjmlab.gis.datum;

import org.nkjmlab.gis.datum.LatLon.Unit;

public class DegreeUnitConverter {

	public static void main(String[] args) {

		// System.out.println(Dms2Sec.toSec(1.0));
		System.out.println(dmsToSec(1.30));// 3600+1800=5400
		System.out.println(dmsToSec(1.3030));// 3600+1800+30=5430
		System.out.println(secToDms(1));
		System.out.println(secToDms(3600));
		System.out.println(secToDms(3601));
		System.out.println(secToDms(3660));
		System.out.println(secToDms(3661));
		System.out.println(secToDms(3670));
		System.out.println(secToDms(3662));
		System.out.println(secToDms(3720));
		System.out.println(secToDms(4800));
		System.out.println(secToDms(5400));

	}

	/**
	 * 単位を変える．
	 *
	 * @param val
	 * @param fromUnit
	 * @param toUnit
	 * @return
	 */
	public static double change(double val, Unit fromUnit, Unit toUnit) {
		if (fromUnit == toUnit) {
			return val;
		}

		switch (fromUnit) {
		case DEGREE:
			if (toUnit == Unit.MILI_DEGREE) {
				return val * 1000;
			} else if (toUnit == Unit.DMS) {
				return degToDms(val);
			} else if (toUnit == Unit.SECOND) {
				return dmsToSec(degToDms(val));
			}
		case MILI_DEGREE:
			if (toUnit == Unit.DEGREE) {
				return val / 1000;
			} else if (toUnit == Unit.DMS) {
				return degToDms(val / 1000);
			} else if (toUnit == Unit.SECOND) {
				return dmsToSec(degToDms(val / 1000));
			}
		case DMS:
			if (toUnit == Unit.DEGREE) {
				return dmsToDeg(val);
			} else if (toUnit == Unit.MILI_DEGREE) {
				return dmsToDeg(val) * 1000;
			} else if (toUnit == Unit.SECOND) {
				return dmsToSec(val);
			}
		case SECOND:
			if (toUnit == Unit.DEGREE) {
				return dmsToDeg(secToDms(val));
			} else if (toUnit == Unit.MILI_DEGREE) {
				return dmsToDeg(secToDms(val)) * 1000;
			} else if (toUnit == Unit.DMS) {
				return secToDms(val);
			}
		default:
			throw new RuntimeException();
		}
	}

	/**
	 * 度分秒単位(dddmmss.s)を秒に変換
	 */

	public static double dmsToSec(double dddmmss_s) {
		double ddd_mmsss = dddmmss_s / 10000;
		int d = (int) ddd_mmsss;
		int m = (int) (((ddd_mmsss - d) * 100));
		double s = (ddd_mmsss * 100 - (int) (ddd_mmsss * 100)) * 100;
		return d * 3600 + m * 60 + s;
	}

	/**
	 * 度分秒単位(dddmmss.s)を10進法度単位(ddd.ddddd)に変換
	 */
	public static double dmsToDeg(double dddmmss_s) {
		double ddd_mmsss = dddmmss_s / 10000;
		int ddd = (int) ddd_mmsss;
		double min = (ddd_mmsss - ddd) * 100.0;
		double sec = (ddd_mmsss - ddd - min / 100) * 10000;

		return ddd + min / 60 + sec / 3600;
	}

	/**
	 * 十進法度単位(ddd.ddddd)を度分秒単位(dddmmss.s)に変換
	 */
	public static double degToDms(double ddd_ddddd) {
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

	/**
	 * dddmmss.sss
	 *
	 * @param second
	 * @return
	 */
	public static double secToDms(double second) {
		int hour = (int) second / 3600;
		double minute = (int) ((second - hour * 3600) / 60);
		double sec = second - hour * 3600 - minute * 60;

		return hour * 10000 + minute * 100 + sec;
	}
}
