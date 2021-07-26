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
import pengembalian.pengembalian;
/**
 *
 * @author rifki
 */
public class database {
    public final String driver = "com.mysql.cj.jdbc.Driver";
    public final String url = "jdbc:mysql://localhost:3306/db10119240perpustakaan";
    public final String user = "root";
    public final String pwd = "";
    private String username;
    
    
    public ArrayList<buku> tampilBuku(){
        ArrayList<buku> list = new ArrayList<buku>();
        Connection conn=null;
        Statement st = null;
        CallableStatement cs = null;
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,pwd);
            
            cs = conn.prepareCall("{ call tampilBuku() }");
            //ResultSet rs = st.executeQuery(sql);
            ResultSet rs = cs.executeQuery();
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
        CallableStatement cs = null;
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,pwd);
            cs = conn.prepareCall("{ call tampilBuku() }");
            ResultSet rs = cs.executeQuery();
            
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
        CallableStatement cs = null;
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,pwd);
            st = conn.createStatement();
//            String sql1 = "INSERT into buku values('"+bk.getkdBuku()+"',"
//                            + "'"+bk.getJudul()+"',"
//                            + "'"+bk.getPenerbit()+"',"
//                            + "'"+bk.getTahun()+"',"
//                            + "'"+bk.getStok()+"')";
            cs = conn.prepareCall("{ call inputBuku(?,?,?,?,?) }");
            cs.setString("kode_buku", bk.getkdBuku());
            cs.setString("judul_buku", bk.getJudul());
            cs.setString("penerbit", bk.getPenerbit());
            cs.setString("tahun", bk.getTahun());
            cs.setInt("stok", bk.getStok());
            cs.setString("status", "pinjam");
            cs.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan",
                        "Info",JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Data gagal ditambahkan : "+e.getMessage(),
                    "ERROR",JOptionPane.ERROR_MESSAGE);
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
            JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Data gagal dihapus : "+e.getMessage(),
                    "ERROR",JOptionPane.ERROR_MESSAGE);
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
            JOptionPane.showMessageDialog(null, "Data berhasil diupdate",
                    "Info",JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Data gagal diupdate : "+e.getMessage(),
                    "ERROR",JOptionPane.ERROR_MESSAGE);
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
            JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan",
                        "Info",JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Data gagal ditambahkan : "+e.getMessage(),
                        "ERROR",JOptionPane.ERROR_MESSAGE);
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
            JOptionPane.showMessageDialog(null, "Data berhasil diupdate",
                    "Info",JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Data gagal diupdate : "+e.getMessage(),
                    "ERROR",JOptionPane.ERROR_MESSAGE);
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
            String sql = "SELECT * from vTampilPeminjaman";
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                list.add(new peminjaman(rs.getString("no_pinjam"),
                    rs.getString("nis"),
                    rs.getString("nama_siswa"),rs.getString("kode_buku"),
                    rs.getString("judul_buku"),rs.getString("tgl_pinjam"),
                    rs.getString("nip"),rs.getString("nama_petugas"),
                    rs.getString("status")));
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
                            + "'"+pj.getNIP()+"',"
                            + "'"+pj.getStatus()+"')";
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
            JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
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
            JOptionPane.showMessageDialog(null, "Data berhasil diupdate",
                "Info",JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Data gagal dihapus : "+e.getMessage());
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
    public ArrayList<peminjaman> cariPeminjaman(String keyword){
        ArrayList<peminjaman> list = new ArrayList<peminjaman>();
        Connection conn=null;
        Statement st = null;
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,pwd);
            st = conn.createStatement();
            String sql = "SELECT p.no_pinjam, p.nis, a.nama_siswa, " 
                          + "b.judul_buku, p.tgl_pinjam,b.kode_buku, "
                          + " pt.nama_petugas, p.nip, p.status "
                          + " FROM peminjaman p JOIN anggota a USING(nis) "
                          + " JOIN buku b USING(kode_buku) JOIN petugas pt USING(nip)" 
                          + " where b.judul_buku like '%"+keyword+"%'"
                          + "or a.nama_siswa like '%"+keyword+"%'";
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                list.add(new peminjaman(rs.getString("no_pinjam"),
                    rs.getString("nis"),
                    rs.getString("nama_siswa"),rs.getString("kode_buku"),
                    rs.getString("judul_buku"),rs.getString("tgl_pinjam"),
                    rs.getString("nip"),rs.getString("nama_petugas"),
                    rs.getString("status")));
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
    //pengembalian
    public ArrayList<pengembalian> tampilPengembalian(){
        ArrayList<pengembalian> list = new ArrayList<pengembalian>();
        Connection conn=null;
        Statement st = null;
        CallableStatement cs = null;
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,pwd);
            st = conn.createStatement();
            String sql = "SELECT * from vTampilPengembalian";
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                list.add(new pengembalian(rs.getString("no_pinjam"),
                    rs.getString("nis"),
                    rs.getString("nama_siswa"),
                    rs.getString("judul_buku"),
                    rs.getString("tgl_pinjam"),
                    rs.getString("tgl_kembali"),
                    rs.getString("nip"),
                    rs.getString("nama_petugas"),
                    rs.getInt("denda")));
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
    public void tambahPengembalian(pengembalian pk){
        Connection conn=null;
        Statement st = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,pwd);
            st = conn.createStatement();
            cs = conn.prepareCall("{ call inputPengembalian(?,?,?) }");
            cs.setString("no_pinjam", pk.getNoPinjam());
            cs.setString("tgl_kembali", pk.getTglKembali());
            cs.setString("tgl_pinjam",pk.getTglPinjam());
            cs.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan",
                "Info",JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Data gagal ditambahkan : "+e.getMessage(),
                "ERROR",JOptionPane.ERROR_MESSAGE);
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
    public void hapusPengembalian(String no){
        Connection conn=null;
        Statement st = null;
        CallableStatement cs = null;
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,pwd);
            st = conn.createStatement();
            cs = conn.prepareCall("{ call hpsPengembalian(?) }");
            cs.setString("in_no_pinjam", no);
            cs.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Data gagal dihapus : "+e.getMessage());
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
    public ArrayList<pengembalian> cariPengembalian(String keyword){
        ArrayList<pengembalian> list = new ArrayList<pengembalian>();
        Connection conn=null;
        Statement st = null;
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,pwd);
            st = conn.createStatement();
            String sql = "SELECT p.no_pinjam, p.nis, a.nama_siswa," 
                          + "b.judul_buku, p.tgl_pinjam, pk.tgl_kembali, pk.denda,"
                          + " pt.nama_petugas, p.nip" 
                          + " FROM peminjaman p JOIN anggota a USING(nis) "
                          + " JOIN buku b USING(kode_buku) JOIN petugas pt USING(nip)" 
                          + " JOIN pengembalian pk USING(no_pinjam)"
                          + " where b.judul_buku like '%"+keyword+"%'"
                          + "or a.nama_siswa like '%"+keyword+"%'";
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                list.add(new pengembalian(rs.getString("no_pinjam"),
                    rs.getString("nis"),
                    rs.getString("nama_siswa"),
                    rs.getString("judul_buku"),
                    rs.getString("tgl_pinjam"),
                    rs.getString("tgl_kembali"),
                    rs.getString("nip"),
                    rs.getString("nama_petugas"),
                    rs.getInt("denda")));
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
    public String loginUser(String username, String password){
        String status = "";
        boolean validasi = false;
        Connection conn=null;
        Statement st = null;
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,pwd);
            st = conn.createStatement();
            String sql= "SELECT * FROM petugas WHERE username='"+username+"' "
                    + "AND pass='"+password+"'";                
            ResultSet rs = st.executeQuery(sql);
            
            //kondisi jika data ada
            if(rs.next()){
                userSession.setUsername(rs.getString("username"));
                userSession.setNIP(rs.getString("nip"));
                userSession.setNama("nama_petugas");
                status = "OK";
            }else{
                status = "ERROR";
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
//    public String getNIP(user u){
//        Connection conn=null;
//        Statement st = null;
//        String nip = "";
//        try{
//            Class.forName(driver);
//            conn = DriverManager.getConnection(url,user,pwd);
//            st = conn.createStatement();
//            String sql = "select nip('"+u.getUser()+"') as nip";
//            ResultSet rs = st.executeQuery(sql);
//            while(rs.next()){
//                nip = rs.getString("nip");
//            }
//        }catch(Exception e){
//            
//        }
//        return nip;
//    }
    
}
