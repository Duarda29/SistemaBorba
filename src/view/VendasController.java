
package view;

import bean.MebVendas;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author maria
 */
public class VendasController extends AbstractTableModel{ // esse controla o carinha do usuarioPesquisar
    
    //Tem esses três métodos porque é um dos poucos requerimentos para criar esse método abstrato
    
    List lista;
    
    public void setList(List lista){
    
       this.lista = lista; //colocar o this porque esta se referindo a lista da classe
       this.fireTableDataChanged();
        
    }
    
    public MebVendas getBean(int row){ //pegar a linha do bean
    return (MebVendas) lista.get(row);
    }
    

    @Override
    public int getRowCount() {//quantidade de linhas
        //decidir quantas linhas vai ter
    return lista.size(); //vai mostrar apenas a quantidade de registros que tiver no banco de dados
    }

    @Override
    public int getColumnCount() {//quantidade de colunas
    return 4; //decidir quantas colunas vai ter
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {//quantidade Valor
        
     MebVendas mebVendas = (MebVendas) lista.get(rowIndex); //vai pegar a linha se quiser algo específico, colocar o numero da linha do bd  
        
if ( columnIndex == 0) {
         return mebVendas.getIdMebVendas();   
        }

if ( columnIndex == 1) {
         return mebVendas.getMebClientes();   
        }

if ( columnIndex == 2) {
         return mebVendas.getMebUsuarios();   
        }

if ( columnIndex == 3) {
         return mebVendas.getMebData();   
        }

if ( columnIndex == 4) {
         return mebVendas.getMebTotal();   
        }


return "";
            }
    
  
    
    @Override
    public String getColumnName(int column){
        if ( column == 0) {
         return "id";   
        }
        
        if ( column == 1) {
         return "Clientes";   
        }
        
        if ( column == 2) {
         return "Usuarios";   
        }
        
        if ( column == 3) {
         return "Data";   
        }
        
        if ( column == 4) {
         return "Total";   
        }
      
        
        return "";
    }
}
