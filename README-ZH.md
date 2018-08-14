
# LovelyView
### 一个组合图片和文本类的view，可让你更加节省时间地开发类似于左中右这种显示顺序的图片+文本的列表项。

[![Api reqeust](https://img.shields.io/badge/api-1+-green.svg)](https://github.com/samlss/LovelyView)  [![Apache License 2.0](https://img.shields.io/hexpm/l/plug.svg)](https://github.com/samlss/LovelyView/blob/master/LICENSE) [![Blog](https://img.shields.io/badge/samlss-blog-orange.svg)](https://blog.csdn.net/Samlss)


![pic1](https://github.com/samlss/LovelyView/blob/master/screenshots/screenshot1.png)

<br/>

![pic2](https://github.com/samlss/LovelyView/blob/master/screenshots/screenshot2.png)



## 使用<br>
在根目录的build.gradle添加这一句代码：
```
allprojects {
    repositories {
        //...
        maven { url 'https://jitpack.io' }
    }
}
```

在app目录下的build.gradle添加依赖使用：
```
dependencies {
    implementation 'com.github.samlss:LovelyView:1.0'
}
```

## View整体示例图

![pic4](https://github.com/samlss/LovelyView/blob/master/screenshots/screenshot4.png)

* 左边：包含一个ImageView和三个TextView
* 中间：包含一个TextView
* 右边：包含一个ImageView和三个TextView
* 且顶部和底部都包含一条分割线（即View）

## 属性说明：

### ImageView

| 属性        | 说明           |
| ------------- |:-------------:|
| `leftImage`/`rightImage`      | ImageView的图片资源，例如@mipmap/ic_launcher |
| `leftImageWidth`/`rightImageWidth` | ImageView的宽 |
| `leftImageHeight`/`rightImageHeight` | ImageView的高 |
| `leftImageScaleType`/`rightImageScaleType` | ImageView的ScaleType |
| `leftImageMarginLeft`/`rightImageMarginLeft` | ImageView的marginLeft距离 |
| `leftImageMarginRight`/`rightImageMarginRight` | ImageView的marginRight距离|
| `leftImageMarginTop`/`rightImageMarginTop` | ImageView的marginTop距离|
| `leftImageMarginBottom`/`rightImageMarginBottom` | ImageView的marginBottom距离|

<br/>

### TextView系列

| 属性        | 说明           |
| ------------- |:-------------:|
| `leftText`/`rightText`/`centerText`     | TextView的字符串id或字符串常量 |
| `leftTextSize`/`rightTextSize`/`centerTextSize` | TextView的大小 |
| `leftTextColor`/`rightTextColor`/`centerTextColor` | TextView的颜色 |
| `leftTextMarginLeft`/`rightTextMarginLeft` | TextView的marginLeft的距离 |
| `leftTextMarginRight`/`rightTextMarginRight` | TextView的marginRight距离|
| `leftTextMarginTop`/`rightTextMarginTop` | TextView的marginTop距离|
| `leftTextMarginBottom`/`rightTextMarginBottom` | TextView的marginBottom距离|

### [更多属性可查看](https://github.com/samlss/LovelyView/blob/master/library/src/main/res/values/attrs.xml)

<br/>

### View(分割线)

| 属性        | 说明           |
| ------------- |:-------------:|
| `topLineDisplay`/`bottomLineDisplay`      | 是否显示该分割线，false的话会设置为invisible |
| `topLineColor`/`bottomLineColor` | 分割线颜色 |
| `topLineHeight`/`bottomLineHeight` | 分割线高度 |
| `topLineMarginLeft`/`bottomLineMarginLeft` | 分割线marginLeft距离 |
| `topLineMarginRight`/`bottomLineMarginRight` | 分割线marginRight距离|
| `topLineMarginTop`/`bottomLineMarginTop` | 分割线marginTop距离|
| `topLineMarginBottom`/`bottomLineMarginBottom` | 分割线marginBottom距离|


## 布局中使用：
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

## 代码中使用，以在Activity中使用为例：
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
```

* 如果在布局文件中指定的属性还不满足需求的话，可以通过get...View()来直接进行操作


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
