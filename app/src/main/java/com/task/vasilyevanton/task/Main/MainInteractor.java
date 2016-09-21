package com.task.vasilyevanton.task.Main;


import android.app.Activity;

import com.task.vasilyevanton.task.pojos.FileModel;

import java.util.ArrayList;

public interface MainInteractor {


    void getDatabaseData(OnDataBaseObtainListener listener, Activity activity);
    void setDatabaseData(ArrayList<FileModel> data, Activity activity);

    interface OnDataBaseObtainListener {
        void onEmptyDatabase();
        void onSuccessDatabase(ArrayList<FileModel> data);
    }
}
