package com.example.invoiceapp.repository.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "customers")
public class Customer {
    @PrimaryKey
    @NonNull
    @SerializedName("sif_firme")
    @Expose
    private int sifFirme;
    @SerializedName("descript")
    @Expose
    private String descript;
    @SerializedName("br_poste")
    @Expose
    private int brPoste;
    @SerializedName("ulica")
    @Expose
    private String ulica;
    @SerializedName("broj")
    @Expose
    private String broj;
    @SerializedName("mesto")
    @Expose
    private String mesto;
    @SerializedName("pib")
    @Expose
    private String pib;

    public int getSifFirme() {
        return sifFirme;
    }

    public void setSifFirme(int sifFirme) {
        this.sifFirme = sifFirme;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public int getBrPoste() {
        return brPoste;
    }

    public void setBrPoste(int brPoste) {
        this.brPoste = brPoste;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getBroj() {
        return broj;
    }

    public void setBroj(String broj) {
        this.broj = broj;
    }

    public String getMesto() {
        return mesto;
    }

    public void setMesto(String mesto) {
        this.mesto = mesto;
    }

    public String getPib() {
        return pib;
    }

    public void setPib(String pib) {
        this.pib = pib;
    }

}