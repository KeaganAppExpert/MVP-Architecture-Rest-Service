package com.example.mvparchitecture.data.mvp;

import com.example.mvparchitecture.data.model.MusicResponses;

import java.util.List;

public interface ViewPresenterContract {

    //presenter and view
    interface IPresenter extends BasePresenter {
        //calls that the view can call
        void retrieveData();
        void otherLogic();
    }

    interface IView extends BaseView<IPresenter> {
        //calls that the presenter can call
        void passDataAdapter(MusicResponses musicResponses);
    }
}
