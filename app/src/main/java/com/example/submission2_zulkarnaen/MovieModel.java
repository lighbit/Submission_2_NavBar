package com.example.submission2_zulkarnaen;

import android.os.Parcel;
import android.os.Parcelable;

public class MovieModel implements Parcelable {

    // TODO: SET ALL
    private int photo;
    private String name;
    private String description;
    private String sinopsis;
    private String genre;
    private String tahun;

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public  String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public  String getDescription() {
        return description;
    }

    public  void setDescription(String description) {
        this.description = description;
    }

    public  String getSinopsis() {
        return sinopsis;
    }

    public  void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public   String getGenre() {
        return genre;
    }

    public   void setGenre(String genre) {
        this.genre = genre;
    }

    public   String getTahun() {
        return tahun;
    }

    public   void setTahun(String tahun) {
        this.tahun = tahun;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.photo);
        dest.writeString(this.name);
        dest.writeString(this.description);
        dest.writeString(this.sinopsis);
        dest.writeString(this.genre);
        dest.writeString(this.tahun);
    }

    public MovieModel() {
    }

    public MovieModel(Parcel in) {
        this.photo = in.readInt();
        this.name = in.readString();
        this.description = in.readString();
        this.sinopsis = in.readString();
        this.genre = in.readString();
        this.tahun = in.readString();
    }

    public static final Creator<MovieModel> CREATOR = new Creator<MovieModel>() {
        @Override
        public MovieModel createFromParcel(Parcel source) {
            return new MovieModel(source);
        }

        @Override
        public MovieModel[] newArray(int size) {
            return new MovieModel[size];
        }
    };
}
