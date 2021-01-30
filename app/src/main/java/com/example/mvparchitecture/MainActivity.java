package com.example.mvparchitecture;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.mvparchitecture.data.adapter.MusicAdapter;
import com.example.mvparchitecture.data.model.MusicResponses;
import com.example.mvparchitecture.data.model.Result;
import com.example.mvparchitecture.data.remote.APIService;
import com.example.mvparchitecture.data.utils.ApiUtils;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private MusicAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private APIService mService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mService = ApiUtils.getAPIService();
        mRecyclerView = findViewById(R.id.rv_answers);
        mAdapter = new MusicAdapter(this, new ArrayList<Result>(0), new MusicAdapter.PostItemListener() {

            @Override
            public void onPostClick(long id) {
                Toast.makeText(MainActivity.this, "Post id is" + id, Toast.LENGTH_SHORT).show();
            }
        });

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        mRecyclerView.addItemDecoration(itemDecoration);

        loadAnswers();
    }

    public void loadAnswers() {
        mService.getAnswers().enqueue(new Callback<MusicResponses>() {
            @Override
            public void onResponse(Call<MusicResponses> call, Response<MusicResponses> response) {

                if(response.isSuccessful()) {
                    mAdapter.updateAnswers(response.body().getResults());
                    Log.d("MainActivity", "posts loaded from API");
                }else {
                    int statusCode  = response.code();
                    // handle request errors depending on status code
                }
            }

            @Override
            public void onFailure(Call<MusicResponses> call, Throwable t) {
                //showErrorMessage();
                Log.d("MainActivity", "error loading from API");

            }
        });
    }
}