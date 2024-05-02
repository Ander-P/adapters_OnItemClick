package com.example.recyclerview.adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.R;
import com.example.recyclerview.clases.Film;
import com.squareup.picasso.Picasso;

import java.util.List;

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.ViewHolder> {

    private List<Film> films;

    public FilmAdapter(List<Film> films){
        this.films = films;
    }

    @NonNull
    @Override
    public FilmAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_film, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmAdapter.ViewHolder holder, int position) {
        Film film = films.get(position);
        holder.bind(film);
    }

    @Override
    public int getItemCount() {
        return films.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView txt_name_film, txt_duration_film;
        ImageView img_film;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_name_film = itemView.findViewById(R.id.txt_name_film);
            txt_duration_film = itemView.findViewById(R.id.txt_duration_film);
            img_film = itemView.findViewById(R.id.img_film);
        }

        public void bind (Film dato){
            txt_name_film.setText(dato.getName());
            txt_duration_film.setText(dato.getDuration());
            //Library img
            Picasso.get().load(dato.getImage()).into(img_film);
        }
    }
}
