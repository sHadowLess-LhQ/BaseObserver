package cn.com.shadowless.baseobserver.loadingObserver;

import android.app.Activity;

import androidx.annotation.NonNull;

import cn.com.shadowless.baseobserver.BaseCompletableObserver;
import cn.com.shadowless.baseobserver.LoadingConfig;


/**
 * The type Base observer.
 *
 * @author sHadowLess
 */
public abstract class BaseLoadingCompletableObserver extends BaseCompletableObserver {

    /**
     * Instantiates a new Base life observer.
     *
     * @param activity the activity
     * @param config   the config
     */
    public BaseLoadingCompletableObserver(@NonNull Activity activity, @NonNull LoadingConfig config) {
        loadingPopupView = this.getLoadingPopView(activity, config);
    }

    @Override
    public void start() {
        loadingPopupView.show();
        loadingTime = loadingPopupView.getAnimationDuration() + 200;
        onStartEvent();
    }

    @Override
    public void fail(String error, Throwable e) {
        loadingPopupView.delayDismissWith(loadingTime, () -> onFailEvent(error, e));
    }

    @Override
    public void finish() {
        loadingPopupView.delayDismissWith(loadingTime, this::onFinishEvent);
    }

    @Override
    public void onRefreshEvent(Object o) {

    }

    @Override
    public void onLoadEvent(Object o) {

    }

    @Override
    public void onSuccessEvent(Object o) {

    }
}