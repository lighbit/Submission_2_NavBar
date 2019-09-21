package com.example.submission2_zulkarnaen.ui.Fragment;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.submission2_zulkarnaen.Adapter.CardViewTvShowAdapter;
import com.example.submission2_zulkarnaen.MovieModel;
import com.example.submission2_zulkarnaen.R;

import java.util.ArrayList;

public class TvShowFragment extends Fragment {

    private RecyclerView rvTvShow;
    private ArrayList<MovieModel> list = new ArrayList<>();
    private String[] dataName;
    private String[] dataDescription;
    private TypedArray dataPhoto;
    private String[] sinopsis;
    private String[] tahun;
    private String[] genre;


    public TvShowFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        rvTvShow = view.findViewById(R.id.rv_category);
        rvTvShow.setHasFixedSize(true);

        list.addAll(getListData());
        showRecyclerTvShow();

        return view;
    }

    private void showRecyclerTvShow() {
        rvTvShow.setLayoutManager(new LinearLayoutManager(this.getContext()));
        CardViewTvShowAdapter cardViewTvShowAdapter = new CardViewTvShowAdapter(this.getContext());
        cardViewTvShowAdapter.setListTvShow(list);
        rvTvShow.setAdapter(cardViewTvShowAdapter);
    }

    private void prepare() {
        dataName = getResources().getStringArray(R.array.data_name_tv);
        dataDescription = getResources().getStringArray(R.array.data_description_tv);
        sinopsis = getResources().getStringArray(R.array.data_sinopsis_tv);
        tahun = getResources().getStringArray(R.array.data_tahun_tv);
        dataPhoto = getResources().obtainTypedArray(R.array.data_photo_tv);
        genre = getResources().getStringArray(R.array.data_genre_tv);
    }


    private ArrayList<MovieModel> getListData() {

        prepare();

        ArrayList<MovieModel> movieModelArrayList = new ArrayList<>();
        for (int i = 0; i < dataName.length; i++) {
            MovieModel movieModel = new MovieModel();
            movieModel.setPhoto(dataPhoto.getResourceId(i, -1));
            movieModel.setName(dataName[i]);
            movieModel.setDescription(dataDescription[i]);
            movieModel.setSinopsis(sinopsis[i]);
            movieModel.setTahun(tahun[i]);
            movieModel.setGenre(genre[i]);
            movieModelArrayList.add(movieModel);
        }
        return movieModelArrayList;
    }
}