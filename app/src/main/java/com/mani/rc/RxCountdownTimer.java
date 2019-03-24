package com.mani.rc;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

public class RxCountdownTimer {

    private final Scheduler scheduler;

    public RxCountdownTimer() {
        this(Schedulers.computation());
    }

    public RxCountdownTimer(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    public Observable<Long> observe(long millisInFuture) {
        if (millisInFuture < 0) {
            throw new IllegalArgumentException(" param millisInFuture must be larger or equal than 0");
        }
        long count = millisInFuture / 1000;
        long initialDelay = millisInFuture % 1000;
        return Observable.interval(initialDelay,
                1000, TimeUnit.MILLISECONDS,
                scheduler).take(count).map(value -> count - value);
    }
}