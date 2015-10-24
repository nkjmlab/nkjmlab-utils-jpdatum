package org.nkjmlab.gis.datum.jprect;

import org.nkjmlab.gis.datum.LatLon.Detum;
import org.nkjmlab.gis.datum.LatLon.Unit;
import org.nkjmlab.gis.datum.LatLonBasis;

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
