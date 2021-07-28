/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anggota;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author ASUS
 */
public class anggotaTableModel extends AbstractTableModel {

    private ArrayList<anggota> data;
    private String[] namaField = {"ID Anggota","Nama Siswa",
                                  "Kelas","Jurusan","Tingkat"};
    
    public void setData(ArrayList<anggota> dt){
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
        anggota ag = data.get(baris);
        switch(kolom){
            case 0 : return ag.getNis();
            case 1 : return ag.getNama();
            case 2 : return ag.getKelas();
            case 3 : return ag.getJurusan();
            case 4 : return ag.getTingkat();
            default : return null;
        }
    }
    @Override
    public String getColumnName(int column){
        return namaField[column];
    }
}
