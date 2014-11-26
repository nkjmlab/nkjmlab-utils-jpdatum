package org.nkjmlab.gis.jpr.latlngxy;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.nkjmlab.gis.jpr.latlngxy.common.LatLng;
import org.nkjmlab.gis.jpr.latlngxy.common.XY;
import org.nkjmlab.gis.jpr.latlngxy.numerical.LatLng2XY;
import org.nkjmlab.gis.jpr.latlngxy.util.LatLngUtils;

/**
 * 日本測地系2000(The Japanese Geodetic Datum 2000 ：JGD2000) を日本平面直角座標系(Japan Plane
 * Rectangular)に変換するテスト．
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

		Map<LatLng, XY> qas = new HashMap<>();
		// 国土地理院
		qas.put(new LatLng(36.061358925, 140.051627815, 9), new XY(11542.461,
				22913.506, 9));
		// スカイツリー
		qas.put(new LatLng(LatLngUtils.degToDms(35.71004), LatLngUtils
				.degToDms(139.81070), 9), new XY(-32166.024, -2047.700, 9));

		for (LatLng query : qas.keySet()) {
			XY expected = qas.get(query);
			XY actual = LatLng2XY.toXY(query);
			System.out.println("Expected:" + expected);
			System.out.println("Actual:" + actual);
			assertEquals(expected.getX(), actual.getX(), 0.5);
			assertEquals(expected.getY(), actual.getY(), 0.5);

		}
	}
}
