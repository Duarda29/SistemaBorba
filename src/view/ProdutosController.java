/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.MebProdutos;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author maria
 */
public class ProdutosController extends AbstractTableModel {
    
     private List lista;

    public void setList(List lista) {
        this.lista = lista;
        this.fireTableDataChanged();
    }
    
    public MebProdutos getBean(int row) {
        return (MebProdutos) lista.get(row);
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
        
    MebProdutos mebProdutos = (MebProdutos) lista.get(row);
        if (column == 0) {
           return mebProdutos.getIdMebProdutos();
        } 
        if (column == 1) {
           return mebProdutos.getMebNomeProduto();
        } 
        if (column == 2) {
           return mebProdutos.getMebQuantidade();
        } 
        if (column == 3) {
           return mebProdutos.getMebComplemento();
        } 
        return null;     
    
   }
    
     @Override
     public String getColumnName(int column) {
        if (column == 0) {
            return "Id";
        }
        if (column == 1) {
            return "Nome";
        }
        if (column == 2) {
            return "Quantidade";
        }
        if (column == 3) {
            return "Complemento";
        }
        return "";
    }
    
}
