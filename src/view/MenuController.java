/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.MebMenu;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author maria
 */
public class MenuController extends AbstractTableModel {

     private List lista;

    public void setList(List lista) {
        this.lista = lista;
        this.fireTableDataChanged();
    }
    
    public MebMenu getBean(int row) {
        return (MebMenu) lista.get(row);
    }
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
}

    @Override
    public Object getValueAt(int row, int column) {
        
      MebMenu mebMenu = (MebMenu) lista.get(row);
        if (column == 0) {
           return mebMenu.getIdMebMenu();
        } 
        if (column == 1) {
           return mebMenu.getMebPizza();
        } 
        if (column == 2) {
           return mebMenu.getMebBorda();
        } 
        if (column == 3) {
           return mebMenu.getMebTamanhos();
        } 
        return null; 
    }
    
     @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "Id";
        }
        if (column == 1) {
            return "Pizza";
        }
        if (column == 2) {
            return "Bordas";
        }
        if (column == 3) {
            return "Tamanhos";
        }
        return "";
    }
    
    
}
