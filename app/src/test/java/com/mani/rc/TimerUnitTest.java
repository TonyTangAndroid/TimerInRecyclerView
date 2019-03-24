package com.mani.rc;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.observers.TestObserver;
import io.reactivex.schedulers.TestScheduler;


public class TimerUnitTest {

    @Test
    public void should_complete_on_enough_time_advanced() {
        TestScheduler scheduler = new TestScheduler();
        TestObserver<Long> testObserver = Observable.timer(5, TimeUnit.SECONDS, scheduler).test();
        testObserver.assertNoValues();
        scheduler.advanceTimeBy(3, TimeUnit.SECONDS);
        testObserver.assertNoValues();
        scheduler.advanceTimeBy(3, TimeUnit.SECONDS);
        testObserver.assertValues(0L);

    }
}