/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anggota;

/**
 *
 * @author ASUS
 */
public class anggota {
    private String nis;
    private String nama;
    private String kelas;
    private String jurusan;
    private String tingkat;
    
    public void setNis(String nis){
        this.nis = nis;
    }
    public void setNama(String nama){
        this.nama = nama;
    }
    public void setKelas(String kelas){
        this.kelas = kelas;
    }
    public void setJurusan(String jurusan){
        this.jurusan = jurusan;
    }
    public void setTingkat(String tingkat){
        this.tingkat = tingkat;
    }
    public String getNis(){
        return nis;
    }
    public String getNama(){
        return nama;
    }
    public String getKelas(){
        return kelas;
    }
    public String getJurusan(){
        return jurusan;
    }
    public String getTingkat(){
        return tingkat;
    }
    
    public anggota(String nis, String nama, String kelas, String jurusan, String tingkat){
        setNis(nis);
        setNama(nama);
        setKelas(kelas);
        setJurusan(jurusan);
        setTingkat(tingkat);
    }
}
