package org.nkjmlab.gis.datum;

import java.text.NumberFormat;
import java.util.Objects;
import org.nkjmlab.gis.datum.jprect.util.LatLonUtils;

/**
 * 緯度経度を表現するクラス．緯度経度は，作成時に指定された単位と測地系で保存される．呼び出し時に指定した単位および座標系で取り出すことができる．
 *
 * @author nkjm
 */
public class LatLon extends LatLonPair {

  protected final Basis basis;

  public enum Unit {
    DEGREE,
    MILLI_DEGREE,
    DMS,
    SECOND
  }

  public enum Detum {
    TOKYO,
    WGS84
  }

  public LatLon(double lat, double lon, Unit unit, Detum detum) {
    super(lat, lon);
    this.basis = Basis.of(unit, detum);
  }

  public LatLon(double lat, double lon, Basis basis) {
    super(lat, lon);
    this.basis = basis;
  }

  public LatLon(LatLonPair latLon, Unit unit, Detum detum) {
    super(latLon);
    this.basis = Basis.of(unit, detum);
  }

  public LatLon(LatLonPair latLon, Basis basis) {
    super(latLon);
    this.basis = basis;
  }

  public Unit getUnit() {
    return basis.getUnit();
  }

  public Detum getDetum() {
    return basis.getDetum();
  }

  public String toSimpleString() {
    NumberFormat format = NumberFormat.getInstance();
    format.setGroupingUsed(false);
    format.setMaximumFractionDigits(2);
    return format.format(lat)
        + ","
        + format.format(lon)
        + ","
        + basis.getUnit()
        + ","
        + basis.getDetum();
  }

  /**
   * 緯度を返す．単位と測地系は引数の値に従う．
   *
   * @param basis
   * @return
   */
  public double getLat(Basis basis) {
    return getLat(basis.getUnit(), basis.getDetum());
  }

  /**
   * 緯度を返す．単位と測地系は引数の値に従う．
   *
   * @param basis
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
    return BasisConverter.changeBasisOfLat(
        lat, lon, this.basis.getUnit(), this.basis.getDetum(), toUnit, toDetum);
  }

  /**
   * 経度を返す．単位と測地系は引数の値に従う．
   *
   * @return
   */
  public double getLon(Unit toUnit, Detum toDetum) {
    return BasisConverter.changeBasisOfLon(
        lat, lon, this.basis.getUnit(), this.basis.getDetum(), toUnit, toDetum);
  }

  /**
   * 経度を返す．単位は引数の値に，測地系はインスタンス生成時の値に従う．
   *
   * @return
   */
  public double getLon(Unit toUnit) {
    return BasisConverter.changeBasisOfLon(
        lat, lon, this.basis.getUnit(), this.basis.getDetum(), toUnit, this.basis.getDetum());
  }

  /**
   * 緯度を返す．単位は引数の値に，測地系はインスタンス生成時の値に従う．
   *
   * @return
   */
  public double getLat(Unit toUnit) {
    return BasisConverter.changeBasisOfLat(
        lat, lon, this.basis.getUnit(), this.basis.getDetum(), toUnit, this.basis.getDetum());
  }

  /**
   * 緯度を返す．単位はインスタンス生成時の値に，測地系は引数の値に従う．
   *
   * @return
   */
  public double getLat(Detum toDetum) {
    return BasisConverter.changeBasisOfLat(
        lat, lon, this.basis.getUnit(), this.basis.getDetum(), this.basis.getUnit(), toDetum);
  }

  /**
   * 経度を返す．単位と測地系は引数の値に従う．
   *
   * @return
   */
  public double getLon(Detum toDetum) {
    return BasisConverter.changeBasisOfLon(
        lat, lon, this.basis.getUnit(), this.basis.getDetum(), this.basis.getUnit(), toDetum);
  }

  public Basis getBasis() {
    return basis;
  }

  public LatLon copyInto(Basis basis) {
    return new LatLon(getLat(basis), getLon(basis), basis);
  }

  public Tile toTile(int zoom) {
    return LatLonUtils.toTile(this, zoom);
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + Objects.hash(basis);
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (!super.equals(obj)) return false;
    if (!(obj instanceof LatLon)) return false;
    LatLon other = (LatLon) obj;
    return Objects.equals(basis, other.basis);
  }

  @Override
  public String toString() {
    return "LatLon [basis=" + basis + ", lat=" + lat + ", lon=" + lon + "]";
  }
}
