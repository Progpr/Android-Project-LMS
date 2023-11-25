package com.example.mad_project;

public class updatehelper5 {

    String Bool;
    String CurrentTimeAndDate;

    public updatehelper5(){

    }

    public updatehelper5(String bool, String dandt) {

        Bool = bool;
        CurrentTimeAndDate = dandt;
    }

    public String getBool() {
        return Bool;
    }

    public void setBool(String bool) {
        Bool = bool;
    }


    public String getCurrentTimeAndDate() {
        return CurrentTimeAndDate;
    }

    public void setCurrentTimeAndDate(String currentTimeAndDate) {
        CurrentTimeAndDate = currentTimeAndDate;
    }
}
