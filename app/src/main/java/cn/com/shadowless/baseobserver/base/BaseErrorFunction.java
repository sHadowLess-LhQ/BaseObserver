package cn.com.shadowless.baseobserver.base;

import android.util.Log;

import io.reactivex.rxjava3.functions.Function;

/**
 * 基础错误函数接口
 *
 * @param <R> 返回值类型
 * @author sHadowLess
 */
public interface BaseErrorFunction<R> extends Function<Throwable, R> {

    @Override
    default R apply(Throwable throwable) throws Throwable {
        return apply(Log.getStackTraceString(throwable), throwable);
    }

    /**
     * 应用处理方法
     *
     * @param error 错误信息
     * @param e     异常对象
     * @return 处理结果
     * @throws Throwable 异常
     */
    R apply(String error, Throwable e) throws Throwable;
}