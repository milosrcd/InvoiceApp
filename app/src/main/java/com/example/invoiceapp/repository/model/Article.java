package com.example.invoiceapp.repository.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "articles")
public class Article {
    @PrimaryKey
    @NonNull
    @SerializedName("sif_mat")
    @Expose
    private String sifMat;
    @SerializedName("naziv")
    @Expose
    private String naziv;
    @SerializedName("pr_cena")
    @Expose
    private double prCena;

    @NonNull
    public String getSifMat() {
        return sifMat;
    }

    public void setSifMat(@NonNull String sifMat) {
        this.sifMat = sifMat;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public double getPrCena() {
        return prCena;
    }

    public void setPrCena(double prCena) {
        this.prCena = prCena;
    }

}
