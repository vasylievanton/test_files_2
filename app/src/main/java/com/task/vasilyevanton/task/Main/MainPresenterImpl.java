package com.task.vasilyevanton.task.Main;


import android.app.Activity;
import android.content.Context;
import android.util.Log;

import com.task.vasilyevanton.task.DataBaseHandler;
import com.task.vasilyevanton.task.pojos.FileModel;

import java.util.ArrayList;

public class MainPresenterImpl implements MainPresenter, MainInteractor.OnDataBaseObtainListener {

    private MainView mainView;
    private MainInteractor mainInteractor;
    private Activity mActivity;

    public MainPresenterImpl(MainView mainView, Activity activity) {
        this.mainView = mainView;
        this.mainInteractor = new MainInteractorImpl();
        this.mActivity=activity;
    }

    //from VIEW
    @Override
    public void getDBFiles() {
        if (mainView != null) {
            Log.w("getDBFiles", "Get db data");
            mainInteractor.getDatabaseData(this, mActivity);
        }

    }

    @Override
    public void onDestroy(Context context) {
        DataBaseHandler dataBaseHandler = new DataBaseHandler(context);
        dataBaseHandler.deleteAll();
        mainView = null;

    }

    @Override
    public void onResume() {
        if (mainView != null) {
            //
        }
    }


    @Override
    public void onEmptyDatabase() {
        Log.w("Empty db", "Get Api data");
    }


    @Override
    public void onSuccessDatabase(ArrayList<FileModel> data) {
        if (mainView != null) {
            Log.w("Load db", "data");
            mainView.setFilesData(data);
        }
    }
}
