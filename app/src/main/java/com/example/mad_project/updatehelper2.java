package com.example.mad_project;

public class updatehelper2 {

    String Bool;
    int LockerNo;

    String CurrentTimeAndDate;

    public updatehelper2(){

    }

    public updatehelper2(String bool, int LN, String dandt) {

        Bool = bool;
        LockerNo = LN;
        CurrentTimeAndDate = dandt;
    }

    public String getBool() {
        return Bool;
    }

    public void setBool(String bool) {
        Bool = bool;
    }

    public int getLockerNo() {
        return LockerNo;
    }

    public void setLockerNo(int lockerNo) {
        LockerNo = lockerNo;
    }

    public String getCurrentTimeAndDate() {
        return CurrentTimeAndDate;
    }

    public void setCurrentTimeAndDate(String currentTimeAndDate) {
        CurrentTimeAndDate = currentTimeAndDate;
    }
}
