package org.nkjmlab.gis.datum.jprect.numerical;

/**
 *
 * このクラスはジャスミンソフトがApache License 2.0に基づいて公開しているscalcに由来します．
 *
 * scalcは，琉球大学工学部情報工学科 宮城研究室の成果物 を，ジャスミンソフトが整理・統合したものです． 再利用を快諾
 * して頂いた宮城隼夫教授以下，宮城研究室のスタッフにこの場を借りて感謝致します．
 *
 * @author Miho Nagata
 * @author Yoshinori Nie
 */

class Const {

	/**
	 * ベッセル楕円体の長半径 (semi-major axis)
	 */
	static double ra = 6377397.155;

	/**
	 * ベッセル楕円体の短半径 (semi-minor axis)
	 */
	private static double rb = 6356078.9363;

	/**
	 * 離心率を求める為の変数
	 */
	private static double dr = Math.sqrt((Math.pow(ra, 2) - Math.pow(rb, 2)));

	/**
	 * 第一離心率 (eccentricity)
	 */
	static double e = dr / ra;

	/**
	 * 第二離心率
	 */
	static double e1 = dr / rb;

	/**
	 * 縮率 (rate)（19座標系）
	 */
	static double m0 = 0.9999;
}
