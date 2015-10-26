package org.nkjmlab.gis.datum.jprect.util;

import org.nkjmlab.gis.datum.Basis;
import org.nkjmlab.gis.datum.BasisConverter;
import org.nkjmlab.gis.datum.LatLon.Detum;
import org.nkjmlab.gis.datum.LatLon.Unit;
import org.nkjmlab.gis.datum.DegreeUnitConverter;
import org.nkjmlab.gis.datum.jprect.JapanPlaneRectangular;
import org.nkjmlab.gis.datum.jprect.JapanPlaneRectangular.ZoneId;
import org.nkjmlab.gis.datum.jprect.LatLonWithZone;
import org.nkjmlab.gis.datum.jprect.XYWithZone;
import org.nkjmlab.gis.datum.jprect.helper.XY2LatLonHelper;

/**
 *
 * @author Yuu NAKAJIMA
 */
public class XY2LatLon {

	protected static Basis basis = new Basis(Unit.DEGREE, Detum.TOKYO);

	/**
	 *
	 * @param xy
	 *            平面直角座標系の系番号付きの平面直角座標系XY
	 * @return 平面直角座標系の系番号付きの緯度経度
	 */
	public static LatLonWithZone toLatLon(XYWithZone xy) {
		double x = xy.getX();
		double y = xy.getY();
		ZoneId zoneId = xy.getZoneId();
		double latDeg = XY2LatLon.toLat(x, y, zoneId, basis);
		double lonDeg = XY2LatLon.toLon(x, y, zoneId, basis);
		return new LatLonWithZone(latDeg, lonDeg, basis.getUnit(),
				basis.getDetum(), zoneId);
	}

	private static double toLat(double x, double y, ZoneId zoneId,
			Basis toBasis) {
		return toLat(x, y, zoneId, toBasis.getUnit(), toBasis.getDetum());
	}

	private static double toLon(double x, double y, ZoneId zoneId,
			Basis toBasis) {
		return toLon(x, y, zoneId, toBasis.getUnit(), toBasis.getDetum());
	}

	/**
	 * @param x
	 * @param y
	 * @param zoneId
	 *            平面直角座標系（平成十四年国土交通省告示第九号）｜国土地理院
	 *            http://www.gsi.go.jp/LAW/heimencho.html
	 *            にzoneId(系番号)と適用区域が書かれている．
	 * @param basis2
	 * @return 日本測地系の緯度の十進法(degree: ddd.dddd)表記
	 */
	public static double toLat(double x, double y, ZoneId zoneId, Unit toUnit,
			Detum toDetum) {
		LatLonWithZone origin = JapanPlaneRectangular.getOrigin(zoneId);
		double lat = XY2LatLonHelper.toLatitude(x, y, origin.getLat(basis),
				origin.getLon(basis));
		if (toDetum == Detum.WGS84) {
			double lon = XY2LatLonHelper.toLongitude(x, y, origin.getLat(basis),
					origin.getLon(basis));
			return BasisConverter.changeBasisOfLon(lat, lon, basis,
					new Basis(toUnit, toDetum));
		} else {
			return DegreeUnitConverter.change(lat, Unit.DEGREE, toUnit);
		}
	}

	/**
	 * @param x
	 * @param y
	 * @param zoneId
	 *            平面直角座標系（平成十四年国土交通省告示第九号）｜国土地理院
	 *            http://www.gsi.go.jp/LAW/heimencho.html
	 *            にzoneId(系番号)と適用区域が書かれている．
	 * @param miliDegree
	 * @param tokyo
	 * @return 日本測地系の経度度の十進法(degree: ddd.dddd)表記
	 */
	public static double toLon(double x, double y, ZoneId zoneId, Unit toUnit,
			Detum toDetum) {
		LatLonWithZone origin = JapanPlaneRectangular.getOrigin(zoneId);
		double lon = XY2LatLonHelper.toLongitude(x, y, origin.getLat(basis),
				origin.getLon(basis));
		if (toDetum == Detum.WGS84) {
			double lat = XY2LatLonHelper.toLatitude(x, y, origin.getLat(basis),
					origin.getLon(basis));
			return BasisConverter.changeBasisOfLon(lat, lon, basis,
					new Basis(toUnit, toDetum));
		} else {
			return DegreeUnitConverter.change(lon, Unit.DEGREE, toUnit);
		}
	}

}
