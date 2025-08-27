package org.nkjmlab.gis.datum.jprect;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.nkjmlab.gis.datum.Basis;
import org.nkjmlab.gis.datum.LatLon.Detum;
import org.nkjmlab.gis.datum.LatLon.Unit;

/**
 * WGSとTDの間の変換の誤差が大きいので，XY平面に変換する場合は，インスタンスを作る際にTD座標系の値を入れた方が良い．
 *
 * @author nkjm
 */
public class BasisWithZone extends Basis {

  private final ZoneId zoneId;

  protected BasisWithZone(Basis basis, ZoneId zoneId) {
    this(basis.getUnit(), basis.getDetum(), zoneId);
  }

  protected BasisWithZone(Unit unit, Detum detum, ZoneId zoneId) {
    super(unit, detum);
    this.zoneId = zoneId;
  }

  public ZoneId getZoneId() {
    return zoneId;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + Objects.hash(zoneId);
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (!super.equals(obj)) return false;
    if (!(obj instanceof BasisWithZone)) return false;
    BasisWithZone other = (BasisWithZone) obj;
    return zoneId == other.zoneId;
  }

  @Override
  public String toString() {
    return "BasisWithZone [zoneId=" + zoneId + ", Basis=" + super.toString() + "]";
  }

  private static final Map<ZoneId, Map<Basis, BasisWithZone>> map = new HashMap<>();

  public static BasisWithZone of(Basis basis, ZoneId zoneId) {
    return of(basis.getUnit(), basis.getDetum(), zoneId);
  }

  public static BasisWithZone of(Unit unit, Detum detum, ZoneId zoneId) {
    Map<Basis, BasisWithZone> m = map.get(zoneId);
    if (m == null) {
      m = new HashMap<>();
      map.put(zoneId, m);
    }
    Basis b = of(unit, detum);
    BasisWithZone bz = m.get(b);
    if (bz != null) {
      return bz;
    }

    bz = new BasisWithZone(b, zoneId);
    m.put(of(unit, detum), bz);
    return bz;
  }
}
