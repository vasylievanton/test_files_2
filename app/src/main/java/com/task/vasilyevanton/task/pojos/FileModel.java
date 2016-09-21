package com.task.vasilyevanton.task.pojos;

public class FileModel {

    String filename;
    int isFolder;
    String modDate;
    String mFileType;
    int isOrange;
    int isBlue;

    public FileModel() {
        this.filename = "";
        this.isFolder = 0;
        this.modDate = "";
        this.mFileType = "";
        this.isOrange = 0;
        this.isBlue = 0;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public int getIsFolder() {
        return isFolder;
    }

    public void setIsFolder(int isFolder) {
        this.isFolder = isFolder;
    }

    public String getModDate() {
        return modDate;
    }

    public void setModDate(String modDate) {
        this.modDate = modDate;
    }

    public String getFileType() {
        return mFileType;
    }

    public void setFileType(String fileType) {
        mFileType = fileType;
    }

    public int getIsOrange() {
        return isOrange;
    }

    public void setIsOrange(int isOrange) {
        this.isOrange = isOrange;
    }

    public int getIsBlue() {
        return isBlue;
    }

    public void setIsBlue(int isBlue) {
        this.isBlue = isBlue;
    }


}
