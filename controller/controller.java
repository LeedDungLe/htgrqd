package controller;

import database.database;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Xung;
import model.benh;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import model.*;
import view.*;


public class controller {
    private benhNhan bn ;
    private database db;
    private Set<Xung> xungs = new HashSet<>();
    
    private Set<tamQuanTrongXungBenh> importantness = new HashSet<>();
    private Set<luat> luats = new HashSet<>();
    private Set<benh> benhs = new HashSet<>();
    
    boolean sameImportantLvl;
    private double e = 0.02;
    
    
    private ketQuaGUI kq;
    private caChanDoanGUI caChanDoan ;
    private nhapXungGUI nhapXung ;
    private mainGUI mainG ;
    private chonTamQuanTrongGUI importantLvl;

    public controller() {
    }

    

    
    
    public Set<benh> getBenhs() {
        return benhs;
    }

    public void setBenhs(Set<benh> benhs) {
        this.benhs = benhs;
    }

    public ketQuaGUI getKq() {
        return kq;
    }

    public void setKq(ketQuaGUI kq) {
        this.kq = kq;
    }

    
    
    
    public caChanDoanGUI getCaChanDoan() {
        return caChanDoan;
    }

    public void setCaChanDoan(caChanDoanGUI caChanDoan) {
        this.caChanDoan = caChanDoan;
    }

    public nhapXungGUI getNhapXung() {
        return nhapXung;
    }

    public void setNhapXung(nhapXungGUI nhapXung) {
        this.nhapXung = nhapXung;
    }

    public mainGUI getMainG() {
        return mainG;
    }

    public void setMainG(mainGUI mainG) {
        this.mainG = mainG;
    }

    public chonTamQuanTrongGUI getImportantLvl() {
        return importantLvl;
    }

    public void setImportantLvl(chonTamQuanTrongGUI importantLvl) {
        this.importantLvl = importantLvl;
    }
    
    
    

    public controller(Set<Xung> xungs, boolean sameImportantLvl) {

        this.xungs = xungs;
        this.sameImportantLvl = sameImportantLvl;
    }

    public benhNhan getBn() {
        return bn;
    }

    public void setBn(benhNhan bn) {
        this.bn = bn;
    }

    
    
    public Set<tamQuanTrongXungBenh> gettamQuanTrongs() {
        return importantness;
    }

    public void settamQuanTrongs(Set<tamQuanTrongXungBenh> benhs) {
        this.importantness = benhs;
    }

    public Set<Xung> getXungs() {
        return xungs;
    }

    public void setXungs(Set<Xung> xungs) {
        this.xungs = xungs;
    }

    public boolean isSameImportantLvl() {
        return sameImportantLvl;
    }

    public void setSameImportantLvl(boolean sameImportantLvl) {
        this.sameImportantLvl = sameImportantLvl;
    }

        public void showMainGUI(){
        mainGUI frame = new mainGUI();
	frame.setVisible(true);
           
    }
    
    public void showCaChanDoanGUI(controller viewCtrl){
            caChanDoanGUI gui = new caChanDoanGUI(viewCtrl);
            this.caChanDoan = gui;
            caChanDoan.setVisible(true);
    }
    
     public void showNhapXungGUI(controller viewCtrl){
            
            nhapXungGUI gui = new nhapXungGUI(viewCtrl);
            this.nhapXung = gui;
            nhapXung.setVisible(true);
    }
     
     public void showChonTamQuanTrongGUI(controller viewCtrl){
            chonTamQuanTrongGUI gui = new chonTamQuanTrongGUI(viewCtrl);
            this.importantLvl = gui;
            importantLvl.setVisible(true);
    }
     
     public void showKetQuaGUI(controller viewCtrl){
         ketQuaGUI gui = new ketQuaGUI(viewCtrl);
         this.kq = gui;
         kq.setVisible(true);
     }
    
    
    public void xuLyBenh() throws SQLException{
        db = new database();
        Set<Integer> ids1 = new HashSet<>();
        Set<Integer> ids2 = new HashSet<>();
        ids1 = db.ruleIdsHave(xungs);
        ids2 = db.ruleIdsWithout(xungs);
        
        System.out.println("ids1 : "+ids1);
        System.out.println("ids2 : "+ids2);
        
        ids1.removeAll(ids2);
        System.out.println("new ids1 :" +ids1);
        Set<benh> Benhs = db.getBenhs(ids1);
       
        importantness = db.getImportantness(Benhs, xungs);
        for( tamQuanTrongXungBenh i: importantness){
            benhs.add(i.getBenh());
        }
        luats = db.getLuats(ids1);
        
    }
    
    public void calcBenhKhongCoTamQuanTrong(){
        for (benh benh : benhs){
            double DXN = 0;
            for ( Xung xung: xungs){
                double dxn = 0 ;
                for (luat luat : luats){
                    if( luat.getXung().equals(xung)){
                        if(benh.equals(luat.getBenh())){
                            dxn = Math.min( luat.getWeight(),xung.getMucDo());
                        }
                    }
                }
                DXN = Math.max(dxn, DXN);
            }
           benh.setDoXacNhan(DXN);
        }
    }
    
    public void calcBenhCoTamQuanTrong(){
        for (benh benh : benhs){
            double DXN = 0;
            for ( Xung xung: xungs){
                double dxn = 0 ;
                for (luat luat : luats){
                    for( tamQuanTrongXungBenh tqt : importantness){     
                        if( tqt.getBenh().equals(benh) & tqt.getXung().equals(xung)){
                            if( luat.getXung().equals(xung)){
                                 if(benh.equals(luat.getBenh())){
                                 dxn = Math.min( Math.min(xung.getMucDo(), tqt.getGiaTri()),luat.getWeight());
                                }   
                            }
                        }
                    }
                    
                }
                DXN = Math.max(dxn, DXN);
            }
           benh.setDoXacNhan(DXN);
        }
    }
 
    public void setThongTins(){
        for(benh benh: benhs){
            double gt = benh.getDoXacNhan();
            String tt ;
            if(gt == 1){
                tt = "Hoàn toàn xác nhận";
            }else if(gt < 1 & gt >=  0.6){
                tt = "Gần như xác nhận";
            }else if(gt < 0.6 & gt >= e ){
                tt ="Có thể xác nhận";
            }else if (gt < e & gt > 0){
                tt="Không xác định";
            }else{
                tt="Loại trừ hoàn toàn";
            }
            benh.setThongTin(tt);
        }        
    }
    

}
