package com.example.sportak.practica13discos.adaptadores;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.sportak.practica13discos.R;
import com.example.sportak.practica13discos.pojos.Cancion;

import java.util.ArrayList;
import java.util.List;

public class adaptadorCanciones<T> extends ArrayAdapter<T> {


    public adaptadorCanciones(Context context, int resource, ArrayList<T> objects) {
        super(context, resource, objects);
    }


    public View getView(int position, View convertView,  ViewGroup parent) {
        LayoutInflater inflater= (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View listView=convertView;
        if(convertView==null){
            listView=inflater.inflate(R.layout.item_list_view_cancion,parent,false);
        }
        TextView nombreCancion=listView.findViewById(R.id.cancion_cancion);
        TextView autorCancion=listView.findViewById(R.id.autor_cancion);
        TextView lodemasCancio=listView.findViewById(R.id.lodemas_cancion);

        Cancion c= (Cancion) getItem(position);

        nombreCancion.setText(c.getNombreCancion());
        autorCancion.setText(c.getAutor());
        lodemasCancio.setText("Num "+c.getNumeroCancion() +" Duracion: "+ c.getDuracion());


        return listView;
    }
}
