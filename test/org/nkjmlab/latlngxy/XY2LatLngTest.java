package org.nkjmlab.latlngxy;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.nkjmlab.latlngxy.common.JapanPlaneRectangular;
import org.nkjmlab.latlngxy.common.LatLng;
import org.nkjmlab.latlngxy.common.XY;
import org.nkjmlab.latlngxy.numerical.XY2LatLng;

/**
 * 日本平面直角座標系(Japan Plane Rectangular) から 日本測地系2000(The Japanese Geodetic Datum
 * 2000 ：JGD2000) に変換するテスト．
 *
 * @author nkjm
 *
 */

public class XY2LatLngTest {

	@Before
	public void setUp() throws Exception {
	}

	/**
	 * 各ゾーンの原点で確認．
	 * http://vldb.gsi.go.jp/sokuchi/surveycalc/surveycalc/xy2blf.html
	 */

	@Test
	public void test() {

		double x = 0;
		double y = 0;
		for (int zoneId = 1; zoneId <= 19; zoneId++) {

			LatLng origin = JapanPlaneRectangular.getOrigin(zoneId);
			LatLng latLng = XY2LatLng.toLatLng(new XY(x, y, zoneId));

			System.out.println("Origin: " + origin);
			System.out.println("Calced: " + latLng);
			assertEquals(origin.getLat(), latLng.getLat(), 0.1);
			assertEquals(origin.getLat(), latLng.getLat(), 0.1);
		}

	}
}
