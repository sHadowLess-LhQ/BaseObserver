package cn.com.shadowless.baseobserver;

import android.app.Activity;

import androidx.annotation.NonNull;

import com.lxj.xpopup.XPopup;
import com.lxj.xpopup.core.BasePopupView;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

/**
 * The type Base observer.
 *
 * @param <T> the type parameter
 * @author sHadowLess
 */
public abstract class BaseSingleObserver<T> implements SingleObserver<T> {

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
    public BaseSingleObserver() {
    }

    /**
     * Instantiates a new Base observer.
     *
     * @param activity         the activity
     * @param isSmartDismiss   the is smart dismiss
     * @param loadingPopupView the loading popup view
     */
    public BaseSingleObserver(Activity activity, boolean isSmartDismiss, BasePopupView loadingPopupView) {
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
    public BaseSingleObserver(Activity activity, LoadingConfig config) {
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
    public void onSubscribe(@NonNull Disposable d) {
        if (loadingPopupView != null) {
            activity.runOnUiThread(() -> {
                onStart(d);
                loadingPopupView.show();
            });
        }
    }

    @Override
    public void onSuccess(@NonNull T t) {
        if (loadingPopupView != null) {
            if (isSmartDismiss) {
                activity.runOnUiThread(() -> loadingPopupView.smartDismiss());
                onFinish(t);
            } else {
                activity.runOnUiThread(() -> loadingPopupView.dismissWith(() -> onFinish(t)));
            }
        } else {
            onFinish(t);
        }
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

    /**
     * On start.
     *
     * @param disposable the disposable
     */
    public abstract void onStart(Disposable disposable);

    /**
     * On success.
     *
     * @param t the t
     */
    public abstract void onFinish(@NonNull T t);

    /**
     * On fail.
     *
     * @param e the e
     */
    public abstract void onFail(Throwable e);
}