package com.task.vasilyevanton.task.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.task.vasilyevanton.task.R;
import com.task.vasilyevanton.task.pojos.FileModel;

import java.util.List;

public class FilesAdapter extends ArrayAdapter<FileModel> {

    protected List<FileModel> mDataList;
    private Activity activity;
    private Integer mLayout;


    public FilesAdapter(Activity context, Integer mLayout, List<FileModel> dataList) {
        super(context, mLayout, dataList);
        this.activity = context;
        this.mLayout = mLayout;
        this.mDataList = dataList;
    }

    @Override
    public View getView(final int position, View mConvertView, ViewGroup parent) {

        final ViewHolder mHolder;
        if (mConvertView == null) {
            LayoutInflater inflater = activity.getLayoutInflater();
            mConvertView = inflater.inflate(this.mLayout, null, false);
            mHolder = new ViewHolder();
            //
            mHolder.colorTop = (LinearLayout) mConvertView.findViewById(R.id.top_color_element);
            mHolder.colorBottom = (LinearLayout) mConvertView.findViewById(R.id.bottom_color_element);
            mHolder.isFolderLeft = (View) mConvertView.findViewById(R.id.left_element);
            mHolder.isFolderRight = (View) mConvertView.findViewById(R.id.right_element);

            mHolder.name = (TextView) mConvertView.findViewById(R.id.file_name);
            mHolder.modified = (TextView) mConvertView.findViewById(R.id.modified);
            mHolder.image = (ImageView) mConvertView.findViewById(R.id.image_people);

            //
            mConvertView.setTag(mHolder);

        } else {
            mHolder = (ViewHolder) mConvertView.getTag();
        }


        mHolder.name.setText(mDataList.get(position).getFilename());
        mHolder.modified.setText("modified " + mDataList.get(position).getModDate());



        return mConvertView;
    }

    static class ViewHolder {
        public TextView name, modified;
        public ImageView image;
        public View isFolderLeft,isFolderRight;
        public LinearLayout colorTop, colorBottom;

    }

}
