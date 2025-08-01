# BaseObserver

#### 软件架构

个人自用Rxjava观察者封装

### 【注】：3.0变更了包结构，并引入Kotlin扩展函数方便Kotlin开发时使用

#### 安装教程

Step 1. 添加maven仓库地址和配置

```
     //旧AndroidStudio版本
     //build.gradle
     allprojects {
         repositories {
            ...
              maven { url 'https://jitpack.io' }
         }
     }
     
     //新AndroidStudio版本
     //settings.gradle
     dependencyResolutionManagement {
          repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
          repositories {
            ...
             maven { url 'https://jitpack.io' }
          }
      }
```

Step 2. 添加依赖

a、克隆引入

直接下载源码引入model

b、远程仓库引入

[![](https://jitpack.io/v/sHadowLess-LhQ/BaseObserver.svg)](https://jitpack.io/#sHadowLess-LhQ/BaseObserver)

```
     dependencies {
        //根依赖
        implementation 'com.gitee.shadowless_lhq:base-observer:Tag'
        implementation 'io.reactivex.rxjava3:rxjava:3.1.8'
        //如需使用loadingObserver包下的类，请额外依赖
        implementation 'com.github.li-xiaojun:XPopup:2.10.0'
        //如需使用freshObserver包下的类，请额外依赖
        implementation 'io.github.scwang90:refresh-layout-kernel:2.1.0'
        //3.0补充
        implementation 'com.github.liujingxing.rxlife:rxlife-rxjava3:2.2.2'
    }
```

c、混淆规则

```
-keepattributes Signature
-dontwarn sun.misc.**
-keepclassmembers class rx.internal.util.unsafe.*ArrayQueue*Field* {
    long producerIndex;
    long consumerIndex;
}
-keepclassmembers class rx.internal.util.unsafe.BaseLinkedQueueProducerNodeRef {
    rx.internal.util.atomic.LinkedQueueNode producerNode;
}
-keepclassmembers class rx.internal.util.unsafe.BaseLinkedQueueConsumerNodeRef {
    rx.internal.util.atomic.LinkedQueueNode consumerNode;
}
-keepclassmembers class rx.android.**{*;}
-dontwarn com.lxj.xpopup.widget.**
-keep class com.lxj.xpopup.widget.**{*;}
-dontwarn com.tencent.bugly.**
-keep public class com.tencent.bugly.**{*;}
-keep class android.support.**{*;}
```

#### 使用说明

## 同RxJava里的观察者同样的使用方式

## Kotlin扩展函数，详细请看BaseObserverExt
