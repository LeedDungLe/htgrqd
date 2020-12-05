package model;

import java.util.Objects;

public class Xung {
    private String tenXung ;
    private String vitri;
    private String tay;
    private double mucDo;

    public Xung() {
    }

    
    
    public Xung(String tenXung, String vitri, String tay, double mucDo) {
        this.tenXung = tenXung;
        this.vitri = vitri;
        this.tay = tay;
        this.mucDo = mucDo;
    }

    public Xung(String tenXung) {
        this.tenXung = tenXung;
    }

    public Xung(String tenXung, String vitri) {
        this.tenXung = tenXung;
        this.vitri = vitri;
    }

    public double getMucDo() {
        return mucDo;
    }

    public void setMucDo(double mucDo) {
        this.mucDo = mucDo;
    }

    public String getTay() {
        return tay;
    }

    public void setTay(String tay) {
        this.tay = tay;
    }

    public String getTenXung() {
        return tenXung;
    }

    public void setTenXung(String tenXung) {
        this.tenXung = tenXung;
    }

    public String getVitri() {
        return vitri;
    }

    public void setVitri(String vitri) {
        this.vitri = vitri;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Xung xung = (Xung) o;
        return Objects.equals(tenXung, xung.tenXung);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tenXung);
    }

    @Override
    public String toString() {
        return "Xung{" + "tenXung=" + tenXung + ", mucDo=" + mucDo + '}';
    }
    
    
}
