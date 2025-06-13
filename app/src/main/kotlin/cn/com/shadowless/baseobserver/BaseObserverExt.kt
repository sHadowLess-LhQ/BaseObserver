package cn.com.shadowless.baseobserver

import android.app.Activity
import cn.com.shadowless.baseobserver.base.BaseCompletableObserver
import cn.com.shadowless.baseobserver.base.BaseErrorConsumer
import cn.com.shadowless.baseobserver.base.BaseErrorFunction
import cn.com.shadowless.baseobserver.base.BaseFlowable
import cn.com.shadowless.baseobserver.base.BaseMaybeObserver
import cn.com.shadowless.baseobserver.base.BaseObserver
import cn.com.shadowless.baseobserver.base.BaseSingleObserver
import cn.com.shadowless.baseobserver.freshObserber.BaseFreshCompletableObserver
import cn.com.shadowless.baseobserver.freshObserber.BaseFreshFlowable
import cn.com.shadowless.baseobserver.freshObserber.BaseFreshMaybeObserver
import cn.com.shadowless.baseobserver.freshObserber.BaseFreshObserver
import cn.com.shadowless.baseobserver.freshObserber.BaseFreshSingleObserver
import cn.com.shadowless.baseobserver.loadingObserver.BaseLoadingCompletableObserver
import cn.com.shadowless.baseobserver.loadingObserver.BaseLoadingFlowable
import cn.com.shadowless.baseobserver.loadingObserver.BaseLoadingMaybeObserver
import cn.com.shadowless.baseobserver.loadingObserver.BaseLoadingObserver
import cn.com.shadowless.baseobserver.loadingObserver.BaseLoadingSingleObserver
import com.rxjava.rxlife.CompletableLife
import com.rxjava.rxlife.FlowableLife
import com.rxjava.rxlife.MaybeLife
import com.rxjava.rxlife.ObservableLife
import com.rxjava.rxlife.SingleLife
import com.scwang.smart.refresh.layout.SmartRefreshLayout
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

inline fun <T : Any> Observable<T>.subscribeByObservable(
    crossinline onStart: () -> Unit = {},
    crossinline onSuccess: (T?) -> Unit,
    crossinline onFailure: (String?, Throwable?) -> Unit,
    crossinline onFinish: () -> Unit = {}
) {
    this.subscribe(object : BaseObserver<T>() {
        override fun start() = onStart()
        override fun success(t: T?) = onSuccess(t)
        override fun fail(error: String?, e: Throwable?) = onFailure(error, e)
        override fun finish() = onFinish()
    })
}

inline fun <T : Any> Observable<T>.subscribeByObservable(
    activity: Activity,
    config: LoadingConfig = LoadingConfig.builder().loadName("加载中").canBackCancel(false)
        .canOutSideCancel(false).build(),
    crossinline onStart: () -> Unit = {},
    crossinline onSuccess: (T?) -> Unit,
    crossinline onFailure: (String?, Throwable?) -> Unit,
    crossinline onFinish: () -> Unit = {}
) {
    this.subscribe(object : BaseLoadingObserver<T>(activity, config) {

        override fun onStartEvent() = onStart()

        override fun onSuccessEvent(t: T) = onSuccess(t)

        override fun onFailEvent(error: String?, e: Throwable?) = onFailure(error, e)

        override fun onFinishEvent() = onFinish()
    })
}

inline fun <T : Any> Observable<T>.subscribeByObservable(
    refresh: SmartRefreshLayout,
    crossinline onStart: () -> Unit = {},
    crossinline onRefresh: (T?) -> Unit,
    crossinline onLoad: (T?) -> Unit,
    crossinline onFailure: (String?, Throwable?) -> Unit,
    crossinline onFinish: () -> Unit = {}
) {
    this.subscribe(object : BaseFreshObserver<T>(refresh) {
        override fun onStartEvent() = onStart()

        override fun onRefreshEvent(t: T) = onRefresh(t)

        override fun onLoadEvent(t: T) = onLoad(t)

        override fun onFailEvent(error: String?, e: Throwable?) = onFailure(error, e)

        override fun onFinishEvent() = onFinish()
    })
}

inline fun <T : Any> ObservableLife<T>.subscribeByObservable(
    crossinline onStart: () -> Unit = {},
    crossinline onSuccess: (T) -> Unit,
    crossinline onFailure: (String?, Throwable?) -> Unit,
    crossinline onFinish: () -> Unit = {}
) {
    this.subscribe(object : BaseObserver<T>() {
        override fun start() = onStart()
        override fun success(t: T) = onSuccess(t)
        override fun fail(error: String?, e: Throwable?) = onFailure(error, e)
        override fun finish() = onFinish()
    })
}

