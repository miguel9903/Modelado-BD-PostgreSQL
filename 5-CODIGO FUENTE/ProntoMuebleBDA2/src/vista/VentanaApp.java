/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 *
 * @author ASUS
 */
public class VentanaApp extends javax.swing.JFrame {

    /**
     * Creates new form VentanaApp
     */
    public VentanaApp() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        escritorio = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        menuOpc = new javax.swing.JMenuBar();
        menuClientes = new javax.swing.JMenu();
        itemRegistrarCliente = new javax.swing.JMenuItem();
        itemModificarCliente = new javax.swing.JMenuItem();
        itemEliminarCliente = new javax.swing.JMenuItem();
        itemListarCliente = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        itemRegistrarMueble = new javax.swing.JMenuItem();
        itemModificarMueble = new javax.swing.JMenuItem();
        itemEliminarMueble = new javax.swing.JMenuItem();
        itemListarMueble = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        itemRegistrarProveedor = new javax.swing.JMenuItem();
        itemModificarProveedor = new javax.swing.JMenuItem();
        itemEliminarProveedor = new javax.swing.JMenuItem();
        itemListarProveedor = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        itemRegistrarVendedor = new javax.swing.JMenuItem();
        itemModificarVendedor = new javax.swing.JMenuItem();
        itemEliminarVendedor = new javax.swing.JMenuItem();
        itemListarVendedor = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        itemRealizarVenta = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        itemRealizarVenta1 = new javax.swing.JMenuItem();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ProntoMueble");

        escritorio.setBackground(new java.awt.Color(51, 158, 228));

