package com.example.sportak.practica13discos.adaptadores;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sportak.practica13discos.R;
import com.example.sportak.practica13discos.pojos.Disco;

import java.util.ArrayList;
import java.util.List;

public class adaptadorGridView<T> extends ArrayAdapter<T> {

    public adaptadorGridView(Context context, int resource,  ArrayList<T> objects) {
        super(context, resource, objects);
    }


    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        //return super.getView(position, convertView, parent);
        LayoutInflater inflater= (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View gridview=convertView;
        if(convertView==null){
            gridview=inflater.inflate(R.layout.item_grid_view_custom,parent,false);
        }
        ImageView imagen=gridview.findViewById(R.id.custom_img_txt);
        TextView txt=gridview.findViewById(R.id.custom_txt_grid);

        Disco disc= (Disco) getItem(position);

        imagen.setImageResource(disc.getPortadaDisco());
        txt.setText(disc.getNombreDiscos());

    return gridview;
    }
}
