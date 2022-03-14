package org.nkjmlab.gis.datum;

import org.nkjmlab.gis.datum.LatLon.Detum;
import org.nkjmlab.gis.datum.LatLon.Unit;

public class DatumConverter {
  /**
   * 単位は変えず，測地系のみを変える．
   *
   * @param lat
   * @param lon
   * @param fromUnit
   * @param fromDetum
   * @param toDetum
   * @return
   */
  public static double changeDetumOfLat(double lat, double lon, Unit fromUnit, Detum fromDetum,
      Detum toDetum) {
    double latDeg = LatLonUnitConverter.change(lat, fromUnit, Unit.DEGREE);
    double lonDeg = LatLonUnitConverter.change(lon, fromUnit, Unit.DEGREE);

    switch (toDetum) {
      case TOKYO:
        return LatLonUnitConverter.change(changeDetumOfLatFromWgsToTd(latDeg, lonDeg), Unit.DEGREE,
            fromUnit);
      case WGS84:
        return LatLonUnitConverter.change(changeDetumOfLatFromTdToWgs(latDeg, lonDeg), Unit.DEGREE,
            fromUnit);
      default:
        throw new IllegalArgumentException(toDetum + " is not suported.");
    }
  }

  /**
   * 単位は変えず，測地系のみを変える．
   *
   * @param lat
   * @param lon
   * @param fromUnit
   * @param fromDetum
   * @param toDetum
   * @return
   */
  public static double changeDetumOfLon(double lat, double lon, Unit fromUnit, Detum fromDetum,
      Detum toDetum) {
    double latDeg = LatLonUnitConverter.change(lat, fromUnit, Unit.DEGREE);
    double lonDeg = LatLonUnitConverter.change(lon, fromUnit, Unit.DEGREE);

    switch (toDetum) {
      case TOKYO:
        return LatLonUnitConverter.change(changeDetumOfLonFromWgsToTd(latDeg, lonDeg), Unit.DEGREE,
            fromUnit);
      case WGS84:
        return LatLonUnitConverter.change(changeDetumOfLonFromTdToWgs(latDeg, lonDeg), Unit.DEGREE,
            fromUnit);
      default:
        throw new IllegalArgumentException(toDetum + " is not suported.");
    }
  }

  /***
   * 簡易的な世界測地系 → 旧日本測地系変換(TD: Tokyo Datum) をする．
   *
   * 参考ページ1：<a href=
   * "https://web.archive.org/web/20140710182621/http://homepage3.nifty.com/Nowral/02_DATUM/02_DATUM.html">
   * 02 DATUM</a>, 参考ページ2 <a href="http://www.museum.tokushima-ec.ed.jp/ogawa/map/datumconv/">
   * 測地系変換にともなうずれ</a>
   */
  public static double changeDetumOfLatFromWgsToTd(double latDegWgs, double lonDegWgs) {
    return latDegWgs + latDegWgs * 0.00010696 - lonDegWgs * 0.000017467 - 0.0046020;
  }

  public static double changeDetumOfLonFromWgsToTd(double latDegWgs, double lonDegWgs) {
    return lonDegWgs + latDegWgs * 0.000046047 + lonDegWgs * 0.000083049 - 0.010041;
  }

  public static double changeDetumOfLatFromTdToWgs(double latDegTD, double lonDegTD) {
    return latDegTD - 0.00010695 * latDegTD + 0.000017464 * lonDegTD + 0.0046017;
  }

  public static double changeDetumOfLonFromTdToWgs(double latDegTD, double lonDegTD) {
    return lonDegTD - 0.000046038 * lonDegTD - 0.000083043 * lonDegTD + 0.010040;
  }

}
