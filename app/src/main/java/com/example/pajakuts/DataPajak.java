package com.example.pajakuts;

import android.os.Parcel;
import android.os.Parcelable;

public class DataPajak implements Parcelable {
    private String nama;
    private int mobil1, mobil2, mobil3;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getMobil1() {
        return mobil1;
    }

    public void setMobil1(int mobil1) {
        this.mobil1 = mobil1;
    }

    public int getMobil2() {
        return mobil2;
    }

    public void setMobil2(int mobil2) {
        this.mobil2 = mobil2;
    }

    public int getMobil3() {
        return mobil3;
    }

    public void setMobil3(int mobil3) {
        this.mobil3 = mobil3;
    }

    public DataPajak(String nama, int mobil1, int mobil2, int mobil3) {
        this.nama = nama;
        this.mobil1 = mobil1;
        this.mobil2 = mobil2;
        this.mobil3 = mobil3;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nama);
        dest.writeInt(this.mobil1);
        dest.writeInt(this.mobil2);
        dest.writeInt(this.mobil3);
    }

    public void readFromParcel(Parcel source) {
        this.nama = source.readString();
        this.mobil1 = source.readInt();
        this.mobil2 = source.readInt();
        this.mobil3 = source.readInt();
    }

    protected DataPajak(Parcel in) {
        this.nama = in.readString();
        this.mobil1 = in.readInt();
        this.mobil2 = in.readInt();
        this.mobil3 = in.readInt();
    }

    public static final Parcelable.Creator<DataPajak> CREATOR = new Parcelable.Creator<DataPajak>() {
        @Override
        public DataPajak createFromParcel(Parcel source) {
            return new DataPajak(source);
        }

        @Override
        public DataPajak[] newArray(int size) {
            return new DataPajak[size];
        }
    };
}
