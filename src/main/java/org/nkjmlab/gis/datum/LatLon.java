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
 * 緯度経度を表現するクラス．作成時に，内部的には緯度 (TD座標系，十進法度表記)と 緯度 (TD座標系，十進法度表記)に変換して格納される．
 * 呼び出し時に指定した単位および座標系で取り出すことができる．
 *
 * WGSとTDの間の変換の誤差が大きいので，XY平面に変換する場合は，インスタンスを作る際にTD座標系の値を入れた方が良い．同様の理由で，
 * 内部をWGSで持たせることを諦めた．
 *
 * @author nkjm
 *
 */
public class LatLon {

	protected final double latDegTD;
	protected final double lonDegTD;

	public enum Unit {
		DEG, MILI_DEG, DMS, SECOND
	}

	public enum Detum {
		TD, WGS
	}

	/**
	 * WGSとTDの間の変換の誤差が大きいので，XY平面に変換する場合は，インスタンスを作る際にTD座標系の値を入れた方が良い．
	 *
	 * @param latDeg
	 * @param lonDeg
	 * @param detum
	 * @return
	 */
	public static LatLon create(double latDeg, double lonDeg, Detum detum) {
		return create(latDeg, lonDeg, Unit.DEG, detum);
	}

	public static LatLon create(double latTD, double lonTD, Unit unit) {
		return create(latTD, lonTD, unit, Detum.TD);
	}

	/**
	 * WGSとTDの間の変換の誤差が大きいので，XY平面に変換する場合は，インスタンスを作る際にTD座標系の値を入れた方が良い．
	 *
	 * @param latDeg
	 * @param lonDeg
	 * @param detum
	 * @return
	 */
	public static LatLon create(double lat, double lon, Unit unit,
			Detum detum) {

		double latDeg = 0;
		double lonDeg = 0;

		switch (unit) {
		case DEG:
			latDeg = lat;
			lonDeg = lon;
			break;
		case DMS:
			latDeg = Dms2Deg.toDeg(lat);
			lonDeg = Dms2Deg.toDeg(lon);
		case MILI_DEG:
			latDeg = lat * 1000;
			lonDeg = lon * 1000;
		case SECOND:
			latDeg = Sec2Dms.toDms(lat);
			lonDeg = Sec2Dms.toDms(lon);
		default:
			throw new RuntimeException();
		}

		double latDegTD = 0;
		double lonDegTD = 0;

		switch (detum) {
		case TD:
			latDegTD = latDeg;
			lonDegTD = latDeg;
			break;
		case WGS:
			latDegTD = Wgs2TD.toLatTD(latDeg, lonDeg);
			lonDegTD = Wgs2TD.toLonTD(latDeg, lonDeg);
			break;
		default:
			throw new RuntimeException();
		}

		return new LatLon(latDegTD, lonDegTD);
	}

	/**
	 * @param latDegTD
	 *            緯度(TD座標系，十進法度表記)
	 * @param lonDegTD
	 *            経度(TD座標系，十進法度表記)
	 * @return
	 */
	public static LatLon create(double latDegTD, double lonDegTD) {
		return new LatLon(latDegTD, lonDegTD);
	}

	protected LatLon(double latDegTD, double lonDegTD) {
		this.latDegTD = latDegTD;
		this.lonDegTD = lonDegTD;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof LatLon)) {
			return false;
		}
		LatLon l = (LatLon) obj;
		return this.latDegTD == l.latDegTD && this.lonDegTD == l.lonDegTD;
	}

	@Override
	public int hashCode() {
		return (int) (latDegTD + lonDegTD);
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.SHORT_PREFIX_STYLE);
	}

	/**
	 * 緯度を返す．(TD座標系，十進法度(ddd.ddd)表記)
	 *
	 * @return
	 */
	public double getLat() {
		return getLatDegTD();
	}

	/**
	 * 経度を返す．(TD座標系，十進法度(ddd.ddd)表記)
	 *
	 * @return
	 */
	public double getLon() {
		return getLonDegTD();
	}

	/**
	 * 緯度を返す．(TD座標系，十進法度(ddd.ddd)表記)
	 *
	 * @return
	 */
	public double getLatDegTD() {
		return latDegTD;
	}

	/**
	 * 経度を返す．(TD座標系，十進法度(ddd.ddd)表記)
	 *
	 * @return
	 */
	public double getLonDegTD() {
		return lonDegTD;
	}

	/**
	 * 緯度を返す．(TD座標系，十進法ミリ度表記)
	 *
	 * @return
	 */
	public double getLatMiliDegTD() {
		return getLatDegTD() * 1000;
	}

	/**
	 * 経度を返す．(TD座標系，十進法ミリ度表記)
	 *
	 * @return
	 */
	public double getLonMiliDegTD() {
		return getLonDegTD() * 1000;
	}

	/**
	 * 緯度を返す．(TD座標系，DMS(ddd.mmss)表記)
	 *
	 * @return
	 */
	public double getLatDmsTD() {
		return Deg2Dms.toDms(getLatDegTD());
	}

	/**
	 * 経度を返す．(TD座標系，DMS(ddd.mmss)表記)
	 *
	 * @return
	 */
	public double getLonDmsTD() {
		return Deg2Dms.toDms(getLonDegTD());
	}

	/**
	 * 緯度を返す．(TD座標系，DMS(ddd.mmss)表記)
	 *
	 * @return
	 */
	public double getLatSecTD() {
		return Dms2Sec.toSec(getLatDmsTD());
	}

	/**
	 * 経度を返す．(TD座標系，DMS(ddd.mmss)表記)
	 *
	 * @return
	 */
	public double getLonSecTD() {
		return Dms2Sec.toSec(getLonDmsTD());
	}

	/**
	 * 緯度を返す．(WGS座標系，十進法度(ddd.ddd)表記)
	 *
	 * @return
	 */
	public double getLatDegWgs() {
		return TD2Wgs.toLatWgs(latDegTD, lonDegTD);
	}

	/**
	 * 経度を返す．(WGS座標系，十進法度(ddd.ddd)表記)
	 *
	 * @return
	 */
	public double getLonDegWgs() {
		return TD2Wgs.toLonWgs(latDegTD, lonDegTD);
	}

	/**
	 * 緯度を返す．(WGS座標系，十進法ミリ度表記)
	 *
	 * @return
	 */
	public double getLatMiliDegWgs() {
		return getLatDegWgs() * 1000;
	}

	/**
	 * 経度を返す．(WGS座標系，十進法ミリ度表記)
	 *
	 * @return
	 */
	public double getLonMiliDegWGS() {
		return getLonDegWgs() * 1000;
	}

	/**
	 * 緯度を返す．(WGS座標系，DMS(ddd.mmss)表記)
	 *
	 * @return
	 */
	public double getLatDmsWGS() {
		return Deg2Dms.toDms(getLatDegWgs());
	}

	/**
	 * 経度を返す．(WGS座標系，DMS(ddd.mmss)表記)
	 *
	 * @return
	 */
	public double getLonDmsWgs() {
		return Deg2Dms.toDms(getLonDegWgs());
	}

	/**
	 * 緯度を返す．(WGS座標系，DMS(ddd.mmss)表記)
	 *
	 * @return
	 */
	public double getLatSecWgs() {
		return Dms2Sec.toSec(getLatDmsWGS());
	}

	/**
	 * 経度を返す．(WGS座標系，DMS(ddd.mmss)表記)
	 *
	 * @return
	 */
	public double getLonSecWgs() {
		return Dms2Sec.toSec(getLonDmsWgs());
	}

}
