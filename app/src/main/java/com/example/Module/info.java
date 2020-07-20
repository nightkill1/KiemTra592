package com.example.Module;

public class info {
    String date, pt, MV, BR;
    int id;


    public info (int id,String date, String pt, String MV, String BR) {
        this.id = id;
        this.date = date;
        this.pt = pt;
        this.MV = MV;
        this.BR = BR;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPt() {
        return pt;
    }

    public void setPt(String pt) {
        this.pt = pt;
    }

    public String getMV() {
        return MV;
    }

    public void setMV(String MV) {
        this.MV = MV;
    }

    public String getBR() {
        return BR;
    }

    public void setBR(String BR) {
        this.BR = BR;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
