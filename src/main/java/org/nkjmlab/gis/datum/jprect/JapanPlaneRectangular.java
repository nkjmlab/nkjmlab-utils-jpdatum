package org.nkjmlab.gis.datum.jprect;

import java.util.Arrays;
import java.util.List;
import org.nkjmlab.gis.datum.Basis;
import org.nkjmlab.gis.datum.DistanceUnit;
import org.nkjmlab.gis.datum.LatLon;
import org.nkjmlab.gis.datum.LatLon.Detum;
import org.nkjmlab.gis.datum.LatLon.Unit;

/**
 *
 * Japan Plane Rectangular 平面直角座標系（平成十四年国土交通省告示第九号） http://www.gsi.go.jp/LAW/heimencho.html
 * にzoneId(系番号)と適用区域が書かれている．
 *
 * 測量法（昭和二十四年法律第百八十八号。以下「法」という。)第十一条第一項第一号の規定を実施するため、 直角座標で位置を表示する場合の平面直角座標系を次のように定める。
 *
 * http://vldb.gsi.go.jp/sokuchi/patchjgd/download/Help/jpc/jpcmap1_19.htm
 *
 * @author Yuu NAKAJIMA
 *
 */
public class JapanPlaneRectangular {

  // UNIT.DEGREE, Detum.WGS84
  private static final double[] lats = {33.00000, 33.00000, 36.00000, 33.00000, 36.00000, 36.00000,
      36.00000, 36.00000, 36.00000, 40.00000, 44.00000, 44.00000, 44.00000, 26.00000, 26.00000,
      26.00000, 26.00000, 20.00000, 26.00000};

  // UNIT.DEGREE, Detum.WGS84
  private static final double[] lons =
      {129.5000, 131.00000, 132.166666666666669, 133.50000, 134.333333333333334, 136.00000,
          137.166666666666666, 138.5, 139.833333333333334, 140.833333333333333, 140.25000,
          142.25000, 144.25000, 142.00000, 127.50000, 124.00000, 131.00000, 136.00000, 154.00000};

  private static final LatLonWithZone[] tokyos =
      {new LatLonWithZone(lats[0], lons[0], Unit.DEGREE, Detum.TOKYO, ZoneId._1),
          new LatLonWithZone(lats[1], lons[1], Unit.DEGREE, Detum.TOKYO, ZoneId._2),
          new LatLonWithZone(lats[2], lons[2], Unit.DEGREE, Detum.TOKYO, ZoneId._3),
          new LatLonWithZone(lats[3], lons[3], Unit.DEGREE, Detum.TOKYO, ZoneId._4),
          new LatLonWithZone(lats[4], lons[4], Unit.DEGREE, Detum.TOKYO, ZoneId._5),
          new LatLonWithZone(lats[5], lons[5], Unit.DEGREE, Detum.TOKYO, ZoneId._6),
          new LatLonWithZone(lats[6], lons[6], Unit.DEGREE, Detum.TOKYO, ZoneId._7),
          new LatLonWithZone(lats[7], lons[7], Unit.DEGREE, Detum.TOKYO, ZoneId._8),
          new LatLonWithZone(lats[8], lons[8], Unit.DEGREE, Detum.TOKYO, ZoneId._9),
          new LatLonWithZone(lats[9], lons[9], Unit.DEGREE, Detum.TOKYO, ZoneId._10),
          new LatLonWithZone(lats[10], lons[10], Unit.DEGREE, Detum.TOKYO, ZoneId._11),
          new LatLonWithZone(lats[11], lons[11], Unit.DEGREE, Detum.TOKYO, ZoneId._12),
          new LatLonWithZone(lats[12], lons[12], Unit.DEGREE, Detum.TOKYO, ZoneId._13),
          new LatLonWithZone(lats[13], lons[13], Unit.DEGREE, Detum.TOKYO, ZoneId._14),
          new LatLonWithZone(lats[14], lons[14], Unit.DEGREE, Detum.TOKYO, ZoneId._15),
          new LatLonWithZone(lats[15], lons[15], Unit.DEGREE, Detum.TOKYO, ZoneId._16),
          new LatLonWithZone(lats[16], lons[16], Unit.DEGREE, Detum.TOKYO, ZoneId._17),
          new LatLonWithZone(lats[17], lons[17], Unit.DEGREE, Detum.TOKYO, ZoneId._18),
          new LatLonWithZone(lats[18], lons[18], Unit.DEGREE, Detum.TOKYO, ZoneId._19)};

  private static final LatLonWithZone[] wgs84s =
      {new LatLonWithZone(lats[0], lons[0], Unit.DEGREE, Detum.WGS84, ZoneId._1),
          new LatLonWithZone(lats[1], lons[1], Unit.DEGREE, Detum.WGS84, ZoneId._2),
          new LatLonWithZone(lats[2], lons[2], Unit.DEGREE, Detum.WGS84, ZoneId._3),
          new LatLonWithZone(lats[3], lons[3], Unit.DEGREE, Detum.WGS84, ZoneId._4),
          new LatLonWithZone(lats[4], lons[4], Unit.DEGREE, Detum.WGS84, ZoneId._5),
          new LatLonWithZone(lats[5], lons[5], Unit.DEGREE, Detum.WGS84, ZoneId._6),
          new LatLonWithZone(lats[6], lons[6], Unit.DEGREE, Detum.WGS84, ZoneId._7),
          new LatLonWithZone(lats[7], lons[7], Unit.DEGREE, Detum.WGS84, ZoneId._8),
          new LatLonWithZone(lats[8], lons[8], Unit.DEGREE, Detum.WGS84, ZoneId._9),
          new LatLonWithZone(lats[9], lons[9], Unit.DEGREE, Detum.WGS84, ZoneId._10),
          new LatLonWithZone(lats[10], lons[10], Unit.DEGREE, Detum.WGS84, ZoneId._11),
          new LatLonWithZone(lats[11], lons[11], Unit.DEGREE, Detum.WGS84, ZoneId._12),
          new LatLonWithZone(lats[12], lons[12], Unit.DEGREE, Detum.WGS84, ZoneId._13),
          new LatLonWithZone(lats[13], lons[13], Unit.DEGREE, Detum.WGS84, ZoneId._14),
          new LatLonWithZone(lats[14], lons[14], Unit.DEGREE, Detum.WGS84, ZoneId._15),
          new LatLonWithZone(lats[15], lons[15], Unit.DEGREE, Detum.WGS84, ZoneId._16),
          new LatLonWithZone(lats[16], lons[16], Unit.DEGREE, Detum.WGS84, ZoneId._17),
          new LatLonWithZone(lats[17], lons[17], Unit.DEGREE, Detum.WGS84, ZoneId._18),
          new LatLonWithZone(lats[18], lons[18], Unit.DEGREE, Detum.WGS84, ZoneId._19)};

