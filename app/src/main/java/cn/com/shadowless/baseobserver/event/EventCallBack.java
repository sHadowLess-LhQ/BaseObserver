package cn.com.shadowless.baseobserver.event;

import kotlin.NotImplementedError;

public interface EventCallBack {

    int REFRESH = 0;

    int LOAD = 1;

    default int getState() {
        throw new NotImplementedError("Not yet implemented");
    }

    default void finishRefresh() {
        throw new NotImplementedError("Not yet implemented");
    }

    default void finishLoad() {
        throw new NotImplementedError("Not yet implemented");
    }

    default void show() {
        throw new NotImplementedError("Not yet implemented");
    }

    default void dismiss() {
        throw new NotImplementedError("Not yet implemented");
    }

    default int getAnimationDuration() {
        return 0;
    }
}
