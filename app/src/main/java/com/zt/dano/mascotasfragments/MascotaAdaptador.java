package com.zt.dano.mascotasfragments;

import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by dano on 05/06/16.
 */
public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {

    ArrayList<Mascota> mascotas;
   // ArrayList<Mascota> top5;

    public MascotaAdaptador(ArrayList<Mascota> mascotas, FragmentActivity activity){
        this.mascotas = mascotas;

    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardv_mascota, parent, false);

        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MascotaViewHolder mascotasViewholder, int position) {
        Mascota mascota = mascotas.get(position);
        mascotasViewholder.imgFoto.setImageResource(mascota.getFoto());
        mascotasViewholder.cvnombre.setText(mascota.getNombre());

    }

    @Override
    public int getItemCount() { //cantidad de elementos
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgFoto;
        private TextView cvnombre;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            cvnombre = (TextView) itemView.findViewById(R.id.nomCV);
        }
    }

}
