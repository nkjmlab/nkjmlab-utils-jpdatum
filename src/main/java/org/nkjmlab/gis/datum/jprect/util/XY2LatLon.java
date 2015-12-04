package org.nkjmlab.gis.datum.jprect.util;

import org.nkjmlab.gis.datum.jprect.LatLonWithZone;
import org.nkjmlab.gis.datum.jprect.XYWithZone;
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
	public static LatLonWithZone toLatLonWithZone(XYWithZone xy) {
		return XY2LatLonHelper.toLatLonWithZone(xy);
	}

	public static double toLat(XYWithZone xy) {
		return XY2LatLonHelper.toLat(xy);
	}

	public static double toLon(XYWithZone xy) {
		return XY2LatLonHelper.toLon(xy);
	}

}
