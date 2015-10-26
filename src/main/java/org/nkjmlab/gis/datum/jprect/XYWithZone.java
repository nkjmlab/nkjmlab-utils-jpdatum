package org.nkjmlab.gis.datum.jprect;

import org.nkjmlab.gis.datum.XY;
import org.nkjmlab.gis.datum.jprect.JapanPlaneRectangular.ZoneId;

/***
 * Japan Plane Rectangular 平面直角座標系（平成十四年国土交通省告示第九号）の系番号付きのXY
 *
 * @author Yuu NAKAJIMA
 *
 */
public class XYWithZone extends XY {

	protected final ZoneId zoneId;

	public XYWithZone(double x, double y, ZoneId zoneId) {
		super(x, y);
		this.zoneId = zoneId;
	}

	@Override
	public int hashCode() {
		return (int) (x + y + zoneId.ordinal());
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof XYWithZone)) {
			return false;
		}
		XYWithZone xy = (XYWithZone) obj;
		return x == xy.x && y == xy.y && zoneId == xy.zoneId;
	}

	public ZoneId getZoneId() {
		return zoneId;
	}

}
