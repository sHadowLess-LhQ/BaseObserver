# BaseObserver

#### 软件架构

个人自用Rxjava观察者封装

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

[[![](https://jitpack.io/v/com.gitee.shadowless_lhq/base-observer.svg)](https://jitpack.io/#com.gitee.shadowless_lhq/base-observer)

```
     dependencies {
        implementation 'com.gitee.shadowless_lhq:base-observer:Tag'

        implementation 'io.reactivex.rxjava2:rxjava:2.2.21'
        implementation 'com.github.li-xiaojun:XPopup:2.9.4'
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

### BaseObserver

```
     //无加载框
     new BaseObserver()
     //自定义LoadingPopView/是否智能关闭
     new BaseObserver(LoadingPopupView loadingPopupView, boolean isSmartDismiss)
     //配置LoadingPopView
     new BaseObserver(Activity activity, LoadingConfig config)
```

### BaseCompletableObserver

```
     //无加载框
     new BaseCompletableObserver()
     //自定义LoadingPopView/是否智能关闭
     new BaseCompletableObserver(LoadingPopupView loadingPopupView, boolean isSmartDismiss)
     //配置LoadingPopView
     new BaseCompletableObserver(Activity activity, LoadingConfig config)
```

### BaseMaybeObserver

```
     //无加载框
     new BaseMaybeObserver()
     //自定义LoadingPopView/是否智能关闭
     new BaseMaybeObserver(LoadingPopupView loadingPopupView, boolean isSmartDismiss)
     //配置LoadingPopView
     new BaseMaybeObserver(Activity activity, LoadingConfig config)
```

### BaseSingleObserver

```
     //无加载框
     new BaseSingleObserver()
     //自定义LoadingPopView/是否智能关闭
     new BaseSingleObserver(LoadingPopupView loadingPopupView, boolean isSmartDismiss)
     //配置LoadingPopView
     new BaseSingleObserver(Activity activity, LoadingConfig config)
```

### BaseSubscriber

```
     //无加载框
     new BaseSubscriber()
     //自定义LoadingPopView/是否智能关闭
     new BaseSubscriber(LoadingPopupView loadingPopupView, boolean isSmartDismiss)
     //配置LoadingPopView
     new BaseSubscriber(Activity activity, LoadingConfig config)
```
