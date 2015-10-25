package org.nkjmlab.gis.datum;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.nkjmlab.gis.datum.util.Deg2Dms;
import org.nkjmlab.gis.datum.util.Dms2Deg;
import org.nkjmlab.gis.datum.util.Dms2Sec;
import org.nkjmlab.gis.datum.util.Sec2Dms;
import org.nkjmlab.gis.datum.util.TD2Wgs;
import org.nkjmlab.gis.datum.util.Wgs2TD;

/**
 * 緯度経度を表現するクラス．緯度経度は，作成時に指定された単位と測地系で保存される．呼び出し時に指定した単位および座標系で取り出すことができる．
 *
 *
 * @author nkjm
 *
 */
public class LatLon {

	protected final double lat;
	protected final double lon;

	protected final Unit unit;
	protected final Detum detum;

	public enum Unit {
		DEGREE, MILI_DEGREE, DMS, SECOND
	}

	public enum Detum {
		TOKYO, WGS84
	}

	protected LatLon(double lat, double lon, Unit unit, Detum detum) {
		this.lat = lat;
		this.lon = lon;
		this.unit = unit;
		this.detum = detum;

	}

	public Unit getUnit() {
		return this.unit;
	}

	public Detum getDetum() {
		return this.detum;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof LatLon)) {
			return false;
		}
		LatLon l = (LatLon) obj;
		return this.lat == l.lat && this.lon == l.lon && this.unit == l.unit
				&& this.detum == l.detum;
	}

	@Override
	public int hashCode() {
		return (int) (lat + lon);
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.SHORT_PREFIX_STYLE);
	}

	/**
	 * 緯度を返す．単位と測地系はインスタンス生成時の引数の値に従う．
	 *
	 * @return
	 */
	public double getLat() {
		return lat;
	}

	/**
	 * 経度を返す．単位と測地系はインスタンス生成時の引数の値に従う．
	 *
	 * @return
	 */
	public double getLon() {
		return lon;
	}

	/**
	 * 緯度を返す．単位と測地系は引数の値に従う．
	 *
	 * @param basis
	 *
	 * @return
	 */
	public double getLat(LatLonBasis basis) {
		return getLat(basis.getUnit(), basis.getDetum());
	}

	/**
	 * 緯度を返す．単位と測地系は引数の値に従う．
	 *
	 * @param basis
	 *
	 * @return
	 */
	public double getLon(LatLonBasis basis) {
		return getLon(basis.getUnit(), basis.getDetum());
	}

	/**
	 * 緯度を返す．単位と測地系は引数の値に従う．
	 *
	 * @return
	 */
	public double getLat(Unit toUnit, Detum toDetum) {
		return changeBasisOfLat(lat, lon, this.unit, this.detum, toUnit,
				toDetum);
	}

	/**
	 * 経度を返す．単位と測地系は引数の値に従う．
	 *
	 * @return
	 */
	public double getLon(Unit toUnit, Detum toDetum) {
		return changeBasisOfLon(lat, lon, this.unit, this.detum, toUnit,
				toDetum);
	}

	/**
	 * 経度を返す．単位は引数の値に，測地系はインスタンス生成時の値に従う．
	 *
	 * @return
	 */
	public double getLon(Unit toUnit) {
		return changeBasisOfLon(lat, lon, this.unit, this.detum, toUnit,
				this.detum);
	}

	/**
	 * 緯度を返す．単位は引数の値に，測地系はインスタンス生成時の値に従う．
	 *
	 * @return
	 */
	public double getLat(Unit toUnit) {
		return changeBasisOfLat(lat, lon, this.unit, this.detum, toUnit,
				this.detum);
	}

	/**
	 * 緯度を返す．単位はインスタンス生成時の値に，測地系は引数の値に従う．
	 *
	 * @return
	 */
	public double getLat(Detum toDetum) {
		return changeBasisOfLat(lat, lon, this.unit, this.detum, this.unit,
				toDetum);
	}

	/**
	 * 経度を返す．単位と測地系は引数の値に従う．
	 *
	 * @return
	 */
	public double getLon(Detum toDetum) {
		return changeBasisOfLon(lat, lon, this.unit, this.detum, this.unit,
				toDetum);
	}

	public static double changeBasisOfLat(double lat, double lon, Unit fromUnit,
			Detum fromDetum, Unit toUnit, Detum toDetum) {
		if (fromDetum == toDetum) {
			return changeUnit(lat, fromUnit, toUnit);
		}
		double valOnToDetum = changeDetumOfLat(
				changeUnit(lat, fromUnit, Unit.DEGREE),
				changeUnit(lon, fromUnit, Unit.DEGREE), toDetum);
		return changeUnit(valOnToDetum, fromUnit, toUnit);
	}

	public static double changeBasisOfLon(double lat, double lon, Unit fromUnit,
			Detum fromDetum, Unit toUnit, Detum toDetum) {
		if (fromDetum == toDetum) {
			return changeUnit(lon, fromUnit, toUnit);
		}
		double valOnToDetum = changeDetumOfLon(
				changeUnit(lon, fromUnit, Unit.DEGREE),
				changeUnit(lon, fromUnit, Unit.DEGREE), toDetum);
		return changeUnit(valOnToDetum, fromUnit, toUnit);
	}

	public static double changeDetumOfLat(double latDeg, double lonDeg,
			Detum toDetum) {
		switch (toDetum) {
		case TOKYO:
			return Wgs2TD.toLatTD(latDeg, lonDeg);
		case WGS84:
			return TD2Wgs.toLatWgs(latDeg, lonDeg);
		default:
			throw new RuntimeException();
		}
	}

	public static double changeDetumOfLon(double latDeg, double lonDeg,
			Detum toDetum) {
		switch (toDetum) {
		case TOKYO:
			return Wgs2TD.toLonTD(latDeg, lonDeg);
		case WGS84:
			return TD2Wgs.toLonWgs(latDeg, lonDeg);
		default:
			throw new RuntimeException();
		}
	}

	public static double changeUnit(double val, Unit fromUnit, Unit toUnit) {
		if (fromUnit == toUnit) {
			return val;
		}

		switch (fromUnit) {
		case DEGREE:
			if (toUnit == Unit.MILI_DEGREE) {
				return val * 1000;
			} else if (toUnit == Unit.DMS) {
				return Deg2Dms.toDms(val);
			} else if (toUnit == Unit.SECOND) {
				return Dms2Sec.toSec(Deg2Dms.toDms(val));
			}
		case MILI_DEGREE:
			if (toUnit == Unit.DEGREE) {
				return val / 1000;
			} else if (toUnit == Unit.DMS) {
				return Deg2Dms.toDms(val / 1000);
			} else if (toUnit == Unit.SECOND) {
				return Dms2Sec.toSec(Deg2Dms.toDms(val / 1000));
			}
		case DMS:
			if (toUnit == Unit.DEGREE) {
				return Dms2Deg.toDeg(val);
			} else if (toUnit == Unit.MILI_DEGREE) {
				return Dms2Deg.toDeg(val) * 1000;
			} else if (toUnit == Unit.SECOND) {
				return Dms2Sec.toSec(val);
			}
		case SECOND:
			if (toUnit == Unit.DEGREE) {
				return Dms2Deg.toDeg(Sec2Dms.toDms(val));
			} else if (toUnit == Unit.MILI_DEGREE) {
				return Dms2Deg.toDeg(Sec2Dms.toDms(val)) * 1000;
			} else if (toUnit == Unit.DMS) {
				return Sec2Dms.toDms(val);
			}
		default:
			throw new RuntimeException();
		}
	}

}