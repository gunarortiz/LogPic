package com.goc.logpic.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import com.goc.logpic.model.Curso;

/**
 * Created by gunar on 9/1/17.
 */

public class DataBaseManagerCurso{

    private SQLiteDatabase db;
    private DbHelper helper;

    private static final String NOMBRE_TABLA="curso";

    private static final String CN_ID="_id";
    private static final String CN_NOMBRE="nombre";
    private static final String CN_FECHA="descripcion";
    private static final String CN_IMGP="precio";
    private static final String CN_FRECUENCIA="frecuencia";


    public static final String CREATE_TABLE = "create table " + NOMBRE_TABLA + " ("
            + BaseColumns._ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
            + CN_ID + " integer KEY AUTOINCREMENT, "
            + CN_NOMBRE + " text NOT NULL, "
            + CN_FECHA + " text NULL, "
            + CN_IMGP + " text NULL, "
            + CN_FRECUENCIA + " text NULL"
            + ");";

    public DataBaseManagerCurso(Context ctx) {
        helper= new DbHelper(ctx);
        db=helper.getWritableDatabase();
    }

    private ContentValues generarContentValues(String id, String name, String fecha, String imgp, String frecuencia) {
        ContentValues valores = new ContentValues();
        valores.put(CN_ID, id);
        valores.put(CN_NOMBRE, name);
        valores.put(CN_FECHA, fecha);
        valores.put(CN_IMGP, imgp);
        valores.put(CN_FRECUENCIA, frecuencia);
        return valores;
    }

   public void insertar_4parametros(String id, String nombre, String fecha, String imgp, String frecuencia) {
        //super.getDb().execSQL("INSERT INTO "+);
        Log.d("cursos_insertar", db.insert(NOMBRE_TABLA, null, generarContentValues(id, nombre, fecha, imgp, frecuencia)) + "");
       //generarContentValues(id, nombre, descripcion, precio);
    }

    public void actualizar_4parametros(String id, String nombre, String fecha, String imgp, String frecuencia) {
        ContentValues valores = new ContentValues();
        valores.put(CN_ID, id);
        valores.put(CN_NOMBRE, nombre);
        valores.put(CN_FECHA, fecha);
        valores.put(CN_IMGP, imgp);
        valores.put(CN_FRECUENCIA, frecuencia);

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
        String [] columnas= new String[]{CN_ID, CN_NOMBRE, CN_FECHA, CN_IMGP, CN_FRECUENCIA};
        return db.query(NOMBRE_TABLA,columnas,null,null,null,null,null );
    }

    Boolean compruebaRegistro(String id) {
        boolean esta=true;

        Cursor resultSet= db.rawQuery("Select * from " + NOMBRE_TABLA + " WHERE " + CN_ID + "=" + id, null);
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