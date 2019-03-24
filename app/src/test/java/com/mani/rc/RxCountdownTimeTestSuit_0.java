package com.mani.rc;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.observers.TestObserver;
import io.reactivex.schedulers.TestScheduler;


public class RxCountdownTimeTestSuit_0 {

    @Test
    public void emit_no_values_when_subscribed_with_0s_remain_time() {

        TestScheduler testScheduler = new TestScheduler();
        RxCountdownTimer countdownTimer = new RxCountdownTimer(testScheduler);
        Observable<Long> observable = countdownTimer.observe(0L);
        TestObserver<Long> observer = observable.test();
        observer.assertNoValues();
        testScheduler.advanceTimeBy(2, TimeUnit.SECONDS);
        observer.assertNoValues();
        observer.assertComplete();
    }

    @Test(expected = IllegalArgumentException.class)
    public void throw_error_when_subscribed_with_invalid_remaining_time() {
        TestScheduler testScheduler = new TestScheduler();
        RxCountdownTimer countdownTimer = new RxCountdownTimer(testScheduler);
        countdownTimer.observe(-1L);
    }

}