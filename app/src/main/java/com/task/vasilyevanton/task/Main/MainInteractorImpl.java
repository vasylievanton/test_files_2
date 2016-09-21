package com.task.vasilyevanton.task.Main;


import android.app.Activity;

import com.task.vasilyevanton.task.DataBaseHandler;
import com.task.vasilyevanton.task.pojos.FileModel;

import java.util.ArrayList;

public class MainInteractorImpl implements MainInteractor {

    @Override
    public void getDatabaseData(OnDataBaseObtainListener listener, Activity activity) {
        DataBaseHandler db = new DataBaseHandler(activity);
        if (db.getFilesCount() == 0) {
            ArrayList<FileModel> data = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                FileModel model = new FileModel();
                if (i <= 3) {
                    model.setFilename("Some File");
                    model.setFileType("music");
                    model.setIsBlue(1);
                }
                if (i > 3 && i <= 6) {
                    model.setFilename("Some New File");
                    model.setFileType("image");
                    model.setIsOrange(1);
                }
                if (i > 6) {
                    model.setFilename("Some New File");
                    model.setFileType("movie");
                    model.setIsBlue(1);
                    model.setIsOrange(1);
                }
                model.setModDate("21.09.2016");
                data.add(model);
            }
            db.addFiles(data);
            listener.onSuccessDatabase(db.getFiles());
        } else {
            listener.onSuccessDatabase(db.getFiles());
        }

    }

    @Override
    public void setDatabaseData(ArrayList<FileModel> data, Activity activity) {
        DataBaseHandler db = new DataBaseHandler(activity);
        db.addFiles(data);
    }


}
