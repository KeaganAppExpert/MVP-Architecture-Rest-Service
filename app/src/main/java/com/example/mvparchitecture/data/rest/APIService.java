package com.example.mvparchitecture.data.rest;

import com.example.mvparchitecture.data.model.MusicResponses;

import io.reactivex.Observable;
import retrofit2.http.GET;


public interface APIService {
    @GET("/search?term=classick&amp;media=music&amp;entity=song&amp;limit=50")
    Observable<MusicResponses> getAnswers();

    /*@GET("/search?term=classick&amp;media=music&amp;entity=song&amp;limit=50")
    Observable<MusicResponses> getAnswers(@Query("tagged") String tags);*/
}
