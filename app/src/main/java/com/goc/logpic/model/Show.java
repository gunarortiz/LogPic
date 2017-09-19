package com.goc.logpic.model;

/**
 * Created by gunar on 9/17/17.
 */

public class Show {

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getIdParent() {
        return idParent;
    }

    public void setIdParent(String idParent) {
        this.idParent = idParent;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getFechaItem(){
        return fechaItem;
    }

    public void setFechaItem(String FechaItem){
        this.fechaItem=FechaItem;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    private String id;
    private String idParent;
    private String src;

    public Show(String id, String idParent, String src, String position, String note, String flag, String fechaItem, String tipo) {
        this.id = id;
        this.idParent = idParent;
        this.src = src;
        this.position = position;
        this.note = note;
        this.flag = flag;
        this.fechaItem = fechaItem;
        this.tipo = tipo;
    }

    private String position;
    private String note;
    private String flag;
    private String fechaItem;
    private String tipo;




}
