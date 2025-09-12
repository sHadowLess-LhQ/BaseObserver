package cn.com.shadowless.baseobserver;


import android.app.Activity;

import com.lxj.xpopup.XPopup;
import com.lxj.xpopup.core.BasePopupView;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.constant.RefreshState;

/**
 * 观察者公共抽象封装规范（包含公共方法和变量）
 *
 * @param <T> 泛型参数
 * @author sHadowLess
 */
public abstract class BaseAbstract<T> {

    /**
     * 加载时间（毫秒）
     */
    protected int loadingTime = 500;

    /**
     * 加载弹窗视图
     */
    protected BasePopupView loadingPopupView = null;

    /**
     * 获取加载弹窗视图
     *
     * @param activity Activity上下文
     * @param config   加载配置
     * @return 加载弹窗视图
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
     * 自动完成刷新或加载操作
     *
     * @param state  刷新状态
     * @param layout 刷新布局
     */
    protected void autoFinishRefreshAndLoad(RefreshState state, SmartRefreshLayout layout) {
        if (state == RefreshState.Refreshing) {
            layout.finishRefresh();
        } else if (state == RefreshState.Loading) {
            layout.finishLoadMore();
        }
    }

    /**
     * 开始事件
     */
    public abstract void start();

    /**
     * 成功事件
     *
     * @param t 数据对象
     */
    public abstract void success(T t);

    /**
     * 失败事件
     *
     * @param error 错误信息
     * @param e     异常对象
     */
    public abstract void fail(String error, Throwable e);

    /**
     * 完成事件
     */
    public abstract void finish();
}