package com.example.sportak.practica13discos.fragmentos;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sportak.practica13discos.R;
import com.example.sportak.practica13discos.pojos.Cancion;
import com.example.sportak.practica13discos.pojos.Disco;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link dialogFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class dialogFragment extends DialogFragment {
    Cancion mParam1=null;

    public dialogFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment dialogFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static dialogFragment newInstance(Cancion c) {
        dialogFragment fragment = new dialogFragment();
        Bundle args = new Bundle();
        args.putSerializable("cancion",c);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = (Cancion) getArguments().getSerializable("cancion");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dialog, container, false);
    }


    @Override
    public Dialog onCreateDialog( Bundle savedInstanceState) {
        AlertDialog.Builder bodybuilder=new AlertDialog.Builder(getActivity());
        View view=getActivity().getLayoutInflater().inflate(R.layout.fragment_dialog,null);
        bodybuilder.setView(view);

        TextView txt=view.findViewById(R.id.dialogotxt1);
        TextView txt2=view.findViewById(R.id.dialogotxt2);
        txt.setText(this.mParam1.getAutor());
        txt2.setText(this.mParam1.getNombreCancion());


        bodybuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        return bodybuilder.create();
    }
}
