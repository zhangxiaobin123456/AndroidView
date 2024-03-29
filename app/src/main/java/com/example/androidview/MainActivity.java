package com.example.androidview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.androidview.view.ScrollDemoActivity;
import com.example.androidview.view.ViewScrollTestActivity;
import com.example.androidview.view.ViewTestActivity;
import com.example.androidview.view.ViewTestThreeActivity;
import com.example.androidview.view.ViewTestTwoActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tv_toOne)
    TextView mTvToOne;
    @BindView(R.id.tv_toTwo)
    TextView mTvToTwo;
    @BindView(R.id.tv_toViewScroll)
    TextView mTVViewScroll;
    @BindView(R.id.tv_toScrollDemo)
    TextView mTvScrollDemo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.tv_toOne, R.id.tv_toTwo,R.id.tv_toThree,R.id.tv_toViewScroll,R.id.tv_toScrollDemo})
    public void onViewClicked(View view) {
        Intent intent;

        switch (view.getId()) {
            case R.id.tv_toOne:
                intent = new Intent(getApplicationContext(), ViewTestActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_toTwo:
                intent = new Intent(getApplicationContext(), ViewTestTwoActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_toThree:
                intent = new Intent(getApplicationContext(), ViewTestThreeActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_toViewScroll:
                intent = new Intent(getApplicationContext(), ViewScrollTestActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_toScrollDemo:
                intent = new Intent(getApplicationContext(), ScrollDemoActivity.class);
                startActivity(intent);
                break;
        }
    }
}
