/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import buku.buku;
import anggota.anggota;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import peminjaman.peminjaman;
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
    //anggota
    public ArrayList<anggota> tampilAnggota(){
        ArrayList<anggota> list = new ArrayList<anggota>();
        Connection conn=null;
        Statement st = null;
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,pwd);
            st = conn.createStatement();
            String sql = "SELECT * from anggota order by nis ASC";
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                list.add(new anggota(rs.getString("nis"),rs.getString("nama_siswa"),
                rs.getString("kelas"),rs.getString("jurusan"),rs.getString("tingkat")));
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
    
    public void tambahAnggota(anggota ag){
        Connection conn=null;
        Statement st = null;
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,pwd);
            st = conn.createStatement();
            String sql1 = "INSERT into anggota values('"+ag.getNis()+"',"
                            + "'"+ag.getNama()+"',"
                            + "'"+ag.getKelas()+"',"
                            + "'"+ag.getJurusan()+"',"
                            + "'"+ag.getTingkat()+"')";
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
    
    public String validasiTambahAnggota(String ag){
        String status = "";
        boolean validasi = false;
        Connection conn=null;
        Statement st = null;
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,pwd);
            st = conn.createStatement();
            String sql = "SELECT * from anggota order by nis ASC";
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                if(ag.equals(rs.getString("nis"))){
                            JOptionPane.showMessageDialog(null, "nis sudah ada!",
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
    
    public void hapusAnggota(String nis){
        Connection conn=null;
        Statement st = null;
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,pwd);
            st = conn.createStatement();
            String sql = "DELETE from anggota where nis='"+nis+"'";
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
    
    public void updateAnggota(anggota ag){
        Connection conn=null;
        Statement st = null;
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,pwd);
            st = conn.createStatement();
            String sql = "UPDATE anggota SET nama_siswa='"+ag.getNama()+"',"
                    + "kelas='"+ag.getKelas()+"',"
                    + "jurusan='"+ag.getJurusan()+"',"
                    + "tingkat='"+ag.getTingkat()+"'"
                    + "where nis='"+ag.getNis()+"'";
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
    
    public anggota pilihAnggota(String nis){
        anggota ag=null;
        Connection conn=null;
        Statement st = null;
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,pwd);
            st = conn.createStatement();
            String sql = "SELECT * from anggota where nis='"+nis+"'";
            ResultSet rs = st.executeQuery(sql);
           
            if(rs.next()){
                ag = new anggota(rs.getString("nis"),rs.getString("nama_siswa"),
                rs.getString("kelas"),rs.getString("jurusan"),
                rs.getString("tingkat"));
            }else
                ag = null;
            
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
    return ag;
    }
    public ArrayList<anggota> cariAnggota(String keyword){
        ArrayList<anggota> list = new ArrayList<anggota>();
        Connection conn=null;
        Statement st = null;
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,pwd);
            st = conn.createStatement();
            String sql = "SELECT * from anggota where nis like '%"+keyword+"%'"
                    + "or nama_siswa like '%"+keyword+"%'";
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                list.add(new anggota(rs.getString("nis"),rs.getString("nama_siswa"),
                rs.getString("kelas"),rs.getString("jurusan"),rs.getString("tingkat")));
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
    //Peminjaman
    public ArrayList<peminjaman> tampilPeminjaman(){
        ArrayList<peminjaman> list = new ArrayList<peminjaman>();
        Connection conn=null;
        Statement st = null;
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,pwd);
            st = conn.createStatement();
            String sql = "SELECT p.no_pinjam, p.nis, a.nama_siswa, p.kode_buku,"
                    + "b.judul_buku, p.tgl_pinjam, p.nip "
                    + "from peminjaman p join anggota a using(nis)"
                    + "join buku b using(kode_buku) order by a.nama_siswa ASC";
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                list.add(new peminjaman(rs.getString("no_pinjam"),
                    rs.getString("nis"),
                    rs.getString("nama_siswa"),rs.getString("kode_buku"),
                    rs.getString("judul_buku"),rs.getString("tgl_pinjam"),
                    rs.getString("nip")));
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
    public void tambahPeminjaman(peminjaman pj){
        Connection conn=null;
        Statement st = null;
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,pwd);
            st = conn.createStatement();
            String sql1 = "INSERT into peminjaman values('"+pj.getNoPinjam()+"',"
                            + "'"+pj.getTglPinjam()+"',"
                            + "'"+pj.getNIS()+"',"
                            + "'"+pj.getKdBuku()+"',"
                            + "'"+pj.getNIP()+"')";
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
    public void hapusPeminjaman(String no){
        Connection conn=null;
        Statement st = null;
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,pwd);
            st = conn.createStatement();
            String sql = "DELETE from peminjaman where no_pinjam='"+no+"'";
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
    public void updatePeminjaman(String no, String tgl){
        Connection conn=null;
        Statement st = null;
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,pwd);
            st = conn.createStatement();
            String sql = "UPDATE peminjaman SET tgl_pinjam='"+tgl+"'"
                    + "where no_pinjam='"+no+"'";
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
    
    public String loginUser(String username, String password){
        String status = "";
        boolean validasi = false;
        Connection conn=null;
        Statement st = null;
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,pwd);
            st = conn.createStatement();
            String sql = "SELECT * from petugas where username='"+username+"'";
            ResultSet rs = st.executeQuery(sql);
           
            while(rs.next()){
                if (rs.getString("pass").equals(password)) {
                    validasi = true;
                    status = "OK";
                }
                else if(validasi==false) {
                    status = "ERROR";
                }
            } 
                //pt = null;
            
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
    
}
