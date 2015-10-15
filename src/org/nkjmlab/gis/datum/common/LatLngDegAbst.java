package org.nkjmlab.gis.datum.common;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.nkjmlab.gis.datum.util.Deg2Dms;
import org.nkjmlab.gis.datum.util.Dms2Deg;

/**
 *
 * @author Yuu NAKAJIMA
 *
 */
public abstract class LatLngDegAbst {

	/**
	 * @param latDeg
	 *            十進法(degree: ddd.dddd)表記
	 * @param lngDeg
	 *            十進法(degree: ddd.dddd)表記
	 */

	public final double latDeg;
	public final double lngDeg;

	public LatLngDegAbst(double latDeg, double lngDeg) {
		this.latDeg = latDeg;
		this.lngDeg = lngDeg;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof LatLngDegAbst)) {
			return false;
		}
		LatLngDegAbst l = (LatLngDegAbst) obj;
		return this.latDeg == l.latDeg && this.lngDeg == l.lngDeg;
	}

	@Override
	public int hashCode() {
		return (int) (latDeg + lngDeg);
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.SHORT_PREFIX_STYLE);
	}

	public double getLatDms() {
		return Deg2Dms.toDms(latDeg);
	}

	public double getLngDms() {
		return Deg2Dms.toDms(lngDeg);
	}

	public double getLatDeg() {
		return latDeg;
	}

	public double getLngDeg() {
		return Dms2Deg.toDeg(lngDeg);
	}

	public double getLng() {
		return getLngDeg();
	}

	public double getLat() {
		return getLatDeg();
	}

}
