package com.pushtorefresh.storio.operations.internal;

import android.support.annotation.NonNull;

import com.pushtorefresh.storio.operations.PreparedOperation;

import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;

/**
 * Required to avoid problems with ClassLoader when RxJava is not in ClassPath
 * We can not use anonymous classes from RxJava directly in StorIO, ClassLoader won't be happy :(
 * <p>
 * For internal usage only!
 */
public final class FlowableOnSubscribeExecuteAsBlocking<Result> implements FlowableOnSubscribe<Result> {

    @NonNull
    private final PreparedOperation<Result> preparedOperation;

    public FlowableOnSubscribeExecuteAsBlocking(@NonNull PreparedOperation<Result> preparedOperation) {
        this.preparedOperation = preparedOperation;
    }

    @Override
    public void subscribe(@io.reactivex.annotations.NonNull FlowableEmitter<Result> emitter) throws Exception {
        try {
            emitter.onNext(preparedOperation.executeAsBlocking());
        } catch (Exception e) {
            emitter.onError(e);
        }

        emitter.onComplete();
    }
}