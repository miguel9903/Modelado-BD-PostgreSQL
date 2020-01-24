package modelo;

import java.awt.Toolkit;
import javax.swing.JTextArea;

import javax.swing.JTextField;

public class Validaciones {

   public static boolean validarCampoTexto(JTextField etiqueta) {

      boolean val = false;

      if (etiqueta.getText().equals("")) {

         val = true;
      }
      return val;
   }

   public static boolean validarAreaTexto(JTextArea area) {

      boolean val = false;

      if (area.getText().equals("")) {

         val = true;
      }
      return val;
   }

   public static void sonar() {
      Toolkit t = Toolkit.getDefaultToolkit();
      t.beep();
   }

   public static boolean validarCampoNumerico(String cadena) {
      boolean validacion;
      try {
         Double.parseDouble(cadena);
         validacion = true;
      } catch (NumberFormatException e) {
         validacion = false;
      }
      return validacion;
   }

   public static boolean validarCadena(String cadena) {

      boolean val = false;

      if (cadena.equals("")) {

         val = true;
      }
      return val;
   }

}
