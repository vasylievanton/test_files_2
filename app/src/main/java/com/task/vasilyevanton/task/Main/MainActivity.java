package com.task.vasilyevanton.task.Main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.task.vasilyevanton.task.R;
import com.task.vasilyevanton.task.adapter.FilesAdapter;
import com.task.vasilyevanton.task.pojos.FileModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MainView, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {
    private MainPresenter presenter;
    private ListView filesListView;
    private FilesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        filesListView = (ListView) findViewById(R.id.people_list);
        filesListView.setOnItemClickListener(this);
        filesListView.setOnItemLongClickListener(this);

        presenter = new MainPresenterImpl(this,this);
        presenter.getDBFiles();


    }

    //to Presenter
    @Override
    protected void onDestroy() {
        presenter.onDestroy(getApplicationContext());
        super.onDestroy();
    }

    @Override
    public void onResume() {
        presenter.onResume();
        super.onResume();
    }


    //from Presenter
    @Override
    public void setFilesData(ArrayList<FileModel> list) {
        if (adapter == null) {
            adapter = new FilesAdapter(MainActivity.this, R.layout.people_list_item, list);

        } else {
            adapter.notifyDataSetChanged();
        }
        filesListView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        FileModel model = (FileModel) adapterView.getItemAtPosition(i);
        if(model.getIsFolder()==1){
            //is folder
        }
        else {
            Log.w("File", model.getFilename());
        }
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(MainActivity.this,"Show SOme Dialog",Toast.LENGTH_LONG).show();
        return false;
    }
}
