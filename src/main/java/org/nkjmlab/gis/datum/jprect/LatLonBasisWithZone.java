package org.nkjmlab.gis.datum.jprect;

import org.nkjmlab.gis.datum.LatLon.Detum;
import org.nkjmlab.gis.datum.LatLon.Unit;
import org.nkjmlab.gis.datum.LatLonBasis;

/**
 * WGSとTDの間の変換の誤差が大きいので，XY平面に変換する場合は，インスタンスを作る際にTD座標系の値を入れた方が良い．
 *
 * @author nkjm
 *
 */
public class LatLonBasisWithZone extends LatLonBasis {

	protected final int zoneId;

	public LatLonBasisWithZone(Unit unit, Detum detum, int zoneId) {
		super(unit, detum);
		this.zoneId = zoneId;
	}

	public int getZoneId() {
		return zoneId;
	}

}
