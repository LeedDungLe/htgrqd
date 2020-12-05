/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Admin
 */
public class tamQuanTrongXungBenh {
    private Xung xung;
    private benh benh;
    private double giaTri;


    public tamQuanTrongXungBenh(Xung xung, benh benh, double giaTri) {
        this.xung = xung;
        this.benh = benh;
        this.giaTri = giaTri;
    }

    
    
    public Xung getXung() {
        return xung;
    }

    public void setXung(Xung xung) {
        this.xung = xung;
    }

    public benh getBenh() {
        return benh;
    }

    public void setBenh(benh benh) {
        this.benh = benh;
    }

    public double getGiaTri() {
        return giaTri;
    }

    public void setGiaTri(double giaTri) {
        this.giaTri = giaTri;
    }

    @Override
    public String toString() {
        return "tamQuanTrongXungBenh{" + "xung=" + xung + ", benh=" + benh + '}';
    }
    
    
    
    
}
