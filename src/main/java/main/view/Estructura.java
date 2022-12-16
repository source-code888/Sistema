package main.view;

import main.controller.*;
import java.util.*;
import javax.swing.*;
import main.library.Objetos;
import main.model.Usuario;

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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1034, Short.MAX_VALUE)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(spinner)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
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
                                .addComponent(txtBuscador, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(lblPaginador))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        btnEliminarMaterial.setFocusPainted(false);

        lblNombreMaterial.setText("Nombre del material:");

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
                            .addComponent(lblClasificacionMat, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTiendaMat)
                            .addComponent(txtNombre)
                            .addComponent(lblTituloFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 34, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNombreMaterial)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            .addGap(0, 1324, Short.MAX_VALUE)
        );
        panelSalidasLayout.setVerticalGroup(
            panelSalidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 563, Short.MAX_VALUE)
        );

        tabbedPane.addTab("Salidas", panelSalidas);

        javax.swing.GroupLayout panelEmpleadosLayout = new javax.swing.GroupLayout(panelEmpleados);
        panelEmpleados.setLayout(panelEmpleadosLayout);
        panelEmpleadosLayout.setHorizontalGroup(
            panelEmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1324, Short.MAX_VALUE)
        );
        panelEmpleadosLayout.setVerticalGroup(
            panelEmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 563, Short.MAX_VALUE)
        );

        tabbedPane.addTab("Empleados", panelEmpleados);

        jMenuAjustes.setText("Ajustes");

        menuItemAreas.setText("Areas");
        jMenuAjustes.add(menuItemAreas);

        menuItemClasificaciones.setText("Clasificaciones");
        jMenuAjustes.add(menuItemClasificaciones);

        menuItemTiendas.setText("Tiendas");
        menuItemTiendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemTiendasActionPerformed(evt);
            }
        });
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
            .addComponent(tabbedPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPane)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuItemTiendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemTiendasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuItemTiendasActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarNuevoMaterial;
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnEliminarMaterial;
    private javax.swing.JButton btnPrimero;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JButton btnUltimo;
    private javax.swing.JComboBox<String> cbxClasificacion;
    private javax.swing.JComboBox<String> cbxTiendas;
    private javax.swing.JComboBox<String> cbxUnidad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenuAjustes;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenu jMenuCerrar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBuscador;
    private javax.swing.JLabel lblCantidadMaterial;
    private javax.swing.JLabel lblClasificacionMat;
    private javax.swing.JLabel lblFechaIngreso;
    private javax.swing.JLabel lblLimiteMinimoMat;
    private javax.swing.JLabel lblNombreMaterial;
    private javax.swing.JLabel lblPaginador;
    private javax.swing.JLabel lblSkuMat;
    private javax.swing.JLabel lblTiendaMat;
    private javax.swing.JLabel lblTitulo;
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
    private javax.swing.JTabbedPane tabbedPane;
    private javax.swing.JTable tbMateriales;
    private javax.swing.JTextField txtBuscador;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtSku;
    // End of variables declaration//GEN-END:variables
}
