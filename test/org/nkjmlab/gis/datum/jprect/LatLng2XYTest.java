package org.nkjmlab.gis.datum.jprect;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.nkjmlab.gis.datum.jprect.common.LatLngDegTDWithZoneId;
import org.nkjmlab.gis.datum.jprect.common.XYWithZoneId;
import org.nkjmlab.gis.datum.jprect.numerical.LatLngDegTD2XY;
import org.nkjmlab.gis.datum.jprect.numerical.XY2LatLngDegTD;

/**
 * 旧日本測地系(Tokyo Datum：2002年3月末までの日本の公式測地系．Bessel楕円体) に基づく緯度経度を日本平面直角座標系(Japan
 * Plane Rectangular) に基づくXY座標に変換するテスト．
 *
 *
 * @author nkjm
 *
 */

public class LatLng2XYTest {

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

		Map<LatLngDegTDWithZoneId, XYWithZoneId> qas = new HashMap<>();
		// 国土地理院 (日本測地系)
		qas.put(new LatLngDegTDWithZoneId(36.104583, 140.084583, 9),
				new XYWithZoneId(11631.3563, 22618.7053, 9));

		// スカイツリー (日本測地系)
		qas.put(new LatLngDegTDWithZoneId(35.71004, 139.81070, 9),
				new XYWithZoneId(-32166.0244, -2047.6996, 9));

		for (LatLngDegTDWithZoneId query : qas.keySet()) {
			{
				XYWithZoneId expected = qas.get(query);
				XYWithZoneId actual = LatLngDegTD2XY.toXY(query);
				System.out.println("Expected:" + expected);
				System.out.println("Actual:" + actual);
				assertEquals(expected.x, actual.x, 0.1);
				assertEquals(expected.y, actual.y, 0.1);
			}
			{
				LatLngDegTDWithZoneId expected = query;
				LatLngDegTDWithZoneId actual = XY2LatLngDegTD.toLatLng(qas.get(query));
				System.out.println("Expected:" + expected);
				System.out.println("Actual:" + actual);
				assertEquals(expected.latDeg, actual.latDeg, 0.1);
				assertEquals(expected.lngDeg, actual.lngDeg, 0.1);

			}
		}
	}
}
