package com.example.sportak.practica13discos.fragmentos;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import com.example.sportak.practica13discos.R;
import com.example.sportak.practica13discos.actividades.CancionActivity;
import com.example.sportak.practica13discos.adaptadores.adaptadorGridView;
import com.example.sportak.practica13discos.interfaces.DiscosListener;
import com.example.sportak.practica13discos.pojos.Cancion;
import com.example.sportak.practica13discos.pojos.Disco;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class fragmentoDisco extends Fragment implements  AdapterView.OnItemClickListener {

    GridView tablaDiscos=null;
    adaptadorGridView adaptador=null;
    ArrayList<Disco>listaDiscos=new ArrayList<>();

    private DiscosListener listener;

    public fragmentoDisco() {
        // Required empty public constructor
    }

    public void setDiscosListener(DiscosListener listener){
        this.listener=listener;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_disco, container, false);
        if(getActivity().getIntent().getSerializableExtra("dembow")!=null){
            this.listaDiscos= (ArrayList<Disco>) getActivity().getIntent().getSerializableExtra("dembow");
            System.out.println(this.listaDiscos.toString());
        }
        this.tablaDiscos=view.findViewById(R.id.gridview1);
        adaptador=new adaptadorGridView(this.getContext(),R.layout.item_grid_view_custom,listaDiscos);
        this.tablaDiscos.setAdapter(adaptador);
        this.tablaDiscos.setOnItemClickListener(this);
        return view;
    }




    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if(this.listener!=null){
            listener.onDiscoSeleccionado((Disco) parent.getItemAtPosition(position));
        }

    /*
        if(getActivity().getSupportFragmentManager().findFragmentById(R.id.fragment2)==null) {

        }else{
            System.out.println("click click");
        }
        */

    }
}
