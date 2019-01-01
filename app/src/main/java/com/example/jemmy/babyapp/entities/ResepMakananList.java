package com.example.jemmy.babyapp.entities;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class ResepMakananList implements Parcelable {

    private ArrayList<ResepMakanan> resepMakanans;

    public ResepMakananList() {
        super();
    }

    protected ResepMakananList(Parcel in) {
        resepMakanans = in.createTypedArrayList(ResepMakanan.CREATOR);
    }

    public static final Creator<ResepMakananList> CREATOR = new Creator<ResepMakananList>() {
        @Override
        public ResepMakananList createFromParcel(Parcel in) {
            return new ResepMakananList(in);
        }

        @Override
        public ResepMakananList[] newArray(int size) {
            return new ResepMakananList[size];
        }
    };

    public ArrayList<ResepMakanan> getResepMakanans() {
        return resepMakanans;
    }

    public void setResepMakanans(ArrayList<ResepMakanan> resepMakanans) {
        this.resepMakanans = resepMakanans;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(resepMakanans);
    }

    @Override
    public String toString() {
        return "ResepMakananList{" +
                "resepMakanans=" + resepMakanans +
                '}';
    }
}
