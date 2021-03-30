package com.apkdoandroid.giftcard.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.apkdoandroid.giftcard.R;
import com.apkdoandroid.giftcard.model.Spot;
import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CardStackAdapter extends RecyclerView.Adapter<CardStackAdapter.ViewHolder>{
    private List<Spot>spots;

    public CardStackAdapter(List<Spot> spots) {
        this.spots = spots;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_spot,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Spot spot = spots.get(position);
        holder.nome.setText(spot.getId()+". "+spot.getNome());
        holder.city.setText(spot.getCity());

        // pode usar o Glide
//        Glide.with(holder.imageView)
//                .load(spot.getUrl())
//                .into(holder.imageView);
        //ou piscasso
        Picasso.get().load(spot.getUrl()).into(holder.imageView);
        // ou interno
//        holder.imageView.setImageResource(R.drawable.teste222);



    }

    @Override
    public int getItemCount() {
        return spots.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView nome,city;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.item_image);
            nome = itemView.findViewById(R.id.item_name);
            city = itemView.findViewById(R.id.item_city);
        }
    }
}
