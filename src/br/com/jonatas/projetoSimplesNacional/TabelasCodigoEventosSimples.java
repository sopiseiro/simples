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
public class TabelasCodigoEventosSimples {
    public static void main(String[] args) {
        
        try {
            List<String> v = new ArrayList<String>();
            
            bd b = new bd();
            b.connect();
            mySql f = new mySql(b.conn);
            
            leituraTxt txt = new leituraTxt("/home/issqn/Área de Trabalho/90-0000-PUB-TabelaEventosSimplesNacional.txt");
            v = txt.leituraTxt();
            
            for (int i=2;i<v.size();i++){
                //System.out.println(v.get(i));
                System.out.println(v.get(i).substring(0, 9));
                System.out.println(v.get(i).substring(11, 211));
                System.out.println(v.get(i).substring(212, 269).replace(" ", ""));//12
                System.out.println(v.get(i).substring(281, 536));//256
                System.out.println(v.get(i).substring(538, 540));//11
                System.out.println(v.get(i).substring(550, 551));//6
                
                
                
                f.execute("INSERT INTO tabelaEventosSimples VALUES (null "
                    + ",'" + v.get(i).substring(1, 9) + "'"
                    + ",'" + v.get(i).substring(11, 211) + "'"
                    + ",'" + v.get(i).substring(212, 269).replace(" ", "") + "' "
                    + ",'" + v.get(i).substring(281, 536) + "' "
                    + ",'" + v.get(i).substring(538, 540) + "'"
                    + ",'" + v.get(i).substring(550, 551) + "'"
                    + ")");
               
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TabelasCodigoEventosSimples.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
