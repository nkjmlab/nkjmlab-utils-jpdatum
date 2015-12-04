package org.nkjmlab.gis.datum.jprect;

import java.security.InvalidParameterException;

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

	public enum ZoneId {
		_1, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14, _15, _16, _17, _18, _19,
	}

	public static LatLonWithZone getOrigin(ZoneId zoneId) {
		double lat;
		double lon;
		switch (zoneId) {
		case _1:
			lat = 33.00000;
			lon = 129.5000;
			break;
		case _2:
			lat = 33.00000;
			lon = 131.00000;
			break;
		case _3:
			lat = 36.00000;
			lon = 132.166666666666669;
			break;
		case _4:
			lat = 33.00000;
			lon = 133.50000;
			break;
		case _5:
			lat = 36.00000;
			lon = 134.333333333333334;
			break;
		case _6:
			lat = 36.00000;
			lon = 136.00000;
			break;
		case _7:
			lat = 36.00000;
			lon = 137.166666666666666;
			break;
		case _8:
			lat = 36.00000;
			lon = 138.5;
			break;
		case _9:
			lat = 36.00000;
			lon = 139.833333333333334;
			break;
		case _10:
			lat = 40.00000;
			lon = 140.833333333333333;
			break;
		case _11:
			lat = 44.00000;
			lon = 140.25000;
			break;
		case _12:
			lat = 44.00000;
			lon = 142.25000;
			break;
		case _13:
			lat = 44.00000;
			lon = 144.25000;
			break;
		case _14:
			lat = 26.00000;
			lon = 142.00000;
			break;
		case _15:
			lat = 26.00000;
			lon = 127.50000;
			break;
		case _16:
			lat = 26.00000;
			lon = 124.00000;
			break;
		case _17:
			lat = 26.00000;
			lon = 131.00000;
			break;
		case _18:
			lat = 20.00000;
			lon = 136.00000;
			break;
		case _19:
			lat = 26.00000;
			lon = 154.00000;
			break;
		default:
			String s = "zoneId=" + zoneId
					+ " is invalid. The zone id range from 1 to 19.";
			System.err.println(s);
			throw new InvalidParameterException(s);

		}
		return new LatLonWithZone(lat, lon, Unit.DEGREE, Detum.WGS84, zoneId);
	}
}
