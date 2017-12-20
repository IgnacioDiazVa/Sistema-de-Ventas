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
public class Venta {
    private Integer idVenta,tipoVentaId,valorVenta;
    private String rut, fehcaContratacion, fechaTerminoOpcional, fechaTerminoContrato;

    public Venta() {
    }

    public Venta(Integer idVenta, Integer tipoVentaId, Integer valorVenta, String rut, String fehcaContratacion, String fechaTerminoOpcional, String fechaTerminoContrato) {
        this.idVenta = idVenta;
        this.tipoVentaId = tipoVentaId;
        this.valorVenta = valorVenta;
        this.rut = rut;
        this.fehcaContratacion = fehcaContratacion;
        this.fechaTerminoOpcional = fechaTerminoOpcional;
        this.fechaTerminoContrato = fechaTerminoContrato;
    }

    public Integer getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Integer idVenta) {
        this.idVenta = idVenta;
    }

    public Integer getTipoVentaId() {
        return tipoVentaId;
    }

    public void setTipoVentaId(Integer tipoVentaId) {
        this.tipoVentaId = tipoVentaId;
    }

    public Integer getValorVenta() {
        return valorVenta;
    }

    public void setValorVenta(Integer valorVenta) {
        this.valorVenta = valorVenta;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getFehcaContratacion() {
        return fehcaContratacion;
    }

    public void setFehcaContratacion(String fehcaContratacion) {
        this.fehcaContratacion = fehcaContratacion;
    }

    public String getFechaTerminoOpcional() {
        return fechaTerminoOpcional;
    }

    public void setFechaTerminoOpcional(String fechaTerminoOpcional) {
        this.fechaTerminoOpcional = fechaTerminoOpcional;
    }

    public String getFechaTerminoContrato() {
        return fechaTerminoContrato;
    }

    public void setFechaTerminoContrato(String fechaTerminoContrato) {
        this.fechaTerminoContrato = fechaTerminoContrato;
    }
    
    
}
