package com.example.androidview.view;

import android.os.Bundle;
import android.support.v4.widget.ViewDragHelper;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Scroller;

import com.example.androidview.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ViewTestThreeActivity extends AppCompatActivity {

    @BindView(R.id.rl)
    RelativeLayout mRl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_test_three);
        ButterKnife.bind(this);
        initView();
    }
    int mLastx;
    int mLasty;
    int startLeft;
    int startRight;
    int startTop;
    int startBottom;
    private void initView() {

        mRl.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                int rawx = (int) event.getRawX();
                int rawy = (int) event.getRawY();
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN://按下,获取View初始的位置
                        startLeft = v.getLeft();
                        startRight = v.getRight();
                        startTop = v.getTop();
                        startBottom = v.getBottom();
                        break;
                    case MotionEvent.ACTION_MOVE://移动,View跟随手指的移动
                        int offsetX = rawx - mLastx;
                        int offsetY = rawy - mLasty;
                        v.layout(v.getLeft()+offsetX,v.getTop()+offsetY,
                                v.getRight()+offsetX,v.getBottom()+offsetY);



                        break;
                    case MotionEvent.ACTION_UP://当手指抬起时,回到View初始的位置
                        v.layout(startLeft, startTop, startRight, startBottom);
                        break;
                }
                mLastx = rawx;
                mLasty = rawy;

                return true;
            }
        });


        Scroller scroller = new Scroller(getApplicationContext());
        // startx 和 starty表示滑动的起点   dx 和 dy 表示要滑动的距离，duration表示滑动的时间
        scroller.startScroll(100,100,100,100,1000);

        View decorView = ViewTestThreeActivity.this.getWindow().getDecorView();

    }
}
