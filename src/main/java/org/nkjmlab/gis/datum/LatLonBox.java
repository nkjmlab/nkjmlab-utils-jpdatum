package org.nkjmlab.gis.datum;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.nkjmlab.gis.datum.jprect.LatLonWithZone;
import org.nkjmlab.gis.datum.jprect.ZoneId;

public class LatLonBox {

	public static final double PIXEL = 256;

	private LatLon northWest;
	private LatLon southEast;

	private LatLon southWest;
	private LatLon northEast;

	public LatLonBox(LatLon northWest, LatLon southEast) {
		this.northWest = northWest;
		this.southEast = southEast;
		this.southWest = new LatLon(southEast.getLat(), northWest.getLon(), northWest.basis);
		this.northEast = new LatLon(northWest.getLat(), southEast.getLon(), northWest.basis);
	}

	public LatLon getNorthWest() {
		return northWest;
	}

	public LatLon getSouthEast() {
		return southEast;
	}

	public LatLon getSouthWest() {
		return southWest;
	}

	public LatLon getNorthEast() {
		return northEast;
	}

	public double getNorthEdgeLat(Basis basis) {
		return northWest.getLat(basis);
	}

	public double getSouthEdgeLat(Basis basis) {
		return southEast.getLat(basis);
	}

	public double getWestEdgeLon(Basis basis) {
		return northWest.getLon(basis);
	}

	public double getEastEdgeLon(Basis basis) {
		return southEast.getLon(basis);
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

	public double getLatDistance(Basis basis) {
		return Math.abs(getNorthEdgeLat(basis) - getSouthEdgeLat(basis));
	}

	public double getLatDistanceByPixel(Basis basis) {
		return getLatDistance(basis) / PIXEL;
	}

	public double getLonDistance(Basis basis) {
		return Math.abs(getEastEdgeLon(basis) - getWestEdgeLon(basis));
	}

	public double getLonDistanceByPixel(Basis basis) {
		return getLonDistance(basis) / PIXEL;
	}

	public double getXDistance(ZoneId zoneId, DistanceUnit distanceUnit) {
		return new LatLonWithZone(getNorthWest(), zoneId).distance(
				new LatLonWithZone(getSouthWest(), zoneId),
				distanceUnit);
	}

	public double getYDistance(ZoneId zoneId, DistanceUnit distanceUnit) {
		return new LatLonWithZone(getNorthWest(), zoneId).distance(
				new LatLonWithZone(getNorthEast(), zoneId),
				distanceUnit);

	}

}
