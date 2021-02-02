package com.example.mvparchitecture;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class MusicListDetailsActivity extends AppCompatActivity {
    public static final String ARTIST_NAME = "com.example.mvparchitecture.ARTIST_NAME";
    public static final String TRACK_NAME = "com.example.mvparchitecture.TRACK_NAME";
    public static final String TRACK_PRICE = "com.example.mvparchitecture.TRACK_PRICE";
    public static final String COLLECTION_NAME = "com.example.mvparchitecture.COLLECTION_NAME";
    public static final String TRACK_URL = "com.example.mvparchitecture.TRACK_URL";
    public static final String RATING = "com.example.mvparchitecture.RATING";
    public static final String COLLECTION_ARTIST_URL = "com.example.mvparchitecture.COLLECTION_ARTIST_URL";

    private ImageView collectionURL, trackURL;
    private TextView artistName, trackName, trackPrice, collectionName, rating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_list_details);

        artistName = findViewById(R.id.artist_Name);
        trackName = findViewById(R.id.track_Name);
        trackPrice = findViewById(R.id.trackPrice);
        collectionName = findViewById(R.id.collectionName);
        rating = findViewById(R.id.song_Rating);
        trackURL = findViewById(R.id.artistImage);

        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {

        artistName.setText(bundle.getString(ARTIST_NAME));
        trackName.setText(bundle.getString(TRACK_NAME));
        trackPrice.setText(bundle.getString(TRACK_PRICE));
        collectionName.setText(bundle.getString(COLLECTION_NAME));
        rating.setText(bundle.getString(RATING));
            int resId = bundle.getInt(TRACK_URL);
            trackURL.setImageResource(resId);
        }
    }
}