package cn.com.shadowless.baseobserver;


import android.app.Activity;

import com.lxj.xpopup.XPopup;
import com.lxj.xpopup.core.BasePopupView;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.constant.RefreshState;

/**
 * 观察者公共抽象封装规范（包含公共方法和变量）
 *
 * @param <T> the type parameter
 * @author sHadowLess
 */
public abstract class BaseAbstract<T> {

    /**
     * The Time.
     */
    protected int loadingTime = 500;

    /**
     * The Loading popup view.
     */
    protected BasePopupView loadingPopupView = null;

    /**
     * Gets loading pop view.
     *
     * @param activity the activity
     * @param config   the config
     * @return the loading pop view
     */
    protected BasePopupView getLoadingPopView(Activity activity, LoadingConfig config) {
        return new XPopup
                .Builder(activity)
                .isDestroyOnDismiss(config.isDestroyOnDismiss())
                .isViewMode(config.isViewModel())
                .dismissOnBackPressed(config.isCanBackCancel())
                .dismissOnTouchOutside(config.isCanOutSideCancel())
                .hasBlurBg(config.isHasBlurBg())
                .hasShadowBg(config.isHasShadow())
                .asLoading(config.getLoadName());
    }

    /**
     * Auto finish refresh and load.
     *
     * @param state  the state
     * @param layout the layout
     */
    protected void autoFinishRefreshAndLoad(RefreshState state, SmartRefreshLayout layout) {
        if (state == RefreshState.Refreshing) {
            layout.finishRefresh();
        } else if (state == RefreshState.Loading) {
            layout.finishLoadMore();
        }
    }

    /**
     * Start.
     */
    public abstract void start();

    /**
     * Success.
     *
     * @param t the t
     */
    public abstract void success(T t);

    /**
     * Fail.
     *
     * @param error the error
     * @param e     the e
     */
    public abstract void fail(String error, Throwable e);

    /**
     * Finish.
     */
    public abstract void finish();
}
