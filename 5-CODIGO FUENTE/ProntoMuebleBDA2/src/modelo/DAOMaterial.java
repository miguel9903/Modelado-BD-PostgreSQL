package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAOMaterial extends Conexion  {
    public String registrar(Material material) throws Exception {
        String res = null;
        try {
            this.conectar();
            PreparedStatement st = this.getConexion().prepareStatement("INSERT INTO MATERIAL(material) VALUES(?);");
            st.setString(1, material.getMaterial());
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

    public ArrayList<Material> listar() throws Exception {
        ArrayList<Material> listaP = new ArrayList<>();
        String sentenciaSQL = "";

        sentenciaSQL = "SELECT * FROM MATERIAL ORDER BY id;";

        try {
            this.conectar();
            PreparedStatement st = this.getConexion().prepareStatement(sentenciaSQL);
            ResultSet resultado = st.executeQuery();
            while (resultado.next()) {
                Material material = new Material();
                material.setId(resultado.getInt("id"));
                material.setMaterial(resultado.getString("material"));
                listaP.add(material);
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

    public ArrayList<Material> buscar(String cadena, String criterio) throws Exception {
      ArrayList<Material> listaP = new ArrayList<>();
        String sentenciaSQL = "";

        if (criterio.equalsIgnoreCase("Id")) {
            sentenciaSQL = "SELECT * FROM MATERIAL WHERE id=" + Integer.parseInt(cadena) + ";";
        } else if (criterio.equalsIgnoreCase("TipoMueble")) {
            sentenciaSQL = "SELECT * FROM MATERIAL WHERE material='" + cadena + "';";
        }

        try {
            this.conectar();
            PreparedStatement st = this.getConexion().prepareStatement(sentenciaSQL);
            ResultSet resultado = st.executeQuery();
            while (resultado.next()) {
                Material material=new Material();
                material.setId(resultado.getInt("id"));
                material.setMaterial(resultado.getString("material"));
                listaP.add(material);
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
