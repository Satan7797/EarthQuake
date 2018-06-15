package com.example.android.quakereport;
public class Earthquake {
    private double mMagnitude;
    private String mCity;
    private long mDate;
    private String mURL;
    Earthquake(double magnitude,String city,long date,String url){
        mMagnitude=magnitude;
        mCity=city;
        mDate=date;
        mURL=url;
    }

    public double getMagnitude(){
        return mMagnitude;
    }
    public String getCity(){
        return mCity;
    }
    public long getDate(){
        return mDate;
    }
    public String getURL(){
        return mURL;
    }
}
