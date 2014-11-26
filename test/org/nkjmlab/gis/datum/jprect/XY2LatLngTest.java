package org.nkjmlab.gis.datum.jprect;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.nkjmlab.gis.datum.jprect.common.JapanPlaneRectangular;
import org.nkjmlab.gis.datum.jprect.common.LatLng;
import org.nkjmlab.gis.datum.jprect.common.XY;
import org.nkjmlab.gis.datum.jprect.numerical.XY2LatLng;

/**
 * 日本平面直角座標系 (Japan Plane Rectangular) に基づくXY座標 から 旧日本測地系 (Tokyo
 * Datum：2002年3月末までの日本の公式測地系．Bessel楕円体) に基づく緯度経度 に変換するテスト．
 *
 * @author Yuu NAKAJIMA
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