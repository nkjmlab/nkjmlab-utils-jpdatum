package org.nkjmlab.gis.datum.jprect;

import java.awt.Point;

import org.nkjmlab.gis.datum.LatLon.Detum;
import org.nkjmlab.gis.datum.LatLon.Unit;
import org.nkjmlab.gis.datum.jprect.JapanPlaneRectangular.ZoneId;
import org.nkjmlab.gis.datum.jprect.util.XY2LatLon;

/***
 * Japan Plane Rectangular 平面直角座標系（平成十四年国土交通省告示第九号）の系番号付きのXY座標．原則として，単位はメートル．
 * 平面座標系における，XY座標を表すクラス．上方向がX軸正方向，右方向がY軸正方向である．
 *
 * @author Yuu NAKAJIMA
 *
 */

public class XYWithZone extends XY {

	protected final BasisWithZone basis;

	public XYWithZone(double x, double y, BasisWithZone basis) {
		super(x, y);
		this.basis = basis;
	}

	public XYWithZone(XY xy, BasisWithZone basis) {
		this(xy.getX(), xy.getY(), basis);
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

	public Point toRelativeScreenCoord(XYWithZone origin, Scale scale) {
		XY relativeCoord = this.toRelativeCoord(origin);
		return toPoint(relativeCoord, scale);
	}

	private Point toPoint(XY relativeCoord, Scale scale) {
		int x = scale.toPixcel(getY());
		int y = scale.toPixcel(getX()) * -1;
		Point p = new Point(x, y);
		return p;
	}

	private XY toRelativeCoord(XYWithZone origin) {
		return new XY(x - origin.getX(), y - origin.getY());
	}

}
