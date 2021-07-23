/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peminjaman;

import peminjaman.*;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author rifki
 */

public class peminjamanTableModel extends AbstractTableModel {

    private ArrayList<peminjaman> data;
    private String[] namaField = {"ID Peminjaman","NIS","Nama Siswa",
                                  "Kode Buku","Judul","Tanggal Pinjam","ID Pegawai"};
    
    public void setData(ArrayList<peminjaman> dt){
        this.data = dt;
    }
    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return namaField.length;
    }

    @Override
    public Object getValueAt(int baris, int kolom) {
        peminjaman pj = data.get(baris);
        switch(kolom){
            case 0 : return pj.getNoPinjam();
            case 1 : return pj.getNIS();
            case 2 : return pj.getNamaSiswa();
            case 3 : return pj.getKdBuku();
            case 4 : return pj.getJudulBuku();
            case 5 : return pj.getTglPinjam();
            case 6 : return pj.getNIP();
            default : return null;
        }
        
    }
    @Override
    public String getColumnName(int column){
        return namaField[column];
    }
    

    
}
