
package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOVendedor extends Conexion {
    
    public String registrar(Vendedor v) throws Exception {
        String res = null;
        String consultaSQL = "";
        try {
            this.conectar();
            consultaSQL = "INSERT INTO VENDEDOR(nombre, telefono) VALUES(?,?);";
            PreparedStatement st = this.getConexion().prepareStatement(consultaSQL);
            st.setString(1, v.getNombre());
            st.setString(2, v.getTelefono());
            int num = st.executeUpdate();

            if (num > 0) {
                res = "Vendedor registrado con exito.";
            }

        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return res;
    }

    public String modificar(Vendedor v, int id_mod) throws Exception {
        String res = null;
        String consultaSQL = "";
        try {
            this.conectar();
            consultaSQL = "UPDATE VENDEDOR SET nombre=?, telefono=?, estado=? WHERE id=?;";
            PreparedStatement st = this.getConexion().prepareStatement(consultaSQL);
            establecerParametrosConsulta(st, v);
            st.setInt(4, id_mod);
            int num = st.executeUpdate();
            if (num > 0) {
                res = "Proveedor modificado con exito";
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return res;
    }

    public ArrayList<Vendedor> listar(String criterio) throws Exception {
        ArrayList<Vendedor> listaP = new ArrayList<>();
        String sentenciaSQL = "";

        if (criterio.equals("Todos")) {
            sentenciaSQL = "SELECT * FROM VENDEDOR ORDER BY id";
        } else if (criterio.equals("Activos")) {
            sentenciaSQL = "SELECT * FROM VENDEDOR WHERE estado='activo' ORDER BY id;";
        }
        try {
            this.conectar();
            PreparedStatement st = this.getConexion().prepareStatement(sentenciaSQL);
            ResultSet resultado = st.executeQuery();
            llenarListaVendedor(resultado, listaP);
            resultado.close();
            st.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return listaP;
    }

    public ArrayList<Vendedor> buscar(String cadena, String criterio) throws Exception {

        ArrayList<Vendedor> listaP = new ArrayList<>();
        String sentenciaSQL = "";

        if (criterio.equalsIgnoreCase("General")) {
            sentenciaSQL = "SELECT * FROM VENDEDOR WHERE cast(id as varchar(3)) LIKE '" + cadena + "' OR nombre LIKE '" + cadena + "%' OR telefono LIKE '"
                    + cadena + "%' OR estado LIKE '" + cadena + "%' ORDER BY id;";
        } else if (criterio.equalsIgnoreCase("Activos")) {
            sentenciaSQL = "SELECT * FROM VENDEDOR WHERE (cast(id as varchar(3)) LIKE '" + cadena + "' OR nombre LIKE '" + cadena + "%' OR telefono LIKE '"
                    + cadena + "%') AND estado='activo' ORDER BY id;";
        }
        try {
            this.conectar();
            PreparedStatement st = this.getConexion().prepareStatement(sentenciaSQL);
            ResultSet resultado = st.executeQuery();
            llenarListaVendedor(resultado, listaP);
            resultado.close();
            st.close();
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return listaP;
    }

    public int retornarMax() throws Exception {

        String sentenciaSQL = "SELECT MAX(id) FROM PROVEEDOR;";
        int numMax = 0;
        try {
            this.conectar();
            PreparedStatement st = this.getConexion().prepareStatement(sentenciaSQL);
            ResultSet resultado = st.executeQuery();
            while (resultado.next()) {
                numMax = resultado.getInt("max");
            }
            resultado.close();
            st.close();
        } catch (ClassNotFoundException | SQLException e) {

        } finally {
            this.desconectar();
        }
        return numMax;
    }

    public void establecerParametrosConsulta(PreparedStatement st, Vendedor v) {
        try {
            st.setString(1, v.getNombre());
            st.setString(2, v.getTelefono());
            st.setString(3, v.getEstado());
        } catch (SQLException ex) {
            Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void llenarListaVendedor(ResultSet resultado, ArrayList<Vendedor> listaP) {
        try {
            while (resultado.next()) {
                Vendedor v = new Vendedor();
                v.setId(resultado.getInt("id"));
                v.setNombre(resultado.getString("nombre"));
                v.setTelefono(resultado.getString("telefono"));
                v.setEstado(resultado.getString("estado"));
                listaP.add(v);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int validarExistente(String id, String tabla, String campo, String valor) throws Exception {
        int res = 0;
        try {
            this.conectar();
            PreparedStatement st = this.getConexion().prepareStatement("SELECT COUNT(" + id + ") FROM " + tabla + " WHERE " + campo + "='" + valor + "';");
            ResultSet resultado = st.executeQuery();
            if (resultado.next()) {
                res = resultado.getInt(1);
            }
            resultado.close();
            st.close();
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return res;
    }
}
