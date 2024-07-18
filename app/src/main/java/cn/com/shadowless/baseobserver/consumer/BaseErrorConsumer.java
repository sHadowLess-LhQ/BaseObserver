package cn.com.shadowless.baseobserver.consumer;

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
        error(Log.getStackTraceString(throwable));
    }

    /**
     * Error.
     *
     * @param error the error
     */
    void error(String error);
}
