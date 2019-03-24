package com.mani.rc;

import com.uber.autodispose.ScopeProvider;

import io.reactivex.observers.DisposableObserver;

import static com.uber.autodispose.AutoDispose.autoDisposable;

public class Ticker {
    private final ScopeProvider provider;
    private final RxCountdownTimer countdownTimer;

    public Ticker(ScopeProvider provider) {
        this.provider = provider;
        this.countdownTimer = new RxCountdownTimer();
    }

    public void start(long millisInFuture, Callback callback) {
        countdownTimer.observe(millisInFuture).as(autoDisposable(provider)).subscribe(new DisposableObserver<Long>() {
            @Override
            public void onNext(Long secondsUntilFinished) {
                callback.onTick(secondsUntilFinished);
            }

            @Override
            public void onError(Throwable e) {
                throw new IllegalStateException(e);
            }

            @Override
            public void onComplete() {
                callback.onFinish();
            }
        });

    }


    public interface Callback {

        void onTick(long secondsUntilFinished);

        void onFinish();
    }
}
