package org.nkjmlab.gis.datum.jprect.helper;

import org.nkjmlab.gis.datum.util.AngleUtil;

/**
 * このクラスはジャスミンソフトがApache License 2.0に基づいて公開しているscalcに由来します．
 *
 * scalcは，琉球大学工学部情報工学科 宮城研究室の成果物 を，ジャスミンソフトが整理・統合したものです． 再利用を快諾
 * して頂いた宮城隼夫教授以下，宮城研究室のスタッフにこの場を借りて感謝致します．
 *
 * @author Miho Nagata
 * @author Yoshinori Nie
 * @author Yuu NAKAJIMA
 *
 */
public class LatLon2XYHelper {

	/**
	 * 縮率に基づき算出された X,Y 座標値が有効かどうかを判断.
	 */
	@SuppressWarnings("unused")
	private static boolean isValid(double lat, double lon, double x) {
		double m = calcM(AngleUtil.toRadian(lat), AngleUtil.toRadian(lon), x);
		if (0.9999 <= m && m < 1.0001) {
			return true;
		}
		return false;
	}

	public static double toXCoord(double latDeg, double lonDeg, double oLatDeg,
			double oLonDeg) {

		double b = AngleUtil.toRadian(latDeg);
		double l = AngleUtil.toRadian(lonDeg);

		double gentenB = AngleUtil.toRadian(oLatDeg);
		double gentenL = AngleUtil.toRadian(oLonDeg);

		double lam = l - gentenL;
		double eta = Const.e1 * Math.cos(b);
		double t = Math.tan(b);

		double q = 1.0 - Math.pow(Const.e * Math.sin(b), 2);
		double prc = Const.ra / Math.sqrt(q);
		double arc_gap = ArcLength.calcArcLength(b)
				- ArcLength.calcArcLength(gentenB);

		double x1 = Math.pow(lam, 2) * prc * Math.sin(b) * Math.cos(b) / 2.0;

		double x2 = Math.pow(lam, 4) * prc * Math.sin(b)
				* Math.pow(Math.cos(b), 3) / 24.0 * (5.0 - Math.pow(t, 2)
						+ 9.0 * Math.pow(eta, 2) + 4.0 * Math.pow(eta, 4));

		double x3 = Math.pow(lam, 6) * prc * Math.sin(b)
				* Math.pow(Math.cos(b), 5) / 720.0
				* (61.0 - 58.0 * Math.pow(t, 2) + Math.pow(t, 4)
						+ 270.0 * Math.pow(eta, 2)
						- 330.0 * Math.pow(t, 2) * Math.pow(eta, 2));

		return Const.m0 * (arc_gap + x1 + x2 + x3);
	}

	public static double toYCoord(double latDeg, double lonDeg, double oLatDeg,
			double oLonDeg) {

		double b = AngleUtil.toRadian(latDeg);
		double l = AngleUtil.toRadian(lonDeg);

		double gentenL = AngleUtil.toRadian(oLonDeg);

		double lam = l - gentenL;
		double eta = Const.e1 * Math.cos(b);
		double t = Math.tan(b);

		double q = 1.0 - Math.pow(Const.e * Math.sin(b), 2);
		double prc = Const.ra / Math.sqrt(q);

		double y1 = lam * prc * Math.cos(b)
				+ Math.pow(lam, 3) * Math.pow(Math.cos(b), 3) * prc / 6.0
						* (1.0 - Math.pow(t, 2) + Math.pow(eta, 2));

		double y2 = Math.pow(lam, 5) * Math.pow(Math.cos(b), 5) * prc / 120.0
				* (5.0 - 18.0 * Math.pow(t, 2) + Math.pow(t, 4)
						+ 14.0 * Math.pow(eta, 2)
						- 58.0 * Math.pow(t, 2) * Math.pow(eta, 2));

		return Const.m0 * (y1 + y2);
	}

	/**
	 * 求点における縮率を返すメソッド
	 */
	private static double calcM(double b, double l, double y) {

		double q = 1.0 - Math.pow(Const.e * Math.sin(b), 2);
		double prc = Const.ra / Math.sqrt(q);
		double mrc = Const.ra * (1 - Math.pow(Const.e, 2))
				/ Math.sqrt(Math.pow(q, 3));

		double olive = Math.pow(y, 2) / (2 * mrc * prc * Math.pow(Const.m0, 2));
		double mac = Math.pow(y, 4) / (24 * Math.pow(mrc, 2) * Math.pow(prc, 2)
				* Math.pow(Const.m0, 4));

		return Const.m0 * (1.0 + olive + mac);
	}

}
