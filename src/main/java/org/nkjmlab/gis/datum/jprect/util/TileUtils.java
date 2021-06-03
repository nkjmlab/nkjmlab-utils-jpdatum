package org.nkjmlab.gis.datum.jprect.util;

import org.nkjmlab.gis.datum.Basis;
import org.nkjmlab.gis.datum.LatLon;
import org.nkjmlab.gis.datum.LatLon.Detum;
import org.nkjmlab.gis.datum.LatLon.Unit;
import org.nkjmlab.gis.datum.LatLonBox;
import org.nkjmlab.gis.datum.Tile;

/**
 * http://wiki.openstreetmap.org/wiki/Slippy_map_tilenames
 * 
 * @author nkjm
 *
 */
public final class TileUtils {

  public static double toLon(int x, int z) {
    return x / Math.pow(2.0, z) * 360.0 - 180;
  }

  public static double toLat(int y, int z) {
    double n = Math.PI - (2.0 * Math.PI * y) / Math.pow(2.0, z);
    return Math.toDegrees(Math.atan(Math.sinh(n)));
  }

  public static LatLonBox toLatLonBox(Tile tile, final int zoom) {
    return toLatLonBox(tile, Basis.of(Unit.DEGREE, Detum.WGS84));
  }

  public static LatLonBox toLatLonBox(Tile tile, Basis basis) {
    int x = tile.getX();
    int y = tile.getY();
    int zoom = tile.getZoom();
    double northLat = toLat(y, zoom);
    double southLat = toLat(y + 1, zoom);
    double westLon = toLon(x, zoom);
    double eastLon = toLon(x + 1, zoom);
    LatLon northWest = new LatLon(northLat, westLon, Basis.of(Unit.DEGREE, Detum.WGS84));
    LatLon southEast = new LatLon(southLat, eastLon, Basis.of(Unit.DEGREE, Detum.WGS84));
    LatLonBox bb = new LatLonBox(northWest.copyInto(basis), southEast.copyInto(basis));
    return bb;
  }

}
