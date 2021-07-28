/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buku;

/**
 *
 * @author rifki
 */
public class buku {
    private String kdBuku;
    private String judul;
    private String penerbit;
    private String tahun;
    private int stok;

    
    
    public void setkdBuku(String kd){
        this.kdBuku = kd;
    }
    public void setJudul(String judul){
        this.judul = judul;
    }
    public void setPenerbit(String pnb){
        this.penerbit = pnb;
    }
    public void setTahun(String thn){
        this.tahun = thn;
    }
    public void setStok(int stok){
        this.stok = stok;
    }
    public String getkdBuku(){
        return kdBuku;
    }
    public String getJudul(){
        return judul;
    }
    public String getPenerbit(){
        return penerbit;
    }
    public String getTahun(){
        return tahun;
    }
    public int getStok(){
        return stok;
    }
    
    public buku(String kd, String judul, String pnb, String thn, int stok){
        setkdBuku(kd);
        setJudul(judul);
        setPenerbit(pnb);
        setTahun(thn);
        setStok(stok);
    }
}
