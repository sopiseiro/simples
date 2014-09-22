/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.jonatas.Classes;

/**
 *
 * @author issqn
 */
public class Datas {
    private String data;
    public Datas(){
        
    }
    
    public void setData(String data){
        this.data = data;
    }
    
    public String getInvertData(String data){
        this.data = data;
        return data.substring(6, 8)+"/"+data.substring(4, 6)+"/"+data.substring(0, 4);
    }
    
    public boolean getDataZero(){
        if (getInvertData(data).equals("00/00/0000"))
            return true;
        return false;
    }
    
    public String getHoras(String hora){
        return hora.substring(0, 2)+":"+hora.substring(2, 4)+":"+hora.substring(4, 6); 
    }
            
}
