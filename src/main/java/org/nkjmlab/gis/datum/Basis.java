package org.nkjmlab.gis.datum;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.nkjmlab.gis.datum.LatLon.Detum;
import org.nkjmlab.gis.datum.LatLon.Unit;

public class Basis {

  public static final Basis DEGREE_WGS;
  private final Unit unit;
  private final Detum detum;
  private static Map<Detum, Map<Unit, Basis>> map = new HashMap<>();

  static {
    map.put(Detum.TOKYO, new HashMap<>());
    map.put(Detum.WGS84, new HashMap<>());
    DEGREE_WGS = of(Unit.DEGREE, Detum.WGS84);
  }

  protected Basis(Unit unit, Detum detum) {
    this.unit = unit;
    this.detum = detum;
  }

  public Unit getUnit() {
    return unit;
  }

  public Detum getDetum() {
    return detum;
  }

  @Override
  public int hashCode() {
    return HashCodeBuilder.reflectionHashCode(this);
  }

  @Override
  public boolean equals(Object obj) {
    return EqualsBuilder.reflectionEquals(this, obj);
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
  }

  public static Basis of(Unit unit, Detum detum) {
    Basis b = map.get(detum).get(unit);
    if (b != null) {
      return b;
    }
    b = new Basis(unit, detum);
    map.get(detum).put(unit, b);
    return b;
  }

}
