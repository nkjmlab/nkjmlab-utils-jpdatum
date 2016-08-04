package org.nkjmlab.gis.datum;

public class DistanceUnitConverter {

	public static double change(double val, DistanceUnit fromUnit, DistanceUnit toUnit) {
		if (fromUnit == toUnit) {
			return val;
		}

		switch (fromUnit) {
		case M:
			if (toUnit == DistanceUnit.KM) {
				return val / 1000;
			}
		case KM:
			if (toUnit == DistanceUnit.M) {
				return val * 1000;
			}
		default:
			throw new IllegalArgumentException(fromUnit + " is not suported.");
		}
	}
}
