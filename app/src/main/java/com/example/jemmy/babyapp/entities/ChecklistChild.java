package com.example.jemmy.babyapp.entities;

import android.os.Parcel;
import android.os.Parcelable;

public class ChecklistChild implements Parcelable {

    private String text;
    private boolean done;

    public ChecklistChild() {
        super();
    }

    protected ChecklistChild(Parcel in) {
        text = in.readString();
        done = in.readByte() != 0;
    }

    public static final Creator<ChecklistChild> CREATOR = new Creator<ChecklistChild>() {
        @Override
        public ChecklistChild createFromParcel(Parcel in) {
            return new ChecklistChild(in);
        }

        @Override
        public ChecklistChild[] newArray(int size) {
            return new ChecklistChild[size];
        }
    };

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(text);
        dest.writeByte((byte) (done ? 1 : 0));
    }

    @Override
    public String toString() {
        return "ChecklistChild{" +
                "text='" + text + '\'' +
                ", done=" + done +
                '}';
    }
}
