package org.nkjmlab.gis.datum;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

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
		return BasisConverter.changeBasisOfLat(lat, lon, this.unit, this.detum,
				toUnit, toDetum);
	}

	/**
	 * 経度を返す．単位と測地系は引数の値に従う．
	 *
	 * @return
	 */
	public double getLon(Unit toUnit, Detum toDetum) {
		return BasisConverter.changeBasisOfLon(lat, lon, this.unit, this.detum,
				toUnit, toDetum);
	}

	/**
	 * 経度を返す．単位は引数の値に，測地系はインスタンス生成時の値に従う．
	 *
	 * @return
	 */
	public double getLon(Unit toUnit) {
		return BasisConverter.changeBasisOfLon(lat, lon, this.unit, this.detum,
				toUnit, this.detum);
	}

	/**
	 * 緯度を返す．単位は引数の値に，測地系はインスタンス生成時の値に従う．
	 *
	 * @return
	 */
	public double getLat(Unit toUnit) {
		return BasisConverter.changeBasisOfLat(lat, lon, this.unit, this.detum,
				toUnit, this.detum);
	}

	/**
	 * 緯度を返す．単位はインスタンス生成時の値に，測地系は引数の値に従う．
	 *
	 * @return
	 */
	public double getLat(Detum toDetum) {
		return BasisConverter.changeBasisOfLat(lat, lon, this.unit, this.detum,
				this.unit, toDetum);
	}

	/**
	 * 経度を返す．単位と測地系は引数の値に従う．
	 *
	 * @return
	 */
	public double getLon(Detum toDetum) {
		return BasisConverter.changeBasisOfLon(lat, lon, this.unit, this.detum,
				this.unit, toDetum);
	}

}
