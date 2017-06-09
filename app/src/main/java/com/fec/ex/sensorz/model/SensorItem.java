package com.fec.ex.sensorz.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Fe2Cu on 2017.05.16.
 */

public class SensorItem implements Parcelable{

    private String sensorName;
    private int sensorType;
    private int imgID;
    private String sensorValue;

    public SensorItem(String sensorName, int sensorType, int imgID, String sensorValue) {
        this.sensorName = sensorName;
        this.sensorType = sensorType;
        this.imgID = imgID;
        this.sensorValue = sensorValue;
    }

    public SensorItem(String sensorName, int sensorType, int imgID) {
        this.sensorName = sensorName;
        this.sensorType = sensorType;
        this.imgID = imgID;
    }

    public SensorItem(String sensorName, int sensorType) {
        this.sensorName = sensorName;
        this.sensorType = sensorType;
    }

    public String getSensorName() {
        return sensorName;
    }

    public void setSensorName(String sensorName) {
        this.sensorName = sensorName;
    }

    public int getSensorType() {
        return sensorType;
    }

    public void setSensorType(int sensorType) {
        this.sensorType = sensorType;
    }

    public int getImgID() {
        return imgID;
    }

    public void setImgID(int imgID) {
        this.imgID = imgID;
    }

    public String getSensorValue() {
        return sensorValue;
    }

    public void setSensorValue(String sensorValue) {
        this.sensorValue = sensorValue;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.imgID);
        dest.writeInt(this.sensorType);
        dest.writeString(this.sensorName);
        dest.writeString(this.sensorValue);
    }

    protected SensorItem(Parcel in) {
        this.imgID = in.readInt();
        this.sensorType = in.readInt();
        this.sensorName = in.readString();
        this.sensorValue = in.readString();
    }

    public static final Parcelable.Creator<SensorItem> CREATOR = new Parcelable.Creator<SensorItem>() {
        @Override
        public SensorItem createFromParcel(Parcel source) {
            return new SensorItem(source);
        }

        @Override
        public SensorItem[] newArray(int size) {
            return new SensorItem[size];
        }
    };
}
