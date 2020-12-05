package model;

import java.util.Objects;

public class benh {
    private int id;
    private String tenBenh;
    private double weight;
    private double doXacNhan;
    private String thongTin;
    

    public benh(int id, String tenBenh) {
        this.id = id;
        this.tenBenh = tenBenh;
    }
    
    

    public benh(String tenBenh, double weight) {
        this.tenBenh = tenBenh;
        this.weight = weight;
    }

    public String getThongTin() {
        return thongTin;
    }

    public void setThongTin(String thongTin) {
        this.thongTin = thongTin;
    }

    
    
    public benh(String tenBenh) {
        this.tenBenh = tenBenh;
    }

    

    public benh(int id, String tenBenh, double weight) {
        this.id = id;
        this.tenBenh = tenBenh;
        this.weight = weight;
    }

    benh() {
        
    }

    public double getDoXacNhan() {
        return doXacNhan;
    }

    public void setDoXacNhan(double doXacNhan) {
        this.doXacNhan = doXacNhan;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenBenh() {
        return tenBenh;
    }

    public void setTenBenh(String tenBenh) {
        this.tenBenh = tenBenh;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        benh benh = (benh) o;
        return Objects.equals(tenBenh, benh.tenBenh);
    }
    
    

    @Override
    public int hashCode() {
        return Objects.hash(tenBenh);
    }
}
