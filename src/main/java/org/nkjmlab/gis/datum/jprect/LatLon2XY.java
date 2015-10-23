package org.nkjmlab.gis.datum.jprect;

import org.nkjmlab.gis.datum.jprect.helper.LatLon2XYHelper;
import org.nkjmlab.gis.datum.util.Deg2Dms;

/**
 * このクラスはジャスミンソフトがApache License 2.0に基づいて公開しているscalcに由来します．
 *
 * scalcは，琉球大学工学部情報工学科 宮城研究室の成果物 を，ジャスミンソフトが整理・統合したものです． 再利用を快諾
 * して頂いた宮城隼夫教授以下，宮城研究室のスタッフにこの場を借りて感謝致します．
 *
 * @author Miho Nagata
 * @author Yoshinori Nie
 * @author Yuu NAKAJIMA
 *
 */
public class LatLon2XY {

	/**
	 * 平面直角座標系の系番号付きの緯度経度(TD座標系，十進法度表記)を，平面直角座標系のXYに変換
	 *
	 * @param latLon
	 *            平面直角座標系の系番号付きの緯度経度(TD座標系，十進法度表記)
	 * @return 平面直角座標系の系番号付きの平面直角座標系XY
	 */
	public static XYWithZone toXY(LatLonWithZone latLon) {
		double latDegTD = latLon.getLat();
		double lonDegTD = latLon.getLon();
		int zoneId = latLon.zoneId;
		double x = LatLon2XY.toX(latDegTD, lonDegTD, zoneId);
		double y = LatLon2XY.toY(latDegTD, lonDegTD, zoneId);
		return new XYWithZone(x, y, zoneId);
	}

	/**
	 *
	 * @param latDegTD
	 * @param lonDegTD
	 * @param zoneId
	 *            平面直角座標系（平成十四年国土交通省告示第九号）｜国土地理院
	 *            http://www.gsi.go.jp/LAW/heimencho.html
	 *            にzoneId(系番号)と適用区域が書かれている．
	 * @return
	 */
	public static double toX(double latDegTD, double lonDegTD, int zoneId) {
		LatLonWithZone origin = JapanPlaneRectangular.getOrigin(zoneId);
		return LatLon2XYHelper.toXCoord(Deg2Dms.toDms(latDegTD),
				Deg2Dms.toDms(lonDegTD), Deg2Dms.toDms(origin.getLat()),
				Deg2Dms.toDms(origin.getLon()));
	}

	/**
	 *
	 * @param latDegTD
	 * @param lonDegTD
	 * @param zoneId
	 *            平面直角座標系（平成十四年国土交通省告示第九号）｜国土地理院
	 *            http://www.gsi.go.jp/LAW/heimencho.html
	 *            にzoneId(系番号)と適用区域が書かれている．
	 * @return
	 */
	public static double toY(double latDegTD, double lonDegTD, int zoneId) {
		LatLonWithZone origin = JapanPlaneRectangular.getOrigin(zoneId);
		return LatLon2XYHelper.toYCoord(Deg2Dms.toDms(latDegTD),
				Deg2Dms.toDms(lonDegTD), Deg2Dms.toDms(origin.getLat()),
				Deg2Dms.toDms(origin.getLon()));
	}

}
