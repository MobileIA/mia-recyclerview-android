package com.mobileia.recyclerview.example;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.mobileia.recyclerview.MobileiaRecyclerView;
import com.mobileia.recyclerview.action.ItemTypeClickListener;
import com.mobileia.recyclerview.adapter.BuilderAdapter;
import com.mobileia.recyclerview.adapter.ItemTypeHolder;
import com.mobileia.recyclerview.adapter.MultiBuilderAdapter;
import com.mobileia.recyclerview.example.entity.ItemTest;
import com.mobileia.recyclerview.example.entity.ItemTestTwo;
import com.mobileia.recyclerview.example.view.holder.ItemHolder;
import com.mobileia.recyclerview.example.view.holder.ItemTwoHolder;
import com.mobileia.recyclerview.scroll.EndScrollListener;
import com.mobileia.recyclerview.scroll.StartScrollListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //setUpList();
        setUpListMulti();
    }

    protected void setUpListMulti() {
        // Obtememos el listado
        final MobileiaRecyclerView recyclerView = (MobileiaRecyclerView)findViewById(R.id.list);
        // configuramos el Layout
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // Crear el adapter
        final MultiBuilderAdapter adapter = new MultiBuilderAdapter();
        adapter.register(new ItemTypeHolder(R.layout.item_multi_one, ItemHolder.class, null));
        adapter.register(new ItemTypeHolder(R.layout.item_multi_two, ItemTwoHolder.class, new ItemTypeClickListener<Object>() {
            @Override
            public void onItemClick(View view, Object item) {
                ItemTestTwo itemC = (ItemTestTwo)item;
                System.out.println("CLick Item 2: " + itemC.title);
            }
        }));
        // Setear adapter
        recyclerView.setAdapter(adapter);
        // Agregar items
        adapter.add(new ItemTest("Title 1", "Subitulo 1"));
        adapter.add(new ItemTestTwo("Title 2", "Esto es una prueba loca."));
        adapter.add(new ItemTest("Title 3", "Esto es una prueba loca."));

        adapter.add(new ItemTest("Title 4", "Esto es una prueba loca."));
        adapter.add(new ItemTestTwo("Title 5", "Esto es una prueba loca."));
        adapter.add(new ItemTest("Title 6", "Esto es una prueba loca."));
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
