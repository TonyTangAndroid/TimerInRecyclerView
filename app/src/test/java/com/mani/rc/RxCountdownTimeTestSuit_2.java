package com.mani.rc;

import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.observers.TestObserver;
import io.reactivex.schedulers.TestScheduler;


public class RxCountdownTimeTestSuit_2 {

    private TestScheduler testScheduler;
    private TestObserver<Long> observer;

    @Before
    public void setup() {
        testScheduler = new TestScheduler();
        RxCountdownTimer countdownTimer = new RxCountdownTimer(testScheduler);
        Observable<Long> observable = countdownTimer.observe(10L * 1000);
        observer = observable.test();
    }

    @Test
    public void emit_no_values_on_subscribed() {
        observer.assertNoValues();
    }

    @Test
    public void emit_2_values_when_subscribed_and_advanced_by_2s() {

        observer.assertNoValues();
        testScheduler.advanceTimeBy(2, TimeUnit.SECONDS);
        observer.assertValues(10L, 9L, 8L);
        observer.assertNotComplete();

    }

    @Test
    public void emit_10_values_when_subscribed_and_advanced_by_9s_and_complete() {

        observer.assertNoValues();
        testScheduler.advanceTimeBy(9500, TimeUnit.MILLISECONDS);
        observer.assertValues(10L, 9L, 8L, 7L, 6L, 5L, 4L, 3L, 2L, 1L);
        observer.assertComplete();

    }

    @Test
    public void emit_10_values_when_subscribed_and_advanced_by_10s() {

        observer.assertNoValues();
        testScheduler.advanceTimeBy(10, TimeUnit.SECONDS);
        observer.assertValues(10L, 9L, 8L, 7L, 6L, 5L, 4L, 3L, 2L, 1L);
    }

    @Test
    public void emit_10_values_and_complete_when_subscribed_and_advanced_by_10s() {
        observer.assertNoValues();
        testScheduler.advanceTimeBy(10, TimeUnit.SECONDS);
        observer.assertComplete();
    }

    @Test
    public void emit_4_values_when_subscribed_and_advanced_by_3s_and_not_complete() {

        observer.assertNoValues();
        testScheduler.advanceTimeBy(3000, TimeUnit.MILLISECONDS);
        observer.assertValues(10L, 9L, 8L, 7L);
        observer.assertNotComplete();

    }

}