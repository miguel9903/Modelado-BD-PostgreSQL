package modelo;

public class Telefono_Cliente {

    private int id_cliente;
    private String telefono;

    public Telefono_Cliente() {
    }

    public Telefono_Cliente(int id_cliente, String telefono) {
        this.id_cliente = id_cliente;
        this.telefono = telefono;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
