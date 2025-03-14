package cn.com.shadowless.baseobserver.loadingObserver;

import android.app.Activity;

import androidx.annotation.NonNull;

import com.lxj.xpopup.XPopup;
import com.lxj.xpopup.core.BasePopupView;

import cn.com.shadowless.baseobserver.BaseObserver;
import cn.com.shadowless.baseobserver.LoadingConfig;
import cn.com.shadowless.baseobserver.ObserveEventSpecification;

/**
 * The type Base observer.
 *
 * @param <T> the type parameter
 * @author sHadowLess
 */
public abstract class BaseLoadingObserver<T> extends BaseObserver<T> implements ObserveEventSpecification<T> {

    /**
     * Instantiates a new Base life observer.
     *
     * @param activity the activity
     * @param config   the config
     */
    public BaseLoadingObserver(@NonNull Activity activity, @NonNull LoadingConfig config) {
        loadingPopupView = this.getLoadingPopView(activity, config);
    }

    @Override
    public void start() {
        loadingPopupView.show();
        loadingTime = loadingPopupView.getAnimationDuration() + 200;
        onStartEvent();
    }

    @Override
    public void success(T t) {
        loadingPopupView.delayDismissWith(loadingTime, () -> onSuccessEvent(t));
    }

    @Override
    public void fail(String error, Throwable e) {
        loadingPopupView.delayDismissWith(loadingTime, () -> onFailEvent(error, e));
    }

    @Override
    public void finish() {
        onFinishEvent();
    }

    @Override
    public void onRefreshEvent(T t) {

    }

    @Override
    public void onLoadEvent(T t) {

    }
}