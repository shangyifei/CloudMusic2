package com.syf.ghost.cloudmusic.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.syf.ghost.cloudmusic.R;

/**
 * Created by Android on 2019/4/4.
 * auth Shangyifei
 */
public class PlayerControlView extends FrameLayout {
    public PlayerControlView(Context context) {
        this(context,null);
    }

    public PlayerControlView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public PlayerControlView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inflate(context, R.layout.layout_player_control,this);
    }
}
