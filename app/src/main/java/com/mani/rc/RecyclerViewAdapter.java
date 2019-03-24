package com.mani.rc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.ButterKnife;

public class RecyclerViewAdapter extends RecyclerView.Adapter<ItemViewHolder> {

    private final List<Long> list;

    public RecyclerViewAdapter() {
        list = DataRepo.shift(DataRepo.diff());
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.recycler_item, parent, false);
        ButterKnife.bind(this, view);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.bind(Math.max(list.get(position) - nowInMillseconds(), 0L));
    }

    private long nowInMillseconds() {
        return System.currentTimeMillis();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}
