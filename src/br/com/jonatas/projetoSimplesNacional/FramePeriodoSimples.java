/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.jonatas.projetoSimplesNacional;

import br.com.jonatas.Base.bd;
import br.com.jonatas.Classes.CalcularDVCNPJ;
import br.com.jonatas.Classes.Datas;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JDialog;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import utilitarios.mySql;

/**
 *
 * @author issqn
 */
public class FramePeriodoSimples extends javax.swing.JDialog {

    /**
     * Creates new form frameEventoSimples
     */
    
    public List dados;
    public JFileChooser j;
    public FramePeriodoSimples(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
    }
    
    public void setTable(){
        DefaultTableModel model = (DefaultTableModel)tabela.getModel();
        
        bd b = new bd();
        b.connect();
        mySql f = new mySql(b.conn);
        
        for (int i=0;i<dados.size();i++){
            String aux = dados.get(i).toString();
            CalcularDVCNPJ c = new CalcularDVCNPJ(aux.substring(0,8));
            Datas data = new Datas();
            
            //System.out.println(c.getCNPJCompleto());
            model.addRow(new Object[]{c.getCNPJCompleto(), 
                data.getInvertData(aux.substring(8, 16)),
                data.getInvertData(aux.substring(16, 24)),
                aux.substring(24, 25),
                aux.substring(25, aux.length()),
                    data.getDataZero()==true?"Optante":"Desenquadrado"});
            
            f.execute("INSERT INTO periodoSimples VALUES (null "
                    + ",'" + c.getCNPJCompleto() + "'"
                    + ",'" + aux.substring(8, 16) + "'"
                    + ",'" + aux.substring(16, 24) + "' "
                    + ",'" + aux.substring(24, 25) + "' "
                    + ",'" + aux.substring(25, aux.length()) + "'"
                    + ")");
        }
        
        tabela.setModel(model);
    }
    
    public void setDadosVetor(List dados, JFileChooser f){
        this.dados = dados;
        this.j = j;
        nomeArquivo.setText(f.getSelectedFile().getName());
    }
    
    public void print(){
        for (int i=0;i<dados.size();i++){
            System.out.println(dados.get(i));
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        nomeArquivo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(740, 500));

        jLabel1.setText("Arquivo:");

        nomeArquivo.setEditable(false);
        nomeArquivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeArquivoActionPerformed(evt);
            }
        });

        tabela.setAutoCreateRowSorter(true);
        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CNPJ", "Data início", "Data fim", "ID Cancelamento", "Nº Opção", "Optante Simples"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela.getTableHeader().setResizingAllowed(false);
        tabela.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabela);

        jButton1.setText("Imprimir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Sair");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nomeArquivo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nomeArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nomeArquivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeArquivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomeArquivoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            DefaultTableModel model = (DefaultTableModel)tabela.getModel();
            JRTableModelDataSource datasource = new JRTableModelDataSource(model);
            String report = "";
            
            Toolkit toolkit = Toolkit.getDefaultToolkit();    
            Dimension screenSize = toolkit.getScreenSize(); 
            
            
            JDialog viewer = new JDialog(new javax.swing.JFrame(),"Impressão de Relatório", true);   
            viewer.setSize(screenSize.width, screenSize.height);  
            viewer.setLocationRelativeTo(null);
           
            HashMap<String, Object> p = new HashMap<String, Object>();
            p.put("arquivo", nomeArquivo.getText());
            //exibe relatorio
            JasperPrint jp = JasperFillManager.fillReport("relatorios//peridoSimples.jasper", p, datasource);
            JasperViewer jrv = new JasperViewer(jp, false);
            viewer.getContentPane().add(jrv.getContentPane());   
            viewer.setVisible(true); 
                    
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(FramePeriodoSimples.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FramePeriodoSimples.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FramePeriodoSimples.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FramePeriodoSimples.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FramePeriodoSimples dialog = new FramePeriodoSimples(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nomeArquivo;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
}
