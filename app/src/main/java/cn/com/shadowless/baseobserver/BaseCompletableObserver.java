package cn.com.shadowless.baseobserver;

import android.app.Activity;

import androidx.annotation.NonNull;

import com.lxj.xpopup.XPopup;
import com.lxj.xpopup.core.BasePopupView;

import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;

/**
 * The type Base observer.
 *
 * @author sHadowLess
 */
public abstract class BaseCompletableObserver implements CompletableObserver {

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
    public BaseCompletableObserver() {
    }

    /**
     * Instantiates a new Base observer.
     *
     * @param activity         the activity
     * @param isSmartDismiss   the is smart dismiss
     * @param loadingPopupView the loading popup view
     */
    public BaseCompletableObserver(Activity activity, boolean isSmartDismiss, BasePopupView loadingPopupView) {
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
    public BaseCompletableObserver(Activity activity, LoadingConfig config) {
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
     * @param disposable the disposable
     */
    public abstract void onStart(Disposable disposable);

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