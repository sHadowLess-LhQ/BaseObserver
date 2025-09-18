package cn.com.shadowless.baseobserver;


import android.os.Handler;
import android.os.Looper;

import cn.com.shadowless.baseobserver.event.EventCallBack;
import io.reactivex.rxjava3.annotations.NonNull;

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
    protected int loadingTime = 0;

    /**
     * 加载弹窗视图
     */
    protected EventCallBack callBack = null;

    /**
     * 执行
     */
    protected final Handler handler = new Handler(Looper.getMainLooper());

    /**
     * 自动完成刷新或加载操作
     *
     * @param state    刷新状态
     * @param callBack 刷新
     */
    protected void autoFinishRefreshAndLoad(int state, EventCallBack callBack) {
        if (state == EventCallBack.REFRESH) {
            callBack.finishRefresh();
        } else if (state == EventCallBack.LOAD) {
            callBack.finishLoad();
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
    public abstract void success(@NonNull T t);

    /**
     * 失败事件
     *
     * @param error 错误信息
     * @param e     异常对象
     */
    public abstract void fail(@NonNull String error, @NonNull Throwable e);

    /**
     * 完成事件
     */
    public abstract void finish();
}