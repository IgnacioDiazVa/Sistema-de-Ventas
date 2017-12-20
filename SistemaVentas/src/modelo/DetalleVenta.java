package modelo;

/**
 *
 * @author simon (editado por Lucas)
 */
public class DetalleVenta {
    private Integer ventaIdVenta, idProducto, precio, cantidad;
    
    public DetalleVenta() {
    }

    public DetalleVenta(Integer ventaIdVenta, Integer idProducto, Integer precio, Integer cantidad) {
        setVentaIdVenta(ventaIdVenta);//hasta 4 digitos
        setIdProducto(idProducto);//hasta 4 digitos
        setPrecio(precio);//hasta 11 digitos
        setCantidad(cantidad);//hasta 11 digitos
    }

    public Integer getVentaIdVenta() {
        return ventaIdVenta;
    }

    public void setVentaIdVenta(Integer ventaIdVenta) {
        if(ventaIdVenta>0 && ventaIdVenta<10000){
            this.ventaIdVenta = ventaIdVenta;
        }else{
            System.out.println("Id Venta debe tener 4 dgitos maximo");
        }
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        if(idProducto>0 && idProducto<10000){
            this.idProducto = idProducto;
        }else{
            System.out.println("Id Producto debe tener 4 dgitos maximo");
        }
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.ventaIdVenta = ventaIdVenta;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.ventaIdVenta = ventaIdVenta;
    }

    @Override
    public String toString() {
        return "\nID Venta: " + getVentaIdVenta() + "ID Producto: " + getIdProducto() + " Precio: " + getPrecio() + " Cantidad: " + getCantidad();
    }
}
