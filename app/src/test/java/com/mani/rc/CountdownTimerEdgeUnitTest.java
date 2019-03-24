package com.mani.rc;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.observers.TestObserver;
import io.reactivex.schedulers.TestScheduler;


public class CountdownTimerEdgeUnitTest {

    @Test
    public void emit_no_values_when_subscribed_with_0s_remain_time() {

        TestScheduler testScheduler = new TestScheduler();
        CountdownTimer countdownTimer = new CountdownTimer(testScheduler);
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
        CountdownTimer countdownTimer = new CountdownTimer(testScheduler);
        countdownTimer.observe(-1L);
    }


}