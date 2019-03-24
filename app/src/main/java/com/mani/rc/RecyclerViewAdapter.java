package com.mani.rc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.ButterKnife;

public class RecyclerViewAdapter extends RecyclerView.Adapter<ItemViewHolder> {

    private static final long NONE = 0;
    private static final long ONE_SECOND = 1;
    private static final long ONE_MINUTE = 60;
    private static final long ONE_HOUR = ONE_MINUTE * 60;
    private static final long ONE_DAY = ONE_HOUR * 24;
    private static final long ONE_MONTH = ONE_DAY * 30;
    private static final long ONE_YEAR = ONE_MONTH * 12;

    private final List<Long> list;

    public RecyclerViewAdapter() {
        list = shift(diff());
    }

    private List<Long> shift(List<Long> diff) {
        List<Long> result = new ArrayList<>(diff.size());
        for (Long item : diff) {
            result.add(item + 1553394032
            );//Saturday, March 23, 2019 7:10:38 PM GMT-07:00

        }
        return result;

    }

    private List<Long> diff() {
        return Arrays.asList(
                ONE_YEAR,
                ONE_MINUTE,
                NONE,
                ONE_DAY,
                ONE_SECOND,
                ONE_HOUR,
                ONE_MONTH, ONE_YEAR,
                ONE_MINUTE,
                NONE,
                ONE_DAY,
                ONE_SECOND,
                ONE_HOUR,
                ONE_MONTH,
                ONE_YEAR,
                ONE_MINUTE,
                NONE,
                ONE_DAY,
                ONE_SECOND,
                ONE_HOUR,
                ONE_MONTH,
                ONE_YEAR,
                ONE_MINUTE,
                NONE,
                ONE_DAY,
                ONE_SECOND,
                ONE_HOUR,
                ONE_MONTH,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE
                );
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
        holder.bind(Math.max(list.get(position) - nowInSeconds(), 0L));
    }

    private long nowInSeconds() {
        return System.currentTimeMillis() / 1000;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}
