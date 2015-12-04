package org.nkjmlab.gis.datum;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.nkjmlab.gis.datum.jprect.XYWithZone;

/**
 * 平面座標系における，XY座標を表すクラス．右方向がX軸正方向，上方向がY軸正方向とする．
 */

public class XYPair {
	protected final double x;
	protected final double y;

	public XYPair(double x, double y) {
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
		return (int) (x + y);
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof XYWithZone)) {
			return false;
		}
		XYWithZone xy = (XYWithZone) obj;
		return x == xy.x && y == xy.y;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
