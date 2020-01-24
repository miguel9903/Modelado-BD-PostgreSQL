package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAOTipo_Mueble extends Conexion {

    public String registrar(Tipo_Mueble mueble) throws Exception {
        String res = null;
        try {
            this.conectar();
            PreparedStatement st = this.getConexion().prepareStatement("INSERT INTO TIPO_MUEBLE(tipo_mueble) VALUES(?);");
            st.setString(1, mueble.getTipo_mueble());
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

    public ArrayList<Tipo_Mueble> listar() throws Exception {
        ArrayList<Tipo_Mueble> listaP = new ArrayList<>();
        String sentenciaSQL = "";

        sentenciaSQL = "SELECT * FROM TIPO_MUEBLE ORDER BY id;";

        try {
            this.conectar();
            PreparedStatement st = this.getConexion().prepareStatement(sentenciaSQL);
            ResultSet resultado = st.executeQuery();
            while (resultado.next()) {
                Tipo_Mueble tipo_mueble = new Tipo_Mueble();
                tipo_mueble.setId(resultado.getInt("id"));
                tipo_mueble.setTipo_mueble(resultado.getString("tipo_mueble"));
                listaP.add(tipo_mueble);
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

    public ArrayList<Tipo_Mueble> buscar(String cadena, String criterio) throws Exception {

        ArrayList<Tipo_Mueble> listaP = new ArrayList<>();
        String sentenciaSQL = "";

        if (criterio.equalsIgnoreCase("Id")) {
            sentenciaSQL = "SELECT * FROM TIPO_MUEBLE WHERE id=" + Integer.parseInt(cadena) + ";";
        } else if (criterio.equalsIgnoreCase("TipoMueble")) {
            sentenciaSQL = "SELECT * FROM TIPO_MUEBLE WHERE tipo_mueble='" + cadena + "';";
        }// else if (criterio.equalsIgnoreCase("BuscarNombreId")) {
        //  sentenciaSQL = "SELECT tipo_mueble FROM TIPO_MUEBLE WHERE id=" + Integer.parseInt(cadena) + ";";
        // }

        try {
            this.conectar();
            PreparedStatement st = this.getConexion().prepareStatement(sentenciaSQL);
            ResultSet resultado = st.executeQuery();
            while (resultado.next()) {
                Tipo_Mueble tipo_mueble = new Tipo_Mueble();
                tipo_mueble.setId(resultado.getInt("id"));
                tipo_mueble.setTipo_mueble(resultado.getString("tipo_mueble"));
                listaP.add(tipo_mueble);
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

}
