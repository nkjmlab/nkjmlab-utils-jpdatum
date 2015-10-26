package org.nkjmlab.gis.datum;

import org.nkjmlab.gis.datum.LatLon.Detum;
import org.nkjmlab.gis.datum.LatLon.Unit;

public class BasisConverter {

	public static double changeBasisOfLat(double lat, double lon, Unit fromUnit,
			Detum fromDetum, Unit toUnit, Detum toDetum) {
		if (fromDetum == toDetum) {
			return UnitConverter.changeUnit(lat, fromUnit, toUnit);
		}
		double valOnToDetum = DatumConverter.changeDetumOfLat(lat, lon,
				fromUnit, fromDetum, toDetum);
		return UnitConverter.changeUnit(valOnToDetum, fromUnit, toUnit);
	}

	public static double changeBasisOfLon(double lat, double lon, Unit fromUnit,
			Detum fromDetum, Unit toUnit, Detum toDetum) {
		if (fromDetum == toDetum) {
			return UnitConverter.changeUnit(lon, fromUnit, toUnit);
		}
		double valOnToDetum = DatumConverter.changeDetumOfLon(lat, lon,
				fromUnit, fromDetum, toDetum);
		return UnitConverter.changeUnit(valOnToDetum, fromUnit, toUnit);
	}

}
