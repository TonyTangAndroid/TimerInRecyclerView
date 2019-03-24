package com.mani.rc;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.observers.TestObserver;
import io.reactivex.schedulers.TestScheduler;


public class RxCountdownTimeTestSuit_1 {


    @Test
    public void emit_no_value_when_subscribed_with_5100ms_remain_time_and_advanced_99ms() {

        TestScheduler testScheduler = new TestScheduler();
        RxCountdownTimer countdownTimer = new RxCountdownTimer(testScheduler);
        Observable<Long> observable = countdownTimer.observe(5100L);
        TestObserver<Long> observer = observable.test();
        observer.assertNoValues();
        testScheduler.advanceTimeBy(99, TimeUnit.MILLISECONDS);
        observer.assertNoValues();
        observer.assertNotComplete();
    }

    @Test
    public void emit_1_value_when_subscribed_with_5100ms_remain_time_and_advanced_100() {

        TestScheduler testScheduler = new TestScheduler();
        RxCountdownTimer countdownTimer = new RxCountdownTimer(testScheduler);
        Observable<Long> observable = countdownTimer.observe(5100L);
        TestObserver<Long> observer = observable.test();
        observer.assertNoValues();
        testScheduler.advanceTimeBy(100, TimeUnit.MILLISECONDS);
        observer.assertValues(5L);
        observer.assertNotComplete();
    }

    @Test
    public void emit_3_value_when_subscribed_with_5100ms_remain_time_and_advanced_2100() {

        TestScheduler testScheduler = new TestScheduler();
        RxCountdownTimer countdownTimer = new RxCountdownTimer(testScheduler);
        Observable<Long> observable = countdownTimer.observe(5100L);
        TestObserver<Long> observer = observable.test();
        observer.assertNoValues();
        testScheduler.advanceTimeBy(2100, TimeUnit.MILLISECONDS);
        observer.assertValues(5L, 4L, 3L);
        observer.assertNotComplete();
    }

    @Test
    public void emit_5_value_when_subscribed_with_5100ms_remain_time_and_advanced_4100() {

        TestScheduler testScheduler = new TestScheduler();
        RxCountdownTimer countdownTimer = new RxCountdownTimer(testScheduler);
        Observable<Long> observable = countdownTimer.observe(5100L);
        TestObserver<Long> observer = observable.test();
        observer.assertNoValues();
        testScheduler.advanceTimeBy(4100, TimeUnit.MILLISECONDS);
        observer.assertValues(5L, 4L, 3L, 2L, 1L);
//        observer.assertNotComplete();
    }


}