package com.example.jemmy.babyapp.entities;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class ChecklistParentContent implements Parcelable {

    private int id;
    private String parent;
    private ArrayList<ChecklistChild> checklistChildren;

    public ChecklistParentContent() {
        super();
    }

    protected ChecklistParentContent(Parcel in) {
        id = in.readInt();
        parent = in.readString();
        checklistChildren = in.createTypedArrayList(ChecklistChild.CREATOR);
    }

    public static final Creator<ChecklistParentContent> CREATOR = new Creator<ChecklistParentContent>() {
        @Override
        public ChecklistParentContent createFromParcel(Parcel in) {
            return new ChecklistParentContent(in);
        }

        @Override
        public ChecklistParentContent[] newArray(int size) {
            return new ChecklistParentContent[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public ArrayList<ChecklistChild> getChecklistChildren() {
        return checklistChildren;
    }

    public void setChecklistChildren(ArrayList<ChecklistChild> checklistChildren) {
        this.checklistChildren = checklistChildren;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(parent);
        dest.writeTypedList(checklistChildren);
    }

    @Override
    public String toString() {
        return "ChecklistParentContent{" +
                "id=" + id +
                ", parent='" + parent + '\'' +
                ", checklistChildren=" + checklistChildren +
                '}';
    }
}
