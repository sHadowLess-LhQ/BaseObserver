package cn.com.shadowless.baseobserver;

/**
 * 观察者监听抽象封装规范
 *
 * @param <T> 泛型参数
 * @author sHadowLess
 */
public interface ObserveEventSpecification<T> {

    /**
     * 开始事件
     */
    void onStartEvent();

    /**
     * 刷新事件
     *
     * @param t 数据对象
     */
    void onRefreshEvent(T t);

    /**
     * 加载事件
     *
     * @param t 数据对象
     */
    void onLoadEvent(T t);

    /**
     * 成功事件
     *
     * @param t 数据对象
     */
    void onSuccessEvent(T t);

    /**
     * 完成事件
     */
    void onFinishEvent();

    /**
     * 失败事件
     *
     * @param error 错误信息
     * @param e     异常对象
     */
    void onFailEvent(String error, Throwable e);
}