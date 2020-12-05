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
public class luat {
    private benh benh;
    private Xung xung;
    private double weight;

    public luat(benh benh, Xung xung, double weight) {
        this.benh = benh;
        this.xung = xung;
        this.weight = weight;
    }

    public luat() {
         benh = new benh();
         xung = new Xung(); 
    }

    
    
    public benh getBenh() {
        return benh;
    }

    public void setBenh(benh benh) {
        this.benh = benh;
    }

    public Xung getXung() {
        return xung;
    }

    public void setXung(Xung xung) {
        this.xung = xung;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
    
    
    
    
}
