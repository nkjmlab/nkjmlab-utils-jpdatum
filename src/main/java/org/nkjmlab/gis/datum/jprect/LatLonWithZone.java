package org.nkjmlab.gis.datum.jprect;

import java.security.InvalidParameterException;

import org.nkjmlab.gis.datum.LatLon;
import org.nkjmlab.gis.datum.LatLonBasis;
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

	protected final int zoneId;

	/**
	 *
	 * @param zoneId
	 */
	public LatLonWithZone(LatLon latLon, int zoneId) {
		this(latLon.getLat(), latLon.getLon(), latLon.getUnit(),
				latLon.getDetum(), zoneId);
	}

	public LatLonWithZone(double lat, double lon, Unit unit, Detum detum,
			int zoneId) {
		super(lat, lon, unit, detum);
		this.zoneId = zoneId;

		if (20 <= zoneId) {
			String s = "zoneId=" + zoneId
					+ " is invalid. The zone id range from 1 to 19.";
			System.err.println(s);
			throw new InvalidParameterException(s);
		}

	}

	public LatLonWithZone(double lat, double lon, LatLonBasisWithZone basis) {
		this(lat, lon, basis.getUnit(), basis.getDetum(), basis.getZoneId());
	}

	public int getZoneId() {
		return zoneId;
	}

	public double getX() {
		return LatLon2XY.toX(this.getLat(basis), this.getLon(basis), zoneId);
	}

	public double getY() {
		return LatLon2XY.toY(this.getLat(basis), this.getLon(basis), zoneId);
	}

}
