package org.nkjmlab.gis.datum.jprect;

import org.nkjmlab.gis.datum.LatLon.Detum;
import org.nkjmlab.gis.datum.LatLon.Unit;
import org.nkjmlab.gis.datum.XYPair;
import org.nkjmlab.gis.datum.jprect.JapanPlaneRectangular.ZoneId;
import org.nkjmlab.gis.datum.jprect.util.XY2LatLon;

/***
 * Japan Plane Rectangular 平面直角座標系（平成十四年国土交通省告示第九号）の系番号付きのXY座標．原則として，単位はメートル．
 *
 * @author Yuu NAKAJIMA
 *
 */
public class XYWithZone extends XY {

	protected final BasisWithZone basis;

	public XYWithZone(double x, double y, DistanceUnit unit,
			BasisWithZone basis) {
		super(x, y, unit);
		this.basis = basis;
	}

	public XYWithZone(XYPair xy, DistanceUnit unit, BasisWithZone basis) {
		this(xy.getX(), xy.getY(), unit, basis);
	}

	public XYWithZone(XY xy, BasisWithZone basis) {
		this(xy.getX(), xy.getY(), xy.getDistanceUnit(), basis);
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof XYWithZone)) {
			return false;
		}
		XYWithZone xy = (XYWithZone) obj;
		return super.equals(xy) && basis.equals(xy.getBasis());
	}

	public BasisWithZone getBasis() {
		return basis;
	}

	public LatLonWithZone toLatLonWithZone() {
		return XY2LatLon.toLatLonWithZone(this);
	}

	public ZoneId getZoneId() {
		return basis.getZoneId();
	}

	public Unit getUnit() {
		return basis.getUnit();
	}

	public Detum getDetum() {
		return basis.getDetum();
	}

}
