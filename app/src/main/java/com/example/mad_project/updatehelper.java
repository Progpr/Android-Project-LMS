package com.example.mad_project;

public class updatehelper {

    String Username, Password, Roll, Sap, Sem, Year, School;

    public updatehelper(){

    }
    public updatehelper(String user, String pass, String roll, String sap, String sem, String year, String school) {

        Username = user;
        Password = pass;
        Sap = sap;
        Sem = sem;
        Year = year;
        School = school;
        Roll = roll;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getRoll() {
        return Roll;
    }

    public void setRoll(String roll) {
        Roll = roll;
    }

    public String getSap() {
        return Sap;
    }

    public void setSap(String sap) {
        Sap = sap;
    }

    public String getSem() {
        return Sem;
    }

    public void setSem(String sem) {
        Sem = sem;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }

    public String getSchool() {
        return School;
    }

    public void setSchool(String school) {
        School = school;
    }
}
