package com.example.sportak.practica13discos.actividades;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;

import com.example.sportak.practica13discos.R;
import com.example.sportak.practica13discos.pojos.Cancion;
import com.example.sportak.practica13discos.pojos.Disco;

import java.io.Serializable;
import java.util.ArrayList;

public class Menu extends AppCompatActivity implements View.OnClickListener {
    private ArrayList<Disco>listaDiscos=new ArrayList<>();
    private ArrayList<Cancion>listaCanciones1=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Button btn1=findViewById(R.id.button);
        Button btn2=findViewById(R.id.button2);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        this.cargarCanciones();
        this.listaDiscos.add(new Disco("Dethalbum 1",R.drawable.thunderhorse,this.listaCanciones1));
        this.listaDiscos.add(new Disco("Dethalbum 2",R.drawable.dethalbum2,this.listaCanciones1));
        this.listaDiscos.add(new Disco("Dethalbum 3",R.drawable.dethalbum3,this.listaCanciones1));
        this.listaDiscos.add(new Disco("Dethalbum 4",R.drawable.dethalbum4,this.listaCanciones1));


    }



    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.button){
            Intent intento=new Intent(this,MainActivity.class);
            startActivity(intento);
        }else if(v.getId()==R.id.button2){
            Intent intento=new Intent(this,MainActivity.class);
            Bundle bundle= new Bundle();
            bundle.putSerializable("dembow", this.listaDiscos);
            intento.putExtras(bundle);
            startActivity(intento);

        }
    }

    public void cargarCanciones(){
        this.listaCanciones1.add(new Cancion("ThunderHorse","20:00","NathanExplosion",1));
        this.listaCanciones1.add(new Cancion("Awaken","2:00","NathanExplosion",2));


    }
}
