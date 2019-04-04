package com.syf.ghost.cloudmusic.base;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Android on 2019/4/3.
 * auth Shangyifei
 */
public class MultiTypeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> adapters = new ArrayList<>();
    private SparseArray<RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> sparseArray = new SparseArray<>();
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int type) {
        return sparseArray.get(type).onCreateViewHolder(viewGroup, type);
    }
    @Override
    public int getItemCount() {
        int flatCount = 0;
        for (RecyclerView.Adapter adapter : adapters) {
            flatCount += adapter.getItemCount();
        }

        return flatCount;
    }
    @Override
    public int getItemViewType(int flatPoi) {
        return getDelegateAdapterItemType(flatPoi);
    }

    public RecyclerView.Adapter<RecyclerView.ViewHolder> getDelegateAdapterByPosition(int flatPoi) {
        int totalCount = 0;
        for (RecyclerView.Adapter adapter : adapters) {
            totalCount+=adapter.getItemCount();
            if (flatPoi < totalCount) {
                return adapter;
            }
        }
        return null;
    }

    private int flatPositionToDelegateAdapterPosition(int flatPoi) {
        int totalCount = 0;
        int preTotalCount = 0;
        for (RecyclerView.Adapter adapter : adapters) {
            totalCount += adapter.getItemCount();
            if (flatPoi < totalCount) {
                return flatPoi - preTotalCount;
            }
            preTotalCount += adapter.getItemCount();
        }
        return 0;
    }

    private int getDelegateAdapterItemType(int poi) {
        int delegatePoi = flatPositionToDelegateAdapterPosition(poi);
        RecyclerView.Adapter delegateAdapter = getDelegateAdapterByPosition(poi);
        int type = delegateAdapter.getItemViewType(delegatePoi);
        sparseArray.put(type, delegateAdapter);
        return type;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int poi) {
        getDelegateAdapterByPosition(poi).onBindViewHolder(viewHolder,flatPositionToDelegateAdapterPosition(poi));
    }

    public void setAdapter(List<? extends RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> adapters) {
        this.adapters.clear();
        this.adapters.addAll(adapters);
        notifyDataSetChanged();
    }
}