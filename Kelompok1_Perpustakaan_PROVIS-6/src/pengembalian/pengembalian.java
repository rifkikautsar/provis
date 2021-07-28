/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pengembalian;

import pengembalian.*;
import buku.*;
import java.util.Date;

/**
 *
 * @author rifki
 */
public class pengembalian {
    private String noPinjam;
    private String tglPinjam;
    private String nis;
    private String namaSiswa;
    private String judulBuku;
    private String tglKembali;
    private String nip;
    private String namaPegawai;
    private String kdBuku;
    private int denda;
    
    
    public void setKdBuku(String kd){
        this.kdBuku = kd;
    }
    public void setNoPinjam(String no){
        this.noPinjam = no;
    }
    public void setTglPinjam(String tgl){
        this.tglPinjam = tgl;
    }
    public void setNIS(String nis){
        this.nis = nis;
    }
    public void setTglKembali(String tgl2){
        this.tglKembali = tgl2;
    }
    public void setNIP(String nip){
        this.nip = nip;
    }
    public void setNamaSiswa(String ns){
        this.namaSiswa = ns;
    }
    public void setJudulBuku(String jd){
        this.judulBuku = jd;
    }
    public void setNamaPegawai(String np){
        this.namaPegawai = np;
    }
    public void setDenda(int dd){
        this.denda = dd;
    }
    public String getKdBuku(){
        return kdBuku;
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
    public String getTglKembali(){
        return tglKembali;
    }
    public String getNIP(){
        return nip;
    }
    public String getNamaSiswa(){
        return namaSiswa;
    }
    public String getJudulBuku(){
        return judulBuku;
    }
    public String getNamaPegawai(){
        return namaPegawai;
    }
    public int getDenda(){
        return denda;
    }
    public pengembalian(String no,String nis,String ns,String jd,String tgl,
            String tgl2,String nip,String np,int denda,String kd){
        setNoPinjam(no);
        setTglPinjam(tgl);
        setNIS(nis);
        setTglKembali(tgl2);
        setNIP(nip);
        setNamaSiswa(ns);
        setJudulBuku(jd);
        setNamaPegawai(np);
        setDenda(denda);
        setKdBuku(kd);
    }
}
