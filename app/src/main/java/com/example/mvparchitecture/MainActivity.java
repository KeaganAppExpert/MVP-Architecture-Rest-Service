package com.example.mvparchitecture;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

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




    private MusicDetailsFragment musicDetailsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.musicDetailsList = new MusicDetailsFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.musicListFragment, musicDetailsList)
                .commit();
    }


        @Override
        public void onResume() {
            super.onResume();
        /*_subscriptions = RxUtils.getNewCompositeSubIfUnsubscribed(_subscriptions);*/
        }

        @Override
        public void onPause() {
            super.onPause();
        }

        @Override
        public void onDestroy() {
            super.onDestroy();

        }

}
