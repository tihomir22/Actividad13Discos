package com.example.sportak.practica13discos.fragmentos;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.sportak.practica13discos.R;
import com.example.sportak.practica13discos.actividades.MainActivity;
import com.example.sportak.practica13discos.adaptadores.adaptadorCanciones;
import com.example.sportak.practica13discos.pojos.Cancion;
import com.example.sportak.practica13discos.pojos.Disco;

/**
 * A simple {@link Fragment} subclass.
 */
public class fragmentoCanciones extends Fragment implements AdapterView.OnItemClickListener {
    ListView list=null;

    public fragmentoCanciones() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista= inflater.inflate(R.layout.fragment_fragmento_canciones, container, false);
        this.list=vista.findViewById(R.id.listacanciones);
        if (getActivity().getIntent().getExtras().getSerializable("disco") != null) {
            if(getActivity().getClass()!=MainActivity.class) {
                Disco disco = (Disco) getActivity().getIntent().getExtras().getSerializable("disco");
                adaptadorCanciones<Cancion> adaptador = new adaptadorCanciones<>(this.getContext(), R.layout.item_list_view_cancion, disco.getListaCanciones());
                this.list.setAdapter(adaptador);
                this.list.setOnItemClickListener(this);
            }
        }
        return vista;
    }
    public void mostrarDatos(Disco d){
        adaptadorCanciones<Cancion> adaptador = new adaptadorCanciones<>(this.getContext(), R.layout.item_list_view_cancion, d.getListaCanciones());
        this.list.setAdapter(adaptador);
        this.list.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Cancion cancion= (Cancion) parent.getItemAtPosition(position);
        FragmentManager manager=getActivity().getSupportFragmentManager();
        dialogFragment f=dialogFragment.newInstance(cancion);
        f.show(manager,"dembowxxx");

    }
}
