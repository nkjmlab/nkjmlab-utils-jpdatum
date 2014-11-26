package org.nkjmlab.gis.jpr.latlngxy.numerical;

/**
 * このクラスはジャスミンソフトがApache License 2.0に基づいて公開しているscalcに由来します．
 *
 * scalcは，琉球大学工学部情報工学科 宮城研究室の成果物 を，ジャスミンソフトが整理・統合したものです． 再利用を快諾
 * して頂いた宮城隼夫教授以下，宮城研究室のスタッフにこの場を借りて感謝致します．
 *
 *
 * @author Miho Nagata
 * @author Yoshinori Nie
 */

class AngleUtil {

	/**
	 * DMS表記(ddd.mmsss)を経緯度（単位はラジアン）に変換
	 *
	 * @return ラジアン値
	 */
	public static double toRadian(double ddd_mmsss) {
		return AngleUtil.toAngle(ddd_mmsss) * Math.PI / 180.0;
	}

	/**
	 * DMS表記(ddd.mmsss)を経緯度（単位は度）に変換
	 *
	 * @return 度
	 */
	public static double toAngle(double ddd_mmsss) {
		int ddd = (int) ddd_mmsss;
		int mm = (int) (((ddd_mmsss * 10000) - (ddd * 10000.0)) / 100.0);
		double ss_s = ((ddd_mmsss * 10000) - (ddd * 10000.0) - (mm * 100.0));

		return (ddd + mm / 60.0 + ss_s / 3600.0);
	}

}
