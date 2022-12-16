package main.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import main.library.Paginador;
import main.model.*;

public class MaterialController extends MouseAdapter implements ActionListener, ChangeListener, KeyListener, FocusListener {

    private Material material;
    private List<Material> materiales;
    private DefaultTableModel defaultTableModel;
    private String accion = "insert";
    private int idMaterial;
    //Elementos visibles
    private List<JButton> buttons;
    private List<JTextField> textFields;
    private List<JLabel> labels;
    private JTable tbMateriales;
    private List<JSpinner> spinners;
    private List<JComboBox> combos;

    //ELEMENTOS DEL PAGIANDOR
    private Paginador<Material> paginador;
    private int rows = 10;
    private int pagNum = 1;
    private JSpinner spinner;
    private Usuario usuario;

    public MaterialController(Object object, List<JButton> buttons, List<JTextField> textFields, List<JLabel> labels, JTable tbMateriales, List<JSpinner> spinners, List<JComboBox> combos) {
        this.buttons = buttons;
        this.textFields = textFields;
        this.labels = labels;
        this.tbMateriales = tbMateriales;
        this.spinners = spinners;
        this.spinner = spinners.get(0);
        this.combos = combos;
        buttons.get(1).setVisible(false);
        if (object instanceof Usuario) {
            usuario = (Usuario) object;
        }
        reestablecer();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj instanceof JButton) {
            JButton btn = (JButton) obj;
            if (btn.equals(buttons.get(0))) {
                if (textFields.get(0).getText().isBlank()
                        && textFields.get(1).getText().isBlank() && combos.get(0).getSelectedItem() == null
                        && combos.get(1).getSelectedItem() == null && combos.get(2).getSelectedItem() == null) {
                    labels.get(1).setText("Ingresa el nombre del material");
                    labels.get(3).setText("Selecciona una unidad");
                    labels.get(5).setText("Ingresa el SKU");
                    labels.get(6).setText("Selecciona una clasificacion");
                    labels.get(7).setText("Selecciona una tienda");
                    labels.get(1).setForeground(Color.red);
                    labels.get(3).setForeground(Color.red);
                    labels.get(5).setForeground(Color.red);
                    labels.get(6).setForeground(Color.red);
                    labels.get(7).setForeground(Color.red);
                } else if (textFields.get(0).getText().isBlank()) {
                    labels.get(1).setText("Ingresa el nombre del material");
                    labels.get(1).setForeground(Color.red);
                } else if (combos.get(0).getSelectedItem() == null) {
                    labels.get(3).setText("Selecciona una unidad");
                    labels.get(3).setForeground(Color.red);
                } else if (textFields.get(1).getText().isBlank()) {
                    labels.get(5).setText("Ingresa el SKU");
                    labels.get(5).setForeground(Color.red);
                } else if (combos.get(1).getSelectedItem() == null) {
                    labels.get(6).setText("Selecciona una clasificacion");
                    labels.get(6).setForeground(Color.red);
                } else if (combos.get(2).getSelectedItem() == null) {
                    labels.get(7).setText("Selecciona una tienda");
                    labels.get(7).setForeground(Color.red);
                } else {
                    if (accion.equals("insert")) {
                        try {
                            String strFormat = "hh: mm: ss a dd-mm-YYYY";
                            SimpleDateFormat dateFormat = new SimpleDateFormat(strFormat);
                            Date fecha = new Date();
                            String fechaCompleta = dateFormat.format(fecha).toString();
                            int idUnidad = new UnidadDAO().unidades().stream().filter(
                                    unidad -> unidad.getNombre().equals(combos.get(0).getSelectedItem().toString())
                            ).collect(Collectors.toList()).get(0).getId();
                            int idClasificacion = new ClasificacionDAO().clasificaciones().stream().filter(
                                    clasificacion -> clasificacion.getNombre().equals(combos.get(1).getSelectedItem().toString()
                                    )).collect(Collectors.toList()).get(0).getId();
                            int idTienda = new TiendaDAO().tiendas().stream().filter(
                                    tienda -> tienda.getNombre().equals(combos.get(2).getSelectedItem().toString()
                                    )).collect(Collectors.toList()).get(0).getId();
                            int idUsuario = usuario.getIdUsuario();
                            Object[] data = {
                                textFields.get(0).getText(),
                                Integer.parseInt(spinners.get(1).getValue().toString()),
                                Integer.parseInt(spinners.get(2).getValue().toString()),
                                textFields.get(1).getText(),
                                fechaCompleta,
                                idUnidad,
                                idClasificacion,
                                idTienda,
                                idUsuario
                            };
                            new MaterialDAO().insert(data);
                            reestablecer();
                        } catch (SQLException ex) {
                        }

                    } else if (accion.equals("update")) {

                        try {
                            int idUnidad = new UnidadDAO().unidades().stream().filter(
                                    unidad -> unidad.getNombre().equals(combos.get(0).getSelectedItem().toString())
                            ).collect(Collectors.toList()).get(0).getId();
                            int idClasificacion = new ClasificacionDAO().clasificaciones().stream().filter(
                                    clasificacion -> clasificacion.getNombre().equals(combos.get(1).getSelectedItem().toString()
                                    )).collect(Collectors.toList()).get(0).getId();
                            int idTienda = new TiendaDAO().tiendas().stream().filter(
                                    tienda -> tienda.getNombre().equals(combos.get(2).getSelectedItem().toString()
                                    )).collect(Collectors.toList()).get(0).getId();
                            material.setNombreMaterial(textFields.get(0).getText());
                            material.setCantidad(Integer.parseInt(spinners.get(1).getValue().toString()));
                            material.setLimiteMinimo(Integer.parseInt(spinners.get(2).getValue().toString()));
                            material.setSku(textFields.get(1).getText());
                            material.setIdUnidad(idUnidad);
                            material.setIdClasificacion(idClasificacion);
                            material.setIdTienda(idTienda);
                            Object[] data = {
                                material.getNombreMaterial(),
                                material.getCantidad(),
                                material.getLimiteMinimo(),
                                material.getSku(),
                                material.getFechaIngreso(),
                                material.getIdUnidad(),
                                material.getIdClasificacion(),
                                material.getIdTienda(),
                                material.getIdUsuario()
                            };
                            new MaterialDAO().update(material.getIdMaterial(), data);
                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(null, "Hubo un error.");
                        }
                        reestablecer();
                    }
                }

            }
            if (btn.equals(buttons.get(1))) {
                try {
                    //BOton eliminar
                    new MaterialDAO().remove(idMaterial);
                    reestablecer();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "No se puede eliminar este material.");
                }
            }
            if (btn.equals(buttons.get(2))) {
                //BOTON btnPrimero
                pager(METHOD_FIRST);
            }
            if (btn.equals(buttons.get(3))) {
                //BOTON btnAnterior
                pager(METHOD_LAST);
            }
            if (btn.equals(buttons.get(4))) {
                //BOTON btnSiguiente
                pager(METHOD_NEXT);
            }
            if (btn.equals(buttons.get(5))) {
                //BOTON btnUltimo
                pager(METHOD_LATEST);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        Object obj = e.getSource();
        if (obj instanceof JTable) {
            JTable tb = (JTable) obj;
            if (tb.equals(tbMateriales)) {
                if (tbMateriales.getSelectedRows().length > 0) {
                    obtenerRegistro();
                }
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Object obj = e.getSource();
        if (obj instanceof JTable) {
            JTable tb = (JTable) obj;
            if (tb.equals(tbMateriales)) {
                if (tbMateriales.getSelectedRows().length > 0) {
                    obtenerRegistro();
                }
            }
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        Object obj = e.getSource();
        if (obj instanceof JSpinner) {
            JSpinner sp = (JSpinner) obj;
            if (sp.equals(spinner)) {
                mostrarRegistrosPorPagina();
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void focusGained(FocusEvent e) {
        Object obj = e.getSource();
        if (obj instanceof JComboBox) {
            JComboBox cbx = (JComboBox) obj;
            if (cbx.equals(combos.get(0))) {
                //Unidad
                comboModel("unidad");
            }
            if (cbx.equals(combos.get(1))) {
                //Clasificacion
                comboModel("clasificacion");
            }
            if (cbx.equals(combos.get(2))) {
                //Tienda
                comboModel("tienda");
            }
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
    }

    private void buscar(String data) {
        List<Material> filter;
        String titulos[] = {
            "ID",
            "Nombre",
            "Cantidad",
            "Limite minimo",
            "SKU",
            "Fecha ingreso",
            "Unidad",
            "Clasificacion",
            "Tienda",
            "Usuario"
        };
        defaultTableModel = new DefaultTableModel(null, titulos);
        int start = (pagNum - 1) * rows;
        if (data.equals("")) {
            filter = materiales.stream().skip(start).limit(rows).collect(Collectors.toList());
        } else {
            filter = materiales.stream().filter(material
                    -> material.getNombreMaterial().startsWith(data) || material.getSku().startsWith(data)
            ).skip(start).limit(rows).collect(Collectors.toList());
        }
        if (!filter.isEmpty()) {
            filter.forEach(
                    material -> {
                        String unidad = new UnidadDAO().unidades().stream().filter(
                                obj -> obj.getId() == material.getIdUnidad()
                        ).collect(Collectors.toList()).get(0).getNombre();
                        String clasificacion = new ClasificacionDAO().clasificaciones().stream().filter(
                                obj -> obj.getId() == material.getIdClasificacion()
                        ).collect(Collectors.toList()).get(0).getNombre();
                        String tienda = new TiendaDAO().tiendas().stream().filter(
                                obj -> obj.getId() == material.getIdTienda()
                        ).collect(Collectors.toList()).get(0).getNombre();
                        String usuario = new UsuarioDAO().usuarios().stream().
                                filter(u -> u.getIdUsuario() == material.getIdUsuario()).collect(Collectors.toList()).
                                get(0).getUsuario();
                        Object[] objects = {
                            material.getIdMaterial(),
                            material.getNombreMaterial(),
                            material.getCantidad(),
                            material.getLimiteMinimo(),
                            material.getSku(),
                            material.getFechaIngreso(),
                            unidad,
                            clasificacion,
                            tienda,
                            usuario
                        };
                        defaultTableModel.addRow(objects);
                    }
            );
        }
        tbMateriales.setModel(defaultTableModel);
        tbMateriales.setRowHeight(30);
        tbMateriales.getColumnModel().getColumn(0).setMaxWidth(0);
        tbMateriales.getColumnModel().getColumn(0).setMinWidth(0);
        tbMateriales.getColumnModel().getColumn(0).setPreferredWidth(0);
    }

    private void comboModel(String data) {
        if (data.equals("unidad")) {
            var unidades = new UnidadDAO().unidades();
            String[] objetosUnidad = new String[unidades.size()];
            for (int i = 0; i < unidades.size(); i++) {
                objetosUnidad[i] = unidades.get(i).getNombre();
            }
            DefaultComboBoxModel boxModelU = new DefaultComboBoxModel(objetosUnidad);
            boxModelU.setSelectedItem(null);
            combos.get(0).setModel(boxModelU);
        } else if (data.equals("clasificacion")) {
            var clasificaciones = new ClasificacionDAO().clasificaciones();
            String[] objetosClasificacion = new String[clasificaciones.size()];
            for (int i = 0; i < clasificaciones.size(); i++) {
                objetosClasificacion[i] = clasificaciones.get(i).getNombre();
            }
            DefaultComboBoxModel boxModelC = new DefaultComboBoxModel(objetosClasificacion);
            boxModelC.setSelectedItem(null);
            combos.get(1).setModel(boxModelC);
        } else if (data.equals("tienda")) {
            var tiendas = new TiendaDAO().tiendas();
            String[] objetosTienda = new String[tiendas.size()];
            for (int i = 0; i < tiendas.size(); i++) {
                objetosTienda[i] = tiendas.get(i).getNombre();
            }
            DefaultComboBoxModel boxModelT = new DefaultComboBoxModel(objetosTienda);
            boxModelT.setSelectedItem(null);
            combos.get(2).setModel(boxModelT);
        }
    }

    private void pager(String method) {
        switch (method) {
            case METHOD_FIRST -> {
                if (!materiales.isEmpty()) {
                    pagNum = paginador.primero();
                }

            }
            case METHOD_LAST -> {
                if (!materiales.isEmpty()) {
                    pagNum = paginador.anterior();
                }
            }
            case METHOD_NEXT -> {
                if (!materiales.isEmpty()) {
                    pagNum = paginador.siguiente();
                }
            }
            case METHOD_LATEST -> {
                if (!materiales.isEmpty()) {
                    pagNum = paginador.ultimo();
                }
            }
        }
        buscar("");
    }

    private void mostrarRegistrosPorPagina() {
        pagNum = 1;
        Number box = (Number) spinner.getValue();
        rows = box.intValue();
        if (!materiales.isEmpty()) {
            paginador = new Paginador<>(materiales, labels.get(0), rows);
        }
        buscar("");
    }

    private void reestablecer() {
        accion = "insert";
        materiales = new MaterialDAO().materiales();
        if (!materiales.isEmpty()) {
            paginador = new Paginador<>(materiales, labels.get(0), rows);
        }
        //REINICIAR VALORES
        textFields.get(0).setText("");
        textFields.get(1).setText("");
        comboModel("tienda");
        comboModel("unidad");
        comboModel("clasificacion");
        //
        SpinnerNumberModel numberModel = new SpinnerNumberModel(10, 1, 100, 1);
        SpinnerNumberModel numberModel1 = new SpinnerNumberModel(10, 1, 100, 1);
        SpinnerNumberModel numberModel2 = new SpinnerNumberModel(10, 1, 100, 1);
        spinner.setModel(numberModel);
        spinners.get(1).setModel(numberModel1);
        spinners.get(2).setModel(numberModel2);
        comboModel("unidad");
        comboModel("clasificacion");
        comboModel("tienda");
        buscar("");
        mostrarRegistrosPorPagina();
        buttons.get(1).setVisible(false);
        material = null;
        labels.get(8).setText("");
        labels.get(8).setVisible(false);
        labels.get(9).setVisible(false);
    }

    private void obtenerRegistro() {
        accion = "update";
        int row = tbMateriales.getSelectedRow();
        idMaterial = (Integer) defaultTableModel.getValueAt(row, 0);
        textFields.get(0).setText((String) defaultTableModel.getValueAt(row, 1));
        SpinnerNumberModel numberModel1 = new SpinnerNumberModel(Integer.parseInt(defaultTableModel.getValueAt(row, 2).toString()), 1, 100, 1);
        SpinnerNumberModel numberModel2 = new SpinnerNumberModel(Integer.parseInt(defaultTableModel.getValueAt(row, 3).toString()), 1, 100, 1);
        spinners.get(1).setModel(numberModel1);
        spinners.get(2).setModel(numberModel2);
        textFields.get(1).setText((String) defaultTableModel.getValueAt(row, 4));
        combos.get(0).setSelectedItem((String) defaultTableModel.getValueAt(row, 6));
        combos.get(1).setSelectedItem((String) defaultTableModel.getValueAt(row, 7));
        combos.get(2).setSelectedItem((String) defaultTableModel.getValueAt(row, 8));
        textFields.get(0).requestFocus();
        buttons.get(1).setVisible(true);
        int idUnidad = new UnidadDAO().unidades().stream().filter(
                unidad -> unidad.getNombre().equals(combos.get(0).getSelectedItem().toString())
        ).collect(Collectors.toList()).get(0).getId();
        int idClasificacion = new ClasificacionDAO().clasificaciones().stream().filter(
                clasificacion -> clasificacion.getNombre().equals(combos.get(1).getSelectedItem().toString()
                )).collect(Collectors.toList()).get(0).getId();
        int idTienda = new TiendaDAO().tiendas().stream().filter(
                tienda -> tienda.getNombre().equals(combos.get(2).getSelectedItem().toString()
                )).collect(Collectors.toList()).get(0).getId();
        material = new Material(idMaterial, textFields.get(0).getText(),
                Integer.parseInt(spinners.get(1).getValue().toString()),
                Integer.parseInt(spinners.get(2).getValue().toString()),
                textFields.get(1).getText(), (String) defaultTableModel.getValueAt(row, 5),
                idUnidad, idClasificacion, idTienda, usuario.getIdUsuario());
        labels.get(8).setVisible(true);
        labels.get(9).setVisible(true);
        labels.get(8).setText(material.getFechaIngreso());
    }

    public static final String METHOD_FIRST = "first";
    public static final String METHOD_LAST = "last";
    public static final String METHOD_NEXT = "next";
    public static final String METHOD_LATEST = "latest";

}
