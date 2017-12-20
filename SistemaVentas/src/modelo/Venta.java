package modelo;

/**
 *
 * @author simon (editado por Lucas)
 */
public class Venta {
    private Integer idVenta,tipoVentaId,valorVenta;
    private String rut, fechaContratacion, fechaTerminoOpcional, fechaTerminoContrato;

    public Venta() {
    }

    public Venta(Integer idVenta, Integer tipoVentaId, Integer valorVenta, String rut, String fechaContratacion, String fechaTerminoOpcional, String fechaTerminoContrato) {
        this.idVenta = idVenta;//hasta 4 digitos
        this.tipoVentaId = tipoVentaId;//post-pago (1000) o pre-pago (2000)
        this.valorVenta = valorVenta;//hasta 11 digitos
        this.rut = rut;//hasta 11 digitos
        this.fechaContratacion = fechaContratacion;//insertar como TimeStamp
        this.fechaTerminoOpcional = fechaTerminoOpcional;//insertar como TimeStamp
        this.fechaTerminoContrato = fechaTerminoContrato;//insertar como TimeStamp
    }

    public Integer getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Integer idVenta) {
        if(idVenta>0 && idVenta<10000){
            this.idVenta = idVenta;
        }else{
            System.out.println("Id debe ser entre 0 y 9999");
        }
    }

    public Integer getTipoVentaId() {
        return tipoVentaId;
    }

    public void setTipoVentaId(Integer tipoVentaId) {
        if(tipoVentaId==1000 || tipoVentaId==2000){
            this.tipoVentaId = tipoVentaId;
        }else{
            System.out.println("Tipo venta desconocido");
        }
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

    public String getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(String fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
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
