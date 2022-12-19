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
import main.library.Objetos;
import main.library.Paginador;
import main.library.TableModel;
import main.model.*;

public class MaterialController extends MouseAdapter implements ActionListener, ChangeListener, KeyListener, FocusListener {

    private Material material;
    private List<Material> materiales;
    private TableModel defaultTableModel;
    private String accion = "insert";
    private List<Tienda> tiendas;
    private List<Unidad> unidades;
    private List<Clasificacion> clasificaciones;
    //Elementos visibles
    private List<JButton> buttons;
    private List<JTextField> textFields;
    private List<JLabel> labels;
    private JTable tbMateriales;
    private List<JComboBox> combos;

    //ELEMENTOS DEL PAGINADOR
    private Paginador<Material> paginador;
    private int rows = 10;
    private int pagNum = 1;
    private JSpinner spinner;
    private Usuario usuario;

    public MaterialController(Object object, List<JButton> buttons, List<JTextField> textFields, List<JLabel> labels, JTable tbMateriales, JSpinner spinner, List<JComboBox> combos) {
        this.buttons = buttons;
        this.textFields = textFields;
        this.labels = labels;
        this.tbMateriales = tbMateriales;
        this.spinner = spinner;
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
                    reestablecer();
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
                    labels.get(2).setForeground(Color.red);
                    labels.get(4).setForeground(Color.red);
                } else if (textFields.get(0).getText().isBlank()) {
                    labels.get(1).setText("Ingresa el nombre del material");
                    labels.get(1).setForeground(Color.red);
                } else if (textFields.get(3).getText().isBlank()) {
                    labels.get(2).setText("Ingresa la cantidad");
                    labels.get(2).setForeground(Color.red);
                } else if (combos.get(0).getSelectedItem() == null) {
                    labels.get(3).setText("Selecciona una unidad");
                    labels.get(3).setForeground(Color.red);
                } else if (textFields.get(4).getText().isBlank()) {
                    labels.get(4).setText("Ingresa el limite minimo");
                    labels.get(4).setForeground(Color.red);
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
                            int idUnidad = unidades.stream().filter(
                                    unidad -> unidad.getNombre().equals(combos.get(0).getSelectedItem().toString())
                            ).collect(Collectors.toList()).get(0).getId();
                            int idClasificacion = clasificaciones.stream().filter(
                                    clasificacion -> clasificacion.getNombre().equals(combos.get(1).getSelectedItem().toString()
                                    )).collect(Collectors.toList()).get(0).getId();
                            int idTienda = tiendas.stream().filter(
                                    tienda -> tienda.getNombre().equals(combos.get(2).getSelectedItem().toString()
                                    )).collect(Collectors.toList()).get(0).getId();
                            int idUsuario = usuario.getIdUsuario();
                            Object[] data = {
                                textFields.get(0).getText(),
                                Integer.parseInt(textFields.get(3).getText()),
                                Integer.parseInt(textFields.get(4).getText()),
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
                        int idUnidad = unidades.stream().filter(
                                unidad -> unidad.getNombre().equals(combos.get(0).getSelectedItem().toString())
                        ).collect(Collectors.toList()).get(0).getId();
                        int idClasificacion = clasificaciones.stream().filter(
                                clasificacion -> clasificacion.getNombre().equals(combos.get(1).getSelectedItem().toString()
                                )).collect(Collectors.toList()).get(0).getId();
                        int idTienda = tiendas.stream().filter(
                                tienda -> tienda.getNombre().equals(combos.get(2).getSelectedItem().toString()
                                )).collect(Collectors.toList()).get(0).getId();
                        boolean existente = (idUnidad == material.getIdUnidad() && idClasificacion == material.getIdClasificacion()
                                && idTienda == material.getIdTienda() && material.getNombreMaterial().equals(textFields.get(0).getText())
                                && material.getCantidad() == Integer.parseInt(textFields.get(3).getText())
                                && material.getLimiteMinimo() == Integer.parseInt(textFields.get(4).getText())
                                && material.getSku().equals(textFields.get(1).getText()));
                        if (!existente) {
                            try {

                                material.setNombreMaterial(textFields.get(0).getText());
                                material.setCantidad(Integer.parseInt(textFields.get(3).getText()));
                                material.setLimiteMinimo(Integer.parseInt(textFields.get(4).getText()));
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
                        }
                        reestablecer();
                    }
                }

            }
            if (btn.equals(buttons.get(1))) {
                try {
                    //BOton eliminar
                    new MaterialDAO().remove(material.getIdMaterial());
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
        if (obj instanceof JComboBox) {
            JComboBox cbx = (JComboBox) obj;
            if (cbx.equals(combos.get(0))) {
                //Unidad
                labels.get(3).setText("Unidad");
                labels.get(3).setForeground(new Color(0, 153, 51));
            }
            if (cbx.equals(combos.get(1))) {
                //Clasificacion
                labels.get(6).setText("Clasificacion");
                labels.get(6).setForeground(new Color(0, 153, 51));
            }
            if (cbx.equals(combos.get(2))) {
                //Tienda
                labels.get(7).setText("Tienda");
                labels.get(7).setForeground(new Color(0, 153, 51));
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

        if (obj instanceof JTextField) {
            JTextField txt = (JTextField) obj;
            if (txt.equals(textFields.get(2))) {
                if (txt.equals(textFields.get(2))) {
                    if (!textFields.get(0).getText().equals("")) {
                        reestablecer();
                    }
                    textFields.get(2).requestFocus();
                    buscar(textFields.get(2).getText());
                }

            }
            if (txt.equals(textFields.get(0))) {
                if (textFields.get(0).getText().isBlank()) {
                    labels.get(1).setText("Ingresa el nombre del material");
                    labels.get(1).setForeground(Color.red);
                } else {
                    labels.get(1).setText("Nombre del material:");
                    labels.get(1).setForeground(new Color(0, 153, 51));
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    if (tbMateriales.getSelectedRows().length > 0) {
                        int index = tbMateriales.getSelectedRow() + 1;
                        if (index < tbMateriales.getRowCount()) {
                            tbMateriales.getSelectionModel().setSelectionInterval(index, index);
                            obtenerRegistro();
                        }
                    }
                } else if (e.getKeyCode() == KeyEvent.VK_UP) {
                    if (tbMateriales.getSelectedRows().length > 0) {
                        int index = tbMateriales.getSelectedRow() - 1;
                        if (index >= 0) {
                            tbMateriales.getSelectionModel().setSelectionInterval(index, index);
                            obtenerRegistro();
                        }
                    }
                }
            }
            if (txt.equals(textFields.get(1))) {
                if (textFields.get(1).getText().isBlank()) {
                    labels.get(5).setText("Ingresa el SKU");
                    labels.get(5).setForeground(Color.red);
                } else {
                    labels.get(5).setText("SKU:");
                    labels.get(5).setForeground(new Color(0, 153, 51));
                }
            }
            if (txt.equals(textFields.get(3))) {
                if (textFields.get(3).getText().isBlank()) {
                    labels.get(2).setText("Ingresa la cantidad");
                    labels.get(2).setForeground(Color.red);
                } else {
                    labels.get(2).setText("Cantidad:");
                    labels.get(2).setForeground(new Color(0, 153, 51));
                }
            }
            if (txt.equals(textFields.get(4))) {
                if (textFields.get(4).getText().isBlank()) {
                    labels.get(4).setText("Ingresa el limite minimo");
                    labels.get(4).setForeground(Color.red);
                } else {
                    labels.get(2).setText("Cantidad:");
                    labels.get(2).setForeground(new Color(0, 153, 51));
                    labels.get(4).setText("Limite minimo:");
                    labels.get(4).setForeground(new Color(0, 153, 51));
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
        Object obj = e.getSource();
        if (obj instanceof JTextField) {
            JTextField txt = (JTextField) obj;
            /**
             * Los 2 if que siguen es para que en esos TXT solo se permita la entrada de texto(No se permite texto alfanumerico
             */
            if (txt.equals(textFields.get(0))) {
                //en caso de que poner numeros u otros caracteres en el nombre de un registro hay que borrar esto
                Objetos.eventoComun.textKeyPressed(e);
            }
            if(txt.equals(textFields.get(2))){
                //Remover si es necesario
                Objetos.eventoComun.textKeyPressed(e);
            }
            if (txt.equals(textFields.get(3))) {
                Objetos.eventoComun.numberKeyPressed(e);
            }
            if (txt.equals(textFields.get(4))) {
                Objetos.eventoComun.numberKeyPressed(e);
            }
        }
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
        Object obj = e.getSource();
        if (obj instanceof JTextField) {
            JTextField txt = (JTextField) obj;
            if (txt.equals(textFields.get(0))) {
                if (!textFields.get(0).getText().isBlank()) {
                    labels.get(1).setText("Nombre del material:");
                    labels.get(1).setForeground(new Color(0, 153, 51));
                } else {
                    labels.get(1).setText("Ingresa el nombre del material");
                    labels.get(1).setForeground(Color.red);
                }
            }
            if (txt.equals(textFields.get(1))) {
                if (!textFields.get(1).getText().isBlank()) {
                    labels.get(5).setText("SKU:");
                    labels.get(5).setForeground(new Color(0, 153, 51));
                } else {
                    labels.get(5).setText("Ingresa el SKU");
                    labels.get(5).setForeground(Color.red);
                }
            }
            if (txt.equals(textFields.get(3))) {
                if (textFields.get(3).getText().isBlank()) {
                    labels.get(2).setText("Ingresa la cantidad");
                    labels.get(2).setForeground(Color.red);
                } else {
                    labels.get(2).setText("Cantidad:");
                    labels.get(2).setForeground(new Color(0, 153, 51));
                }
            }
            if (txt.equals(textFields.get(4))) {
                if (textFields.get(4).getText().isBlank()) {
                    labels.get(4).setText("Ingresa el limite minimo");
                    labels.get(4).setForeground(Color.red);
                } else {
                    labels.get(4).setText("Limite minimo:");
                    labels.get(4).setForeground(new Color(0, 153, 51));
                }
            }
        }
        if (obj instanceof JComboBox) {
            JComboBox cbx = (JComboBox) obj;
            if (cbx.equals(combos.get(0))) {
                //Unidad
                if (combos.get(0).getSelectedItem() == null) {
                    //3 6 7
                    labels.get(3).setText("Selecciona una unidad");
                    labels.get(3).setForeground(Color.red);
                }
            }
            if (cbx.equals(combos.get(1))) {
                //Clasificacion
                if (combos.get(0).getSelectedItem() == null) {
                    labels.get(6).setText("Selecciona una clasificacion");
                    labels.get(6).setForeground(Color.red);
                }
            }
            if (cbx.equals(combos.get(2))) {
                //Tienda
                if (combos.get(0).getSelectedItem() == null) {
                    labels.get(7).setText("Selecciona una tienda");
                    labels.get(7).setForeground(Color.red);
                }
            }
        }
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
        defaultTableModel = new TableModel(null, titulos);
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
                        String unidad = unidades.stream().filter(
                                obj -> obj.getId() == material.getIdUnidad()
                        ).collect(Collectors.toList()).get(0).getNombre();
                        String clasificacion = clasificaciones.stream().filter(
                                obj -> obj.getId() == material.getIdClasificacion()
                        ).collect(Collectors.toList()).get(0).getNombre();
                        String tienda = tiendas.stream().filter(
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
        tbMateriales.getColumnModel().getColumn(5).setPreferredWidth(200);
        tbMateriales.setRowHeight(30);
        tbMateriales.getColumnModel().getColumn(0).setMaxWidth(0);
        tbMateriales.getColumnModel().getColumn(0).setMinWidth(0);
        tbMateriales.getColumnModel().getColumn(0).setPreferredWidth(0);

    }

    private void comboModel(String data) {
        iniciarListas();
        if (data.equals("unidad")) {
            String[] objetosUnidad = new String[unidades.size()];
            for (int i = 0; i < unidades.size(); i++) {
                objetosUnidad[i] = unidades.get(i).getNombre();
            }
            DefaultComboBoxModel boxModelU = new DefaultComboBoxModel(objetosUnidad);
            boxModelU.setSelectedItem(null);
            combos.get(0).setModel(boxModelU);
        } else if (data.equals("clasificacion")) {
            String[] objetosClasificacion = new String[clasificaciones.size()];
            for (int i = 0; i < clasificaciones.size(); i++) {
                objetosClasificacion[i] = clasificaciones.get(i).getNombre();
            }
            DefaultComboBoxModel boxModelC = new DefaultComboBoxModel(objetosClasificacion);
            boxModelC.setSelectedItem(null);
            combos.get(1).setModel(boxModelC);
        } else if (data.equals("tienda")) {
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
        iniciarListas();
        //REINICIAR VALORES
        textFields.get(0).setText("");
        textFields.get(1).setText("");
        textFields.get(2).setText("");
        textFields.get(3).setText("");
        textFields.get(4).setText("");
        labels.get(1).setText("Nombre del material:");
        labels.get(1).setForeground(Color.black);
        labels.get(2).setForeground(Color.black);
        labels.get(2).setText("Cantidad:");
        labels.get(2).setForeground(Color.black);
        labels.get(3).setText("Unidad");
        labels.get(3).setForeground(Color.black);
        labels.get(4).setForeground(Color.black);
        labels.get(4).setText("Limite minimo:");
        labels.get(4).setForeground(Color.black);
        labels.get(5).setText("SKU:");
        labels.get(5).setForeground(Color.black);
        labels.get(6).setText("Clasificacion");
        labels.get(6).setForeground(Color.black);
        labels.get(7).setText("Tienda");
        labels.get(7).setForeground(Color.black);
        labels.get(8).setText("");
        labels.get(9).setText("");
        comboModel("tienda");
        comboModel("unidad");
        comboModel("clasificacion");
        //
        SpinnerNumberModel numberModel = new SpinnerNumberModel(10, 1, 100, 1);

        spinner.setModel(numberModel);
        comboModel("unidad");
        comboModel("clasificacion");
        comboModel("tienda");
        buscar("");
        mostrarRegistrosPorPagina();
        buttons.get(1).setVisible(false);
        material = null;
    }

    private void obtenerRegistro() {
        accion = "update";
        int row = tbMateriales.getSelectedRow();
        int idMaterial = (Integer) defaultTableModel.getValueAt(row, 0);
        textFields.get(0).setText((String) defaultTableModel.getValueAt(row, 1));
        textFields.get(3).setText((String) defaultTableModel.getValueAt(row, 2).toString());
        textFields.get(4).setText((String) defaultTableModel.getValueAt(row, 3).toString());
        textFields.get(1).setText((String) defaultTableModel.getValueAt(row, 4));
        combos.get(0).setSelectedItem((String) defaultTableModel.getValueAt(row, 6));
        combos.get(1).setSelectedItem((String) defaultTableModel.getValueAt(row, 7));
        combos.get(2).setSelectedItem((String) defaultTableModel.getValueAt(row, 8));
        textFields.get(0).requestFocus();
        buttons.get(1).setVisible(true);

        //OBTENEMOS LOS IDS
        int idUnidad = unidades.stream().filter(
                unidad -> unidad.getNombre().equals(combos.get(0).getSelectedItem().toString())
        ).collect(Collectors.toList()).get(0).getId();
        int idClasificacion = clasificaciones.stream().filter(
                clasificacion -> clasificacion.getNombre().equals(combos.get(1).getSelectedItem().toString()
                )).collect(Collectors.toList()).get(0).getId();
        int idTienda = tiendas.stream().filter(
                tienda -> tienda.getNombre().equals(combos.get(2).getSelectedItem().toString()
                )).collect(Collectors.toList()).get(0).getId();
        //FIN 
        material = new Material(idMaterial, textFields.get(0).getText(),
                Integer.parseInt(textFields.get(3).getText()),
                Integer.parseInt(textFields.get(4).getText()),
                textFields.get(1).getText(), (String) defaultTableModel.getValueAt(row, 5),
                idUnidad, idClasificacion, idTienda, usuario.getIdUsuario());
        labels.get(8).setText(material.getFechaIngreso());
        labels.get(9).setText("Fecha en que ingreso el material:");
        if (!textFields.get(2).getText().equals("")) {
            textFields.get(2).setText("");
        }
        labels.get(1).setForeground(new Color(0, 153, 51));
        labels.get(2).setForeground(new Color(0, 153, 51));
        labels.get(4).setForeground(new Color(0, 153, 51));
        labels.get(5).setForeground(new Color(0, 153, 51));
    }

    private void iniciarListas() {
        tiendas = new TiendaDAO().tiendas();
        clasificaciones = new ClasificacionDAO().clasificaciones();
        unidades = new UnidadDAO().unidades();
        materiales = new MaterialDAO().materiales();
    }
    public static final String METHOD_FIRST = "first";
    public static final String METHOD_LAST = "last";
    public static final String METHOD_NEXT = "next";
    public static final String METHOD_LATEST = "latest";

}
