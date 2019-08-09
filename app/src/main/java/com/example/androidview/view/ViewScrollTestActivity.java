package com.example.androidview.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.androidview.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ViewScrollTestActivity extends AppCompatActivity {

    @BindView(R.id.tv_one)
    TextView mTvOne;
    @BindView(R.id.tv_two)
    TextView mTvTwo;
    @BindView(R.id.scroll)
    TextView mScroll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_scroll_test);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {

    }

    @OnClick(R.id.scroll)
    public void onViewClicked() {
        mTvOne.scrollTo(-20, -20);

        mTvTwo.scrollBy(20, -20);
    }
}
