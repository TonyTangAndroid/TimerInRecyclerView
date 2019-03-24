package com.mani.rc;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.observers.TestObserver;
import io.reactivex.schedulers.TestScheduler;


public class SchedulerTest {



    @Test
    public void should_not_complete_on_no_time_advanced() {
        TestScheduler scheduler = new TestScheduler();
        TestObserver<Long> testObserver = Observable.timer(5, TimeUnit.SECONDS, scheduler).test();
        testObserver.assertNotComplete();
    }


    @Test
    public void should_not_complete_on_no_enough_time_advanced() {
        TestScheduler scheduler = new TestScheduler();
        TestObserver<Long> testObserver = Observable.timer(5, TimeUnit.SECONDS, scheduler).test();
        scheduler.advanceTimeBy(1, TimeUnit.MILLISECONDS);
        testObserver.assertNotComplete();
    }

    @Test
    public void should_complete_on_enough_time_advanced() {
        TestScheduler scheduler = new TestScheduler();
        TestObserver<Long> testObserver = Observable.timer(5, TimeUnit.SECONDS, scheduler).test();
        scheduler.advanceTimeBy(6, TimeUnit.DAYS);
        testObserver.assertComplete();
    }


    @Test
    public void should_not_complete_on_useless_schedule_specified() {
        TestScheduler scheduler = new TestScheduler();
        TestObserver<Long> testObserver = Observable.timer(5, TimeUnit.SECONDS)
                .subscribeOn(scheduler).test();
        scheduler.advanceTimeBy(6, TimeUnit.DAYS);
        testObserver.assertNotComplete();
    }


}