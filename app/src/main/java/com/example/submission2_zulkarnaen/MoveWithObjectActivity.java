package com.example.submission2_zulkarnaen;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.Objects;

public class MoveWithObjectActivity extends AppCompatActivity {
    // TODO: EXTRA MOVIE FOR GET INTENCE
    public static final String EXTRA_MOVIE = "extra_movie";
    public static final String EXTRA_DATA = "actionbar";

    // TODO: SET TEXTVIEW AND IMAGEVIEW
    TextView dataName, dataDescription, sinopsis, tahun, genre;
    ImageView dataPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO: SET LAYOUT TO ACTIVITY MOVIE DETAIL
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_with_object);

        // TODO: DECLARED TEXTVIEW TO ID IN THE LAYOUT
        dataName = findViewById(R.id.txt_name);
        dataDescription = findViewById(R.id.txt_description);
        sinopsis = findViewById(R.id.tv_item_sinopsis);
        tahun = findViewById(R.id.tv_item_tahun);
        dataPhoto = findViewById(R.id.img_photo);
        genre = findViewById(R.id.tv_genre);

        //TODO: SET TO MOVIE MODEL
        MovieModel movie = getIntent().getParcelableExtra(EXTRA_MOVIE);
        assert movie != null;
        dataName.setText(movie.getName());
        dataDescription.setText(movie.getDescription());
        sinopsis.setText(movie.getSinopsis());
        tahun.setText(movie.getTahun());
        genre.setText(movie.getGenre());

        // TODO: GLIDE FOR PHOTO
        Glide.with(this)
                .load(movie.getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(dataPhoto);

        String sign = getIntent().getStringExtra(EXTRA_DATA);


        // TODO: CUSTOMER ACTION BAR
        if (sign !=null){
            getSupportActionBar().setTitle(R.string.app_name_movie);
        } else {
            getSupportActionBar().setTitle(R.string.app_name_tvshow);
        }

    }

}
