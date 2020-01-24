package modelo;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DAODetalle extends Conexion {

    public String registrar(Detalle detalle) throws Exception {
        String res = null;
        try {
            this.conectar();
            PreparedStatement st = this.getConexion().prepareStatement("INSERT INTO DETALLE VALUES (?, ?, ?);;");
            st.setInt(1, detalle.getId_mueble());
            st.setInt(2, detalle.getId_venta());
            st.setInt(3, detalle.getCantidad());
            int num = st.executeUpdate();
            if (num > 0) {
                res = "Detalle registrado con exito.";
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return res;
    }
}
