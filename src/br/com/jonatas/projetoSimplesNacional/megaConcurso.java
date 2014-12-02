/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jonatas.projetoSimplesNacional;

import br.com.jonatas.Base.bd;
import br.com.jonatas.Classes.leituraTxt;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilitarios.mySql;

/**
 *
 * @author issqn
 */
public class megaConcurso {
    public static void main(String[] args) {
        
        try {
            List<String> v = new ArrayList<String>();
            
            bd b = new bd();
            b.connect();
            mySql f = new mySql(b.conn);
            
            leituraTxt txt = new leituraTxt("/home/issqn/Área de Trabalho/mega.txt");
            v = txt.leituraTxt();
            
            for (int i=0;i<v.size();i++){
                String numero[] = v.get(i).split(" ");
                /*System.out.println(v.get(i).substring(0, 9));
                System.out.println(v.get(i).substring(11, 211));
                System.out.println(v.get(i).substring(212, 269).replace(" ", ""));//12
                System.out.println(v.get(i).substring(281, 536));//256
                System.out.println(v.get(i).substring(538, 540));//11
                System.out.println(v.get(i).substring(550, 551));//6
                */
                
                for (int x=2;x<numero.length;x++){
                    System.out.println(numero[x]);
                    f.execute("INSERT INTO mega VALUES ('"+ numero[x] +"')");
                }
                
               
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TabelasCodigoEventosSimples.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
