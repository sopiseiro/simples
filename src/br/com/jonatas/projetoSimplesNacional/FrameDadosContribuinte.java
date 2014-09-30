/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.jonatas.projetoSimplesNacional;

import br.com.jonatas.Base.bd;
import br.com.jonatas.Classes.leituraTxt;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import utilitarios.mySql;

/**
 *
 * @author issqn
 */
public class FrameDadosContribuinte extends javax.swing.JDialog {

    /**
     * Creates new form FrameDadosContribuinte
     */
    public FrameDadosContribuinte(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    
     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(152, 152, 152)
                .addComponent(jButton1)
                .addContainerGap(185, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addComponent(jButton1)
                .addContainerGap(144, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        List<String> v = new ArrayList<String>();

        String pa = "201407";//lembrar de add campo para informação
        String aliquota[]={"2.79","3.50","3.84","3.87","4.23","4.26","4.31","4.61","4.65","5.00"};

        
        
        bd b = new bd();
        b.connect();
        mySql f = new mySql(b.conn);

        try {
            // Criação do FileChooser
            JFileChooser file = new JFileChooser("/media/ISSQN/PGDAS/");
            // Abre a caixa para escolher a imagem
            file.showOpenDialog(null);
            File selFile = file.getSelectedFile();
            
            f.open("SELECT * FROM arqdadoscontribuinte WHERE nome = '"+selFile.getName()+"'");
            if (f.next()){
               JOptionPane.showMessageDialog(this, "Arquivo já importado.");
               return;
            }

            leituraTxt txt = new leituraTxt(selFile);
            v = txt.leituraTxt();
            boolean captura = false;
            boolean ente = false;
            
            for (int i=0; i<v.size()-1;i++){
                if (v.get(i).split("\\|")[0].length() >= 13)
                f.execute("INSERT INTO dadoscontribuinte VALUES (null "
                                + ",'"+pa+"'" //pa
                                + ",'"+ v.get(i).split("\\|")[0]+"'"//cnpj
                                + ",'"+ v.get(i).split("\\|")[2] +"' " //valor retido
                                + ",'"+ v.get(i).split("\\|")[1] +"' " //valor sem retencao
          + ",'"+ (v.get(i).split("\\|")[3].equals("null")?"2":aliquota[Integer.parseInt(v.get(i).split("\\|")[3])]) +"' " //aliquota
                                 + ")");
                
                //System.out.println(pa +" - "+cnpj+" - "+ razao +" - "+ valoracumulado+" - "+semret+" - "+retido+" - "+aliquota);
                   
               
                
            }
            
            System.out.println(selFile.getName());
            f.execute("INSERT INTO arqdadoscontribuinte VALUES (null, '" + selFile.getName() +"', 0 )");
            b.disconnect();
            
          // reader = new PdfReader("" + selFile);
            // contador para o numeros de paginas
           /* for (int i = 1; i <= 1; i++) {
            // Extrai o texto do pdf
            //String text = PdfTextExtractor.getTextFromPage(reader, i);

           // System.out.println(text);
            //System.out.println(text);
            }*/

           } catch (IOException e1) {
                e1.printStackTrace();
                b.disconnect();
                //JOptionPane.showMessageDialog(null, "ERRO: " + e1);
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
            java.util.logging.Logger.getLogger(FrameDadosContribuinte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameDadosContribuinte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameDadosContribuinte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameDadosContribuinte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrameDadosContribuinte dialog = new FrameDadosContribuinte(new javax.swing.JFrame(), true);
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
    // End of variables declaration//GEN-END:variables
}
