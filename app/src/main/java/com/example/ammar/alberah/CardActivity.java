package com.example.ammar.alberah;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.ammar.alberah.adapter.MyRecyclerAdapter;
import com.example.ammar.alberah.helpers.OnRecyclerViewItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class CardActivity extends AppCompatActivity {

    private static final String MOCK_URL = "https://cdn.mos.cms.futurecdn.net/995e457534b67e7afec11568127db10f-970-80.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);

        RecyclerView recyclerView = findViewById(R.id.list);
        recyclerView.setHasFixedSize(true);
        final MyRecyclerAdapter adapter;

        recyclerView.setAdapter(adapter = new MyRecyclerAdapter(createMockList(), R.layout.card));
        LinearLayoutManager linearLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        adapter.setOnItemClickListener(new OnRecyclerViewItemClickListener<CardModel>() {
            @Override
            public void onItemClick(View view, CardModel viewModel) {
                adapter.remove(viewModel);
            }
        });
    }

    private List<CardModel> createMockList() {
        List<CardModel> items = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            items.add(new CardModel(i, "Item " + (i + 1), MOCK_URL));
        }
        return items;
    }
}
