package com.mani.rc;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {


    private Handler handler = new Handler();

    public RecyclerViewAdapter() {
    }

    public void clearAll() {
        handler.removeCallbacksAndMessages(null);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.recycler_item, parent, false);
        ButterKnife.bind(this, view);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind();
    }

    @Override
    public int getItemCount() {
        return 100;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.timestamp)
        TextView timeStamp;
        @BindView(R.id.bck)
        ImageView imageView;
        CustomRunnable customRunnable;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            customRunnable = new CustomRunnable(handler, timeStamp, 10000, imageView);
        }

        public void bind() {
            handler.removeCallbacks(customRunnable);
            customRunnable.holder = timeStamp;
            customRunnable.millisUntilFinished = 10000 * getAdapterPosition();
            handler.postDelayed(customRunnable, 100);

        }
    }
}
