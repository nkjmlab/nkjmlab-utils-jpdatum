package org.nkjmlab.gis.datum.jprect.util;

import org.nkjmlab.gis.datum.DistanceUnit;
import org.nkjmlab.gis.datum.DistanceUnitConverter;
import org.nkjmlab.gis.datum.LatLon.Detum;
import org.nkjmlab.gis.datum.LatLon.Unit;
import org.nkjmlab.gis.datum.jprect.JapanPlaneRectangular;
import org.nkjmlab.gis.datum.jprect.LatLonWithZone;
import org.nkjmlab.gis.datum.jprect.XYWithZone;
import org.nkjmlab.gis.datum.jprect.helper.LatLon2XYHelper;

/**
 * @author Yuu NAKAJIMA
 *
 */
public class LatLon2XY {

	/**
	 * 平面直角座標系の系番号付きの緯度経度を，平面直角座標系のXYに変換
	 *
	 * @param latLon
	 *            平面直角座標系の系番号付きの緯度経度(TD座標系，十進法度表記)
	 * @return 平面直角座標系の系番号付きの平面直角座標系XY
	 */
	public static XYWithZone toXYWithZone(LatLonWithZone latLon) {
		return new XYWithZone(toX(latLon, DistanceUnit.M), toY(latLon, DistanceUnit.M), latLon.getBasis());
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
	public static double toX(LatLonWithZone latLon, DistanceUnit distanceUnit) {
		LatLonWithZone origin = JapanPlaneRectangular.getOrigin(latLon.getZoneId(), latLon.getDetum());
		return DistanceUnitConverter.change(LatLon2XYHelper.toXCoord(latLon.getLat(Unit.DEGREE, Detum.TOKYO),
				latLon.getLon(Unit.DEGREE, Detum.TOKYO), origin.getLat(Unit.DEGREE, Detum.TOKYO),
				origin.getLon(Unit.DEGREE, Detum.TOKYO)), DistanceUnit.M, distanceUnit);
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
	public static double toY(LatLonWithZone latLon, DistanceUnit distanceUnit) {
		LatLonWithZone origin = JapanPlaneRectangular.getOrigin(latLon.getZoneId(), latLon.getDetum());
		return DistanceUnitConverter.change(LatLon2XYHelper.toYCoord(latLon.getLat(Unit.DEGREE, Detum.TOKYO),
				latLon.getLon(Unit.DEGREE, Detum.TOKYO), origin.getLat(Unit.DEGREE, Detum.TOKYO),
				origin.getLon(Unit.DEGREE, Detum.TOKYO)), DistanceUnit.M, distanceUnit);
	}

}