inline fun <T : Any> ObservableLife<T>.subscribeByObservable(
    activity: Activity,
    config: LoadingConfig = LoadingConfig.builder().loadName("加载中").canBackCancel(false)
        .canOutSideCancel(false).build(),
    crossinline onStart: () -> Unit = {},
    crossinline onSuccess: (T?) -> Unit,
    crossinline onFailure: (String?, Throwable?) -> Unit,
    crossinline onFinish: () -> Unit = {}
) {
    this.subscribe(object : BaseLoadingObserver<T>(activity, config) {

        override fun onStartEvent() = onStart()

        override fun onSuccessEvent(t: T) = onSuccess(t)

        override fun onFailEvent(error: String?, e: Throwable?) = onFailure(error, e)

        override fun onFinishEvent() = onFinish()
    })
}

inline fun <T : Any> ObservableLife<T>.subscribeByObservable(
    refresh: SmartRefreshLayout,
    crossinline onStart: () -> Unit = {},
    crossinline onRefresh: (T?) -> Unit,
    crossinline onLoad: (T?) -> Unit,
    crossinline onFailure: (String?, Throwable?) -> Unit,
    crossinline onFinish: () -> Unit = {}
) {
    this.subscribe(object : BaseFreshObserver<T>(refresh) {
        override fun onStartEvent() = onStart()

        override fun onRefreshEvent(t: T) = onRefresh(t)

        override fun onLoadEvent(t: T) = onLoad(t)

        override fun onFailEvent(error: String?, e: Throwable?) = onFailure(error, e)

        override fun onFinishEvent() = onFinish()
    })
}


inline fun <T : Any> Single<T>.subscribeBySingle(
    crossinline onStart: () -> Unit = {},
    crossinline onSuccess: (T?) -> Unit,
    crossinline onFailure: (String?, Throwable?) -> Unit,
) {
    this.subscribe(object : BaseSingleObserver<T>() {
        override fun start() = onStart()

        override fun success(t: T?) = onSuccess(t)

        override fun fail(error: String?, e: Throwable?) = onFailure(error, e)

        override fun finish() {

        }
    })
}

inline fun <T : Any> Single<T>.subscribeBySingle(
    activity: Activity,
    config: LoadingConfig = LoadingConfig.builder().loadName("加载中").canBackCancel(false)
        .canOutSideCancel(false).build(),
    crossinline onStart: () -> Unit = {},
    crossinline onSuccess: (T?) -> Unit,
    crossinline onFailure: (String?, Throwable?) -> Unit
) {
    this.subscribe(object : BaseLoadingSingleObserver<T>(activity, config) {

        override fun onStartEvent() = onStart()

        override fun onSuccessEvent(t: T) = onSuccess(t)

        override fun onFailEvent(error: String?, e: Throwable?) = onFailure(error, e)

        override fun finish() {

        }
    })
}

inline fun <T : Any> Single<T>.subscribeBySingle(
    refresh: SmartRefreshLayout,
    crossinline onStart: () -> Unit = {},
    crossinline onRefresh: (T?) -> Unit,
    crossinline onLoad: (T?) -> Unit,
    crossinline onFailure: (String?, Throwable?) -> Unit,
) {
    this.subscribe(object : BaseFreshSingleObserver<T>(refresh) {
        override fun onStartEvent() = onStart()

        override fun onRefreshEvent(t: T) = onRefresh(t)

        override fun onLoadEvent(t: T) = onLoad(t)

        override fun onFailEvent(error: String?, e: Throwable?) = onFailure(error, e)

        override fun finish() {

        }
    })
}

inline fun <T : Any> SingleLife<T>.subscribeBySingle(
    crossinline onStart: () -> Unit = {},
    crossinline onSuccess: (T) -> Unit,
    crossinline onFailure: (String?, Throwable?) -> Unit
) {
    this.subscribe(object : BaseSingleObserver<T>() {
        override fun start() = onStart()

        override fun success(t: T) = onSuccess(t)

        override fun fail(error: String?, e: Throwable?) = onFailure(error, e)

        override fun finish() {

        }
    })
}

inline fun <T : Any> SingleLife<T>.subscribeBySingle(
    activity: Activity,
    config: LoadingConfig = LoadingConfig.builder().loadName("加载中").canBackCancel(false)
        .canOutSideCancel(false).build(),
    crossinline onStart: () -> Unit = {},
    crossinline onSuccess: (T) -> Unit,
    crossinline onFailure: (String?, Throwable?) -> Unit
) {
    this.subscribe(object : BaseLoadingSingleObserver<T>(activity, config) {

        override fun onStartEvent() = onStart()

        override fun onSuccessEvent(t: T) = onSuccess(t)

        override fun onFailEvent(error: String?, e: Throwable?) = onFailure(error, e)

        override fun finish() {

        }
    })
}

