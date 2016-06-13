package com.zt.dano.mascotasfragments.presentador;

import android.content.Context;

import com.zt.dano.mascotasfragments.IRecyclerViewFragmentView;
import com.zt.dano.mascotasfragments.Mascota;
import com.zt.dano.mascotasfragments.db.ConstructorMascotas;

import java.util.ArrayList;

/**
 * Created by dano on 12/06/16.
 */
public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter{
    private ConstructorMascotas constructorMascotas;
    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private  Context context;
    private ArrayList<Mascota> mascotas;


    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context){

        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;
        obtenerMascotasBaseDatos();
    }

    @Override
    public void obtenerMascotasBaseDatos() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerDatos();
        mostrarMascotasRV();

    }

    @Override
    public void mostrarMascotasRV() {
        iRecyclerViewFragmentView.inicializarAdaptadoRV(iRecyclerViewFragmentView.creaAdaptador(mascotas));
        iRecyclerViewFragmentView.generarLinerLayoutVertical();
    }
}
