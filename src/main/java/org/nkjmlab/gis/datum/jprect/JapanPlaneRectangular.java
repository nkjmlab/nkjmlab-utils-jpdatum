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
		_1(0), _2(1), _3(2), _4(3), _5(4), _6(5), _7(6), _8(7), _9(8), _10(9), _11(10), _12(11), _13(12), _14(13), _15(
				14), _16(15), _17(16), _18(17), _19(18);

		private int index;

		private ZoneId(int index) {
			this.index = index;
		}
	}

	private static final double[] lats = { 33.00000, 33.00000, 36.00000, 33.00000, 36.00000, 36.00000, 36.00000,
			36.00000, 36.00000, 40.00000, 44.00000, 44.00000, 44.00000, 26.00000, 26.00000, 26.00000, 26.00000,
			20.00000, 26.00000 };

	private static final double[] lons = { 129.5000, 131.00000, 132.166666666666669, 133.50000, 134.333333333333334,
			136.00000, 137.166666666666666, 138.5, 139.833333333333334, 140.833333333333333, 140.25000, 142.25000,
			144.25000, 142.00000, 127.50000, 124.00000, 131.00000, 136.00000, 154.00000 };

	private static final LatLonWithZone[] tokyos = {
			new LatLonWithZone(lats[0], lons[0], Unit.DEGREE, Detum.TOKYO, ZoneId._1),
			new LatLonWithZone(lats[1], lons[1], Unit.DEGREE, Detum.TOKYO, ZoneId._2),
			new LatLonWithZone(lats[2], lons[2], Unit.DEGREE, Detum.TOKYO, ZoneId._3),
			new LatLonWithZone(lats[3], lons[3], Unit.DEGREE, Detum.TOKYO, ZoneId._4),
			new LatLonWithZone(lats[4], lons[4], Unit.DEGREE, Detum.TOKYO, ZoneId._5),
			new LatLonWithZone(lats[5], lons[5], Unit.DEGREE, Detum.TOKYO, ZoneId._6),
			new LatLonWithZone(lats[6], lons[6], Unit.DEGREE, Detum.TOKYO, ZoneId._7),
			new LatLonWithZone(lats[7], lons[7], Unit.DEGREE, Detum.TOKYO, ZoneId._8),
			new LatLonWithZone(lats[8], lons[8], Unit.DEGREE, Detum.TOKYO, ZoneId._9),
			new LatLonWithZone(lats[9], lons[9], Unit.DEGREE, Detum.TOKYO, ZoneId._10),
			new LatLonWithZone(lats[10], lons[10], Unit.DEGREE, Detum.TOKYO, ZoneId._11),
			new LatLonWithZone(lats[11], lons[11], Unit.DEGREE, Detum.TOKYO, ZoneId._12),
			new LatLonWithZone(lats[12], lons[12], Unit.DEGREE, Detum.TOKYO, ZoneId._13),
			new LatLonWithZone(lats[13], lons[13], Unit.DEGREE, Detum.TOKYO, ZoneId._14),
			new LatLonWithZone(lats[14], lons[14], Unit.DEGREE, Detum.TOKYO, ZoneId._15),
			new LatLonWithZone(lats[15], lons[15], Unit.DEGREE, Detum.TOKYO, ZoneId._16),
			new LatLonWithZone(lats[16], lons[16], Unit.DEGREE, Detum.TOKYO, ZoneId._17),
			new LatLonWithZone(lats[17], lons[17], Unit.DEGREE, Detum.TOKYO, ZoneId._18),
			new LatLonWithZone(lats[18], lons[18], Unit.DEGREE, Detum.TOKYO, ZoneId._19) };

	private static final LatLonWithZone[] wgs84s = {
			new LatLonWithZone(lats[0], lons[0], Unit.DEGREE, Detum.WGS84, ZoneId._1),
			new LatLonWithZone(lats[1], lons[1], Unit.DEGREE, Detum.WGS84, ZoneId._2),
			new LatLonWithZone(lats[2], lons[2], Unit.DEGREE, Detum.WGS84, ZoneId._3),
			new LatLonWithZone(lats[3], lons[3], Unit.DEGREE, Detum.WGS84, ZoneId._4),
			new LatLonWithZone(lats[4], lons[4], Unit.DEGREE, Detum.WGS84, ZoneId._5),
			new LatLonWithZone(lats[5], lons[5], Unit.DEGREE, Detum.WGS84, ZoneId._6),
			new LatLonWithZone(lats[6], lons[6], Unit.DEGREE, Detum.WGS84, ZoneId._7),
			new LatLonWithZone(lats[7], lons[7], Unit.DEGREE, Detum.WGS84, ZoneId._8),
			new LatLonWithZone(lats[8], lons[8], Unit.DEGREE, Detum.WGS84, ZoneId._9),
			new LatLonWithZone(lats[9], lons[9], Unit.DEGREE, Detum.WGS84, ZoneId._10),
			new LatLonWithZone(lats[10], lons[10], Unit.DEGREE, Detum.WGS84, ZoneId._11),
			new LatLonWithZone(lats[11], lons[11], Unit.DEGREE, Detum.WGS84, ZoneId._12),
			new LatLonWithZone(lats[12], lons[12], Unit.DEGREE, Detum.WGS84, ZoneId._13),
			new LatLonWithZone(lats[13], lons[13], Unit.DEGREE, Detum.WGS84, ZoneId._14),
			new LatLonWithZone(lats[14], lons[14], Unit.DEGREE, Detum.WGS84, ZoneId._15),
			new LatLonWithZone(lats[15], lons[15], Unit.DEGREE, Detum.WGS84, ZoneId._16),
			new LatLonWithZone(lats[16], lons[16], Unit.DEGREE, Detum.WGS84, ZoneId._17),
			new LatLonWithZone(lats[17], lons[17], Unit.DEGREE, Detum.WGS84, ZoneId._18),
			new LatLonWithZone(lats[18], lons[18], Unit.DEGREE, Detum.WGS84, ZoneId._19) };

	public static final LatLonWithZone getOrigin(ZoneId zoneId, Detum detum) {
		switch (detum) {
		case TOKYO:
			return tokyos[zoneId.index];
		case WGS84:
			return wgs84s[zoneId.index];
		default:
			throw new IllegalArgumentException();
		}
	}
}