inline fun <T : Any> SingleLife<T>.subscribeBySingle(
    refresh: SmartRefreshLayout,
    crossinline onStart: () -> Unit = {},
    crossinline onRefresh: (T?) -> Unit,
    crossinline onLoad: (T?) -> Unit,
    crossinline onFailure: (String?, Throwable?) -> Unit,
) {
    this.subscribe(object : BaseFreshSingleObserver<T>(refresh) {
        override fun onStartEvent() = onStart()

        override fun onRefreshEvent(t: T) = onRefresh(t)

        override fun onLoadEvent(t: T) = onLoad(t)

        override fun onFailEvent(error: String?, e: Throwable?) = onFailure(error, e)

        override fun finish() {

        }
    })
}

inline fun Completable.subscribeByCompletable(
    crossinline onStart: () -> Unit = {},
    crossinline onFailure: (String?, Throwable?) -> Unit,
    crossinline onFinish: () -> Unit = {}
) {
    this.subscribe(object : BaseCompletableObserver() {
        override fun start() = onStart()

        override fun success(t: Any?) {
        }

        override fun fail(error: String?, e: Throwable?) = onFailure(error, e)

        override fun finish() = onFinish()
    })
}

inline fun Completable.subscribeByCompletable(
    activity: Activity,
    config: LoadingConfig = LoadingConfig.builder().loadName("加载中").canBackCancel(false)
        .canOutSideCancel(false).build(),
    crossinline onStart: () -> Unit = {},
    crossinline onFailure: (String?, Throwable?) -> Unit,
    crossinline onFinish: () -> Unit = {}
) {
    this.subscribe(object : BaseLoadingCompletableObserver(activity, config) {

        override fun onStartEvent() = onStart()

        override fun success(t: Any?) {
        }

        override fun onFinishEvent() = onFinish()

        override fun onFailEvent(error: String?, e: Throwable?) = onFailure(error, e)
    })
}

inline fun Completable.subscribeByCompletable(
    refresh: SmartRefreshLayout,
    crossinline onStart: () -> Unit = {},
    crossinline onFailure: (String?, Throwable?) -> Unit,
    crossinline onFinish: () -> Unit = {}
) {
    this.subscribe(object : BaseFreshCompletableObserver(refresh) {
        override fun onStartEvent() = onStart()

        override fun success(t: Any?) {
        }

        override fun onFailEvent(error: String?, e: Throwable?) = onFailure(error, e)

        override fun onFinishEvent() = onFinish()
    })
}

inline fun CompletableLife.subscribeByCompletable(
    crossinline onStart: () -> Unit = {},
    crossinline onFailure: (String?, Throwable?) -> Unit,
    crossinline onFinish: () -> Unit = {}
) {
    this.subscribe(object : BaseCompletableObserver() {
        override fun start() = onStart()
        override fun success(t: Any?) {

        }

        override fun fail(error: String?, e: Throwable?) = onFailure(error, e)
        override fun finish() = onFinish()
    })
}

inline fun CompletableLife.subscribeByCompletable(
    activity: Activity,
    config: LoadingConfig = LoadingConfig.builder().loadName("加载中").canBackCancel(false)
        .canOutSideCancel(false).build(),
    crossinline onStart: () -> Unit = {},
    crossinline onFailure: (String?, Throwable?) -> Unit,
    crossinline onFinish: () -> Unit = {}
) {
    this.subscribe(object : BaseLoadingCompletableObserver(activity, config) {

        override fun onStartEvent() = onStart()

        override fun success(t: Any?) {
        }

        override fun onFinishEvent() = onFinish()

        override fun onFailEvent(error: String?, e: Throwable?) = onFailure(error, e)
    })
}

inline fun CompletableLife.subscribeByCompletable(
    refresh: SmartRefreshLayout,
    crossinline onStart: () -> Unit = {},
    crossinline onFailure: (String?, Throwable?) -> Unit,
    crossinline onFinish: () -> Unit = {}
) {
    this.subscribe(object : BaseFreshCompletableObserver(refresh) {
        override fun onStartEvent() = onStart()

        override fun success(t: Any?) {
        }

        override fun onFailEvent(error: String?, e: Throwable?) = onFailure(error, e)

        override fun onFinishEvent() = onFinish()
    })
}


