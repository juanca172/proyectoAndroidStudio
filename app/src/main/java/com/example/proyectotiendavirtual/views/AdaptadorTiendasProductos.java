package com.example.proyectotiendavirtual.views;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectotiendavirtual.R;

import java.util.ArrayList;
import java.util.List;

public class AdaptadorTiendasProductos extends RecyclerView.Adapter<AdaptadorTiendasProductos.RecyclerHolder> {
    private List<CardViewAtributos> items;

    public AdaptadorTiendasProductos(List<CardViewAtributos> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_productos_o_tiendas, parent,false);
        return new RecyclerHolder(view);
    }

    @Override
    public void onBindViewHolder(AdaptadorTiendasProductos.RecyclerHolder holder, int position) {
        CardViewAtributos atributosDelCardView = items.get(position);
        holder.imgItem.setImageResource(atributosDelCardView.getImagenDeTienda());
        holder.tvTitulo.setText(atributosDelCardView.getNombre());
        holder.tvDescripcion.setText(atributosDelCardView.getDescripcion());
    }

    @Override
    public int getItemCount() {
        //colocamos la cantidad de elementos de la lista
        return items.size();
    }

    public static class RecyclerHolder extends RecyclerView.ViewHolder {
        private ImageView imgItem;
        private TextView tvTitulo;
        private TextView tvDescripcion;
        public RecyclerHolder(@NonNull View itemView) {
            super(itemView);
            imgItem = itemView.findViewById(R.id.imageViewTiendas);
            tvTitulo = itemView.findViewById(R.id.tvNombreDelProducto);
            tvDescripcion = itemView.findViewById(R.id.tvDescripcionProducto);
        }
    }
}
