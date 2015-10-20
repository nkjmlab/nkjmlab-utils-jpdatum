package org.nkjmlab.gis.datum.jprect;

/***
 * @author Yuu NAKAJIMA
 */
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.nkjmlab.gis.datum.util.Deg2Dms;
import org.nkjmlab.gis.datum.util.Dms2Deg;

public class LatLngUtilsTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		testDmsDeg(139.483852, 139.81070);
		testDmsDeg(132.1000, 132.1778);
		testDmsDeg(134.1200, 134.2000);
	}

	private void testDmsDeg(double dms, double deg) {
		System.out.println(Deg2Dms.to(deg));
		System.out.println(Dms2Deg.to(dms));

		assertEquals(dms, Deg2Dms.to(deg), 0.01);
		assertEquals(deg, Dms2Deg.to(dms), 0.01);

	}
}
