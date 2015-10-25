package org.nkjmlab.gis.datum.util;

/***
 * @author Yuu NAKAJIMA
 */
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LatLonUtilsTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		testDmsDeg(1321210, 132.202777777777778);
		testDmsDeg(1321000, 132.166666666666667);
		testDmsDeg(1321200, 132.2000);
	}

	private void testDmsDeg(double dms, double deg) {
		System.out.println(Deg2Dms.toDms(deg));
		System.out.println(Dms2Deg.toDeg(dms));

		assertEquals(dms, Deg2Dms.toDms(deg), 0.01);
		assertEquals(deg, Dms2Deg.toDeg(dms), 0.01);

	}
}
