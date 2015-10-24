package org.nkjmlab.gis.datum;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.nkjmlab.gis.datum.LatLon.Detum;
import org.nkjmlab.gis.datum.LatLon.Unit;

public class LatLonBasis {

	protected final Unit unit;
	protected final Detum detum;

	public LatLonBasis(Unit unit, Detum detum) {
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
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

}
