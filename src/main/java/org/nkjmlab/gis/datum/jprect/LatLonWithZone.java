package org.nkjmlab.gis.datum.jprect;

import org.nkjmlab.gis.datum.LatLon;
import org.nkjmlab.gis.datum.LatLonBasis;
import org.nkjmlab.gis.datum.jprect.JapanPlaneRectangular.ZoneId;
import org.nkjmlab.gis.datum.jprect.util.LatLon2XY;

/**
 * Japan Plane Rectangular 平面直角座標系（平成十四年国土交通省告示第九号）の系番号付きの緯度経度
 *
 * @author Yuu NAKAJIMA
 *
 */
public class LatLonWithZone extends LatLon {

	protected static LatLonBasis basis = new LatLonBasis(Unit.DEGREE,
			Detum.TOKYO);

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

	public LatLonWithZone(double lat, double lon, LatLonBasisWithZone basis) {
		this(lat, lon, basis.getUnit(), basis.getDetum(), basis.getZoneId());
	}

	public ZoneId getZoneId() {
		return zoneId;
	}

	public double getX() {
		return LatLon2XY.toX(this.getLat(basis), this.getLon(basis), zoneId);
	}

	public double getY() {
		return LatLon2XY.toY(this.getLat(basis), this.getLon(basis), zoneId);
	}

}
