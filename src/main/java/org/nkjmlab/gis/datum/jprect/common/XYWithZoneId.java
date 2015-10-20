package org.nkjmlab.gis.datum.jprect.common;

import java.security.InvalidParameterException;

/***
 *
 * @author Yuu NAKAJIMA
 *
 */
public class XYWithZoneId extends XY {

	public final int zoneId;

	public XYWithZoneId(double x, double y, int zoneId) {
		super(x, y);
		this.zoneId = zoneId;

		if (zoneId <= 0 || 20 <= zoneId) {
			String s = "zoneId=" + zoneId
					+ " is invalid. The zone id range from 1 to 19.";
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
		if (!(obj instanceof XYWithZoneId)) {
			return false;
		}
		XYWithZoneId xy = (XYWithZoneId) obj;
		return x == xy.x && y == xy.y && zoneId == xy.zoneId;
	}

	@Override
	public String toString() {
		return super.toString() + "[x=" + x + ",y=" + y + ",zoneId=" + zoneId
				+ "]";
	}

}
