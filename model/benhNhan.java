package model;

public class benhNhan {

    private String name;
    private int age;
    private int chieuCao;
    private int canNang;
    private String diaChi;

    public benhNhan(String name, int age, int chieuCao, int canNang, String diaChi) {
        this.name = name;
        this.age = age;
        this.chieuCao = chieuCao;
        this.canNang = canNang;
        this.diaChi = diaChi;
    }

    public benhNhan() {
        
    }

  
    
    
    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getChieuCao() {
        return chieuCao;
    }

    public void setChieuCao(int chieuCao) {
        this.chieuCao = chieuCao;
    }

    public int getCanNang() {
        return canNang;
    }

    public void setCanNang(int canNang) {
        this.canNang = canNang;
    }

    @Override
    public String toString() {
        return "benhNhan{" + "name=" + name + ", age=" + age + ", chieuCao=" + chieuCao + ", canNang=" + canNang + ", diaChi=" + diaChi + '}';
    }

    
}
