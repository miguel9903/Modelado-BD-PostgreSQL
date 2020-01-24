package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {

    private Connection conexion;
    private final String rutaBBDD = "jdbc:postgresql://localhost:5432/prontomueble";
    private final String usuario = "postgres";
    private final String clave = "123456";

    public Conexion() {
    }

    public void conectar() throws ClassNotFoundException {

        try {
            Class.forName("org.postgresql.Driver");
            conexion = DriverManager.getConnection(rutaBBDD, usuario, clave);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void desconectar() throws SQLException {

        if (conexion != null) {
            if (conexion.isClosed() == false) {
                conexion.close();
            }
        }
    }

    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

}
