package org.nkjmlab.gis.datum.util;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Wgs2TDTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testToWGS() {
		double latDegTD = 35.71004;
		double lonDegTD = 139.81070;
		double latDegWgs = 35.71327498;
		double lonDegWgs = 139.80746187;
		assertEquals(latDegWgs, TD2Wgs.toLatWgs(latDegTD, lonDegTD), 0.001);
		assertEquals(lonDegWgs, TD2Wgs.toLonWgs(latDegTD, lonDegTD), 0.001);

	}

}
