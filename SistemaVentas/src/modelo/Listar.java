/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import accesoBD.acceso;
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
public class Listar {
    ArrayList<Venta> ventas;
    Venta venta;
    ArrayList<DetalleVenta> detalles;
    DetalleVenta detalleVenta;
    /**
     * Metodos de Listar de ventas y Detalle de las Ventas
     * @Simon
     */
    public ArrayList<Venta> ListarVentas(){
        
        try {
            String sql="select ID_VENTA,FECHA_CONTRATACION,FECHA_TERMINO_OPCIONAL,FECHA_TERMINO_CONTRATO,TIPOVENTA_ID_TIPO,VALOR_VENTA,RUT from venta";
            PreparedStatement preparedStatement =acceso.obtenerInstancia().prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery(); 
            ventas = new ArrayList();
            while (resultSet.next()){
                venta = new Venta();
                venta.setIdVenta(resultSet.getInt("ID_VENTA"));
                venta.setFechaContratacion(resultSet.getString("FECHA_CONTRATACION"));
                venta.setFechaTerminoOpcional(resultSet.getString("FECHA_TERMINO_OPCIONAL"));
                venta.setFechaTerminoContrato(resultSet.getString("FECHA_TERMINO_CONTRATO"));
                venta.setTipoVentaId(resultSet.getInt("TIPOVENTA_ID_TIPO"));
                venta.setValorVenta(resultSet.getInt("VALOR_VENTA"));
                venta.setRut(resultSet.getString("RUT"));
                ventas.add(venta);
            }
            return ventas;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("se cae en el modelo");                    
            Logger.getLogger(Listar.class.getName()).log(Level.SEVERE, null, ex);
                return null;
        }   
    }
    public ArrayList<DetalleVenta> ListarDetalleVenta(int codigo){
        
        try {
            String sql="select VENTA_ID_VENTA,PRODUCTO_ID_PRODUCTO,PRECIO,CANTIDAD from relation_2v1 where VENTA_ID_VENTA=?";
            PreparedStatement preparedStatement =acceso.obtenerInstancia().prepareStatement(sql);
            preparedStatement.setInt(1,codigo);
            ResultSet resultSet = preparedStatement.executeQuery(); 
            detalles = new ArrayList();
            while (resultSet.next()){
                detalleVenta = new DetalleVenta();
                detalleVenta.setVentaIdVenta(resultSet.getInt("VENTA_ID_VENTA"));
                detalleVenta.setIdProducto(resultSet.getInt("PRODUCTO_ID_PRODUCTO"));
                detalleVenta.setPrecio(resultSet.getInt("PRECIO"));
                detalleVenta.setCantidad(resultSet.getInt("CANTIDAD"));
                detalles.add(detalleVenta);
            }
            return detalles;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("se cae en el modelo");                    
            Logger.getLogger(Listar.class.getName()).log(Level.SEVERE, null, ex);
                return null;
        }   
    }
    public ArrayList<DetalleVenta> BuscarDetalleVenta(int codigo,int producto){
        
        try {
            String sql="select VENTA_ID_VENTA,PRODUCTO_ID_PRODUCTO,PRECIO,CANTIDAD from relation_2v1 where VENTA_ID_VENTA=? and PRODUCTO_ID_PRODUCTO=?";
            PreparedStatement preparedStatement =acceso.obtenerInstancia().prepareStatement(sql);
            preparedStatement.setInt(1,codigo);
            preparedStatement.setInt(2,producto);
            ResultSet resultSet = preparedStatement.executeQuery(); 
            detalles = new ArrayList();
            while (resultSet.next()){
                detalleVenta = new DetalleVenta();
                detalleVenta.setVentaIdVenta(resultSet.getInt("VENTA_ID_VENTA"));
                detalleVenta.setIdProducto(resultSet.getInt("PRODUCTO_ID_PRODUCTO"));
                detalleVenta.setPrecio(resultSet.getInt("PRECIO"));
                detalleVenta.setCantidad(resultSet.getInt("CANTIDAD"));
                detalles.add(detalleVenta);
            }
            return detalles;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("se cae en el modelo");                    
            Logger.getLogger(Listar.class.getName()).log(Level.SEVERE, null, ex);
                return null;
        }   
    }
}
