package org.nkjmlab.gis.datum;

public class DistanceUnitConverter {

	public enum Unit {
		M, KM
	}

	public static double change(double val, Unit fromUnit, Unit toUnit) {
		if (fromUnit == toUnit) {
			return val;
		}

		switch (fromUnit) {
		case M:
			if (toUnit == Unit.KM) {
				return val / 1000;
			}
		case KM:
			if (toUnit == Unit.M) {
				return val * 1000;
			}

		}
		throw new RuntimeException();
	}
}
