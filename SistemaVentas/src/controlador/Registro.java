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
    public ArrayList<DetalleVenta> ListaDetalle(){
        consultaListar=new Listar();
        return consultaListar.ListarDetalleVenta();
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
    
    public boolean agregar(Venta nuevo){
        
        try {
            Statement s = acceso.obtenerInstancia().createStatement();//se crea el statment de la conexion
            if(!buscar(nuevo.getIdVenta())){//se usa el metodo buscar para comprobar si elcodigo ya esta registrado
                String sentencia;
                if(nuevo.getFechaTerminoContrato().length()>2){
                    sentencia = "INSERT INTO VENTA (ID_VENTA, TIPOVENTA_ID_TIPO, VALOR_VENTA, RUT, FECHA_CONTRATACION, FECHA_TERMINO_OPCIONAL, FECHA_TERMINO_CONTRATO)"+//se da la estructura de la tabla
                                   "VALUES ("+nuevo.getIdVenta()+","+nuevo.getTipoVentaId()+","+nuevo.getValorVenta()+",'"+nuevo.getRut()+"','"+nuevo.getFechaContratacion()+"','"+nuevo.getFechaTerminoOpcional()+"','"+nuevo.getFechaTerminoContrato()+"')";//se agregan los datos del producto
                }else{
                    sentencia = "INSERT INTO VENTA (ID_VENTA, TIPOVENTA_ID_TIPO, VALOR_VENTA, RUT, FECHA_CONTRATACION, FECHA_TERMINO_OPCIONAL, FECHA_TERMINO_CONTRATO)"+//se da la estructura de la tabla
                                   "VALUES ("+nuevo.getIdVenta()+","+nuevo.getTipoVentaId()+","+0+",'"+nuevo.getRut()+"','"+nuevo.getFechaContratacion()+"','"+"null"+"','"+"null"+"')";//se agregan los datos del producto
                }

                s.execute(sentencia);//se ejecuta la sentencia sql

                System.out.println("Insertado con exito");//mensaje de exito
                return true;//retorno de exito
            }else{
                System.out.println("Codigo repetido");//mensaje de error si codigo repetido
            }
        } catch (SQLException ex) {
            System.out.println("No se pudo agregar");//mensaje de error al agregar
        }
        return false;//retorno en caso de error
    }
    
    public boolean buscar(int idVenta){
        String sentencia = "SELECT * FROM VENTA WHERE ID_VENTA = "+idVenta;//String de la sentencia para buscar el producto
        Statement s;//se crea el statment de la conexion
        
        try {
            s = acceso.obtenerInstancia().createStatement();//se instancia el statment de la conexion
            System.out.println(" Cargando datos...");
            ResultSet resultado=s.executeQuery(sentencia);//se captura el resultado de la consulta
            if(resultado.next()){//se comprueba que no esté vacio
                System.out.println("encontrado");//mensaje de encontrado
                return true;//retorno de encontrado
            }else{
                System.out.println("no encontrado");//mensaje de no encontrado
                return false;//retorno de no encontrado
            }
        } 
        catch (SQLException ex) {
            System.out.println("Error en la carga de datos");//mensaje de error en la consulta
            return false;//retorno de error en la consulta
        }
    }
}
