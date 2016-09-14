package org.nkjmlab.gis.datum.util;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.nkjmlab.gis.datum.Basis;
import org.nkjmlab.gis.datum.LatLon;
import org.nkjmlab.gis.datum.LatLon.Detum;
import org.nkjmlab.gis.datum.LatLon.Unit;
import org.nkjmlab.gis.datum.Tile;
import org.nkjmlab.gis.datum.jprect.util.LatLon2Tile;

public class TileUtilsTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		testToTile(35.6235, 139.7804, 16, 58214, 25819);
	}

	private void testToTile(double lat, double lon, int zoom, int x, int y) {
		Tile tile = LatLon2Tile.toTile(new LatLon(lat, lon, Basis.of(Unit.DEGREE, Detum.WGS84)),
				zoom);

		System.out.println(tile);
		assertEquals(x, tile.getX());
		assertEquals(y, tile.getY());

	}

}
