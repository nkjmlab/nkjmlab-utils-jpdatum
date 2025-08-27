package org.nkjmlab.gis.datum.jprect;

import java.awt.Point;
import java.util.Objects;
import org.nkjmlab.gis.datum.LatLon.Detum;
import org.nkjmlab.gis.datum.LatLon.Unit;
import org.nkjmlab.gis.datum.jprect.util.XYUtils;

/***
 * Japan Plane Rectangular 平面直角座標系（平成十四年国土交通省告示第九号）の系番号付きのXY座標．原則として，単位はメートル．
 * 平面座標系における，XY座標を表すクラス．上方向がX軸正方向，右方向がY軸正方向である．
 *
 * @author Yuu NAKAJIMA
 *
 */

public class XYWithZone extends XY {

  private final BasisWithZone basis;

  public XYWithZone(double x, double y, BasisWithZone basis) {
    super(x, y);
    this.basis = basis;
  }

  public XYWithZone(XY xy, BasisWithZone basis) {
    this(xy.getX(), xy.getY(), basis);
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + Objects.hash(basis);
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (!super.equals(obj)) return false;
    if (!(obj instanceof XYWithZone)) return false;
    XYWithZone other = (XYWithZone) obj;
    return Objects.equals(basis, other.basis);
  }

  @Override
  public String toString() {
    return "XYWithZone [basis=" + basis + ", XY=" + super.toString() + "]";
  }

  public BasisWithZone getBasis() {
    return basis;
  }

  public LatLonWithZone toLatLonWithZone() {
    return XYUtils.toLatLonWithZone(this);
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

  public Point toRelativeScreenCoord(XYWithZone origin, ScreenSizeBasis screenSizeBasis) {
    return toPoint(toRelativeCoord(origin), screenSizeBasis);
  }

  private static Point toPoint(XY relativeCoord, ScreenSizeBasis screenSizeBasis) {
    int x = (int) screenSizeBasis.toPixel(relativeCoord.getY());
    int y = (int) screenSizeBasis.toPixel(relativeCoord.getX()) * -1;
    Point p = new Point(x, y);
    return p;
  }

  private XY toRelativeCoord(XYWithZone origin) {
    return new XY(getX() - origin.getX(), getY() - origin.getY());
  }
}
