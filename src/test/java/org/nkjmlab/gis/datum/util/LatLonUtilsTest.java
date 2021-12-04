package org.nkjmlab.gis.datum.util;

import static org.junit.jupiter.api.Assertions.*;
/***
 * @author Yuu NAKAJIMA
 */
import org.junit.jupiter.api.Test;
import org.nkjmlab.gis.datum.LatLon.Unit;
import org.nkjmlab.gis.datum.LatLonUnitConverter;

public class LatLonUtilsTest {


  @Test
  public void test() {
    testDmsDeg(1321210, 132.202777777777778);
    testDmsDeg(1321000, 132.166666666666667);
    testDmsDeg(1321200, 132.2000);
  }

  private void testDmsDeg(double dms, double deg) {
    System.out.println(LatLonUnitConverter.change(deg, Unit.DEGREE, Unit.DMS));
    System.out.println(LatLonUnitConverter.change(dms, Unit.DMS, Unit.DEGREE));

    assertEquals(dms, LatLonUnitConverter.change(deg, Unit.DEGREE, Unit.DMS), 0.01);
    assertEquals(deg, LatLonUnitConverter.change(dms, Unit.DMS, Unit.DEGREE), 0.01);

  }
}
