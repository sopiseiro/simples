/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.jonatas.projetoSimplesNacional;

import br.com.jonatas.Classes.CalcularDVCNPJ;
import br.com.jonatas.Classes.Datas;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.HashMap;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author issqn
 */
public class FrameEventoSimei extends javax.swing.JDialog {

    /**
     * Creates new form FrameEventoSimples
     */
    
    public List dados;
    public JFileChooser j;
    
    public FrameEventoSimei(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        for (int i=8;i<14;i++){
            tabela.getColumnModel().getColumn(i).setMinWidth(0);
            tabela.getColumnModel().getColumn(i).setMaxWidth(0);
        }

        tabela.getColumnModel().getColumn(5).setMinWidth(0);
        tabela.getColumnModel().getColumn(5).setMaxWidth(0);
        tabela.getColumnModel().getColumn(6).setMinWidth(0);
        tabela.getColumnModel().getColumn(6).setMaxWidth(0);
    }

     public void setTable(){
        String natureza[] = {"Medida Judicial","Ato Administrativo","Opção do Contribuinte"};
        DefaultTableModel model = (DefaultTableModel)tabela.getModel();
        for (int i=0;i<dados.size();i++){
            String aux = dados.get(i).toString();
            CalcularDVCNPJ c = new CalcularDVCNPJ(aux.substring(0,8));
            Datas data = new Datas();
            
            //System.out.println(c.getCNPJCompleto());
            model.addRow(new Object[]{
                c.getCNPJCompleto(),
                natureza[ Integer.parseInt(aux.substring(8  , 9))-1 ],
                aux.substring(9, 12),
                data.getInvertData(aux.substring(12, 20)),
                data.getInvertData(aux.substring(20, 28)),
                aux.substring(28   , 78),
                aux.substring(78, 103),
                aux.substring(103, 353),//observacoes do usuario
                aux.substring(353, 360),
                aux.substring(360, 362),
                aux.substring(362, 366),
                data.getInvertData(aux.substring(366, 374)),
                data.getHoras(aux.substring(374, 380)),
                aux.substring(380, 389)
                //data.getDataZero()==true?"Optante":"Desenquadrado"
            });
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

        nomeArquivo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        nomeArquivo.setEditable(false);
        nomeArquivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeArquivoActionPerformed(evt);
            }
        });

        jLabel1.setText("Arquivo:");

        tabela.setAutoCreateRowSorter(true);
        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CNPJ", "Natureza", "Cód Evento", "Data Fato Mot.", "Data efeito", "Nº Processo Judicial", "Nº Processo Adm", "Observações", "Código UA", "Código UF", "Código Municipio", "Data Ocorrência", "Hora Ocorrência", "Nº Opção"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabela);

        jButton1.setText("Imprimir ");
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
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nomeArquivo, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nomeArquivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeArquivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomeArquivoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            
            
            DefaultTableModel model = (DefaultTableModel)tabela.getModel();
            /*DefaultTableModel model2 =(DefaultTableModel)tabela.getModel();
            model2.setNumRows(0);
            System.out.println(tabela.getRowCount());
            for (int i=0;i<tabela.getRowCount();i++){
                model2.addRow(new Object[]{
                    tabela.getValueAt(i, 0),
                    tabela.getValueAt(i, 1),
                    tabela.getValueAt(i, 2),
                    tabela.getValueAt(i, 3),
                    tabela.getValueAt(i, 4),
                    tabela.getValueAt(i, 5),
                    tabela.getValueAt(i, 6),
                    tabela.getValueAt(i, 7),
                    tabela.getValueAt(i, 8),
                    tabela.getValueAt(i, 9),
                    tabela.getValueAt(i, 10),
                    tabela.getValueAt(i, 11),
                    tabela.getValueAt(i, 12),
                    tabela.getValueAt(i, 13)
                });
                
            }*/
            
            
            JRTableModelDataSource datasource = new JRTableModelDataSource(model);
            //String report = "";
            
            Toolkit toolkit = Toolkit.getDefaultToolkit();    
            Dimension screenSize = toolkit.getScreenSize(); 
            
            
            JDialog viewer = new JDialog(new javax.swing.JFrame(),"Impressão de Relatório", true);   
            viewer.setSize(screenSize.width, screenSize.height);  
            viewer.setLocationRelativeTo(null);
           
            HashMap<String, Object> p = new HashMap<String, Object>();
            p.put("arquivo", nomeArquivo.getText());
            //exibe relatorio
            JasperPrint jp = JasperFillManager.fillReport("relatorios//EventosSimples.jasper", p, datasource);
            JasperViewer jrv = new JasperViewer(jp, false);
            viewer.getContentPane().add(jrv.getContentPane());   
            viewer.setVisible(true); 
                    
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(FrameEventoSimei.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameEventoSimei.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameEventoSimei.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameEventoSimei.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrameEventoSimei dialog = new FrameEventoSimei(new javax.swing.JFrame(), true);
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
