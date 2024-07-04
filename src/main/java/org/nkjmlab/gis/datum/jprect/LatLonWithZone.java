package org.nkjmlab.gis.datum.jprect;

import java.awt.Point;
import org.nkjmlab.gis.datum.Basis;
import org.nkjmlab.gis.datum.DistanceUnit;
import org.nkjmlab.gis.datum.DistanceUnitConverter;
import org.nkjmlab.gis.datum.LatLon;
import org.nkjmlab.gis.datum.LatLonPair;
import org.nkjmlab.gis.datum.jprect.util.LatLonUtils;

/**
 * Japan Plane Rectangular 平面直角座標系（平成十四年国土交通省告示第九号）の系番号付きの緯度経度
 *
 * @author Yuu NAKAJIMA
 */
public class LatLonWithZone extends LatLon {

  public static LatLonWithZone createWithNearestOrigin(LatLon latLon) {
    ZoneId zoneId = JapanPlaneRectangular.getNearestOriginZoneId(latLon);
    return new LatLonWithZone(latLon, zoneId);
  }

  /**
   * @param latLon
   * @param zoneId 平面直角座標系（平成十四年国土交通省告示第九号）｜国土地理院 http://www.gsi.go.jp/LAW/heimencho.html
   *     にzoneId(系番号)と適用区域が書かれている．
   */
  public LatLonWithZone(LatLon latLon, ZoneId zoneId) {
    super(
        latLon.getLat(),
        latLon.getLon(),
        BasisWithZone.of(latLon.getUnit(), latLon.getDetum(), zoneId));
  }

  public LatLonWithZone(double lat, double lon, Unit unit, Detum detum, ZoneId zoneId) {
    super(lat, lon, BasisWithZone.of(unit, detum, zoneId));
  }

  public LatLonWithZone(double lat, double lon, BasisWithZone basis) {
    super(lat, lon, basis);
  }

  public LatLonWithZone(LatLonPair latLon, Unit unit, Detum detum, ZoneId zoneId) {
    super(latLon, BasisWithZone.of(unit, detum, zoneId));
  }

  public LatLonWithZone(LatLonPair latLon, BasisWithZone basis) {
    super(latLon, basis);
  }

  @Override
  public BasisWithZone getBasis() {
    return (BasisWithZone) basis;
  }

  public ZoneId getZoneId() {
    return getBasis().getZoneId();
  }

  public double getX(DistanceUnit distanceUnit) {
    return LatLonUtils.toX(this, distanceUnit);
  }

  public double getY(DistanceUnit distanceUnit) {
    return LatLonUtils.toY(this, distanceUnit);
  }

  /**
   * このオブジェクトと引数のtoLatLonの距離を返す．
   *
   * @param toLatLon
   * @return
   */
  public double distance(LatLonWithZone toLatLon, DistanceUnit distanceUnit) {
    return DistanceUnitConverter.change(
        Math.sqrt(
            Math.pow(getX(DistanceUnit.M) - toLatLon.getX(DistanceUnit.M), 2)
                + Math.pow(getY(DistanceUnit.M) - toLatLon.getY(DistanceUnit.M), 2)),
        DistanceUnit.M,
        distanceUnit);
  }

  public XYWithZone toXYWithZone() {
    return LatLonUtils.toXYWithZone(this);
  }

  public Point toScreenCoord(LatLonWithZone origin, ScreenSizeBasis screenSizeBasis) {
    return this.toXYWithZone().toRelativeScreenCoord(origin.toXYWithZone(), screenSizeBasis);
  }

  public LatLonWithZone innerPoint(LatLonWithZone to, double ratio) {
    double diffLat = (to.getLat(getBasis()) - getLat(getBasis())) * ratio;
    double diffLon = (to.getLon(getBasis()) - getLon(getBasis())) * ratio;

    return new LatLonWithZone(getLat() + diffLat, getLon() + diffLon, getBasis());
  }

  @Override
  public LatLonWithZone copyInto(Basis basis) {
    return new LatLonWithZone(getLat(basis), getLon(basis), BasisWithZone.of(basis, getZoneId()));
  }
}
