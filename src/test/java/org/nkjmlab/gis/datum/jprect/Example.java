package org.nkjmlab.gis.datum.jprect;

import org.nkjmlab.gis.datum.LatLon.Detum;
import org.nkjmlab.gis.datum.LatLon.Unit;

public class Example {
  private static final org.apache.logging.log4j.Logger log =
      org.apache.logging.log4j.LogManager.getLogger();

  public static void main(String[] args) {
    new Example().example();
  }

  public void example() {

    long start = System.currentTimeMillis();

    double lat = 36.103774791666666;
    double lon = 140.08785504166664;

    for (double i = 0; i < 1; i += 0.0000001) {
      LatLonWithZone tokyoLatLon = new LatLonWithZone(lat + i, lon + i,
          BasisWithZone.of(Unit.DEGREE, Detum.TOKYO, ZoneId._9));
      XYWithZone tokyoXy = tokyoLatLon.toXYWithZone();
    }

    log.debug("{} times convertion latlon to xy in {} msec", 1 / 0.0000001,
        System.currentTimeMillis() - start);

    LatLonWithZone tokyoLatLon = new LatLonWithZone(36.103774791666666, 140.08785504166664,
        BasisWithZone.of(Unit.DEGREE, Detum.TOKYO, ZoneId._9));

    LatLonWithZone wgsLatLon = new LatLonWithZone(36.103774791666666, 140.08785504166664,
        BasisWithZone.of(Unit.DEGREE, Detum.WGS84, ZoneId._9));

    XYWithZone tokyoXy = tokyoLatLon.toXYWithZone();
    log.debug(tokyoXy);
    // =>
    // XYWithZone[basis=BasisWithZone[zoneId=_9,unit=DEGREE,detum=TOKYO],x=11542.461079999104,y=22913.50559491415,distanceUnit=M]

    LatLonWithZone rTokyoLatLon = tokyoXy.toLatLonWithZone();
    log.debug(rTokyoLatLon);
    // =>
    // LatLonWithZone[zoneId=_9,unit=DEGREE,detum=TOKYO,lat=36.1037814806522,lon=140.08311062649173]
  }
}
