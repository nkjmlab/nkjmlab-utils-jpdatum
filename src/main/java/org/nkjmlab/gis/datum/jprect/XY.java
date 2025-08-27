package org.nkjmlab.gis.datum.jprect;

import java.util.Objects;
import org.nkjmlab.gis.datum.DistanceUnit;

public class XY {
  private final double x;
  private final double y;

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

  public DistanceUnit getDistanceUnit() {
    return distanceUnit;
  }

  @Override
  public int hashCode() {
    return Objects.hash(distanceUnit, x, y);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (!(obj instanceof XY)) return false;
    XY other = (XY) obj;
    return distanceUnit == other.distanceUnit
        && Double.doubleToLongBits(x) == Double.doubleToLongBits(other.x)
        && Double.doubleToLongBits(y) == Double.doubleToLongBits(other.y);
  }

  @Override
  public String toString() {
    return "XY [x=" + x + ", y=" + y + ", distanceUnit=" + distanceUnit + "]";
  }
}
