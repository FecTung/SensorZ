package com.fec.ex.sensorz;

/**
 * Created by Fe2Cu on 2017.05.16.
 */

public class SensorItem {

    private String sensorName;
    private String sensorValue;
    private String sensorCal;
    private int imgID;
    private boolean hasSensor;

    public SensorItem(String sensorName, String sensorValue, String sensorCal, int imgID, boolean hasSensor) {
        this.sensorName = sensorName;
        this.sensorValue = sensorValue;
        this.sensorCal = sensorCal;
        this.imgID = imgID;
        this.hasSensor = hasSensor;
    }

    public SensorItem(String sensorName, String sensorValue, String sensorCal, boolean hasSensor) {
        this.sensorName = sensorName;
        this.sensorValue = sensorValue;
        this.sensorCal = sensorCal;
        this.hasSensor = hasSensor;
    }

    public SensorItem(String sensorName, String sensorValue, String sensorCal) {
        this.sensorName = sensorName;
        this.sensorValue = sensorValue;
        this.sensorCal = sensorCal;
    }

    public SensorItem(String sensorName, String sensorValue, boolean hasSensor) {
        this.sensorName = sensorName;
        this.sensorValue = sensorValue;
        this.hasSensor = hasSensor;
    }

    public SensorItem(String sensorName, String sensorValue) {
        this.sensorName = sensorName;
        this.sensorValue = sensorValue;
    }

    public SensorItem(String sensorName) {
        this.sensorName = sensorName;
    }

    public SensorItem() {
    }

    public String getSensorName() {
        return sensorName;
    }

    public void setSensorName(String sensorName) {
        this.sensorName = sensorName;
    }

    public String getSensorValue() {
        return sensorValue;
    }

    public void setSensorValue(String sensorValue) {
        this.sensorValue = sensorValue;
    }

    public String getSensorCal() {
        return sensorCal;
    }

    public void setSensorCal(String sensorCal) {
        this.sensorCal = sensorCal;
    }

    public int getImgID() {
        return imgID;
    }

    public void setImgID(int imgID) {
        this.imgID = imgID;
    }

    public boolean isHasSensor() {
        return hasSensor;
    }

    public void setHasSensor(boolean hasSensor) {
        this.hasSensor = hasSensor;
    }
}
