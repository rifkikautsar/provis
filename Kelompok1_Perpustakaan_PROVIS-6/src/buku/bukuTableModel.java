/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buku;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author rifki
 */

public class bukuTableModel extends AbstractTableModel {

    private ArrayList<buku> data;
    private String[] namaField = {"Kode Buku","Judul",
                                  "Penerbit","Tahun","Stok"};
    
    public void setData(ArrayList<buku> dt){
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
        buku bk = data.get(baris);
        switch(kolom){
            case 0 : return bk.getkdBuku();
            case 1 : return bk.getJudul();
            case 2 : return bk.getPenerbit();
            case 3 : return bk.getTahun();
            case 4 : return bk.getStok();
            default : return null;
        }
        
    }
    @Override
    public String getColumnName(int column){
        return namaField[column];
    }
    

    
}
