package org.nkjmlab.gis.datum.jprect;

import org.nkjmlab.gis.datum.LatLon.Detum;
import org.nkjmlab.gis.datum.LatLon.Unit;

/**
 *
 * Japan Plane Rectangular 平面直角座標系（平成十四年国土交通省告示第九号）
 * http://www.gsi.go.jp/LAW/heimencho.html にzoneId(系番号)と適用区域が書かれている．
 *
 * 測量法（昭和二十四年法律第百八十八号。以下「法」という。)第十一条第一項第一号の規定を実施するため、
 * 直角座標で位置を表示する場合の平面直角座標系を次のように定める。
 *
 * @author Yuu NAKAJIMA
 *
 */
public class JapanPlaneRectangular {

	public static enum ZoneId {
		_1(0), _2(1), _3(2), _4(3), _5(4), _6(5), _7(6), _8(7), _9(8), _10(9), _11(
				10), _12(11), _13(12), _14(13), _15(14), _16(15), _17(16), _18(17), _19(18);

		private int index;

		private ZoneId(int index) {
			this.index = index;
		}
	}

	private static final double[] lats = { 33.00000, 33.00000, 36.00000, 33.00000, 36.00000,
			36.00000, 36.00000, 36.00000, 36.00000, 40.00000, 44.00000, 44.00000, 44.00000,
			26.00000, 26.00000, 26.00000, 26.00000, 20.00000, 26.00000 };

	private static final double[] lons = { 129.5000, 131.00000, 132.166666666666669, 133.50000,
			134.333333333333334, 136.00000, 137.166666666666666, 138.5, 139.833333333333334,
			140.833333333333333, 140.25000, 142.25000, 144.25000, 142.00000, 127.50000, 124.00000,
			131.00000, 136.00000, 154.00000 };

	public static final LatLonWithZone getOrigin(ZoneId zoneId, Detum detum) {
		return new LatLonWithZone(lats[zoneId.index], lons[zoneId.index], Unit.DEGREE, detum,
				zoneId);
	}
}
