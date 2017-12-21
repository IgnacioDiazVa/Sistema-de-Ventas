/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import accesoBD.acceso;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.DetalleVenta;
import modelo.Listar;
import modelo.Venta;

/**
 *
 * @author LEARNING CENTER
 */
public class Registro {
    Listar consultaListar;
    /**
     * Metodos a traves del registro para listar, no existen reglas de negocio al respecto
     * @ Simon
     */
    public ArrayList<Venta> ListaVenta(){
        consultaListar=new Listar();
        return consultaListar.ListarVentas();
    }
    public ArrayList<DetalleVenta> ListaDetalle(int codigo){
        consultaListar=new Listar();
        return consultaListar.ListarDetalleVenta(codigo);
    }
    public ArrayList<DetalleVenta> BuscarDetalle(int codigo, int producto){
        consultaListar=new Listar();
        return consultaListar.BuscarDetalleVenta(codigo, producto);
    }
    
    public ResultSet productos(){
        String sentencia = "SELECT NOMBRE_PRODUCTO FROM PRODUCTO ORDER BY ID ASC";//String de la sentencia para buscar los productos agregados
        Statement s;//se crea el statment de la conexion
        
        try {
            s = acceso.obtenerInstancia().createStatement();//se instancia el statment de la conexion
            System.out.println(" Cargando datos...");
            ResultSet resultado=s.executeQuery(sentencia);//se ejecuta la sentencia sql y se le da valor al resulltado
            return resultado;//se retorna el resulatdo de la consulta como ResultSet
        } 
        catch (SQLException ex) {
            System.out.println("Error en la carga de datos");//mensaje de error
            return null;//retorna nulo si hubo un fallo en la carga de datos
        } 
    }
    
    /**
     * Metodo boolean borrar venta por codigo, genera mensajes de avance durante el proceso
     * @param codigo
     * @return true si fue borrado de manera correcta a la base de datos
     */
    public boolean borrar(int idVenta){
        if(buscar(idVenta)){//se usa el metodo buscar para comprobar si elcodigo ya esta registrado
            String sentencia="DELETE FROM VENTA WHERE ID_VENTA="+idVenta;//String de la sentencia para borrar el producto con el codigo
            try {
                Statement s = acceso.obtenerInstancia().createStatement();//se crea el statment de la conexion
                s.executeUpdate(sentencia);//se ejecuta la sentencia sql
                System.out.println(" registro borrado...");//mensaje de exito
                return true;//retorno de exito al borrar
            } catch (SQLException ex) {
                System.out.println("registro no encontrado");//mensaje de error
            }
            return false;//retorno de error al borrar
        }
        return false;//retorno de no se encuentra en la base de datos
    }
    
    /**
     * Metodo boolean borrar detalle venta por codigo, genera mensajes de avance durante el proceso
     * @param codigo
     * @return true si fue borrado de manera correcta a la base de datos
     */
    public boolean borrarDetalle(int idVenta, int idProducto){
        if(!BuscarDetalle(idVenta, idProducto).isEmpty()){//se usa el metodo buscar para comprobar si elcodigo ya esta registrado
            String sentencia="DELETE FROM RELATION_2V1 WHERE VENTA_ID_VENTA="+idVenta+"AND PRODUCTO_ID_PRODUCTO = "+idProducto;//String de la sentencia para borrar el producto con el codigo
            try {
                Statement s = acceso.obtenerInstancia().createStatement();//se crea el statment de la conexion
                s.executeUpdate(sentencia);//se ejecuta la sentencia sql
                System.out.println(" registro borrado...");//mensaje de exito
                return true;//retorno de exito al borrar
            } catch (SQLException ex) {
                System.out.println("registro no encontrado");//mensaje de error
            }
            return false;//retorno de error al borrar
        }
        return false;//retorno de no se encuentra en la base de datos
    }
}
