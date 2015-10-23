package org.nkjmlab.gis.datum.util;

import org.junit.Before;
import org.junit.Test;
import org.nkjmlab.gis.datum.util.Wgs2TD;

public class TD2WgsTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testToWgs() {
		// TD(35.71004, 139.81070)=>JGD2000(35.713274983, 139.807461872)

		System.out.println(Wgs2TD.toLatTD(35.71004, 139.81070));
		System.out.println(Wgs2TD.toLonTD(35.71004, 139.81070));
	}

}
