package org.nkjmlab.gis.datum;

import org.nkjmlab.gis.datum.LatLon.Detum;
import org.nkjmlab.gis.datum.LatLon.Unit;

public class BasisConverter {

	/**
	 * 指定された単位・測地系の緯度・経度から，指定した単位・測地系の緯度を取り出す．
	 *
	 * @param lat
	 *            緯度
	 * @param lon
	 *            経度
	 * @param fromUnit
	 *            入力の単位
	 * @param fromDetum
	 *            入力の単位
	 * @param toUnit
	 *            出力の単位
	 * @param toDetum
	 *            出力の測地系
	 * @return toUnit，toDetumで指定された単位・測地系による経度
	 */
	public static double changeBasisOfLat(double lat, double lon, Unit fromUnit,
			Detum fromDetum, Unit toUnit, Detum toDetum) {
		if (fromDetum == toDetum) {
			return DegreeUnitConverter.change(lat, fromUnit, toUnit);
		}
		double valOnToDetum = DatumConverter.changeDetumOfLat(lat, lon,
				fromUnit, fromDetum, toDetum);
		return DegreeUnitConverter.change(valOnToDetum, fromUnit, toUnit);
	}

	/**
	 * 指定された単位・測地系の緯度・経度から，指定した単位・測地系の緯度を取り出す．
	 *
	 * @param lat
	 *            緯度
	 * @param lon
	 *            経度
	 * @param fromUnit
	 *            入力の単位
	 * @param fromDetum
	 *            入力の単位
	 * @param toUnit
	 *            出力の単位
	 * @param toDetum
	 *            出力の測地系
	 * @return toUnit，toDetumで指定された単位・測地系による経度
	 */
	public static double changeBasisOfLon(double lat, double lon, Unit fromUnit,
			Detum fromDetum, Unit toUnit, Detum toDetum) {
		if (fromDetum == toDetum) {
			return DegreeUnitConverter.change(lon, fromUnit, toUnit);
		}
		double valOnToDetum = DatumConverter.changeDetumOfLon(lat, lon,
				fromUnit, fromDetum, toDetum);
		return DegreeUnitConverter.change(valOnToDetum, fromUnit, toUnit);
	}

	public static double changeBasisOfLon(double lat, double lon,
			Basis fromBasis, Basis toBasis) {
		return changeBasisOfLon(lat, lon, fromBasis.getUnit(),
				fromBasis.getDetum(), toBasis.getUnit(), toBasis.getDetum());
	}

}
