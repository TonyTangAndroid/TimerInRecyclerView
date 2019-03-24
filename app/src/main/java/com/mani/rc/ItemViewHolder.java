package com.mani.rc;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.uber.autodispose.AutoDispose.autoDisposable;

public class ItemViewHolder extends AutoDisposeViewHolder {
    private final CountdownTimer countdownTimer;
    @BindView(R.id.timestamp)
    TextView timeStamp;
    @BindView(R.id.bck)
    ImageView imageView;

    public ItemViewHolder(View itemView) {
        super(itemView);
        countdownTimer = new CountdownTimer();
        ButterKnife.bind(this, itemView);
    }

    public void bind(long remain) {
        countdownTimer.observe(remain).
                as(autoDisposable(this)).subscribe(this::onTick, this::onError, this::onComplete);

    }

    @SuppressLint("SetTextI18n")
    private void onComplete() {
        timeStamp.setText("ended");
        System.out.println("onComplete:");
    }

    private void onError(Throwable throwable) {
        timeStamp.setText(throwable.getMessage());

    }

    private void onTick(Long remainTime) {
        timeStamp.setText(String.valueOf(remainTime));
        System.out.println("remainTime:" + remainTime);
    }
}
