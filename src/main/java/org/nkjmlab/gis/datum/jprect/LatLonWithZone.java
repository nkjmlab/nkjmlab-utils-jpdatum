package org.nkjmlab.gis.datum.jprect;

import org.nkjmlab.gis.datum.Basis;
import org.nkjmlab.gis.datum.BasisConverter;
import org.nkjmlab.gis.datum.LatLon;
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
		this(latLon.getLat(), latLon.getLon(), latLon.getUnit(),
				latLon.getDetum(), zoneId);
	}

	public LatLonWithZone(double lat, double lon, Unit unit, Detum detum,
			ZoneId zoneId) {
		super(lat, lon, unit, detum);
		this.zoneId = zoneId;

	}

	public LatLonWithZone(double lat, double lon, BasisWithZone basis) {
		this(lat, lon, basis.getUnit(), basis.getDetum(), basis.getZoneId());
	}

	@Override
	public BasisWithZone getBasis() {
		return new BasisWithZone(super.getBasis(), zoneId);
	}

	public ZoneId getZoneId() {
		return zoneId;
	}

	public double getX() {
		Basis basis = new Basis(Unit.DEGREE, Detum.TOKYO);
		return LatLon2XY.toX(this.getLat(basis), this.getLon(basis), zoneId);
	}

	public double getY() {
		Basis basis = new Basis(Unit.DEGREE, Detum.TOKYO);
		return LatLon2XY.toY(this.getLat(basis), this.getLon(basis), zoneId);
	}

	@Override
	public LatLonWithZone copyOn(Basis toBasis) {
		LatLon latLon = BasisConverter.changeBasis(lat, lon, getBasis(),
				toBasis);
		return new LatLonWithZone(latLon, zoneId);
	}
}
