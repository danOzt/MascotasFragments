package com.zt.dano.mascotasfragments.db;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.zt.dano.mascotasfragments.Mascota;
import com.zt.dano.mascotasfragments.R;

import java.util.ArrayList;

/**
 * Created by dano on 12/06/16.
 */
public class ConstructorMascotas {

    private Context context;
    public ConstructorMascotas(Context context) {
        this.context = context;

    }


    public ArrayList<Mascota> obtenerDatos(){
/*
        ArrayList<Mascota> mascotas = new ArrayList<>();
        mascotas.add(new Mascota("buffy", R.drawable.dog1,0));
        mascotas.add(new Mascota("bolo", R.drawable.dog2,0));
        mascotas.add(new Mascota("sanson", R.drawable.dog3,0));
        mascotas.add(new Mascota("manchas", R.drawable.dog5,0));
        mascotas.add(new Mascota("greñas", R.drawable.dog6,0));
        mascotas.add(new Mascota("bigotes", R.drawable.dog7,0));*/

        BaseDatos db = new BaseDatos(context);
        insertarTresMascotas(db);

        return db.obtenerTodasLasMascotas();
    }

    public void insertarTresMascotas(BaseDatos db){

        ContentValues values = new ContentValues();
        values.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "buffy");
        values.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.dog1);
        values.put(ConstantesBaseDatos.TABLE_MASCOTA_LIKE, 0);

        db.insertarMascotas(values);

        ContentValues values2 = new ContentValues();
        values.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "bolo");
        values.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.dog2);
        values.put(ConstantesBaseDatos.TABLE_MASCOTA_LIKE, 0);

        db.insertarMascotas(values2);

        ContentValues values3 = new ContentValues();
        values.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "sanson");
        values.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.dog3);
        values.put(ConstantesBaseDatos.TABLE_MASCOTA_LIKE, 0);

        db.insertarMascotas(values3);

    }

}
