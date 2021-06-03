package org.nkjmlab.gis.datum;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.nkjmlab.gis.datum.jprect.LatLon2XYTest;
import org.nkjmlab.gis.datum.jprect.XY2LatLonTest;
import org.nkjmlab.gis.datum.util.LatLonUtilsTest;
import org.nkjmlab.gis.datum.util.TD2WgsTest;
import org.nkjmlab.gis.datum.util.Wgs2TDTest;

@RunWith(Suite.class)
@SuiteClasses({LatLon2XYTest.class, XY2LatLonTest.class, LatLonUtilsTest.class, TD2WgsTest.class,
    Wgs2TDTest.class})
public class AllTests {

}
