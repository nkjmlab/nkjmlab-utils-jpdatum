package org.nkjmlab.gis.datum.jprect;

import static org.junit.Assert.*;
import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;
import org.nkjmlab.gis.datum.LatLon.Detum;
import org.nkjmlab.gis.datum.LatLon.Unit;

/**
 * 旧日本測地系(Tokyo Datum：2002年3月末までの日本の公式測地系．Bessel楕円体) に基づく緯度経度を日本平面直角座標系(Japan Plane Rectangular)
 * に基づくXY座標に変換するテスト．
 *
 *
 * @author nkjm
 *
 */

public class LatLon2XYTest {

  @Before
  public void setUp() throws Exception {}

  /**
   * 平面直角座標への換算 http://vldb.gsi.go.jp/sokuchi/surveycalc/surveycalc/bl2xyf.html
   *
   * わかりやすい平面直角座標系 http://vldb.gsi.go.jp/sokuchi/patchjgd/download/Help/jpc/jpc.htm
   *
   * 「平面直角座標への換算」ページで，測地系を「日本測地系」，系番号に適切なものを選び， 度分秒(dddmmss.s)の入力単位で緯度，経度を入力し，変換したものと比較する．
   */

  @Test
  public void test() {

    Map<LatLonWithZone, XYWithZone> queries = new LinkedHashMap<>();

    BasisWithZone tokyoBasis = BasisWithZone.of(Unit.DEGREE, Detum.TOKYO, ZoneId._9);

    BasisWithZone wgsBasis = BasisWithZone.of(Unit.DEGREE, Detum.WGS84, ZoneId._9);

    // BasisWithZone basis2 = new BasisWithZone(Unit.MILLI_DEGREE,
    // Detum.TOKYO,
    // ZoneId._9);
    // // 国土地理院 (日本測地系)
    // qas.put(new LatLonWithZone(36104.583, 140084.583, basis2),
    // new XYWithZone(11631.3563, 22618.7053, DistanceUnit.M, basis2));

    // 国土地理院 (日本測地系)
    // qas.put(new LatLonWithZone(36.104583, 140.084583, basis1),
    // new XYWithZone(11631.3563, 22618.7053, basis1));

    // 国土地理院 (日本測地系)
    queries.put(new LatLonWithZone(36.103774791666666, 140.08785504166664, tokyoBasis),
        new XYWithZone(11542.4611, 22913.5056, tokyoBasis));

    // 国土地理院 (世界測地系)
    queries.put(new LatLonWithZone(36.103774791666666, 140.08785504166664, wgsBasis),
        new XYWithZone(11543.6883, 22916.2436, wgsBasis));

    // スカイツリー (日本測地系)
    queries.put(new LatLonWithZone(35.71004, 139.81070, tokyoBasis),
        new XYWithZone(-32166.0244, -2047.6996, tokyoBasis));

    for (LatLonWithZone query : queries.keySet()) {
      {
        XYWithZone expected = queries.get(query);
        XYWithZone actual = query.toXYWithZone();
        System.out.println("Expected:" + expected);
        System.out.println("Actual:" + actual);
        assertEquals(expected.getX(), actual.getX(), 5);
        assertEquals(expected.getY(), actual.getY(), 5);
        System.out.println(actual.toLatLonWithZone());

      }
      {
        LatLonWithZone expected = query;
        LatLonWithZone actual = queries.get(query).toLatLonWithZone();
        System.out.println("Expected:" + expected);
        System.out.println("Actual:" + actual);
        assertEquals(expected.getLat(), actual.getLat(), 1);
        assertEquals(expected.getLon(), actual.getLon(), 1);
      }
    }
  }
}
