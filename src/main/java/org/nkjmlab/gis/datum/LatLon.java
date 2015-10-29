package org.nkjmlab.gis.datum;

import java.text.NumberFormat;

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
		DEGREE, MILLI_DEGREE, DMS, SECOND
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

	public LatLon(double lat, double lon, Basis basis) {
		this(lat, lon, basis.getUnit(), basis.getDetum());
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

	public String toSimpleString() {
		NumberFormat format = NumberFormat.getInstance();
		format.setGroupingUsed(false);
		format.setMaximumFractionDigits(2);
		return format.format(lat) + "," + format.format(lon) + "," + unit + ","
				+ detum;
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
	public double getLat(Basis basis) {
		return getLat(basis.getUnit(), basis.getDetum());
	}

	/**
	 * 緯度を返す．単位と測地系は引数の値に従う．
	 *
	 * @param basis
	 *
	 * @return
	 */
	public double getLon(Basis basis) {
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

	public LatLon copyOn(Basis toBasis) {
		return BasisConverter.changeBasis(lat, lon, getBasis(), toBasis);
	}

	public Basis getBasis() {
		return new Basis(unit, detum);
	}

	/**
	 * このオブジェクトと引数のtoLatLonの距離を返す．単位と測地系は，このオブジェクトに従う．
	 *
	 * @param toLatLon
	 * @return
	 */
	public double distance(LatLon toLatLon) {
		return Math.abs(lat - toLatLon.getLat(getBasis()) + lon
				- toLatLon.getLon(getBasis()));
	}

	/**
	 * このオブジェクトと引数のtoLatLonの距離を返す．単位は引数に従う．測地系は，このオブジェクトに従う．
	 *
	 * @param toLatLon
	 * @return
	 */
	public double distance(LatLon toLatLon, Unit toUnit) {
		return LatLonUnitConverter.change(distance(toLatLon), getUnit(),
				toUnit);
	}

}
