package main.view;

import main.controller.*;
import java.util.*;
import javax.swing.*;
import main.library.Objetos;

public class Estructura extends javax.swing.JFrame {

    private Object object;

    public Estructura(Object object) {
        this.object = object;

        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabbedPane = new javax.swing.JTabbedPane();
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
        spLimiteMinimo = new javax.swing.JSpinner();
        lblCantidadMaterial = new javax.swing.JLabel();
        spCantidad = new javax.swing.JSpinner();
        lblSkuMat = new javax.swing.JLabel();
        txtSku = new javax.swing.JTextField();
        cbxClasificacion = new javax.swing.JComboBox<>();
        lblClasificacionMat = new javax.swing.JLabel();
        cbxTiendas = new javax.swing.JComboBox<>();
        lblTiendaMat = new javax.swing.JLabel();
        lblTituloFecha = new javax.swing.JLabel();
        lblFechaIngreso = new javax.swing.JLabel();
        panelSalidas = new javax.swing.JPanel();
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(lblBuscador, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtBuscador, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBuscador, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscador, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblPaginador))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPrimero, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUltimo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        EstructuraController controller = new EstructuraController(this);
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

        List<JSpinner> spinners = new ArrayList<>();
        spinners.add(this.spinner);
        spinners.add(this.spCantidad);
        spinners.add(this.spLimiteMinimo);
        List<JComboBox> combos = new ArrayList<>();
        combos.add(this.cbxUnidad);
        combos.add(this.cbxClasificacion);
        combos.add(this.cbxTiendas);
        MaterialController materialCTRL = new MaterialController(object,buttons, textFields, labels, tbMateriales, spinners, combos);
        btnAgregarNuevoMaterial.setFocusPainted(false);
        this.jMenuAjustes.addMouseListener(controller);
        this.jMenuCerrar.addMouseListener(controller);
        this.menuItemAreas.addActionListener(controller);
        this.menuItemClasificaciones.addActionListener(controller);
        this.menuItemTiendas.addActionListener(controller);
        this.menuItemUnidades.addActionListener(controller);
        this.btnAgregarNuevoMaterial.addActionListener(materialCTRL);
        this.spinner.addChangeListener(materialCTRL);
        this.btnPrimero.setIcon(new ImageIcon(Objetos.imagenPath.ruta("left_doble.png")));
        this.btnAnterior.setIcon(new ImageIcon(Objetos.imagenPath.ruta("left_icon.png")));
        this.btnSiguiente.setIcon(new ImageIcon(Objetos.imagenPath.ruta("right_icon.png")));
        this.btnUltimo.setIcon(new ImageIcon(Objetos.imagenPath.ruta("right_doble.png")));
        this.cbxUnidad.addFocusListener(materialCTRL);
        this.cbxClasificacion.addFocusListener(materialCTRL);
        this.cbxTiendas.addFocusListener(materialCTRL);
        this.tbMateriales.addMouseListener(materialCTRL);
        this.tbMateriales.addKeyListener(materialCTRL);
        this.btnEliminarMaterial.addActionListener(materialCTRL);
        this.btnAgregarNuevoMaterial.setIcon(new ImageIcon(Objetos.imagenPath.ruta("accept.png")));
        this.btnEliminarMaterial.setIcon(new ImageIcon(Objetos.imagenPath.ruta("remove.png")));
        this.lblBuscador.setIcon(new ImageIcon(Objetos.imagenPath.ruta("search.png")));
        this.txtBuscador.addKeyListener(materialCTRL);
        this.txtNombre.addKeyListener(materialCTRL);
        this.btnPrimero.addActionListener(materialCTRL);
        this.btnAnterior.addActionListener(materialCTRL);
        this.btnSiguiente.addActionListener(materialCTRL);
        this.btnUltimo.addActionListener(materialCTRL);
        this.cbxClasificacion.addActionListener(materialCTRL);
        this.cbxTiendas.addActionListener(materialCTRL);
        this.cbxUnidad.addActionListener(materialCTRL);
        this.txtNombre.addFocusListener(materialCTRL);
        this.txtSku.addFocusListener(materialCTRL);
        this.txtSku.addKeyListener(materialCTRL);

        btnEliminarMaterial.setFocusPainted(false);

        lblNombreMaterial.setText("Nombre del material:");

        txtNombre.setPreferredSize(new java.awt.Dimension(64, 30));

        lblUnidadMaterial.setText("Unidad");

        lblLimiteMinimoMat.setText("Limite minimo");

