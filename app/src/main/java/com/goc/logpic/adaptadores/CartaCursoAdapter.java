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

public class CartaCursoAdapter extends RecyclerView.Adapter<CartaCursoAdapter.CartaViewHolder> implements View.OnClickListener{

    private  Context mainContext;
    private  List<Curso> items;
    private View.OnClickListener listener;
    private ClickListener clicklistener = null;

    public CartaCursoAdapter(List<Curso> items, Context contexto) {
        this.mainContext = contexto;
        this.items = items;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView mTextView;

        public ItemViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);

            mTextView = (TextView) itemView.findViewById(R.id.list_item);
        }

        @Override
        public void onClick(View v) {
            if (clicklistener != null) {
                clicklistener.itemClicked(v, getAdapterPosition());
            }
        }
    }


    static class CartaViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener{
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


        @Override
        public void onClick(View view) {

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

        v.setOnClickListener(this);
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
    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        if(listener != null)
            listener.onClick(view);
    }


    @Override
    public int getItemCount() {
        return items.size();
    }


}
