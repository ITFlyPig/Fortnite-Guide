package com.statstracker.forfornitegame.home;

public class EventModel {
    public int code;
    public String op;

    public EventModel(int code, String op) {
        this.code = code;
        this.op = op;
    }

    public EventModel(int code) {
        this.code = code;
    }
}
