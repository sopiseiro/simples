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
    String operacao = "";
    float fixo, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c22, c23, c24;
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
        String codMunicipio = "8979";
        
        
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
            JFileChooser file = new JFileChooser("/media/ISSQN/PGDAS/10-2014");
            // Abre a caixa para escolher a imagem
            file.showOpenDialog(null);
            File selFile = file.getSelectedFile();
            
            f.open("SELECT * FROM arqpgdas WHERE nome = '"+selFile.getName()+"'");
            if (f.next()){
               JOptionPane.showMessageDialog(this, "Arquivo já importado.");
               b.disconnect();
               return;
            }

            leituraTxt txt = new leituraTxt(selFile);
            v = txt.leituraTxtPGDAS();
            //txt.imprimir();
            //boolean captura = false;
            boolean ente = false;
            boolean gravar = false;
            
            for (int i=0; i<v.size();i++){
                if (v.get(i).substring(0,5).equals("00000")){
                    cnpj  = v.get(i).split("\\|")[6];
                    razao = v.get(i).split("\\|")[7];
                    pa    = v.get(i).split("\\|")[11];
                    operacao = v.get(i).split("\\|")[15];
                }
                
                if (v.get(i).substring(0,5).equals("02000"))
                    valoracumulado = v.get(i).split("\\|")[1];
                
                if (v.get(i).substring(0,5).equals("03000") ){
                        if (v.get(i).split("\\|")[3].equals(codMunicipio)){
                            ente = true;
                            cnpj = v.get(i).split("\\|")[1];
                        }else
                            ente = false;
                }
                
                
                
                if (v.get(i).substring(0,5).equals("03100") && ente){
                    switch (v.get(i).split("\\|")[1]){
                        case "08":
                            c8 = Float.parseFloat(v.get(i).split("\\|")[2].replace(",", "."));
                            gravar = true;
                            break;
                        case "09":
                            c9 = Float.parseFloat(v.get(i).split("\\|")[2].replace(",", "."));
                            gravar = true;
                            break;
                        case "10":
                            c10 = Float.parseFloat(v.get(i).split("\\|")[2].replace(",", "."));
                            gravar = true;
                            break;
                        case "11":
                            c11 = Float.parseFloat(v.get(i).split("\\|")[2].replace(",", "."));
                            gravar = true;
                            break;
                        case "12":
                            c12 = Float.parseFloat(v.get(i).split("\\|")[2].replace(",", "."));
                            gravar = true;
                            break;
                        case "13":
                            c13 = Float.parseFloat(v.get(i).split("\\|")[2].replace(",", "."));
                            gravar = true;
                            break;
                        case "14":
                            c14 = Float.parseFloat(v.get(i).split("\\|")[2].replace(",", "."));
                            gravar = true;
                            break;
                        case "15":
                            c15 = Float.parseFloat(v.get(i).split("\\|")[2].replace(",", "."));
                            gravar = true;
                            break;
                        case "16":
                            c16 = Float.parseFloat(v.get(i).split("\\|")[2].replace(",", "."));
                            gravar = true;
                            break; 
                        case "17":
                            c17 = Float.parseFloat(v.get(i).split("\\|")[2].replace(",", "."));
                            gravar = true;
                            break;  
                        case "22":
                            c22 = Float.parseFloat(v.get(i).split("\\|")[2].replace(",", "."));
                            gravar = true;
                            break;
                        case "23":
                            c23 = Float.parseFloat(v.get(i).split("\\|")[2].replace(",", "."));
                            gravar = true;
                            break;
                        case "24":
                            c24 = Float.parseFloat(v.get(i).split("\\|")[2].replace(",", "."));
                            gravar = true;
                            break;
                         
                            
                          
                        
                    }
                    /*if ( filtroISS.contains( v.get(i).split("\\|")[1] ) ){
                        semret = v.get(i).split("\\|")[2];
                    }
                    if (filtroISSRetido.contains( v.get(i).split("\\|")[1]) ){
                        retido = v.get(i).split("\\|")[2];
                    }*/
                    
                }
                //System.out.println("aliquota"+aliquota+" - valor c11"+c11+ " - ente"+ente+ "- gravar "+gravar );
                if (v.get(i).substring(0,5).equals("03110") && aliquota.equals("")){
                     aliquota = v.get(i).split("\\|")[26];
                }
               
                
                if (v.get(i).substring(0,5).equals("99999")){
                    if (gravar){
                        float aux;
                       
                        f.execute("INSERT INTO pgdas VALUES (null "
                                + ",'"+pa+"'"
                                + ",'"+ razao.replace("'", "\'") +"'"
                                + ",'"+ cnpj +"' "
                                + ",'"+ valoracumulado.replace(",", ".") +"' "
                                + ",'"+ (c8+c9+c10+c12+c13+c15+c16+c23+c24) +"' "//valor normal
                                + ",'"+ (c11+c14+c17+c22) +"' "//valor retido
                                + ",'"+ 0 +"' "
                                + ",'"+ getAliquota(Float.parseFloat(valoracumulado.replace(",", "."))) +"' "
                                + ",'"+ selFile.getName().split("-")[4]+"' "
                                + ",'"+ operacao +"' "
                                + ",'0' "
                                 + ")");
                        System.out.println(pa +" - "+cnpj+" - "+ razao +" - "+ valoracumulado+" - "+semret+" - "+retido+" - "+aliquota);
                    }
                    fixo =c8= c9= c10= c11= c12= c13= c14= c15= c16= c17= c22= c23= c24=0;
                    ente =gravar= false;
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
        
        JOptionPane.showMessageDialog(this, "ok importa o próximo");
        

    }//GEN-LAST:event_jButton1ActionPerformed

    public String getAliquota(float totalPA){
                    
        if (totalPA >= 180000.01 && totalPA <= 360000.00){
            return "2.79";
        }
        if (totalPA >= 360000.01 && totalPA <= 540000.00){
            return "3.50";
        }
        if (totalPA >= 540000.01 && totalPA <= 720000.00){
            return "3.84";
        }
        if (totalPA >= 720000.01 && totalPA <= 900000.00){
            return "3.87";
        }
        if (totalPA >= 900000.01 && totalPA <= 1080000.00){
            return "4.23";
        }
        if (totalPA >= 1080000.01 && totalPA <= 1260000.00){
            return "4.26";
        }
        if (totalPA >= 1260000.01 && totalPA <= 1440000.00){
            return "4.31";
        }
        if (totalPA >= 1440000.01 && totalPA <= 1620000.00){
            return "4.61";
        }
        if (totalPA >= 1620000.01 && totalPA <= 1800000.00){
            return "4.65";
        }
        if (totalPA > 1800001.00){
            return "5.00";
        }
        
        return "2.00";
    }
    
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
