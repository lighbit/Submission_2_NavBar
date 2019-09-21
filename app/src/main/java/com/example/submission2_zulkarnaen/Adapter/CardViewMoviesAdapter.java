package com.example.submission2_zulkarnaen.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.submission2_zulkarnaen.MoveWithObjectActivity;
import com.example.submission2_zulkarnaen.MovieModel;
import com.example.submission2_zulkarnaen.R;

import java.util.ArrayList;

public class CardViewMoviesAdapter extends RecyclerView.Adapter<CardViewMoviesAdapter.CardViewViewHolder> {
    private Context context;
    private ArrayList<MovieModel> listMovies;

    public CardViewMoviesAdapter(Context context) {
        this.context = context;
    }

    private ArrayList<MovieModel> getListMovies() {
        return listMovies;
    }

    public void setListMovies(ArrayList<MovieModel> listMovies) {
        this.listMovies = listMovies;
    }


    @NonNull
    @Override
    public CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_movies, viewGroup, false);
        return new CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewMoviesAdapter.CardViewViewHolder cardViewViewHolder, int position) {
        MovieModel tvShow = getListMovies().get(position);
        Glide.with(context)
                .load(tvShow.getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(cardViewViewHolder.dataPhoto);

        cardViewViewHolder.dataName.setText(tvShow.getName());
        cardViewViewHolder.dataDescription.setText(tvShow.getDescription());
        cardViewViewHolder.dataGenre.setText(tvShow.getGenre());
        cardViewViewHolder.dataTahun.setText(tvShow.getTahun());

    }

    @Override
    public int getItemCount() {
        return getListMovies().size();
    }

    class CardViewViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView dataName, dataDescription, dataGenre, dataTahun;
        ImageView dataPhoto;

        CardViewViewHolder(@NonNull final View itemView) {
            super(itemView);

            dataName = itemView.findViewById(R.id.txt_name);
            dataDescription = itemView.findViewById(R.id.txt_description);
            dataPhoto = itemView.findViewById(R.id.img_photo);
            dataGenre = itemView.findViewById(R.id.txt_genres);
            dataTahun = itemView.findViewById(R.id.txt_tahun);


            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            MovieModel tvShow = getListMovies().get(position);

            // TODO: EXTRA
            tvShow.setActionBarMark("1");

            Intent moveWithObjectIntent = new Intent(itemView.getContext(), MoveWithObjectActivity.class);
            moveWithObjectIntent.putExtra(MoveWithObjectActivity.EXTRA_MOVIE, tvShow);
            moveWithObjectIntent.putExtra(MoveWithObjectActivity.EXTRA_DATA, "1");
            context.startActivity(moveWithObjectIntent);
        }
    }

}