inline fun <T : Any> Maybe<T>.subscribeByMaybe(
    crossinline onStart: () -> Unit = {},
    crossinline onSuccess: (T?) -> Unit,
    crossinline onFailure: (String?, Throwable?) -> Unit,
    crossinline onFinish: () -> Unit = {}
) {
    this.subscribe(object : BaseMaybeObserver<T>() {
        override fun start() = onStart()

        override fun success(t: T?) = onSuccess(t)

        override fun fail(error: String?, e: Throwable?) = onFailure(error, e)

        override fun finish() = onFinish()
    })
}

inline fun <T : Any> Maybe<T>.subscribeByMaybe(
    activity: Activity,
    config: LoadingConfig = LoadingConfig.builder().loadName("加载中").canBackCancel(false)
        .canOutSideCancel(false).build(),
    crossinline onStart: () -> Unit = {},
    crossinline onSuccess: (T?) -> Unit,
    crossinline onFailure: (String?, Throwable?) -> Unit,
    crossinline onFinish: () -> Unit = {}
) {
    this.subscribe(object : BaseLoadingMaybeObserver<T>(activity, config) {
        override fun onStartEvent() = onStart()

        override fun onSuccessEvent(t: T) = onSuccess(t)

        override fun onFailEvent(error: String?, e: Throwable?) = onFailure(error, e)

        override fun onFinishEvent() = onFinish()
    })
}

inline fun <T : Any> Maybe<T>.subscribeByMaybe(
    refresh: SmartRefreshLayout,
    crossinline onStart: () -> Unit = {},
    crossinline onRefresh: (T?) -> Unit,
    crossinline onLoad: (T?) -> Unit,
    crossinline onFailure: (String?, Throwable?) -> Unit,
    crossinline onFinish: () -> Unit = {}
) {
    this.subscribe(object : BaseFreshMaybeObserver<T>(refresh) {
        override fun onStartEvent() = onStart()

        override fun onRefreshEvent(t: T) = onRefresh(t)

        override fun onLoadEvent(t: T) = onLoad(t)

        override fun onFailEvent(error: String?, e: Throwable?) = onFailure(error, e)

        override fun onFinishEvent() = onFinish()
    })
}

inline fun <T : Any> MaybeLife<T>.subscribeByMaybe(
    crossinline onStart: () -> Unit = {},
    crossinline onSuccess: (T) -> Unit,
    crossinline onFailure: (String?, Throwable?) -> Unit,
    crossinline onFinish: () -> Unit = {}
) {
    this.subscribe(object : BaseMaybeObserver<T>() {
        override fun start() = onStart()

        override fun success(t: T) = onSuccess(t)

        override fun fail(error: String?, e: Throwable?) = onFailure(error, e)

        override fun finish() = onFinish()
    })
}

inline fun <T : Any> MaybeLife<T>.subscribeByMaybe(
    activity: Activity,
    config: LoadingConfig = LoadingConfig.builder().loadName("加载中").canBackCancel(false)
        .canOutSideCancel(false).build(),
    crossinline onStart: () -> Unit = {},
    crossinline onSuccess: (T?) -> Unit,
    crossinline onFailure: (String?, Throwable?) -> Unit,
    crossinline onFinish: () -> Unit = {}
) {
    this.subscribe(object : BaseLoadingMaybeObserver<T>(activity, config) {
        override fun onStartEvent() = onStart()

        override fun onSuccessEvent(t: T) = onSuccess(t)

        override fun onFailEvent(error: String?, e: Throwable?) = onFailure(error, e)

        override fun onFinishEvent() = onFinish()
    })
}

inline fun <T : Any> MaybeLife<T>.subscribeByMaybe(
    refresh: SmartRefreshLayout,
    crossinline onStart: () -> Unit = {},
    crossinline onRefresh: (T?) -> Unit,
    crossinline onLoad: (T?) -> Unit,
    crossinline onFailure: (String?, Throwable?) -> Unit,
    crossinline onFinish: () -> Unit = {}
) {
    this.subscribe(object : BaseFreshMaybeObserver<T>(refresh) {
        override fun onStartEvent() = onStart()

        override fun onRefreshEvent(t: T) = onRefresh(t)

        override fun onLoadEvent(t: T) = onLoad(t)

        override fun onFailEvent(error: String?, e: Throwable?) = onFailure(error, e)

        override fun onFinishEvent() = onFinish()
    })
}


