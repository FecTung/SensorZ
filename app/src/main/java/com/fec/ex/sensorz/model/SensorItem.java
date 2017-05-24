package com.fec.ex.sensorz.model;

/**
 * Created by Fe2Cu on 2017.05.16.
 */

public class SensorItem {

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
}
