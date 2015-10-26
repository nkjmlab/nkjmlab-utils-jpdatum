package org.nkjmlab.gis.datum.jprect;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.nkjmlab.gis.datum.LatLon.Detum;
import org.nkjmlab.gis.datum.LatLon.Unit;
import org.nkjmlab.gis.datum.jprect.util.XY2LatLon;
import org.nkjmlab.gis.datum.Basis;

/**
 * 日本平面直角座標系 (Japan Plane Rectangular) に基づくXY座標 から 旧日本測地系 (Tokyo
 * Datum：2002年3月末までの日本の公式測地系．Bessel楕円体) に基づく緯度経度 に変換するテスト．
 *
 * @author Yuu NAKAJIMA
 *
 */

public class XY2LatLonTest {

	@Before
	public void setUp() throws Exception {
	}

	/**
	 * 各ゾーンの原点で確認．
	 * http://vldb.gsi.go.jp/sokuchi/surveycalc/surveycalc/xy2blf.html
	 */

	@Test
	public void test() {
		Basis basis = new Basis(Unit.DEGREE, Detum.TOKYO);

		double x = 0;
		double y = 0;
		for (JapanPlaneRectangular.ZoneId zoneId : JapanPlaneRectangular.ZoneId
				.values()) {

			LatLonWithZone origin = JapanPlaneRectangular.getOrigin(zoneId);
			LatLonWithZone latLon = XY2LatLon
					.toLatLon(new XYWithZone(x, y, zoneId));

			System.out.println("Origin: " + origin);
			System.out.println("Calculated: " + latLon);
			assertEquals(origin.getLat(basis), latLon.getLat(basis), 0.01);
			assertEquals(origin.getLon(basis), latLon.getLon(basis), 0.01);
		}

	}
}
