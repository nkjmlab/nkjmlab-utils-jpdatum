package org.nkjmlab.gis.datum.jprect;

import java.security.InvalidParameterException;

import org.nkjmlab.gis.datum.LatLon;

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

	public static LatLonWithZone getOrigin(int zoneId) {
		double lat;
		double lon;
		switch (zoneId) {
		case 1:
			lat = 33.00000;
			lon = 129.0000;
			break;
		case 2:
			lat = 33.00000;
			lon = 131.00000;
			break;
		case 3:
			lat = 36.00000;
			lon = 132.166666666666667;
			break;
		case 4:
			lat = 33.00000;
			lon = 133.50000;
			break;
		case 5:
			lat = 36.00000;
			lon = 134.333333333333333;
			break;
		case 6:
			lat = 36.00000;
			lon = 136.00000;
			break;
		case 7:
			lat = 36.00000;
			lon = 137.166666666666667;
			break;
		case 8:
			lat = 36.00000;
			lon = 138.833333333333333;
			break;
		case 9:
			lat = 36.00000;
			lon = 139.833333333333333;
			break;
		case 10:
			lat = 40.00000;
			lon = 140.833333333333333;
			break;
		case 11:
			lat = 44.00000;
			lon = 140.15000;
			break;
		case 12:
			lat = 44.00000;
			lon = 142.25000;
			break;
		case 13:
			lat = 44.00000;
			lon = 144.25000;
			break;
		case 14:
			lat = 26.00000;
			lon = 142.00000;
			break;
		case 15:
			lat = 26.00000;
			lon = 127.50000;
			break;
		case 16:
			lat = 26.00000;
			lon = 124.00000;
			break;
		case 17:
			lat = 26.00000;
			lon = 131.00000;
			break;
		case 18:
			lat = 20.00000;
			lon = 136.00000;
			break;
		case 19:
			lat = 26.00000;
			lon = 154.00000;
			break;
		default:
			String s = "zoneId=" + zoneId
					+ " is invalid. The zone id range from 1 to 19.";
			System.err.println(s);
			throw new InvalidParameterException(s);

		}
		return new LatLonWithZone(LatLon.create(lat, lon), zoneId);
	}
}
