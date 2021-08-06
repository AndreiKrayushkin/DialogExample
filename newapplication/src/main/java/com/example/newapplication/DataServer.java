package com.example.newapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DataServer {
    private String nameServer;
    private int numberOfUsers;
    private int bgColor;

    public DataServer (String nameServer, int numUsers, int bgColor) {
        this.nameServer = nameServer;
        this.numberOfUsers = numUsers;
        this.bgColor = bgColor;
    }

    public String getNameServer() {
        return nameServer;
    }

    public void setNameServer(String nameServer) {
        this.nameServer = nameServer;
    }

    public int getNumberOfUsers() {
        return numberOfUsers;
    }

    public void setNumberOfUsers(int numberOfUsers) {
        this.numberOfUsers = numberOfUsers;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        return super.equals(obj);
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }

    public int getBgColor() {
        return bgColor;
    }

    public void setBgColor(int bgColor) {
        this.bgColor = bgColor;
    }
}
