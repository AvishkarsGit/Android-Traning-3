package com.avishkar.apicalling.interfaces;

import com.avishkar.apicalling.models.MovieResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("movie/allMovies")
    Call<MovieResponse> getMovies(@Query("page") int page);

    public void onClick();
}