  private static final List<String> ZONE_14_CITIES =
      Arrays.asList("小笠原村", "聟島列島", "父島列島", "母島列島", "硫黄島");

  private static final List<String> ZONE_11_CITIES =
      Arrays.asList("小樽市", "函館市", "伊達市", "北斗市", "豊浦町", "壮瞥町", "洞爺湖町", "奥尻島", "渡島大島", "松前小島");

  private static final List<String> ZONE_13_CITIES =
      Arrays.asList("北見市", "帯広市", "釧路市", "網走市", "根室市", "美幌町", "津別町", "斜里町", "清里町", "小清水町", "訓子府町",
          "置戸町", "佐呂間町", "大空町", "択捉島", "国後島", "色丹島", "歯舞群島");

  private static final List<String> ZONE_16_CITIES = Arrays.asList("平良市", "石垣市", "城辺町", "下地町",
      "上野村", "伊良部町", "多良間村", "竹富町", "与那国町", "宮古諸島", "多良間島", "水納島", "与那国島", "石垣島", "竹富島", "西表島");

  private static final List<String> ZONE_17_CITIES = Arrays.asList("南大東村", "北大東村", "北大東島", "南大東島");

  public static final LatLonWithZone getOrigin(ZoneId zoneId, Detum detum) {
    switch (detum) {
      case TOKYO:
        return tokyos[zoneId.getIndex()];
      case WGS84:
        return wgs84s[zoneId.getIndex()];
      default:
        throw new IllegalArgumentException();
    }
  }

  public static void main(String[] args) {
    System.out.println(getNearestOriginZoneId(new LatLon(35.010348, 135.768738, Basis.DEGREE_WGS)));
  }

  public static ZoneId getNearestOriginZoneId(LatLon latLon) {
    LatLonWithZone l = new LatLonWithZone(latLon, ZoneId._7);
    int minIndex = 0;
    double minVal = Double.MAX_VALUE;
    for (int i = 0; i < wgs84s.length; i++) {
      double dist = new LatLonWithZone(wgs84s[i], ZoneId._7).distance(l, DistanceUnit.M);
      if (dist < minVal) {
        minIndex = i;
        minVal = dist;
      }
    }
    ZoneId z = ZoneId.get(minIndex);
    return z;
  }

  public static ZoneId estimateZoneIdBasedOnAddress(String state, String address) {
    switch (state) {
      case "長崎県":
      case "鹿児島県":
        return ZoneId._1;
      case "福岡県":
      case "佐賀県":
      case "熊本県":
      case "大分県":
      case "宮崎県":
        return ZoneId._2;
      case "山口県":
      case "島根県":
      case "広島県":
        return ZoneId._3;
      case "香川県":
      case "愛媛県":
      case "徳島県":
      case "高知県":
        return ZoneId._4;
      case "兵庫県":
      case "鳥取県":
      case "岡山県":
        return ZoneId._5;
      case "京都府":
      case "大阪府":
      case "福井県":
      case "滋賀県":
      case "三重県":
      case "奈良県":
      case "和歌山県":
        return ZoneId._6;
      case "石川県":
      case "富山県":
      case "岐阜県":
      case "愛知県":
        return ZoneId._7;
      case "新潟県":
      case "長野県":
      case "山梨県":
      case "静岡県":
        return ZoneId._8;
      case "東京都":
        if (address.contains("沖ノ鳥島")) {
          return ZoneId._18;
        }
        if (address.contains("南鳥島")) {
          return ZoneId._19;
        }

        for (String city : ZONE_14_CITIES) {
          if (address.contains(city)) {
            return ZoneId._14;
          }
        }
        return ZoneId._9;
      case "福島県":
      case "栃木県":
      case "茨城県":
      case "埼玉県":
      case "千葉県":
      case "群馬県":
      case "神奈川県":
        return ZoneId._9;
      case "青森県":
      case "秋田県":
      case "山形県":
      case "岩手県":
      case "宮城県":
        return ZoneId._10;
      case "北海道":
        for (String city : ZONE_11_CITIES) {
          if (address.contains(city)) {
            return ZoneId._11;
          }
        }
        for (String city : ZONE_13_CITIES) {
          if (address.contains(city)) {
            return ZoneId._13;
          }
        }
        return ZoneId._12;
      case "沖縄県":
        for (String city : ZONE_16_CITIES) {
          if (address.contains(city)) {
            return ZoneId._16;
          }
        }

        for (String city : ZONE_17_CITIES) {
          if (address.contains(city)) {
            return ZoneId._17;
          }
        }
        return ZoneId._15;

      default:
        throw new IllegalArgumentException("適切なZoneIdを見つけられませんでした．");
    }
  }

}
