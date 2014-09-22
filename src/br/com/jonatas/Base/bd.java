package br.com.jonatas.Base;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class bd {

    public Connection conn = null;
    public boolean status;

    public bd() {
    }

    public void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            System.out.println("jdbc:sqlite:"+ System.getProperty("user.dir") + File.separator+"base"+File.separator+"datasn.sqlite");
            conn = DriverManager.getConnection("jdbc:sqlite:"+ System.getProperty("user.dir") + File.separator +"base"+File.separator+"datasn.sqlite");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Impossivel conectar com o banco de dados. Verifique se o servidor está ativo!");
            System.exit(0);
        }
    }

    public void disconnect() {
        try {
            conn.close();
            status = false;
        } catch (SQLException erro) {
            System.out.println("Erro no fechamento");
            //erro.printStackTrace();
        }
    }

    public boolean isconnected() {
        return status;
    }
}
