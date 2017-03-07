package org.nkjmlab.gis.datum.jprect.util;

import org.nkjmlab.gis.datum.jprect.JapanPlaneRectangular;
import org.nkjmlab.gis.datum.jprect.LatLonWithZone;
import org.nkjmlab.gis.datum.jprect.XYWithZone;
import org.nkjmlab.gis.datum.jprect.helper.XY2LatLonHelper;

/**
 *
 * @author Yuu NAKAJIMA
 */
public class XYUtils {

	/**
	 *
	 * @param xy
	 *            平面直角座標系の系番号付きの平面直角座標系XY
	 * @return 平面直角座標系の系番号付きの緯度経度
	 */
	public static LatLonWithZone toLatLonWithZone(XYWithZone xy) {
		return new LatLonWithZone(toLat(xy), toLon(xy), xy.getBasis());
	}

	public static double toLat(XYWithZone xy) {
		LatLonWithZone origin = JapanPlaneRectangular.getOrigin(xy.getBasis().getZoneId(), xy.getDetum());
		return XY2LatLonHelper.toLatitude(xy.getX(), xy.getY(), origin.getLat(), origin.getLon());
	}

	public static double toLon(XYWithZone xy) {
		LatLonWithZone origin = JapanPlaneRectangular.getOrigin(xy.getBasis().getZoneId(), xy.getDetum());
		return XY2LatLonHelper.toLongitude(xy.getX(), xy.getY(), origin.getLat(), origin.getLon());
	}

}
