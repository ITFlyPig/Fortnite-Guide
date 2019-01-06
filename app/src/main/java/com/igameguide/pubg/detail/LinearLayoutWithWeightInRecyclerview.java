package com.igameguide.pubg.detail;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * weight属性在recyclerview中失效，这里保证有效，但是会多测量几次
 */
public class LinearLayoutWithWeightInRecyclerview extends LinearLayout{
    public LinearLayoutWithWeightInRecyclerview(Context context) {
        super(context);
    }

    public LinearLayoutWithWeightInRecyclerview(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public LinearLayoutWithWeightInRecyclerview(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int childCount = getChildCount();
        if (childCount > 0) {
            int perW = MeasureSpec.getSize(widthMeasureSpec) / childCount;
            for (int i = 0; i < childCount; i++) {
                View child = getChildAt(i);
                ViewGroup.LayoutParams params = child.getLayoutParams();
                params.width = perW;
                child.setLayoutParams(params);
            }
        }

    }
}
