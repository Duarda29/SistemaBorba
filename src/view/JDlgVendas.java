/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.MebClientes;
import bean.MebProdutos;
import bean.MebVendas;
import bean.MebVendasProduto;
import bean.MebUsuarios;
import dao.ClientesDAO;
import dao.ProdutosDAO;
import dao.UsuariosDAO;
import dao.VendasDAO;
import dao.VendasProdutoDAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import tools.Util;
import view.JDlgUsuarios;
import view.JDlgVendasPesquisa;
import view.JDlgVendasProduto;
import view.ProdutosController;
import view.VendasProdutoController;

/**
 *
 * @author maria
 */
public class JDlgVendas extends javax.swing.JDialog {

     MaskFormatter mascaraData;
     private boolean incluindo;
     
     
    public VendasDAO vendasDAO;
    public MebVendas mebVendas;
    public JDlgVendasProduto jDlgVendasProduto;
    public ProdutosDAO produtosDAO;
    public MebProdutos mebProdutos;
    public ProdutosController produtosController;
    private VendasProdutoController vendasProdutoController = new VendasProdutoController(); //deixou como global

    /**
     * Creates new form JDlgPedidos
     */
    public JDlgVendas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
          setTitle("Vendas");
        setLocationRelativeTo(null);

       vendasDAO = new VendasDAO();

        Util.habilitar(false, jTxtNumPedidos, jFmtData, jTxtTotal, jCboClientes, jCboVendedor, jBtn_Meb_Cancelar, jBtn_Meb_Confirmar);
        Util.habilitar(true, jBtn_Meb_Incluir, jBtn_Meb_Alterar, jBtn_Meb_Excluir, jBtn_Meb_Pesquisar);
        
        
        JDlgVendasProduto jDlgVendasProduto= new JDlgVendasProduto(null, true);
        produtosDAO = new ProdutosDAO();
        List lista = produtosDAO.listAll();
        produtosController = new ProdutosController();
        produtosController.setList(lista);
        jTable1.setModel(produtosController);
        
        ClientesDAO clientesDAO = new ClientesDAO();
        List listaCli = clientesDAO.listAll();
        for (int i = 0; i < listaCli.size(); i++) {
        //    clientesDAO.addItem((MebClientes) listaCli.get(i));
        }

        UsuariosDAO usuariosDAO = new UsuariosDAO();
        List listaFu = usuariosDAO.listAll();
        for (int i = 0; i < listaFu.size(); i++) {
          //  usuariosDAO.addItem((MebUsuarios) listaFu.get(i));
        }
        
       

