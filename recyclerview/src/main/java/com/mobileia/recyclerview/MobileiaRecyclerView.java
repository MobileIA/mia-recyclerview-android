package com.mobileia.recyclerview;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * Created by matiascamiletti on 15/10/17.
 */

public class MobileiaRecyclerView extends RelativeLayout {
    /**
     * Almacena instancia del SwipeRefresh para actualizar el listado
     */
    protected SwipeRefreshLayout mSwipeRefresh;
    /**
     * Almacena instancia del listado
     */
    protected RecyclerView mRecyclerView;
    /**
     * Almacena contenedor de la vista de cuando no hay elementos
     */
    protected RelativeLayout mContainerEmpty;

    public MobileiaRecyclerView(Context context) {
        super(context);
        init();
    }

    public MobileiaRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MobileiaRecyclerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public MobileiaRecyclerView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    /**
     * Setea el listener para el refresh
     * @param listener
     */
    public void setOnRefreshListener(SwipeRefreshLayout.OnRefreshListener listener){
        // Habilitar el refresh
        mSwipeRefresh.setEnabled(true);
        // Setear el listener
        mSwipeRefresh.setOnRefreshListener(listener);
    }

    /**
     * Para el refresh si ya se completo
     */
    public void stopRefreshing(){
        // Parar el refreshing
        mSwipeRefresh.setRefreshing(false);
    }

    /**
     * Setea el Layout Manager en el RecyclerView
     * @param layoutManager
     */
    public void setLayoutManager(RecyclerView.LayoutManager layoutManager){
        mRecyclerView.setLayoutManager(layoutManager);
    }

    /**
     * Setea el adapter al RecyclerView
     * @param adapter
     */
    public void setAdapter(RecyclerView.Adapter adapter){
        mRecyclerView.setAdapter(adapter);
    }

    /**
     * Configura la vista de cuando no hay elementos
     * @param layout
     */
    public void setEmptyView(int layout){
        // Inflar vista en el contenedor
        View view = LayoutInflater.from(getContext()).inflate(layout, mContainerEmpty, false);
        // Agregamos la vista
        setEmptyView(view);
    }

    /**
     * Configura la vista de cuando no hay elementos
     * @param view
     */
    public void setEmptyView(View view){
        // Agregar vista
        mContainerEmpty.addView(view);
    }

    /**
     * Muestra la vista de cuando no hay elementos
     */
    public void showEmptyView(){
        // Ocultar listado
        mSwipeRefresh.setVisibility(GONE);
        // Mostrar vista
        mContainerEmpty.setVisibility(VISIBLE);
    }

    /**
     * Metodo constructor de la vista
     */
    protected void init(){
        // Generar vista base del elemento
        generateViewBase();
        // Configurar los elementos
        setUpViews();
    }

    /**
     * Funcion que se encarga de configurar los elementos principales
     */
    protected void setUpViews(){
        // Obtenemos elemento de refresh
        mSwipeRefresh = findViewById(R.id.swipeRefresh);
        // Deshabilitar el refresh
        mSwipeRefresh.setEnabled(false);
        // Obtenemos el listado
        mRecyclerView = findViewById(R.id.recyclerView);
        // Obtener contendor de vista vacia
        mContainerEmpty = findViewById(R.id.container_empty);
    }
    /**
     * Se encarga de inflar el layout base y agregarlo a la vista
     */
    protected void generateViewBase(){
        // Inflamos la vista base
        View base = LayoutInflater.from(getContext()).inflate(R.layout.mobileia_recyclerview_base, this, false);
        // Agregamos esta base al layout padre
        addView(base);
    }
}
