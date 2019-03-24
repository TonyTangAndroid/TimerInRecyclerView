package com.mani.rc;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.observers.TestObserver;
import io.reactivex.schedulers.TestScheduler;


public class RawCountdownTimerUnitTest {

    @Test
    public void emit_no_values_on_subscribed() {
        TestScheduler testScheduler = new TestScheduler();
        Observable<Long> observable = countdownTimer(10L, testScheduler);
        TestObserver<Long> testObserver = observable.test();
        testObserver.assertNoValues();
    }

    @Test
    public void emit_2_values_when_subscribed_and_advanced_by_2s() {
        TestScheduler testScheduler = new TestScheduler();
        Observable<Long> observable = countdownTimer(10L, testScheduler);
        TestObserver<Long> observer = observable.test();
        observer.assertNoValues();
        testScheduler.advanceTimeBy(2, TimeUnit.SECONDS);
        observer.assertValues(10L, 9L);
        observer.assertNotComplete();
    }


    @Test
    public void emit_9_values_when_subscribed_and_advanced_by_9s_and_not_complete() {
        TestScheduler testScheduler = new TestScheduler();
        Observable<Long> observable = countdownTimer(10L, testScheduler);
        TestObserver<Long> observer = observable.test();
        observer.assertNoValues();
        testScheduler.advanceTimeBy(9500, TimeUnit.MILLISECONDS);
        observer.assertValues(10L, 9L, 8L, 7L, 6L, 5L, 4L, 3L, 2L);
        observer.assertNotComplete();

    }

    @Test
    public void emit_10_values_when_subscribed_and_advanced_by_10s() {
        TestScheduler testScheduler = new TestScheduler();
        Observable<Long> observable = countdownTimer(10L, testScheduler);
        TestObserver<Long> observer = observable.test();
        observer.assertNoValues();
        testScheduler.advanceTimeBy(10, TimeUnit.SECONDS);
        observer.assertValues(10L, 9L, 8L, 7L, 6L, 5L, 4L, 3L, 2L, 1L);
    }

    @Test
    public void emit_10_values_and_complete_when_subscribed_and_advanced_by_10s() {
        TestScheduler testScheduler = new TestScheduler();
        Observable<Long> observable = countdownTimer(10L, testScheduler);
        TestObserver<Long> observer = observable.test();
        observer.assertNoValues();
        testScheduler.advanceTimeBy(10, TimeUnit.SECONDS);
        observer.assertComplete();
    }

    @Test
    public void emit_10_values_when_subscribed_and_advanced_by_100s() {
        TestScheduler testScheduler = new TestScheduler();
        Observable<Long> observable = countdownTimer(5L, testScheduler);
        TestObserver<Long> observer = observable.test();
        observer.assertNoValues();
        testScheduler.advanceTimeBy(10, TimeUnit.SECONDS);
        observer.assertValues(5L, 4L, 3L, 2L, 1L);
        observer.assertComplete();
    }

    private Observable<Long> countdownTimer(Long start, Scheduler testScheduler) {
        return Observable.interval(1, TimeUnit.SECONDS, testScheduler)
                .take(start).map(value -> start - value);
    }


}