package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOMueble extends Conexion {

    public String registrar(Mueble mueble) throws Exception {
        String res = null;
        try {
            this.conectar();
            PreparedStatement st = this.getConexion().prepareStatement("INSERT INTO MUEBLE(id_tipo_mueble, id_material, largo, ancho, alto, "
                    + "id_color, precio_unitario, descripcion, stock, estado) "
                    + "VALUES((SELECT id from TIPO_MUEBLE where tipo_mueble=?),(SELECT id from MATERIAL where material=?),?,?,?,(SELECT id from COLOR where color=?),?,?,?,?);");
            establecerParametrosConsulta(st, mueble);
            int num = st.executeUpdate();
            if (num > 0) {
                res = "Registro exitoso";
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return res;
    }

    public String modificar(Mueble mueble, int id_mod, String criterio) throws Exception {
        String res = null;
        String consultaSQL = "";
        PreparedStatement st = null;
        try {
            this.conectar();
            if (criterio.equals("Varios")) {
                consultaSQL = "UPDATE MUEBLE SET id_tipo_mueble=(SELECT id from TIPO_MUEBLE where tipo_mueble=?), "
                        + "id_material=(SELECT id from MATERIAL where material=?), largo=?, ancho=?, alto=?, id_color=(SELECT id from COLOR where color=?), "
                        + " precio_unitario=?, descripcion=?, stock=?, estado=? WHERE id=?;";
                st = this.getConexion().prepareStatement(consultaSQL);
                establecerParametrosConsulta(st, mueble);
                st.setInt(11, id_mod);
            } else if (criterio.equals("Estado")) {
                consultaSQL = "UPDATE MUEBLE SET estado=? WHERE id=?;";
                st = this.getConexion().prepareStatement(consultaSQL);
                st.setString(1, mueble.getEstado());
                st.setInt(2, id_mod);
            }
            int num = st.executeUpdate();
            if (num > 0) {
                res = "Mueble eliminado con exito.";
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return res;
    }

    public String modificarStock(int stock, int id_mod) throws Exception {
        String res = null;
        try {
            this.conectar();
            PreparedStatement st = this.getConexion().prepareStatement("UPDATE MUEBLE SET stock=? WHERE id=?;");
            st.setInt(1, stock);
            st.setInt(2, id_mod);
            int num = st.executeUpdate();
            if (num > 0) {
                res = "Stock actualizado con exito.";
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return res;
    }

    public ArrayList<Mueble> listar(String criterio) throws Exception {

        ArrayList<Mueble> listaP = new ArrayList<>();
        String sentenciaSQL = "";
        PreparedStatement st = null;
        ResultSet resultado = null;

        try {
            this.conectar();
            if (criterio.equals("Todos")) {
                sentenciaSQL = "SELECT mueble.id, tipo_mueble, material, largo, ancho, alto, color, precio_unitario, descripcion, stock, estado\n"
                        + "FROM mueble, tipo_mueble, material, color\n"
                        + "WHERE id_tipo_mueble=tipo_mueble.id AND id_material=material.id AND id_color=color.id ORDER BY id;";
                st = this.getConexion().prepareStatement(sentenciaSQL);
                resultado = st.executeQuery();
                llenarListaMueble(resultado, listaP);
            } else if (criterio.equals("Activos")) {
                sentenciaSQL = "SELECT mueble.id, tipo_mueble, material, largo, ancho, alto, color, precio_unitario, descripcion, stock, estado\n"
                        + "FROM mueble, tipo_mueble, material, color\n"
                        + "WHERE id_tipo_mueble=tipo_mueble.id AND id_material=material.id AND id_color=color.id AND estado='activo' ORDER BY id;";
                st = this.getConexion().prepareStatement(sentenciaSQL);
                llenarListaMueble(resultado, listaP);
                resultado = st.executeQuery();
            } else if (criterio.equals("Venta_mueble")) {
                sentenciaSQL = "SELECT * FROM vista_venta_mueble;";
                st = this.getConexion().prepareStatement(sentenciaSQL);
                resultado = st.executeQuery();
                llenarListaMuebleVentas(resultado, listaP);
            }

            resultado.close();
            st.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return listaP;
    }

    public ArrayList<Mueble> buscar(String cadena, String criterio) throws Exception {

        ArrayList<Mueble> listaP = new ArrayList<>();
        String sentenciaSQL = "";

        if (criterio.equalsIgnoreCase("General")) {
            //    sentenciaSQL = "SELECT * FROM MUEBLE WHERE cast(id as varchar(5)) LIKE '" + cadena + "' OR descripcion LIKE '" + cadena + "%' OR estado LIKE '" + cadena + "%' ORDER BY id;";
            sentenciaSQL = "SELECT mueble.id, tipo_mueble, material, largo, ancho, alto, color, precio_unitario, descripcion, stock, estado\n"
                    + "FROM mueble, tipo_mueble, material, color\n"
                    + "WHERE id_tipo_mueble=tipo_mueble.id AND id_material=material.id AND id_color=color.id AND (cast(mueble.id as varchar(5)) LIKE '" + cadena
                    + "' OR descripcion LIKE '" + cadena + "%' OR estado LIKE '" + cadena + "%') ORDER BY mueble.id;";
        } else if (criterio.equalsIgnoreCase("Activos")) {
            //    sentenciaSQL = "SELECT * FROM MUEBLE WHERE cast(id as varchar(5)) LIKE '" + cadena + "' OR descripcion LIKE '" + cadena + "%' OR estado LIKE '" + cadena + "%' ORDER BY id;";
            sentenciaSQL = "SELECT mueble.id, tipo_mueble, material, largo, ancho, alto, color, precio_unitario, descripcion, stock, estado\n"
                    + "FROM mueble, tipo_mueble, material, color\n"
                    + "WHERE id_tipo_mueble=tipo_mueble.id AND id_material=material.id AND id_color=color.id AND (cast(mueble.id as varchar(5)) LIKE '" + cadena
                    + "' OR descripcion LIKE '" + cadena + "%') AND estado='Activo' ORDER BY mueble.id;";
        }

        try {
            this.conectar();
            PreparedStatement st = this.getConexion().prepareStatement(sentenciaSQL);
            ResultSet resultado = st.executeQuery();
            llenarListaMueble(resultado, listaP);
            resultado.close();
            st.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return listaP;

    }

    public void establecerParametrosConsulta(PreparedStatement st, Mueble mueble) {
        try {
            st.setString(1, mueble.getId_tipo_mueble());
            st.setString(2, mueble.getId_material());
            st.setFloat(3, mueble.getLargo());
            st.setFloat(4, mueble.getAncho());
            st.setFloat(5, mueble.getAlto());
            st.setString(6, mueble.getId_color());
            st.setFloat(7, mueble.getPrecio_unitario());
            st.setString(8, mueble.getDescripcion());
            st.setInt(9, mueble.getStock());
            st.setString(10, mueble.getEstado());

        } catch (SQLException ex) {
            Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void llenarListaMueble(ResultSet resultado, ArrayList<Mueble> listaP) {
        try {
            while (resultado.next()) {
                Mueble mueble = new Mueble();
                mueble.setId(resultado.getInt("id"));
                mueble.setId_tipo_mueble(resultado.getString("tipo_mueble"));
                mueble.setId_material(resultado.getString("material"));
                mueble.setLargo(resultado.getFloat("largo"));
                mueble.setAncho(resultado.getFloat("ancho"));
                mueble.setAlto(resultado.getFloat("alto"));
                mueble.setId_color(resultado.getString("color"));
                mueble.setPrecio_unitario(resultado.getFloat("precio_unitario"));
                mueble.setDescripcion(resultado.getString("descripcion"));
                mueble.setStock(resultado.getInt("stock"));
                mueble.setEstado(resultado.getString("estado"));
                listaP.add(mueble);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void llenarListaMuebleVentas(ResultSet resultado, ArrayList<Mueble> listaP) {
        try {
            while (resultado.next()) {
                Mueble mueble = new Mueble();
                mueble.setId(resultado.getInt("id"));
                mueble.setDescripcion(resultado.getString("descripcion"));
                mueble.setPrecio_unitario(resultado.getFloat("precio_unitario"));
                mueble.setStock(resultado.getInt("stock"));
                mueble.setEstado(resultado.getString("estado"));
                listaP.add(mueble);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
