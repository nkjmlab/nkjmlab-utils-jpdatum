package org.nkjmlab.gis.jpr.latlngxy;

/***
 * @author Yuu NAKAJIMA
 */
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.nkjmlab.gis.jpr.latlngxy.util.LatLngUtils;

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
		System.out.println(LatLngUtils.degToDms(deg));
		System.out.println(LatLngUtils.dmsToDeg(dms));

		assertEquals(dms, LatLngUtils.degToDms(deg), 0.01);
		assertEquals(deg, LatLngUtils.dmsToDeg(dms), 0.01);

	}
}
