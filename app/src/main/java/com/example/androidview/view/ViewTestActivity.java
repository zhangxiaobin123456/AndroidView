package com.example.androidview.view;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.androidview.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ViewTestActivity extends AppCompatActivity {

    @BindView(R.id.tv)
    TextView mTv;
    private static final String TAG = "ViewTestActivity";
    @BindView(R.id.rl)
    RelativeLayout mRl;
    @BindView(R.id.tv_yellow)
    TextView mTvYellow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_test);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);


                    mTv.getLeft();
                    mTv.getRight();
                    mTv.getTop();
                    mTv.getBottom();

                    Log.e(TAG, "initView:  Left " + mTv.getLeft() + " px");
                    Log.e(TAG, "initView:  Right " + mTv.getRight() + " px");
                    Log.e(TAG, "initView:  Top " + mTv.getTop() + " px");
                    Log.e(TAG, "initView:  Bottom " + mTv.getBottom() + " px");

                    Log.e(TAG, "initView:  转换为dp  Left " + px2dp(mTv.getLeft()) + " dp");
                    Log.e(TAG, "initView:  转换为dp  Right " + px2dp(mTv.getRight()) + " dp");
                    Log.e(TAG, "initView:  转换为dp  Top " + px2dp(mTv.getTop()) + " dp");
                    Log.e(TAG, "initView:  转换为dp  Bottom " + px2dp(mTv.getBottom()) + " dp");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        int scaledTouchSlop = ViewConfiguration.get(getApplicationContext()).getScaledTouchSlop();
        Log.e(TAG, " scaledTouchSlop"+scaledTouchSlop);

        mTvYellow.setOnTouchListener(mOnTouchListener);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        VelocityTracker velocityTracker = VelocityTracker.obtain();
        velocityTracker.addMovement(event);
        velocityTracker.computeCurrentVelocity(1000);
        int xVelocity = (int) velocityTracker.getXVelocity();
        int yVelocity = (int) velocityTracker.getYVelocity();
        Log.e(TAG, "onTouchEvent: xVelocity "+xVelocity+"   yVelocity"+yVelocity);

        velocityTracker.clear();
        velocityTracker.recycle();
        return super.onTouchEvent(event);

    }

    private int lastX;
    private int lastY;
    private int startLeft;
    private int startRight;
    private int startTop;
    private int startBottom;

    View.OnTouchListener mOnTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            int action = event.getAction();
            //获取手机触摸的坐标
            int x = (int) event.getX();
            int y = (int) event.getY();
            int rawx = (int) event.getRawX();
            int rawy = (int) event.getRawY();
//            Log.e(TAG, "onTouch: _x: "+x +"   ___  y: "+y);
//            Log.e(TAG, "onTouch: rawx: "+rawx +"   ___  rawy: "+rawy);
//            Log.e(TAG, "onTouch:  转换为dp  _x " + px2dp(x) + " dp"+"   ___  y: "+px2dp(y)+ " dp");
//            Log.e(TAG, "onTouch:  转换为dp  rawx " + px2dp(rawx) + " dp"+"   ___  rawy: "+px2dp(rawy)+ " dp");




            switch (action){
                case MotionEvent.ACTION_DOWN://按下,获取View初始的位置
                    startLeft = v.getLeft();
                    startRight = v.getRight();
                    startTop = v.getTop();
                    startBottom = v.getBottom();
                    lastX = x;
                    lastY = y;
                    break;
                case MotionEvent.ACTION_MOVE://移动,View跟随手指的移动
                    int offsetX = x - lastX;
                    int offsetY = y - lastY;
                    v.layout(v.getLeft()+offsetX,v.getTop()+offsetY,
                            v.getRight()+offsetX,v.getBottom()+offsetY);


                    break;
                case MotionEvent.ACTION_UP://当手指抬起时,回到View初始的位置
                    v.layout(startLeft, startTop, startRight, startBottom);
                    break;
            }
            return true;
        }

    };

    // dp--px
    public int dp2px(int dp) {
        // 1、获取屏幕密度
        float density = getApplicationContext().getResources().getDisplayMetrics().density;
        // 2、进行乘法操作
        return (int) (dp * density + 0.5);
    }

    // px--dp
    public int px2dp(int px) {
        // 1、获取屏幕密度
        float density = getApplicationContext().getResources().getDisplayMetrics().density;
        // 2、进行除法操作
        return (int) (px / density + 0.5);
    }
}
