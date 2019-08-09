package com.example.androidview.view;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androidview.HorizontalScrollViewEx;
import com.example.androidview.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ScrollDemoActivity extends AppCompatActivity {

    @BindView(R.id.container)
    HorizontalScrollViewEx mContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_demo);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        LayoutInflater inflater = getLayoutInflater();
        int widthPixels = this.getResources().getDisplayMetrics().widthPixels;
        int heightPixels = this.getResources().getDisplayMetrics().heightPixels;
        for (int i = 0; i < 3; i++) {
            ViewGroup layout = (ViewGroup) inflater.inflate(
                    R.layout.content_layout, mContainer, false);
            layout.getLayoutParams().width = widthPixels;
            TextView textView = (TextView) layout.findViewById(R.id.title);
            textView.setText("page " + (i + 1));
            layout.setBackgroundColor(Color.rgb(255 / (i + 1), 255 / (i + 1), 0));
            createList(layout);
            mContainer.addView(layout);
        }
    }

    private void createList(ViewGroup layout) {
        ListView listView = (ListView) layout.findViewById(R.id.list);
        ArrayList<String> datas = new ArrayList<String>();
        for (int i = 0; i < 50; i++) {
            datas.add("name " + i);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.content_list_item, R.id.name, datas);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(ScrollDemoActivity.this, "click item",
                        Toast.LENGTH_SHORT).show();

            }
        });
    }


}
