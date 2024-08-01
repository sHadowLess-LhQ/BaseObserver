package cn.com.shadowless.baseobserver.loadingObserver;

import android.app.Activity;

import androidx.annotation.NonNull;

import com.lxj.xpopup.XPopup;
import com.lxj.xpopup.core.BasePopupView;

import cn.com.shadowless.baseobserver.BaseMaybeObserver;
import cn.com.shadowless.baseobserver.LoadingConfig;


/**
 * The type Base observer.
 *
 * @param <T> the type parameter
 * @author sHadowLess
 */
public abstract class BaseLoadingMaybeObserver<T> extends BaseMaybeObserver<T> {

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
    public BaseLoadingMaybeObserver(@NonNull Activity activity, @NonNull LoadingConfig config) {
        loadingPopupView = new XPopup.Builder(activity)
                .isDestroyOnDismiss(config.isDestroyOnDismiss())
                .isViewMode(config.isViewModel())
                .dismissOnBackPressed(config.isCanBackCancel())
                .dismissOnTouchOutside(config.isCanOutSideCancel())
                .hasBlurBg(config.isHasBlurBg())
                .hasShadowBg(config.isHasShadow())
                .asLoading(config.getLoadName());
        loadingPopupView.show();
    }

    @Override
    public void start() {
        onStart();
        time = loadingPopupView.getAnimationDuration() + 200;
    }

    @Override
    public void success(T t) {
        loadingPopupView.delayDismissWith(time, () -> onSuccess(t));
    }

    @Override
    public void fail(String error, Throwable e) {
        loadingPopupView.delayDismissWith(time, () -> onFail(error, e));
    }

    @Override
    public void finish() {
        onFinish();
    }

    /**
     * On start.
     */
    public abstract void onStart();

    /**
     * On success.
     *
     * @param t the t
     */
    public abstract void onSuccess(T t);

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