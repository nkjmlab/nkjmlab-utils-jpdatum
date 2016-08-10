package org.nkjmlab.gis.datum.jprect.helper;

/**
 * このクラスはジャスミンソフトがApache License 2.0に基づいて公開しているscalcに由来します．
 *
 * scalcは，琉球大学工学部情報工学科 宮城研究室の成果物 を，ジャスミンソフトが整理・統合したものです． 再利用を快諾
 * して頂いた宮城隼夫教授以下，宮城研究室のスタッフにこの場を借りて感謝致します．
 *
 * @author Miho Nagata
 * @author Yoshinori Nie
 * @author Yuu NAKAJIMA
 */
public class XY2LatLonHelper {

	private static final double rho = 180.0 / Math.PI;

	public static double toLatitude(double x, double y, double latDegOfOrigin, double lonDegOfOrigin) {

		double phi = calcPhi(latDegOfOrigin, x);

		double b = phi;

		double eta = Const.e1 * Math.cos(b);
		double t = Math.tan(b);

		double q = 1.0 - Math.pow(Const.e * Math.sin(b), 2);
		double prc = Const.ra / Math.sqrt(q);
		double mrc = Const.ra * (1 - Math.pow(Const.e, 2)) / Math.sqrt(Math.pow(q, 3));
		double ym = y / Const.m0;

		double B1 = phi * rho - (Math.pow(ym, 2) * t / (2.0 * mrc * prc)) * rho
				+ (Math.pow(ym, 4) * t * (5.0 + 3.0 * Math.pow(t, 2) + Math.pow(eta, 2)
						- 9.0 * Math.pow(eta, 2) * Math.pow(t, 2) - 4.0 * Math.pow(eta, 4))
						/ (24.0 * mrc * Math.pow(prc, 3))) * rho;

		double B2 = (Math.pow(ym, 6) * t
				* (61.0 + 90.0 * Math.pow(t, 2) + 45.0 * Math.pow(t, 4) + 46.0 * Math.pow(eta, 2)
						- 252.0 * Math.pow(t, 2) * Math.pow(eta, 2) - 90.0 * Math.pow(t, 4) * Math.pow(eta, 2))
				/ (720.0 * mrc * Math.pow(prc, 5))) * rho;

		return (B1 - B2);
	}

	/**
	 * Y座標を経度に変換するメソッド
	 *
	 * @param gentenL2
	 *
	 * @return 経度
	 */
	public static double toLongitude(double x, double y, double latDegOfOrigin, double lonDegOfOrigin) {
		double gentenL = lonDegOfOrigin;
		double phi = calcPhi(latDegOfOrigin, x);

		double b = phi;

		double eta = Const.e1 * Math.cos(b);
		double t = Math.tan(b);

		double q = 1.0 - Math.pow(Const.e * Math.sin(b), 2);
		double prc = Const.ra / Math.sqrt(q);
		double ym = y / Const.m0;

		double L1 = ym / (prc * Math.cos(phi)) * rho - (Math.pow(ym, 3)
				* (1.0 + 2.0 * Math.pow(t, 2) + Math.pow(eta, 2)) / (6.0 * Math.pow(prc, 3) * Math.cos(phi))) * rho;

		double L2 = (Math.pow(ym, 5) * (5.0 + 28.0 * Math.pow(t, 2) + 24.0 * Math.pow(t, 4) + 6.0 * Math.pow(eta, 2)
				+ 8.0 * Math.pow(t, 2) * Math.pow(eta, 2)) / (120.0 * Math.pow(prc, 5) * Math.cos(phi))) * rho;

		return (gentenL + L1 + L2);
	}

	/**
	 * phiを返すメソッド
	 */
	private static double calcPhi(double latDeg, double x) {

		double gentenB = AngleUtil.toRadian(latDeg);
		double arc_l = ArcLength.calcArcLength(gentenB);

		double sxm = arc_l + x / Const.m0;

		double phi[] = new double[5];

		for (int i = 0; i < 5; i++) {
			if (i == 0) {
				phi[i] = gentenB;
			} else if (i > 0) {
				phi[i] = phi[i - 1] - (ArcLength.calcArcLength(phi[i - 1]) - sxm) / calcM(phi[i - 1]);
			}
		}
		return phi[4];
	}

	/**
	 * phi[i]による子午線曲率半径を求めるメソッド
	 */
	private static double calcM(double p) {
		double q = 1.0 - Math.pow(Const.e * Math.sin(p), 2);
		double M = Const.ra * (1 - Math.pow(Const.e, 2)) / Math.sqrt(Math.pow(q, 3));
		return M;
	}

}
