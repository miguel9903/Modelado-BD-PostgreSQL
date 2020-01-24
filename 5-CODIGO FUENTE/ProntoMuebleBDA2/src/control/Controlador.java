package control;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.Cliente;
import modelo.Color;
import modelo.DAOCliente;
import modelo.DAOColor;
import modelo.DAODetalle;
import modelo.DAOMaterial;
import modelo.DAOMueble;
import modelo.DAOProveedor;
import modelo.DAOTipo_Mueble;
import modelo.DAOVendedor;
import modelo.DAOVenta;
import modelo.Material;
import modelo.Mueble;
import modelo.PersonaDeContacto;
import modelo.Proveedor;
import modelo.Telefono_Cliente;
import modelo.Telefono_Proveedor;
import modelo.Tipo_Mueble;
import modelo.Validaciones;
import modelo.Vendedor;
import vista.*;

public class Controlador {

    //OTROS
    ButtonGroup grupoOpcAgrMueble;

    //DAO
    DAOProveedor daoProv;
    DAOCliente daoCliente;
    DAOTipo_Mueble daoTipoMueble;
    DAOMaterial daoMaterial;
    DAOColor daoColor;
    DAOMueble daoMueble;
    DAOVenta daoVenta;
    DAODetalle daoDetalle;
    DAOVendedor daoVend;

    //EVENTOS
    ManejoBotones manejoBotones;
    ManejoTeclado manejoTeclado;

    // VENTANAS INICIO APP
    VentanaInicioApp ventanaInicioApp;
    VentanaApp ventanaPrincipal;

    //VENTANAS OPERACIONES BASICAS
    VentanaListarClientes ventanaListar;

    //PROVEEDOR
    VentanaAgregarProveedor ventanaAgregarProveedor;
    VentanaModificarProveedor ventanaModificarProveedor;
    VentanaEliminarProveedor ventanaEliminarProveedor;
    FormularioModificarProv formularioModificarProv;
    FormularioAgregarPC formularioAgregarPerConct;
    FormularioModificarPC formularioModificarPerConct;

    //VENDEDOR
    VentanaAgregarVendedor ventanaAgregarVendedor;
    VentanaModificarVendedor ventanaModificarVendedor;
    VentanaEliminarVendedor ventanaEliminarVendedor;
    FormularioModificarVend formularioModificarVend;

    //CLIENTE
    VentanaAgregarCliente ventanaAgregarCliente;
    VentanaModificarCliente ventanaModificarCliente;
    VentanaEliminarCliente ventanaEliminarCliente;
    FormularioModificarCliente formularioModificarCliente;

    //MUEBLE
    VentanaAgregarMueble ventanaAgregarMueble;
    VentanaModificarMueble ventanaModificarMueble;
    VentanaEliminarMueble ventanaEliminarMueble;
    FormularioModificarMueble formularioModificarMueble;

    //VENTANA VENTAS
    VentanaVentas ventanaVentas;
    FormularioVenta formularioVenta;

    public Controlador() {

        //DAO
        this.daoProv = new DAOProveedor();
        this.daoCliente = new DAOCliente();
        this.daoTipoMueble = new DAOTipo_Mueble();
        this.daoMaterial = new DAOMaterial();
        this.daoColor = new DAOColor();
        this.daoMueble = new DAOMueble();
        this.daoVenta = new DAOVenta();
        this.daoDetalle = new DAODetalle();
        this.daoVend = new DAOVendedor();

        //Eventos
        this.manejoBotones = new ManejoBotones();
        this.manejoTeclado = new ManejoTeclado();

// ----------------------INICIALIZAR VENTANAS-----------------------------------
        //VENTANAS INICIO APP
        this.ventanaInicioApp = new VentanaInicioApp();
        this.ventanaPrincipal = new VentanaApp();
        this.ventanaListar = new VentanaListarClientes();

        //PROVEEDOR
        this.ventanaAgregarProveedor = new VentanaAgregarProveedor();
        this.ventanaModificarProveedor = new VentanaModificarProveedor();
        this.ventanaEliminarProveedor = new VentanaEliminarProveedor();
        this.formularioModificarProv = new FormularioModificarProv();
        this.formularioAgregarPerConct = new FormularioAgregarPC();
        this.formularioModificarPerConct = new FormularioModificarPC();

        //VENDEDOR
        this.ventanaAgregarVendedor = new VentanaAgregarVendedor();
        this.ventanaModificarVendedor = new VentanaModificarVendedor();
        this.ventanaEliminarVendedor = new VentanaEliminarVendedor();
        this.formularioModificarVend = new FormularioModificarVend();

        //CLIENTE
        this.ventanaAgregarCliente = new VentanaAgregarCliente();
        this.ventanaModificarCliente = new VentanaModificarCliente();
        this.ventanaEliminarCliente = new VentanaEliminarCliente();
        this.formularioModificarCliente = new FormularioModificarCliente();

        //MUEBLE
        this.ventanaAgregarMueble = new VentanaAgregarMueble();
        this.ventanaModificarMueble = new VentanaModificarMueble();
        this.ventanaEliminarMueble = new VentanaEliminarMueble();
        this.formularioModificarMueble = new FormularioModificarMueble();

        this.grupoOpcAgrMueble = new ButtonGroup();
        this.grupoOpcAgrMueble.add(ventanaAgregarMueble.getOpcSi());
        this.grupoOpcAgrMueble.add(ventanaAgregarMueble.getOpcNo());

        //VENTAS
        ventanaVentas = new VentanaVentas();
        formularioVenta = new FormularioVenta();

// ---------------------AGREGAR VENTANAS AL ESCRITORIO--------------------------
        //VENTANA LISTAR
        ventanaPrincipal.getEscritorio().add(ventanaListar);

        //PROVEEDOR
        ventanaPrincipal.getEscritorio().add(ventanaAgregarProveedor);
        ventanaPrincipal.getEscritorio().add(ventanaModificarProveedor);
        ventanaPrincipal.getEscritorio().add(ventanaEliminarProveedor);
        ventanaPrincipal.getEscritorio().add(formularioModificarProv);
        ventanaPrincipal.getEscritorio().add(formularioAgregarPerConct);
        ventanaPrincipal.getEscritorio().add(formularioModificarPerConct);

        //VENDEDOR
        ventanaPrincipal.getEscritorio().add(ventanaAgregarVendedor);
        ventanaPrincipal.getEscritorio().add(ventanaModificarVendedor);
        ventanaPrincipal.getEscritorio().add(ventanaEliminarVendedor);
        ventanaPrincipal.getEscritorio().add(formularioModificarVend);

        //CLIENTE
        ventanaPrincipal.getEscritorio().add(ventanaAgregarCliente);
        ventanaPrincipal.getEscritorio().add(ventanaModificarCliente);
        ventanaPrincipal.getEscritorio().add(ventanaEliminarCliente);
        ventanaPrincipal.getEscritorio().add(formularioModificarCliente);

        //MUEBLE
        ventanaPrincipal.getEscritorio().add(ventanaAgregarMueble);
        ventanaPrincipal.getEscritorio().add(ventanaModificarMueble);
        ventanaPrincipal.getEscritorio().add(ventanaEliminarMueble);
        ventanaPrincipal.getEscritorio().add(formularioModificarMueble);

        //VENTANA VENTAS
        ventanaPrincipal.getEscritorio().add(ventanaVentas);
        ventanaPrincipal.getEscritorio().add(formularioVenta);

// ---------------------AGREGAR COMPONENTES A LA ESCUCHA------------------------
        //VENTANA INICIO APP
        ventanaInicioApp.getBotonInicio().addActionListener(manejoBotones);

        //-----------------ITEMS VENTANA PRINCIPAL------------------------------
        //Proveedor
        ventanaPrincipal.getItemRegistrarProveedor().addActionListener(manejoBotones);
        ventanaPrincipal.getItemModificarProveedor().addActionListener(manejoBotones);
        ventanaPrincipal.getItemEliminarProveedor().addActionListener(manejoBotones);

        //Vendedor
        ventanaPrincipal.getItemRegistrarVendedor().addActionListener(manejoBotones);
        ventanaPrincipal.getItemModificarVendedor().addActionListener(manejoBotones);
        ventanaPrincipal.getItemEliminarVendedor().addActionListener(manejoBotones);

        //Cliente
        ventanaPrincipal.getItemRegistrarCliente().addActionListener(manejoBotones);
        ventanaPrincipal.getItemModificarCliente().addActionListener(manejoBotones);
        ventanaPrincipal.getItemEliminarCliente().addActionListener(manejoBotones);
        ventanaPrincipal.getItemListarCliente().addActionListener(manejoBotones);

        //Mueble
        ventanaPrincipal.getItemRegistrarMueble().addActionListener(manejoBotones);
        ventanaPrincipal.getItemModificarMueble().addActionListener(manejoBotones);
        ventanaPrincipal.getItemEliminarMueble().addActionListener(manejoBotones);
        //----------------------------------------------------------------------

        //Ventas
        ventanaPrincipal.getItemRealizarVenta().addActionListener(manejoBotones);

        //VENTANA AGREGAR PROVEEDOR
        ventanaAgregarProveedor.getBotonAgregarProveedor().addActionListener(manejoBotones);
        ventanaAgregarProveedor.getBotonCerrarVentana1().addActionListener(manejoBotones);
        ventanaAgregarProveedor.getBotonLimpiarFormulario1().addActionListener(manejoBotones);

        //VENTANA MODIFICAR PROV
        //-----------------------------ActionListener---------------------------
        ventanaModificarProveedor.getBotonAceptarModificar().addActionListener(manejoBotones);
        ventanaModificarProveedor.getBotonCerrarVentana().addActionListener(manejoBotones);
        ventanaModificarProveedor.getBotonActualizarProv().addActionListener(manejoBotones);
        ventanaModificarProveedor.getBotonBuscar().addActionListener(manejoBotones);
        ventanaModificarProveedor.getBotonRefrescar().addActionListener(manejoBotones);

        formularioModificarProv.getBotonModificarProveedor().addActionListener(manejoBotones);
        formularioModificarProv.getBotonLimpiarFormulario().addActionListener(manejoBotones);
        formularioModificarProv.getBotonAgregarTelefono().addActionListener(manejoBotones);
        formularioModificarProv.getBotonEliminarTelefono().addActionListener(manejoBotones);
        formularioModificarProv.getBotonAgregarPC().addActionListener(manejoBotones);
        formularioModificarProv.getBotonModificarPC().addActionListener(manejoBotones);
        formularioModificarProv.getBotonEliminarPC().addActionListener(manejoBotones);
        formularioModificarProv.getBotonActualizarPC().addActionListener(manejoBotones);
        formularioModificarProv.getBotonCerrarVentana().addActionListener(manejoBotones);

        formularioModificarPerConct.getBotonCerrarVentana().addActionListener(manejoBotones);
        formularioModificarPerConct.getBotonLimpiarFormulario().addActionListener(manejoBotones);
        formularioModificarPerConct.getBotonModificarPC().addActionListener(manejoBotones);

        formularioAgregarPerConct.getBotonCerrarVentana().addActionListener(manejoBotones);
        formularioAgregarPerConct.getBotonLimpiarFormulario().addActionListener(manejoBotones);
        formularioAgregarPerConct.getBotonAgregarPC().addActionListener(manejoBotones);

        //-----------------------------MouseListener----------------------------
        ventanaModificarProveedor.getTablaBuscarProv().addMouseListener(new ManejoTablaBuscarProv());
        formularioModificarProv.getTablaPerContacto().addMouseListener(new ManejoTablaPC());

        //-----------------------------KeyListener------------------------------
        ventanaModificarProveedor.getTxtBuscarProv().addKeyListener(manejoTeclado);

        //VENTANA ELIMINAR PROVEEDOR
        //-----------------------------ActionListener---------------------------
        ventanaEliminarProveedor.getBotonBuscar().addActionListener(manejoBotones);
        ventanaEliminarProveedor.getBotonRefrescar().addActionListener(manejoBotones);
        ventanaEliminarProveedor.getBotonCerrarVentana().addActionListener(manejoBotones);
        ventanaEliminarProveedor.getBotonActualizaProv().addActionListener(manejoBotones);
        ventanaEliminarProveedor.getBotonAceptarEliminar().addActionListener(manejoBotones);

        //VENTANA AGREGAR VNENDEDOR
        ventanaAgregarVendedor.getBotonAgregarProveedor().addActionListener(manejoBotones);
        ventanaAgregarVendedor.getBotonCerrarVentana1().addActionListener(manejoBotones);
        ventanaAgregarVendedor.getBotonLimpiarFormulario1().addActionListener(manejoBotones);

        //VENTANA MODIFICAR VENDEDOR
        ventanaModificarVendedor.getBotonAceptarModificar().addActionListener(manejoBotones);
        ventanaModificarVendedor.getBotonCerrarVentana().addActionListener(manejoBotones);
        ventanaModificarVendedor.getBotonActualizarProv().addActionListener(manejoBotones);
        ventanaModificarVendedor.getBotonBuscar().addActionListener(manejoBotones);
        ventanaModificarVendedor.getBotonRefrescar().addActionListener(manejoBotones);

        formularioModificarVend.getBotonModificarVendedor().addActionListener(manejoBotones);
        formularioModificarVend.getBotonLimpiarFormulario1().addActionListener(manejoBotones);
        formularioModificarVend.getBotonCerrarVentana1().addActionListener(manejoBotones);

        ventanaModificarVendedor.getTablaBuscarProv().addMouseListener(new ManejoTablaBuscarVend());

        //VENTANA AGREGAR CLIENTE
        ventanaAgregarCliente.getBotonAgregarCliente().addActionListener(manejoBotones);
        ventanaAgregarCliente.getBotonLimpiarFormulario().addActionListener(manejoBotones);
        ventanaAgregarCliente.getBotonCerrarVentana().addActionListener(manejoBotones);

        //VENTANA MODIFICAR CLIENTE
        //-----------------------------ActionListener---------------------------
        ventanaModificarCliente.getBotonAceptarModificar().addActionListener(manejoBotones);
        ventanaModificarCliente.getBotonActualizarCliente().addActionListener(manejoBotones);
        ventanaModificarCliente.getBotonBuscar().addActionListener(manejoBotones);
        ventanaModificarCliente.getBotonRefrescar().addActionListener(manejoBotones);
        ventanaModificarCliente.getBotonCerrarVentana().addActionListener(manejoBotones);

        formularioModificarCliente.getBotonLimpiarFormulario().addActionListener(manejoBotones);
        formularioModificarCliente.getBotonModificarCliente().addActionListener(manejoBotones);
        formularioModificarCliente.getBotonEliminarTelefono().addActionListener(manejoBotones);
        formularioModificarCliente.getBotonAgregarTelefono().addActionListener(manejoBotones);
        formularioModificarCliente.getBotonCerrarVentana().addActionListener(manejoBotones);
        //-----------------------------MouseListener----------------------------
        ventanaModificarCliente.getTablaBuscarCliente().addMouseListener(new ManejoTablaBuscarCliente());
        //-----------------------------KeyListener------------------------------
        ventanaModificarCliente.getTxtBuscarCliente().addKeyListener(manejoTeclado);

        //VENTANA ELIMINAR CLIENTE
        //-----------------------------ActionListener---------------------------
        ventanaEliminarCliente.getBotonAceptarEliminar().addActionListener(manejoBotones);
        ventanaEliminarCliente.getBotonBuscar().addActionListener(manejoBotones);
        ventanaEliminarCliente.getBotonRefrescar().addActionListener(manejoBotones);
        ventanaEliminarCliente.getBotonCerrarVentana().addActionListener(manejoBotones);
        ventanaEliminarCliente.getBotonActualizarCliente().addActionListener(manejoBotones);
        //-----------------------------KeyListener------------------------------
        ventanaEliminarCliente.getTxtBuscarCliente().addKeyListener(manejoTeclado);

        //VENTANA AGREGAR MUEBLE
        ventanaAgregarMueble.getBotonAgregarMueble().addActionListener(manejoBotones);
        ventanaAgregarMueble.getBotonLimpiarCampos().addActionListener(manejoBotones);
        ventanaAgregarMueble.getOpcNo().addActionListener(manejoBotones);
        ventanaAgregarMueble.getOpcSi().addActionListener(manejoBotones);
        ventanaAgregarMueble.getBotonCerrarVentana().addActionListener(manejoBotones);

        //VENTANA MODFICICAR MUEBLE
        //-----------------------------ActionListener---------------------------
        ventanaModificarMueble.getBotonActualizarMueble().addActionListener(manejoBotones);
        ventanaModificarMueble.getBotonBuscar().addActionListener(manejoBotones);
        ventanaModificarMueble.getBotonRefrescar().addActionListener(manejoBotones);
        ventanaModificarMueble.getBotonCerrarVentana().addActionListener(manejoBotones);
        ventanaModificarMueble.getBotonAceptarModificar().addActionListener(manejoBotones);

        formularioModificarMueble.getBotonCerrarVentana().addActionListener(manejoBotones);
        formularioModificarMueble.getBotonRegistrarStock().addActionListener(manejoBotones);
        formularioModificarMueble.getBotonModificarMueble().addActionListener(manejoBotones);

        //-----------------------------MouseListener----------------------------
        ventanaModificarMueble.getTablaBuscarMueble().addMouseListener(new ManejoTablaBuscarMueble());
        //-----------------------------KeyListener------------------------------
        ventanaModificarMueble.getTxtBuscarMueble().addKeyListener(manejoTeclado);

        //VENTANA ELIMINAR MUEBLE
        //-----------------------------ActionListener---------------------------
        ventanaEliminarMueble.getBotonBuscar().addActionListener(manejoBotones);
        ventanaEliminarMueble.getBotonRefrescar().addActionListener(manejoBotones);
        ventanaEliminarMueble.getBotonCerrarVentana().addActionListener(manejoBotones);
        ventanaEliminarMueble.getBotonActualizarMueble().addActionListener(manejoBotones);
        ventanaEliminarMueble.getBotonAceptarEliminar().addActionListener(manejoBotones);
        //-----------------------------KeyListener------------------------------
        ventanaEliminarMueble.getTxtBuscarMueble().addKeyListener(manejoTeclado);

        //VENTANA VENTAS
        //-----------------------------ActionListener---------------------------
        ventanaVentas.getBotonAgregarMueble().addActionListener(manejoBotones);
        ventanaVentas.getBotonCancelarVenta().addActionListener(manejoBotones);
        ventanaVentas.getBotonBuscarCliente().addActionListener(manejoBotones);
        ventanaVentas.getBotonBuscarProv().addActionListener(manejoBotones);

        ventanaListar.getBotonAgregarCliente().addActionListener(manejoBotones);
        ventanaListar.getBotonBuscar().addActionListener(manejoBotones);
        ventanaListar.getBotonRefrescar().addActionListener(manejoBotones);
        ventanaListar.getBotonCerrarVentana().addActionListener(manejoBotones);

        formularioVenta.getBotonAgregarMueble().addActionListener(manejoBotones);
        formularioVenta.getBotonBuscar().addActionListener(manejoBotones);
        formularioVenta.getBotonCerrarVentana().addActionListener(manejoBotones);
        formularioVenta.getBotonRefrescar().addActionListener(manejoBotones);
        //-----------------------------KeyListener------------------------------
        formularioVenta.getTxtBuscarMueble().addKeyListener(manejoTeclado);
    }

