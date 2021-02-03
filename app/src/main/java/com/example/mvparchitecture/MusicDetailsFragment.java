package com.example.mvparchitecture;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mvparchitecture.data.adapter.MusicAdapter;
import com.example.mvparchitecture.data.model.MusicResponses;
import com.example.mvparchitecture.data.mvp.MusicListPresenter;
import com.example.mvparchitecture.data.mvp.ViewPresenterContract;
import com.example.mvparchitecture.data.utilities.RxUtils;

import rx.subscriptions.CompositeSubscription;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class MusicDetailsFragment extends Fragment implements ViewPresenterContract.IView {
    private RecyclerView mRecyclerView;
    private MusicAdapter mAdapter;
    private ProgressDialog pDialog;

    //Create an instance of the music list presenter
    private MusicListPresenter musicListPresenter;

    /**
     * Subscription that represents a group of Subscriptions that are unsubscribed together.*/


    private CompositeSubscription _subscriptions = new CompositeSubscription();

    public MusicDetailsFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.recycler_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        musicListPresenter = new MusicListPresenter(this);
        musicListPresenter.retrieveData();
        initialRecyclerView();
        intialaizeProgress();
    }



    @Override
    public void onResume() {
        super.onResume();
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
        mRecyclerView = getView().findViewById(R.id.list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
    }
    public void intialaizeProgress(){
        pDialog = new ProgressDialog(getContext());
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

    @Override
    public void passDataAdapter(MusicResponses musicResponses) {
        if (musicResponses.getResults() !=null && mRecyclerView != null) {
            mAdapter = new MusicAdapter(musicResponses.getResults(), R.layout.card_row, getContext());
            mRecyclerView.setAdapter(mAdapter);
            hidePDialog();
        }
    }

    @Override
    public void setPresenter(ViewPresenterContract.IPresenter presenter) {

    }
}