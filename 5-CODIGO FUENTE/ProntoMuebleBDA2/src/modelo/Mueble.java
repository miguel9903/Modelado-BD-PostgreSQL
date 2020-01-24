package modelo;

public class Mueble {

    int id, stock;
    String descripcion;
    String estado;
    String id_tipo_mueble;
    String id_material;
    String id_color;
    float precio_unitario, largo, ancho, alto;

    public Mueble() {
    }

    public Mueble(int id, int stock, String descripcion, String estado, String id_tipo_mueble, String id_material, String id_color, float precio_unitario, float largo, float ancho, float alto) {
        this.id = id;
        this.stock = stock;
        this.descripcion = descripcion;
        this.estado = estado;
        this.id_tipo_mueble = id_tipo_mueble;
        this.id_material = id_material;
        this.id_color = id_color;
        this.precio_unitario = precio_unitario;
        this.largo = largo;
        this.ancho = ancho;
        this.alto = alto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getId_tipo_mueble() {
        return id_tipo_mueble;
    }

    public void setId_tipo_mueble(String id_tipo_mueble) {
        this.id_tipo_mueble = id_tipo_mueble;
    }

    public String getId_material() {
        return id_material;
    }

    public void setId_material(String id_material) {
        this.id_material = id_material;
    }

    public String getId_color() {
        return id_color;
    }

    public void setId_color(String id_color) {
        this.id_color = id_color;
    }

    public float getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(float precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public float getLargo() {
        return largo;
    }

    public void setLargo(float largo) {
        this.largo = largo;
    }

    public float getAncho() {
        return ancho;
    }

    public void setAncho(float ancho) {
        this.ancho = ancho;
    }

    public float getAlto() {
        return alto;
    }

    public void setAlto(float alto) {
        this.alto = alto;
    }

}
