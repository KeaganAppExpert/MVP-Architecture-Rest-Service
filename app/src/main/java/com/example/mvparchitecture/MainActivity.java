package com.example.mvparchitecture;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;

import com.example.mvparchitecture.data.adapter.MusicAdapter;
import com.example.mvparchitecture.data.model.MusicResponses;
import com.example.mvparchitecture.data.model.Result;
import com.example.mvparchitecture.data.rest.APIService;
import com.example.mvparchitecture.data.rest.RetrofitClient;
import com.example.mvparchitecture.data.utilities.RxUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private MusicAdapter mAdapter;
    private ProgressDialog pDialog;


/**
     * Subscription that represents a group of Subscriptions that are unsubscribed together.*/

    private CompositeSubscription _subscriptions = new CompositeSubscription();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_main);
        initialRecyclerView();
        intialaizeProgress();
        loadMusicList();
    }

public void loadMusicList() {
        APIService apiService =
                RetrofitClient.getClient().create(APIService.class);
        apiService.getAnswers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MusicResponses>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MusicResponses moviesResponses) {
                        if (moviesResponses.getResultCount() > 0 && mRecyclerView != null) {
                            mAdapter = new MusicAdapter(moviesResponses.getResults(), R.layout.card_row, getApplicationContext());
                            mRecyclerView.setAdapter(mAdapter);
                            hidePDialog();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        hidePDialog();
                        Log.d("message", e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("Done");
                    }
                });
    }


    @Override
    public void onResume() {
        super.onResume();
_subscriptions = RxUtils.getNewCompositeSubIfUnsubscribed(_subscriptions);

    }

    @Override
    public void onPause() {
        super.onPause();
RxUtils.unsubscribeIfNotNull(_subscriptions);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
hidePDialog();

    }

 public void initialRecyclerView(){
        mRecyclerView = (RecyclerView)findViewById(R.id.list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
    }
    public void intialaizeProgress(){
        pDialog = new ProgressDialog(this);
        // Showing progress dialog before making http request
        pDialog.setMessage("Loading...");
        pDialog.show();
    }

    private void hidePDialog() {
        if (pDialog != null) {
            pDialog.dismiss();
            pDialog = null;
        }
    }

}
