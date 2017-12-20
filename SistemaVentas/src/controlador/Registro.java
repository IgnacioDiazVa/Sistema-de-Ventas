/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import modelo.DetalleVenta;
import modelo.ModeloListar;
import modelo.Venta;

/**
 *
 * @author LEARNING CENTER
 */
public class Registro {
    ModeloListar consultaListar;
    /**
     * Metodos a traves del registro para listar, no existen reglas de negocio al respecto
     * @ Simon
     */
    public ArrayList<Venta> ListaVenta(){
        consultaListar=new ModeloListar();
        return consultaListar.ListarVentas();
    }
    public ArrayList<DetalleVenta> ListaDetalle(){
        consultaListar=new ModeloListar();
        return consultaListar.ListarDetalleVenta();
    }
}
