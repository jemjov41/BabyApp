package com.example.jemmy.babyapp.entities;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Checklist implements Parcelable {

    private int id;
    private ArrayList<ChecklistParentContent> checklistParentContents;

    public Checklist() {
        super();
    }

    protected Checklist(Parcel in) {
        id = in.readInt();
        checklistParentContents = in.createTypedArrayList(ChecklistParentContent.CREATOR);
    }

    public static final Creator<Checklist> CREATOR = new Creator<Checklist>() {
        @Override
        public Checklist createFromParcel(Parcel in) {
            return new Checklist(in);
        }

        @Override
        public Checklist[] newArray(int size) {
            return new Checklist[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<ChecklistParentContent> getChecklistParentContents() {
        return checklistParentContents;
    }

    public void setChecklistParentContents(ArrayList<ChecklistParentContent> checklistParentContents) {
        this.checklistParentContents = checklistParentContents;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeTypedList(checklistParentContents);
    }

    @Override
    public String toString() {
        return "Checklist{" +
                "id=" + id +
                ", checklistParentContents=" + checklistParentContents +
                '}';
    }
}
