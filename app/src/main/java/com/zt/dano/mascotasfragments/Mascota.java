package com.zt.dano.mascotasfragments;

/**
 * Created by dano on 05/06/16.
 */
public class Mascota {

    private  int id;
    private String nombre;
    private  int foto;
    private int like;

    public Mascota(String nombre, int foto, int like) {
        this.nombre = nombre;
        this.foto = foto;
        this.like = like;
    }

    public Mascota() {

    }


    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }






    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
