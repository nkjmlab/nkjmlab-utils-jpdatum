package org.nkjmlab.gis.datum;

import java.util.Objects;
import org.nkjmlab.gis.datum.jprect.util.TileUtils;

public class Tile {

  private final int x;
  private final int y;
  private final int zoom;

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
    return Objects.hash(x, y, zoom);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (!(obj instanceof Tile))
      return false;
    Tile other = (Tile) obj;
    return x == other.x && y == other.y && zoom == other.zoom;
  }

  @Override
  public String toString() {
    return "Tile [x=" + x + ", y=" + y + ", zoom=" + zoom + "]";
  }

  public Tile getNextX() {
    return new Tile(x + 1, y, zoom);
  }

  public Tile getNextY() {
    return new Tile(x, y + 1, zoom);
  }
}
