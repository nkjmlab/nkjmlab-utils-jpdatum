package org.nkjmlab.gis.datum.jprect.util;

import org.nkjmlab.gis.datum.LatLon.Detum;
import org.nkjmlab.gis.datum.LatLon.Unit;
import org.nkjmlab.gis.datum.Basis;
import org.nkjmlab.gis.datum.jprect.JapanPlaneRectangular;
import org.nkjmlab.gis.datum.jprect.LatLonWithZone;
import org.nkjmlab.gis.datum.jprect.XYWithZone;
import org.nkjmlab.gis.datum.jprect.helper.LatLon2XYHelper;
import org.nkjmlab.gis.datum.jprect.JapanPlaneRectangular.ZoneId;

/**
 * @author Yuu NAKAJIMA
 *
 */
public class LatLon2XY {

	protected static Basis basis = new Basis(Unit.DEGREE,
			Detum.TOKYO);

	/**
	 * 平面直角座標系の系番号付きの緯度経度(TD座標系，十進法度表記)を，平面直角座標系のXYに変換
	 *
	 * @param latLon
	 *            平面直角座標系の系番号付きの緯度経度(TD座標系，十進法度表記)
	 * @return 平面直角座標系の系番号付きの平面直角座標系XY
	 */
	public static XYWithZone toXY(LatLonWithZone latLon) {
		double latDegTD = latLon.getLat(basis);
		double lonDegTD = latLon.getLon(basis);
		ZoneId zoneId = latLon.getZoneId();
		double x = LatLon2XY.toX(latDegTD, lonDegTD, zoneId);
		double y = LatLon2XY.toY(latDegTD, lonDegTD, zoneId);
		return new XYWithZone(x, y, zoneId);
	}

	/**
	 *
	 * @param latDegTD
	 * @param lonDegTD
	 * @param zoneId
	 *            平面直角座標系（平成十四年国土交通省告示第九号）｜国土地理院
	 *            http://www.gsi.go.jp/LAW/heimencho.html
	 *            にzoneId(系番号)と適用区域が書かれている．
	 * @return
	 */
	public static double toX(double latDegTD, double lonDegTD, ZoneId zoneId) {
		LatLonWithZone origin = JapanPlaneRectangular.getOrigin(zoneId);
		return LatLon2XYHelper.toXCoord(latDegTD, lonDegTD,
				origin.getLat(basis), origin.getLon(basis));
	}

	/**
	 *
	 * @param latDegTD
	 * @param lonDegTD
	 * @param zoneId
	 *            平面直角座標系（平成十四年国土交通省告示第九号）｜国土地理院
	 *            http://www.gsi.go.jp/LAW/heimencho.html
	 *            にzoneId(系番号)と適用区域が書かれている．
	 * @return
	 */
	public static double toY(double latDegTD, double lonDegTD, ZoneId zoneId) {
		LatLonWithZone origin = JapanPlaneRectangular.getOrigin(zoneId);
		return LatLon2XYHelper.toYCoord(latDegTD, lonDegTD,
				origin.getLat(basis), origin.getLon(basis));
	}

}
