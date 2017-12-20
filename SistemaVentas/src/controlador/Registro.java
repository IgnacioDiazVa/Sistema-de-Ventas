/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

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
}
