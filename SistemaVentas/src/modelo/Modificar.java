/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import accesoBD.acceso;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author simon
 */
public class Modificar {
    public Boolean ModificarDetalle (int codigo,int producto, int precio, int cantidad){
          try {
            int a = 0;
            StringBuffer linea = new StringBuffer();
            linea.append("update relation_2v1 set ");
            if (precio>0){
                linea.append("PRECIO="+precio);
                a++;
                System.out.println("modifico PRECIO");
            }if (cantidad>0){
                if (a>0){
                linea.append(", ");
                a++;
                }
                linea.append("CANTIDAD="+cantidad+"'");
                System.out.println("modifico CANTIDAD");
            }
            linea.append(" where VENTA_ID_VENTA=? and PRODUCTO_ID_PRODUCTO=?");                
            System.out.println(linea.toString());
            PreparedStatement preparedStatement = acceso.obtenerInstancia().prepareStatement(linea.toString());
            preparedStatement.setInt(1,codigo);
            preparedStatement.setInt(2,producto);
            preparedStatement.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Modificar.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
