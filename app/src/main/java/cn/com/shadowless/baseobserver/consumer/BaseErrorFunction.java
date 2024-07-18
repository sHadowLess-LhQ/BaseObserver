package cn.com.shadowless.baseobserver.consumer;

import android.util.Log;

import io.reactivex.rxjava3.functions.Function;

/**
 * The type Base error function.
 *
 * @param <R> the type parameter
 * @author sHadowLess
 */
public interface BaseErrorFunction<R> extends Function<Throwable, R> {

    @Override
    default R apply(Throwable throwable) throws Throwable {
        return apply(Log.getStackTraceString(throwable));
    }

    /**
     * Apply r.
     *
     * @param error the error
     * @return the r
     */
    R apply(String error);
}
