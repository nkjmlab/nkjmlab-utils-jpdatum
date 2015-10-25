package org.nkjmlab.gis.datum.util;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TD2WgsTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testToWgs() {

		double latDegTD = 35.71004;
		double lonDegTD = 139.81070;
		double latDegWgs = 35.71327498;
		double lonDegWgs = 139.80746187;
		// 0.0001度もズレない．
		assertEquals(latDegTD, Wgs2TD.toLatTD(latDegWgs, lonDegWgs), 0.0001);
		assertEquals(lonDegTD, Wgs2TD.toLonTD(latDegWgs, lonDegWgs), 0.0001);

		// 0.01度はズレないけど，0.001度はズレる．ざっくりと1度が111kmとすると100mはズレちゃうのか…
		assertEquals(latDegWgs,
				TD2Wgs.toLatWgs(Wgs2TD.toLatTD(latDegWgs, lonDegWgs), Wgs2TD.toLonTD(latDegWgs, lonDegWgs)), 0.01);
		assertEquals(lonDegWgs,
				TD2Wgs.toLonWgs(Wgs2TD.toLatTD(latDegWgs, lonDegWgs), Wgs2TD.toLonTD(latDegWgs, lonDegWgs)), 0.01);

	}

}
