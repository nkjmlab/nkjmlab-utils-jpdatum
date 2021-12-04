package org.nkjmlab.gis.datum.jprect;

/**
 * pixcel/meter
 *
 * @author nkjm
 *
 */
public class ScreenSizeBasis {

  private final double pixel;
  private final double meter;

  public ScreenSizeBasis(double pixel, double meter) {
    this.pixel = pixel;
    this.meter = meter;
  }

  /**
   *
   * @param meter
   * @return
   */
  public double toPixel(double meter) {
    return (pixel * meter / this.meter);
  }

  @Override
  public String toString() {
    return "ScreenSizeBasis [pixel=" + pixel + ", meter=" + meter + "]";
  }


}
