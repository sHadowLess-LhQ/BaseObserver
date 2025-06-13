package cn.com.shadowless.baseobserver.base;

import android.util.Log;

import io.reactivex.rxjava3.functions.Consumer;

/**
 * The type Base error consumer.
 *
 * @author sHadowLess
 */
public interface BaseErrorConsumer extends Consumer<Throwable> {

    @Override
    default void accept(Throwable throwable) throws Throwable {
        error(Log.getStackTraceString(throwable), throwable);
    }

    /**
     * Error.
     *
     * @param error the error
     * @param e     the e
     * @throws Throwable the throwable
     */
    void error(String error, Throwable e) throws Throwable;
}
