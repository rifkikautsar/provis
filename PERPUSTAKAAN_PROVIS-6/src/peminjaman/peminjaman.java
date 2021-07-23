/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peminjaman;

import buku.*;
import java.util.Date;

/**
 *
 * @author rifki
 */
public class peminjaman {
    private String noPinjam;
    private String tglPinjam;
    private String nis;
    private String nama_siswa;
    private String judul_buku;
    private String kdBuku;
    private String nip;
    
    
    
    public void setNoPinjam(String no){
        this.noPinjam = no;
    }
    public void setTglPinjam(String tgl){
        this.tglPinjam = tgl;
    }
    public void setNIS(String nis){
        this.nis = nis;
    }
    public void setKdBuku(String kd){
        this.kdBuku = kd;
    }
    public void setNIP(String nip){
        this.nip = nip;
    }
    public void setNamaSiswa(String ns){
        this.nama_siswa = ns;
    }
    public void setJudulBuku(String jd){
        this.judul_buku = jd;
    }
    public String getNoPinjam(){
        return noPinjam;
    }
    public String getTglPinjam(){
        return tglPinjam;
    }
    public String getNIS(){
        return nis;
    }
    public String getKdBuku(){
        return kdBuku;
    }
    public String getNIP(){
        return nip;
    }
    public String getNamaSiswa(){
        return nama_siswa;
    }
    public String getJudulBuku(){
        return judul_buku;
    }
    
    public peminjaman(String no,String nis,String ns,String kd,String jd,String tgl,String nip){
        setNoPinjam(no);
        setTglPinjam(tgl);
        setNIS(nis);
        setKdBuku(kd);
        setNIP(nip);
        setNamaSiswa(ns);
        setJudulBuku(jd);
    }
}
