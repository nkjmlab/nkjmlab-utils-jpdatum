package org.nkjmlab.gis.datum.jprect;

import java.security.InvalidParameterException;

import org.nkjmlab.gis.datum.common.XY;

/***
 *
 * @author Yuu NAKAJIMA
 *
 */
public class XYJpr extends XY {

	public final int zoneId;

	public XYJpr(double x, double y, int zoneId) {
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
		if (!(obj instanceof XYJpr)) {
			return false;
		}
		XYJpr xy = (XYJpr) obj;
		return x == xy.x && y == xy.y && zoneId == xy.zoneId;
	}

	public int getZoneId() {
		return zoneId;
	}

}
