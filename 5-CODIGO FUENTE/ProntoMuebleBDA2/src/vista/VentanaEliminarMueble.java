/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author ASUS
 */
public class VentanaEliminarMueble extends javax.swing.JInternalFrame {

    /**
     * Creates new form AgregarProv
     */
    public VentanaEliminarMueble() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        txtBuscarMueble = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaBuscarMueble = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        botonActualizarMueble = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        botonCerrarVentana = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        botonBuscar = new javax.swing.JButton();
        botonRefrescar = new javax.swing.JButton();
        botonAceptarEliminar = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        tituloVentana = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setTitle("Eliminar Mueble");

        jPanel1.setBackground(new java.awt.Color(41, 128, 185));

        jPanel8.setBackground(new java.awt.Color(248, 249, 249));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(52, 152, 219), 4));

        txtBuscarMueble.setToolTipText("");
        txtBuscarMueble.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(52, 152, 219), 2));
        txtBuscarMueble.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarMuebleKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarMuebleKeyTyped(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel13.setText("Ingrese el id o la descripcion:");

        tablaBuscarMueble = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        tablaBuscarMueble.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(52, 152, 219), 2));
        tablaBuscarMueble.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaBuscarMueble);
        if (tablaBuscarMueble.getColumnModel().getColumnCount() > 0) {
            tablaBuscarMueble.getColumnModel().getColumn(0).setResizable(false);
            tablaBuscarMueble.getColumnModel().getColumn(1).setResizable(false);
            tablaBuscarMueble.getColumnModel().getColumn(2).setResizable(false);
            tablaBuscarMueble.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel14.setText("Lista de Muebles");
        jLabel14.setToolTipText("");

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel15.setText("Busqueda de clientes:");
        jLabel15.setToolTipText("");

        jLabel17.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel17.setText("Por favor seleccione el mueble que desea eliminar:");
        jLabel17.setToolTipText("");

        botonActualizarMueble.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconoActualizar2.png"))); // NOI18N
        botonActualizarMueble.setText("Actualizar");
        botonActualizarMueble.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActualizarMuebleActionPerformed(evt);
            }
        });

        jSeparator4.setBackground(new java.awt.Color(52, 152, 219));

        jSeparator5.setBackground(new java.awt.Color(52, 152, 219));

        botonCerrarVentana.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconoEliminar.png"))); // NOI18N
        botonCerrarVentana.setText("Cerrar");
        botonCerrarVentana.setToolTipText("");

        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel16.setText("Filtrar por:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tipo de mueble", "Material", "Color", "Estado" }));

        botonBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b2.png"))); // NOI18N
        botonBuscar.setText("Buscar");

        botonRefrescar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconoRefrescar.png"))); // NOI18N
        botonRefrescar.setToolTipText("Refrescar Registros");

        botonAceptarEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconoEliminar.png"))); // NOI18N
        botonAceptarEliminar.setText("Eliminar");
        botonAceptarEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAceptarEliminarActionPerformed1(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator4)
            .addComponent(jSeparator5)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1056, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBuscarMueble, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonRefrescar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonBuscar))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel17)
                            .addComponent(jLabel15))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(botonActualizarMueble)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonCerrarVentana)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonAceptarEliminar)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addGap(13, 13, 13)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtBuscarMueble, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13))
                    .addComponent(botonRefrescar)
                    .addComponent(botonBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel16)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonActualizarMueble, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(botonCerrarVentana)
                        .addComponent(botonAceptarEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(41, 128, 185));

        tituloVentana.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        tituloVentana.setForeground(new java.awt.Color(255, 255, 255));
        tituloVentana.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/eliminarMueble.png"))); // NOI18N
        tituloVentana.setText("ELIMINAR MUEBLE");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tituloVentana, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tituloVentana)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarMuebleKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarMuebleKeyTyped
        // TODO add your handling code here:

    }//GEN-LAST:event_txtBuscarMuebleKeyTyped

    private void txtBuscarMuebleKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarMuebleKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarMuebleKeyPressed

    private void botonActualizarMuebleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarMuebleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonActualizarMuebleActionPerformed

    private void botonAceptarEliminarActionPerformed1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAceptarEliminarActionPerformed1
        // TODO add your handling code here:
    }//GEN-LAST:event_botonAceptarEliminarActionPerformed1


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAceptarEliminar;
    private javax.swing.JButton botonActualizarMueble;
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonCerrarVentana;
    private javax.swing.JButton botonRefrescar;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTable tablaBuscarMueble;
    private javax.swing.JLabel tituloVentana;
    private javax.swing.JTextField txtBuscarMueble;
    // End of variables declaration//GEN-END:variables



    public JButton getBotonActualizarMueble() {
        return botonActualizarMueble;
    }

    public void setBotonActualizarMueble(JButton botonActualizarMueble) {
        this.botonActualizarMueble = botonActualizarMueble;
    }



    public JTable getTablaBuscarMueble() {
        return tablaBuscarMueble;
    }

    public void setTablaBuscarMueble(JTable tablaBuscarMueble) {
        this.tablaBuscarMueble = tablaBuscarMueble;
    }

    public JTextField getTxtBuscarMueble() {
        return txtBuscarMueble;
    }

    public void setTxtBuscarMueble(JTextField txtBuscarMueble) {
        this.txtBuscarMueble = txtBuscarMueble;
    }

    public JButton getBotonBuscar() {
        return botonBuscar;
    }

    public void setBotonBuscar(JButton botonBuscar) {
        this.botonBuscar = botonBuscar;
    }

    public JButton getBotonCerrarVentana() {
        return botonCerrarVentana;
    }

    public void setBotonCerrarVentana(JButton botonCerrarVentana) {
        this.botonCerrarVentana = botonCerrarVentana;
    }

    public JButton getBotonRefrescar() {
        return botonRefrescar;
    }

    public void setBotonRefrescar(JButton botonRefrescar) {
        this.botonRefrescar = botonRefrescar;
    }

   public JLabel getTituloVentana() {
      return tituloVentana;
   }

   public void setTituloVentana(JLabel tituloVentana) {
      this.tituloVentana = tituloVentana;
   }

    public JButton getBotonAceptarEliminar() {
        return botonAceptarEliminar;
    }

    public void setBotonAceptarEliminar(JButton botonAceptarEliminar) {
        this.botonAceptarEliminar = botonAceptarEliminar;
    }

    
}
