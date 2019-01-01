package com.example.jemmy.babyapp.entities;

import android.os.Parcel;
import android.os.Parcelable;

public class ResepMakanan implements Parcelable {

    private String imageUrl;
    private String namaResep;
    private String kisaranUsia;
    private boolean bookmark;

    public ResepMakanan() {
        super();
    }

    protected ResepMakanan(Parcel in) {
        imageUrl = in.readString();
        namaResep = in.readString();
        kisaranUsia = in.readString();
        bookmark = in.readByte() != 0;
    }

    public static final Creator<ResepMakanan> CREATOR = new Creator<ResepMakanan>() {
        @Override
        public ResepMakanan createFromParcel(Parcel in) {
            return new ResepMakanan(in);
        }

        @Override
        public ResepMakanan[] newArray(int size) {
            return new ResepMakanan[size];
        }
    };

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getNamaResep() {
        return namaResep;
    }

    public void setNamaResep(String namaResep) {
        this.namaResep = namaResep;
    }

    public String getKisaranUsia() {
        return kisaranUsia;
    }

    public void setKisaranUsia(String kisaranUsia) {
        this.kisaranUsia = kisaranUsia;
    }

    public boolean isBookmark() {
        return bookmark;
    }

    public void setBookmark(boolean bookmark) {
        this.bookmark = bookmark;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(imageUrl);
        dest.writeString(namaResep);
        dest.writeString(kisaranUsia);
        dest.writeByte((byte) (bookmark ? 1 : 0));
    }

    @Override
    public String toString() {
        return "ResepMakanan{" +
                "imageUrl='" + imageUrl + '\'' +
                ", namaResep='" + namaResep + '\'' +
                ", kisaranUsia='" + kisaranUsia + '\'' +
                ", bookmark=" + bookmark +
                '}';
    }
}
