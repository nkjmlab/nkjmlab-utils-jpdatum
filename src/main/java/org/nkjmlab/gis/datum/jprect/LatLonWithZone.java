package org.nkjmlab.gis.datum.jprect;

import java.awt.Point;

import org.nkjmlab.gis.datum.Basis;
import org.nkjmlab.gis.datum.BasisConverter;
import org.nkjmlab.gis.datum.DistanceUnit;
import org.nkjmlab.gis.datum.DistanceUnitConverter;
import org.nkjmlab.gis.datum.LatLon;
import org.nkjmlab.gis.datum.LatLonPair;
import org.nkjmlab.gis.datum.jprect.JapanPlaneRectangular.ZoneId;
import org.nkjmlab.gis.datum.jprect.util.LatLon2XY;

/**
 * Japan Plane Rectangular 平面直角座標系（平成十四年国土交通省告示第九号）の系番号付きの緯度経度
 *
 * @author Yuu NAKAJIMA
 *
 */
public class LatLonWithZone extends LatLon {

	protected final ZoneId zoneId;

	/**
	 *
	 * @param zoneId
	 */
	public LatLonWithZone(LatLon latLon, ZoneId zoneId) {
		this(latLon.getLat(), latLon.getLon(), latLon.getUnit(), latLon.getDetum(), zoneId);
	}

	public LatLonWithZone(double lat, double lon, Unit unit, Detum detum, ZoneId zoneId) {
		super(lat, lon, unit, detum);
		this.zoneId = zoneId;

	}

	public LatLonWithZone(double lat, double lon, BasisWithZone basis) {
		this(lat, lon, basis.getUnit(), basis.getDetum(), basis.getZoneId());
	}

	public LatLonWithZone(LatLonPair latLon, Unit unit, Detum detum, ZoneId zoneId) {
		super(latLon, unit, detum);
		this.zoneId = zoneId;

	}

	public LatLonWithZone(LatLonPair latLon, BasisWithZone basis) {
		this(latLon, basis.getUnit(), basis.getDetum(), basis.getZoneId());
	}

	@Override
	public BasisWithZone getBasis() {
		return BasisWithZone.create(super.getBasis(), zoneId);
	}

	public ZoneId getZoneId() {
		return zoneId;
	}

	public double getX(DistanceUnit distanceUnit) {
		return LatLon2XY.toX(this, distanceUnit);
	}

	public double getY(DistanceUnit distanceUnit) {
		return LatLon2XY.toY(this, distanceUnit);
	}

	@Override
	public LatLonWithZone copyOn(Basis toBasis) {
		LatLon latLon = BasisConverter.changeBasis(lat, lon, getBasis(), toBasis);
		return new LatLonWithZone(latLon, zoneId);
	}

	/**
	 * このオブジェクトと引数のtoLatLonの距離を返す．
	 *
	 * @param toLatLon
	 * @return
	 */
	public double distance(LatLonWithZone toLatLon, DistanceUnit distanceUnit) {
		return DistanceUnitConverter.change(Math.sqrt(Math.pow(getX(distanceUnit) - toLatLon.getX(distanceUnit), 2)
				+ Math.pow(getY(distanceUnit) - toLatLon.getY(distanceUnit), 2)), DistanceUnit.M, distanceUnit);
	}

	public XYWithZone toXYWithZone() {
		return LatLon2XY.toXYWithZone(this);
	}

	public Point toScreenCoord(LatLonWithZone origin, Scale scale) {
		return this.toXYWithZone().toRelativeScreenCoord(origin.toXYWithZone(), scale);
	}

	public LatLonWithZone innerPoint(LatLonWithZone to, double ratio) {
		double diffLat = (to.getLat(getBasis()) - getLat(getBasis())) * ratio;
		double diffLon = (to.getLon(getBasis()) - getLon(getBasis())) * ratio;

		return new LatLonWithZone(getLat() + diffLat, getLon() + diffLon, getBasis());
	}
}
