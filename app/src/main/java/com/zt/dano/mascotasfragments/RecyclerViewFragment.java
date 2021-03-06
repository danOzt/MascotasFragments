package com.zt.dano.mascotasfragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zt.dano.mascotasfragments.presentador.IRecyclerViewFragmentPresenter;
import com.zt.dano.mascotasfragments.presentador.RecyclerViewFragmentPresenter;

import java.util.ArrayList;

/**
 * Created by dano on 05/06/16.
 */
public class RecyclerViewFragment extends Fragment implements IRecyclerViewFragmentView {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    private IRecyclerViewFragmentPresenter presenter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
      View v = inflater.inflate(R.layout.fragment_recyvlerview, container, false);
        listaMascotas =  (RecyclerView) v.findViewById(R.id.rcmascotas);
        presenter = new RecyclerViewFragmentPresenter(this, getContext());
       return v;
    }

    public void inicializarMascotas(){
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("buffy", R.drawable.dog1,0));
        mascotas.add(new Mascota("bolo", R.drawable.dog2,0));
        mascotas.add(new Mascota("sanson", R.drawable.dog3,0));
        mascotas.add(new Mascota("manchas", R.drawable.dog5,0));
        mascotas.add(new Mascota("greñas", R.drawable.dog6,0));
        mascotas.add(new Mascota("bigotes", R.drawable.dog7,0));

    }



    @Override
    public void generarLinerLayoutVertical() {

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);


    }

    @Override
    public MascotaAdaptador creaAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, getActivity());
        return null;
    }

    @Override
    public void inicializarAdaptadoRV(MascotaAdaptador adaptador) {
        listaMascotas.setAdapter(adaptador);

    }
}
