package database;

import model.*;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;


public class database {
    private Connection conn;
    private PreparedStatement ps ;
    private Set<Xung> xungs;
    private Set<benh> benhs;
    

    public static Connection openConnection() {
             
        String DB_URL = "jdbc:mysql://127.0.0.1 /htgrqd?useLegacyDatetimeCode=false&serverTimezone=UTC";
        String USER_NAME = "root";
        String PASSWORD = "";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            System.out.println("connect successfully!");
        } catch (Exception ex) {
            System.out.println("connect failure!");
            ex.printStackTrace();
        }
        return conn;
    }

    public Set<Xung> getxung() throws SQLException{
        conn = openConnection();
        xungs = new HashSet<>();
        String query = "SELECT * FROM pulse";

        try {
            PreparedStatement ps =  conn.prepareCall(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Xung monhoc = new Xung(rs.getString("ten"));
                xungs.add(monhoc);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        conn.close();
        return xungs;
    }

    public Set<benh> getBenhs(String tay, String vitri, String xung) throws SQLException{
        conn = openConnection();
        benhs = new HashSet<>();
        String query = "SELECT benh.* FROM benh,rules WHERE benh.id = rules.id_benh AND rules.tenXung = "+ xung ;
        try {
            PreparedStatement ps =  conn.prepareCall(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                benh benh = new benh(rs.getInt("id"),rs.getString("ten"),rs.getInt("weight"));
                benhs.add(benh);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        conn.close();
        return benhs;
    }
    
    public Set<Integer> ruleIdsHave(Set<Xung> xung) throws SQLException{
        Set<Integer> ids = new HashSet<>();
        List<Xung> xungs = new ArrayList<>();
        xungs.addAll(xung);
        conn = openConnection();
        for(int i=0; i< xungs.size(); i++){
            System.out.println(xungs.get(i));;
        }
        
        String query = "SELECT id_trieuChung FROM rules WHERE  tenXung ='"+ xungs.get(0).getTenXung()+"'";        
        
        for(int i=1; i< xungs.size(); i++){
            query = query + " OR tenXung = '"+ xungs.get(i).getTenXung() + "'";
        }
        
        try {
            PreparedStatement ps =  conn.prepareCall(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ids.add(rs.getInt("id_trieuchung"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        conn.close();
        return ids;
    }
    
    public Set<Integer> ruleIdsWithout(Set<Xung> xungs) throws SQLException{
        Set<Integer> ids = new HashSet<>();
        conn = openConnection();
       String query = "SELECT id_trieuChung FROM rules WHERE TRUE ";
        for (Xung i : xungs){
            query = query + " AND tenXung != '"+ i.getTenXung() + "'";
        }
        try {
            PreparedStatement ps =  conn.prepareCall(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ids.add(rs.getInt("id_trieuchung"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        conn.close();
        return ids;
       
    }
    
    public Set<benh> getBenhs(Set<Integer> ids) throws SQLException{
        Set<benh> benhs = new  HashSet<>();
        conn = openConnection();
        for ( Integer i: ids){
            String query = "SELECT * FROM trieuchung WHERE id = " + i;
            try {
                PreparedStatement ps =  conn.prepareCall(query);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    benhs.add( new benh(rs.getInt("id"),rs.getString("ten")));
                    
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        conn.close();
        return benhs;
    }
    
    public Set<tamQuanTrongXungBenh> getImportantness(Set<benh> benhs, Set<Xung> xungs) throws SQLException{
        Set<tamQuanTrongXungBenh> Importantness = new HashSet<>();
        conn = openConnection();
        
        for(benh benh : benhs){
            for(Xung xung: xungs){
                String query = "SELECT tamQuanTrong FROM mucdoquantrong WHERE tenTrieuChung ='" +benh.getTenBenh()+"' AND tenXung = '"+ xung.getTenXung()+"' ";
                try {
                PreparedStatement ps =  conn.prepareCall(query);
                ResultSet rs = ps.executeQuery();  
                    
                    if (rs.next() == false) System.out.println("empty");
                    else{
                        do{
                            System.out.println(rs.getInt("tamQuanTrong"));
                            Importantness.add(new tamQuanTrongXungBenh(xung, benh, rs.getDouble("tamQuanTrong")));
                        }
                         while (rs.next());
                    }
                    
               
            } catch (Exception e) {
                e.printStackTrace();
            }
                
            }
        }
        
        conn.close();
        return Importantness;
    }
    
   public Set<luat> getLuats(Set<Integer> ids){
       Set<luat> luats = new HashSet<>();
       conn = openConnection();
       for ( Integer i: ids){
            String query = "SELECT * FROM trieuchung, rules WHERE rules.id_trieuChung=trieuchung.id AND rules.id_trieuChung = " + i;
            try {
                PreparedStatement ps =  conn.prepareCall(query);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    luat luat = new luat();
                    luat.getBenh().setTenBenh(rs.getString("ten"));
                    luat.getXung().setTenXung(rs.getString("tenXung"));
                    luat.setWeight(rs.getDouble("weight"));
                    luats.add(luat);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
        }
       return luats;
   }


}
