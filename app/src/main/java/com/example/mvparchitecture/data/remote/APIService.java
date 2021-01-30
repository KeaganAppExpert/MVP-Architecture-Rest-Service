package com.example.mvparchitecture.data.remote;

import com.example.mvparchitecture.data.model.MusicResponses;
import com.example.mvparchitecture.data.model.Result;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIService {
    @GET("/search?term=classick&amp;media=music&amp;entity=song&amp;limit=50")
    Call<MusicResponses> getAnswers();

    /*@GET("/search?term=classick&amp;media=music&amp;entity=song&amp;limit=50")
    Call<Result> getAnswers(@Query("tagged") String tags);*/
}
