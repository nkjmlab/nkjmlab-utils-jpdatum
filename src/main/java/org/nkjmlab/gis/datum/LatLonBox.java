package org.nkjmlab.gis.datum;

public class LatLonBox {

	private LatLon northWest;
	private LatLon southEast;

	public LatLonBox(LatLon northWest, LatLon southEast) {
		this.northWest = northWest;
		this.southEast = southEast;
	}

	public LatLon getNorthWest() {
		return northWest;
	}

	public LatLon getSouthEast() {
		return southEast;
	}

	public double getNorthEdge(Basis basis) {
		return northWest.getLat(basis);
	}

	public double getSouthEdge(Basis basis) {
		return southEast.getLat(basis);
	}

	public double getWestEdge(Basis basis) {
		return northWest.getLon(basis);
	}

	public double getEastEdge(Basis basis) {
		return southEast.getLon(basis);
	}

}
