package com.example.jemmy.babyapp.entities;

public class Activities {
    private int id;
    private String text;
    private boolean done;

    public Activities() {
        super();
    }

    public Activities(int id, String text, boolean done) {
        this.id = id;
        this.text = text;
        this.done = done;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
    public String toString() {
        return "Activities{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", done=" + done +
                '}';
    }
}
