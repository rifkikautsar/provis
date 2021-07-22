/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import buku.buku;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author rifki
 */
public class database {
    public final String driver = "com.mysql.cj.jdbc.Driver";
    public final String url = "jdbc:mysql://localhost:3306/db10119240perpustakaan";
    public final String user = "root";
    public final String pwd = "";
    
    
    
    public ArrayList<buku> tampilBuku(){
        ArrayList<buku> list = new ArrayList<buku>();
        Connection conn=null;
        Statement st = null;
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,pwd);
            st = conn.createStatement();
            String sql = "SELECT * from buku order by kode_buku ASC";
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                list.add(new buku(rs.getString("kode_buku"),rs.getString("judul_buku"),
                rs.getString("penerbit"),rs.getString("tahun"),rs.getInt("stok")));
            }
            rs.close();
        }catch(Exception e){
            System.out.println("Error : "+e.getMessage());
        }finally{
            try{
                st.close();
            }catch(Exception e){}
            try{
                conn.close();
            }catch(Exception e){}
        }
        return list;
    }
    
    public ArrayList<buku> cariBuku(String keyword){
        ArrayList<buku> list = new ArrayList<buku>();
        Connection conn=null;
        Statement st = null;
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,pwd);
            st = conn.createStatement();
            String sql = "SELECT * from buku where kode_buku like '%"+keyword+"%'"
                    + "or judul_buku like '%"+keyword+"%'";
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                list.add(new buku(rs.getString("kode_buku"),rs.getString("judul_buku"),
                rs.getString("penerbit"),rs.getString("tahun"),rs.getInt("stok")));
            }
            rs.close();
        }catch(Exception e){
            System.out.println("Error : "+e.getMessage());
        }finally{
            try{
                st.close();
            }catch(Exception e){}
            try{
                conn.close();
            }catch(Exception e){}
        }
        return list;
    }
    
    public String validasiTambahBuku(String kd){
        String status = "";
        boolean validasi = false;
        Connection conn=null;
        Statement st = null;
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,pwd);
            st = conn.createStatement();
            String sql = "SELECT * from buku order by kode_buku ASC";
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                if(kd.equals(rs.getString("kode_buku"))){
                            JOptionPane.showMessageDialog(null, "Kode buku sudah ada!",
                                    "Warning",JOptionPane.WARNING_MESSAGE);
                            validasi = true;
                            status = "ERROR";
                }
                else if(validasi==false){
                    status = "OK";
                }
            }
            rs.close();
        }catch(Exception e){
            System.out.println("Error : "+e.getMessage());
        }finally{
            try{
                st.close();
            }catch(Exception e){}
            try{
                conn.close();
            }catch(Exception e){}
        }
        return status;
    }
    
    public void tambahBuku(buku bk){
        Connection conn=null;
        Statement st = null;
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,pwd);
            st = conn.createStatement();
            String sql1 = "INSERT into buku values('"+bk.getkdBuku()+"',"
                            + "'"+bk.getJudul()+"',"
                            + "'"+bk.getPenerbit()+"',"
                            + "'"+bk.getTahun()+"',"
                            + "'"+bk.getStok()+"')";
            st.executeUpdate(sql1);
        }catch(Exception e){
            System.out.println("Error : "+e.getMessage());
        }finally{
            try{
                st.close();
            }catch(Exception e){}
            try{
                conn.close();
            }catch(Exception e){}
        }
    }
    
    public void hapusBuku(String nim){
        Connection conn=null;
        Statement st = null;
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,pwd);
            st = conn.createStatement();
            String sql = "DELETE from buku where kode_buku='"+nim+"'";
            st.executeUpdate(sql);
        }catch(Exception e){
            System.out.println("Error : "+e.getMessage());
        }finally{
            try{
                st.close();
            }catch(Exception e){}
            try{
                conn.close();
            }catch(Exception e){}
        }
    }
    
    public void updateBuku(buku bk){
        Connection conn=null;
        Statement st = null;
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,pwd);
            st = conn.createStatement();
            String sql = "UPDATE buku SET judul_buku='"+bk.getJudul()+"',"
                    + "penerbit='"+bk.getPenerbit()+"',"
                    + "tahun='"+bk.getTahun()+"',"
                    + "stok='"+bk.getStok()+"'"
                    + "where kode_buku='"+bk.getkdBuku()+"'";
            st.executeUpdate(sql);
        }catch(Exception e){
            System.out.println("Error : "+e.getMessage());
        }finally{
            try{
                st.close();
            }catch(Exception e){}
            try{
                conn.close();
            }catch(Exception e){}
        }
    }
    public buku pilihBuku(String kd){
        buku bk=null;
        Connection conn=null;
        Statement st = null;
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,pwd);
            st = conn.createStatement();
            String sql = "SELECT * from buku where kode_buku='"+kd+"'";
            ResultSet rs = st.executeQuery(sql);
           
            if(rs.next()){
                bk = new buku(rs.getString("kode_buku"),rs.getString("judul_buku"),
                rs.getString("penerbit"),rs.getString("tahun"),
                rs.getInt("stok"));
            }else
                bk = null;
            
            rs.close();
        }catch(Exception e){
            System.out.println("Error : "+e.getMessage());
        }finally{
            try{
                st.close();
            }catch(Exception e){}
            try{
                conn.close();
            }catch(Exception e){}
        }
    return bk;
    }
}