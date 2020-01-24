package modelo;

public class Telefono_Proveedor {

    private int id_proveedor;
    private String telefono;

    public Telefono_Proveedor() {
    }

    public Telefono_Proveedor(int id_proveedor, String telefono) {
        this.id_proveedor = id_proveedor;
        this.telefono = telefono;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }


}
