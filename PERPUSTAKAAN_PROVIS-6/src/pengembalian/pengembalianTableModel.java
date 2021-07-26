/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pengembalian;

import pengembalian.*;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author rifki
 */

public class pengembalianTableModel extends AbstractTableModel {

    private ArrayList<pengembalian> data;
    private String[] namaField = {"ID Pinjam","NIS","Nama Siswa","Judul",
                                  "Tgl Pinjam","Tgl Kembali","Denda","Pegawai"};
    
    public void setData(ArrayList<pengembalian> dt){
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
        pengembalian pj = data.get(baris);
        switch(kolom){
            case 0 : return pj.getNoPinjam();
            case 1 : return pj.getNIS();
            case 2 : return pj.getNamaSiswa();
            case 3 : return pj.getJudulBuku();
            case 4 : return pj.getTglPinjam();
            case 5 : return pj.getTglKembali();
            case 6 : return pj.getDenda();
            case 7 : return pj.getNamaPegawai();
            default : return null;
        }
        
    }
    @Override
    public String getColumnName(int column){
        return namaField[column];
    }
    

    
}
