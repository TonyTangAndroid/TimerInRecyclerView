package com.mani.rc;

import android.os.Bundle;
import android.util.Log;

import com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider;

import java.util.concurrent.TimeUnit;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import io.reactivex.Observable;

import static com.uber.autodispose.AutoDispose.autoDisposable;

/**
 * Demo activity, shamelessly borrowed from the RxLifecycle sample.
 * <p>
 * This leverages the Architecture Components support for the demo.
 */
public class JavaActivity extends AppCompatActivity {

    private static final String TAG = "JavaActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(TAG, "onCreate()");

        setContentView(R.layout.activity_java);

        // Using automatic disposal, this should determine that the correct time to
        // dispose is onDestroy (the opposite of onCreate).
        Observable.interval(1, TimeUnit.SECONDS)
                .doOnDispose(() -> Log.i(TAG, "Disposing subscription from onCreate()"))
                .as(autoDisposable(AndroidLifecycleScopeProvider.from(this)))
                .subscribe(num -> Log.i(TAG, "Started in onCreate(), running until onDestroy(): " + num));

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, new JavaFragment())
                .commitNow();
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d(TAG, "onStart()");

        // Using automatic disposal, this should determine that the correct time to
        // dispose is onStop (the opposite of onStart).
        Observable.interval(1, TimeUnit.SECONDS)
                .doOnDispose(() -> Log.i(TAG, "Disposing subscription from onStart()"))
                .as(autoDisposable(AndroidLifecycleScopeProvider.from(this)))
                .subscribe(num -> Log.i(TAG, "Started in onStart(), running until in onStop(): " + num));
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d(TAG, "onResume()");

        // Using automatic disposal, this should determine that the correct time to
        // dispose is onPause (the opposite of onResume).
        Observable.interval(1, TimeUnit.SECONDS)
                .doOnDispose(() -> Log.i(TAG, "Disposing subscription from onResume()"))
                .as(autoDisposable(AndroidLifecycleScopeProvider.from(this)))
                .subscribe(num -> Log.i(TAG, "Started in onResume(), running until in onPause(): " + num));

        // Setting a specific untilEvent, this should dispose in onDestroy.
        Observable.interval(1, TimeUnit.SECONDS)
                .doOnDispose(() -> Log.i(TAG, "Disposing subscription from onResume() with untilEvent ON_DESTROY"))
                .as(autoDisposable(AndroidLifecycleScopeProvider.from(this, Lifecycle.Event.ON_DESTROY)))
                .subscribe(num -> Log.i(TAG, "Started in onResume(), running until in onDestroy(): " + num));
    }


}
