package com.zt.dano.mascotasfragments;

import java.util.ArrayList;

/**
 * Created by dano on 12/06/16.
 */
public interface IRecyclerViewFragmentView {

    public void generarLinerLayoutVertical();
    public MascotaAdaptador creaAdaptador(ArrayList<Mascota> mascotas);
    public void inicializarAdaptadoRV(MascotaAdaptador adaptador);

}
