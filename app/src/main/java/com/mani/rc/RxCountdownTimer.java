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

    public Observable<Long> observe(Long start) {
        return Observable.interval(1, TimeUnit.SECONDS, scheduler)
                .take(start).map(value -> start - value);
    }
}