package com.cyq.expendtextview;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cyq.expendtextview.adapter.MyAdapter;
import com.cyq.expendtextview.bean.TestBean;
import com.cyq.expendtextview.view.Utils;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private MyAdapter mAdapter;
    private List<TestBean> mList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.recyclerView);
        int width = getWindowManager().getDefaultDisplay().getWidth() - Utils.dp2px(this, 20);
        //构造假数据
        for (int i = 0; i < 30; i++) {
            TestBean bean = new TestBean();
            bean.setStr(getResources().getString(R.string.text_content));
            bean.isChecked = false;
            mList.add(bean);
        }
        mAdapter = new MyAdapter(this, mList, width);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);
    }
}
