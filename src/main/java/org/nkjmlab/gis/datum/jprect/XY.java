package org.nkjmlab.gis.datum.jprect;

import org.nkjmlab.gis.datum.XYPair;

public class XY extends XYPair {

	private DistanceUnit distanceUnit;

	public XY(double x, double y, DistanceUnit unit) {
		super(x, y);
		this.distanceUnit = unit;
	}

	public enum DistanceUnit {
		M, KM
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof XY)) {
			return false;
		}
		XY xy = (XY) obj;
		return super.equals(xy) && distanceUnit == xy.distanceUnit;
	}

	public DistanceUnit getDistanceUnit() {
		return distanceUnit;
	}

}