        lblCantidadMaterial.setText("Cantidad");

        JSpinner.NumberEditor numberEditor = new JSpinner.NumberEditor(spCantidad, "0");
        spCantidad.setEditor(numberEditor);

        lblSkuMat.setText("SKU:");

        lblClasificacionMat.setText("Clasificacion");

        cbxTiendas.setToolTipText("");

        lblTiendaMat.setText("Tiendas");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblFechaIngreso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnEliminarMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAgregarNuevoMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(spCantidad)
                            .addComponent(cbxUnidad, 0, 200, Short.MAX_VALUE)
                            .addComponent(spLimiteMinimo)
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
                            .addComponent(lblTituloFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblClasificacionMat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 34, Short.MAX_VALUE)))
                .addContainerGap())
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblUnidadMaterial)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblLimiteMinimoMat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spLimiteMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTituloFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblFechaIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarNuevoMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout panelMaterialesLayout = new javax.swing.GroupLayout(panelMateriales);
        panelMateriales.setLayout(panelMaterialesLayout);
        panelMaterialesLayout.setHorizontalGroup(
            panelMaterialesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMaterialesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelMaterialesLayout.setVerticalGroup(
            panelMaterialesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMaterialesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMaterialesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        tabbedPane.addTab("Materiales", panelMateriales);

        javax.swing.GroupLayout panelSalidasLayout = new javax.swing.GroupLayout(panelSalidas);
        panelSalidas.setLayout(panelSalidasLayout);
        panelSalidasLayout.setHorizontalGroup(
            panelSalidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1275, Short.MAX_VALUE)
        );
        panelSalidasLayout.setVerticalGroup(
            panelSalidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 557, Short.MAX_VALUE)
        );

        tabbedPane.addTab("Salidas", panelSalidas);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setMinimumSize(new java.awt.Dimension(250, 250));

        btnAgregarNuevoEmpleado.setFocusPainted(false);

        btnEliminarEmpleado.setFocusPainted(false);

        lblNombreEmpleado.setText("Nombre:");

        txtNombreEmpleado.setPreferredSize(new java.awt.Dimension(64, 30));

        lblTelefono.setText("Teléfono:");

        lblApellidoPaterno.setText("Apellido Paterno");

        lblEmail.setText("Correo electrónico:");

        lblArea.setText("Area:");

        txtApellidoPaterno.setPreferredSize(new java.awt.Dimension(64, 30));

        lblApellidoMaterno.setText("Apellido Materno");

        txtApellidoMaterno.setPreferredSize(new java.awt.Dimension(64, 30));

        txtTelefono.setPreferredSize(new java.awt.Dimension(64, 30));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(btnEliminarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 138, Short.MAX_VALUE)
                        .addComponent(btnAgregarNuevoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
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
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 985, Short.MAX_VALUE)
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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblPaginadorEmpleados))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spinnerEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPrimeroEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAnteriorEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSiguienteEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUltimoEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

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

        List<JLabel> labelsEmpleados = new ArrayList<>();
        labelsEmpleados.add(this.lblNombreEmpleado);
        labelsEmpleados.add(this.lblApellidoPaterno);
        labelsEmpleados.add(this.lblApellidoMaterno);
        labelsEmpleados.add(this.lblTelefono);
        labelsEmpleados.add(this.lblEmail);
        labelsEmpleados.add(this.lblArea);
        labelsEmpleados.add(this.lblPaginadorEmpleados);

        EmpleadoController empleadoCTRL = new EmpleadoController(buttonsEmpleados, textsEmpleados, labelsEmpleados, this.cbxAreaEmpleados, this.spinnerEmpleados, this.tbEmpleados);

        this.tbEmpleados.setSelectionMode(0);
        this.cbxAreaEmpleados.addFocusListener(empleadoCTRL);
        this.btnEliminarEmpleado.setVisible(false);
        this.btnAgregarNuevoEmpleado.setIcon(new ImageIcon(Objetos.imagenPath.ruta("accept.png")));
        this.btnEliminarEmpleado.setIcon(new ImageIcon(Objetos.imagenPath.ruta("remove.png")));
        this.lblBuscadorEmpleados.setIcon(new ImageIcon(Objetos.imagenPath.ruta("search.png")));
        this.btnPrimeroEmpleados.setIcon(new ImageIcon(Objetos.imagenPath.ruta("left_doble.png")));
        this.btnAnteriorEmpleados.setIcon(new ImageIcon(Objetos.imagenPath.ruta("left_icon.png")));
        this.btnSiguienteEmpleados.setIcon(new ImageIcon(Objetos.imagenPath.ruta("right_icon.png")));
        this.btnUltimoEmpleados.setIcon(new ImageIcon(Objetos.imagenPath.ruta("right_doble.png")));
        this.txtNombreEmpleado.addKeyListener(empleadoCTRL);
        this.txtApellidoPaterno.addKeyListener(empleadoCTRL);
        this.txtApellidoMaterno.addKeyListener(empleadoCTRL);
        this.txtTelefono.addKeyListener(empleadoCTRL);
        this.txtEmail.addKeyListener(empleadoCTRL);
        this.txtBuscadorEmpleados.addKeyListener(empleadoCTRL);
        this.btnAgregarNuevoEmpleado.addActionListener(empleadoCTRL);
        this.btnEliminarEmpleado.addActionListener(empleadoCTRL);
        this.btnAnteriorEmpleados.addActionListener(empleadoCTRL);
        this.btnPrimeroEmpleados.addActionListener(empleadoCTRL);
        this.btnSiguienteEmpleados.addActionListener(empleadoCTRL);
        this.btnUltimoEmpleados.addActionListener(empleadoCTRL);

        javax.swing.GroupLayout panelEmpleadosLayout = new javax.swing.GroupLayout(panelEmpleados);
        panelEmpleados.setLayout(panelEmpleadosLayout);
        panelEmpleadosLayout.setHorizontalGroup(
            panelEmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEmpleadosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelEmpleadosLayout.setVerticalGroup(
            panelEmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEmpleadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelEmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        tabbedPane.addTab("Empleados", panelEmpleados);

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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabbedPane)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarNuevoEmpleado;
    private javax.swing.JButton btnAgregarNuevoMaterial;
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnAnteriorEmpleados;
    private javax.swing.JButton btnEliminarEmpleado;
    private javax.swing.JButton btnEliminarMaterial;
    private javax.swing.JButton btnPrimero;
    private javax.swing.JButton btnPrimeroEmpleados;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JButton btnSiguienteEmpleados;
    private javax.swing.JButton btnUltimo;
    private javax.swing.JButton btnUltimoEmpleados;
    private javax.swing.JComboBox<String> cbxAreaEmpleados;
    private javax.swing.JComboBox<String> cbxClasificacion;
    private javax.swing.JComboBox<String> cbxTiendas;
    private javax.swing.JComboBox<String> cbxUnidad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenuAjustes;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenu jMenuCerrar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblApellidoMaterno;
    private javax.swing.JLabel lblApellidoPaterno;
    private javax.swing.JLabel lblArea;
    private javax.swing.JLabel lblBuscador;
    private javax.swing.JLabel lblBuscadorEmpleados;
    private javax.swing.JLabel lblCantidadMaterial;
    private javax.swing.JLabel lblClasificacionMat;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblFechaIngreso;
    private javax.swing.JLabel lblLimiteMinimoMat;
    private javax.swing.JLabel lblNombreEmpleado;
    private javax.swing.JLabel lblNombreMaterial;
    private javax.swing.JLabel lblPaginador;
    private javax.swing.JLabel lblPaginadorEmpleados;
    private javax.swing.JLabel lblSkuMat;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTiendaMat;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTitulo1;
    private javax.swing.JLabel lblTituloFecha;
    private javax.swing.JLabel lblUnidadMaterial;
    private javax.swing.JMenuItem menuItemAreas;
    private javax.swing.JMenuItem menuItemClasificaciones;
    private javax.swing.JMenuItem menuItemTiendas;
    private javax.swing.JMenuItem menuItemUnidades;
    private javax.swing.JPanel panelEmpleados;
    private javax.swing.JPanel panelMateriales;
    private javax.swing.JPanel panelSalidas;
    private javax.swing.JSpinner spCantidad;
    private javax.swing.JSpinner spLimiteMinimo;
    private javax.swing.JSpinner spinner;
    private javax.swing.JSpinner spinnerEmpleados;
    private javax.swing.JTabbedPane tabbedPane;
    private javax.swing.JTable tbEmpleados;
    private javax.swing.JTable tbMateriales;
    private javax.swing.JTextField txtApellidoMaterno;
    private javax.swing.JTextField txtApellidoPaterno;
    private javax.swing.JTextField txtBuscador;
    private javax.swing.JTextField txtBuscadorEmpleados;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombreEmpleado;
    private javax.swing.JTextField txtSku;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
