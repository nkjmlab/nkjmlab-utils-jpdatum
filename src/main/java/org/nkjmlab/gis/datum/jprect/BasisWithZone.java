package org.nkjmlab.gis.datum.jprect;

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

	public BasisWithZone(Basis basis, ZoneId zoneId) {
		this(basis.getUnit(), basis.getDetum(), zoneId);
	}

	public BasisWithZone(Unit unit, Detum detum, ZoneId zoneId) {
		super(unit, detum);
		this.zoneId = zoneId;
	}

	public ZoneId getZoneId() {
		return zoneId;
	}

	@Override
	public int hashCode() {
		return unit.hashCode() + detum.hashCode() + zoneId.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof BasisWithZone)) {
			return false;
		}
		BasisWithZone xy = (BasisWithZone) obj;
		return super.equals(xy) && zoneId == xy.getZoneId();
	}

}
