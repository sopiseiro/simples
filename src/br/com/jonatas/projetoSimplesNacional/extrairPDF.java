/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.jonatas.projetoSimplesNacional;

import br.com.jonatas.Base.bd;
import br.com.jonatas.Classes.leituraTxt;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import utilitarios.mySql;

/**
 *
 * @author issqn
 */
public class extrairPDF extends javax.swing.JDialog {

    private PdfReader reader = null;
    String cnpj, pa, razao,valoracumulado; 
    String retido = "";
    String semret = "";
    String aliquota = "";
    /**
     * Creates new form extrairPDF
     */
    public extrairPDF(java.awt.Frame parent, boolean modal) {
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
                .addGap(163, 163, 163)
                .addComponent(jButton1)
                .addContainerGap(165, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(jButton1)
                .addContainerGap(151, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        List<String> v = new ArrayList<String>();
        
        
        List<String> filtroISS = new ArrayList<String>();
        filtroISS.add("10");
        filtroISS.add("13");
        filtroISS.add("16");
        
        List<String> filtroISSRetido = new ArrayList<String>();
        filtroISSRetido.add("11");
        filtroISSRetido.add("14");
        filtroISSRetido.add("17");

        bd b = new bd();
        b.connect();
        mySql f = new mySql(b.conn);

        try {
            // Criação do FileChooser
            JFileChooser file = new JFileChooser();
            // Abre a caixa para escolher a imagem
            file.showOpenDialog(null);
            File selFile = file.getSelectedFile();
            
            f.open("SELECT * FROM arqpgdas WHERE nome = '"+selFile.getName()+"'");
            if (f.next()){
               JOptionPane.showMessageDialog(this, "Arquivo já importado.");
                return;
            }

            leituraTxt txt = new leituraTxt(selFile);
            v = txt.leituraTxtPGDAS();
            boolean captura = false;
            boolean ente = false;
            
            for (int i=0; i<v.size()-1;i++){
                if (v.get(i).substring(0,5).equals("00000")){
                    cnpj  = v.get(i).split("\\|")[6];
                    razao = v.get(i).split("\\|")[7];
                    pa    = v.get(i).split("\\|")[11];
                }
                
                if (v.get(i).substring(0,5).equals("02000"))
                    valoracumulado = v.get(i).split("\\|")[1];
                
                if (v.get(i).substring(0,5).equals("03000"))
                   ente = true;
                
                if (v.get(i).substring(0,5).equals("03100") && ente){
                    if ( filtroISS.contains( v.get(i).split("\\|")[1] ) ){
                        semret = v.get(i).split("\\|")[2];
                    }
                    if (filtroISSRetido.contains( v.get(i).split("\\|")[1]) ){
                        retido = v.get(i).split("\\|")[2];
                    }
                }
                
                if (v.get(i).substring(0,5).equals("03110") && aliquota.equals("")){
                     aliquota = v.get(i).split("\\|")[26];
                }
               
                
                if (v.get(i).substring(0,5).equals("99999")){
                    if (!semret.equals("") && !retido.equals("")){
                        //f.execute("INSERT INTO arq-pdgas");
                        f.execute("INSERT INTO PGDAS VALUES (null "
                                + ",'"+pa+"'"
                                + ",'"+ razao +"'"
                                + ",'"+ cnpj +"' "
                                + ",'"+ valoracumulado.replace(",", ".") +"' "
                                + ",'"+ semret.replace(",", ".") +"' "
                                + ",'"+ retido.replace(",", ".") +"' "
                                + ",'"+ 0 +"' "
                                + ",'"+ aliquota.replace(",", ".") +"' "
                                + ",'"+ selFile.getName().split("-")[4]+"' "
                                 + ")");
                        System.out.println(pa +" - "+cnpj+" - "+ razao +" - "+ valoracumulado+" - "+semret+" - "+retido+" - "+aliquota);
                    }
                    ente = false;
                    semret = "";
                    retido = "";
                    aliquota = "";
                }
                
            }
            
            System.out.println(selFile.getName());
            f.execute("INSERT INTO arqpgdas VALUES (null, '" + selFile.getName() +"', 0 , 0, 0 )");
            
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
                //JOptionPane.showMessageDialog(null, "ERRO: " + e1);
            } finally {
                if (reader != null)
                reader.close();
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
            java.util.logging.Logger.getLogger(extrairPDF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(extrairPDF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(extrairPDF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(extrairPDF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                extrairPDF dialog = new extrairPDF(new javax.swing.JFrame(), true);
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
