package org.nkjmlab.latlngxy;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.nkjmlab.latlngxy.common.LatLng;
import org.nkjmlab.latlngxy.common.XY;
import org.nkjmlab.latlngxy.numerical.LatLng2XY;

/**
 * 日本測地系2000(The Japanese Geodetic Datum 2000 ：JGD2000) を日本平面直角座標系(Japan Plane
 * Rectangular)に変換するテスト．
 *
 * @author nkjm
 *
 */

public class LatLngConvTest {

	@Before
	public void setUp() throws Exception {
	}

	/**
	 * http://vldb.gsi.go.jp/sokuchi/surveycalc/surveycalc/bl2xyf.html
	 */

	@Test
	public void test() {

		Map<LatLng, XY> qas = new HashMap<>();
		qas.put(new LatLng(36.061358925, 140.051627815, 9), new XY(11542.461,
				22913.506, 9));

		for (LatLng query : qas.keySet()) {
			XY expected = qas.get(query);
			XY actual = LatLng2XY.toXY(query);
			assertEquals(expected.getX(), actual.getX(), 0.5);
			assertEquals(expected.getY(), actual.getY(), 0.5);
			System.out.println("Expected:" + expected);
			System.out.println("Actual:" + actual);

		}
	}
}
