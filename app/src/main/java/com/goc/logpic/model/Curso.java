package com.goc.logpic.model;

/**
 * Created by gunar on 9/1/17.
 */

public class Curso {
    private String id;
    private String nombre;
    private String fecha;
    private String imgp;
    private String frecuencia;


    public Curso() {
    }

    public Curso(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Curso(String id, String nombre, String fecha, String imgp, String frecuencia) {
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
        this.imgp = imgp;
        this.frecuencia = frecuencia;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {  return fecha; }

    public void setFecha(String fecha) { this.fecha = fecha; }

    public String getImgp() { return imgp; }

    public void setImgp(String imgp) { this.imgp = imgp; }

    public String getFrecuencia() { return frecuencia; }

    public void setFrecuencia(String frecuencia) { this.frecuencia = frecuencia; }

}
