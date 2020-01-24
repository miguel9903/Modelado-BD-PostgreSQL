package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOCliente extends Conexion {

    public String registrar(Cliente cliente) throws Exception {
        String res = null;
        try {
            this.conectar();
            PreparedStatement st = this.getConexion().prepareStatement("INSERT INTO CLIENTE(nombre, direccion, correo, estado) VALUES(?,?,?,?);");
            establecerParametrosConsulta(st, cliente);
            int num = st.executeUpdate();
            if (num > 0) {
                res = "Cliente registrado con exiro.";
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return res;
    }

    public String modificar(Cliente cliente, int id_mod) throws Exception {
        String res = null;
        String consultaSQL = "";
        try {
            this.conectar();
            consultaSQL = "UPDATE CLIENTE SET nombre=?, direccion=?, correo=?, estado=?  WHERE id=?;";
            PreparedStatement st = this.getConexion().prepareStatement(consultaSQL);
            establecerParametrosConsulta(st, cliente);
            st.setInt(5, id_mod);
            int num = st.executeUpdate();
            if (num > 0) {
                res = "Modificacion exitosa";
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return res;
    }

    public ArrayList<Cliente> listar(String criterio) throws Exception {
        ArrayList<Cliente> listaP = new ArrayList<>();
        String sentenciaSQL = "";
        PreparedStatement st = null;
        ResultSet resultado = null;

        try {
            this.conectar();
            if (criterio.equals("Todos")) {
                sentenciaSQL = "SELECT * FROM CLIENTE ORDER BY id";
                st = this.getConexion().prepareStatement(sentenciaSQL);
                resultado = st.executeQuery();
                llenarListaCliente(resultado, listaP);
            } else if (criterio.equals("Activos")) {
                sentenciaSQL = "SELECT * FROM CLIENTE WHERE estado='activo' ORDER BY id;";
                st = this.getConexion().prepareStatement(sentenciaSQL);
                resultado = st.executeQuery();
                llenarListaCliente(resultado, listaP);
            } else if (criterio.equals("Cliente_Venta")) {
                sentenciaSQL = "SELECT id, nombre, direccion, correo, estado FROM CLIENTE ORDER BY id;";
                st = this.getConexion().prepareStatement(sentenciaSQL);
                resultado = st.executeQuery();
                llenarListaClienteVentas(resultado, listaP);
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

    public ArrayList<Cliente> buscar(String cadena, String criterio) throws Exception {

        ArrayList<Cliente> listaP = new ArrayList<>();
        String sentenciaSQL = "";

        if (criterio.equalsIgnoreCase("General")) {
            sentenciaSQL = "SELECT * FROM CLIENTE WHERE cast(id as varchar(3)) LIKE '" + cadena + "' OR nombre LIKE '" + cadena + "%' OR direccion LIKE '"
                    + cadena + "%' OR correo LIKE '" + cadena + "%' OR estado LIKE '" + cadena + "%' ORDER BY id;";
        } else if (criterio.equalsIgnoreCase("Activos")) {
            sentenciaSQL = "SELECT * FROM CLIENTE WHERE (cast(id as varchar(3)) LIKE '" + cadena + "' OR nombre LIKE '" + cadena + "%' OR direccion LIKE '"
                    + cadena + "%' OR correo LIKE '" + cadena + "%') AND estado='activo' ORDER BY id;";
        }

        try {
            this.conectar();
            PreparedStatement st = this.getConexion().prepareStatement(sentenciaSQL);
            ResultSet resultado = st.executeQuery();
            llenarListaCliente(resultado, listaP);
            resultado.close();
            st.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return listaP;
    }

    public void llenarListaCliente(ResultSet resultado, ArrayList<Cliente> listaP) {
        try {
            while (resultado.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(resultado.getInt("id"));
                cliente.setNombre(resultado.getString("nombre"));
                cliente.setDireccion(resultado.getString("direccion"));
                cliente.setCorreo(resultado.getString("correo"));
                cliente.setEstado(resultado.getString("estado"));
                listaP.add(cliente);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void llenarListaClienteVentas(ResultSet resultado, ArrayList<Cliente> listaP) {
        try {
            while (resultado.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(resultado.getInt("id"));
                cliente.setNombre(resultado.getString("nombre"));
                cliente.setDireccion(resultado.getString("direccion"));
                cliente.setCorreo(resultado.getString("correo"));
                cliente.setEstado(resultado.getString("estado"));
                listaP.add(cliente);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void establecerParametrosConsulta(PreparedStatement st, Cliente cliente) {
        try {
            st.setString(1, cliente.getNombre());
            st.setString(2, cliente.getDireccion());
            st.setString(3, cliente.getCorreo());
            st.setString(4, cliente.getEstado());
        } catch (SQLException ex) {
            Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int retornarMax() throws Exception {

        String sentenciaSQL = "SELECT MAX(id) FROM CLIENTE;";
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

    //TELEFONO CLIENTE
    public String insertarTelefono(Telefono_Cliente tel_cliente) throws Exception {
        String res = null;
        String consultaSQL = "";
        try {
            this.conectar();
            consultaSQL = "INSERT INTO TELEFONO_CLIENTE VALUES(?,?);";
            PreparedStatement st = this.getConexion().prepareStatement(consultaSQL);
            st.setInt(1, tel_cliente.getId_cliente());
            st.setString(2, tel_cliente.getTelefono());
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

    public ArrayList<Telefono_Cliente> listarTelefonos(int id) throws Exception {
        ArrayList<Telefono_Cliente> listaP = new ArrayList<>();
        String sentenciaSQL = "";
        sentenciaSQL = "SELECT * FROM TELEFONO_CLIENTE WHERE id_cliente=" + id + ";";
        try {
            this.conectar();
            PreparedStatement st = this.getConexion().prepareStatement(sentenciaSQL);
            ResultSet resultado = st.executeQuery();
            while (resultado.next()) {
                Telefono_Cliente tel = new Telefono_Cliente();
                tel.setId_cliente(resultado.getInt("id_cliente"));
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
            PreparedStatement st = this.getConexion().prepareStatement("DELETE FROM TELEFONO_CLIENTE WHERE telefono='" + telefono + "';");
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

        String sentenciaSQL = "SELECT consultar_telefono_cliente(" + id + ");";
        int cantRegistros = 0;
        try {
            this.conectar();
            PreparedStatement st = this.getConexion().prepareStatement(sentenciaSQL);
            ResultSet resultado = st.executeQuery();
            while (resultado.next()) {
                cantRegistros = resultado.getInt("consultar_telefono_cliente");
            }
            resultado.close();
            st.close();
        } catch (ClassNotFoundException | SQLException e) {

        } finally {
            this.desconectar();
        }
        return cantRegistros;
    }
}
