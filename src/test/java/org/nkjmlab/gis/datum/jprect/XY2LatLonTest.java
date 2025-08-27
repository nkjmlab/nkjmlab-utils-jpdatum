package org.nkjmlab.gis.datum.jprect;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.nkjmlab.gis.datum.LatLon.Detum;
import org.nkjmlab.gis.datum.jprect.util.XYUtils;

/**
 * 日本平面直角座標系 (Japan Plane Rectangular) に基づくXY座標 から 旧日本測地系 (Tokyo
 * Datum：2002年3月末までの日本の公式測地系．Bessel楕円体) に基づく緯度経度 に変換するテスト．
 *
 * @author Yuu NAKAJIMA
 */
public class XY2LatLonTest {
  private static final org.apache.logging.log4j.Logger log =
      org.apache.logging.log4j.LogManager.getLogger();

  /** 各ゾーンの原点で確認． http://vldb.gsi.go.jp/sokuchi/surveycalc/surveycalc/xy2blf.html */
  @Test
  public void test() {

    for (ZoneId zoneId : ZoneId.values()) {

      LatLonWithZone origin = JapanPlaneRectangular.getOrigin(zoneId, Detum.TOKYO);

      BasisWithZone basis = origin.getBasis();
      double x = 0;
      double y = 0;

      LatLonWithZone latLon = XYUtils.toLatLonWithZone(new XYWithZone(x, y, basis));

      log.debug("Origin: " + origin);
      log.debug("Calculated: " + latLon);
      assertEquals(origin.getLat(basis), latLon.getLat(basis), 0.01);
      assertEquals(origin.getLon(basis), latLon.getLon(basis), 0.01);
    }
  }
}
