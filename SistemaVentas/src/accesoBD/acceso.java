/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author simon
 */
public class acceso {
        public static Connection connection;
        
        private acceso() {
    }
    public static Connection obtenerInstancia(){
        if (connection==null){
        String url= "jdbc:oracle:thin:@MSP-PM-04-03.aws.smartcloud.cl:1521:xe";
        String user="usuario03";
        String pass="usuario03";
        System.out.println("Proceso de Coneccion...");
        try {
            connection= DriverManager.getConnection(url, user, pass);
            System.out.println("Base de datos Conectada!!");
        }catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        }
        return connection;
    }
}