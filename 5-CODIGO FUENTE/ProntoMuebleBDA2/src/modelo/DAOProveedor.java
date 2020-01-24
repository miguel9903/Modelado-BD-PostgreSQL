package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOProveedor extends Conexion {

    public String registrar(Proveedor p) throws Exception {
        String res = null;
        String consultaSQL = "";
        try {
            this.conectar();
            consultaSQL = "INSERT INTO PROVEEDOR(nombre, direccion) VALUES(?,?);";
            PreparedStatement st = this.getConexion().prepareStatement(consultaSQL);
            st.setString(1, p.getNombre());
            st.setString(2, p.getDireccion());
            int num = st.executeUpdate();

            if (num > 0) {
                res = "Proveedor registrado con exito.";
            }

        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return res;
    }

    public String modificar(Proveedor p, int id_mod) throws Exception {
        String res = null;
        String consultaSQL = "";
        try {
            this.conectar();
            consultaSQL = "UPDATE PROVEEDOR SET nombre=?, direccion=?, estado=? WHERE id=?;";
            PreparedStatement st = this.getConexion().prepareStatement(consultaSQL);
            establecerParametrosConsulta(st, p);
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

    public ArrayList<Proveedor> listar(String criterio) throws Exception {
        ArrayList<Proveedor> listaP = new ArrayList<>();
        String sentenciaSQL = "";

        if (criterio.equals("Todos")) {
            sentenciaSQL = "SELECT * FROM PROVEEDOR ORDER BY id";
        } else if (criterio.equals("Activos")) {
            sentenciaSQL = "SELECT * FROM PROVEEDOR WHERE estado='activo' ORDER BY id;";
        }
        try {
            this.conectar();
            PreparedStatement st = this.getConexion().prepareStatement(sentenciaSQL);
            ResultSet resultado = st.executeQuery();
            llenarListaProveedor(resultado, listaP);
            resultado.close();
            st.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return listaP;
    }

    public ArrayList<Proveedor> buscar(String cadena, String criterio) throws Exception {

        ArrayList<Proveedor> listaP = new ArrayList<>();
        String sentenciaSQL = "";

        if (criterio.equalsIgnoreCase("General")) {
            sentenciaSQL = "SELECT * FROM PROVEEDOR WHERE cast(id as varchar(3)) LIKE '" + cadena + "' OR nombre LIKE '" + cadena + "%' OR direccion LIKE '"
                    + cadena + "%' OR estado LIKE '" + cadena + "%' ORDER BY id;";
        } else if (criterio.equalsIgnoreCase("Activos")) {
            sentenciaSQL = "SELECT * FROM PROVEEDOR WHERE (cast(id as varchar(3)) LIKE '" + cadena + "' OR nombre LIKE '" + cadena + "%' OR direccion LIKE '"
                    + cadena + "%') AND estado='activo' ORDER BY id;";
        }
        try {
            this.conectar();
            PreparedStatement st = this.getConexion().prepareStatement(sentenciaSQL);
            ResultSet resultado = st.executeQuery();
            llenarListaProveedor(resultado, listaP);
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

    public void establecerParametrosConsulta(PreparedStatement st, Proveedor prov) {
        try {
            st.setString(1, prov.getNombre());
            st.setString(2, prov.getDireccion());
            st.setString(3, prov.getEstado());
        } catch (SQLException ex) {
            Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void llenarListaProveedor(ResultSet resultado, ArrayList<Proveedor> listaP) {
        try {
            while (resultado.next()) {
                Proveedor prov = new Proveedor();
                prov.setId(resultado.getInt("id"));
                prov.setNombre(resultado.getString("nombre"));
                prov.setDireccion(resultado.getString("direccion"));
                prov.setEstado(resultado.getString("estado"));
                listaP.add(prov);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String insertarTelefono(Telefono_Proveedor tel_proveedor) throws Exception {
        String res = null;
        try {
            this.conectar();
            PreparedStatement st = this.getConexion().prepareStatement("INSERT INTO TELEFONO_PROVEEDOR VALUES(?,?);");
            st.setInt(1, tel_proveedor.getId_proveedor());
            st.setString(2, tel_proveedor.getTelefono());
            int num = st.executeUpdate();
            if (num > 0) {
                res = "Teléfono registrado con exito.";
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return res;
    }

    public ArrayList<Telefono_Proveedor> listarTelefonos(int id) throws Exception {
        ArrayList<Telefono_Proveedor> listaP = new ArrayList<>();
        String sentenciaSQL = "";
        sentenciaSQL = "SELECT * FROM TELEFONO_PROVEEDOR WHERE id_proveedor=" + id + ";";
        try {
            this.conectar();
            PreparedStatement st = this.getConexion().prepareStatement(sentenciaSQL);
            ResultSet resultado = st.executeQuery();
            while (resultado.next()) {
                Telefono_Proveedor tel = new Telefono_Proveedor();
                tel.setId_proveedor(resultado.getInt("id_proveedor"));
                tel.setTelefono(resultado.getString("telefono"));
                listaP.add(tel);
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

    public String eliminarTelefono(String telefono) throws Exception {
        String res = null;
        try {
            this.conectar();
            PreparedStatement st = this.getConexion().prepareStatement("DELETE FROM TELEFONO_PROVEEDOR WHERE telefono='" + telefono + "';");
            int num = st.executeUpdate();
            if (num > 0) {
                res = "Teléfono eliminado con exito.";
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return res;
    }

    public int retornarCantRegistrosTelefono(int id) throws Exception {

        String sentenciaSQL = "SELECT consultar_telefono_prov(" + id + ");";
        int cantRegistros = 0;
        try {
            this.conectar();
            PreparedStatement st = this.getConexion().prepareStatement(sentenciaSQL);
            ResultSet resultado = st.executeQuery();
            while (resultado.next()) {
                cantRegistros = resultado.getInt("consultar_telefono_prov");
            }
            resultado.close();
            st.close();
        } catch (ClassNotFoundException | SQLException e) {

        } finally {
            this.desconectar();
        }
        return cantRegistros;
    }

    public String insertarPersonaDeContacto(PersonaDeContacto pc, int id_prov) throws Exception {
        String res = null;
        try {
            this.conectar();
            PreparedStatement st = this.getConexion().prepareStatement("INSERT INTO PERSONA_CONTACTO(nombre, telefono, id_proveedor) VALUES(?,?,?);");
            st.setString(1, pc.getNombre());
            st.setString(2, pc.getTelefono());
            st.setInt(3, id_prov);
            int num = st.executeUpdate();
            if (num > 0) {
                res = "Persona de contacto registrada con exito.";
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return res;
    }

    public ArrayList<PersonaDeContacto> listarPC(int id) throws Exception {
        ArrayList<PersonaDeContacto> listaP = new ArrayList<>();
        String sentenciaSQL = "";
        sentenciaSQL = "SELECT * FROM PERSONA_CONTACTO WHERE id_proveedor=" + id + ";";
        try {
            this.conectar();
            PreparedStatement st = this.getConexion().prepareStatement(sentenciaSQL);
            ResultSet resultado = st.executeQuery();
            while (resultado.next()) {
                PersonaDeContacto pc = new PersonaDeContacto();
                pc.setId(resultado.getInt("id"));
                pc.setNombre(resultado.getString("nombre"));
                pc.setTelefono(resultado.getString("telefono"));
                listaP.add(pc);
            }
            resultado.close();
            st.close();

        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return listaP;
    }

    public String modificarPC(PersonaDeContacto pc, int id_mod) throws Exception {
        String res = null;
        try {
            this.conectar();
            PreparedStatement st = this.getConexion().prepareStatement("UPDATE PERSONA_CONTACTO SET nombre=?, telefono=? WHERE id_proveedor=?;");
            st.setString(1, pc.getNombre());
            st.setString(2, pc.getTelefono());
            st.setInt(3, id_mod);
            int num = st.executeUpdate();
            if (num > 0) {
                res = "Persona de contacto modificada con exito";
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return res;
    }

    public String eliminarrPC(int id_pc) throws Exception {
        String res = null;
        try {
            this.conectar();
            PreparedStatement st = this.getConexion().prepareStatement("DELETE FROM PERSONA_CONTACTO WHERE id=" + id_pc + ";");
            int num = st.executeUpdate();
            if (num > 0) {
                res = "Persona de contacto eliminada con exito";
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return res;
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
