package com.task.vasilyevanton.task.Main;


import android.content.Context;

public interface MainPresenter {
    void getDBFiles();
    void onDestroy(Context context);
    void onResume();
}
