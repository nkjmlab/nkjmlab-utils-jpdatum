package org.nkjmlab.gis.datum.jprect.util;

import org.nkjmlab.gis.datum.Basis;
import org.nkjmlab.gis.datum.LatLon;
import org.nkjmlab.gis.datum.LatLon.Detum;
import org.nkjmlab.gis.datum.LatLon.Unit;
import org.nkjmlab.gis.datum.Tile;

/**
 * http://wiki.openstreetmap.org/wiki/Slippy_map_tilenames
 * @author nkjm
 *
 */
public final class LatLon2Tile {

	public static Tile toTile(LatLon latLon, int zoom) {
		int xtile = (int) Math.floor(
				(latLon.getLon(Basis.of(Unit.DEGREE, Detum.WGS84)) + 180) / 360 * (1 << zoom));
		int ytile = (int) Math.floor(
				(1 - Math.log(Math.tan(Math.toRadians(latLon.getLat(Unit.DEGREE, Detum.WGS84)))
						+ 1 / Math.cos(Math.toRadians(latLon.getLat(Unit.DEGREE, Detum.WGS84))))
						/ Math.PI) / 2 * (1 << zoom));
		if (xtile < 0) {
			xtile = 0;
		}
		if (xtile >= (1 << zoom)) {
			xtile = ((1 << zoom) - 1);
		}
		if (ytile < 0) {
			ytile = 0;
		}
		if (ytile >= (1 << zoom)) {
			ytile = ((1 << zoom) - 1);
		}
		return new Tile(xtile, ytile, zoom);
	}

}
