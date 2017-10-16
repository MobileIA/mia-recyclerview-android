package com.mobileia.recyclerview.example;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.mobileia.recyclerview.MobileiaRecyclerView;
import com.mobileia.recyclerview.adapter.BuilderAdapter;
import com.mobileia.recyclerview.example.entity.ItemTest;
import com.mobileia.recyclerview.example.view.holder.ItemHolder;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpList();
    }

    protected void setUpList(){
        // Obtememos el listado
        final MobileiaRecyclerView recyclerView = (MobileiaRecyclerView)findViewById(R.id.list);
        // configuramos el Layout
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // Crear el adapter
        final BuilderAdapter adapter = new BuilderAdapter();
        adapter.setViewHolder(R.layout.item_test, ItemHolder.class);
        // Setear adapter
        recyclerView.setAdapter(adapter);
        // Agregar items
        adapter.add(new ItemTest("Title 1", "Subitulo 1"));
        adapter.add(new ItemTest("Title 2", "Esto es una prueba loca."));
        // Agregar refreshing
        recyclerView.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                adapter.add(new ItemTest("Title 3", "Subitulo 1"));
                adapter.add(new ItemTest("Title 4", "Esto es una prueba loca."));
                // Parar refresh
                recyclerView.stopRefreshing();
            }
        });
        // Agregar vista vacia
        recyclerView.setEmptyView(R.layout.item_empty);
        recyclerView.showEmptyView();
        // Agregar vista de loading
        recyclerView.setLoadingView(R.layout.item_loading);
        recyclerView.startLoading();
    }
}
