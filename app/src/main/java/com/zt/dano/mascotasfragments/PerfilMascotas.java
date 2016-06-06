package com.zt.dano.mascotasfragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilMascotas extends Fragment {


    public PerfilMascotas() {
        // Required empty public constructor
    }

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_perfil_mascotas, container, false);



    }

}
