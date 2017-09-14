package com.goc.logpic.adaptadores;

import android.os.Bundle;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import com.goc.logpic.model.Curso;
import com.goc.logpic.R;

/**
 * Created by gunar on 9/1/17.
 */

public class CartaCursoAdapter extends RecyclerView.Adapter<CartaCursoAdapter.CartaViewHolder> {

    private  Context mainContext;
    private  List<Curso> items;

    public CartaCursoAdapter(List<Curso> items, Context contexto) {
        this.mainContext = contexto;
        this.items = items;
    }


    static class CartaViewHolder extends RecyclerView.ViewHolder {
        // Campos respectivos de un item
        protected TextView id;
        protected TextView nombre;
        protected TextView fecha;
        protected TextView precio;


        public CartaViewHolder(View v) {
            super(v);

            this.id = (TextView) v.findViewById(R.id.textview_curso_id);
            this.nombre = (TextView) v.findViewById(R.id.textview_curso_nombre);
            this.fecha = (TextView) v.findViewById(R.id.textview_curso_fecha);

        }
    }


    /**
     * creamos la card o targeta
     * @param viewGroup
     * @param viewType
     * @return
     */
    @Override
    public CartaViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_item_curso, viewGroup, false);

        return new CartaViewHolder(v);
    }

    /**
     * Este metodo actualiza el RecyclerView.ViewHolder
     * @param viewHolder
     * @param position
     */
    @Override
    public void onBindViewHolder(CartaViewHolder viewHolder, int position) {
        Curso item = items.get(position);
        viewHolder.itemView.setTag(item);

        viewHolder.id.setText("Nº: "+item.getId());
        viewHolder.nombre.setText("Nombre: " +  item.getNombre());
        viewHolder.fecha.setText("Fecha: " +  item.getFecha());
        //viewHolder.precio.setText("Precio: " + item.getPrecio());


    }

    @Override
    public int getItemCount() {
        return items.size();
    }


}
