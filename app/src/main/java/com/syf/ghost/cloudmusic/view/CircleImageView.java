package com.syf.ghost.cloudmusic.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.util.AttributeSet;

/**
 * Created by Android on 2019/4/4.
 * auth Shangyifei
 */
public class CircleImageView extends android.support.v7.widget.AppCompatImageView {

    private Path mShadePath = new Path();

    public CircleImageView(Context context) {
        super(context);
    }

    public CircleImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CircleImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.save();
        int width = getWidth();
        int height = getHeight();
        mShadePath.addCircle(width / 2, height / 2, width > height ? height / 2 : width / 2, Path.Direction.CCW);
        canvas.clipPath(mShadePath);
        super.onDraw(canvas);
        canvas.restore();

    }
}
