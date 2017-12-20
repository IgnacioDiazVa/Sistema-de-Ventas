/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author simon
 */
public class ModeloListar {
    ArrayList<Venta> ventas;
    Venta venta;
    ArrayList<DetalleVenta> detalles;
    DetalleVenta detalleVenta;
    
    public ArrayList<Venta> ListarVentas(){
        
        try {
            String sql="select id_transaccion,fecha,monto_total from transaccion";
            PreparedStatement preparedStatement =acceso.obtenerInstancia().prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery(); 
            ventas = new ArrayList();
            while (resultSet.next()){
                venta = new Venta();
                //venta.setIdTransaccion(resultSet.getInt("id_transaccion"));
                ventas.add(venta);
            }
            return ventas;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println(ex.getMessage());                    
            Logger.getLogger(ModeloListar.class.getName()).log(Level.SEVERE, null, ex);
                return null;
        }   
    }
}
