package com.fec.ex.sensorz;

/**
 * Created by USFec on 2017.05.16.
 */

public class SensorItem {

    private String sensorName;
    private String sensorValue;
    private String SensorCal;
    private int imgID;
    private boolean hasSensor;

    public SensorItem(String sensorName, String sensorValue, String sensorCal, int imgID, boolean hasSensor) {
        this.sensorName = sensorName;
        this.sensorValue = sensorValue;
        this.SensorCal = sensorCal;
        this.imgID = imgID;
        this.hasSensor = hasSensor;
    }

    public SensorItem(String sensorName, String sensorValue) {
        this.sensorName = sensorName;
        this.sensorValue = sensorValue;
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
        return SensorCal;
    }

    public void setSensorCal(String sensorCal) {
        SensorCal = sensorCal;
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
