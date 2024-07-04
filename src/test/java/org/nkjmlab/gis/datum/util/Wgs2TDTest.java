package org.nkjmlab.gis.datum.util;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.nkjmlab.gis.datum.DatumConverter;

public class Wgs2TDTest {

  @Test
  public void testToWGS() {
    double latDegTD = 35.71004;
    double lonDegTD = 139.81070;
    double latDegWgs = 35.71327498;
    double lonDegWgs = 139.80746187;
    assertEquals(latDegWgs, DatumConverter.changeDetumOfLatFromTdToWgs(latDegTD, lonDegTD), 0.01);
    assertEquals(lonDegWgs, DatumConverter.changeDetumOfLonFromTdToWgs(latDegTD, lonDegTD), 0.01);
  }
}
