package cn.com.shadowless.baseobserver;

/**
 * 观察者监听抽象封装规范
 *
 * @param <T> the type parameter
 * @author sHadowLess
 */
public interface ObserveEventSpecification<T> {

    /**
     * On start.
     */
    void onStartEvent();

    /**
     * Finish refresh.
     *
     * @param t the t
     */
    void onRefreshEvent(T t);

    /**
     * Finish load.
     *
     * @param t the t
     */
    void onLoadEvent(T t);

    /**
     * On success.
     *
     * @param t the t
     */
    void onSuccessEvent(T t);

    /**
     * On finish.
     */
    void onFinishEvent();

    /**
     * On fail.
     *
     * @param error the error
     * @param e     the e
     */
    void onFailEvent(String error, Throwable e);
}
