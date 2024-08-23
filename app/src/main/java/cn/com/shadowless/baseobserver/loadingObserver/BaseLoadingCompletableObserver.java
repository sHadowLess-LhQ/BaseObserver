package cn.com.shadowless.baseobserver.loadingObserver;

import android.app.Activity;

import androidx.annotation.NonNull;

import com.lxj.xpopup.XPopup;
import com.lxj.xpopup.core.BasePopupView;

import cn.com.shadowless.baseobserver.BaseCompletableObserver;
import cn.com.shadowless.baseobserver.LoadingConfig;


/**
 * The type Base observer.
 *
 * @author sHadowLess
 */
public abstract class BaseLoadingCompletableObserver extends BaseCompletableObserver {

    /**
     * The Loading popup view.
     */
    private final BasePopupView loadingPopupView;

    /**
     * The Time.
     */
    private int time = 500;

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
        onStart();
        loadingPopupView.show();
        time = loadingPopupView.getAnimationDuration() + 200;
    }

    @Override
    public void fail(String error, Throwable e) {
        loadingPopupView.delayDismissWith(time, () -> onFail(error, e));
    }

    @Override
    public void finish() {
        loadingPopupView.delayDismissWith(time, this::onFinish);
    }

    /**
     * On start.
     */
    public abstract void onStart();

    /**
     * On success.
     */
    public abstract void onFinish();

    /**
     * On fail.
     *
     * @param error the error
     * @param e     the e
     */
    public abstract void onFail(String error, Throwable e);
}