        escritorio.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, escritorioLayout.createSequentialGroup()
                .addContainerGap(148, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 876, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(140, 140, 140))
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escritorioLayout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(jLabel1)
                .addContainerGap(601, Short.MAX_VALUE))
        );

        menuOpc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(93, 173, 226), 4));

        menuClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cliente2.png"))); // NOI18N
        menuClientes.setText("Clientes");
        menuClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuClientesActionPerformed(evt);
            }
        });

        itemRegistrarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconoInsertar.png"))); // NOI18N
        itemRegistrarCliente.setText("Registrar");
        menuClientes.add(itemRegistrarCliente);

        itemModificarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconoMod.png"))); // NOI18N
        itemModificarCliente.setText("Modificar");
        menuClientes.add(itemModificarCliente);

        itemEliminarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconoEliminar.png"))); // NOI18N
        itemEliminarCliente.setText("Eliminar");
        menuClientes.add(itemEliminarCliente);

        itemListarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b2.png"))); // NOI18N
        itemListarCliente.setText("Lista de clientes");
        itemListarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemListarClienteActionPerformed(evt);
            }
        });
        menuClientes.add(itemListarCliente);

        menuOpc.add(menuClientes);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/mueble3.png"))); // NOI18N
        jMenu2.setText("Muebles");

        itemRegistrarMueble.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconoInsertar.png"))); // NOI18N
        itemRegistrarMueble.setText("Registrar");
        jMenu2.add(itemRegistrarMueble);

        itemModificarMueble.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconoMod.png"))); // NOI18N
        itemModificarMueble.setText("Modificar");
        jMenu2.add(itemModificarMueble);

        itemEliminarMueble.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconoEliminar.png"))); // NOI18N
        itemEliminarMueble.setText("Eliminar");
        itemEliminarMueble.setActionCommand("Modificar");
        jMenu2.add(itemEliminarMueble);

        itemListarMueble.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b2.png"))); // NOI18N
        itemListarMueble.setText("Lista de muebles");
        itemListarMueble.setActionCommand("Modificar");
        jMenu2.add(itemListarMueble);

        menuOpc.add(jMenu2);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/prov2.png"))); // NOI18N
        jMenu3.setText("Proveedores");

        itemRegistrarProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconoInsertar.png"))); // NOI18N
        itemRegistrarProveedor.setText("Registrar");
        jMenu3.add(itemRegistrarProveedor);

        itemModificarProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconoMod.png"))); // NOI18N
        itemModificarProveedor.setText("Modificar");
        jMenu3.add(itemModificarProveedor);

        itemEliminarProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconoEliminar.png"))); // NOI18N
        itemEliminarProveedor.setText("Eliminar");
        jMenu3.add(itemEliminarProveedor);

        itemListarProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b2.png"))); // NOI18N
        itemListarProveedor.setText("Lista de proveedores");
        jMenu3.add(itemListarProveedor);

        menuOpc.add(jMenu3);

        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/vendedor.png"))); // NOI18N
        jMenu5.setText("Vendedores");

        itemRegistrarVendedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconoInsertar.png"))); // NOI18N
        itemRegistrarVendedor.setText("Registrar");
        jMenu5.add(itemRegistrarVendedor);

        itemModificarVendedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconoMod.png"))); // NOI18N
        itemModificarVendedor.setText("Modificar");
        itemModificarVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemModificarVendedorActionPerformed(evt);
            }
        });
        jMenu5.add(itemModificarVendedor);

        itemEliminarVendedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconoEliminar.png"))); // NOI18N
        itemEliminarVendedor.setText("Eliminar");
        jMenu5.add(itemEliminarVendedor);

        itemListarVendedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b2.png"))); // NOI18N
        itemListarVendedor.setText("Lista de vendedores");
        itemListarVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemListarVendedorActionPerformed(evt);
            }
        });
        jMenu5.add(itemListarVendedor);

        menuOpc.add(jMenu5);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ventas2.png"))); // NOI18N
        jMenu4.setText("Ventas");

        itemRealizarVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/factura2.png"))); // NOI18N
        itemRealizarVenta.setText("Realizar Venta");
        jMenu4.add(itemRealizarVenta);

        menuOpc.add(jMenu4);

        jMenu6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reporte.png"))); // NOI18N
        jMenu6.setText("Reportes");

        itemRealizarVenta1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/factura2.png"))); // NOI18N
        itemRealizarVenta1.setText("Realizar Venta");
        jMenu6.add(itemRealizarVenta1);

        menuOpc.add(jMenu6);

        setJMenuBar(menuOpc);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemListarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemListarClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemListarClienteActionPerformed

    private void menuClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuClientesActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_menuClientesActionPerformed

    private void itemModificarVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemModificarVendedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemModificarVendedorActionPerformed

    private void itemListarVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemListarVendedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemListarVendedorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenuItem itemEliminarCliente;
    private javax.swing.JMenuItem itemEliminarMueble;
    private javax.swing.JMenuItem itemEliminarProveedor;
    private javax.swing.JMenuItem itemEliminarVendedor;
    private javax.swing.JMenuItem itemListarCliente;
    private javax.swing.JMenuItem itemListarMueble;
    private javax.swing.JMenuItem itemListarProveedor;
    private javax.swing.JMenuItem itemListarVendedor;
    private javax.swing.JMenuItem itemModificarCliente;
    private javax.swing.JMenuItem itemModificarMueble;
    private javax.swing.JMenuItem itemModificarProveedor;
    private javax.swing.JMenuItem itemModificarVendedor;
    private javax.swing.JMenuItem itemRealizarVenta;
    private javax.swing.JMenuItem itemRealizarVenta1;
    private javax.swing.JMenuItem itemRegistrarCliente;
    private javax.swing.JMenuItem itemRegistrarMueble;
    private javax.swing.JMenuItem itemRegistrarProveedor;
    private javax.swing.JMenuItem itemRegistrarVendedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JMenu menuClientes;
    private javax.swing.JMenuBar menuOpc;
    // End of variables declaration//GEN-END:variables

    public JDesktopPane getEscritorio() {
        return escritorio;
    }

    public void setEscritorio(JDesktopPane escritorio) {
        this.escritorio = escritorio;
    }

    public JMenuItem getItemEliminarCliente() {
        return itemEliminarCliente;
    }

    public void setItemEliminarCliente(JMenuItem itemEliminarCliente) {
        this.itemEliminarCliente = itemEliminarCliente;
    }

    public JMenuItem getItemListarCliente() {
        return itemListarCliente;
    }

    public void setItemListarCliente(JMenuItem itemListarCliente) {
        this.itemListarCliente = itemListarCliente;
    }

    public JMenuItem getItemModificarCliente() {
        return itemModificarCliente;
    }

    public void setItemModificarCliente(JMenuItem itemModificarCliente) {
        this.itemModificarCliente = itemModificarCliente;
    }

    public JMenuItem getItemModificarMueble() {
        return itemModificarMueble;
    }

    public void setItemModificarMueble(JMenuItem itemModificarMueble) {
        this.itemModificarMueble = itemModificarMueble;
    }

    public JMenuItem getItemRegistrarCliente() {
        return itemRegistrarCliente;
    }

    public void setItemRegistrarCliente(JMenuItem itemRegistrarCliente) {
        this.itemRegistrarCliente = itemRegistrarCliente;
    }

    public JMenuItem getItemRegistrarMueble() {
        return itemRegistrarMueble;
    }

    public void setItemRegistrarMueble(JMenuItem itemRegistrarMueble) {
        this.itemRegistrarMueble = itemRegistrarMueble;
    }

    public JMenuItem getItemEliminarMueble() {
        return itemEliminarMueble;
    }

    public void setItemEliminarMueble(JMenuItem itemEliminarMueble) {
        this.itemEliminarMueble = itemEliminarMueble;
    }

    public JMenuItem getItemListarMueble() {
        return itemListarMueble;
    }

    public void setItemListarMueble(JMenuItem itemListarMueble) {
        this.itemListarMueble = itemListarMueble;
    }

   public JMenuItem getItemEliminarProveedor() {
      return itemEliminarProveedor;
   }

   public void setItemEliminarProveedor(JMenuItem itemEliminarProveedor) {
      this.itemEliminarProveedor = itemEliminarProveedor;
   }

   public JMenuItem getItemListarProveedor() {
      return itemListarProveedor;
   }

   public void setItemListarProveedor(JMenuItem itemListarProveedor) {
      this.itemListarProveedor = itemListarProveedor;
   }

   public JMenuItem getItemModificarProveedor() {
      return itemModificarProveedor;
   }

   public void setItemModificarProveedor(JMenuItem itemModificarProveedor) {
      this.itemModificarProveedor = itemModificarProveedor;
   }

   public JMenuItem getItemRegistrarCliente9() {
      return itemRealizarVenta;
   }

   public void setItemRegistrarCliente9(JMenuItem itemRegistrarCliente9) {
      this.itemRealizarVenta = itemRegistrarCliente9;
   }

   public JMenuItem getItemRegistrarProveedor() {
      return itemRegistrarProveedor;
   }

   public void setItemRegistrarProveedor(JMenuItem itemRegistrarProveedor) {
      this.itemRegistrarProveedor = itemRegistrarProveedor;
   }

    public JMenuItem getItemRealizarVenta() {
        return itemRealizarVenta;
    }

    public void setItemRealizarVenta(JMenuItem itemRealizarVenta) {
        this.itemRealizarVenta = itemRealizarVenta;
    }

    public JMenuItem getItemEliminarVendedor() {
        return itemEliminarVendedor;
    }

    public void setItemEliminarVendedor(JMenuItem itemEliminarVendedor) {
        this.itemEliminarVendedor = itemEliminarVendedor;
    }

    public JMenuItem getItemListarVendedor() {
        return itemListarVendedor;
    }

    public void setItemListarVendedor(JMenuItem itemListarVendedor) {
        this.itemListarVendedor = itemListarVendedor;
    }

    public JMenuItem getItemModificarVendedor() {
        return itemModificarVendedor;
    }

    public void setItemModificarVendedor(JMenuItem itemModificarVendedor) {
        this.itemModificarVendedor = itemModificarVendedor;
    }

    public JMenuItem getItemRegistrarVendedor() {
        return itemRegistrarVendedor;
    }

    public void setItemRegistrarVendedor(JMenuItem itemRegistrarVendedor) {
        this.itemRegistrarVendedor = itemRegistrarVendedor;
    }



}
