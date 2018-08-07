
# LovelyView
### A view that combines images and texts, allowing you to save time by developing a list item like  'images + text' follow the display order of left, center, and right.


### [中文](https://github.com/samlss/LovelyView/edit/master/README-ZH.md)

[![Api reqeust](https://img.shields.io/badge/api-1+-green.svg)](https://github.com/samlss/LovelyView)  [![Apache License 2.0](https://img.shields.io/hexpm/l/plug.svg)](https://github.com/samlss/LovelyView/blob/master/LICENSE) [![Blog](https://img.shields.io/badge/samlss-blog-orange.svg)](https://blog.csdn.net/Samlss)


![pic1](https://github.com/samlss/LovelyView/blob/master/screenshots/screenshot1.png)

<br/>

![pic2](https://github.com/samlss/LovelyView/blob/master/screenshots/screenshot2.png)



## Use<br>
Add it in your root build.gradle at the end of repositories：
```
allprojects {
    repositories {
        //...
        maven { url 'https://jitpack.io' }
    }
}
```
Add it in your app build.gradle at the end of repositories:
```
dependencies {
    implementation 'com.github.samlss:LovelyView:1.0'
}
```

## View diagram

![pic4](https://github.com/samlss/LovelyView/blob/master/screenshots/screenshot4.png)

* Left：includes one ImageView and three TextViews
* center：includes one TextView
* Right：includes one ImageView and three TextViews
* Top and bottom both contain a split line (View)

## Attributes description：

### ImageView

| attr        | description           |
| ------------- |:-------------:|
| `leftImage`/`rightImage`      | ImageView resources, for example: @mipmap/ic_launcher |
| `leftImageWidth`/`rightImageWidth` | ImageView width |
| `leftImageHeight`/`rightImageHeight` | ImageView's height |
| `leftImageScaleType`/`rightImageScaleType` | ImageView's ScaleType |
| `leftImageMarginLeft`/`rightImageMarginLeft` | ImageView's marginLeft distance |
| `leftImageMarginRight`/`rightImageMarginRight` | ImageView's marginRight distance |
| `leftImageMarginTop`/`rightImageMarginTop` | ImageView's marginTop distance |
| `leftImageMarginBottom`/`rightImageMarginBottom` |ImageView's marginBottom distance |

<br/>

### TextView

| attr        | description           |
| ------------- |:-------------:|
| `leftText`/`rightText`/`centerText`     | TextView stringId or string |
| `leftTextSize`/`rightTextSize`/`centerTextSize` | TextView's size |
| `leftTextColor`/`rightTextColor`/`centerTextColor` | TextView's color |
| `leftTextMarginLeft`/`rightTextMarginLeft` | TextView's marginLeft distance |
| `leftTextMarginRight`/`rightTextMarginRight` | TextView's marginRight distance |
| `leftTextMarginTop`/`rightTextMarginTop` | TextView's marginTop distance |
| `leftTextMarginBottom`/`rightTextMarginBottom` | TextView's marginBottom distance |

### [More attrs](https://github.com/samlss/LovelyView/blob/master/library/src/main/res/values/attrs.xml)

<br/>

### View(split line)

| attr        | description           |
| ------------- |:-------------:|
| `topLineDisplay`/`bottomLineDisplay`      | Whether to display the line, false will be set to invisible |
| `topLineColor`/`bottomLineColor` | the color of split line |
| `topLineHeight`/`bottomLineHeight` | the height of split line |
| `topLineMarginLeft`/`bottomLineMarginLeft` | marginLeft distance |
| `topLineMarginRight`/`bottomLineMarginRight` | marginRight distance |
| `topLineMarginTop`/`bottomLineMarginTop` | marginTop distance |
| `topLineMarginBottom`/`bottomLineMarginBottom` | marginBottom distance |


## in layout.xml：
```
      <com.iigo.library.LovelyView
                android:background="@android:color/white"
                app:leftImage="@mipmap/ic_launcher"
                app:leftImageWidth="50dp"
                app:leftImageHeight="50dp"
                app:leftImageMarginLeft="10dp"
                app:leftText="Left"
                app:leftTextSize="16sp"
                app:leftTextMarginLeft="10dp"
                app:leftTextColor="@android:color/holo_orange_light"
                app:leftTopText="Left Top"
                app:leftTopTextSize="16sp"
                app:leftTopTextMarginLeft="10dp"
                app:leftTopTextColor="@android:color/holo_orange_light"
                app:leftBottomText="Left Bottom"
                app:leftBottomTextSize="16sp"
                app:leftBottomTextMarginLeft="10dp"
                app:leftBottomTextColor="@android:color/holo_orange_light"
                app:centerText="All Attr"
                app:centerTextSize="16sp"
                app:centerTextColor="@android:color/black"
                app:rightText="Right"
                app:rightTextSize="16sp"
                app:rightTextColor="@android:color/holo_blue_dark"
                app:rightTextMarginRight="10dp"
                app:rightTopText="Right Top"
                app:rightTopTextSize="16sp"
                app:rightTopTextColor="@android:color/holo_blue_dark"
                app:rightTopTextMarginRight="10dp"
                app:rightBottomText="Right Top"
                app:rightBottomTextSize="16sp"
                app:rightBottomTextColor="@android:color/holo_blue_dark"
                app:rightBottomTextMarginRight="10dp"
                app:rightImage="@mipmap/ic_launcher"
                app:rightImageWidth="50dp"
                app:rightImageHeight="50dp"
                app:rightImageMarginRight="10dp"
                android:layout_width="match_parent"
                android:layout_height="100dp"/>
```

## in code：
```
        lovelyView.getRightTextView().setText("right"); 
        lovelyView.getRightTextView().setTextSize(20);

        lovelyView.getRightTopTextView().setText("right");
        lovelyView.getRightTopTextView().setTextSize(20);

        lovelyView.getRightBottomTextView().setText("right");
        lovelyView.getRightBottomTextView().setTextSize(20);

        lovelyView.getLeftTopTextView().setText("left top");
        lovelyView.getLeftTextView().setText("left");
        lovelyView.getLeftBottomTextView().setText("left bottom");

        lovelyView.getLeftImageView().setImageResource(R.mipmap.icon_cab);
        lovelyView.getRightImageView().setImageResource(R.mipmap.icon_cab);

        lovelyView.getCenterTextView().setText("center");
    }
```

* If the attribute specified in the layout.xml does not meet your requirements, you can directly using get...View() to do more.


## License
```
Copyright 2018 samlss

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
