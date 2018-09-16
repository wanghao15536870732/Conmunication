# 项目背景
> &emsp;“一带一路”建设是在我国构建全方位开放新格局，深度融入世界经济体系背景下提出的重大倡议，旨在促进经济要素有序自由流动、资源高效配置和市场深度融合，推动沿线各国实现经济政策协调，开展更大范围、更高水平、更深层次的区域合作，共同打造开放、包容、均衡、普惠的区域经济合作架构，维护全球自由贸易体系和开放型世界经济。<br>[查看出处](http://history.mofcom.gov.cn/?newchina=%E4%B8%80%E5%B8%A6%E4%B8%80%E8%B7%AF%E5%80%A1%E8%AE%AE%E7%9A%84%E6%8F%90%E5%87%BA)

2016年7月教育部发布文件[教育部关于印发《推进共建“一带一路”教育行动》的通知
](http://www.moe.gov.cn/srcsite/A20/s7068/201608/t20160811_274679.html)

## [一路语伴](https://github.com/wmpscc/YiLuYuBan)的社群聊天部分

## 界面演示

<div align="center">

|聊天消息|联系人|问题动态|
|:--:|:--:|:--:|
|![Screenshot_20180916-213740.png](https://upload-images.jianshu.io/upload_images/9140378-55c2736e4d157c31.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/240)|![Screenshot_20180916-214621.png](https://upload-images.jianshu.io/upload_images/9140378-37e10b708e38a444.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/240)|![Screenshot_20180916-213931.png](https://upload-images.jianshu.io/upload_images/9140378-99c44a59beae4ba8.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/240)|
|开始聊天|详细联系人|问题详情|
|![Screenshot_20180916-213919.png](https://upload-images.jianshu.io/upload_images/9140378-8dd7576c6517638a.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/240)|![Screenshot_20180916-214104.png](https://upload-images.jianshu.io/upload_images/9140378-07251f0a0a1ae28b.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/240)|![Screenshot_20180916-214005.png](https://upload-images.jianshu.io/upload_images/9140378-a4e59e8c9f73d5e5.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/240)|
|消息种类|问题详情|热心评论|
|![Screenshot_20180916-213922.png](https://upload-images.jianshu.io/upload_images/9140378-e77229940bc4c4c3.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/240)|![Screenshot_20180916-214008.png](https://upload-images.jianshu.io/upload_images/9140378-ace6e9f582a1187d.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/240)|![Screenshot_20180916-214010.png](https://upload-images.jianshu.io/upload_images/9140378-f273c82cf4988896.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/240)|
|添加问题动态|提取图中文字|详细结果|
|![Screenshot_20180916-213956.png](https://upload-images.jianshu.io/upload_images/9140378-ebc30015521060e1.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/240)|![Screenshot_20180916-214704.png](https://upload-images.jianshu.io/upload_images/9140378-24f91e08a9065c1c.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/240)|![Screenshot_20180916-214704.png](https://upload-images.jianshu.io/upload_images/9140378-24f91e08a9065c1c.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/240)|

</div>

## 用到的第三方库
```java
dependencies {
    implementation fileTree(include: ['*.jar'], dir: 'libs')
    //noinspection GradleCompatible
    implementation 'com.android.support:appcompat-v7:27.1.1'
    implementation 'com.android.support.constraint:constraint-layout:1.1.1'
    testImplementation 'junit:junit:4.12'
    androidTestImplementation 'com.android.support.test:runner:1.0.2'
    androidTestImplementation 'com.android.support.test.espresso:espresso-core:3.0.2'
    implementation 'com.github.bumptech.glide:glide:4.7.1'
    implementation 'com.alibaba:fastjson:1.2.47'
    annotationProcessor 'com.github.bumptech.glide:compiler:4.7.1'
    implementation 'me.drakeet.multitype:multitype:3.4.4'
    implementation 'com.lzy.net:okgo:3.0.4'
    implementation 'com.lzy.net:okserver:2.0.5'
    implementation 'com.android.support:design:27.1.1'
    implementation 'com.wenwenwen888:searchbox:1.0.0'
    implementation 'com.jakewharton:butterknife:8.8.0'
    implementation 'com.jakewharton:butterknife-annotations:8.8.0'
    implementation 'com.android.support:cardview-v7:27.1.1'
    implementation 'de.hdodenhof:circleimageview:2.2.0'
    implementation 'com.squareup.retrofit2:converter-gson:2.0.0-beta4'
    implementation 'com.zhy:autolayout:1.4.5'
    implementation 'com.lzy.widget:imagepicker:0.6.1'
    implementation 'com.zzti.fengyongge:imagepicker:1.2.0'
    implementation 'com.android.support:multidex:1.0.3'
    implementation 'org.greenrobot:greendao:3.2.2'
    implementation 'com.github.LuckSiege.PictureSelector:picture_library:v2.2.3'
    implementation 'com.github.nyakokishi:ChatImageView:1.0.2'
    implementation 'com.nostra13.universalimageloader:universal-image-loader:1.9.5'
    implementation 'org.ocpsoft.prettytime:prettytime:4.0.1.Final'
    implementation 'com.novaapps:FloatingActionMenu:1.0'
    implementation 'com.github.hackware1993:MagicIndicator:1.5.0'
    //悬浮按钮
    implementation 'com.getbase:floatingactionbutton:1.10.1'
    //点赞按钮
    implementation 'com.sackcentury:shinebutton:0.2.0'
    //圆形头像
    implementation 'com.makeramen:roundedimageview:2.3.0'
    // 语音波浪线
    implementation 'com.github.baixxx:WaveView:master'

}
```
## LICENSE
```java
 Copyright [2018] [wanghao15536870732]

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

时隔好几个月才把这个旧的项目完善 , 差点就凉了...
