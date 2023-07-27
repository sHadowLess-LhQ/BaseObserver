package cn.com.shadowless.baseobserver;

import android.app.Activity;

import androidx.annotation.NonNull;

import com.lxj.xpopup.XPopup;
import com.lxj.xpopup.core.BasePopupView;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.disposables.Disposable;

/**
 * The type Base observer.
 *
 * @param <T> the type parameter
 * @author sHadowLess
 */
public abstract class BaseSubscriber<T> implements Subscriber<T> {


    /**
     * The Loading popup view.
     */
    private BasePopupView loadingPopupView = null;

    /**
     * The Is smart dismiss.
     */
    private boolean isSmartDismiss = false;

    /**
     * The Activity.
     */
    private Activity activity;

    /**
     * Instantiates a new Base observer.
     */
    public BaseSubscriber() {
    }

    /**
     * Instantiates a new Base observer.
     *
     * @param activity         the activity
     * @param isSmartDismiss   the is smart dismiss
     * @param loadingPopupView the loading popup view
     */
    public BaseSubscriber(Activity activity, boolean isSmartDismiss, BasePopupView loadingPopupView) {
        this.activity = activity;
        this.isSmartDismiss = isSmartDismiss;
        this.loadingPopupView = loadingPopupView;
    }

    /**
     * Instantiates a new Base life observer.
     *
     * @param activity the activity
     * @param config   the config
     */
    public BaseSubscriber(Activity activity, LoadingConfig config) {
        this.activity = activity;
        this.isSmartDismiss = config.isSmartDismiss();
        loadingPopupView = new XPopup.Builder(activity)
                .isViewMode(config.isViewModel())
                .dismissOnBackPressed(config.isCanBackCancel())
                .dismissOnTouchOutside(config.isCanOutSideCancel())
                .hasBlurBg(config.isHasBlurBg())
                .hasShadowBg(config.isHasShadow())
                .asLoading(config.getLoadName());
    }

    @Override
    public void onSubscribe(Subscription s) {
        if (loadingPopupView != null) {
            activity.runOnUiThread(() -> {
                onStart(s);
                loadingPopupView.show();
            });
        }
    }

    @Override
    public void onNext(@NonNull T t) {
        onSuccess(t);
    }

    @Override
    public void onError(@NonNull Throwable e) {
        if (loadingPopupView != null) {
            if (isSmartDismiss) {
                activity.runOnUiThread(() -> loadingPopupView.smartDismiss());
                onFail(e);
            } else {
                activity.runOnUiThread(() -> loadingPopupView.dismissWith(() -> onFail(e)));
            }
        } else {
            onFail(e);
        }
    }

    @Override
    public void onComplete() {
        if (loadingPopupView != null) {
            if (isSmartDismiss) {
                activity.runOnUiThread(() -> loadingPopupView.smartDismiss());
                onFinish();
            } else {
                activity.runOnUiThread(() -> loadingPopupView.dismissWith(this::onFinish));
            }
        } else {
            onFinish();
        }
    }

    /**
     * On start.
     *
     * @param subscription the subscription
     */
    public abstract void onStart(Subscription subscription);

    /**
     * On success.
     *
     * @param t the t
     */
    public abstract void onSuccess(@NonNull T t);

    /**
     * On success.
     */
    public abstract void onFinish();

    /**
     * On fail.
     *
     * @param e the e
     */
    public abstract void onFail(Throwable e);
}