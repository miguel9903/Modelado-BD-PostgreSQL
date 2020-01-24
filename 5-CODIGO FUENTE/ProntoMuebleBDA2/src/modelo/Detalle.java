package modelo;

public class Detalle {

    int id_mueble;
    int id_venta;
    int cantidad;

    public Detalle() {

    }

    public Detalle(int id_mueble, int id_venta, int cantidad) {
        this.id_mueble = id_mueble;
        this.id_venta = id_venta;
        this.cantidad = cantidad;
    }

    public int getId_mueble() {
        return id_mueble;
    }

    public void setId_mueble(int id_mueble) {
        this.id_mueble = id_mueble;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

}
