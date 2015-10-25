package org.nkjmlab.gis.datum.jprect;

import org.nkjmlab.gis.datum.LatLon.Detum;
import org.nkjmlab.gis.datum.LatLon.Unit;
import org.nkjmlab.gis.datum.jprect.helper.XY2LatLonHelper;

/**
 *
 * @author Yuu NAKAJIMA
 */
public class XY2LatLon {

	/**
	 *
	 * @param xy
	 *            平面直角座標系の系番号付きの平面直角座標系XY
	 * @return 平面直角座標系の系番号付きの緯度経度
	 */
	public static LatLonWithZone toLatLon(XYWithZone xy) {
		double x = xy.getX();
		double y = xy.getY();
		int zoneId = xy.zoneId;
		double latDeg = XY2LatLon.toLat(x, y, zoneId);
		double lonDeg = XY2LatLon.toLon(x, y, zoneId);
		return new LatLonWithZone(latDeg, lonDeg, Unit.DEGREE, Detum.TOKYO, zoneId);
	}

	/**
	 * @param x
	 * @param y
	 * @param zoneId
	 *            平面直角座標系（平成十四年国土交通省告示第九号）｜国土地理院
	 *            http://www.gsi.go.jp/LAW/heimencho.html
	 *            にzoneId(系番号)と適用区域が書かれている．
	 * @return 日本測地系の緯度の十進法(degree: ddd.dddd)表記
	 */
	public static double toLat(double x, double y, int zoneId) {
		LatLonWithZone origin = JapanPlaneRectangular.getOrigin(zoneId);
		return XY2LatLonHelper.toLatitude(x, y, origin.getLatDegTD(), origin.getLonDegTD());
	}

	/**
	 * @param x
	 * @param y
	 * @param zoneId
	 *            平面直角座標系（平成十四年国土交通省告示第九号）｜国土地理院
	 *            http://www.gsi.go.jp/LAW/heimencho.html
	 *            にzoneId(系番号)と適用区域が書かれている．
	 * @return 日本測地系の経度度の十進法(degree: ddd.dddd)表記
	 */
	public static double toLon(double x, double y, int zoneId) {
		LatLonWithZone origin = JapanPlaneRectangular.getOrigin(zoneId);
		return XY2LatLonHelper.toLongitude(x, y, origin.getLatDegTD(), origin.getLonDegTD());
	}

}
