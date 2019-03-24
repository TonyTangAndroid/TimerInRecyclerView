package com.mani.rc;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Scheduler;

public class CountdownTimer {

    private final Scheduler scheduler;

    public CountdownTimer(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    public Observable<Long> subscribe(Long start) {
        return Observable.interval(1, TimeUnit.SECONDS, scheduler)
                .take(start).map(value -> start - value);
    }
}