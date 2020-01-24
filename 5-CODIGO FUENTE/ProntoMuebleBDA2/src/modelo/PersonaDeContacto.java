package modelo;

public class PersonaDeContacto {

    int id, id_proveedor;
    String nombre, telefono;

    public PersonaDeContacto() {
    }

    public PersonaDeContacto(int id, int id_proveedor, String nombre, String telefono) {
        this.id = id;
        this.id_proveedor = id_proveedor;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

}