inline fun <T : Any> Flowable<T>.subscribeByFlowable(
    crossinline onStart: () -> Unit = {},
    crossinline onSuccess: (T?) -> Unit,
    crossinline onFailure: (String?, Throwable?) -> Unit,
    crossinline onFinish: () -> Unit = {}
) {
    this.subscribe(object : BaseFlowable<T>() {
        override fun start() = onStart()
        override fun success(t: T?) = onSuccess(t)
        override fun fail(error: String?, e: Throwable?) = onFailure(error, e)
        override fun finish() = onFinish()
    })
}

inline fun <T : Any> Flowable<T>.subscribeByFlowable(
    activity: Activity,
    config: LoadingConfig = LoadingConfig.builder().loadName("加载中").canBackCancel(false)
        .canOutSideCancel(false).build(),
    crossinline onStart: () -> Unit = {},
    crossinline onSuccess: (T?) -> Unit,
    crossinline onFailure: (String?, Throwable?) -> Unit,
    crossinline onFinish: () -> Unit = {}
) {
    this.subscribe(object : BaseLoadingFlowable<T>(activity, config) {

        override fun onStartEvent() = onStart()

        override fun onSuccessEvent(t: T) = onSuccess(t)

        override fun onFailEvent(error: String?, e: Throwable?) = onFailure(error, e)

        override fun onFinishEvent() = onFinish()
    })
}

inline fun <T : Any> Flowable<T>.subscribeByFlowable(
    refresh: SmartRefreshLayout,
    crossinline onStart: () -> Unit = {},
    crossinline onRefresh: (T?) -> Unit,
    crossinline onLoad: (T?) -> Unit,
    crossinline onFailure: (String?, Throwable?) -> Unit,
    crossinline onFinish: () -> Unit = {}
) {
    this.subscribe(object : BaseFreshFlowable<T>(refresh) {
        override fun onStartEvent() = onStart()

        override fun onRefreshEvent(t: T) = onRefresh(t)

        override fun onLoadEvent(t: T) = onLoad(t)

        override fun onFailEvent(error: String?, e: Throwable?) = onFailure(error, e)

        override fun onFinishEvent() = onFinish()
    })
}

inline fun <T : Any> FlowableLife<T>.subscribeByFlowable(
    crossinline onStart: () -> Unit = {},
    crossinline onSuccess: (T) -> Unit,
    crossinline onFailure: (String?, Throwable?) -> Unit,
    crossinline onFinish: () -> Unit = {}
) {
    this.subscribe(object : BaseFlowable<T>() {
        override fun start() = onStart()
        override fun success(t: T) = onSuccess(t)
        override fun fail(error: String?, e: Throwable?) = onFailure(error, e)
        override fun finish() = onFinish()
    })
}

inline fun <T : Any> FlowableLife<T>.subscribeByFlowable(
    activity: Activity,
    config: LoadingConfig = LoadingConfig.builder().loadName("加载中").canBackCancel(false)
        .canOutSideCancel(false).build(),
    crossinline onStart: () -> Unit = {},
    crossinline onSuccess: (T?) -> Unit,
    crossinline onFailure: (String?, Throwable?) -> Unit,
    crossinline onFinish: () -> Unit = {}
) {
    this.subscribe(object : BaseLoadingFlowable<T>(activity, config) {

        override fun onStartEvent() = onStart()

        override fun onSuccessEvent(t: T) = onSuccess(t)

        override fun onFailEvent(error: String?, e: Throwable?) = onFailure(error, e)

        override fun onFinishEvent() = onFinish()
    })
}

inline fun <T : Any> FlowableLife<T>.subscribeByFlowable(
    refresh: SmartRefreshLayout,
    crossinline onStart: () -> Unit = {},
    crossinline onRefresh: (T?) -> Unit,
    crossinline onLoad: (T?) -> Unit,
    crossinline onFailure: (String?, Throwable?) -> Unit,
    crossinline onFinish: () -> Unit = {}
) {
    this.subscribe(object : BaseFreshFlowable<T>(refresh) {
        override fun onStartEvent() = onStart()

        override fun onRefreshEvent(t: T) = onRefresh(t)

        override fun onLoadEvent(t: T) = onLoad(t)

        override fun onFailEvent(error: String?, e: Throwable?) = onFailure(error, e)

        override fun onFinishEvent() = onFinish()
    })
}

fun onFailConsumer(consumer: (String?, Throwable?) -> Unit): BaseErrorConsumer {
    return BaseErrorConsumer { error, e -> consumer(error, e) }
}

fun <R : Any> onFailFunction(function: (String?, Throwable?) -> R): BaseErrorFunction<R> {
    return BaseErrorFunction<R> { error, e -> function(error, e) }
}