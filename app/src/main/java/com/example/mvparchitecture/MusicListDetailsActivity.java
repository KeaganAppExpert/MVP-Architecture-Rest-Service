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
    public static final String RELEASE_DATE = "com.example.mvparchitecture.RELEASE_DATE";
    public static final String PRIMARY_GENRE_RELEASE = "com.example.mvparchitecture.PRIMARY_GENRE_RELEASE";
    public static final String TRACK_EXPLICITNESS = "com.example.mvparchitecture.TRACK_EXPLICITNESS";
    public static final String TRACK_NUMBER = "com.example.mvparchitecture.TRACK_NUMBER";

    private ImageView collectionURL, trackURL;
    private TextView artistName, trackName, trackPrice, collectionName, rating, releaseDate, primaryGenreName, trackExplicitness, trackNumber;

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
        releaseDate = findViewById(R.id.release_Date);
        primaryGenreName = findViewById(R.id.primary_Genre_Name);
        trackExplicitness = findViewById(R.id.Track_Explicitness);
        trackNumber = findViewById(R.id.track_Number);

        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            artistName.setText(bundle.getString(ARTIST_NAME));
            trackName.setText(bundle.getString(TRACK_NAME));
            trackPrice.setText(bundle.getString(TRACK_PRICE));
            collectionName.setText(bundle.getString(COLLECTION_NAME));
            rating.setText(bundle.getString(RATING));
            /*int resId = bundle.getInt(TRACK_URL);
            trackURL.setImageResource(resId);*/
            Glide.with(this)
                    .load(bundle.getInt(TRACK_URL))
                    .into(trackURL);
            releaseDate.setText(bundle.getString(RELEASE_DATE));
            primaryGenreName.setText(bundle.getString(PRIMARY_GENRE_RELEASE));
            trackExplicitness.setText(bundle.getString(TRACK_EXPLICITNESS));
            trackNumber.setText(bundle.getString(TRACK_NUMBER));
        }
    }
}