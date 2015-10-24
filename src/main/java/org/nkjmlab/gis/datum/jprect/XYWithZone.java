package org.nkjmlab.gis.datum.jprect;

import java.security.InvalidParameterException;

import org.nkjmlab.gis.datum.XY;

/***
 * Japan Plane Rectangular 平面直角座標系（平成十四年国土交通省告示第九号）の系番号付きのXY
 *
 * @author Yuu NAKAJIMA
 *
 */
public class XYWithZone extends XY {

	protected final int zoneId;

	public XYWithZone(double x, double y, int zoneId) {
		super(x, y);
		this.zoneId = zoneId;

		if (zoneId <= 0 || 20 <= zoneId) {
			String s = "zoneId=" + zoneId + " is invalid. The zone id range from 1 to 19.";
			System.err.println(s);
			throw new InvalidParameterException(s);
		}
	}

	@Override
	public int hashCode() {
		return (int) (x + y + zoneId);
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof XYWithZone)) {
			return false;
		}
		XYWithZone xy = (XYWithZone) obj;
		return x == xy.x && y == xy.y && zoneId == xy.zoneId;
	}

	public int getZoneId() {
		return zoneId;
	}

}
