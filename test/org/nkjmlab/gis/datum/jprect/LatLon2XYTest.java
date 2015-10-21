package org.nkjmlab.gis.datum.jprect;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

/**
 * 旧日本測地系(Tokyo Datum：2002年3月末までの日本の公式測地系．Bessel楕円体) に基づく緯度経度を日本平面直角座標系(Japan
 * Plane Rectangular) に基づくXY座標に変換するテスト．
 *
 *
 * @author nkjm
 *
 */

public class LatLon2XYTest {

	@Before
	public void setUp() throws Exception {
	}

	/**
	 * 平面直角座標への換算
	 * http://vldb.gsi.go.jp/sokuchi/surveycalc/surveycalc/bl2xyf.html
	 *
	 * わかりやすい平面直角座標系
	 * http://vldb.gsi.go.jp/sokuchi/patchjgd/download/Help/jpc/jpc.htm
	 *
	 * 「平面直角座標への換算」ページで，測地系を「日本測地系」，系番号に適切なものを選び，
	 * 度分秒(dddmmss.s)の入力単位で緯度，経度を入力し，変換したものと比較する．
	 */

	@Test
	public void test() {

		Map<LatLonWithZone, XYJpr> qas = new HashMap<>();
		// 国土地理院 (日本測地系)
		qas.put(new LatLonWithZone(36.104583, 140.084583, 9),
				new XYJpr(11631.3563, 22618.7053, 9));

		// スカイツリー (日本測地系)
		qas.put(new LatLonWithZone(35.71004, 139.81070, 9),
				new XYJpr(-32166.0244, -2047.6996, 9));

		for (LatLonWithZone query : qas.keySet()) {
			{
				XYJpr expected = qas.get(query);
				XYJpr actual = LatLon2XY.toXY(query);
				System.out.println("Expected:" + expected);
				System.out.println("Actual:" + actual);
				assertEquals(expected.getX(), actual.getX(), 0.01);
				assertEquals(expected.getY(), actual.getY(), 0.01);
			}
			{
				LatLonWithZone expected = query;
				LatLonWithZone actual = XY2LatLon.toLatLon(qas.get(query));
				System.out.println("Expected:" + expected);
				System.out.println("Actual:" + actual);
				assertEquals(expected.getLat(), actual.getLat(), 0.01);
				assertEquals(expected.getLon(), actual.getLon(), 0.01);

			}
		}
	}
}
