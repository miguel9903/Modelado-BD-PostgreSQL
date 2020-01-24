package modelo;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DAOVenta extends Conexion {

    public String registrar(Venta venta) throws Exception {
        String res = null;
        try {
            this.conectar();
            PreparedStatement st = this.getConexion().prepareStatement("INSERT INTO VENTA(fecha, subtotal, id_vendedor, id_cliente) VALUES(?, ?, ?, ?);");
            st.setString(1, venta.getFecha());
            st.setFloat(2, venta.getSubtotal());
            st.setInt(3, venta.getId_vendedor());
            st.setInt(4, venta.getId_cliente());
            int num = st.executeUpdate();
            if (num > 0) {
                res = "Venta registrada con exito.";
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return res;
    }

}
