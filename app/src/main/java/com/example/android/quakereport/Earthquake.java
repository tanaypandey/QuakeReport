package com.example.android.quakereport;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Earthquake {

    private double  mMagnitudeId;
    private String mPlaceId;
    private long mDateId;
    private  String mUrl;

    public Earthquake(double MagnitudeId, String PlaceId, long DateId,String url){
        mMagnitudeId = MagnitudeId;
        mPlaceId = PlaceId;
        mDateId = DateId;
        mUrl = url;
    }

    public double getMagnitudeId() {
        return mMagnitudeId;
    }

    public String getPlaceId() {
        return mPlaceId;
    }

    public long getDateId() {
        return mDateId;
    }

    public String getUrl() {
        return mUrl;
    }
}
