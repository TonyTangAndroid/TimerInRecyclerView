package com.mani.rc;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ItemViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.timestamp)
    TextView timeStamp;
    @BindView(R.id.bck)
    ImageView imageView;

    public ItemViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(TimeEntity timeEntity) {
        timeStamp.setText(timeEntity.desc());
    }
}
