/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.jonatas.projetoSimplesNacional;

import br.com.jonatas.Classes.leituraTxt;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author issqn
 */
public class FramePrincipal extends javax.swing.JFrame {

    /**
     * Creates new form framePrincipal
     */

    public FramePrincipal() {
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

        jMenu4 = new javax.swing.JMenu();
        jToolBar1 = new javax.swing.JToolBar();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();

        jMenu4.setText("jMenu4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jToolBar1.setRollover(true);

        jLabel1.setText("Desenvolvido por Jônatas Cardoso - Fiscal de Tributos");
        jToolBar1.add(jLabel1);

        jMenu1.setText("Arquivo");

        jMenuItem5.setText("Sair");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Editar");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Importar");

        jMenuItem1.setText("Eventos do Simples");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuItem2.setText("Eventos do SIMEI");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenuItem3.setText("Periodos do Simples");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);

        jMenuItem4.setText("Periodos do Simei");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem4);

        jMenuItem6.setText("PGDAS");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem6);

        jMenuItem9.setText("Dados Fiscais - Contribuinte");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem9);

        jMenuItem10.setText("Base Cadastro Municipal");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem10);

        jMenuBar1.add(jMenu3);

        jMenu6.setText("Relatórios");

        jMenuItem8.setText("Arquivo PGDAS");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem8);

        jMenuBar1.add(jMenu6);

        jMenu5.setText("Ferramentas");

        jMenuItem7.setText("Separar DASDUNICO");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem7);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 254, Short.MAX_VALUE)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        File[] arquivos  = null;
        JFileChooser fc = new JFileChooser();
        fc.setDialogTitle("Escolha o arquivo DASDUNICO");
        fc.setDialogType(JFileChooser.OPEN_DIALOG);
        fc.setApproveButtonText("Selecionar");
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fc.setMultiSelectionEnabled(false);
        int resultado = fc.showOpenDialog(fc);
        if (resultado == JFileChooser.CANCEL_OPTION){
            return;
        }
        //arquivos = fc.getSelectedFiles();
        System.out.println(fc.getSelectedFile());
        leituraTxt txt = new leituraTxt(fc.getSelectedFile().toString());
        try {
            txt.leituraTxt();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FramePrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        txt.imprimir();
        
        /*try{
            FramePeriodoSimei j = new FramePeriodoSimei(this, rootPaneCheckingEnabled);
            j.setDadosVetor(txt.leituraTxt(), fc);
            j.setTable();
            j.print();
            j.setVisible(true);
            j.setTitle("Importação de arquivo PERMEI");
            j.setLocationRelativeTo(null);
            //txt.leituraTxt();
        }catch(Exception e){
            e.printStackTrace();
        }*/
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
            FrameRelatorioPGDAS j = new FrameRelatorioPGDAS(this, rootPaneCheckingEnabled);
            //j.setDadosVetor(txt.leituraTxt(), fc);
            //j.setTable();
            //j.print();
            j.setVisible(true);
            j.setTitle("Relatórios Importação PGDAS");
            j.setLocationRelativeTo(null);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        extrairPDF j = new extrairPDF(this, rootPaneCheckingEnabled);
        //j.setDadosVetor(txt.leituraTxt(), fc);
        //j.setTable();
        //j.print();
        j.setVisible(true);
        j.setTitle("Importação de arquivo PERMEI");
        j.setLocationRelativeTo(null);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        File[] arquivos  = null;
        JFileChooser fc = new JFileChooser();
        fc.setDialogTitle("Escolha o arquivo Periodo do SIMEI");
        fc.setDialogType(JFileChooser.OPEN_DIALOG);
        fc.setApproveButtonText("Selecionar");
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fc.setMultiSelectionEnabled(false);
        int resultado = fc.showOpenDialog(fc);
        if (resultado == JFileChooser.CANCEL_OPTION){
            return;
        }
        //arquivos = fc.getSelectedFiles();
        System.out.println(fc.getSelectedFile());
        leituraTxt txt = new leituraTxt(fc.getSelectedFile().toString());
        try{
            FramePeriodoSimei j = new FramePeriodoSimei(this, rootPaneCheckingEnabled);
            j.setDadosVetor(txt.leituraTxt(), fc);
            j.setTable();
            j.print();
            j.setVisible(true);
            j.setTitle("Importação de arquivo PERMEI");
            j.setLocationRelativeTo(null);
            //txt.leituraTxt();
        }catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        File[] arquivos  = null;
        JFileChooser fc = new JFileChooser();
        fc.setDialogTitle("Escolha o arquivo Eventos do Periodo Simples");
        fc.setDialogType(JFileChooser.OPEN_DIALOG);
        fc.setApproveButtonText("Selecionar");
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fc.setMultiSelectionEnabled(false);
        int resultado = fc.showOpenDialog(fc);
        if (resultado == JFileChooser.CANCEL_OPTION){
            return;
        }
        //arquivos = fc.getSelectedFiles();
        System.out.println(fc.getSelectedFile());
        leituraTxt txt = new leituraTxt(fc.getSelectedFile().toString());
        try{
            FramePeriodoSimples j = new FramePeriodoSimples(this, rootPaneCheckingEnabled);
            j.setDadosVetor(txt.leituraTxt(), fc);
            j.setTable();
            j.print();
            j.setVisible(true);
            j.setTitle("Importação de arquivo Periodo do Simples Nacional");
            j.setLocationRelativeTo(null);
            //txt.leituraTxt();
        }catch(Exception e){
            e.printStackTrace();
        }
        /*for(File f : arquivos){
            System.out.println("NOME: " + f.getName());
        }*/
        //return arquivos;

    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        File[] arquivos  = null;
        JFileChooser fc = new JFileChooser();
        fc.setDialogTitle("Escolha o arquivo Eventos SIMEI");
        fc.setDialogType(JFileChooser.OPEN_DIALOG);
        fc.setApproveButtonText("Selecionar");
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fc.setMultiSelectionEnabled(false);
        int resultado = fc.showOpenDialog(fc);
        if (resultado == JFileChooser.CANCEL_OPTION){
            return;
        }
        //arquivos = fc.getSelectedFiles();
        System.out.println(fc.getSelectedFile());
        leituraTxt txt = new leituraTxt(fc.getSelectedFile().toString());
        try{
            FrameEventoSimei j = new FrameEventoSimei(this, rootPaneCheckingEnabled);
            j.setDadosVetor(txt.leituraTxt(), fc);
            j.setTable();
            j.print();
            j.setVisible(true);
            j.setTitle("Importação de arquivo EVEMEI");
            j.setLocationRelativeTo(null);
            //txt.leituraTxt();
        }catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        File[] arquivos  = null;
        JFileChooser fc = new JFileChooser();
        fc.setDialogTitle("Escolha o arquivo Eventos Simples");
        fc.setDialogType(JFileChooser.OPEN_DIALOG);
        fc.setApproveButtonText("Selecionar");
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fc.setMultiSelectionEnabled(false);
        int resultado = fc.showOpenDialog(fc);
        if (resultado == JFileChooser.CANCEL_OPTION){
            return;
        }
        //arquivos = fc.getSelectedFiles();
        System.out.println(fc.getSelectedFile());
        leituraTxt txt = new leituraTxt(fc.getSelectedFile().toString());
        try{
            FrameEventoSimples j = new FrameEventoSimples(this, rootPaneCheckingEnabled);
            j.setDadosVetor(txt.leituraTxt(), fc);
            j.setTable();
            j.print();
            j.setVisible(true);
            j.setTitle("Importação de arquivo Eventos do Simples Nacional");
            j.setLocationRelativeTo(null);
            //txt.leituraTxt();
        }catch(Exception e){
            e.printStackTrace();
        }
        /*for(File f : arquivos){
            System.out.println("NOME: " + f.getName());
        }*/
        //return arquivos;
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        FrameDadosContribuinte j = new FrameDadosContribuinte(this, rootPaneCheckingEnabled);
        j.setVisible(true);
        j.setTitle("Importação de arquivo Dados Contribuinte");
        j.setLocationRelativeTo(null);
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        FrameContribuintesPrefeitura j = new FrameContribuintesPrefeitura(this, rootPaneCheckingEnabled);
        j.setVisible(true);
        j.setTitle("Importação de CNPJ da base Municipal");
        j.setLocationRelativeTo(null);
    }//GEN-LAST:event_jMenuItem10ActionPerformed

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
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FramePrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
