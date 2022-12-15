package main.view;

import javax.swing.JMenuItem;
import main.controller.EstructuraController;

public class Estructura extends javax.swing.JFrame {

    public Estructura() {
        initComponents();
     
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabbedPane = new javax.swing.JTabbedPane();
        panelMateriales = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTblMateriales = new javax.swing.JTable();
        lblTitulo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnAgregarNuevoMaterial = new javax.swing.JButton();
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

        jTblMateriales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTblMateriales.getTableHeader().setReorderingAllowed(false);
        jTblMateriales.setSelectionMode(0);
        jScrollPane1.setViewportView(jTblMateriales);

        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Materiales");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        EstructuraController controller = new EstructuraController(this);
        btnAgregarNuevoMaterial.setText("Agregar Nuevo Material");
        this.jMenuAjustes.addMouseListener(controller);
        this.jMenuCerrar.addMouseListener(controller);
        this.menuItemAreas.addActionListener(controller);
        this.menuItemClasificaciones.addActionListener(controller);
        this.menuItemTiendas.addActionListener(controller);
        this.menuItemUnidades.addActionListener(controller);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addComponent(btnAgregarNuevoMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(151, 151, 151)
                .addComponent(btnAgregarNuevoMaterial)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelMaterialesLayout = new javax.swing.GroupLayout(panelMateriales);
        panelMateriales.setLayout(panelMaterialesLayout);
        panelMaterialesLayout.setHorizontalGroup(
            panelMaterialesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMaterialesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelMaterialesLayout.setVerticalGroup(
            panelMaterialesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMaterialesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMaterialesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        tabbedPane.addTab("Materiales", panelMateriales);

        javax.swing.GroupLayout panelSalidasLayout = new javax.swing.GroupLayout(panelSalidas);
        panelSalidas.setLayout(panelSalidasLayout);
        panelSalidasLayout.setHorizontalGroup(
            panelSalidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 860, Short.MAX_VALUE)
        );
        panelSalidasLayout.setVerticalGroup(
            panelSalidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 510, Short.MAX_VALUE)
        );

        tabbedPane.addTab("Salidas", panelSalidas);

        javax.swing.GroupLayout panelEmpleadosLayout = new javax.swing.GroupLayout(panelEmpleados);
        panelEmpleados.setLayout(panelEmpleadosLayout);
        panelEmpleadosLayout.setHorizontalGroup(
            panelEmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 860, Short.MAX_VALUE)
        );
        panelEmpleadosLayout.setVerticalGroup(
            panelEmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 510, Short.MAX_VALUE)
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
    private javax.swing.JMenu jMenuAjustes;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenu jMenuCerrar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTblMateriales;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JMenuItem menuItemAreas;
    private javax.swing.JMenuItem menuItemClasificaciones;
    private javax.swing.JMenuItem menuItemTiendas;
    private javax.swing.JMenuItem menuItemUnidades;
    private javax.swing.JPanel panelEmpleados;
    private javax.swing.JPanel panelMateriales;
    private javax.swing.JPanel panelSalidas;
    private javax.swing.JTabbedPane tabbedPane;
    // End of variables declaration//GEN-END:variables
}
