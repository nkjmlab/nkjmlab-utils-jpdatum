package org.nkjmlab.gis.datum.jprect;

import org.nkjmlab.gis.datum.LatLon;
import org.nkjmlab.gis.datum.jprect.helper.XY2LatLonHelper;
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
 */
public class XY2LatLon {

	/**
	 *
	 * @param xy
	 *            平面直角座標系の系番号付きの平面直角座標系XY
	 * @return 平面直角座標系の系番号付きの緯度経度
	 */
	public static LatLonWithZone toLatLon(XYWithZone xy) {
		double x = xy.getX();
		double y = xy.getY();
		int zoneId = xy.zoneId;
		double latDeg = XY2LatLon.toLat(x, y, zoneId);
		double lonDeg = XY2LatLon.toLon(x, y, zoneId);
		return new LatLonWithZone(LatLon.create(latDeg, lonDeg), zoneId);
	}

	/**
	 * @param x
	 * @param y
	 * @param zoneId
	 *            平面直角座標系（平成十四年国土交通省告示第九号）｜国土地理院
	 *            http://www.gsi.go.jp/LAW/heimencho.html
	 *            にzoneId(系番号)と適用区域が書かれている．
	 * @return 日本測地系の緯度の十進法(degree: ddd.dddd)表記
	 */
	public static double toLat(double x, double y, int zoneId) {
		LatLonWithZone origin = JapanPlaneRectangular.getOrigin(zoneId);
		return XY2LatLonHelper.toLatitude(x, y, Deg2Dms.toDms(origin.getLat()),
				Deg2Dms.toDms(origin.getLon()));
	}

	/**
	 * @param x
	 * @param y
	 * @param zoneId
	 *            平面直角座標系（平成十四年国土交通省告示第九号）｜国土地理院
	 *            http://www.gsi.go.jp/LAW/heimencho.html
	 *            にzoneId(系番号)と適用区域が書かれている．
	 * @return 日本測地系の経度度の十進法(degree: ddd.dddd)表記
	 */
	public static double toLon(double x, double y, int zoneId) {
		LatLonWithZone origin = JapanPlaneRectangular.getOrigin(zoneId);
		return XY2LatLonHelper.toLongitude(x, y, Deg2Dms.toDms(origin.getLat()),
				Deg2Dms.toDms(origin.getLon()));
	}

}
