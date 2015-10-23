package org.nkjmlab.gis.datum.util;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TD2WgsTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testToWgs() {

		double latTD = 35.71004;
		double lonTD = 139.81070;
		double latWgs = 35.713274983;
		double lonWgs = 139.807461872;
		assertEquals(latTD, Wgs2TD.toLatTD(latWgs, lonWgs), 0.01);
		assertEquals(lonTD, Wgs2TD.toLonTD(latWgs, lonWgs), 0.01);

	}

}
