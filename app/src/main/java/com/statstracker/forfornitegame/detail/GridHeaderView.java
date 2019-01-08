package com.statstracker.forfornitegame.detail;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.statstracker.forfornitegame.R;
import com.statstracker.forfornitegame.detail.bean.HeaderBean;
import com.statstracker.forfornitegame.util.DisplayUtil;

import java.util.List;

/**
 * 不使用Listview和recycleview等是因为得嵌套到他们当中，幺蛾子太多
 */
public class GridHeaderView extends LinearLayout {
    private boolean isUseWeight = true;

    private int mCol = 3;//每行多少个
    private List<HeaderBean> mData;
    private int mMarginTop;
    private int mPaddingTop;
    private int mPaddingBottom;

    public GridHeaderView(Context context) {
        this(context, null);
    }

    public GridHeaderView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public GridHeaderView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setOrientation(VERTICAL);
        mPaddingTop = DisplayUtil.dip2px(getContext(),  10);
        mPaddingBottom = DisplayUtil.dip2px(getContext(),  10);

    }

    public void setData(List<HeaderBean> data) {
        mData = data;
        updateUI();

    }

    private void updateUI() {
        if (mData == null || mData.size() == 0) {
            return;
        }
        removeAllViews();
        int count = 0;
        int index = 0;
        LinearLayout curLl = null;
        for (HeaderBean bean : mData) {

            if (index > mData.size()) {
                return;
            }

            if ( count % mCol == 0) {
                curLl = new LinearLayoutWithWeightInRecyclerview(getContext());
                curLl.setOrientation(HORIZONTAL);
                addView(curLl, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//                curLl.setPadding(curLl.getPaddingLeft(), mPaddingTop, curLl.getPaddingRight(), mPaddingBottom);
                if (count == mCol) {
                    count = 0;
                }
            }
            View v =  LayoutInflater.from(getContext()).inflate(R.layout.item_header, null);
            curLl.addView(v);
            TextView tvKey = v.findViewById(R.id.tv_key);
            TextView tvValue = v.findViewById(R.id.tv_value);


            int resId = getResources().getIdentifier(bean.key, "string", getContext().getPackageName());
            String key = "";
            if (resId == 0) {
                key = bean.key;
            } else {
                key = getResources().getString(resId);
            }
            tvKey.setText(key);
            tvValue.setText(bean.value);

            count++;
            index++;


        }
    }

//    @Override
//    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//        int childCount = getChildCount();
//        int h = 0;
//        for (int i = 0; i < childCount; i++) {
//            h+= getChildAt(i).getMeasuredHeight();
//        }
//
//        setMeasuredDimension(widthMeasureSpec, MeasureSpec.makeMeasureSpec(h, MeasureSpec.EXACTLY));
//
//    }
}
