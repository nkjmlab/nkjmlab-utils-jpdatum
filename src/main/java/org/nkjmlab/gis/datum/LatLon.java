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
 * WGSとTDの間の変換の誤差が大きいので，XY平面に変換する場合は，インスタンスを作る際にTD座標系の値を入れた方が良い．
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
		DEG, MILI_DEG, DMS, SECOND
	}

	public enum Detum {
		TD, WGS
	}

	protected LatLon(double lat, double lon, Unit unit, Detum detum) {
		this.lat = lat;
		this.lon = lon;
		this.unit = unit;
		this.detum = detum;

	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof LatLon)) {
			return false;
		}
		LatLon l = (LatLon) obj;
		return this.lat == l.lat && this.lon == l.lon;
	}

	@Override
	public int hashCode() {
		return (int) (lat + lon);
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

	/**
	 * 緯度を返す．単位や測地系はメンバの値に従う．
	 *
	 * @return
	 */
	public double getLat() {
		return lat;
	}

	/**
	 * 経度を返す．単位や測地系はメンバの値に従う．
	 *
	 * @return
	 */
	public double getLon() {
		return lon;
	}

	/**
	 * 緯度を返す．(TD座標系，十進法度(ddd.ddd)表記)
	 *
	 * @return
	 */
	public double getLatDegTD() {
		return convLatTo(Unit.DEG, Detum.TD);
	}

	/**
	 * 経度を返す．(TD座標系，十進法度(ddd.ddd)表記)
	 *
	 * @return
	 */
	public double getLonDegTD() {
		return convLonTo(Unit.DEG, Detum.TD);
	}

	/**
	 * 緯度を返す．(TD座標系，十進法ミリ度表記)
	 *
	 * @return
	 */
	public double getLatMiliDegTD() {
		return convLatTo(Unit.MILI_DEG, Detum.TD);
	}

	/**
	 * 経度を返す．(TD座標系，十進法ミリ度表記)
	 *
	 * @return
	 */
	public double getLonMiliDegTD() {
		return convLonTo(Unit.MILI_DEG, Detum.TD);
	}

	/**
	 * 緯度を返す．(TD座標系，DMS(ddd.mmss)表記)
	 *
	 * @return
	 */
	public double getLatDmsTD() {
		return convLatTo(Unit.DMS, Detum.TD);
	}

	/**
	 * 経度を返す．(TD座標系，DMS(ddd.mmss)表記)
	 *
	 * @return
	 */
	public double getLonDmsTD() {
		return convLonTo(Unit.DMS, Detum.TD);
	}

	/**
	 * 緯度を返す．(TD座標系，DMS(ddd.mmss)表記)
	 *
	 * @return
	 */
	public double getLatSecTD() {
		return convLatTo(Unit.SECOND, Detum.TD);
	}

	/**
	 * 経度を返す．(TD座標系，DMS(ddd.mmss)表記)
	 *
	 * @return
	 */
	public double getLonSecTD() {
		return convLonTo(Unit.SECOND, Detum.TD);
	}

	/**
	 * 緯度を返す．(WGS座標系，十進法度(ddd.ddd)表記)
	 *
	 * @return
	 */
	public double getLatDegWgs() {
		return convLatTo(Unit.DEG, Detum.WGS);
	}

	/**
	 * 経度を返す．(WGS座標系，十進法度(ddd.ddd)表記)
	 *
	 * @return
	 */
	public double getLonDegWgs() {
		return convLonTo(Unit.DEG, Detum.WGS);
	}

	/**
	 * 緯度を返す．(WGS座標系，十進法ミリ度表記)
	 *
	 * @return
	 */
	public double getLatMiliDegWgs() {
		return convLatTo(Unit.MILI_DEG, Detum.WGS);
	}

	/**
	 * 経度を返す．(WGS座標系，十進法ミリ度表記)
	 *
	 * @return
	 */
	public double getLonMiliDegWGS() {
		return convLonTo(Unit.MILI_DEG, Detum.WGS);
	}

	/**
	 * 緯度を返す．(WGS座標系，DMS(ddd.mmss)表記)
	 *
	 * @return
	 */
	public double getLatDmsWGS() {
		return convLatTo(Unit.DMS, Detum.WGS);
	}

	/**
	 * 経度を返す．(WGS座標系，DMS(ddd.mmss)表記)
	 *
	 * @return
	 */
	public double getLonDmsWgs() {
		return convLonTo(Unit.DMS, Detum.WGS);
	}

	/**
	 * 緯度を返す．(WGS座標系，DMS(ddd.mmss)表記)
	 *
	 * @return
	 */
	public double getLatSecWgs() {
		return convLatTo(Unit.SECOND, Detum.WGS);
	}

	/**
	 * 経度を返す．(WGS座標系，DMS(ddd.mmss)表記)
	 *
	 * @return
	 */
	public double getLonSecWgs() {
		return convLonTo(Unit.SECOND, Detum.WGS);
	}

	private double convLatTo(Unit toUnit, Detum toDetum) {
		if (this.detum == toDetum) {
			return convTo(lat, toUnit);
		}
		double valOnToDetum = convLatTo(convTo(lat, Unit.DEG), convTo(lon, Unit.DEG), toDetum);
		return convTo(valOnToDetum, toUnit);
	}

	private double convLonTo(Unit toUnit, Detum toDetum) {
		if (this.detum == toDetum) {
			return convTo(lon, toUnit);
		}
		double valOnToDetum = convLonTo(convTo(lat, Unit.DEG), convTo(lon, Unit.DEG), toDetum);
		return convTo(valOnToDetum, toUnit);
	}

	private double convLatTo(double latDeg, double lonDeg, Detum toDetum) {
		switch (toDetum) {
		case TD:
			return Wgs2TD.toLatTD(latDeg, lonDeg);
		case WGS:
			return TD2Wgs.toLatWgs(latDeg, lonDeg);
		default:
			throw new RuntimeException();
		}
	}

	private double convLonTo(double latDeg, double lonDeg, Detum toDetum) {
		switch (toDetum) {
		case TD:
			return Wgs2TD.toLonTD(latDeg, lonDeg);
		case WGS:
			return TD2Wgs.toLonWgs(latDeg, lonDeg);
		default:
			throw new RuntimeException();
		}
	}

	private double convTo(double val, Unit toUnit) {
		if (this.unit == toUnit) {
			return val;
		}

		switch (this.unit) {
		case DEG:
			if (toUnit == Unit.MILI_DEG) {
				return val * 1000;
			} else if (toUnit == Unit.DMS) {
				return Deg2Dms.toDms(val);
			} else if (toUnit == Unit.SECOND) {
				return Dms2Sec.toSec(Deg2Dms.toDms(val));
			}
		case MILI_DEG:
			if (toUnit == Unit.DEG) {
				return val / 1000;
			} else if (toUnit == Unit.DMS) {
				return Deg2Dms.toDms(val / 1000);
			} else if (toUnit == Unit.SECOND) {
				return Dms2Sec.toSec(Deg2Dms.toDms(val / 1000));
			}
		case DMS:
			if (toUnit == Unit.DEG) {
				return Dms2Deg.toDeg(val);
			} else if (toUnit == Unit.MILI_DEG) {
				return Dms2Deg.toDeg(val) * 1000;
			} else if (toUnit == Unit.SECOND) {
				return Dms2Sec.toSec(val);
			}
		case SECOND:
			if (toUnit == Unit.DEG) {
				return Dms2Deg.toDeg(Sec2Dms.toDms(val));
			} else if (toUnit == Unit.MILI_DEG) {
				return Dms2Deg.toDeg(Sec2Dms.toDms(val)) * 1000;
			} else if (toUnit == Unit.DMS) {
				return Sec2Dms.toDms(val);
			}
		default:
			throw new RuntimeException();
		}
	}

	public Unit getUnit() {
		return this.unit;
	}

	public Detum getDetum() {
		return this.detum;
	}

}
