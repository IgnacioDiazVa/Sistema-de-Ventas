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
import modelo.Modificar;
import modelo.Venta;

/**
 *
 * @author LEARNING CENTER
 */
public class Registro {
    Listar consultaListar;
    Modificar consultaModificar;
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
    public Boolean ModificarDetalle(int codigo, int producto,int cantidad, int precio){
        consultaModificar = new Modificar();
        return consultaModificar.ModificarDetalle(codigo, producto, precio, cantidad);
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
}
