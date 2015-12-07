package org.nkjmlab.gis.datum.jprect;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * pixcel/meter
 *
 * @author nkjm
 *
 */
public class Scale {

	private double pixel;
	private double meter;

	public Scale(double pixel, double meter) {
		this.pixel = pixel;
		this.meter = meter;
	}

	/**
	 *
	 * @param meter
	 * @return
	 */
	public int toPixcel(double meter) {
		return (int) (pixel * meter / this.meter);
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.SHORT_PREFIX_STYLE);
	}

}
