package org.nkjmlab.gis.datum.jprect;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.nkjmlab.gis.datum.Basis;
import org.nkjmlab.gis.datum.LatLon.Detum;
import org.nkjmlab.gis.datum.LatLon.Unit;
import org.nkjmlab.gis.datum.jprect.JapanPlaneRectangular.ZoneId;

/**
 * WGSとTDの間の変換の誤差が大きいので，XY平面に変換する場合は，インスタンスを作る際にTD座標系の値を入れた方が良い．
 *
 * @author nkjm
 *
 */
public class BasisWithZone extends Basis {

	protected final ZoneId zoneId;

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
		return HashCodeBuilder.reflectionHashCode(this);
	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

	private static Map<ZoneId, BasisWithZone> map = new HashMap<>();

	public static BasisWithZone create(Basis basis, ZoneId zoneId) {
		return create(basis.getUnit(), basis.getDetum(), zoneId);
	}

	public static BasisWithZone create(Unit unit, Detum detum, ZoneId zoneId) {
		BasisWithZone b = map.get(zoneId);
		if (b != null) {
			return b;
		}
		b = new BasisWithZone(create(unit, detum), zoneId);
		map.put(zoneId, b);
		return b;
	}

}
