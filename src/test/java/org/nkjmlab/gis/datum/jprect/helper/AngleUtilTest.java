package org.nkjmlab.gis.datum.jprect.helper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class AngleUtilTest {

  @Test
  public void testToRadians() {
    assertThat(AngleUtil.toRadian(0)).isEqualTo(0);
    assertThat(AngleUtil.toRadian(90)).isEqualTo(Math.PI / 2);
    assertThat(AngleUtil.toRadian(180)).isEqualTo(Math.PI);
    assertThat(AngleUtil.toRadian(360)).isEqualTo(2 * Math.PI);
  }
}
