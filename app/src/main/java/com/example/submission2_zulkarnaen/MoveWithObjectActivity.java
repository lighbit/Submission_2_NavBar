package com.example.submission2_zulkarnaen;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class MoveWithObjectActivity extends AppCompatActivity {
    // TODO: EXTRA MOVIE FOR GET INTENCE
    public static final String EXTRA_MOVIE = "extra_movie";

    // TODO: SET TEXTVIEW AND IMAGEVIEW
    TextView dataName, dataDescription, sinopsis, tahun;
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

        //TODO: SET TO MOVIE MODEL
        MovieModel movie = getIntent().getParcelableExtra(EXTRA_MOVIE);
        dataName.setText(movie.getName());
        dataDescription.setText(movie.getDescription());
        sinopsis.setText(movie.getSinopsis());
        tahun.setText(movie.getTahun());

        // TODO: GLIDE FOR PHOTO
        Glide.with(this)
                .load(movie.getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(dataPhoto);
    }

}
