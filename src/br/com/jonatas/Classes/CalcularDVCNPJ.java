/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.jonatas.Classes;

/**
 *Recebe string de 8 posiçoes (cnpj base, somento numeros) para calculo do DV do cnpj
 *retorna String de 14 posições, cnpj completo (somente numeros)
 * @author issqn
 */
public class CalcularDVCNPJ {
    
    private String cnpjbase;
    private String cnpjcompleto;
    public CalcularDVCNPJ(String cnpjbase){
        this.cnpjbase = cnpjbase+"0001";
    }
    
    private void calcula(){
        int total = 0;
        int[] mult01 = {5,4,3,2,9,8,7,6,5,4,3,2};
        int[] mult02 = {6,5,4,3,2,9,8,7,6,5,4,3,2};
        for (int i=0;i<cnpjbase.length();i++){
            String aux = cnpjbase;
            //System.out.println(aux.substring(i,i+1)+":teste:"+cnpjbase);
            total += Integer.parseInt(aux.substring(i, i+1))*mult01[i];
                    
        }
        System.out.println(total%11);
        String dv01 = ""+(total%11<2?0:11-(total%11));
        total = 0;
        String cnpjbase11 = cnpjbase+dv01;
        System.out.println(cnpjbase11.length()+":eteste:"+dv01);
        for (int i=0;i<cnpjbase11.length();i++){
            String aux = cnpjbase+dv01;
            total += Integer.parseInt(aux.substring(i, i+1))*mult02[i];
        }
        String dv02 = ""+(total%11<2?0:11-(total%11));
        cnpjcompleto = cnpjbase+dv01+dv02;
    }
    
    public String getCNPJCompleto(){
        calcula();
        return cnpjcompleto;
    }
}
