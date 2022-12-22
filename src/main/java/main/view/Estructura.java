package main.view;

import java.awt.Color;
import main.controller.*;
import java.util.*;
import javax.swing.*;
import main.library.CustomTabbedPane;
import main.library.ImagenPath;
import main.library.Objetos;

public class Estructura extends javax.swing.JFrame {

    private Object object;

    public Estructura(Object object) {
        this.object = object;
        initComponents();
        eventosEstructura();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabbedPanePrincipal = new CustomTabbedPane();
        panelMateriales = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbMateriales = new javax.swing.JTable();
        lblTitulo = new javax.swing.JLabel();
        spinner = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        btnPrimero = new javax.swing.JButton();
        btnAnterior = new javax.swing.JButton();
        btnSiguiente = new javax.swing.JButton();
        btnUltimo = new javax.swing.JButton();
        lblPaginador = new javax.swing.JLabel();
        lblBuscador = new javax.swing.JLabel();
        txtBuscador = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnAgregarNuevoMaterial = new javax.swing.JButton();
        btnEliminarMaterial = new javax.swing.JButton();
        lblNombreMaterial = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblUnidadMaterial = new javax.swing.JLabel();
        cbxUnidad = new javax.swing.JComboBox<>();
        lblLimiteMinimoMat = new javax.swing.JLabel();
        lblCantidadMaterial = new javax.swing.JLabel();
        lblSkuMat = new javax.swing.JLabel();
        txtSku = new javax.swing.JTextField();
        cbxClasificacion = new javax.swing.JComboBox<>();
        lblClasificacionMat = new javax.swing.JLabel();
        cbxTiendas = new javax.swing.JComboBox<>();
        lblTiendaMat = new javax.swing.JLabel();
        lblTituloFecha = new javax.swing.JLabel();
        lblFechaIngreso = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        txtLimiteMinimo = new javax.swing.JTextField();
        filler6 = new javax.swing.Box.Filler(new java.awt.Dimension(260, 0), new java.awt.Dimension(260, 0), new java.awt.Dimension(260, 32767));
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(260, 0), new java.awt.Dimension(260, 0), new java.awt.Dimension(260, 32767));
        filler5 = new javax.swing.Box.Filler(new java.awt.Dimension(260, 0), new java.awt.Dimension(260, 0), new java.awt.Dimension(260, 32767));
        jPanel13 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        panelSalidas = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        tabbedPaneSalidas = new CustomTabbedPane(Color.GRAY, Color.BLACK, Color.
            WHITE);
        jPanel7 = new javax.swing.JPanel();
        lblBuscadorSalida = new javax.swing.JLabel();
        txtBuscadorSalida = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbSalidas = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        spinnerSalidas = new javax.swing.JSpinner();
        btnPrimeroSalidas = new javax.swing.JButton();
        btnAnteriorSalidas = new javax.swing.JButton();
        btnSiguienteSalidas = new javax.swing.JButton();
        btnUltimoSalida = new javax.swing.JButton();
        lblPaginadorSalidas = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbEmpleadoSalida = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbMaterialesSalida = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        lblConceptoSalida = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtAreaConcepto = new javax.swing.JTextArea();
        lblEmpleadoSolicitante = new javax.swing.JLabel();
        txtEmpleadoSalida = new javax.swing.JTextField();
        lblAreaEmpleadoSolicitante = new javax.swing.JLabel();
        txtAreaEmpleadoSol = new javax.swing.JTextField();
        lblMaterialSolicitado = new javax.swing.JLabel();
        txtMaterialSolicitado = new javax.swing.JTextField();
        lblCantidadSalida = new javax.swing.JLabel();
        txtCantidadSalida = new javax.swing.JTextField();
        lblUnidadMaterialSolicitado = new javax.swing.JLabel();
        txtUnidadMaterialSolicitado = new javax.swing.JTextField();
        lblTituloFechaSalida = new javax.swing.JLabel();
        lblFechaSalida = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnAgregarSalida = new javax.swing.JButton();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(260, 0), new java.awt.Dimension(260, 0), new java.awt.Dimension(260, 32767));
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(260, 0), new java.awt.Dimension(260, 0), new java.awt.Dimension(260, 32767));
        panelEmpleados = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btnAgregarNuevoEmpleado = new javax.swing.JButton();
        btnEliminarEmpleado = new javax.swing.JButton();
        lblNombreEmpleado = new javax.swing.JLabel();
        txtNombreEmpleado = new javax.swing.JTextField();
        lblTelefono = new javax.swing.JLabel();
        lblApellidoPaterno = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        cbxAreaEmpleados = new javax.swing.JComboBox<>();
        lblArea = new javax.swing.JLabel();
        txtApellidoPaterno = new javax.swing.JTextField();
        lblApellidoMaterno = new javax.swing.JLabel();
        txtApellidoMaterno = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        jcbContratado = new javax.swing.JCheckBox();
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(260, 0), new java.awt.Dimension(260, 0), new java.awt.Dimension(260, 32767));
        lblNid = new javax.swing.JLabel();
        txtNid = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbEmpleados = new javax.swing.JTable();
        lblTitulo1 = new javax.swing.JLabel();
        spinnerEmpleados = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        btnPrimeroEmpleados = new javax.swing.JButton();
        btnAnteriorEmpleados = new javax.swing.JButton();
        btnSiguienteEmpleados = new javax.swing.JButton();
        btnUltimoEmpleados = new javax.swing.JButton();
        lblPaginadorEmpleados = new javax.swing.JLabel();
        lblBuscadorEmpleados = new javax.swing.JLabel();
        txtBuscadorEmpleados = new javax.swing.JTextField();
        jMenuBar = new javax.swing.JMenuBar();
        jMenuAjustes = new javax.swing.JMenu();
        menuItemAreas = new javax.swing.JMenuItem();
        menuItemClasificaciones = new javax.swing.JMenuItem();
        menuItemTiendas = new javax.swing.JMenuItem();
        menuItemUnidades = new javax.swing.JMenuItem();
        jMenuCerrar = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(815, 680));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tbMateriales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbMateriales.getTableHeader().setReorderingAllowed(false);
        tbMateriales.setSelectionMode(0);
        tbMateriales.getTableHeader().setResizingAllowed(false);
        jScrollPane1.setViewportView(tbMateriales);

        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Materiales");

        jLabel1.setText("Registros por pagina");

        btnPrimero.setFocusPainted(false);

        btnAnterior.setFocusPainted(false);

        btnSiguiente.setFocusPainted(false);

        btnUltimo.setFocusPainted(false);

        lblPaginador.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPaginador.setText("Paginas");

        lblBuscador.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 958, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblBuscador, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtBuscador, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(spinner, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(130, 130, 130)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnPrimero, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnUltimo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lblPaginador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBuscador, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscador, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addComponent(jScrollPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblPaginador))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spinner, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPrimero, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUltimo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnAgregarNuevoMaterial.setFocusPainted(false);

        //EVENTOS MATERIAL CONTROLLER
        eventosMaterial();

        btnEliminarMaterial.setFocusPainted(false);

        lblNombreMaterial.setText("Nombre del material");

        txtNombre.setPreferredSize(new java.awt.Dimension(64, 30));

        lblUnidadMaterial.setText("Unidad");

        lblLimiteMinimoMat.setText("Limite minimo");

        lblCantidadMaterial.setText("Cantidad");

        lblSkuMat.setText("SKU:");

        lblClasificacionMat.setText("Clasificacion");

        cbxTiendas.setToolTipText("");

        lblTiendaMat.setText("Tiendas");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFechaIngreso, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btnEliminarMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAgregarNuevoMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbxUnidad, 0, 206, Short.MAX_VALUE)
                            .addComponent(txtSku)
                            .addComponent(cbxClasificacion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbxTiendas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblNombreMaterial)
                            .addComponent(lblCantidadMaterial)
                            .addComponent(lblUnidadMaterial)
                            .addComponent(lblLimiteMinimoMat)
                            .addComponent(lblSkuMat)
                            .addComponent(lblTiendaMat)
                            .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblClasificacionMat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCantidad)
                            .addComponent(txtLimiteMinimo)
                            .addComponent(lblTituloFecha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(filler6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNombreMaterial)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCantidadMaterial)
                .addGap(8, 8, 8)
                .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblUnidadMaterial)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblLimiteMinimoMat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtLimiteMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(lblSkuMat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSku, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblClasificacionMat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxClasificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTiendaMat)
                .addGap(5, 5, 5)
                .addComponent(cbxTiendas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblTituloFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblFechaIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAgregarNuevoMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filler6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelMaterialesLayout = new javax.swing.GroupLayout(panelMateriales);
        panelMateriales.setLayout(panelMaterialesLayout);
        panelMaterialesLayout.setHorizontalGroup(
            panelMaterialesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMaterialesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelMaterialesLayout.setVerticalGroup(
            panelMaterialesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMaterialesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMaterialesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        tabbedPanePrincipal.addTab("Materiales", panelMateriales);

        jPanel12.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filler5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(filler5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel13.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Entradas");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 958, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addContainerGap(603, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        tabbedPanePrincipal.addTab("Entradas", jPanel11);

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tbSalidas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbSalidas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane3.setViewportView(tbSalidas);

        jLabel5.setText("Registros por pagina");

        spinnerSalidas.setValue(10);

        btnPrimeroSalidas.setFocusPainted(false);

        btnAnteriorSalidas.setFocusPainted(false);

        btnSiguienteSalidas.setFocusPainted(false);

        btnUltimoSalida.setFocusPainted(false);

        lblPaginadorSalidas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPaginadorSalidas.setText("Paginas");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(lblBuscadorSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtBuscadorSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(spinnerSalidas, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(130, 130, 130)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(btnPrimeroSalidas, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnAnteriorSalidas, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnSiguienteSalidas, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnUltimoSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lblPaginadorSalidas, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(508, Short.MAX_VALUE))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBuscadorSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBuscadorSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblPaginadorSalidas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spinnerSalidas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPrimeroSalidas, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAnteriorSalidas, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSiguienteSalidas, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUltimoSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        tabbedPaneSalidas.addTab("Lista de salidas", jPanel7);

        tbEmpleadoSalida.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbEmpleadoSalida.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane4.setViewportView(tbEmpleadoSalida);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Registro de empleados");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 946, Short.MAX_VALUE))
                    .addComponent(jScrollPane4))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabbedPaneSalidas.addTab("Empleados", jPanel8);

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Registro de materiales");

        tbMaterialesSalida.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbMaterialesSalida.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane6.setViewportView(tbMaterialesSalida);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 946, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabbedPaneSalidas.addTab("Materiales", jPanel9);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Salidas");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tabbedPaneSalidas))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabbedPaneSalidas)
                .addContainerGap())
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblConceptoSalida.setText("Concepto:");

        txtAreaConcepto.setColumns(20);
        txtAreaConcepto.setLineWrap(true);
        txtAreaConcepto.setRows(5);
        jScrollPane5.setViewportView(txtAreaConcepto);

        lblEmpleadoSolicitante.setText("Empleado solicitante:");

        lblAreaEmpleadoSolicitante.setText("Area del empleado:");

        lblMaterialSolicitado.setText("Material solicitado:");

        lblCantidadSalida.setText("Cantidad salida:");

        lblUnidadMaterialSolicitado.setText("Unidad del Material:");

        btnCancelar.setFocusPainted(false);

        btnAgregarSalida.setFocusPainted(false);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblConceptoSalida)
                            .addComponent(lblAreaEmpleadoSolicitante)
                            .addComponent(lblMaterialSolicitado)
                            .addComponent(lblUnidadMaterialSolicitado)
                            .addComponent(lblCantidadSalida)
                            .addComponent(lblEmpleadoSolicitante)
                            .addComponent(txtUnidadMaterialSolicitado)
                            .addComponent(txtCantidadSalida)
                            .addComponent(txtMaterialSolicitado)
                            .addComponent(txtAreaEmpleadoSol)
                            .addComponent(txtEmpleadoSalida, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(lblTituloFechaSalida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblFechaSalida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAgregarSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(filler2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filler3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblConceptoSalida)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEmpleadoSolicitante)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEmpleadoSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(lblAreaEmpleadoSolicitante)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAreaEmpleadoSol, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMaterialSolicitado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMaterialSolicitado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCantidadSalida)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCantidadSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblUnidadMaterialSolicitado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUnidadMaterialSolicitado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTituloFechaSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblFechaSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(filler2, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filler3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAgregarSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        eventosSalida();

        javax.swing.GroupLayout panelSalidasLayout = new javax.swing.GroupLayout(panelSalidas);
        panelSalidas.setLayout(panelSalidasLayout);
        panelSalidasLayout.setHorizontalGroup(
            panelSalidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSalidasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelSalidasLayout.setVerticalGroup(
            panelSalidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSalidasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSalidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        tabbedPanePrincipal.addTab("Salidas", panelSalidas);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setMinimumSize(new java.awt.Dimension(250, 250));

        btnAgregarNuevoEmpleado.setFocusPainted(false);

        btnEliminarEmpleado.setFocusPainted(false);

        lblNombreEmpleado.setText("Nombre");

        txtNombreEmpleado.setPreferredSize(new java.awt.Dimension(64, 30));

        lblTelefono.setText("Teléfono:");

        lblApellidoPaterno.setText("Apellido Paterno");

        lblEmail.setText("Correo electrónico:");

        lblArea.setText("Area:");

        txtApellidoPaterno.setPreferredSize(new java.awt.Dimension(64, 30));

        lblApellidoMaterno.setText("Apellido Materno");

        txtApellidoMaterno.setPreferredSize(new java.awt.Dimension(64, 30));

        txtTelefono.setPreferredSize(new java.awt.Dimension(64, 30));

        jcbContratado.setText("Contratado");

        lblNid.setText("NID");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtApellidoPaterno, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxAreaEmpleados, javax.swing.GroupLayout.Alignment.LEADING, 0, 200, Short.MAX_VALUE)
                            .addComponent(lblNombreEmpleado, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblApellidoPaterno, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTelefono, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEmail, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombreEmpleado, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblArea, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblApellidoMaterno, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtApellidoMaterno, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btnEliminarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAgregarNuevoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jcbContratado)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(filler4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNid)
                            .addComponent(txtNid, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNid)
                .addGap(5, 5, 5)
                .addComponent(txtNid, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblNombreEmpleado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombreEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblApellidoPaterno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtApellidoPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(lblApellidoMaterno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtApellidoMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblTelefono)
                .addGap(8, 8, 8)
                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblEmail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblArea)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxAreaEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jcbContratado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(filler4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAgregarNuevoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tbEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbEmpleados.getTableHeader().setReorderingAllowed(false);
        tbEmpleados.getTableHeader().setResizingAllowed(false);
        jScrollPane2.setViewportView(tbEmpleados);

        lblTitulo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo1.setText("Empleados");

        spinnerEmpleados.setValue(10);

        jLabel2.setText("Registros por pagina");

        btnPrimeroEmpleados.setFocusPainted(false);

        btnAnteriorEmpleados.setFocusPainted(false);

        btnSiguienteEmpleados.setFocusPainted(false);

        btnUltimoEmpleados.setFocusPainted(false);

        lblPaginadorEmpleados.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPaginadorEmpleados.setText("Paginas");

        lblBuscadorEmpleados.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 958, Short.MAX_VALUE)
                    .addComponent(lblTitulo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(spinnerEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(130, 130, 130)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(btnPrimeroEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnAnteriorEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnSiguienteEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnUltimoEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lblPaginadorEmpleados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(lblBuscadorEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtBuscadorEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBuscadorEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscadorEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTitulo1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblPaginadorEmpleados))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spinnerEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPrimeroEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAnteriorEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSiguienteEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUltimoEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        eventosEmpleado();

        javax.swing.GroupLayout panelEmpleadosLayout = new javax.swing.GroupLayout(panelEmpleados);
        panelEmpleados.setLayout(panelEmpleadosLayout);
        panelEmpleadosLayout.setHorizontalGroup(
            panelEmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEmpleadosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelEmpleadosLayout.setVerticalGroup(
            panelEmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEmpleadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelEmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        tabbedPanePrincipal.addTab("Empleados", panelEmpleados);

        jMenuAjustes.setText("Ajustes");

        menuItemAreas.setText("Areas");
        jMenuAjustes.add(menuItemAreas);

        menuItemClasificaciones.setText("Clasificaciones");
        jMenuAjustes.add(menuItemClasificaciones);

        menuItemTiendas.setText("Tiendas");
        jMenuAjustes.add(menuItemTiendas);

        menuItemUnidades.setText("Unidades");
        jMenuAjustes.add(menuItemUnidades);

        jMenuBar.add(jMenuAjustes);

        jMenuCerrar.setText("Cerrar");
        jMenuBar.add(jMenuCerrar);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPanePrincipal, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPanePrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 669, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void eventosEstructura() {
        EstructuraController controller = new EstructuraController(this, object, this.tabbedPanePrincipal);
        this.jMenuAjustes.addMouseListener(controller);
        this.jMenuCerrar.addMouseListener(controller);
        this.menuItemAreas.addActionListener(controller);
        this.menuItemClasificaciones.addActionListener(controller);
        this.menuItemTiendas.addActionListener(controller);
        this.menuItemUnidades.addActionListener(controller);
    }

    /**
     * AQUI PUSE TODOS LOS EVENTOS DE MATERIAL CONTROLLER
     */
    private void eventosMaterial() {
        //INICIAR OBJETOS
        List<JButton> buttons = new ArrayList<>();
        buttons.add(this.btnAgregarNuevoMaterial);
        buttons.add(this.btnEliminarMaterial);
        buttons.add(this.btnPrimero);
        buttons.add(this.btnAnterior);
        buttons.add(this.btnSiguiente);
        buttons.add(this.btnUltimo);
        List<JTextField> textFields = new ArrayList<>();
        textFields.add(this.txtNombre);
        textFields.add(this.txtSku);
        textFields.add(this.txtBuscador);
        textFields.add(this.txtCantidad);
        textFields.add(this.txtLimiteMinimo);
        List<JLabel> labels = new ArrayList<>();
        labels.add(this.lblPaginador);
        labels.add(this.lblNombreMaterial);
        labels.add(this.lblCantidadMaterial);
        labels.add(this.lblUnidadMaterial);
        labels.add(this.lblLimiteMinimoMat);
        labels.add(this.lblSkuMat);
        labels.add(this.lblClasificacionMat);
        labels.add(this.lblTiendaMat);
        labels.add(this.lblFechaIngreso);
        labels.add(this.lblTituloFecha);
        List<JComboBox> combos = new ArrayList<>();
        combos.add(this.cbxUnidad);
        combos.add(this.cbxClasificacion);
        combos.add(this.cbxTiendas);
        MaterialController controller = new MaterialController(object, buttons, textFields, labels, tbMateriales, spinner, combos, this.tabbedPanePrincipal);
        //FIN
        //EVENTOS
        //EVENTOS TXT
        this.txtSku.addFocusListener(controller);
        this.txtSku.addKeyListener(controller);
        this.txtNombre.addFocusListener(controller);
        this.txtNombre.addKeyListener(controller);
        this.txtBuscador.addKeyListener(controller);
        this.txtCantidad.addKeyListener(controller);
        this.txtLimiteMinimo.addKeyListener(controller);
        this.txtCantidad.addFocusListener(controller);
        this.txtLimiteMinimo.addFocusListener(controller);
        //EVENTOS BTN
        this.btnAgregarNuevoMaterial.addActionListener(controller);
        this.btnPrimero.addActionListener(controller);
        this.btnAnterior.addActionListener(controller);
        this.btnSiguiente.addActionListener(controller);
        this.btnUltimo.addActionListener(controller);
        this.btnEliminarMaterial.addActionListener(controller);
        //EVENTOS COMBOBOX
        this.cbxUnidad.addFocusListener(controller);
        this.cbxClasificacion.addFocusListener(controller);
        this.cbxTiendas.addFocusListener(controller);
        this.cbxClasificacion.addActionListener(controller);
        this.cbxTiendas.addActionListener(controller);
        this.cbxUnidad.addActionListener(controller);
        this.cbxClasificacion.addKeyListener(controller);
        this.cbxTiendas.addKeyListener(controller);
        this.cbxUnidad.addKeyListener(controller);
        //EVENTOS SPINNER
        this.spinner.addChangeListener(controller);
        //EVENTOS TABLA
        this.tbMateriales.addMouseListener(controller);
        this.tbMateriales.addKeyListener(controller);
        //EVENTOS Tabbed pane principal
        tabbedPanePrincipal.addChangeListener(controller);
        //FIN EVENTOS
        //ICONOS
        this.btnPrimero.setIcon(new ImageIcon(Objetos.imagenPath.ruta("left_doble.png")));
        this.btnAnterior.setIcon(new ImageIcon(Objetos.imagenPath.ruta("left_icon.png")));
        this.btnSiguiente.setIcon(new ImageIcon(Objetos.imagenPath.ruta("right_icon.png")));
        this.btnUltimo.setIcon(new ImageIcon(Objetos.imagenPath.ruta("right_doble.png")));
        this.btnAgregarNuevoMaterial.setIcon(new ImageIcon(Objetos.imagenPath.ruta("accept.png")));
        this.btnEliminarMaterial.setIcon(new ImageIcon(Objetos.imagenPath.ruta("remove.png")));
        this.lblBuscador.setIcon(new ImageIcon(Objetos.imagenPath.ruta("search.png")));
    }

    /**
     * EVENTOS Empleado
     */
    private void eventosEmpleado() {

        //INICIAR OBJETOS
        List<JButton> buttonsEmpleados = new ArrayList<>();
        buttonsEmpleados.add(this.btnAgregarNuevoEmpleado);
        buttonsEmpleados.add(this.btnEliminarEmpleado);
        buttonsEmpleados.add(this.btnPrimeroEmpleados);
        buttonsEmpleados.add(this.btnAnteriorEmpleados);
        buttonsEmpleados.add(this.btnSiguienteEmpleados);
        buttonsEmpleados.add(this.btnUltimoEmpleados);
        List<JTextField> textsEmpleados = new ArrayList<>();
        textsEmpleados.add(this.txtNombreEmpleado);
        textsEmpleados.add(this.txtApellidoPaterno);
        textsEmpleados.add(this.txtApellidoMaterno);
        textsEmpleados.add(this.txtTelefono);
        textsEmpleados.add(this.txtEmail);
        textsEmpleados.add(this.txtBuscadorEmpleados);
        textsEmpleados.add(this.txtNid);
        List<JLabel> labelsEmpleados = new ArrayList<>();
        labelsEmpleados.add(this.lblNombreEmpleado);
        labelsEmpleados.add(this.lblApellidoPaterno);
        labelsEmpleados.add(this.lblApellidoMaterno);
        labelsEmpleados.add(this.lblTelefono);
        labelsEmpleados.add(this.lblEmail);
        labelsEmpleados.add(this.lblArea);
        labelsEmpleados.add(this.lblPaginadorEmpleados);
        labelsEmpleados.add(this.lblNid);
        List<JLabel> columnLabels = new ArrayList<>();

        EmpleadoController empleadoCTRL = new EmpleadoController(buttonsEmpleados, textsEmpleados, labelsEmpleados, this.cbxAreaEmpleados, this.spinnerEmpleados, this.tbEmpleados, columnLabels, this.jcbContratado);
        //FIN
        //EVENTOS
        //EVENTOS TXT
        this.txtNombreEmpleado.addKeyListener(empleadoCTRL);
        this.txtApellidoPaterno.addKeyListener(empleadoCTRL);
        this.txtApellidoMaterno.addKeyListener(empleadoCTRL);
        this.txtTelefono.addKeyListener(empleadoCTRL);
        this.txtEmail.addKeyListener(empleadoCTRL);
        this.txtNombreEmpleado.addFocusListener(empleadoCTRL);
        this.txtApellidoPaterno.addFocusListener(empleadoCTRL);
        this.txtApellidoMaterno.addFocusListener(empleadoCTRL);
        this.txtTelefono.addFocusListener(empleadoCTRL);
        this.txtEmail.addFocusListener(empleadoCTRL);
        this.txtBuscadorEmpleados.addKeyListener(empleadoCTRL);
        this.txtNid.addFocusListener(empleadoCTRL);
        this.txtNid.addKeyListener(empleadoCTRL);
        //EVENTOS BTN
        this.btnAgregarNuevoEmpleado.addActionListener(empleadoCTRL);
        this.btnEliminarEmpleado.addActionListener(empleadoCTRL);
        this.btnAnteriorEmpleados.addActionListener(empleadoCTRL);
        this.btnPrimeroEmpleados.addActionListener(empleadoCTRL);
        this.btnSiguienteEmpleados.addActionListener(empleadoCTRL);
        this.btnUltimoEmpleados.addActionListener(empleadoCTRL);
        //EVENTOS TABLA
        this.tbEmpleados.getTableHeader().addMouseListener(empleadoCTRL);
        //EVENTOS SPINNER
        this.spinnerEmpleados.addChangeListener(empleadoCTRL);
        //EVENTOS COMBOBOX
        this.cbxAreaEmpleados.addActionListener(empleadoCTRL);
        //AGREGA MOUSE LISTENER A LOS HEADER DE CADA COLUMNA DE LA TABLA
        /*
        for(int i = 0; i<7 ; i++){
            TableColumn column = this.tbEmpleados.getColumnModel().getColumn(i);
            column.setHeaderRenderer(new DefaultTableCellRenderer(){
                @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                label.addMouseListener(empleadoCTRL);
                //columnLabels.add(label);
                return label;
            }
            });
        }*/
        //FIN EVENTOS
        //OTRO
        this.tbEmpleados.setSelectionMode(0);
        this.tbEmpleados.addMouseListener(empleadoCTRL);
        this.cbxAreaEmpleados.addFocusListener(empleadoCTRL);
        this.btnEliminarEmpleado.setVisible(false);

        //ICONOS
        this.btnAgregarNuevoEmpleado.setIcon(new ImageIcon(Objetos.imagenPath.ruta("accept.png")));
        this.btnEliminarEmpleado.setIcon(new ImageIcon(Objetos.imagenPath.ruta("remove.png")));
        this.lblBuscadorEmpleados.setIcon(new ImageIcon(Objetos.imagenPath.ruta("search.png")));
        this.btnPrimeroEmpleados.setIcon(new ImageIcon(Objetos.imagenPath.ruta("left_doble.png")));
        this.btnAnteriorEmpleados.setIcon(new ImageIcon(Objetos.imagenPath.ruta("left_icon.png")));
        this.btnSiguienteEmpleados.setIcon(new ImageIcon(Objetos.imagenPath.ruta("right_icon.png")));
        this.btnUltimoEmpleados.setIcon(new ImageIcon(Objetos.imagenPath.ruta("right_doble.png")));
        /*
new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // manejar el evento de hacer clic en la columna aquí
            }
        }
         */
    }

    //EVENTOS DE LA SALIDA
    private void eventosSalida() {
        //INICIAR OBJETOS
        List<JLabel> labels = new ArrayList<>();
        labels.add(this.lblCantidadSalida);
        labels.add(this.lblConceptoSalida);
        labels.add(this.lblEmpleadoSolicitante);
        labels.add(this.lblAreaEmpleadoSolicitante);
        labels.add(this.lblMaterialSolicitado);
        labels.add(this.lblUnidadMaterialSolicitado);
        labels.add(this.lblPaginadorSalidas);
        labels.add(this.lblFechaSalida);
        labels.add(this.lblTituloFechaSalida);
        List<JButton> buttons = new ArrayList<>();
        buttons.add(this.btnAgregarSalida);
        buttons.add(this.btnCancelar);
        buttons.add(this.btnPrimeroSalidas);
        buttons.add(this.btnAnteriorSalidas);
        buttons.add(this.btnSiguienteSalidas);
        buttons.add(this.btnUltimoSalida);
        List<JTextField> textFields = new ArrayList<>();
        textFields.add(this.txtCantidadSalida);
        textFields.add(this.txtEmpleadoSalida);
        textFields.add(this.txtAreaEmpleadoSol);
        textFields.add(this.txtMaterialSolicitado);
        textFields.add(this.txtUnidadMaterialSolicitado);
        textFields.add(this.txtBuscadorSalida);
        SalidaController controller = new SalidaController(object, tabbedPaneSalidas, tbSalidas, tbEmpleadoSalida, tbMaterialesSalida, labels, buttons, textFields, spinnerSalidas, txtAreaConcepto);
        //FIN INICIAR OBJETOS

        //EVENTOS
        //Eventos btn
        this.btnAgregarSalida.addActionListener(controller);
        this.btnCancelar.addActionListener(controller);
        this.btnPrimeroSalidas.addActionListener(controller);
        this.btnAnteriorSalidas.addActionListener(controller);
        this.btnSiguienteSalidas.addActionListener(controller);
        this.btnUltimoSalida.addActionListener(controller);
        //Eventos text field
        this.txtCantidadSalida.addFocusListener(controller);
        this.txtCantidadSalida.addKeyListener(controller);
        this.txtEmpleadoSalida.addFocusListener(controller);
        this.txtEmpleadoSalida.addKeyListener(controller);
        this.txtMaterialSolicitado.addFocusListener(controller);
        this.txtMaterialSolicitado.addKeyListener(controller);
        this.txtBuscadorSalida.addKeyListener(controller);
        //Eventos text area
        this.txtAreaConcepto.addFocusListener(controller);
        this.txtAreaConcepto.addKeyListener(controller);

        //Eventos tabla
        this.tbSalidas.addMouseListener(controller);
        this.tbSalidas.addKeyListener(controller);
        this.tbEmpleadoSalida.addMouseListener(controller);
        this.tbEmpleadoSalida.addKeyListener(controller);
        this.tbMaterialesSalida.addMouseListener(controller);
        this.tbMaterialesSalida.addKeyListener(controller);
        this.tbEmpleadoSalida.addFocusListener(controller);
        //Eventos TabbedPane
        tabbedPaneSalidas.addChangeListener(controller);
        //Eventos spinner
        this.spinnerSalidas.addChangeListener(controller);
        //FIN EVENTOS

        //OTRO
        this.txtAreaEmpleadoSol.setEditable(false);
        this.txtUnidadMaterialSolicitado.setEditable(false);

        //ICONOS
        this.btnAgregarSalida.setIcon(new ImageIcon(Objetos.imagenPath.ruta(ImagenPath.Imagenes.ADD.getValue())));
        this.btnCancelar.setIcon(new ImageIcon(Objetos.imagenPath.ruta(ImagenPath.Imagenes.CANCEL.getValue())));
        this.btnPrimeroSalidas.setIcon(new ImageIcon(Objetos.imagenPath.ruta(ImagenPath.Imagenes.PRIMERO.getValue())));
        this.btnAnteriorSalidas.setIcon(new ImageIcon(Objetos.imagenPath.ruta(ImagenPath.Imagenes.ANTERIOR.getValue())));
        this.btnSiguienteSalidas.setIcon(new ImageIcon(Objetos.imagenPath.ruta(ImagenPath.Imagenes.SIGUIENTE.getValue())));
        this.btnUltimoSalida.setIcon(new ImageIcon(Objetos.imagenPath.ruta(ImagenPath.Imagenes.ULTIMO.getValue())));
        this.lblBuscadorSalida.setIcon(new ImageIcon(Objetos.imagenPath.ruta(ImagenPath.Imagenes.SEARCH.getValue())));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarNuevoEmpleado;
    private javax.swing.JButton btnAgregarNuevoMaterial;
    private javax.swing.JButton btnAgregarSalida;
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnAnteriorEmpleados;
    private javax.swing.JButton btnAnteriorSalidas;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminarEmpleado;
    private javax.swing.JButton btnEliminarMaterial;
    private javax.swing.JButton btnPrimero;
    private javax.swing.JButton btnPrimeroEmpleados;
    private javax.swing.JButton btnPrimeroSalidas;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JButton btnSiguienteEmpleados;
    private javax.swing.JButton btnSiguienteSalidas;
    private javax.swing.JButton btnUltimo;
    private javax.swing.JButton btnUltimoEmpleados;
    private javax.swing.JButton btnUltimoSalida;
    private javax.swing.JComboBox<String> cbxAreaEmpleados;
    private javax.swing.JComboBox<String> cbxClasificacion;
    private javax.swing.JComboBox<String> cbxTiendas;
    private javax.swing.JComboBox<String> cbxUnidad;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.Box.Filler filler4;
    private javax.swing.Box.Filler filler5;
    private javax.swing.Box.Filler filler6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenuAjustes;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenu jMenuCerrar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JCheckBox jcbContratado;
    private javax.swing.JLabel lblApellidoMaterno;
    private javax.swing.JLabel lblApellidoPaterno;
    private javax.swing.JLabel lblArea;
    private javax.swing.JLabel lblAreaEmpleadoSolicitante;
    private javax.swing.JLabel lblBuscador;
    private javax.swing.JLabel lblBuscadorEmpleados;
    private javax.swing.JLabel lblBuscadorSalida;
    private javax.swing.JLabel lblCantidadMaterial;
    private javax.swing.JLabel lblCantidadSalida;
    private javax.swing.JLabel lblClasificacionMat;
    private javax.swing.JLabel lblConceptoSalida;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEmpleadoSolicitante;
    private javax.swing.JLabel lblFechaIngreso;
    private javax.swing.JLabel lblFechaSalida;
    private javax.swing.JLabel lblLimiteMinimoMat;
    private javax.swing.JLabel lblMaterialSolicitado;
    private javax.swing.JLabel lblNid;
    private javax.swing.JLabel lblNombreEmpleado;
    private javax.swing.JLabel lblNombreMaterial;
    private javax.swing.JLabel lblPaginador;
    private javax.swing.JLabel lblPaginadorEmpleados;
    private javax.swing.JLabel lblPaginadorSalidas;
    private javax.swing.JLabel lblSkuMat;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTiendaMat;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTitulo1;
    private javax.swing.JLabel lblTituloFecha;
    private javax.swing.JLabel lblTituloFechaSalida;
    private javax.swing.JLabel lblUnidadMaterial;
    private javax.swing.JLabel lblUnidadMaterialSolicitado;
    private javax.swing.JMenuItem menuItemAreas;
    private javax.swing.JMenuItem menuItemClasificaciones;
    private javax.swing.JMenuItem menuItemTiendas;
    private javax.swing.JMenuItem menuItemUnidades;
    private javax.swing.JPanel panelEmpleados;
    private javax.swing.JPanel panelMateriales;
    private javax.swing.JPanel panelSalidas;
    private javax.swing.JSpinner spinner;
    private javax.swing.JSpinner spinnerEmpleados;
    private javax.swing.JSpinner spinnerSalidas;
    private javax.swing.JTabbedPane tabbedPanePrincipal;
    private javax.swing.JTabbedPane tabbedPaneSalidas;
    private javax.swing.JTable tbEmpleadoSalida;
    private javax.swing.JTable tbEmpleados;
    private javax.swing.JTable tbMateriales;
    private javax.swing.JTable tbMaterialesSalida;
    private javax.swing.JTable tbSalidas;
    private javax.swing.JTextField txtApellidoMaterno;
    private javax.swing.JTextField txtApellidoPaterno;
    private javax.swing.JTextArea txtAreaConcepto;
    private javax.swing.JTextField txtAreaEmpleadoSol;
    private javax.swing.JTextField txtBuscador;
    private javax.swing.JTextField txtBuscadorEmpleados;
    private javax.swing.JTextField txtBuscadorSalida;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCantidadSalida;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEmpleadoSalida;
    private javax.swing.JTextField txtLimiteMinimo;
    private javax.swing.JTextField txtMaterialSolicitado;
    private javax.swing.JTextField txtNid;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombreEmpleado;
    private javax.swing.JTextField txtSku;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtUnidadMaterialSolicitado;
    // End of variables declaration//GEN-END:variables
}
