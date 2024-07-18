package cn.com.shadowless.baseobserver;


/**
 * The type Base abstract.
 *
 * @param <T> the type parameter
 * @author sHadowLess
 */
public abstract class BaseAbstract<T> {
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
     */
    public abstract void fail(String error);

    /**
     * Finish.
     */
    public abstract void finish();
}
