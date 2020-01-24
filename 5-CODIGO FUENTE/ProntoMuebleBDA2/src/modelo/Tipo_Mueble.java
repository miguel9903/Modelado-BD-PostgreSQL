
package modelo;

public class Tipo_Mueble {
    
    int id;
    String tipo_mueble;

    public Tipo_Mueble(int id, String tipo_mueble) {
        this.id = id;
        this.tipo_mueble = tipo_mueble;
    }

    public Tipo_Mueble() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo_mueble() {
        return tipo_mueble;
    }

    public void setTipo_mueble(String tipo_mueble) {
        this.tipo_mueble = tipo_mueble;
    }   
}
