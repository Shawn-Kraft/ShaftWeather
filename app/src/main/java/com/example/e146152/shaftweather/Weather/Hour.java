package com.example.e146152.shaftweather.Weather;

import android.os.Parcel;
import android.os.Parcelable;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by E146152 on 9/19/2015.
 */
public class Hour implements Parcelable {

    private long mTime;
    private String mSummary;
    private double mTemp;
    private String mIcon;
    private  String mTimezone;

    public long getTime() {
        return mTime;
    }

    public void setTime(long time) {
        mTime = time;
    }

    public String getSummary() {
        return mSummary;
    }

    public void setSummary(String summary) {
        mSummary = summary;
    }

    public double getTemp() {
        return (int) Math.round(mTemp);
    }

    public void setTemp(double temp) {
        mTemp = temp;
    }

    public String getIcon() {
        return mIcon;
    }

    public int getIconId() {
        return Forecast.getIconId(mIcon);
    }

    public void setIcon(String icon) {
        mIcon = icon;
    }

    public String getTimezone() {
        return mTimezone;
    }

    public void setTimezone(String timezone) {
        mTimezone = timezone;
    }

    public String getHour() {
        SimpleDateFormat formatter = new SimpleDateFormat("h a");
        Date date = new Date(mTime * 1000);
        return formatter.format(date);
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(mTime);
        dest.writeString(mSummary);
        dest.writeDouble(mTemp);
        dest.writeString(mIcon);
        dest.writeString(mTimezone);
    }

    private Hour (Parcel in) {
        mTime = in.readLong();
        mSummary = in.readString();
        mTemp = in.readDouble();
        mIcon = in.readString();
        mTimezone = in.readString();
    }

    public Hour() {

    }

    public static final Creator<Hour> CREATOR = new Creator<Hour>() {

        @Override
        public Hour createFromParcel(Parcel source) {
            return new Hour(source);
        }

        @Override
        public Hour[] newArray(int size) {
            return new Hour[size];
        }
    };
}
