package com.avishkar.apicalling.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.avishkar.apicalling.R;
import com.avishkar.apicalling.interfaces.ApiService;
import com.avishkar.apicalling.models.Movie;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    ArrayList<Movie> moviesList;
    Context context;

    public MovieAdapter(ArrayList<Movie> moviesList, Context context) {
        this.moviesList = moviesList;
        this.context = context;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.movie_layout, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        final Movie movie = moviesList.get(position);
        Picasso.get()
                .load(movie.getPoster())
                .placeholder(R.drawable.ic_launcher_background)
                .into(holder.movieImage);

        holder.txtTitle.setText(movie.getTitle());
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    public void addData(ArrayList<Movie> newData) {
        moviesList.addAll(newData);
        notifyItemRangeChanged(moviesList.size(),newData.size());
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {
        ImageView movieImage;
        TextView txtTitle;
        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.tvTitle);
            movieImage = itemView.findViewById(R.id.imgPoster);
        }
    }
}
