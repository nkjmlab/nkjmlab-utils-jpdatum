package org.nkjmlab.gis.datum;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.nkjmlab.gis.datum.jprect.util.TileUtils;

public class Tile {

	private int x;
	private int y;
	private int zoom;

	public Tile(int x, int y, int zoom) {
		this.x = x;
		this.y = y;
		this.zoom = zoom;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getZoom() {
		return zoom;
	}

	public LatLonBox toLatLonBox(Basis basis) {
		return TileUtils.toLatLonBox(this, basis);
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

	public Tile getNextX() {
		return new Tile(x + 1, y, zoom);
	}

	public Tile getNextY() {
		return new Tile(x, y + 1, zoom);
	}
}
