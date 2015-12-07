package org.nkjmlab.gis.datum.jprect;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.nkjmlab.gis.datum.DistanceUnit;


public class XY {
	protected final double x;
	protected final double y;

	private final DistanceUnit distanceUnit = DistanceUnit.M;

	public XY(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	@Override
	public int hashCode() {
		return (int) (x + y + distanceUnit.hashCode());
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof XY)) {
			return false;
		}
		XY xy = (XY) obj;
		return x == xy.x && y == xy.y && distanceUnit == xy.distanceUnit;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.SHORT_PREFIX_STYLE);
	}

	public DistanceUnit getDistanceUnit() {
		return distanceUnit;
	}

}
