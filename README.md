nkjmlab-utils-jpdatum
======
[![Maven Central](https://img.shields.io/maven-central/v/org.nkjmlab/nkjmlab-utils-jpdatum.svg)](http://mvnrepository.com/artifact/org.nkjmlab/nkjmlab-utils-jpdatum) [![javadoc](https://javadoc.io/badge2/org.nkjmlab/nkjmlab-utils/javadoc.svg)](https://javadoc.io/doc/org.nkjmlab/nkjmlab-utils-jpdatum) [![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

日本測地系(Tokyo Datum)または世界測地系(WGS84)に基づく緯度経度と，日本平面直角座標系(Japan Plane Rectangular) に基づくXY座標を相互に変換するパッケージです．地理に関する用語には間違いがあるかもしれませんので，注意して下さい．Java 11 以降で動作します．

## 使用方法
最新版が [Maven Central Repository](https://mvnrepository.com/artifact/org.nkjmlab/nkjmlab-utils-jpdatum)に公開されています．pom.xmlに以下を加えることで利用できます．

```xml
 <dependency>
   <groupId>org.nkjmlab</groupId>
   <artifactId>nkjmlab-utils-jpdatum</artifactId>
   <version>0.9.3</version>
 </dependency>
```

## Sample codes
```java
import org.nkjmlab.gis.datum.LatLon.Detum;
import org.nkjmlab.gis.datum.LatLon.Unit;
import org.nkjmlab.gis.datum.jprect.JapanPlaneRectangular.ZoneId;

public class Sample {
    public static void main(String[] args){

        LatLonWithZone tokyoLatLon = new LatLonWithZone(36.103774791666666, 140.08785504166664,
                BasisWithZone.of(Unit.DEGREE, Detum.TOKYO, ZoneId._9));

        XYWithZone tokyoXy = tokyoLatLon.toXYWithZone();
        System.out.println(tokyoXy);
        //=> XYWithZone[basis=BasisWithZone[zoneId=_9,unit=DEGREE,detum=TOKYO],
        //              x=11542.461079999104,y=22913.50559491415,distanceUnit=M]


        LatLonWithZone rTokyoLatLon = tokyoXy.toLatLonWithZone();
        System.out.println(rTokyoLatLon);
        //=> LatLonWithZone[zoneId=_9,unit=DEGREE,detum=TOKYO,
        //                  lat=36.1037814806522,lon=140.08311062649173]
  }
}
```

### 緯度経度から直角座標系への変換例
```
LatLon：36.103774791666666, 140.08785504166664
TOKYO(expected)：x=11542.4611,         y=22913.5056
TOKYO(actural) ：x=11542.461079999104, y=22913.50559491415
WGS84(expected)：x=11543.6883,         y=22916.2436
WGS84(actual)  ：x=11543.19816659062,  y=22916.76434819815
```

### 直角座標系から緯度経度への変換例
```
x=11542.4611, y=22913.5056
TOKYO (expected)：lat=36.103774791666666, lon=140.08785504166664
TOKYO (actual)  ：lat=36.10378148083239,  lon=140.08311062654883
x=11543.6883, y=22916.2436
WGS84 (expected)：lat=36.103774791666666, lon=140.08785504166664
WGS84 (actual)  ：lat=36.10378578916159,  lon=140.0878854906632
```

## ライセンス
Apache License Version 2.0

## 謝辞
本ソフトウエアの平面直角座標-緯度経度変換の計算部分は，株式会社ジャスミンソフト (https://www.jasminesoft.co.jp/) が Apache License 2.0 に基づいて公開している[平面直角座標-緯度経度変換クラスライブラリ](https://web.archive.org/web/20161003012815/http://www.jasminesoft.co.jp/product/scalc.html) を参考に実装しました．
