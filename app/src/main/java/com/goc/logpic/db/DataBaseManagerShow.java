package com.goc.logpic.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;
import android.util.Log;

import com.goc.logpic.model.Curso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gunar on 9/1/17.
 */

public class DataBaseManagerShow {

    private SQLiteDatabase db;
    private DbHelper helper;

    private static final String NOMBRE_TABLA="item";

    private static final String CN_ID="_id";
    private static final String CN_ID_PARENT="idParent";
    private static final String CN_SRC="src";
    private static final String CN_POSITION="position";
    private static final String CN_NOTE="note";
    private static final String CN_FLAG="flag";
    private static final String CN_FECHA_ITEM="fechaItem";
    private static final String CN_TIPO="tipo";


    public static final String CREATE_TABLE = "create table " + NOMBRE_TABLA + " ("
            + BaseColumns._ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
            + CN_ID + " integer KEY AUTOINCREMENT, "
            + CN_ID_PARENT + " text NOT NULL, "
            + CN_SRC + " text NULL, "
            + CN_POSITION + " text NULL, "
            + CN_NOTE + " text NULL, "
            + CN_FLAG + " text NULL, "
            + CN_FECHA_ITEM + " text NULL, "
            + CN_TIPO + " text NULL"
            + ");";

    public DataBaseManagerShow(Context ctx) {
        helper= new DbHelper(ctx);
        db=helper.getWritableDatabase();
    }

    private ContentValues generarContentValues(String id, String idParent, String src, String position, String note, String flag, String fechaItem, String tipo) {
        ContentValues valores = new ContentValues();
        valores.put(CN_ID, id);
        valores.put(CN_ID_PARENT, idParent);
        valores.put(CN_SRC, src);
        valores.put(CN_POSITION, position);
        valores.put(CN_NOTE, note);
        valores.put(CN_FLAG, flag);
        valores.put(CN_FECHA_ITEM, fechaItem);
        valores.put(CN_TIPO, tipo);

        return valores;
    }

   public void insertar_4parametros(String id, String idParent, String src, String position, String note, String flag, String fechaItem, String tipo) {
        //super.getDb().execSQL("INSERT INTO "+);
        Log.d("cursos_insertar", db.insert(NOMBRE_TABLA, null, generarContentValues(id, idParent, src, position, note, flag, fechaItem, tipo)) + "");
       //generarContentValues(id, nombre, descripcion, precio);
    }

    public void actualizar_4parametros(String id, String idParent, String src, String position, String note, String flag, String fechaItem, String tipo) {
        ContentValues valores = new ContentValues();
        valores.put(CN_ID, id);
        valores.put(CN_ID_PARENT, idParent);
        valores.put(CN_SRC, src);
        valores.put(CN_POSITION, position);
        valores.put(CN_NOTE, note);
        valores.put(CN_FLAG, flag);
        valores.put(CN_FECHA_ITEM, fechaItem);
        valores.put(CN_TIPO, tipo);

        String [] args= new String[]{id};
        //db.update(NOMBRE_TABLA, valores, "_id=?", args);
        Log.d("cursos_actualizar", db.update(NOMBRE_TABLA, valores, "_id=?", args)+"");
    }

    public void eliminar(String id) {
        db.delete(NOMBRE_TABLA, CN_ID + "=?", new String[]{id});
    }

    public void eliminarTodo() {
        db.execSQL("DELETE FROM "+ NOMBRE_TABLA+";");
        //Log.d("cursos_eliminar", "Datos borrados");
    }

    public Cursor cargarCursor() {
        String [] columnas= new String[]{CN_ID, CN_ID_PARENT, CN_SRC, CN_POSITION, CN_NOTE, CN_FLAG, CN_FECHA_ITEM, CN_TIPO};
        return db.query(NOMBRE_TABLA,columnas,null,null,null,null,null );
    }

    Boolean compruebaRegistro(String idParent) {
        boolean esta=true;

        Cursor resultSet= db.rawQuery("Select * from " + NOMBRE_TABLA + " WHERE " + CN_ID_PARENT + "=" + idParent, null);
        if(resultSet.getCount()<=0)
            esta=false;
        else
            esta=true;
        return esta;
    }

    public List<Curso> getCursosList(){
        List<Curso>  list= new ArrayList<>();

        Cursor c= cargarCursor();

        while (c.moveToNext()){
            Curso curso = new Curso();
            curso.setId(c.getString(0));
            curso.setNombre(c.getString(1));
            curso.setFecha(c.getString(2));
            curso.setImgp(c.getString(3));
            curso.setFrecuencia(c.getString(4));
            list.add(curso);
        }
        return list;
    }

    public DbHelper getHelper() {
        return helper;
    }
    public SQLiteDatabase getDb() {
        return db;
    }

    public void setHelper(DbHelper helper) {
        this.helper = helper;
    }

    public void setDb(SQLiteDatabase db) {
        this.db = db;
    }
    public void cerrar(){
        db.close();
    }
}