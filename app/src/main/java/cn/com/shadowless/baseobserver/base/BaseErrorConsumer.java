package cn.com.shadowless.baseobserver.base;

import android.util.Log;

import io.reactivex.rxjava3.functions.Consumer;

/**
 * 基础错误消费者接口
 *
 * @author sHadowLess
 */
public interface BaseErrorConsumer extends Consumer<Throwable> {

    @Override
    default void accept(Throwable throwable) throws Throwable {
        error(Log.getStackTraceString(throwable), throwable);
    }

    /**
     * 错误处理方法
     *
     * @param error 错误信息
     * @param e     异常对象
     * @throws Throwable 异常
     */
    void error(String error, Throwable e) throws Throwable;
}