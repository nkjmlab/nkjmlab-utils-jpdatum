package org.nkjmlab.gis.datum.jprect.helper;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.Test;

public class ArcLengthTest {

  @Test
  public void testCalcArcLength() {
    // Test for latitude 0
    assertThat(ArcLength.calcArcLength(0)).isEqualTo(0);

    // Test for latitude π/2 (90 degrees)
    assertThat(ArcLength.calcArcLength(Math.PI / 2))
        .isCloseTo(10018750, Percentage.withPercentage(0.2));
    // Test for latitude π (180 degrees)
    assertThat(ArcLength.calcArcLength(Math.PI))
        .isCloseTo(20037500, Percentage.withPercentage(0.2));
  }
}
