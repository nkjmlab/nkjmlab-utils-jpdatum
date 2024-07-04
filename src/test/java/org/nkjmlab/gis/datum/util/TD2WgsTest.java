package org.nkjmlab.gis.datum.util;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.nkjmlab.gis.datum.DatumConverter;

public class TD2WgsTest {

  @Test
  public void testToWgs() {

    double latDegTD = 35.71004;
    double lonDegTD = 139.81070;
    double latDegWgs = 35.71327498;
    double lonDegWgs = 139.80746187;
    // 0.0001度もズレない．
    assertEquals(
        latDegTD, DatumConverter.changeDetumOfLatFromWgsToTd(latDegWgs, lonDegWgs), 0.0001);
    assertEquals(
        lonDegTD, DatumConverter.changeDetumOfLonFromWgsToTd(latDegWgs, lonDegWgs), 0.0001);

    // 0.01度はズレないけど，0.001度はズレる．ざっくりと1度が111kmとすると100mはズレちゃうのか…
    assertEquals(
        latDegWgs,
        DatumConverter.changeDetumOfLatFromTdToWgs(
            DatumConverter.changeDetumOfLatFromWgsToTd(latDegWgs, lonDegWgs),
            DatumConverter.changeDetumOfLonFromWgsToTd(latDegWgs, lonDegWgs)),
        0.01);
    assertEquals(
        lonDegWgs,
        DatumConverter.changeDetumOfLonFromTdToWgs(
            DatumConverter.changeDetumOfLatFromWgsToTd(latDegWgs, lonDegWgs),
            DatumConverter.changeDetumOfLonFromWgsToTd(latDegWgs, lonDegWgs)),
        0.01);
  }
}
