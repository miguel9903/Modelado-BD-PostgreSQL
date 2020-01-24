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
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author ASUS
 */
public class FormularioModificarProv extends javax.swing.JInternalFrame {

    /**
     * Creates new form AgregarProv
     */
    public FormularioModificarProv() {
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

        panelProveedor = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtIdProv = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNombreProv = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtDireccionProv = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        botonLimpiarFormulario = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        botonModificarProveedor = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        comboEstado = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPerContacto = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        botonAgregarPC = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel17 = new javax.swing.JLabel();
        botonEliminarPC = new javax.swing.JButton();
        botonModificarPC = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        botonActualizarPC = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        botonAgregarTelefono = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        comboTelefono = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        botonEliminarTelefono = new javax.swing.JButton();
        botonCerrarVentana = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        tituloModificar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setTitle("Formulario Modificar Proveedor");

        panelProveedor.setBackground(new java.awt.Color(41, 128, 185));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(52, 152, 219), 2));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setText("Id:");

        txtIdProv.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(105, 198, 230), 2, true));
        txtIdProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdProvActionPerformed(evt);
            }
        });
        txtIdProv.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdProvKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setText("Nombre:");

        txtNombreProv.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(105, 198, 230), 2, true));
        txtNombreProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreProvActionPerformed(evt);
            }
        });
        txtNombreProv.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreProvKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setText("Direccion:");

        txtDireccionProv.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(105, 198, 230), 2, true));
        txtDireccionProv.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDireccionProvKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setText("Ingrese los datos a modificar:");

        botonLimpiarFormulario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/borrarFormulario.png"))); // NOI18N
        botonLimpiarFormulario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonLimpiarFormularioActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel10.setText("Limpiar campos");

        botonModificarProveedor.setText("Modificar");
        botonModificarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonModificarProveedorActionPerformed1(evt);
            }
        });

        jSeparator6.setBackground(new java.awt.Color(52, 152, 219));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel7.setText("Estado:");

        comboEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(botonLimpiarFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonModificarProveedor))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)
                        .addGap(0, 221, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jSeparator6)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombreProv, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdProv, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDireccionProv, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIdProv, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombreProv, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDireccionProv, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(comboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(botonLimpiarFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(botonModificarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Datos Generales", jPanel2);

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(52, 152, 219), 2));

        tablaPerContacto = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        tablaPerContacto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaPerContacto);

        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel15.setText("Agregar persona de contacto:");
        jLabel15.setToolTipText("");

        botonAgregarPC.setText("Agregar");
        botonAgregarPC.setToolTipText("");
        botonAgregarPC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarPCActionPerformed(evt);
            }
        });

        jSeparator5.setBackground(new java.awt.Color(52, 152, 219));

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel17.setText("Eliminar / Modificar");
        jLabel17.setToolTipText("");

        botonEliminarPC.setText("Eliminar");
        botonEliminarPC.setToolTipText("");
        botonEliminarPC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarPCActionPerformed(evt);
            }
        });

        botonModificarPC.setText("Modificar");
        botonModificarPC.setToolTipText("");
        botonModificarPC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonModificarPCActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel16.setText("Seleccione el registro a eliminar/modificar:");
        jLabel16.setToolTipText("");

        botonActualizarPC.setText("Actualizar tabla");
        botonActualizarPC.setToolTipText("");
        botonActualizarPC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActualizarPCActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator5)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonAgregarPC))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(botonActualizarPC)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonEliminarPC)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonModificarPC))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel16))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(botonAgregarPC))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonEliminarPC)
                    .addComponent(botonModificarPC)
                    .addComponent(botonActualizarPC))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Persona de contacto", jPanel5);

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(52, 152, 219), 2));

        botonAgregarTelefono.setText("Agregar");
        botonAgregarTelefono.setToolTipText("");
        botonAgregarTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarTelefonoActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel11.setText("Telefono:");

        jSeparator4.setBackground(new java.awt.Color(52, 152, 219));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel12.setText("Eliminar Telefono");
        jLabel12.setToolTipText("");

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel13.setText("Telefono:");

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel14.setText("Agregar Telefono");
        jLabel14.setToolTipText("");

        botonEliminarTelefono.setText("Eliminar");
        botonEliminarTelefono.setToolTipText("");
        botonEliminarTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarTelefonoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator4)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(botonAgregarTelefono))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(18, 18, 18)
                                .addComponent(comboTelefono, 0, 247, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(botonEliminarTelefono)))
                        .addContainerGap())))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(botonAgregarTelefono))
                .addGap(18, 18, 18)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(comboTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonEliminarTelefono))
                .addContainerGap(103, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Telefono", jPanel4);

        botonCerrarVentana.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconoEliminar.png"))); // NOI18N
        botonCerrarVentana.setText("Cerrar");
        botonCerrarVentana.setToolTipText("");
        botonCerrarVentana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCerrarVentanaActionPerformed1(evt);
            }
        });

        javax.swing.GroupLayout panelProveedorLayout = new javax.swing.GroupLayout(panelProveedor);
        panelProveedor.setLayout(panelProveedorLayout);
        panelProveedorLayout.setHorizontalGroup(
            panelProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProveedorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelProveedorLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(botonCerrarVentana)))
                .addContainerGap())
        );
        panelProveedorLayout.setVerticalGroup(
            panelProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProveedorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonCerrarVentana)
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(41, 128, 185));

        tituloModificar.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        tituloModificar.setForeground(new java.awt.Color(255, 255, 255));
        tituloModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/modificarProv.png"))); // NOI18N
        tituloModificar.setText("MODIFICAR PROVEEDOR");
        tituloModificar.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tituloModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tituloModificar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   private void botonModificarProveedorActionPerformed1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonModificarProveedorActionPerformed1
      // TODO add your handling code here:
   }//GEN-LAST:event_botonModificarProveedorActionPerformed1

   private void botonCerrarVentanaActionPerformed1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCerrarVentanaActionPerformed1
      // TODO add your handling code here:
   }//GEN-LAST:event_botonCerrarVentanaActionPerformed1

   private void botonLimpiarFormularioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLimpiarFormularioActionPerformed
      // TODO add your handling code here:
   }//GEN-LAST:event_botonLimpiarFormularioActionPerformed

   private void txtDireccionProvKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionProvKeyTyped
      // TODO add your handling code here:
   }//GEN-LAST:event_txtDireccionProvKeyTyped

   private void txtNombreProvKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreProvKeyTyped
      // TODO add your handling code here:
      char validacion = evt.getKeyChar();
      if (Character.isDigit(validacion)) {
         getToolkit().beep();
         evt.consume();

         JOptionPane.showMessageDialog(null, "Ingrese solo caracteres");
      }
   }//GEN-LAST:event_txtNombreProvKeyTyped

   private void txtNombreProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreProvActionPerformed
      // TODO add your handling code here:
   }//GEN-LAST:event_txtNombreProvActionPerformed

   private void txtIdProvKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdProvKeyTyped
      // TODO add your handling code here:
   }//GEN-LAST:event_txtIdProvKeyTyped

   private void txtIdProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdProvActionPerformed
      // TODO add your handling code here:
   }//GEN-LAST:event_txtIdProvActionPerformed

    private void botonAgregarTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonAgregarTelefonoActionPerformed

    private void botonEliminarTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonEliminarTelefonoActionPerformed

    private void botonAgregarPCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarPCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonAgregarPCActionPerformed

    private void botonEliminarPCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarPCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonEliminarPCActionPerformed

    private void botonModificarPCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonModificarPCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonModificarPCActionPerformed

    private void botonActualizarPCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarPCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonActualizarPCActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonActualizarPC;
    private javax.swing.JButton botonAgregarPC;
    private javax.swing.JButton botonAgregarTelefono;
    private javax.swing.JButton botonCerrarVentana;
    private javax.swing.JButton botonEliminarPC;
    private javax.swing.JButton botonEliminarTelefono;
    private javax.swing.JButton botonLimpiarFormulario;
    private javax.swing.JButton botonModificarPC;
    private javax.swing.JButton botonModificarProveedor;
    private javax.swing.JComboBox<String> comboEstado;
    private javax.swing.JComboBox<String> comboTelefono;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel panelProveedor;
    private javax.swing.JTable tablaPerContacto;
    private javax.swing.JLabel tituloModificar;
    private javax.swing.JTextField txtDireccionProv;
    private javax.swing.JTextField txtIdProv;
    private javax.swing.JTextField txtNombreProv;
    // End of variables declaration//GEN-END:variables




    public JButton getBotonLimpiarFormulario() {
        return botonLimpiarFormulario;
    }

    public void setBotonLimpiarFormulario(JButton botonLimpiarFormulario) {
        this.botonLimpiarFormulario = botonLimpiarFormulario;
    }

    public JButton getBotonModificarProveedor() {
        return botonModificarProveedor;
    }

    public void setBotonModificarProveedor(JButton botonModificarProveedor) {
        this.botonModificarProveedor = botonModificarProveedor;
    }


    public JComboBox<String> getComboEstado() {
        return comboEstado;
    }

    public void setComboEstado(JComboBox<String> comboEstado) {
        this.comboEstado = comboEstado;
    }


   public JButton getBotonCerrarVentana() {
      return botonCerrarVentana;
   }

   public void setBotonCerrarVentana(JButton botonCerrarVentana) {
      this.botonCerrarVentana = botonCerrarVentana;
   }

    public JTextField getTxtDireccionProv() {
        return txtDireccionProv;
    }

    public void setTxtDireccionProv(JTextField txtDireccionProv) {
        this.txtDireccionProv = txtDireccionProv;
    }

    public JTextField getTxtIdProv() {
        return txtIdProv;
    }

    public void setTxtIdProv(JTextField txtIdProv) {
        this.txtIdProv = txtIdProv;
    }

    public JTextField getTxtNombreProv() {
        return txtNombreProv;
    }

    public void setTxtNombreProv(JTextField txtNombreProv) {
        this.txtNombreProv = txtNombreProv;
    }

    public JButton getBotonAgregarTelefono() {
        return botonAgregarTelefono;
    }

    public void setBotonAgregarTelefono(JButton botonAgregarTelefono) {
        this.botonAgregarTelefono = botonAgregarTelefono;
    }

    public JButton getBotonEliminarTelefono() {
        return botonEliminarTelefono;
    }

    public void setBotonEliminarTelefono(JButton botonEliminarTelefono) {
        this.botonEliminarTelefono = botonEliminarTelefono;
    }

    public JComboBox<String> getComboTelefono() {
        return comboTelefono;
    }

    public void setComboTelefono(JComboBox<String> comboTelefono) {
        this.comboTelefono = comboTelefono;
    }

    public JLabel getTituloModificar() {
        return tituloModificar;
    }

    public void setTituloModificar(JLabel tituloModificar) {
        this.tituloModificar = tituloModificar;
    }

    public JButton getBotonAgregarPC() {
        return botonAgregarPC;
    }

    public void setBotonAgregarPC(JButton botonAgregarPC) {
        this.botonAgregarPC = botonAgregarPC;
    }

    public JButton getBotonEliminarPC() {
        return botonEliminarPC;
    }

    public void setBotonEliminarPC(JButton botonEliminarPC) {
        this.botonEliminarPC = botonEliminarPC;
    }

    public JButton getBotonModificarPC() {
        return botonModificarPC;
    }

    public void setBotonModificarPC(JButton botonModificarPC) {
        this.botonModificarPC = botonModificarPC;
    }

    public JTable getTablaPerContacto() {
        return tablaPerContacto;
    }

    public void setTablaPerContacto(JTable tablaPerContacto) {
        this.tablaPerContacto = tablaPerContacto;
    }

    public JButton getBotonActualizarPC() {
        return botonActualizarPC;
    }

    public void setBotonActualizarPC(JButton botonActualizarPC) {
        this.botonActualizarPC = botonActualizarPC;
    }
    
}
