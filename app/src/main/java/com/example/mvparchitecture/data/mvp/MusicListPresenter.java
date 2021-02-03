package com.example.mvparchitecture.data.mvp;

import android.util.Log;

import com.example.mvparchitecture.R;
import com.example.mvparchitecture.data.adapter.MusicAdapter;
import com.example.mvparchitecture.data.model.MusicResponses;
import com.example.mvparchitecture.data.rest.APIService;
import com.example.mvparchitecture.data.rest.RetrofitClient;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class MusicListPresenter implements ViewPresenterContract.IPresenter{
    private ViewPresenterContract.IView iView;

    public MusicListPresenter(ViewPresenterContract.IView iView) {
        this.iView = iView;
    }

    @Override
    public void retrieveData() {
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

                        //Call that passes the adapter to the view

                        iView.passDataAdapter(moviesResponses);
                    }

                    @Override
                    public void onError(Throwable e) {
                        /*hidePDialog();*/
                        Log.d("message", e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("Done");
                    }
                });
    }

    @Override
    public void otherLogic() {

    }
}
