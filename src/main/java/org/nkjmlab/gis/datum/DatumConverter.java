package org.nkjmlab.gis.datum;

import org.nkjmlab.gis.datum.LatLon.Detum;
import org.nkjmlab.gis.datum.LatLon.Unit;
import org.nkjmlab.gis.datum.util.TD2Wgs;
import org.nkjmlab.gis.datum.util.Wgs2TD;

public class DatumConverter {

	public static double changeDetumOfLat(double lat, double lon, Unit fromUnit,
			Detum fromDetum, Detum toDetum) {
		double latDeg = UnitConverter.changeUnit(lat, fromUnit, Unit.DEGREE);
		double lonDeg = UnitConverter.changeUnit(lon, fromUnit, Unit.DEGREE);

		switch (toDetum) {
		case TOKYO:
			return UnitConverter.changeUnit(Wgs2TD.toLatTD(latDeg, lonDeg),
					Unit.DEGREE, fromUnit);
		case WGS84:
			return UnitConverter.changeUnit(TD2Wgs.toLatWgs(latDeg, lonDeg),
					Unit.DEGREE, fromUnit);
		default:
			throw new RuntimeException();
		}
	}

	public static double changeDetumOfLon(double lat, double lon, Unit fromUnit,
			Detum fromDetum, Detum toDetum) {
		double latDeg = UnitConverter.changeUnit(lat, fromUnit, Unit.DEGREE);
		double lonDeg = UnitConverter.changeUnit(lon, fromUnit, Unit.DEGREE);

		switch (toDetum) {
		case TOKYO:
			return UnitConverter.changeUnit(Wgs2TD.toLonTD(latDeg, lonDeg),
					Unit.DEGREE, fromUnit);
		case WGS84:
			return UnitConverter.changeUnit(TD2Wgs.toLonWgs(latDeg, lonDeg),
					Unit.DEGREE, fromUnit);
		default:
			throw new RuntimeException();
		}
	}
}
