package com.example.mad_project;

public class updatehelper3 {

    String ID;
    String Title;
    int Units;

    public updatehelper3(){

    }

    public updatehelper3(String id, String title, int units) {

        ID=id;
        Title = title;
        Units = units;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public int getUnits() {
        return Units;
    }

    public void setUnits(int units) {
        Units = units;
    }
}
