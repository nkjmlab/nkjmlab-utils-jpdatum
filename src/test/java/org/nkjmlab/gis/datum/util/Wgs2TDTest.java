package org.nkjmlab.gis.datum.util;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class Wgs2TDTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testToWGS() {
		double latTD = 35.71004;
		double lonTD = 139.81070;
		double latWgs = 35.713274983;
		double lonWgs = 139.807461872;
		assertEquals(latWgs, TD2Wgs.toLatWgs(latTD, lonTD), 0.01);
		assertEquals(lonWgs, TD2Wgs.toLonWgs(latTD, lonTD), 0.01);

	}

}
