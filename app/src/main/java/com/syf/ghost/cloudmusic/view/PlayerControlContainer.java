package com.syf.ghost.cloudmusic.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/**
 * Created by Android on 2019/4/4.
 * auth Shangyifei
 */
public class PlayerControlContainer extends FrameLayout {
    private FrameLayout wrapFrameLayout;
    private PlayerControlView playerControlView;

    public PlayerControlContainer(Context context) {
        this(context, null);
    }

    public PlayerControlContainer(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PlayerControlContainer(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        playerControlView = new PlayerControlView(context);
        addView(playerControlView, LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        wrapFrameLayout = new FrameLayout(context);
        addView(wrapFrameLayout, LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int childCount = getChildCount();
        int controlViewUseSpace = 0;
        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            if (child instanceof PlayerControlView) {
                measureChildWithMargins(child, widthMeasureSpec, 0, heightMeasureSpec, 0);
                controlViewUseSpace += child.getMeasuredHeight();
            } else {
                measureChildWithMargins(child, widthMeasureSpec, 0, heightMeasureSpec, controlViewUseSpace);
            }
        }
        setMeasuredDimension(MeasureSpec.getSize(widthMeasureSpec), MeasureSpec.getSize(heightMeasureSpec));
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int height = getMeasuredHeight();
        int width = getMeasuredWidth();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            if (child instanceof PlayerControlView) {
                child.layout(0, height - child.getMeasuredHeight(), width, height);
            } else {
                child.layout(0, 0, width, height);
            }
        }
    }

    @Override
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        if (child == playerControlView || child == wrapFrameLayout) {
            super.addView(child, index, params);
        } else {
            wrapFrameLayout.addView(child, index, params);
        }
    }
}