    public void iniciar() {
        try {
            //ventanaInicioApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            //ventanaInicioApp.setLocationRelativeTo(null);
            //ventanaInicioApp.setTitle("ProntoMueble");
            //ventanaInicioApp.setResizable(false);
            //ventanaInicioApp.setVisible(true);

            ventanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ventanaPrincipal.setLocationRelativeTo(null);
            ventanaPrincipal.setResizable(false);
            ventanaPrincipal.setVisible(true);

            this.ventanaAgregarMueble.getComboColorMueble().setMaximumRowCount(4);
            this.ventanaAgregarMueble.getComboMaterialMueble().setMaximumRowCount(4);
            this.ventanaAgregarMueble.getComboTipoMueble().setMaximumRowCount(4);
            this.ventanaAgregarMueble.getAreaDescripcion().setLineWrap(true);
            this.formularioModificarMueble.getAreaDescripcion().setLineWrap(true);

            /* llenarTablaProveedor(ventanaModificarProveedor.getTablaBuscarProv(), daoProv.listar("Todos"));
            llenarTablaCliente(ventanaModificarCliente.getTablaBuscarCliente(), daoCliente.listar("Todos"));
            llenarTablaCliente(ventanaListar.getTablaBuscarCliente(), daoCliente.listar("Activos")*/
        } catch (Exception ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private class ManejoBotones implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            //Evento boton INICIAR APP
            /* if (e.getSource() == ventanaInicioApp.getBotonInicio()) {

                String clave = String.valueOf(ventanaInicioApp.getClave().getPassword());

                if (Validaciones.validarCampoTexto(ventanaInicioApp.getUsuario()) || Validaciones.validarCampoTexto(ventanaInicioApp.getClave())) {
                    Validaciones.sonar();
                    JOptionPane.showMessageDialog(ventanaPrincipal.getEscritorio(), "Por favor digite usuario y contraseña.");
                } else {
                    if (ventanaInicioApp.getUsuario().getText().equalsIgnoreCase("Admin") && clave.equals("123456")) {
                        ventanaInicioApp.dispose();
                        ventanaPrincipal.setVisible(true);
                        ventanaPrincipal.setLocationRelativeTo(null);
                        ventanaPrincipal.setResizable(false);

                    } else {
                        JOptionPane.showMessageDialog(ventanaPrincipal.getEscritorio(), "Usuario o contraseña incorrectos.");
                    }
                }
            }*/
            //-----EVENTOS ITEMS PROVEEDOR--------------------------------------
            if (e.getSource() == ventanaPrincipal.getItemRegistrarProveedor()) {
                ventanaAgregarProveedor.setVisible(true);
                ventanaAgregarProveedor.getTituloVentana().setHorizontalAlignment(JLabel.CENTER);
                ventanaAgregarProveedor.setLocation((ventanaPrincipal.getEscritorio().getWidth() - ventanaAgregarProveedor.getWidth()) / 2, (ventanaPrincipal.getEscritorio().getHeight() - ventanaAgregarProveedor.getHeight()) / 2);
            }

            if (e.getSource() == ventanaPrincipal.getItemModificarProveedor()) {
                try {
                    ventanaModificarProveedor.setVisible(true);
                    ventanaModificarProveedor.getTituloVentana().setHorizontalAlignment(JLabel.CENTER);
                    llenarTablaProveedor(ventanaModificarProveedor.getTablaBuscarProv(), daoProv.listar("Todos"));
                    ventanaModificarProveedor.setLocation((ventanaPrincipal.getEscritorio().getWidth() - ventanaModificarProveedor.getWidth()) / 2, (ventanaPrincipal.getEscritorio().getHeight() - ventanaModificarProveedor.getHeight()) / 2);
                } catch (Exception ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (e.getSource() == ventanaPrincipal.getItemEliminarProveedor()) {
                try {
                    ventanaEliminarProveedor.setVisible(true);
                    ventanaEliminarProveedor.getTituloVentana().setHorizontalAlignment(JLabel.CENTER);
                    llenarTablaProveedor(ventanaEliminarProveedor.getTablaBuscarProv(), daoProv.listar("Activos"));
                    ventanaEliminarProveedor.setLocation((ventanaPrincipal.getEscritorio().getWidth() - ventanaEliminarProveedor.getWidth()) / 2, (ventanaPrincipal.getEscritorio().getHeight() - ventanaEliminarProveedor.getHeight()) / 2);
                } catch (Exception ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            //------EVENTOS ITEMS VENDEDOR--------------------------------------
            if (e.getSource() == ventanaPrincipal.getItemRegistrarVendedor()) {
                ventanaAgregarVendedor.setVisible(true);
                ventanaAgregarVendedor.getTituloVentana().setHorizontalAlignment(JLabel.CENTER);
                ventanaAgregarVendedor.setLocation((ventanaPrincipal.getEscritorio().getWidth() - ventanaAgregarVendedor.getWidth()) / 2, (ventanaPrincipal.getEscritorio().getHeight() - ventanaAgregarVendedor.getHeight()) / 2);
            }

            if (e.getSource() == ventanaPrincipal.getItemModificarVendedor()) {
                try {
                    ventanaModificarVendedor.setVisible(true);
                    ventanaModificarVendedor.getTituloVentana().setHorizontalAlignment(JLabel.CENTER);
                    llenarTablaVendedor(ventanaModificarVendedor.getTablaBuscarProv(), daoVend.listar("Todos"));
                    ventanaModificarVendedor.setLocation((ventanaPrincipal.getEscritorio().getWidth() - ventanaModificarVendedor.getWidth()) / 2, (ventanaPrincipal.getEscritorio().getHeight() - ventanaModificarVendedor.getHeight()) / 2);
                } catch (Exception ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (e.getSource() == ventanaPrincipal.getItemEliminarVendedor()) {
                try {
                    ventanaEliminarVendedor.setVisible(true);
                    ventanaEliminarVendedor.getTituloVentana().setHorizontalAlignment(JLabel.CENTER);
                    llenarTablaVendedor(ventanaEliminarVendedor.getTablaBuscarProv(), daoVend.listar("Activos"));
                    ventanaEliminarVendedor.setLocation((ventanaPrincipal.getEscritorio().getWidth() - ventanaEliminarVendedor.getWidth()) / 2, (ventanaPrincipal.getEscritorio().getHeight() - ventanaEliminarVendedor.getHeight()) / 2);
                } catch (Exception ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            //-----EVENTOS ITEMS CLIENTE----------------------------------------
            if (e.getSource() == ventanaPrincipal.getItemRegistrarCliente()) {
                try {
                    ventanaAgregarCliente.setVisible(true);
                    ventanaAgregarCliente.getTituloVentana().setHorizontalAlignment(JLabel.CENTER);
                    ventanaAgregarCliente.setLocation((ventanaPrincipal.getEscritorio().getWidth() - ventanaAgregarCliente.getWidth()) / 2, (ventanaPrincipal.getEscritorio().getHeight() - ventanaAgregarCliente.getHeight()) / 2);
                } catch (Exception ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (e.getSource() == ventanaPrincipal.getItemModificarCliente()) {
                try {
                    ventanaModificarCliente.setVisible(true);
                    ventanaModificarCliente.getTituloVentana().setHorizontalAlignment(JLabel.CENTER);
                    llenarTablaCliente(ventanaModificarCliente.getTablaBuscarCliente(), daoCliente.listar("Todos"));
                    ventanaModificarCliente.setLocation((ventanaPrincipal.getEscritorio().getWidth() - ventanaModificarCliente.getWidth()) / 2, (ventanaPrincipal.getEscritorio().getHeight() - ventanaModificarCliente.getHeight()) / 2);
                } catch (Exception ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (e.getSource() == ventanaPrincipal.getItemEliminarCliente()) {
                try {
                    ventanaEliminarCliente.setVisible(true);
                    ventanaEliminarCliente.getTituloVentana().setHorizontalAlignment(JLabel.CENTER);
                    llenarTablaCliente(ventanaEliminarCliente.getTablaBuscarCliente(), daoCliente.listar("Activos"));
                    ventanaEliminarCliente.setLocation((ventanaPrincipal.getEscritorio().getWidth() - ventanaEliminarCliente.getWidth()) / 2, (ventanaPrincipal.getEscritorio().getHeight() - ventanaEliminarCliente.getHeight()) / 2);
                } catch (Exception ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            //-----EVENTOS ITEMS MUEBLE----------------------------------------
            if (e.getSource() == ventanaPrincipal.getItemRegistrarMueble()) {
                try {
                    ventanaAgregarMueble.setVisible(true);
                    ventanaAgregarMueble.getTituloVentana().setHorizontalAlignment(JLabel.CENTER);
                    ventanaAgregarMueble.setLocation((ventanaPrincipal.getEscritorio().getWidth() - ventanaAgregarMueble.getWidth()) / 2, (ventanaPrincipal.getEscritorio().getHeight() - ventanaAgregarMueble.getHeight()) / 2);
                    ventanaAgregarMueble.getOpcNo().setSelected(true);
                    ventanaAgregarMueble.getComboColorMueble().setEnabled(false);
                    ventanaAgregarMueble.getComboMaterialMueble().setEnabled(false);
                    ventanaAgregarMueble.getComboTipoMueble().setEnabled(false);
                    llenarComboTipoMueble(ventanaAgregarMueble.getComboTipoMueble(), daoTipoMueble.listar());
                    llenarComboMaterial(ventanaAgregarMueble.getComboMaterialMueble(), daoMaterial.listar());
                    llenarComboColor(ventanaAgregarMueble.getComboColorMueble(), daoColor.listar());
                } catch (Exception ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (e.getSource() == ventanaPrincipal.getItemModificarMueble()) {
                try {
                    ventanaModificarMueble.setVisible(true);
                    ventanaModificarMueble.getTituloVentana().setHorizontalAlignment(JLabel.CENTER);
                    llenarTablaMueble(ventanaModificarMueble.getTablaBuscarMueble(), daoMueble.listar("Todos"), "Mueble_Admin");
                    ventanaModificarMueble.setLocation((ventanaPrincipal.getEscritorio().getWidth() - ventanaModificarMueble.getWidth()) / 2, (ventanaPrincipal.getEscritorio().getHeight() - ventanaModificarMueble.getHeight()) / 2);
                } catch (Exception ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (e.getSource() == ventanaPrincipal.getItemEliminarMueble()) {
                try {
                    ventanaEliminarMueble.setVisible(true);
                    ventanaEliminarMueble.getTituloVentana().setHorizontalAlignment(JLabel.CENTER);
                    llenarTablaMueble(ventanaEliminarMueble.getTablaBuscarMueble(), daoMueble.listar("Activos"), "Mueble_Admin");
                    ventanaEliminarMueble.setLocation((ventanaPrincipal.getEscritorio().getWidth() - ventanaEliminarMueble.getWidth()) / 2, (ventanaPrincipal.getEscritorio().getHeight() - ventanaEliminarMueble.getHeight()) / 2);
                } catch (Exception ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            //-----EVENTOS ITEMS VENTAS--------------------------------------
            if (e.getSource() == ventanaPrincipal.getItemRealizarVenta()) {
                ventanaVentas.setVisible(true);
                ventanaVentas.getTituloVentana().setHorizontalAlignment(JLabel.CENTER);
                ventanaVentas.getEtiquetaProd().setHorizontalAlignment(JLabel.CENTER);
                ventanaVentas.getEtiquetaDatosGen().setHorizontalAlignment(JLabel.CENTER);
                ventanaVentas.setLocation((ventanaPrincipal.getEscritorio().getWidth() - ventanaVentas.getWidth()) / 2, (ventanaPrincipal.getEscritorio().getHeight() - ventanaVentas.getHeight()) / 2);

                Date fecha_actual = new Date();
                SimpleDateFormat formato_fecha = new SimpleDateFormat("yyyy-MM-dd");
                String fecha = formato_fecha.format(fecha_actual);
                ventanaVentas.getEtiquetaFechaVenta().setText(fecha);
                ventanaVentas.getEtiquetaFechaVenta().setHorizontalAlignment(JLabel.CENTER);
                establecerTamColumnasMueble(ventanaVentas.getTablaProductosVenta(), "Mueble_Venta");
            }

//----------------------MODIFICANDO LA BASE DE DATOS---------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------------------------
            //VENTANA AGREEGAR REGISTRO
            //VENTANA AGREGAR PROVEEDOR
            if (e.getSource() == ventanaAgregarProveedor.getBotonAgregarProveedor()) {
                String res = "";
                try {
                    if (Validaciones.validarCampoTexto(ventanaAgregarProveedor.getTxtNombreProveedor()) == false && Validaciones.validarCampoTexto(ventanaAgregarProveedor.getTxtDireccionProveedor()) == false
                            && Validaciones.validarCampoTexto(ventanaAgregarProveedor.getTxtNombrePC()) == false && Validaciones.validarCampoTexto(ventanaAgregarProveedor.getTxtTelefonoProveedor()) == false
                            && Validaciones.validarCampoTexto(ventanaAgregarProveedor.getTxtTelefonoPC()) == false) {

                        if (daoProv.validarExistente("id", "PROVEEDOR", "nombre", ventanaAgregarProveedor.getTxtNombreProveedor().getText()) == 1) {
                            mostrarAviso("Ya existe un proveedor con el nombre ingresado.");
                        } else {
                            if (daoProv.validarExistente("id", "PROVEEDOR", "direccion", ventanaAgregarProveedor.getTxtDireccionProveedor().getText()) == 1) {
                                mostrarAviso("Ya existe un proveedor con la direccion ingresada.");
                            } else {
                                if (daoProv.validarExistente("id_proveedor", "TELEFONO_PROVEEDOR", "telefono", ventanaAgregarProveedor.getTxtTelefonoProveedor().getText()) == 1) {
                                    mostrarAviso("Ya existe un proveedor con el telefono ingresado.");
                                } else {
                                    if (daoProv.validarExistente("id", "PERSONA_CONTACTO", "nombre", ventanaAgregarProveedor.getTxtNombrePC().getText()) == 1) {
                                        mostrarAviso("Ya existe una persona de contacto con el nombre ingresado.");
                                    } else {
                                        if (daoProv.validarExistente("id", "PERSONA_CONTACTO", "telefono", ventanaAgregarProveedor.getTxtTelefonoPC().getText()) == 1) {
                                            mostrarAviso("Ya existe una persona de contacto con el telefono ingresado.");
                                        } else {
                                            Proveedor prov = new Proveedor();
                                            prov.setNombre(ventanaAgregarProveedor.getTxtNombreProveedor().getText());
                                            prov.setDireccion(ventanaAgregarProveedor.getTxtDireccionProveedor().getText());
                                            res = daoProv.registrar(prov);
                                            mostrarMensaje(res);

                                            Telefono_Proveedor telefono = new Telefono_Proveedor();
                                            telefono.setId_proveedor(daoProv.retornarMax());
                                            telefono.setTelefono(ventanaAgregarProveedor.getTxtTelefonoProveedor().getText());
                                            res = daoProv.insertarTelefono(telefono);
                                            mostrarMensaje(res);

                                            PersonaDeContacto pc = new PersonaDeContacto();
                                            pc.setNombre(ventanaAgregarProveedor.getTxtNombrePC().getText());
                                            pc.setTelefono(ventanaAgregarProveedor.getTxtTelefonoPC().getText());
                                            pc.setId_proveedor(daoProv.retornarMax());
                                            res = daoProv.insertarPersonaDeContacto(pc, daoProv.retornarMax());
                                            mostrarMensaje(res);
                                        }
                                    }
                                }
                            }
                        }

                    } else {
                        mostrarAviso("No pueden quedar campos sin ingresar.");
                    }

                } catch (Exception ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (e.getSource() == ventanaAgregarProveedor.getBotonCerrarVentana1()) {
                ventanaAgregarProveedor.setVisible(false);
            }

            if (e.getSource() == ventanaAgregarProveedor.getBotonLimpiarFormulario1()) {
                ventanaAgregarProveedor.getTxtDireccionProveedor().setText("");
                ventanaAgregarProveedor.getTxtNombrePC().setText("");
                ventanaAgregarProveedor.getTxtNombreProveedor().setText("");
                ventanaAgregarProveedor.getTxtTelefonoPC().setText("");
                ventanaAgregarProveedor.getTxtTelefonoProveedor().setText("");
            }

            //VENTANA MODIFICAR PROVEEDOR
            if (e.getSource() == ventanaModificarProveedor.getBotonAceptarModificar()) {

                if (ventanaModificarProveedor.getTablaBuscarProv().getSelectedRow() == -1) {
                    JOptionPane.showMessageDialog(ventanaPrincipal.getEscritorio(), "Debe seleccionar un proveedor.");
                } else {
                    if (ventanaModificarProveedor.getTablaBuscarProv().getSelectedRowCount() > 1) {
                        mostrarAviso("Seleccione un proveedor a la vez. ");
                    } else {
                        try {
                            formularioModificarProv.setVisible(true);
                            llenarTablaPC(formularioModificarProv.getTablaPerContacto(), daoProv.listarPC(Integer.parseInt(formularioModificarProv.getTxtIdProv().getText())));
                            formularioModificarProv.getTituloModificar().setHorizontalAlignment(JLabel.CENTER);
                            llenarComboTelefonoProveedor(formularioModificarProv.getComboTelefono(), daoProv.listarTelefonos(Integer.parseInt(formularioModificarProv.getTxtIdProv().getText())));
                            inhabilitarCampos(formularioModificarProv.getTxtIdProv());
                            formularioModificarProv.setLocation((ventanaPrincipal.getEscritorio().getWidth() - formularioModificarProv.getWidth()) / 2, (ventanaPrincipal.getEscritorio().getHeight() - formularioModificarProv.getHeight()) / 2);
                        } catch (Exception ex) {
                            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }

            if (e.getSource() == formularioModificarProv.getBotonModificarProveedor()) {
                if (Validaciones.validarCampoTexto(formularioModificarProv.getTxtNombreProv())
                        || Validaciones.validarCampoTexto(formularioModificarProv.getTxtDireccionProv())) {
                    mostrarAviso("No pueden quedar campos vacios.");
                } else {
                    try {
                        Proveedor prov = new Proveedor();
                        prov.setNombre(formularioModificarProv.getTxtNombreProv().getText());
                        prov.setDireccion(formularioModificarProv.getTxtDireccionProv().getText());
                        prov.setEstado(formularioModificarProv.getComboEstado().getSelectedItem().toString());
                        String res = daoProv.modificar(prov, Integer.parseInt(formularioModificarProv.getTxtIdProv().getText()));
                        mostrarMensaje(res);
                    } catch (Exception ex) {
                        Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

            if (e.getSource() == ventanaModificarProveedor.getBotonCerrarVentana()) {
                ventanaModificarProveedor.setVisible(false);
            }

            if (e.getSource() == formularioModificarProv.getBotonLimpiarFormulario()) {
                formularioModificarProv.getTxtNombreProv().setText("");
                formularioModificarProv.getTxtDireccionProv().setText("");
            }

            if (e.getSource() == ventanaModificarProveedor.getBotonActualizarProv()) {
                try {
                    llenarTablaProveedor(ventanaModificarProveedor.getTablaBuscarProv(), daoProv.listar("Todos"));
                } catch (Exception ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (e.getSource() == formularioModificarProv.getBotonAgregarTelefono()) {
                try {
                    Telefono_Proveedor telefono = new Telefono_Proveedor();
                    telefono.setId_proveedor(Integer.parseInt(formularioModificarProv.getTxtIdProv().getText()));
                    int cantR = daoProv.retornarCantRegistrosTelefono(Integer.parseInt(formularioModificarProv.getTxtIdProv().getText()));

                    if (cantR == 2) {
                        mostrarAviso("Un proveedor no puede tener mas de 2 telefonos.");
                    } else {
                        String tel = JOptionPane.showInputDialog("Ingrese el numero de telefono:");
                        if (Validaciones.validarCadena(tel)) {
                            mostrarAviso("El campo telefono no puede quedar vacio.");
                        } else {
                            if (Validaciones.validarCampoNumerico(tel) == false) {
                                mostrarAviso("El campo telefono debe ser un valor numerico.");
                            } else {
                                telefono.setTelefono(tel);
                                String res = daoProv.insertarTelefono(telefono);
                                mostrarMensaje(res);
                                formularioModificarProv.getComboTelefono().addItem(tel);
                            }
                        }
                    }

                } catch (Exception ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (e.getSource() == formularioModificarProv.getBotonEliminarTelefono()) {

                if (formularioModificarProv.getComboTelefono().getSelectedIndex() == -1) {
                    mostrarAviso("No existen telefonos asociados al proveedor.");
                } else {
                    try {
                        int resp = JOptionPane.showConfirmDialog(ventanaPrincipal.getEscritorio(), "¿Está seguro de eliminar el telefono?");
                        if (resp == JOptionPane.YES_OPTION) {
                            String res = daoProv.eliminarTelefono(formularioModificarProv.getComboTelefono().getSelectedItem().toString().trim());
                            mostrarMensaje(res);
                            formularioModificarProv.getComboTelefono().removeItemAt(formularioModificarProv.getComboTelefono().getSelectedIndex());
                        }
                    } catch (Exception ex) {
                        Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }

            if (e.getSource() == formularioModificarProv.getBotonCerrarVentana()) {
                try {
                    int cantR = daoProv.retornarCantRegistrosTelefono(Integer.parseInt(formularioModificarProv.getTxtIdProv().getText()));
                    formularioModificarProv.setVisible(false);
                    for (int i = 0; i < cantR; i++) {
                        formularioModificarProv.getComboTelefono().removeItemAt(0);
                    }
                } catch (Exception ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (e.getSource() == ventanaModificarProveedor.getBotonBuscar()) {
                try {
                    if (Validaciones.validarCampoTexto(ventanaModificarProveedor.getTxtBuscarProv())) {
                        mostrarAviso("Ingrese el criterio de busqueda.");
                    } else {
                        llenarTablaProveedor(ventanaModificarProveedor.getTablaBuscarProv(), daoProv.buscar(ventanaModificarProveedor.getTxtBuscarProv().getText(), "General"));
                        if (daoProv.buscar(ventanaModificarProveedor.getTxtBuscarProv().getText(), "General").isEmpty()) {
                            mostrarAviso("Registro no encontrado");
                            ventanaModificarProveedor.getTxtBuscarProv().setText("");
                            llenarTablaProveedor(ventanaModificarProveedor.getTablaBuscarProv(), daoProv.listar("Todos"));
                        }
                    }

                } catch (Exception ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (e.getSource() == ventanaModificarProveedor.getBotonRefrescar()) {
                try {
                    llenarTablaProveedor(ventanaModificarProveedor.getTablaBuscarProv(), daoProv.listar("Todos"));
                    ventanaModificarProveedor.getTxtBuscarProv().setText("");
                } catch (Exception ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (e.getSource() == formularioModificarProv.getBotonAgregarPC()) {
                try {
                    formularioAgregarPerConct.setVisible(true);
                    formularioAgregarPerConct.getTituloVentana().setHorizontalAlignment(JLabel.CENTER);
                    formularioAgregarPerConct.setLocation((ventanaPrincipal.getEscritorio().getWidth() - formularioAgregarPerConct.getWidth()) / 2, (ventanaPrincipal.getEscritorio().getHeight() - formularioAgregarPerConct.getHeight()) / 2);
                } catch (Exception ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (e.getSource() == formularioAgregarPerConct.getBotonCerrarVentana()) {
                formularioAgregarPerConct.setVisible(false);
            }
            if (e.getSource() == formularioAgregarPerConct.getBotonLimpiarFormulario()) {
                formularioAgregarPerConct.getTxtNombrePC().setText("");
                formularioAgregarPerConct.getTxtTelefonoPC().setText("");
            }

            if (e.getSource() == formularioModificarProv.getBotonAgregarPC()) {
                try {
                    formularioAgregarPerConct.setVisible(true);
                    formularioAgregarPerConct.getTituloVentana().setHorizontalAlignment(JLabel.CENTER);
                    formularioAgregarPerConct.setLocation((ventanaPrincipal.getEscritorio().getWidth() - formularioAgregarPerConct.getWidth()) / 2, (ventanaPrincipal.getEscritorio().getHeight() - formularioAgregarPerConct.getHeight()) / 2);
                } catch (Exception ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (e.getSource() == formularioAgregarPerConct.getBotonAgregarPC()) {
                if (Validaciones.validarCampoTexto(formularioAgregarPerConct.getTxtNombrePC()) || Validaciones.validarCampoTexto(formularioAgregarPerConct.getTxtTelefonoPC())) {
                    mostrarAviso("No pueden quedar campos vacios.");
                } else {
                    try {
                        PersonaDeContacto pc = new PersonaDeContacto();
                        pc.setNombre(formularioAgregarPerConct.getTxtNombrePC().getText());
                        pc.setTelefono(formularioAgregarPerConct.getTxtTelefonoPC().getText());
                        pc.setId_proveedor(Integer.parseInt(formularioModificarProv.getTxtIdProv().getText()));
                        String res = daoProv.insertarPersonaDeContacto(pc, Integer.parseInt(formularioModificarProv.getTxtIdProv().getText()));
                        mostrarMensaje(res);
                    } catch (Exception ex) {
                        Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

            if (e.getSource() == formularioModificarProv.getBotonModificarPC()) {

                if (formularioModificarProv.getTablaPerContacto().getRowCount() == 0) {
                    mostrarAviso("No existen personas de contacto asociadas a este proveedor.");
                } else {
                    if (formularioModificarProv.getTablaPerContacto().getSelectedRow() == -1) {
                        JOptionPane.showMessageDialog(ventanaPrincipal.getEscritorio(), "Debe seleccionar una persona de contacto.");
                    } else {
                        if (formularioModificarProv.getTablaPerContacto().getSelectedRowCount() > 1) {
                            mostrarAviso("Seleccione un cregistro a la vez. ");
                        } else {
                            try {
                                formularioModificarPerConct.setVisible(true);
                                formularioModificarPerConct.getTituloVentana().setHorizontalAlignment(JLabel.CENTER);
                                inhabilitarCampos(formularioModificarPerConct.getTxtIdPC());
                                formularioModificarPerConct.setLocation((ventanaPrincipal.getEscritorio().getWidth() - formularioModificarPerConct.getWidth()) / 2, (ventanaPrincipal.getEscritorio().getHeight() - formularioModificarPerConct.getHeight()) / 2);
                            } catch (Exception ex) {
                                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                }
            }

            if (e.getSource() == formularioModificarPerConct.getBotonModificarPC()) {
                if (Validaciones.validarCampoTexto(formularioModificarPerConct.getTxtNombrePC())
                        || Validaciones.validarCampoTexto(formularioModificarPerConct.getTxtTelefonoPC())) {
                    mostrarAviso("No pueden quedar campos vacios.");
                } else {
                    try {
                        PersonaDeContacto pc = new PersonaDeContacto();
                        pc.setNombre(formularioModificarPerConct.getTxtNombrePC().getText());
                        pc.setTelefono(formularioModificarPerConct.getTxtTelefonoPC().getText());
                        String res = daoProv.modificarPC(pc, Integer.parseInt(formularioModificarProv.getTxtIdProv().getText()));
                        mostrarMensaje(res);
                    } catch (Exception ex) {
                        Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

            if (e.getSource() == formularioModificarPerConct.getBotonCerrarVentana()) {
                formularioModificarPerConct.setVisible(false);
            }
            if (e.getSource() == formularioModificarPerConct.getBotonLimpiarFormulario()) {
                formularioModificarPerConct.getTxtNombrePC().setText("");
                formularioModificarPerConct.getTxtTelefonoPC().setText("");
            }

            if (e.getSource() == formularioModificarProv.getBotonActualizarPC()) {
                try {
                    llenarTablaPC(formularioModificarProv.getTablaPerContacto(), daoProv.listarPC(Integer.parseInt(formularioModificarProv.getTxtIdProv().getText())));
                } catch (Exception ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (e.getSource() == formularioModificarProv.getBotonEliminarPC()) {
                if (formularioModificarProv.getTablaPerContacto().getRowCount() == 0) {
                    mostrarAviso("No existen personas de contacto asociadas a este proveedor.");
                } else {
                    eliminarFilaPC(formularioModificarProv.getTablaPerContacto());
                }
            }

            //VENTANA ELIMINAR PROVEEDOR
            if (e.getSource() == ventanaEliminarProveedor.getBotonAceptarEliminar()) {
                eliminarFilaProveedor(ventanaEliminarProveedor.getTablaBuscarProv());
            }

            if (e.getSource() == ventanaEliminarProveedor.getBotonCerrarVentana()) {
                ventanaEliminarProveedor.setVisible(false);
            }

            if (e.getSource() == ventanaEliminarProveedor.getBotonBuscar()) {
                try {
                    if (Validaciones.validarCampoTexto(ventanaEliminarProveedor.getTxtBuscarProv())) {
                        mostrarAviso("Ingrese el criterio de busqueda.");
                    } else {
                        llenarTablaProveedor(ventanaEliminarProveedor.getTablaBuscarProv(), daoProv.buscar(ventanaEliminarProveedor.getTxtBuscarProv().getText(), "Activos"));
                        if (daoProv.buscar(ventanaEliminarProveedor.getTxtBuscarProv().getText(), "Activos").isEmpty()) {
                            mostrarAviso("Registro no encontrado");
                            ventanaEliminarProveedor.getTxtBuscarProv().setText("");
                            llenarTablaProveedor(ventanaEliminarProveedor.getTablaBuscarProv(), daoProv.listar("Activos"));
                        }
                    }

                } catch (Exception ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (e.getSource() == ventanaEliminarProveedor.getBotonRefrescar()) {
                try {
                    llenarTablaProveedor(ventanaEliminarProveedor.getTablaBuscarProv(), daoProv.listar("Activos"));
                    ventanaEliminarCliente.getTxtBuscarCliente().setText("");
                } catch (Exception ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (e.getSource() == ventanaEliminarProveedor.getBotonActualizaProv()) {
                try {
                    llenarTablaProveedor(ventanaEliminarProveedor.getTablaBuscarProv(), daoProv.listar("Activos"));
                } catch (Exception ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            //VENTANA AGREGAR VENDEDOR
            if (e.getSource() == ventanaAgregarVendedor.getBotonAgregarProveedor()) {
                String res = "";
                try {
                    if (Validaciones.validarCampoTexto(ventanaAgregarVendedor.getTxtNombreProveedor()) == false
                            && Validaciones.validarCampoTexto(ventanaAgregarVendedor.getTxtTelefonoProveedor()) == false) {

                        if (daoVend.validarExistente("id", "VENDEDOR", "nombre", ventanaAgregarVendedor.getTxtNombreProveedor().getText()) == 1) {
                            mostrarAviso("Ya existe un vendedor con el nombre ingresado.");
                        } else {
                            if (daoVend.validarExistente("id", "VENDEDOR", "telefono", ventanaAgregarVendedor.getTxtTelefonoProveedor().getText()) == 1) {
                                mostrarAviso("Ya existe un vendedor con el telefono ingresado.");
                            } else {
                                Vendedor v = new Vendedor();
                                v.setNombre(ventanaAgregarVendedor.getTxtNombreProveedor().getText());
                                v.setTelefono(ventanaAgregarVendedor.getTxtTelefonoProveedor().getText());
                                res = daoVend.registrar(v);
                                mostrarMensaje(res);
                            }
                        }

                    } else {
                        mostrarAviso("No pueden quedar campos sin ingresar.");
                    }

                } catch (Exception ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (e.getSource() == ventanaAgregarVendedor.getBotonCerrarVentana1()) {
                ventanaAgregarVendedor.setVisible(false);
            }

            if (e.getSource() == ventanaAgregarVendedor.getBotonLimpiarFormulario1()) {
                ventanaAgregarVendedor.getTxtNombreProveedor().setText("");
                ventanaAgregarVendedor.getTxtTelefonoProveedor().setText("");
            }

            //VENTANA MODIFICAR VENDEDOR
            if (e.getSource() == ventanaModificarVendedor.getBotonAceptarModificar()) {

                if (ventanaModificarVendedor.getTablaBuscarProv().getSelectedRow() == -1) {
                    mostrarAviso("Debe seleccionar un proveedor.");
                } else {
                    if (ventanaModificarVendedor.getTablaBuscarProv().getSelectedRowCount() > 1) {
                        mostrarAviso("Seleccione un proveedor a la vez. ");
                    } else {
                        try {
                            formularioModificarVend.setVisible(true);
                            formularioModificarVend.getTituloModificar().setHorizontalAlignment(JLabel.CENTER);
                            formularioModificarVend.setLocation((ventanaPrincipal.getEscritorio().getWidth() - formularioModificarVend.getWidth()) / 2, (ventanaPrincipal.getEscritorio().getHeight() - formularioModificarVend.getHeight()) / 2);
                            inhabilitarCampos(formularioModificarVend.getTxtIdVendedor());
                        } catch (Exception ex) {
                            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }

            if (e.getSource() == formularioModificarVend.getBotonModificarVendedor()) {
                if (Validaciones.validarCampoTexto(formularioModificarVend.getTxtNombreVendedor())
                        || Validaciones.validarCampoTexto(formularioModificarVend.getTxtTelefonoVendedor())) {
                    mostrarAviso("No pueden quedar campos vacios.");
                } else {
                    try {
                        Vendedor v = new Vendedor();
                        v.setNombre(formularioModificarVend.getTxtNombreVendedor().getText());
                        v.setTelefono(formularioModificarVend.getTxtTelefonoVendedor().getText());
                        v.setEstado(formularioModificarVend.getComboEstado().getSelectedItem().toString());
                        String res = daoVend.modificar(v, Integer.parseInt(formularioModificarVend.getTxtIdVendedor().getText()));
                        mostrarMensaje(res);
                    } catch (Exception ex) {
                        Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

            if (e.getSource() == ventanaModificarVendedor.getBotonCerrarVentana()) {
                ventanaModificarVendedor.setVisible(false);
            }

            if (e.getSource() == formularioModificarVend.getBotonCerrarVentana1()) {
                formularioModificarVend.setVisible(false);
            }

            if (e.getSource() == formularioModificarVend.getBotonLimpiarFormulario1()) {
                formularioModificarVend.getTxtNombreVendedor().setText("");
                formularioModificarVend.getTxtTelefonoVendedor().setText("");
            }

            if (e.getSource() == ventanaModificarVendedor.getBotonActualizarProv()) {
                try {
                    llenarTablaVendedor(ventanaModificarVendedor.getTablaBuscarProv(), daoVend.listar("Todos"));
                } catch (Exception ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (e.getSource() == ventanaModificarVendedor.getBotonBuscar()) {
                try {
                    if (Validaciones.validarCampoTexto(ventanaModificarVendedor.getTxtBuscarProv())) {
                        mostrarAviso("Ingrese el criterio de busqueda.");
                    } else {
                        llenarTablaVendedor(ventanaModificarVendedor.getTablaBuscarProv(), daoVend.buscar(ventanaModificarVendedor.getTxtBuscarProv().getText(), "General"));
                        if (daoVend.buscar(ventanaModificarVendedor.getTxtBuscarProv().getText(), "General").isEmpty()) {
                            mostrarAviso("Registro no encontrado");
                            ventanaModificarVendedor.getTxtBuscarProv().setText("");
                            llenarTablaVendedor(ventanaModificarVendedor.getTablaBuscarProv(), daoVend.listar("Todos"));
                        }
                    }

                } catch (Exception ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (e.getSource() == ventanaModificarVendedor.getBotonRefrescar()) {
                try {
                    llenarTablaVendedor(ventanaModificarVendedor.getTablaBuscarProv(), daoVend.listar("Todos"));
                    ventanaModificarVendedor.getTxtBuscarProv().setText("");
                } catch (Exception ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            //VENTANA AGREGAR CLIENTE
            if (e.getSource() == ventanaAgregarCliente.getBotonAgregarCliente()) {
                String res = "";

                if (Validaciones.validarCampoTexto(ventanaAgregarCliente.getTxtNombreCliente()) == false && Validaciones.validarCampoTexto(ventanaAgregarCliente.getTxtDireccionCliente()) == false
                        && Validaciones.validarCampoTexto(ventanaAgregarCliente.getTxtCorreoCliente()) == false && Validaciones.validarCampoTexto(ventanaAgregarCliente.getTxtTelefonoCliente()) == false) {
                    try {
                        Cliente cliente = new Cliente();
                        cliente.setNombre(ventanaAgregarCliente.getTxtNombreCliente().getText());
                        cliente.setDireccion(ventanaAgregarCliente.getTxtDireccionCliente().getText());
                        cliente.setCorreo(ventanaAgregarCliente.getTxtCorreoCliente().getText());
                        cliente.setEstado("Activo");
                        res = daoCliente.registrar(cliente);
                        mostrarMensaje(res);

                        Telefono_Cliente telefono = new Telefono_Cliente();
                        telefono.setId_cliente(daoCliente.retornarMax());
                        telefono.setTelefono(ventanaAgregarCliente.getTxtTelefonoCliente().getText());
                        res = daoCliente.insertarTelefono(telefono);
                        mostrarMensaje(res);

                    } catch (Exception ex) {
                        Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    mostrarAviso("No pueden quedar campos sin ingresar.");
                }
            }

            if (e.getSource() == ventanaAgregarCliente.getBotonLimpiarFormulario()) {
                ventanaAgregarCliente.getTxtNombreCliente().setText("");
                ventanaAgregarCliente.getTxtDireccionCliente().setText("");
                ventanaAgregarCliente.getTxtCorreoCliente().setText("");
                ventanaAgregarCliente.getTxtTelefonoCliente().setText("");
            }

            if (e.getSource() == ventanaAgregarCliente.getBotonCerrarVentana()) {
                ventanaAgregarCliente.setVisible(false);
            }

            //VENTANA MODIFICAR CLIENTE
            if (e.getSource() == ventanaModificarCliente.getBotonAceptarModificar()) {

                if (ventanaModificarCliente.getTablaBuscarCliente().getSelectedRow() == -1) {
                    JOptionPane.showMessageDialog(ventanaPrincipal.getEscritorio(), "Debe seleccionar un cliente.");
                } else {
                    if (ventanaModificarCliente.getTablaBuscarCliente().getSelectedRowCount() > 1) {
                        mostrarAviso("Seleccione un cliente a la vez. ");
                    } else {
                        try {
                            formularioModificarCliente.setVisible(true);
                            llenarComboTelefonoCliente(formularioModificarCliente.getComboTelefono(), daoCliente.listarTelefonos(Integer.parseInt(formularioModificarCliente.getTxtIdCliente().getText())));
                            inhabilitarCampos(formularioModificarCliente.getTxtIdCliente());
                            formularioModificarCliente.setLocation((ventanaPrincipal.getEscritorio().getWidth() - formularioModificarCliente.getWidth()) / 2, (ventanaPrincipal.getEscritorio().getHeight() - formularioModificarCliente.getHeight()) / 2);
                        } catch (Exception ex) {
                            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }

            if (e.getSource() == formularioModificarCliente.getBotonLimpiarFormulario()) {
                formularioModificarCliente.getTxtNombreCliente().setText("");
                formularioModificarCliente.getTxtDireccionCliente().setText("");
                formularioModificarCliente.getTxtCorreoCliente().setText("");
            }

            if (e.getSource() == formularioModificarCliente.getBotonModificarCliente()) {
                if (Validaciones.validarCampoTexto(formularioModificarCliente.getTxtNombreCliente())
                        || Validaciones.validarCampoTexto(formularioModificarCliente.getTxtDireccionCliente())
                        || Validaciones.validarCampoTexto(formularioModificarCliente.getTxtCorreoCliente())) {
                    mostrarAviso("No pueden quedar campos vacios.");
                } else {
                    try {
                        Cliente cliente = new Cliente();
                        cliente.setNombre(formularioModificarCliente.getTxtNombreCliente().getText());
                        cliente.setDireccion(formularioModificarCliente.getTxtDireccionCliente().getText());
                        cliente.setCorreo(formularioModificarCliente.getTxtCorreoCliente().getText());
                        cliente.setEstado(formularioModificarCliente.getComboEstado().getSelectedItem().toString());
                        String res = daoCliente.modificar(cliente, Integer.parseInt(formularioModificarCliente.getTxtIdCliente().getText()));
                        mostrarMensaje(res);
                    } catch (Exception ex) {
                        Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

            if (e.getSource() == ventanaModificarCliente.getBotonActualizarCliente()) {
                try {
                    llenarTablaCliente(ventanaModificarCliente.getTablaBuscarCliente(), daoCliente.listar("Todos"));
                } catch (Exception ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (e.getSource() == formularioModificarCliente.getBotonAgregarTelefono()) {
                try {
                    Telefono_Cliente telefono = new Telefono_Cliente();
                    telefono.setId_cliente(Integer.parseInt(formularioModificarCliente.getTxtIdCliente().getText()));
                    int cantR = daoCliente.retornarCantRegistrosTelefono(Integer.parseInt(formularioModificarCliente.getTxtIdCliente().getText()));

                    if (cantR == 2) {
                        mostrarAviso("Un cliente no puede tener mas de 2 telefonos.");
                    } else {
                        String tel = JOptionPane.showInputDialog("Ingrese el numero de telefono:");
                        if (Validaciones.validarCadena(tel)) {
                            mostrarAviso("El campo telefono no puede quedar vacio.");
                        } else {
                            if (Validaciones.validarCampoNumerico(tel) == false) {
                                mostrarAviso("El campo telefono debe ser un valor numerico.");
                            } else {
                                telefono.setTelefono(tel);
                                String res = daoCliente.insertarTelefono(telefono);
                                mostrarMensaje(res);
                                formularioModificarCliente.getComboTelefono().addItem(tel);
                            }
                        }
                    }

                } catch (Exception ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (e.getSource() == formularioModificarCliente.getBotonEliminarTelefono()) {

                if (formularioModificarCliente.getComboTelefono().getSelectedIndex() == -1) {
                    mostrarAviso("No existen telefonos asociados al cliente.");
                } else {
                    try {
                        int resp = JOptionPane.showConfirmDialog(ventanaPrincipal.getEscritorio(), "¿Está seguro de eliminar el telefono?");
                        if (resp == JOptionPane.YES_OPTION) {
                            String res = daoCliente.eliminarTelefono(formularioModificarCliente.getComboTelefono().getSelectedItem().toString().trim());
                            mostrarMensaje(res);
                            formularioModificarCliente.getComboTelefono().removeItemAt(formularioModificarCliente.getComboTelefono().getSelectedIndex());
                        }
                    } catch (Exception ex) {
                        Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }

            if (e.getSource() == formularioModificarCliente.getBotonCerrarVentana()) {
                try {
                    int cantR = daoCliente.retornarCantRegistrosTelefono(Integer.parseInt(formularioModificarCliente.getTxtIdCliente().getText()));
                    formularioModificarCliente.setVisible(false);
                    for (int i = 0; i < cantR; i++) {
                        formularioModificarCliente.getComboTelefono().removeItemAt(0);
                    }
                } catch (Exception ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (e.getSource() == ventanaModificarCliente.getBotonCerrarVentana()) {
                ventanaModificarCliente.setVisible(false);
            }

            if (e.getSource() == ventanaModificarCliente.getBotonBuscar()) {
                try {
                    if (Validaciones.validarCampoTexto(ventanaModificarCliente.getTxtBuscarCliente())) {
                        mostrarAviso("Ingrese el criterio de busqueda.");
                    } else {
                        llenarTablaCliente(ventanaModificarCliente.getTablaBuscarCliente(), daoCliente.buscar(ventanaModificarCliente.getTxtBuscarCliente().getText(), "General"));

                        if (daoCliente.buscar(ventanaModificarCliente.getTxtBuscarCliente().getText(), "General").isEmpty()) {
                            mostrarAviso("Registro no encontrado");
                            ventanaModificarCliente.getTxtBuscarCliente().setText("");
                            llenarTablaCliente(ventanaModificarCliente.getTablaBuscarCliente(), daoCliente.listar("Todos"));
                        }
                    }

                } catch (Exception ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (e.getSource() == ventanaModificarCliente.getBotonRefrescar()) {
                try {
                    llenarTablaCliente(ventanaModificarCliente.getTablaBuscarCliente(), daoCliente.listar("Todos"));
                    ventanaModificarCliente.getTxtBuscarCliente().setText("");
                } catch (Exception ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            //VENTANA ELIMINAR CLIENTE
            if (e.getSource() == ventanaEliminarCliente.getBotonAceptarEliminar()) {
                eliminarFilaCliente(ventanaEliminarCliente.getTablaBuscarCliente());
            }

            if (e.getSource() == ventanaEliminarCliente.getBotonCerrarVentana()) {
                ventanaEliminarCliente.setVisible(false);
            }

            if (e.getSource() == ventanaEliminarCliente.getBotonBuscar()) {
                try {
                    if (Validaciones.validarCampoTexto(ventanaEliminarCliente.getTxtBuscarCliente())) {
                        mostrarAviso("Ingrese el criterio de busqueda.");
                    } else {
                        llenarTablaCliente(ventanaEliminarCliente.getTablaBuscarCliente(), daoCliente.buscar(ventanaEliminarCliente.getTxtBuscarCliente().getText(), "Activos"));
                        if (daoCliente.buscar(ventanaEliminarCliente.getTxtBuscarCliente().getText(), "Activos").isEmpty()) {
                            mostrarAviso("Registro no encontrado");
                            ventanaEliminarCliente.getTxtBuscarCliente().setText("");
                            llenarTablaCliente(ventanaEliminarCliente.getTablaBuscarCliente(), daoCliente.listar("Activos"));
                        }
                    }

                } catch (Exception ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (e.getSource() == ventanaEliminarCliente.getBotonRefrescar()) {
                try {
                    llenarTablaCliente(ventanaEliminarCliente.getTablaBuscarCliente(), daoCliente.listar("Activos"));
                    ventanaEliminarCliente.getTxtBuscarCliente().setText("");
                } catch (Exception ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (e.getSource() == ventanaEliminarCliente.getBotonActualizarCliente()) {
                try {
                    llenarTablaCliente(ventanaEliminarCliente.getTablaBuscarCliente(), daoCliente.listar("Activos"));
                } catch (Exception ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            //VENTANA AGREGAR MUEBLE
            if (e.getSource() == ventanaAgregarMueble.getOpcNo()) {
                ventanaAgregarMueble.getComboColorMueble().setEnabled(false);
                ventanaAgregarMueble.getComboMaterialMueble().setEnabled(false);
                ventanaAgregarMueble.getComboTipoMueble().setEnabled(false);
                habilitarCampos(ventanaAgregarMueble.getTxtNuevoColor());
                habilitarCampos(ventanaAgregarMueble.getTxtNuevoMaterial());
                habilitarCampos(ventanaAgregarMueble.getTxtNuevoTipoMueble());
            }
            if (e.getSource() == ventanaAgregarMueble.getOpcSi()) {
                ventanaAgregarMueble.getComboColorMueble().setEnabled(true);
                ventanaAgregarMueble.getComboMaterialMueble().setEnabled(true);
                ventanaAgregarMueble.getComboTipoMueble().setEnabled(true);
                inhabilitarCampos(ventanaAgregarMueble.getTxtNuevoColor());
                inhabilitarCampos(ventanaAgregarMueble.getTxtNuevoMaterial());
                inhabilitarCampos(ventanaAgregarMueble.getTxtNuevoTipoMueble());
            }

            if (e.getSource() == ventanaAgregarMueble.getBotonAgregarMueble()) {
                try {
                    Mueble mueble = new Mueble();
                    if (ventanaAgregarMueble.getComboColorMueble().isEnabled() && ventanaAgregarMueble.getComboMaterialMueble().isEnabled()
                            && ventanaAgregarMueble.getComboTipoMueble().isEnabled()) {
                        mueble.setId_tipo_mueble(ventanaAgregarMueble.getComboTipoMueble().getSelectedItem().toString());
                        mueble.setId_material(ventanaAgregarMueble.getComboMaterialMueble().getSelectedItem().toString());
                        mueble.setId_color(ventanaAgregarMueble.getComboColorMueble().getSelectedItem().toString());
                    } else {
                        if (Validaciones.validarCampoTexto(ventanaAgregarMueble.getTxtNuevoColor()) || Validaciones.validarCampoTexto(ventanaAgregarMueble.getTxtNuevoMaterial())
                                || Validaciones.validarCampoTexto(ventanaAgregarMueble.getTxtNuevoTipoMueble())) {
                            mostrarAviso("Los campos 'Tipo de mueble', 'Material' y 'Color' no pueden quedar vacios. Por favor ingreselos.");
                        } else {

                            try {
                                Tipo_Mueble tipo_mueble = new Tipo_Mueble();
                                tipo_mueble.setTipo_mueble(ventanaAgregarMueble.getTxtNuevoTipoMueble().getText());
                                String res = daoTipoMueble.registrar(tipo_mueble);

                                Color colorMueble = new Color();
                                colorMueble.setColor(ventanaAgregarMueble.getTxtNuevoColor().getText());
                                res = daoColor.registrar(colorMueble);

                                Material materialMueble = new Material();
                                materialMueble.setMaterial(ventanaAgregarMueble.getTxtNuevoMaterial().getText());
                                res = daoMaterial.registrar(materialMueble);

                                mueble.setId_tipo_mueble(ventanaAgregarMueble.getTxtNuevoTipoMueble().getText());
                                mueble.setId_material(ventanaAgregarMueble.getTxtNuevoMaterial().getText());
                                mueble.setId_color(ventanaAgregarMueble.getTxtNuevoColor().getText());
                            } catch (Exception ex) {
                                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }

                    if (Integer.parseInt(ventanaAgregarMueble.getSpinerAlto().getValue().toString()) < 0 || Integer.parseInt(ventanaAgregarMueble.getSpinerAncho().getValue().toString()) < 0
                            || Integer.parseInt(ventanaAgregarMueble.getSpinerLargo().getValue().toString()) < 0) {
                        mostrarAviso("Los valores de la dimension no pueden ser negativos.");
                        ventanaAgregarMueble.getSpinerAlto().setValue(0);
                        ventanaAgregarMueble.getSpinerAncho().setValue(0);
                        ventanaAgregarMueble.getSpinerLargo().setValue(0);
                    } else {
                        if (Integer.parseInt(ventanaAgregarMueble.getSpinerAlto().getValue().toString()) == 0 || Integer.parseInt(ventanaAgregarMueble.getSpinerAncho().getValue().toString()) == 0
                                || Integer.parseInt(ventanaAgregarMueble.getSpinerLargo().getValue().toString()) == 0) {
                            mostrarAviso("Los valores de la dimension no pueden ser cero.");
                        } else {

                            if (Validaciones.validarCampoTexto(ventanaAgregarMueble.getTxtPrecioUnitario()) || Validaciones.validarCampoTexto(ventanaAgregarMueble.getTxtStock())
                                    || Validaciones.validarAreaTexto(ventanaAgregarMueble.getAreaDescripcion())) {
                                mostrarAviso("Los campos 'Precio unitario', 'Stock' y 'Descripcion no pueden quedar vacios. Por favor ingreselos.");
                            } else {
                                mueble.setLargo(Integer.parseInt(ventanaAgregarMueble.getSpinerLargo().getValue().toString()));
                                mueble.setAncho(Integer.parseInt(ventanaAgregarMueble.getSpinerAncho().getValue().toString()));
                                mueble.setAlto(Integer.parseInt(ventanaAgregarMueble.getSpinerAlto().getValue().toString()));
                                mueble.setPrecio_unitario(Integer.parseInt(ventanaAgregarMueble.getTxtPrecioUnitario().getText()));
                                mueble.setDescripcion(ventanaAgregarMueble.getAreaDescripcion().getText());
                                mueble.setStock(Integer.parseInt(ventanaAgregarMueble.getTxtStock().getText()));
                                mueble.setEstado("Activo");

                                String res = daoMueble.registrar(mueble);
                                mostrarMensaje(res);
                            }
                        }
                    }

                } catch (Exception ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (e.getSource() == ventanaAgregarMueble.getBotonLimpiarCampos()) {
                ventanaAgregarMueble.getSpinerAlto().setValue(0);
                ventanaAgregarMueble.getSpinerAncho().setValue(0);
                ventanaAgregarMueble.getSpinerLargo().setValue(0);
            }

            if (e.getSource() == ventanaAgregarMueble.getBotonCerrarVentana()) {
                ventanaAgregarMueble.setVisible(false);
            }

            //VENTANA MODIFICAR MUEBLE
            if (e.getSource() == ventanaModificarMueble.getBotonAceptarModificar()) {
                if (ventanaModificarMueble.getTablaBuscarMueble().getSelectedRow() == -1) {
                    JOptionPane.showMessageDialog(ventanaPrincipal.getEscritorio(), "Debe seleccionar un mueble.");
                } else {
                    if (ventanaModificarMueble.getTablaBuscarMueble().getSelectedRowCount() > 1) {
                        mostrarAviso("Seleccione un mueble a la vez. ");
                    } else {
                        formularioModificarMueble.setVisible(true);
                        inhabilitarCampos(formularioModificarMueble.getTxtIdMueble());
                        inhabilitarCampos(formularioModificarMueble.getTxtTipoMueble());
                        inhabilitarCampos(formularioModificarMueble.getTxtMaterial());
                        inhabilitarCampos(formularioModificarMueble.getTxtColor());
                        inhabilitarCampos(formularioModificarMueble.getTxtLargo());
                        inhabilitarCampos(formularioModificarMueble.getTxtAncho());
                        inhabilitarCampos(formularioModificarMueble.getTxtAlto());
                        formularioModificarMueble.setLocation((ventanaPrincipal.getEscritorio().getWidth() - formularioModificarMueble.getWidth()) / 2, (ventanaPrincipal.getEscritorio().getHeight() - formularioModificarMueble.getHeight()) / 2);
                    }
                }
            }

            if (e.getSource() == formularioModificarMueble.getBotonCerrarVentana()) {
                formularioModificarMueble.setVisible(false);
            }
            if (e.getSource() == formularioModificarMueble.getBotonModificarMueble()) {
                if (Validaciones.validarCampoTexto(formularioModificarMueble.getTxtIPrecioUnitario())) {
                    mostrarAviso("No pueden quedar campos vacios.");
                } else {
                    try {
                        Mueble mueble = new Mueble();
                        mueble.setId_tipo_mueble(formularioModificarMueble.getTxtTipoMueble().getText());
                        mueble.setId_material(formularioModificarMueble.getTxtMaterial().getText());
                        mueble.setLargo(Float.parseFloat(formularioModificarMueble.getTxtLargo().getText()));
                        mueble.setAncho(Float.parseFloat(formularioModificarMueble.getTxtAncho().getText()));
                        mueble.setAlto(Float.parseFloat(formularioModificarMueble.getTxtAlto().getText()));
                        mueble.setId_color(formularioModificarMueble.getTxtColor().getText());
                        mueble.setPrecio_unitario(Float.parseFloat(formularioModificarMueble.getTxtIPrecioUnitario().getText()));
                        mueble.setDescripcion(formularioModificarMueble.getAreaDescripcion().getText());
                        mueble.setStock(Integer.parseInt(formularioModificarMueble.getEtiquetaStockActual().getText()));
                        mueble.setEstado(formularioModificarMueble.getComboEstado().getSelectedItem().toString());
                        String res = daoMueble.modificar(mueble, Integer.parseInt(formularioModificarMueble.getTxtIdMueble().getText()), "Varios");
                        mostrarMensaje(res);
                    } catch (Exception ex) {
                        Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            if (e.getSource() == ventanaModificarMueble.getBotonActualizarMueble()) {
                try {
                    llenarTablaMueble(ventanaModificarMueble.getTablaBuscarMueble(), daoMueble.listar("Todos"), "Mueble_Admin");
                } catch (Exception ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (e.getSource() == ventanaModificarMueble.getBotonBuscar()) {
                try {
                    if (Validaciones.validarCampoTexto(ventanaModificarMueble.getTxtBuscarMueble())) {
                        mostrarAviso("Ingrese el criterio de busqueda.");
                    } else {
                        llenarTablaMueble(ventanaModificarMueble.getTablaBuscarMueble(), daoMueble.buscar(ventanaModificarMueble.getTxtBuscarMueble().getText(), "General"), "Mueble_Admin");
                        if (daoMueble.buscar(ventanaModificarMueble.getTxtBuscarMueble().getText(), "General").isEmpty()) {
                            mostrarAviso("Registro no encontrado");
                            ventanaModificarMueble.getTxtBuscarMueble().setText("");
                            llenarTablaMueble(ventanaModificarMueble.getTablaBuscarMueble(), daoMueble.listar("Todos"), "Mueble_Admin");
                        }
                    }
                } catch (Exception ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (e.getSource() == ventanaModificarMueble.getBotonRefrescar()) {
                try {
                    llenarTablaMueble(ventanaModificarMueble.getTablaBuscarMueble(), daoMueble.listar("Todos"), "Mueble_Admin");
                    ventanaModificarMueble.getTxtBuscarMueble().setText("");
                } catch (Exception ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (e.getSource() == ventanaModificarMueble.getBotonCerrarVentana()) {
                ventanaModificarMueble.setVisible(false);
            }

            if (e.getSource() == formularioModificarMueble.getBotonRegistrarStock()) {
                int stockActual = 0, nvoStock = 0;
                String res = "";
                if (Validaciones.validarCampoTexto(formularioModificarMueble.getTxtStock())) {
                    mostrarAviso("El campo stock no puede quedar vacio.");
                } else {
                    if (Integer.parseInt(formularioModificarMueble.getTxtStock().getText()) <= 0) {
                        mostrarAviso("El campo stock no puede ser menor o igual a cero.");
                        formularioModificarMueble.getTxtStock().setText("");
                    } else {
                        try {
                            stockActual = Integer.parseInt(formularioModificarMueble.getEtiquetaStockActual().getText());
                            nvoStock = stockActual + Integer.parseInt(formularioModificarMueble.getTxtStock().getText());
                            res = daoMueble.modificarStock(nvoStock, Integer.parseInt(formularioModificarMueble.getTxtIdMueble().getText()));
                            mostrarMensaje(res);
                            formularioModificarMueble.getEtiquetaStockActual().setText(Integer.toString(nvoStock));
                            formularioModificarMueble.getTxtStock().setText("");
                        } catch (Exception ex) {
                            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }

                Integer.parseInt(formularioModificarMueble.getEtiquetaStockActual().getText());

            }

            //VENTANA ELIMINAR MUEBLE
            if (e.getSource() == ventanaEliminarMueble.getBotonBuscar()) {
                try {
                    if (Validaciones.validarCampoTexto(ventanaEliminarMueble.getTxtBuscarMueble())) {
                        mostrarAviso("Ingrese el criterio de busqueda.");
                    } else {
                        llenarTablaMueble(ventanaEliminarMueble.getTablaBuscarMueble(), daoMueble.buscar(ventanaEliminarMueble.getTxtBuscarMueble().getText(), "Activos"), "Mueble_Admin");
                        if (daoMueble.buscar(ventanaEliminarMueble.getTxtBuscarMueble().getText(), "Activos").isEmpty()) {
                            mostrarAviso("Registro no encontrado");
                            ventanaEliminarMueble.getTxtBuscarMueble().setText("");
                            llenarTablaMueble(ventanaEliminarMueble.getTablaBuscarMueble(), daoMueble.listar("Activos"), "Mueble_Admin");
                        }
                    }
                } catch (Exception ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (e.getSource() == ventanaEliminarMueble.getBotonRefrescar()) {
                try {
                    llenarTablaMueble(ventanaEliminarMueble.getTablaBuscarMueble(), daoMueble.listar("Activos"), "Mueble_Admin");
                    ventanaEliminarMueble.getTxtBuscarMueble().setText("");
                } catch (Exception ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (e.getSource() == ventanaEliminarMueble.getBotonCerrarVentana()) {
                ventanaEliminarMueble.setVisible(false);
            }

            if (e.getSource() == ventanaEliminarMueble.getBotonActualizarMueble()) {
                try {
                    llenarTablaMueble(ventanaEliminarMueble.getTablaBuscarMueble(), daoMueble.listar("Activos"), "Mueble_Admin");
                } catch (Exception ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (e.getSource() == ventanaEliminarMueble.getBotonAceptarEliminar()) {
                eliminarFilaMueble(ventanaEliminarMueble.getTablaBuscarMueble());
            }

            //VENTANA VENTAS
            if (e.getSource() == ventanaVentas.getBotonAgregarMueble()) {
                try {
                    formularioVenta.setVisible(true);
                    formularioVenta.setLocation((ventanaPrincipal.getEscritorio().getWidth() - formularioVenta.getWidth()) / 2, (ventanaPrincipal.getEscritorio().getHeight() - formularioVenta.getHeight()) / 2);
                    llenarTablaMueble(formularioVenta.getTablaBuscarMueble(), daoMueble.listar("Venta_mueble"), "Mueble_Venta");
                } catch (Exception ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (e.getSource() == ventanaVentas.getBotonCancelarVenta()) {
                ventanaVentas.setVisible(false);
            }

            //FORMULARIO VENTAS
            if (e.getSource() == formularioVenta.getBotonAgregarMueble()) {
                DefaultTableModel modeloVentas = (DefaultTableModel) ventanaVentas.getTablaProductosVenta().getModel();
                int filaSeleccionada = formularioVenta.getTablaBuscarMueble().getSelectedRow();

                if (filaSeleccionada == -1) {
                    mostrarAviso("Debe seleccionar un registro.");
                } else {
                    if (formularioVenta.getTablaBuscarMueble().getSelectedRowCount() > 1) {
                        mostrarAviso("Seleccione un registro a la vez.");
                    } else {
                        int resp = JOptionPane.showConfirmDialog(ventanaPrincipal.getEscritorio(), "¿Desea agregar el producto?");
                        if (resp == JOptionPane.YES_OPTION) {
                            if (formularioVenta.getTxtCantidad().getText().equals("")) {
                                mostrarAviso("Debe ingresar la cantidad del producto.");
                            } else {
                                if (Integer.parseInt(formularioVenta.getTxtCantidad().getText()) <= 0) {
                                    mostrarAviso("La cantidad debe ser mayor a cero.");
                                } else {
                                    int id = (int) formularioVenta.getTablaBuscarMueble().getValueAt(filaSeleccionada, 0);
                                    float precio_unitario = (float) formularioVenta.getTablaBuscarMueble().getValueAt(filaSeleccionada, 2);
                                    int cantidad = Integer.parseInt(formularioVenta.getTxtCantidad().getText().toString());
                                    String descripcion = (String) formularioVenta.getTablaBuscarMueble().getValueAt(filaSeleccionada, 1);
                                    float total = precio_unitario * cantidad;

                                    Object[] fila_a_agregar = {id, descripcion, precio_unitario, cantidad, total};
                                    modeloVentas.addRow(fila_a_agregar);
                                    establecerTamColumnasMueble(ventanaVentas.getTablaProductosVenta(), "Mueble_Venta");
                                    mostrarAviso("Producto agregado con exito.");
                                }
                            }
                        }
                    }
                }
            }

            if (e.getSource() == formularioVenta.getBotonCerrarVentana()) {
                formularioVenta.setVisible(false);
            }
            if (e.getSource() == formularioVenta.getBotonRefrescar()) {
                try {
                    llenarTablaMueble(formularioVenta.getTablaBuscarMueble(), daoMueble.listar("Venta_mueble"), "Mueble_Venta");
                    formularioVenta.getTxtBuscarMueble().setText("");
                } catch (Exception ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (e.getSource() == formularioVenta.getBotonBuscar()) {
                try {
                    if (Validaciones.validarCampoTexto(formularioVenta.getTxtBuscarMueble())) {
                        mostrarAviso("Ingrese el criterio de busqueda.");
                    } else {
                        llenarTablaMueble(formularioVenta.getTablaBuscarMueble(), daoMueble.buscar(formularioVenta.getTxtBuscarMueble().getText(), "General"), "Mueble_Venta");
                        if (daoMueble.buscar(formularioVenta.getTxtBuscarMueble().getText(), "General").isEmpty()) {
                            mostrarAviso("Registro no encontrado");
                            formularioVenta.getTxtBuscarMueble().setText("");
                            llenarTablaMueble(formularioVenta.getTablaBuscarMueble(), daoMueble.listar("Todos"), "Mueble_Venta");
                        }
                    }

                } catch (Exception ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            //FORMULARIO CLIENTE
            if (e.getSource() == ventanaVentas.getBotonBuscarCliente()) {
                try {
                    ventanaListar.setVisible(true);
                    ventanaListar.getTituloListar().setText("LISTA DE CLIENTES");
                    ventanaListar.getTituloListar().setHorizontalAlignment(JLabel.CENTER);
                    llenarTablaCliente(ventanaListar.getTablaBuscarCliente(), daoCliente.listar("Cliente_Venta"));
                    ventanaListar.setLocation((ventanaPrincipal.getEscritorio().getWidth() - ventanaListar.getWidth()) / 2, (ventanaPrincipal.getEscritorio().getHeight() - ventanaListar.getHeight()) / 2);
                } catch (Exception ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (e.getSource() == ventanaListar.getBotonBuscar()) {
                try {
                    if (Validaciones.validarCampoTexto(ventanaListar.getTxtBuscarCliente())) {
                        mostrarAviso("Ingrese el criterio de busqueda.");
                    } else {
                        llenarTablaCliente(ventanaListar.getTablaBuscarCliente(), daoCliente.buscar(ventanaListar.getTxtBuscarCliente().getText(), "Activos"));
                        if (daoCliente.buscar(ventanaListar.getTxtBuscarCliente().getText(), "Activos").isEmpty()) {
                            mostrarAviso("Registro no encontrado");
                            ventanaListar.getTxtBuscarCliente().setText("");
                            llenarTablaCliente(ventanaListar.getTablaBuscarCliente(), daoCliente.buscar(ventanaListar.getTxtBuscarCliente().getText(), "Activos"));
                        }
                    }

                } catch (Exception ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (e.getSource() == ventanaListar.getBotonAgregarCliente()) {

                int filaSeleccionada = ventanaListar.getTablaBuscarCliente().getSelectedRow();

                if (filaSeleccionada == -1) {
                    mostrarAviso("Debe seleccionar un registro.");
                } else {
                    if (ventanaListar.getTablaBuscarCliente().getSelectedRowCount() > 1) {
                        mostrarAviso("Seleccione un registro a la vez.");
                    } else {
                        int resp = JOptionPane.showConfirmDialog(ventanaPrincipal.getEscritorio(), "¿Desea agregar el cliente?");
                        if (resp == JOptionPane.YES_OPTION) {
                            ventanaVentas.getEtiquetaIdCliente().setText(ventanaListar.getTablaBuscarCliente().getValueAt(filaSeleccionada, 0).toString());
                            ventanaVentas.getEtiquetaNombreCliente().setText(ventanaListar.getTablaBuscarCliente().getValueAt(filaSeleccionada, 1).toString());
                            ventanaVentas.getEtiquetaDireccionCliente().setText(ventanaListar.getTablaBuscarCliente().getValueAt(filaSeleccionada, 2).toString());
                            ventanaVentas.getEtiquetaCorreo().setText(ventanaListar.getTablaBuscarCliente().getValueAt(filaSeleccionada, 3).toString());
                            JOptionPane.showMessageDialog(ventanaListar, "Cliente agregado con exito.");
                        }
                    }
                }
            }

            if (e.getSource() == ventanaListar.getBotonCerrarVentana()) {
                ventanaListar.setVisible(false);
            }

            if (e.getSource() == ventanaListar.getBotonRefrescar()) {
                try {
                    llenarTablaCliente(ventanaListar.getTablaBuscarCliente(), daoCliente.listar("Activos"));
                    ventanaListar.getTxtBuscarCliente().setText("");
                } catch (Exception ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (e.getSource() == ventanaVentas.getBotonBuscarProv()) {
                if (ventanaVentas.getTxtIdProv().getText().equals("")) {
                    mostrarAviso("El campo ID no puede quedar vacio.");
                } else {
                    if (Integer.parseInt(ventanaVentas.getTxtIdProv().getText()) <= 0) {
                        mostrarAviso("El campo ID debe ser mayor que cero.");
                    } else {
                        /* try {
                            ArrayList<Vendedor> resultado = daoProv.buscar(ventanaVentas.getTxtIdProv().getText(), "Activos");
                            if (resultado.isEmpty()) {
                                mostrarAviso("No se ha encontrado un proveedor con ese ID.");
                                ventanaVentas.getTxtIdProv().setText("");
                                ventanaVentas.getEtiquetaNombreProv().setText("");
                            }else{
                                ventanaVentas.getEtiquetaNombreProv().setText(resultado.get(0).getNombre());
                            }
                        } catch (Exception ex) {
                            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                         */
                    }
                }
            }

        }
    }

    private class ManejoTeclado extends KeyAdapter {

        @Override
        public void keyTyped(KeyEvent e) {
            try {
                //PROVEEDOR
                if (e.getSource() == ventanaModificarProveedor.getTxtBuscarProv()) {
                    if (ventanaModificarProveedor.getTxtBuscarProv().getText().equals("")) {
                        llenarTablaProveedor(ventanaModificarProveedor.getTablaBuscarProv(), daoProv.buscar(ventanaModificarProveedor.getTxtBuscarProv().getText(), "General"));
                    }
                }

                //CLIENTE    
                if (e.getSource() == ventanaModificarCliente.getTxtBuscarCliente()) {
                    if (ventanaModificarCliente.getTxtBuscarCliente().getText().equals("")) {
                        llenarTablaCliente(ventanaModificarCliente.getTablaBuscarCliente(), daoCliente.buscar(ventanaModificarCliente.getTxtBuscarCliente().getText(), "General"));
                    }
                } else if (e.getSource() == ventanaEliminarCliente.getTxtBuscarCliente()) {
                    if (ventanaEliminarCliente.getTxtBuscarCliente().getText().equals("")) {
                        llenarTablaCliente(ventanaEliminarCliente.getTablaBuscarCliente(), daoCliente.buscar(ventanaEliminarCliente.getTxtBuscarCliente().getText(), "Activos"));
                    }
                } else if (e.getSource() == ventanaListar.getTxtBuscarCliente()) {
                    if (ventanaListar.getTxtBuscarCliente().getText().equals("")) {
                        llenarTablaCliente(ventanaListar.getTablaBuscarCliente(), daoCliente.buscar(ventanaListar.getTxtBuscarCliente().getText(), "Activos"));
                    }
                }
                //MUEBLE
                if (e.getSource() == ventanaModificarMueble.getTxtBuscarMueble()) {
                    if (ventanaModificarMueble.getTxtBuscarMueble().getText().equals("")) {
                        llenarTablaMueble(ventanaModificarMueble.getTablaBuscarMueble(), daoMueble.buscar(ventanaModificarMueble.getTxtBuscarMueble().getText(), "General"), "Mueble_Admin");
                    }

                } else if (e.getSource() == ventanaEliminarMueble.getTxtBuscarMueble()) {
                    if (ventanaEliminarMueble.getTxtBuscarMueble().getText().equals("")) {
                        llenarTablaMueble(ventanaEliminarMueble.getTablaBuscarMueble(), daoMueble.buscar(ventanaEliminarMueble.getTxtBuscarMueble().getText(), "Activos"), "Mueble_Admin");
                    }
                } else if (e.getSource() == formularioVenta.getTxtBuscarMueble()) {
                    if (formularioVenta.getTxtBuscarMueble().getText().equals("")) {
                        llenarTablaMueble(formularioVenta.getTablaBuscarMueble(), daoMueble.listar("Venta_mueble"), "Mueble_Venta");
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class ManejoTablaBuscarProv extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent e) {
            int filaSeleccionada = ventanaModificarProveedor.getTablaBuscarProv().getSelectedRow();
            formularioModificarProv.getTxtIdProv().setText(ventanaModificarProveedor.getTablaBuscarProv().getValueAt(filaSeleccionada, 0).toString());
            formularioModificarProv.getTxtNombreProv().setText(ventanaModificarProveedor.getTablaBuscarProv().getValueAt(filaSeleccionada, 1).toString());
            formularioModificarProv.getTxtDireccionProv().setText(ventanaModificarProveedor.getTablaBuscarProv().getValueAt(filaSeleccionada, 2).toString());
        }
    }

    private class ManejoTablaPC extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent e) {
            int filaSeleccionada = formularioModificarProv.getTablaPerContacto().getSelectedRow();
            formularioModificarPerConct.getTxtIdPC().setText(formularioModificarProv.getTablaPerContacto().getValueAt(filaSeleccionada, 0).toString());
            formularioModificarPerConct.getTxtNombrePC().setText(formularioModificarProv.getTablaPerContacto().getValueAt(filaSeleccionada, 1).toString());
            formularioModificarPerConct.getTxtTelefonoPC().setText(formularioModificarProv.getTablaPerContacto().getValueAt(filaSeleccionada, 2).toString());
        }
    }

    private class ManejoTablaBuscarCliente extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent e) {
            int filaSeleccionada = ventanaModificarCliente.getTablaBuscarCliente().getSelectedRow();
            formularioModificarCliente.getTxtIdCliente().setText(ventanaModificarCliente.getTablaBuscarCliente().getValueAt(filaSeleccionada, 0).toString());
            formularioModificarCliente.getTxtNombreCliente().setText(ventanaModificarCliente.getTablaBuscarCliente().getValueAt(filaSeleccionada, 1).toString());
            formularioModificarCliente.getTxtDireccionCliente().setText(ventanaModificarCliente.getTablaBuscarCliente().getValueAt(filaSeleccionada, 2).toString());
            formularioModificarCliente.getTxtCorreoCliente().setText(ventanaModificarCliente.getTablaBuscarCliente().getValueAt(filaSeleccionada, 3).toString());
        }
    }

    private class ManejoTablaBuscarVend extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent e) {
            int filaSeleccionada = ventanaModificarVendedor.getTablaBuscarProv().getSelectedRow();
            formularioModificarVend.getTxtIdVendedor().setText(ventanaModificarVendedor.getTablaBuscarProv().getValueAt(filaSeleccionada, 0).toString());
            formularioModificarVend.getTxtNombreVendedor().setText(ventanaModificarVendedor.getTablaBuscarProv().getValueAt(filaSeleccionada, 1).toString());
            formularioModificarVend.getTxtTelefonoVendedor().setText(ventanaModificarVendedor.getTablaBuscarProv().getValueAt(filaSeleccionada, 2).toString());

        }
    }

    private class ManejoTablaBuscarMueble extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent e) {
            int filaSeleccionada = ventanaModificarMueble.getTablaBuscarMueble().getSelectedRow();
            formularioModificarMueble.getTxtIdMueble().setText(ventanaModificarMueble.getTablaBuscarMueble().getValueAt(filaSeleccionada, 0).toString());
            formularioModificarMueble.getTxtTipoMueble().setText(ventanaModificarMueble.getTablaBuscarMueble().getValueAt(filaSeleccionada, 1).toString());
            formularioModificarMueble.getTxtMaterial().setText(ventanaModificarMueble.getTablaBuscarMueble().getValueAt(filaSeleccionada, 2).toString());
            formularioModificarMueble.getTxtColor().setText(ventanaModificarMueble.getTablaBuscarMueble().getValueAt(filaSeleccionada, 6).toString());
            formularioModificarMueble.getTxtLargo().setText(ventanaModificarMueble.getTablaBuscarMueble().getValueAt(filaSeleccionada, 3).toString());
            formularioModificarMueble.getTxtAncho().setText(ventanaModificarMueble.getTablaBuscarMueble().getValueAt(filaSeleccionada, 4).toString());
            formularioModificarMueble.getTxtAlto().setText(ventanaModificarMueble.getTablaBuscarMueble().getValueAt(filaSeleccionada, 5).toString());
            formularioModificarMueble.getAreaDescripcion().setText(ventanaModificarMueble.getTablaBuscarMueble().getValueAt(filaSeleccionada, 8).toString());
            formularioModificarMueble.getEtiquetaDescripcion().setText(ventanaModificarMueble.getTablaBuscarMueble().getValueAt(filaSeleccionada, 8).toString());
            formularioModificarMueble.getTxtIPrecioUnitario().setText(ventanaModificarMueble.getTablaBuscarMueble().getValueAt(filaSeleccionada, 7).toString());
            formularioModificarMueble.getEtiquetaStockActual().setText(ventanaModificarMueble.getTablaBuscarMueble().getValueAt(filaSeleccionada, 9).toString());
        }
    }

    public void eliminarFilaCliente(JTable tabla) {

        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        int filaSeleccionada = tabla.getSelectedRow();

        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(ventanaPrincipal.getEscritorio(), "Debe seleccionar un registro.");
        } else {
            if (tabla.getSelectedRowCount() > 1) {
                mostrarAviso("Seleccione un registro a la vez.");
            } else {
                int resp = JOptionPane.showConfirmDialog(ventanaPrincipal.getEscritorio(), "¿Está seguro de eliminar el registro?");
                if (resp == JOptionPane.YES_OPTION) {
                    try {
                        Cliente cliente = new Cliente();
                        cliente.setNombre(tabla.getValueAt(filaSeleccionada, 1).toString());
                        cliente.setDireccion(tabla.getValueAt(filaSeleccionada, 2).toString());
                        cliente.setCorreo(tabla.getValueAt(filaSeleccionada, 3).toString());
                        cliente.setEstado("inactivo");
                        String res = daoCliente.modificar(cliente, Integer.parseInt(tabla.getValueAt(filaSeleccionada, 0).toString()));
                        modelo.removeRow(filaSeleccionada);
                        mostrarMensaje(res);
                    } catch (Exception ex) {
                        Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }

    public void eliminarFilaProveedor(JTable tabla) {

        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        int filaSeleccionada = tabla.getSelectedRow();

        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(ventanaPrincipal.getEscritorio(), "Debe seleccionar un registro.");
        } else {
            if (tabla.getSelectedRowCount() > 1) {
                mostrarAviso("Seleccione un registro a la vez.");
            } else {
                int resp = JOptionPane.showConfirmDialog(ventanaPrincipal.getEscritorio(), "¿Está seguro de eliminar el registro?");
                if (resp == JOptionPane.YES_OPTION) {
                    try {
                        Proveedor prov = new Proveedor();
                        prov.setNombre(tabla.getValueAt(filaSeleccionada, 1).toString());
                        prov.setDireccion(tabla.getValueAt(filaSeleccionada, 2).toString());
                        prov.setEstado("inactivo");
                        String res = daoProv.modificar(prov, Integer.parseInt(tabla.getValueAt(filaSeleccionada, 0).toString()));
                        modelo.removeRow(filaSeleccionada);
                        mostrarMensaje(res);
                    } catch (Exception ex) {
                        Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }

    public void eliminarFilaPC(JTable tabla) {

        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        int filaSeleccionada = tabla.getSelectedRow();

        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(ventanaPrincipal.getEscritorio(), "Debe seleccionar un registro.");
        } else {
            if (tabla.getSelectedRowCount() > 1) {
                mostrarAviso("Seleccione un registro a la vez.");
            } else {
                int resp = JOptionPane.showConfirmDialog(ventanaPrincipal.getEscritorio(), "¿Está seguro de eliminar el registro?");
                if (resp == JOptionPane.YES_OPTION) {
                    try {
                        String res = daoProv.eliminarrPC(Integer.parseInt(formularioModificarProv.getTablaPerContacto().getValueAt(filaSeleccionada, 0).toString()));
                        modelo.removeRow(filaSeleccionada);
                        mostrarMensaje(res);
                    } catch (Exception ex) {
                        Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }

    public void eliminarFilaMueble(JTable tabla) {

        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        int filaSeleccionada = tabla.getSelectedRow();

        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(ventanaPrincipal.getEscritorio(), "Debe seleccionar un registro.");
        } else {
            if (tabla.getSelectedRowCount() > 1) {
                mostrarAviso("Seleccione un registro a la vez.");
            } else {
                int resp = JOptionPane.showConfirmDialog(ventanaPrincipal.getEscritorio(), "¿Está seguro de eliminar el registro?");
                if (resp == JOptionPane.YES_OPTION) {
                    try {
                        Mueble mueble = new Mueble();
                        mueble.setEstado("Inactivo");
                        String res = daoMueble.modificar(mueble, Integer.parseInt(tabla.getValueAt(filaSeleccionada, 0).toString()), "Estado");
                        modelo.removeRow(filaSeleccionada);
                        mostrarMensaje(res);
                    } catch (Exception ex) {
                        Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }

    public void mostrarMensaje(String m) {
        if (m != null) {
            JOptionPane.showMessageDialog(ventanaPrincipal.getEscritorio(), m);
        } else {
            JOptionPane.showMessageDialog(ventanaPrincipal.getEscritorio(), "Error de registro.");
        }
    }

    public void mostrarAviso(String m) {
        Toolkit t = Toolkit.getDefaultToolkit();
        t.beep();
        JOptionPane.showMessageDialog(ventanaPrincipal.getEscritorio(), m);
    }

    public void llenarTablaProveedor(JTable tabla, ArrayList<Proveedor> listaC) {

        try {
            DefaultTableModel modelo = new DefaultTableModel();
            String cabeceraCliente[] = new String[]{"ID", "NOMBRE", "DIRECCION", "ESTADO"};
            modelo.setColumnIdentifiers(cabeceraCliente);
            ArrayList<Proveedor> lista = listaC;
            for (int i = 0; i < lista.size(); i++) {
                modelo.addRow(new Object[]{
                    lista.get(i).getId(),
                    lista.get(i).getNombre(),
                    lista.get(i).getDireccion(),
                    lista.get(i).getEstado()
                });
            }
            tabla.setModel(modelo);
            establecerTamColumnasProveedor(tabla);
        } catch (Exception ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void llenarTablaVendedor(JTable tabla, ArrayList<Vendedor> listaC) {

        try {
            DefaultTableModel modelo = new DefaultTableModel();
            String cabeceraCliente[] = new String[]{"ID", "NOMBRE", "TELEFONO", "ESTADO"};
            modelo.setColumnIdentifiers(cabeceraCliente);
            ArrayList<Vendedor> lista = listaC;
            for (int i = 0; i < lista.size(); i++) {
                modelo.addRow(new Object[]{
                    lista.get(i).getId(),
                    lista.get(i).getNombre(),
                    lista.get(i).getTelefono(),
                    lista.get(i).getEstado()
                });
            }
            tabla.setModel(modelo);
            establecerTamColumnasProveedor(tabla);
        } catch (Exception ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void llenarTablaPC(JTable tabla, ArrayList<PersonaDeContacto> listaC) {
        try {
            DefaultTableModel modelo = new DefaultTableModel();
            String cabeceraCliente[] = new String[]{"ID", "NOMBRE", "TELEFONO"};
            modelo.setColumnIdentifiers(cabeceraCliente);
            ArrayList<PersonaDeContacto> lista = listaC;
            for (int i = 0; i < lista.size(); i++) {
                modelo.addRow(new Object[]{
                    lista.get(i).getId(),
                    lista.get(i).getNombre(),
                    lista.get(i).getTelefono()
                });
            }
            tabla.setModel(modelo);
            establecerTamColumnasPC(tabla);
        } catch (Exception ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void llenarTablaCliente(JTable tabla, ArrayList<Cliente> listaC) {

        try {
            DefaultTableModel modelo = new DefaultTableModel();
            String cabeceraCliente[] = new String[]{"ID", "NOMBRE", "DIRECCION", "CORREO", "ESTADO"};
            modelo.setColumnIdentifiers(cabeceraCliente);
            ArrayList<Cliente> lista = listaC;
            for (int i = 0; i < lista.size(); i++) {
                modelo.addRow(new Object[]{
                    lista.get(i).getId(),
                    lista.get(i).getNombre(),
                    lista.get(i).getDireccion(),
                    lista.get(i).getCorreo(),
                    lista.get(i).getEstado()
                });
            }
            tabla.setModel(modelo);
            establecerTamColumnasCliente(tabla);
        } catch (Exception ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void llenarTablaMueble(JTable tabla, ArrayList<Mueble> listaC, String tipo_tabla) {
        String cabeceraMueble[] = null;
        DefaultTableModel modelo = new DefaultTableModel();

        try {
            if (tipo_tabla.equals("Mueble_Admin")) {
                cabeceraMueble = new String[]{"ID", "TIPO DE MUEBLE", "MATERIAL", "LARGO", "ANCHO", "ALTO", "COLOR", "PRECIO UNITARIO", "DESCRIPCION", "STOCK", "ESTADO"};
                modelo.setColumnIdentifiers(cabeceraMueble);
                ArrayList<Mueble> lista = listaC;
                for (int i = 0; i < lista.size(); i++) {
                    modelo.addRow(new Object[]{
                        lista.get(i).getId(),
                        lista.get(i).getId_tipo_mueble(),
                        lista.get(i).getId_material(),
                        lista.get(i).getLargo(),
                        lista.get(i).getAncho(),
                        lista.get(i).getAlto(),
                        lista.get(i).getId_color(),
                        lista.get(i).getPrecio_unitario(),
                        lista.get(i).getDescripcion(),
                        lista.get(i).getStock(),
                        lista.get(i).getEstado()
                    });
                }
                tabla.setModel(modelo);
                establecerTamColumnasMueble(tabla, "Mueble_Admin");
            } else if (tipo_tabla.equals("Mueble_Venta")) {
                cabeceraMueble = new String[]{"ID", "DESCRIPCION", "PRECIO UNITARIO", "STOCK", "ESTADO"};
                modelo.setColumnIdentifiers(cabeceraMueble);
                ArrayList<Mueble> lista = listaC;
                for (int i = 0; i < lista.size(); i++) {
                    modelo.addRow(new Object[]{
                        lista.get(i).getId(),
                        lista.get(i).getDescripcion(),
                        lista.get(i).getPrecio_unitario(),
                        lista.get(i).getStock(),
                        lista.get(i).getEstado()
                    });
                }
                tabla.setModel(modelo);
                establecerTamColumnasMueble(tabla, "Mueble_Venta");
            }
        } catch (Exception ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void llenarComboTipoMueble(JComboBox combo, ArrayList<Tipo_Mueble> lista) {
        for (int i = 0; i < lista.size(); i++) {
            combo.addItem(lista.get(i).getTipo_mueble());
        }
    }

    public void llenarComboMaterial(JComboBox combo, ArrayList<Material> lista) {
        for (int i = 0; i < lista.size(); i++) {
            combo.addItem(lista.get(i).getMaterial());
        }
    }

    public void llenarComboColor(JComboBox combo, ArrayList<Color> lista) {
        for (int i = 0; i < lista.size(); i++) {
            combo.addItem(lista.get(i).getColor());
        }
    }

    public void llenarComboTelefonoCliente(JComboBox combo, ArrayList<Telefono_Cliente> lista) {
        for (int i = 0; i < lista.size(); i++) {
            combo.addItem(lista.get(i).getTelefono());
        }
    }

    public void llenarComboTelefonoProveedor(JComboBox combo, ArrayList<Telefono_Proveedor> lista) {
        for (int i = 0; i < lista.size(); i++) {
            combo.addItem(lista.get(i).getTelefono());
        }
    }

    public void inhabilitarCampos(JTextField campo) {
        campo.setEditable(false);
        campo.setEnabled(false);
    }

    public void habilitarCampos(JTextField campo) {
        campo.setEditable(true);
        campo.setEnabled(true);
    }

    public void establecerTamColumnasProveedor(JTable tabla) {
        int anchoColumnas[] = new int[]{40, 220, 130, 70};
        anchoColumnas(tabla, anchoColumnas);
        altoFilas(tabla);
    }

    public void establecerTamColumnasPC(JTable tabla) {
        int anchoColumnas[] = new int[]{40, 220, 70};
        anchoColumnas(tabla, anchoColumnas);
        altoFilas(tabla);
    }

    public void establecerTamColumnasCliente(JTable tabla) {
        int anchoColumnas[] = new int[]{40, 220, 130, 203, 50};
        anchoColumnas(tabla, anchoColumnas);
        altoFilas(tabla);
    }

    public void establecerTamColumnasMueble(JTable tabla, String tipo_tabla) {
        int anchoColumnas[] = null;
        if (tipo_tabla.equals("Mueble_Admin")) {
            anchoColumnas = new int[]{40, 180, 150, 50, 50, 50, 100, 100, 300, 50, 70};
        } else if (tipo_tabla.equals("Mueble_Venta")) {
            anchoColumnas = new int[]{40, 300, 100, 50, 70};
        }
        anchoColumnas(tabla, anchoColumnas);
        altoFilas(tabla);
    }

    public void anchoColumnas(JTable tabla, int anchoColumnas[]) {
        for (int i = 0; i < tabla.getColumnCount(); i++) {
            tabla.getColumnModel().getColumn(i).setPreferredWidth(anchoColumnas[i]);
        }
    }

    public void altoFilas(JTable tabla) {
        for (int i = 0; i < tabla.getRowCount(); i++) {
            tabla.setRowHeight(i, 20);
        }
    }
}
