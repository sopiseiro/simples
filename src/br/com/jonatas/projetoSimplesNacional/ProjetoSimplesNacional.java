/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.jonatas.projetoSimplesNacional;

import br.com.jonatas.Classes.CalcularDVCNPJ;
import javax.swing.JFrame;

/**
 *
 * @author issqn
 */
public class ProjetoSimplesNacional {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FramePrincipal j = new FramePrincipal();
                j.setVisible(true);
                j.setLocationRelativeTo(null);
                j.setExtendedState(JFrame.MAXIMIZED_BOTH);
                j.setTitle("Simples Nacional - Leitor de Arquivos");
        //CalcularDVCNPJ c = new CalcularDVCNPJ("20177229");
        //System.out.println(c.getCNPJCompleto());
               
    }
    
}
