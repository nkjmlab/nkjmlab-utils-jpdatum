package org.nkjmlab.gis.datum.jprect;

import org.junit.Before;
import org.junit.Test;
import org.nkjmlab.gis.datum.common.LatLonDegWgs;
import org.nkjmlab.gis.datum.common.LatLonDegTD;
import org.nkjmlab.gis.datum.util.Wgs2TD;

public class Wgs2TDTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testToWGS() {
		// TD(35.71004, 139.81070)=>JGD2000(35.713274983, 139.807461872)

		LatLonDegTD td = Wgs2TD.toTD(new LatLonDegWgs(35.71004, 139.81070));

	}

}
