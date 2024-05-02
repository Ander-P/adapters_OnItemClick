package com.example.recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.adaptadores.FilmAdapter;
import com.example.recyclerview.clases.Film;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rcv_films;
    List<Film> listFilms = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rcv_films = findViewById(R.id.rcv_films);

        Film film1 = new Film("Efecto mariposa", "113 min", "https://pics.filmaffinity.com/the_butterfly_effect-524611973-large.jpg");
        Film film2 = new Film("Oppenheimer", "180 Min", "https://pics.filmaffinity.com/oppenheimer-828933592-large.jpg");
        Film film3 = new Film("Dune: Parte Dos", "166 min", "https://pics.filmaffinity.com/dune_part_two-802143593-large.jpg");
        Film film4 = new Film("El padrino. Parte III", "163 min", "https://pics.filmaffinity.com/the_godfather_part_iii-171971720-large.jpg");

        Film[] films = {film1, film2, film3, film4};


        for (int i = 0; i < films.length; i++) {
            listFilms.add(films[i]);
        }

        rcv_films.setLayoutManager(new LinearLayoutManager(this));
        rcv_films.setAdapter(new FilmAdapter(listFilms));

        rcv_films.addOnItemTouchListener(new RecyclerViewClickListener(this, new RecyclerViewClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                Film selectedFilm = listFilms.get(position);
                intent.putExtra("name", selectedFilm.getName());
                startActivity(intent);
            }
        }));
    }
}