package com.mani.rc;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ItemViewHolder extends AutoDisposeViewHolder implements Ticker.Callback {
    private final Ticker ticker;
    @BindView(R.id.timestamp)
    TextView timeStamp;
    @BindView(R.id.bck)
    ImageView imageView;

    public ItemViewHolder(View itemView) {
        super(itemView);
        System.out.println("ItemViewHolder created");
        ticker = new Ticker(this);
        ButterKnife.bind(this, itemView);
    }

    public void bind(long remain) {
        ticker.start(remain, this);
    }

    @Override
    public void onTick(long secondsUntilFinished) {
        timeStamp.setText(String.valueOf(secondsUntilFinished));
        System.out.println("remainTime:" + secondsUntilFinished);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onFinish() {
        timeStamp.setText("onFinish");
        System.out.println("onComplete:");
    }
}
