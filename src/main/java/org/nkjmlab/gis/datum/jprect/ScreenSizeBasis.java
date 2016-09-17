package org.nkjmlab.gis.datum.jprect;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * pixcel/meter
 *
 * @author nkjm
 *
 */
public class ScreenSizeBasis {

	private double pixel;
	private double meter;

	public ScreenSizeBasis(double pixel, double meter) {
		this.pixel = pixel;
		this.meter = meter;
	}

	/**
	 *
	 * @param meter
	 * @return
	 */
	public double toPixel(double meter) {
		return (pixel * meter / this.meter);
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

}
