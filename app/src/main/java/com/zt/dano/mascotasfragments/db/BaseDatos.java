package com.zt.dano.mascotasfragments.db;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.zt.dano.mascotasfragments.Mascota;

import java.util.ArrayList;

/**
 * Created by dano on 12/06/16.
 */
public class BaseDatos extends SQLiteOpenHelper {

    private Context context;

    public BaseDatos(Context context){//}, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION) {

        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String queryCrearTablaMascota = "CREATE TABLE " + ConstantesBaseDatos.TABLE_MASCOTA + "("+
                ConstantesBaseDatos.TABLE_MASCOTA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE + "TEXT, " +
                ConstantesBaseDatos.TABLE_MASCOTA_FOTO + "INTEGER, " +
                ConstantesBaseDatos.TABLE_MASCOTA_LIKE + "INTEGER " +

                ")";

        String queryCrearTablaLikesMascotas = "CREATE TABLE "+ ConstantesBaseDatos.TABLE_LIKES_MASCOTAS + "("+
                ConstantesBaseDatos.TABLE_MASCOTA_LIKE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                ConstantesBaseDatos.TABLE_MASCOTA_LIKE_ID_MASCOTA + " INTEGER, "+
                ConstantesBaseDatos.TABLE_MASCOTA_LIKE_NUMERO_LIKES + " INTEGER, "+
                "FOREING KEY ("+ConstantesBaseDatos.TABLE_MASCOTA_LIKE_ID_MASCOTA+ ")"+
                "REFERENCES "+ConstantesBaseDatos.TABLE_MASCOTA+"("+ConstantesBaseDatos.TABLE_MASCOTA_ID+")"+
                ")";


        db.execSQL(queryCrearTablaMascota);
        db.execSQL(queryCrearTablaLikesMascotas);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST"+ConstantesBaseDatos.TABLE_MASCOTA);
        db.execSQL("DROP TABLE IF EXIST"+ConstantesBaseDatos.TABLE_MASCOTA_LIKE);
        onCreate(db);


    }

    public ArrayList<Mascota> obtenerTodasLasMascotas(){
        ArrayList<Mascota> mascotas = new ArrayList<>();
        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_MASCOTA;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()){

            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setFoto(registros.getInt(2));
            mascotaActual.setLike(registros.getInt(3));

            mascotas.add(mascotaActual);

        }

        db.close();
        return mascotas;
    }

    public void insertarMascotas(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_MASCOTA, null, contentValues);
        db.close();

    }
}
