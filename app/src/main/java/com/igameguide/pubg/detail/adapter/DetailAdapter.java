package com.igameguide.pubg.detail.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import com.igameguide.pubg.R;
import com.igameguide.pubg.detail.bean.HItemBean;
import com.igameguide.pubg.detail.bean.HeaderBean;
import com.igameguide.pubg.detail.bean.Paiwei;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailAdapter extends RecyclerView.Adapter {

    private List<Serializable> mData;
    private Context mContext;

    public DetailAdapter(Context mContext) {
        this.mContext = mContext;
        mData = new ArrayList<>();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        RecyclerView.ViewHolder vh = null;
        if (viewType == ItemType.GRID_ITEM) {
            GridView v = (GridView) LayoutInflater.from(mContext).inflate(R.layout.item_gridview, viewGroup, false);
            v.setAdapter(new GrdiViewAdapter());
            vh = new VHGrid(v);
            Log.d("wyl", "onCreateViewHolder VHGrid");
        } else if (viewType == ItemType.H_TITLE) {
            View v = LayoutInflater.from(mContext).inflate(R.layout.item_title, viewGroup, false);
            vh = new VHTitle(v);
            Log.d("wyl", "onCreateViewHolder VHTitle");
        } else {
            View v = LayoutInflater.from(mContext).inflate(R.layout.item_horizontal, viewGroup, false);
            vh = new VHHorizontal(v);
            Log.d("wyl", "onCreateViewHolder VHHorizontal");
        }

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder vh, int position) {

        Serializable bean = mData.get(position);

        if (vh instanceof VHGrid) {
            VHGrid vhGrid = (VHGrid) vh;
            if (bean instanceof Paiwei) {
                Paiwei paiwei = (Paiwei) bean;
                GrdiViewAdapter grdiViewAdapter = (GrdiViewAdapter) vhGrid.gridView.getAdapter();
                grdiViewAdapter.setData(paiwei.headerBeans);
                Log.d("wyl", "onBindViewHolder VHGrid");
            }
        } else if (vh instanceof VHHorizontal) {
            VHHorizontal vhHorizontal = (VHHorizontal) vh;
            if (bean instanceof HItemBean) {
                HItemBean hItemBean = (HItemBean) bean;
                vhHorizontal.tvDate.setText(hItemBean.date);
                vhHorizontal.tvKills.setText(hItemBean.kills);
                vhHorizontal.tvRating.setText(hItemBean.rating);
                vhHorizontal.tvScore.setText(hItemBean.score);

                Log.d("wyl", "onBindViewHolder vhHorizontal");
            }

        }


    }

    @Override
    public int getItemCount() {
        int size = mData == null ? 0 : mData.size();
        Log.d("wyl", "size:" + size);
        return size;
    }


    public void setData(List<Serializable> mData) {
        this.mData = mData;
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return ItemType.GRID_ITEM;
        } else if (position == 1) {
            return ItemType.H_TITLE;
        } else {
            return ItemType.H_ITEM;
        }
    }

    public static class VHGrid extends RecyclerView.ViewHolder {
        public GridView gridView;

        public VHGrid(GridView itemView) {
            super(itemView);
            this.gridView = itemView;
        }
    }

    public static class VHTitle extends RecyclerView.ViewHolder {

        public VHTitle(@NonNull View itemView) {
            super(itemView);
        }
    }

    public static class VHHorizontal extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_date)
        TextView tvDate;
        @BindView(R.id.tv_score)
        TextView tvScore;
        @BindView(R.id.tv_kills)
        TextView tvKills;
        @BindView(R.id.tv_rating)
        TextView tvRating;


        public VHHorizontal(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


    public void showPreQuery() {//显示查询前的UI
        Paiwei paiwei = Paiwei.getEmptyHeaderBean();
        mData.clear();
        mData.add(paiwei);
        notifyDataSetChanged();

    }

    private class GrdiViewAdapter extends BaseAdapter {
        private List<HeaderBean> data;

        public void setData(List<HeaderBean> data) {
            this.data = data;
            notifyDataSetChanged();
        }

        @Override
        public int getCount() {
            return data == null ? 0 : data.size();
        }

        @Override
        public Object getItem(int position) {
            return data.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View v, ViewGroup parent) {
            GridVH gridVH = null;

            if (v == null) {
                v = LayoutInflater.from(mContext).inflate(R.layout.item_header, null);
                gridVH = new GridVH(v);
                v.setTag(gridVH);
            } else {
                gridVH = (GridVH) v.getTag();
            }
            gridVH.tvKey.setText(data.get(position).key);
            gridVH.tvValue.setText(data.get(position).value);

            return v;
        }
    }

    public static class GridVH {
        private TextView tvKey;
        private TextView tvValue;

        public GridVH(View v) {
            tvKey = v.findViewById(R.id.tv_key);
            tvValue = v.findViewById(R.id.tv_value);
        }
    }

}
