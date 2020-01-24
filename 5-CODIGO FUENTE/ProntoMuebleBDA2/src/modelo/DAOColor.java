package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAOColor extends Conexion {

    public String registrar(Color color) throws Exception {
        String res = null;
        try {
            this.conectar();
            PreparedStatement st = this.getConexion().prepareStatement("INSERT INTO COLOR(color) VALUES(?);");
            st.setString(1, color.getColor());
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

    public ArrayList<Color> listar() throws Exception {
        ArrayList<Color> listaP = new ArrayList<>();
        String sentenciaSQL = "";

        sentenciaSQL = "SELECT * FROM COLOR ORDER BY id;";

        try {
            this.conectar();
            PreparedStatement st = this.getConexion().prepareStatement(sentenciaSQL);
            ResultSet resultado = st.executeQuery();
            while (resultado.next()) {
                Color color = new Color();
                color.setId(resultado.getInt("id"));
                color.setColor(resultado.getString("color"));
                listaP.add(color);
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

    public ArrayList<Color> buscar(String cadena, String criterio) throws Exception {
        ArrayList<Color> listaP = new ArrayList<>();
        String sentenciaSQL = "";

        if (criterio.equalsIgnoreCase("Id")) {
            sentenciaSQL = "SELECT * FROM COLOR WHERE id=" + Integer.parseInt(cadena) + ";";
        } else if (criterio.equalsIgnoreCase("TipoMueble")) {
            sentenciaSQL = "SELECT * FROM COLOR WHERE color='" + cadena + "';";
        }

        try {
            this.conectar();
            PreparedStatement st = this.getConexion().prepareStatement(sentenciaSQL);
            ResultSet resultado = st.executeQuery();
            while (resultado.next()) {
                Color color = new Color();
                color.setId(resultado.getInt("id"));
                color.setColor(resultado.getString("color"));
                listaP.add(color);
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
