package org.nkjmlab.gis.datum.jprect.util;

import org.nkjmlab.gis.datum.Basis;
import org.nkjmlab.gis.datum.DistanceUnit;
import org.nkjmlab.gis.datum.DistanceUnitConverter;
import org.nkjmlab.gis.datum.LatLon;
import org.nkjmlab.gis.datum.LatLon.Detum;
import org.nkjmlab.gis.datum.LatLon.Unit;
import org.nkjmlab.gis.datum.Tile;
import org.nkjmlab.gis.datum.jprect.JapanPlaneRectangular;
import org.nkjmlab.gis.datum.jprect.JapanPlaneRectangular.ZoneId;
import org.nkjmlab.gis.datum.jprect.LatLonWithZone;
import org.nkjmlab.gis.datum.jprect.XYWithZone;
import org.nkjmlab.gis.datum.jprect.helper.LatLon2XYHelper;

public class LatLonUtils {

	/**
	 * http://wiki.openstreetmap.org/wiki/Slippy_map_tilenames
	 *
	 */
	public static Tile toTile(LatLon latLon, int zoom) {
		int xtile = (int) Math.floor(
				(latLon.getLon(Basis.of(Unit.DEGREE, Detum.WGS84)) + 180) / 360 * (1 << zoom));
		int ytile = (int) Math.floor(
				(1 - Math.log(Math.tan(Math.toRadians(latLon.getLat(Unit.DEGREE, Detum.WGS84)))
						+ 1 / Math.cos(Math.toRadians(latLon.getLat(Unit.DEGREE, Detum.WGS84))))
						/ Math.PI) / 2 * (1 << zoom));
		if (xtile < 0) {
			xtile = 0;
		}
		if (xtile >= (1 << zoom)) {
			xtile = ((1 << zoom) - 1);
		}
		if (ytile < 0) {
			ytile = 0;
		}
		if (ytile >= (1 << zoom)) {
			ytile = ((1 << zoom) - 1);
		}
		return new Tile(xtile, ytile, zoom);
	}

	/**
	 * 平面直角座標系の系番号付きの緯度経度を，平面直角座標系のXYに変換
	 *
	 * @param latLon
	 *            平面直角座標系の系番号付きの緯度経度(TD座標系，十進法度表記)
	 * @return 平面直角座標系の系番号付きの平面直角座標系XY
	 */
	public static XYWithZone toXYWithZone(LatLonWithZone latLon) {
		return new XYWithZone(LatLonUtils.toX(latLon, DistanceUnit.M), LatLonUtils.toY(latLon, DistanceUnit.M), latLon.getBasis());
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

	public static double toDistance(LatLon from, LatLon to, DistanceUnit distanceUnit) {
		LatLon f = from.copyInto(Basis.DEGREE_WGS);
		LatLon t = to.copyInto(Basis.DEGREE_WGS);
		LatLon midPoint = new LatLon((f.getLat() + t.getLat()) / 2,
				(f.getLon() + t.getLon()) / 2, Basis.DEGREE_WGS);
		ZoneId zoneId = JapanPlaneRectangular.getNearestOriginZoneId(midPoint);
		return new LatLonWithZone(f, zoneId).distance(new LatLonWithZone(t, zoneId), distanceUnit);
	}

}
