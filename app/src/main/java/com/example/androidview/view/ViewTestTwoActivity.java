package com.example.androidview.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Scroller;

import com.example.androidview.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ViewTestTwoActivity extends AppCompatActivity implements GestureDetector.OnGestureListener ,GestureDetector.OnDoubleTapListener{

    @BindView(R.id.rl)
    RelativeLayout mRl;
    
    private static final String TAG = "ViewTestTwoActivity";
    private GestureDetector mGestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_test_two);
        ButterKnife.bind(this);
        initView();

    }

    private void initView() {

        mGestureDetector = new GestureDetector(this);

    }


    @Override
    public boolean onDown(MotionEvent e) {
        //手指按下屏幕的瞬间触发 MotionEvent.ACTION_DOWN
        Log.e(TAG, "onDown: ");
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        //手指按下屏幕，没有拖动和松开的状态下  MotionEvent.ACTION_DOWN
        Log.e(TAG, "onShowPress: ");
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        //手指按下屏幕后松开，即触发MotionEvent.ACTION_UP
        Log.e(TAG, "onSingleTapUp: ");
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        //手指按下屏幕并拖动，触发一个MotionEvent.ACTION_DOWN 和多个MotionEvent.ACTION_MOVE
        Log.e(TAG, "onScroll: ");
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        //手指长按屏幕，并没有松开的状态
        Log.e(TAG, "onLongPress: ");
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        //手指按下屏幕，快速滑动后松开，触发一个MotionEvent.ACTION_DOWN 和多个MotionEvent.ACTION_MOVE，
        //一个MotionEvent.ACTION_UP，即快速滑动行为
        Log.e(TAG, "onFling: ");
        return false;
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        //严格的单机行为
        Log.e(TAG, "onSingleTapConfirmed: ");
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        //双击，由两次连续的单机组成
        Log.e(TAG, "onDoubleTap: ");
        return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        //表示发生了双击行为
        Log.e(TAG, "onDoubleTapEvent: ");
        return false;
    }

}
