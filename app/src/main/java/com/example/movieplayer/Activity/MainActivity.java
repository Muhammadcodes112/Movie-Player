package com.example.movieplayer.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DownloadManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;

import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.movieplayer.Domain.FilmItem;
import com.example.movieplayer.R;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapterNewMovies,adapterUpcoming;
    private RecyclerView recyclerViewNewMovies, recyclerViewUpComing;
    private RequestQueue mRequestQueue;
    private StringRequest mStringRequest, getmStringRequest2;
    private ProgressBar loading1, loading2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        sendRequest1();
    }

        private void sendRequest1() {
            mRequestQueue = Volley.newRequestQueue(this);
            loading1.setVisibility(View.VISIBLE);
            mStringRequest = new StringRequest(Request.Method.GET, "http://www.omdbapi.com/?i=tt3896198&apikey=f4962a24", response -> {
                Gson gson = new Gson();
                loading1.setVisibility(View.GONE);

                FilmItem items = gson.fromJson(response,FilmItem.class);
                adapterNewMovies = new
            }, error -> {

            });
        }

        private void initView(){
            recyclerViewNewMovies = findViewById(R.id.view1);
            recyclerViewNewMovies.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false));
            recyclerViewUpComing = findViewById(R.id.view2);
            recyclerViewUpComing.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false));
            loading1 = findViewById(R.id.loading1);
            loading2 = findViewById(R.id.loading2);
    }
}