package com.avishkar.apicalling;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.avishkar.apicalling.adapter.MovieAdapter;
import com.avishkar.apicalling.interfaces.ApiService;
import com.avishkar.apicalling.models.Movie;
import com.avishkar.apicalling.models.MovieResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    GridLayoutManager gridLayoutManager;

    private RecyclerView moviesRv;
    int currentPage = 1;
    int totalPages =  1;

    boolean isLoading = false;

    MovieAdapter adapter;
    ArrayList<Movie> movieList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        moviesRv = findViewById(R.id.moviesRv);
        gridLayoutManager = new GridLayoutManager(MainActivity.this,2);
        moviesRv.setLayoutManager(gridLayoutManager);
        loadData(currentPage);


        moviesRv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                int visibleItemCount = gridLayoutManager.getChildCount();
                int totalItemsCount = gridLayoutManager.getItemCount();
                int firstVisibleItemPosition = gridLayoutManager.findFirstVisibleItemPosition();

                if (!isLoading && currentPage < totalPages) {
                    if ((visibleItemCount + firstVisibleItemPosition) >= totalItemsCount) {
                        currentPage++;
                        loadData(currentPage);
                    }
                }

            }
        });

    }

    private void loadData(int page) {
        isLoading = true;
        RetrofitInstance.getApiService().getMovies(page)
                .enqueue(new Callback<MovieResponse>() {
                    @Override
                    public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            totalPages = response.body().getTotalPages();
                            movieList = response.body().getMovies();
                            adapter = new MovieAdapter(movieList,MainActivity.this);
                            moviesRv.setAdapter(adapter);
                            adapter.addData(movieList);
                        }
                        isLoading = false;
                    }

                    @Override
                    public void onFailure(Call<MovieResponse> call, Throwable t) {
                        Log.d("API", "Error: "+t.getMessage());
                        isLoading = false;
                    }
                });

    }
}