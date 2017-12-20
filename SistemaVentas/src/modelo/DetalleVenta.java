/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author simon
 */
public class DetalleVenta {
    private Integer ventaIdVenta, idProducto, precio, cantidad;

    public Integer getVentaIdVenta() {
        return ventaIdVenta;
    }

    public void setVentaIdVenta(Integer ventaIdVenta) {
        this.ventaIdVenta = ventaIdVenta;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public DetalleVenta() {
    }

    public DetalleVenta(Integer ventaIdVenta, Integer idProducto, Integer precio, Integer cantidad) {
        this.ventaIdVenta = ventaIdVenta;
        this.idProducto = idProducto;
        this.precio = precio;
        this.cantidad = cantidad;
    }
}
