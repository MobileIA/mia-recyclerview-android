package com.mobileia.recyclerview.example;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.mobileia.recyclerview.MobileiaRecyclerView;
import com.mobileia.recyclerview.adapter.BuilderAdapter;
import com.mobileia.recyclerview.example.entity.ItemTest;
import com.mobileia.recyclerview.example.view.holder.ItemHolder;
import com.mobileia.recyclerview.scroll.EndScrollListener;
import com.mobileia.recyclerview.scroll.StartScrollListener;

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
        adapter.add(new ItemTest("Title 2", "Esto es una prueba loca."));
        adapter.add(new ItemTest("Title 2", "Esto es una prueba loca."));
        adapter.add(new ItemTest("Title 2", "Esto es una prueba loca."));
        adapter.add(new ItemTest("Title 2", "Esto es una prueba loca."));
        adapter.add(new ItemTest("Title 2", "Esto es una prueba loca."));
        adapter.add(new ItemTest("Title 2", "Esto es una prueba loca."));
        adapter.add(new ItemTest("Title 2", "Esto es una prueba loca."));
        adapter.add(new ItemTest("Title 2", "Esto es una prueba loca."));
        adapter.add(new ItemTest("Title 2", "Esto es una prueba loca."));
        adapter.add(new ItemTest("Title 2", "Esto es una prueba loca."));
        adapter.add(new ItemTest("Title 2", "Esto es una prueba loca."));
        adapter.add(new ItemTest("Title 2", "Esto es una prueba loca."));
        adapter.add(new ItemTest("Title 2", "Esto es una prueba loca."));
        adapter.add(new ItemTest("Title 2", "Esto es una prueba loca."));
        adapter.add(new ItemTest("Title 2", "Esto es una prueba loca."));
        adapter.add(new ItemTest("Title 2", "Esto es una prueba loca."));
        adapter.add(new ItemTest("Title 2", "Esto es una prueba loca."));
        adapter.add(new ItemTest("Title 2", "Esto es una prueba loca."));
        adapter.add(new ItemTest("Title 2", "Esto es una prueba loca."));
        recyclerView.scrollToPosition(10);
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
        // Agregar scroll inifinito
        recyclerView.setOnStartScrollListener(new StartScrollListener() {
            @Override
            public void onScrolledToStart() {

                adapter.add(0, new ItemTest("Title -1", "Subitulo 123"));
                adapter.add(0, new ItemTest("Title -1", "Subitulo 123"));
                adapter.add(0, new ItemTest("Title -1", "Subitulo 123"));
                adapter.add(0, new ItemTest("Title -1", "Subitulo 123"));
                adapter.add(0, new ItemTest("Title -1", "Subitulo 123"));
                adapter.add(0, new ItemTest("Title -1", "Subitulo 123"));
                adapter.add(0, new ItemTest("Title -1", "Subitulo 123"));
                adapter.add(0, new ItemTest("Title -1", "Subitulo 123"));
                adapter.add(0, new ItemTest("Title -1", "Subitulo 123"));
                adapter.add(0, new ItemTest("Title -1", "Subitulo 123"));
                adapter.add(0, new ItemTest("Title -1", "Subitulo 123"));
                adapter.add(0, new ItemTest("Title -1", "Subitulo 123"));
                adapter.add(0, new ItemTest("Title -1", "Subitulo 123"));
                adapter.add(0, new ItemTest("Title -1", "Subitulo 123"));
                adapter.add(0, new ItemTest("Title -1", "Subitulo 123"));
                adapter.add(0, new ItemTest("Title -1", "Subitulo 123"));
                adapter.add(0, new ItemTest("Title -1", "Subitulo 123"));
                adapter.add(0, new ItemTest("Title -1", "Subitulo 123"));
                adapter.add(0, new ItemTest("Title -1", "Subitulo 123"));
                adapter.add(0, new ItemTest("Title -1", "Subitulo 123"));
                adapter.add(0, new ItemTest("Title -1", "Subitulo 123"));

                if(adapter.getItemCount() > 100){
                    recyclerView.stopStartScroll();
                }
            }
        });
        recyclerView.setOnEndScrollListener(new EndScrollListener() {
            @Override
            public void onScrolledToEnd() {

                adapter.add(new ItemTest("Title 3", "Subitulo 1"));
                adapter.add(new ItemTest("Title 4", "Esto es una prueba loca."));

                if(adapter.getItemCount() > 100){
                    recyclerView.stopEndScroll();
                }
            }
        });
        // Agregar vista vacia
        recyclerView.setEmptyView(R.layout.item_empty);
        //recyclerView.showEmptyView();
        // Agregar vista de loading
        recyclerView.setLoadingView(R.layout.item_loading);
        //recyclerView.startLoading();
    }
}
