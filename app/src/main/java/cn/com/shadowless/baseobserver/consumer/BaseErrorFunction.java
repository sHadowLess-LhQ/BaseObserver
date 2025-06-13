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
        return apply(Log.getStackTraceString(throwable), throwable);
    }

    /**
     * Apply r.
     *
     * @param error the error
     * @param e     the e
     * @return the r
     * @throws Throwable the throwable
     */
    R apply(String error, Throwable e) throws Throwable;
}
