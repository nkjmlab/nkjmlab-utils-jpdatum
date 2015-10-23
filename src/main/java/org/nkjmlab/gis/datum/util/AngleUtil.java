package org.nkjmlab.gis.datum.util;

public class AngleUtil {

	/**
	 * 十進法度表記(ddd.dddd)を経緯度（単位はラジアン）に変換
	 *
	 * @return ラジアン値
	 */
	public static double toRadian(double ddd_dddd) {
		return ddd_dddd * Math.PI / 180.0;
	}

}
