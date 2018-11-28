package com.example.sportak.practica13discos.actividades;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import com.example.sportak.practica13discos.R;
import com.example.sportak.practica13discos.fragmentos.fragmentoCanciones;
import com.example.sportak.practica13discos.fragmentos.fragmentoDisco;
import com.example.sportak.practica13discos.interfaces.DiscosListener;
import com.example.sportak.practica13discos.pojos.Disco;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements DiscosListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //esto lo usaremos para el listener con la interface
        fragmentoDisco frg= (fragmentoDisco) getSupportFragmentManager().findFragmentById(R.id.fragment);
        frg.setDiscosListener(this);

        /*if(getIntent().getSerializableExtra("dembow")!=null){
          //  ArrayList<Disco> listadiscos= (ArrayList<Disco>) getIntent().getSerializableExtra("dembow");
        }else{
            System.out.println("No me pasan na");

        }*/
    }

    @Override
    public void onDiscoSeleccionado(Disco d) {
        boolean hayDetalle=(getSupportFragmentManager().findFragmentById(R.id.fragment2)!=null);

        if(hayDetalle){
            ((fragmentoCanciones)getSupportFragmentManager().findFragmentById(R.id.fragment2)).mostrarDatos(d);
        }else{

            Intent intento = new Intent(this, CancionActivity.class);
            Bundle bun = new Bundle();
            bun.putSerializable("disco", d);
            intento.putExtras(bun);
            startActivity(intento);
        }

    }
}
