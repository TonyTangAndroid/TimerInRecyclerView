package com.mani.rc;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.observers.TestObserver;
import io.reactivex.schedulers.TestScheduler;


public class InternalUnitTest {

    @Test
    public void should_emit_no_value_when_subscribed_without_initial_delay() {
        TestScheduler scheduler = new TestScheduler();
        TestObserver<Long> testObserver = Observable.interval(5, TimeUnit.SECONDS, scheduler).test();
        testObserver.assertNoValues();
    }

    @Test
    public void should_emit_no_value_even_when_subscribed_with_zero_initial_delay() {
        TestScheduler scheduler = new TestScheduler();
        TestObserver<Long> testObserver = Observable.interval(0, 5, TimeUnit.SECONDS, scheduler).test();
        testObserver.assertNoValues();
    }

    @Test
    public void should_emit_no_value_even_when_subscribed_with_1_second_initial_delay() {
        TestScheduler scheduler = new TestScheduler();
        TestObserver<Long> testObserver = Observable.interval(1, 5, TimeUnit.SECONDS, scheduler).test();
        testObserver.assertNoValues();
    }

    @Test
    public void should_emit_one_value_as_0_when_subscribed_with_1s_initial_delay_and_advanced_1s() {
        TestScheduler scheduler = new TestScheduler();
        TestObserver<Long> testObserver = Observable.interval(1, 5, TimeUnit.SECONDS, scheduler).test();
        scheduler.advanceTimeBy(1, TimeUnit.SECONDS);
        testObserver.assertValues(0L);
    }

    @Test
    public void should_emit_one_value_as_0_when_subscribed_and_advanced_1_unit() {
        TestScheduler scheduler = new TestScheduler();
        TestObserver<Long> testObserver = Observable.interval(5, TimeUnit.SECONDS, scheduler).test();
        scheduler.advanceTimeBy(5, TimeUnit.SECONDS);
        testObserver.assertValues(0L);
    }


    @Test
    public void should_emit_tree_value_as_012_when_subscribed_with_1s_initial_delay_and_advanced_14s() {
        TestScheduler scheduler = new TestScheduler();
        TestObserver<Long> testObserver = Observable.interval(1, 5, TimeUnit.SECONDS, scheduler).test();
        scheduler.advanceTimeBy(14, TimeUnit.SECONDS);
        testObserver.assertValues(0L, 1L, 2L);
        testObserver.assertNotComplete();
    }


    @Test
    public void should_emit_tree_value_as_01234_when_subscribed_with_1s_initial_delay_and_advanced_14s_plus_11s() {
        TestScheduler scheduler = new TestScheduler();
        TestObserver<Long> testObserver = Observable.interval(1, 5, TimeUnit.SECONDS, scheduler).test();
        scheduler.advanceTimeBy(14, TimeUnit.SECONDS);
        testObserver.assertValues(0L, 1L, 2L);
        scheduler.advanceTimeBy(11, TimeUnit.SECONDS);
        testObserver.assertValues(0L, 1L, 2L, 3L, 4L);
    }

    @Test
    public void should_emit_tree_value_as_012345_when_subscribed_with_1s_initial_delay_and_advanced_14s_plus_12s() {
        TestScheduler scheduler = new TestScheduler();
        TestObserver<Long> testObserver = Observable.interval(1, 5, TimeUnit.SECONDS, scheduler).test();
        scheduler.advanceTimeBy(14, TimeUnit.SECONDS);
        testObserver.assertValues(0L, 1L, 2L);
        scheduler.advanceTimeBy(12, TimeUnit.SECONDS);
        testObserver.assertValues(0L, 1L, 2L, 3L, 4L, 5L);
    }

}