        try {
            mascaraData = new MaskFormatter("##/##/####");
        } catch (ParseException ex) {
            Logger.getLogger(JDlgUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        jFmtData.setFormatterFactory(new DefaultFormatterFactory(mascaraData));
    }
    
    public MebVendas beanView(MebVendas mebVendas){
        jTxtNumPedidos.setText(String.valueOf(mebVendas.getIdMebVendas()));
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        jFmtData.setText(formato.format(mebVendas.getMebData()));
         MebClientes idClientes = mebVendas.getMebClientes();
        ClientesDAO clientesDAO = new ClientesDAO();
        jCboClientes.setSelectedItem(mebVendas.getMebClientes());
        jCboVendedor.setSelectedItem(mebVendas.getMebUsuarios());
        jTxtTotal.setText(String.valueOf(mebVendas.getMebTotal()));
       
       
               return mebVendas;
    }
    
    public MebVendas viewBean() {
        MebVendas mebVendas = new MebVendas();
        mebVendas.setIdMebVendas(Util.strInt(jTxtNumPedidos.getText()));
        mebVendas.setMebData(Util.strDate(jFmtData.getText()));
        mebVendas.setMebClientes((MebClientes) jCboClientes.getSelectedItem());
        mebVendas.setMebUsuarios((MebUsuarios)jCboVendedor.getSelectedItem());
        mebVendas.setMebTotal(Util.strDouble(jTxtTotal.getText()));
        
             return mebVendas;
  
    }
   

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTxtNumPedidos = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jCboClientes = new javax.swing.JComboBox<MebClientes>();
        jLabel4 = new javax.swing.JLabel();
        jCboVendedor = new javax.swing.JComboBox<MebUsuarios
        >();
        jLabel5 = new javax.swing.JLabel();
        jTxtTotal = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jBtn_Meb_Incluir = new javax.swing.JButton();
        jBtn_Meb_Alterar = new javax.swing.JButton();
        jBtn_Meb_Excluir = new javax.swing.JButton();
        jBtn_Meb_Confirmar = new javax.swing.JButton();
        jBtn_Meb_Cancelar = new javax.swing.JButton();
        jBtn_Meb_Pesquisar = new javax.swing.JButton();
        jBtnIncluirProd = new javax.swing.JButton();
        jBtnAlterarProd = new javax.swing.JButton();
        jBtnExcluirProd = new javax.swing.JButton();
        jFmtData = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Num. Pedido");

        jLabel2.setText("Data");

        jLabel3.setText("Clientes");

        jLabel4.setText("Usuarios");

        jCboVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCboVendedorActionPerformed(evt);
            }
        });

        jLabel5.setText("Total");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jBtn_Meb_Incluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-divisa-circulada-acima-24.png"))); // NOI18N
        jBtn_Meb_Incluir.setText("Incluir");
        jBtn_Meb_Incluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtn_Meb_IncluirActionPerformed(evt);
            }
        });
        jPanel1.add(jBtn_Meb_Incluir);

        jBtn_Meb_Alterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-alterar-25.png"))); // NOI18N
        jBtn_Meb_Alterar.setText("Alterar");
        jBtn_Meb_Alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtn_Meb_AlterarActionPerformed(evt);
            }
        });
        jPanel1.add(jBtn_Meb_Alterar);

        jBtn_Meb_Excluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-excluir-24.png"))); // NOI18N
        jBtn_Meb_Excluir.setText("Excluir");
        jBtn_Meb_Excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtn_Meb_ExcluirActionPerformed(evt);
            }
        });
        jPanel1.add(jBtn_Meb_Excluir);

        jBtn_Meb_Confirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-ok-24.png"))); // NOI18N
        jBtn_Meb_Confirmar.setText("  Confirmar");
        jBtn_Meb_Confirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtn_Meb_ConfirmarActionPerformed(evt);
            }
        });
        jPanel1.add(jBtn_Meb_Confirmar);

        jBtn_Meb_Cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-cancelar-24.png"))); // NOI18N
        jBtn_Meb_Cancelar.setText("Cancelar");
        jBtn_Meb_Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtn_Meb_CancelarActionPerformed(evt);
            }
        });
        jPanel1.add(jBtn_Meb_Cancelar);

        jBtn_Meb_Pesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-lupa-24.png"))); // NOI18N
        jBtn_Meb_Pesquisar.setText("Pesquisar");
        jBtn_Meb_Pesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtn_Meb_PesquisarActionPerformed(evt);
            }
        });
        jPanel1.add(jBtn_Meb_Pesquisar);

        jBtnIncluirProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ok.png"))); // NOI18N
        jBtnIncluirProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnIncluirProdActionPerformed(evt);
            }
        });

        jBtnAlterarProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/alterar.png"))); // NOI18N
        jBtnAlterarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAlterarProdActionPerformed(evt);
            }
        });

        jBtnExcluirProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/exit.png"))); // NOI18N
        jBtnExcluirProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnExcluirProdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTxtNumPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jFmtData, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCboClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jCboVendedor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTxtTotal)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 653, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jBtnAlterarProd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBtnIncluirProd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBtnExcluirProd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtNumPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCboClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCboVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFmtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jBtnIncluirProd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBtnAlterarProd, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBtnExcluirProd, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtn_Meb_IncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_Meb_IncluirActionPerformed
        // TODO add your handling code here:
        
        Util.habilitar(true, jTxtNumPedidos, jFmtData, jTxtTotal, jCboClientes, jCboVendedor, jBtn_Meb_Cancelar, jBtn_Meb_Confirmar);
        Util.habilitar(false, jBtn_Meb_Incluir, jBtn_Meb_Alterar, jBtn_Meb_Pesquisar, jBtn_Meb_Excluir);
        Util.limparCampos(jTxtNumPedidos, jFmtData, jTxtTotal, jCboClientes, jCboVendedor);

        jTxtNumPedidos.grabFocus();
        incluindo = true;
        mebVendas = new MebVendas();
        
    }//GEN-LAST:event_jBtn_Meb_IncluirActionPerformed

    private void jBtn_Meb_AlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_Meb_AlterarActionPerformed
        // TODO add your handling code here:
        Util.habilitar(true, jTxtNumPedidos, jFmtData, jTxtTotal, jCboClientes, jCboVendedor, jBtn_Meb_Cancelar, jBtn_Meb_Confirmar);
        Util.habilitar(false, jBtn_Meb_Incluir, jBtn_Meb_Alterar, jBtn_Meb_Excluir, jBtn_Meb_Pesquisar);
        //indica que está no meio de uma alteração
        incluindo = false;
        
    }//GEN-LAST:event_jBtn_Meb_AlterarActionPerformed

    private void jBtn_Meb_ExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_Meb_ExcluirActionPerformed
        // TODO add your handling code here:
       
        int resp =  JOptionPane.showConfirmDialog(null, "Deseja excluir o registro?","Confirmar", JOptionPane.YES_NO_OPTION);// configura qual botão eu quero
        if (resp == JOptionPane.YES_OPTION){// confirma que é a opção sim
                           
        MebVendas mebVendas = viewBean();
        VendasDAO vendasDAO = new VendasDAO();
        vendasDAO.delete(mebVendas); 
        
        }else {
        JOptionPane.showMessageDialog(null, "Exclusão cancelada.","Alerta", 2 );
        
        }
        
        Util.limparCampos(jTxtNumPedidos, jFmtData, jTxtTotal, jCboClientes, jCboVendedor);
    }//GEN-LAST:event_jBtn_Meb_ExcluirActionPerformed

    private void jBtn_Meb_ConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_Meb_ConfirmarActionPerformed
        // TODO add your handling code here:
                  mebVendas = viewBean();
            if (incluindo == true) {
            vendasDAO.insert(mebVendas);

        } else {
            vendasDAO.update(mebVendas);

        }
      
        //pegou o que estava do view passou para o bean, do bean passou para o DAO e do DAO para o banco de dados// apagou os campos e habiliotu e desabilitou
        Util.limparCampos(jTxtNumPedidos, jTxtTotal, jCboClientes, jCboVendedor);
        Util.habilitar(true, jBtn_Meb_Incluir, jBtn_Meb_Alterar, jBtn_Meb_Excluir, jBtn_Meb_Pesquisar);
        Util.habilitar(false, jTxtNumPedidos, jFmtData, jTxtTotal, jCboClientes, jCboVendedor, jBtn_Meb_Cancelar, jBtn_Meb_Confirmar);
                           mebVendas = null;                   

    }//GEN-LAST:event_jBtn_Meb_ConfirmarActionPerformed

    private void jBtn_Meb_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_Meb_CancelarActionPerformed
        // TODO add your handling code here:
             Util.habilitar(true, jBtn_Meb_Incluir, jBtn_Meb_Alterar, jBtn_Meb_Excluir, jBtn_Meb_Pesquisar);
        Util.habilitar(false, jTxtNumPedidos, jFmtData, jTxtTotal, jCboClientes, jCboVendedor, jBtn_Meb_Cancelar, jBtn_Meb_Confirmar);
        Util.limparCampos(jTxtNumPedidos, jFmtData, jTxtTotal, jCboClientes, jCboVendedor);
        Util.mensagem("Operação cancelada");
               mebVendas = null;                   

    }//GEN-LAST:event_jBtn_Meb_CancelarActionPerformed

    private void jBtn_Meb_PesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_Meb_PesquisarActionPerformed
        JDlgVendasPesquisa jDlgVendasPesquisa = new JDlgVendasPesquisa(null, true); 
        jDlgVendasPesquisa.setVisible(true);
    }//GEN-LAST:event_jBtn_Meb_PesquisarActionPerformed

    
 //////////////////////////////////////////////////////////////////////////////////////////   
    
 
    private void jBtnIncluirProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnIncluirProdActionPerformed
        // TODO add your handling code here:
        
        JDlgVendasProduto jDlgVendasProduto = new JDlgVendasProduto(null, true);
        jDlgVendasProduto.setTitle("Inclusão de produtos");
   //     jDlgVendasProduto.setTelaAnterior(this);
        jDlgVendasProduto.setVisible(true);
               
          
                
    }//GEN-LAST:event_jBtnIncluirProdActionPerformed

    private void jBtnAlterarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAlterarProdActionPerformed
        // TODO add your handling code here:
        JDlgVendasProduto jDlgVendasProduto = new JDlgVendasProduto(null, true);
        jDlgVendasProduto.setTitle("Alteração de produtos");
  //      jDlgVendasProduto.setTelaAnterior(this);
        jDlgVendasProduto.setVisible(true);
        
    }//GEN-LAST:event_jBtnAlterarProdActionPerformed

    private void jBtnExcluirProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnExcluirProdActionPerformed
        // TODO add your handling code here:
        int linha = jTable1.getSelectedRow();
        if(linha == -1){
            Util.mensagem("Nenhuma linha selecionada");
        }else{
            if(Util.perguntar("Confrima a exclusão do produto??") == true){
            //    PedidosProdutosControle.removeBean(linha);
            }
        }
    }//GEN-LAST:event_jBtnExcluirProdActionPerformed

    private void jCboVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCboVendedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCboVendedorActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JDlgVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDlgVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDlgVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDlgVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDlgVendas dialog = new JDlgVendas(new javax.swing.JFrame(), true);
        dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAlterarProd;
    private javax.swing.JButton jBtnExcluirProd;
    private javax.swing.JButton jBtnIncluirProd;
    private javax.swing.JButton jBtn_Meb_Alterar;
    private javax.swing.JButton jBtn_Meb_Cancelar;
    private javax.swing.JButton jBtn_Meb_Confirmar;
    private javax.swing.JButton jBtn_Meb_Excluir;
    private javax.swing.JButton jBtn_Meb_Incluir;
    private javax.swing.JButton jBtn_Meb_Pesquisar;
    private javax.swing.JComboBox<MebClientes> jCboClientes;
    private javax.swing.JComboBox<MebUsuarios> jCboVendedor;
    private javax.swing.JFormattedTextField jFmtData;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTxtNumPedidos;
    private javax.swing.JTextField jTxtTotal;
    // End of variables declaration//GEN-END:variables
}
