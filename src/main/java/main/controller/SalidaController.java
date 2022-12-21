package main.controller;

import java.awt.Color;
import java.awt.Component;
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
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.print.PrintException;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import static main.library.EventoComun.COLOR_BASE;
import main.library.Paginador;
import main.model.Empleado;
import main.model.Salida;
import main.library.Objetos;
import main.library.TableModel;
import main.model.AreaDAO;
import main.model.ClasificacionDAO;
import main.model.EmpleadoDAO;
import main.model.Material;
import main.model.MaterialDAO;
import main.model.SalidaDAO;
import main.model.TiendaDAO;
import main.model.UnidadDAO;
import main.model.Usuario;
import main.model.UsuarioDAO;
import static main.library.Objetos.METHOD_FIRST;
import static main.library.Objetos.METHOD_LAST;
import static main.library.Objetos.METHOD_LATEST;
import static main.library.Objetos.METHOD_NEXT;
import static main.library.EventoComun.COLOR_TEXTO;
import main.library.GenerarDocumento;
import main.library.RenderCheckBox;

public class SalidaController extends MouseAdapter implements ActionListener, ChangeListener, KeyListener, FocusListener {

    //ELEMENTOS VISUALES
    private JTabbedPane tabbedPaneSalidas;
    private JTabbedPane tabbedPaneAccionSalida;
    private JList lstSalidas;
    private JTable tbSalidas;
    private JTable tbEmpleados;
    private JTable tbMateriales;

    private List<JLabel> labels;
    private List<JButton> buttons;
    private List<JTextField> textFields;
    private JSpinner spinner;
    private JTextArea txtAreaConcepto;

    //ELEMENTOS DE LA CLASE
    private DefaultListModel<Salida> listModel;
    private List<Salida> salidas;
    private List<Empleado> empleados;
    private List<Material> materiales;
    private Usuario usuario;
    private Component componentEmpleados;
    private Component componentMateriales;
    private TableModel tableModelSalidas;
    private TableModel tableModelEmpleados;
    private TableModel tableModelMateriales;
    private String accion = "insert";
    private Salida salida;
    private Empleado empleado;
    private Material material;
    private boolean enter = false;
    private boolean empleadoSeleccionado = false;
    private boolean materialSeleccionado = false;
    private boolean tablaEmpleadosSeleccionada = false;
    private boolean seccionEmpleadosActiva = false;
    private boolean seccionMaterialesActiva = false;
    private boolean seccionAgregarSalida = true;
    //ELEMENTOS DEL PAGINADOR
    private Paginador<Salida> paginador;
    private int rows = 10;
    private int pagNum = 1;

    public SalidaController(Object object, JTabbedPane tabbedPaneSalidas, JTable tbSalidas, JTable tbEmpleados, JTable tbMateriales, List<JLabel> labels, List<JButton> buttons, List<JTextField> textFields, JSpinner spinner, JTextArea txtAreaConcepto, JTabbedPane tabbedPaneAccionSalida, JList lstSalidas) {
        if (object instanceof Usuario) {
            usuario = (Usuario) object;
        }
        this.tabbedPaneSalidas = tabbedPaneSalidas;
        this.tbSalidas = tbSalidas;
        this.tbEmpleados = tbEmpleados;
        this.tbMateriales = tbMateriales;
        this.labels = labels;
        this.buttons = buttons;
        this.textFields = textFields;
        this.spinner = spinner;
        this.txtAreaConcepto = txtAreaConcepto;
        this.tabbedPaneAccionSalida = tabbedPaneAccionSalida;
        this.lstSalidas = lstSalidas;
        componentMateriales = tabbedPaneSalidas.getComponent(tabbedPaneSalidas.getTabCount() - 1);
        componentEmpleados = tabbedPaneSalidas.getComponent(tabbedPaneSalidas.getTabCount() - 2);
        tabbedPaneSalidas.removeTabAt(tabbedPaneSalidas.getTabCount() - 1);
        tabbedPaneSalidas.removeTabAt(tabbedPaneSalidas.getTabCount() - 1);
        reestablecer();
    }

    /**
     * Ocultar componente de un TabbedPane
     *
     * @param titulo del componente que se desea ocultar
     * <p>
     * Titulos</p>
     * <ul>
     * <li><p>
     * Empleados: Oculta el panel empleados</p></li>
     * <li><p>
     * Materiales: Oculta el panel materiales</p></li>
     * <li><p>
     * Todos: Oculta todos los paneles</p></li>
     * </ul>
     */
    private void ocultarComponenteTabbedPane(String titulo) {
        if (tabbedPaneSalidas.getTabCount() > 1) {
            if (titulo.equals("Empleados")) {
                componentEmpleados = tabbedPaneSalidas.getComponent(tabbedPaneSalidas.getTabCount() - 1);
                tabbedPaneSalidas.removeTabAt(tabbedPaneSalidas.getTabCount() - 1);
                seccionEmpleadosActiva = false;
            } else if (titulo.equals("Materiales")) {
                componentMateriales = tabbedPaneSalidas.getComponent(tabbedPaneSalidas.getTabCount() - 1);
                tabbedPaneSalidas.removeTabAt(tabbedPaneSalidas.getTabCount() - 1);
                seccionMaterialesActiva = false;
            }
        }
    }

    //EVENTOS
    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj instanceof JButton) {
            JButton button = (JButton) obj;
            if (button.equals(buttons.get(0))) {
                if (accion.equals("insert")) {
                    if (validarEntrada()) {
                        insertarSalida();
                    }
                }
            }

            if (button.equals(buttons.get(1))) {
                reestablecer();
            }
            if (button.equals(buttons.get(2))) {
                pager(METHOD_FIRST);
            }
            if (button.equals(buttons.get(3))) {
                pager(METHOD_LAST);
            }
            if (button.equals(buttons.get(4))) {
                pager(METHOD_NEXT);
            }
            if (button.equals(buttons.get(5))) {
                pager(METHOD_LATEST);
            }
            if (button.equals(buttons.get(6))) {
                if (listModel != null) {
                    if (!listModel.isEmpty()) {
                        GenerarDocumento ticket = new GenerarDocumento();
                        ticket.addTextCenter("Sistema de almacén");
                        ticket.addTextLeft("Dirección: ");
                        ticket.addTextLeft("Dirección tal");
                        ticket.addTextLeft("Teléfono: 8341329745");
                        ticket.separarSeccion();
                        ticket.addTextCenter("Reporte de salidas");
                        ticket.addTextLeft("Empleado que reporta: " + getNombreEmpleado(usuario.getIdEmpleado()));
                        ticket.addTextLeft("Fecha de reporte: " + labels.get(12).getText());
                        ticket.separarSeccion();
                        ticket.addTextCenter("Salidas reportadas");
                        ticket.separadorAs();
                        int materialesSalida = 0;
                        for (int i = 0; i < listModel.size(); i++) {
                            var sal = listModel.getElementAt(i);
                            ticket.addItem(getNombreMaterial(sal.getIdMaterial()), "Cantidad: " + sal.getCantidadSalida(), "");
                            ticket.addTextLeft("Lo solicitó: " + getNombreEmpleado(sal.getIdEmpleado()) + " " + getApellidoEmpleado(sal.getIdEmpleado()));
                            ticket.addTextLeft("Contacto: " + getContactoEmpleado(sal.getIdEmpleado()));
                            ticket.addTextLeft("Fecha de solicitud: " + sal.getFechaHoraSalida());
                            ticket.separadorAs();
                            materialesSalida += sal.getCantidadSalida();
                        }
                        ticket.separadorE();
                        ticket.addTextLeft("Total de materiales que salieron: " + materialesSalida);
                        ticket.separadorE();
                        ticket.addTextCenter("Fin");
                        try {
                            ticket.print();
                            for (int i = 0; i < listModel.size(); i++) {
                                var sal = listModel.getElementAt(i);
                                try {
                                    new SalidaDAO().remove(sal.getIdSalida());
                                } catch (SQLException ex) {
                                    JOptionPane.showMessageDialog(null, "La salida no ha podido ser eliminada.");
                                }
                            }
                            reestablecer();
                            reestablecerReporte();
                        } catch (PrintException ex) {
                            ex.printStackTrace(System.out);
                            JOptionPane.showMessageDialog(null, "Reporte cancelado");
                        }
                    }
                }
            }

            if (button.equals(buttons.get(7))) {
                reestablecerReporte();
            }
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        Object obj = e.getSource();
        if (obj instanceof JTabbedPane) {
            JTabbedPane pane = (JTabbedPane) obj;
            if (pane.equals(tabbedPaneSalidas)) {
                if (tabbedPaneSalidas.getTabCount() > 1) {
                    tabbedPaneSalidas.setSelectedIndex(1);
                }
            }
            if (pane.equals(tabbedPaneAccionSalida)) {
                if (tabbedPaneAccionSalida.getSelectedIndex() == 0) {
                    seccionAgregarSalida = true;
                    reestablecer();
                } else if (tabbedPaneAccionSalida.getSelectedIndex() == 1) {
                    seccionAgregarSalida = false;
                    reestablecerReporte();
                }
            }
        }
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
        if (obj instanceof JTextArea) {
            JTextArea area = (JTextArea) obj;
            if (area.equals(txtAreaConcepto)) {
                if (txtAreaConcepto.getText().length() >= 200) {
                    e.consume();
                }
            }
        }
        if (obj instanceof JTextField) {
            JTextField textField = (JTextField) obj;
            if (textField.equals(textFields.get(0))) {
                Objetos.eventoComun.numberKeyPressed(e);
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        Object obj = e.getSource();
        if (obj instanceof JTable) {
            JTable tb = (JTable) obj;
            if (tb.equals(tbSalidas)) {
                if (tbSalidas.getSelectedRows().length > 0) {
                    if (seccionAgregarSalida) {
                        obtenerRegistro();
                    } else {
                        obtenerSalida();
                    }
                }
            }

            if (tb.equals(tbEmpleados)) {
                if (tbEmpleados.getSelectedRows().length > 0) {
                    obtenerEmpleado();
                    empleadoSeleccionado = true;
                }
            }
            if (tb.equals(tbMateriales)) {
                if (tbMateriales.getSelectedRows().length > 0) {
                    obtenerMaterial();
                    materialSeleccionado = true;
                }
            }
        }
        if (obj instanceof JTextField) {
            JTextField txt = (JTextField) obj;
            if (txt.equals(textFields.get(0))) {
                if (textFields.get(0).getText().isBlank()) {
                    Objetos.eventoComun.remarcarLabel(labels.get(0), "Ingresa la cantidad de salida:", Color.red);
                } else {
                    Objetos.eventoComun.remarcarLabel(labels.get(0), "Cantidad:", COLOR_BASE);
                    if (e.getKeyChar() == '\n') {
                        enter = true;
                        buttons.get(0).doClick();
                    }
                }
            }

            if (txt.equals(textFields.get(1))) {
                if (e.getKeyChar() != '\n') {
                    labels.get(3).setForeground(Color.BLACK);
                    labels.get(2).setForeground(Color.BLACK);
                    labels.get(4).setForeground(Color.BLACK);
                    labels.get(5).setForeground(Color.BLACK);
                    textFields.get(4).setText("");
                    textFields.get(3).setText("");
                    material = null;
                    empleado = null;
                    textFields.get(2).setText("");
                    buscarEmpleado(textFields.get(1).getText());
                } else {
                    if (tbEmpleados.getRowCount() > 0) {
                        tbEmpleados.setRowSelectionInterval(0, 0);
                        obtenerEmpleado();
                        textFields.get(3).requestFocus();
                        empleadoSeleccionado = true;
                    }
                }
            }
            if (txt.equals(textFields.get(3))) {
                if (e.getKeyChar() != '\n') {
                    material = null;
                    labels.get(4).setForeground(Color.BLACK);
                    labels.get(5).setForeground(Color.BLACK);

                    textFields.get(4).setText("");

                    buscarMaterial(textFields.get(3).getText());
                } else {
                    if (tbMateriales.getRowCount() > 0) {
                        tbMateriales.setRowSelectionInterval(0, 0);
                        obtenerMaterial();
                        textFields.get(0).requestFocus();
                        materialSeleccionado = true;
                    }
                }
            }
            if (txt.equals(textFields.get(5))) {
                if (e.getKeyChar() != '\n') {
                    buscar(textFields.get(5).getText());
                } else {
                    if (tbSalidas.getRowCount() > 0) {
                        tbSalidas.setRowSelectionInterval(0, 0);
                        obtenerRegistro();
                    }
                }
            }
        }
        if (obj instanceof JTextArea) {
            JTextArea area = (JTextArea) obj;
            if (area.equals(txtAreaConcepto)) {
                if (txtAreaConcepto.getText().isBlank()) {
                    Objetos.eventoComun.remarcarLabel(labels.get(1), "Ingresa el concepto:", Color.red);
                } else {
                    Objetos.eventoComun.remarcarLabel(labels.get(1), "Concepto:", COLOR_BASE);
                    if (e.getKeyChar() == '\n') {
                        textFields.get(1).requestFocus();
                    }
                }
            }
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        Object obj = e.getSource();
        if (obj instanceof JTable) {
            JTable table = (JTable) obj;
            if (table.equals(tbEmpleados)) {
            }
        }
        if (seccionMaterialesActiva) {
            if (!obj.equals(textFields.get(3)) && !seccionEmpleadosActiva && !obj.equals(tbMateriales)) {
                ocultarComponenteTabbedPane("Materiales");
            }
        } else if (seccionEmpleadosActiva) {
            if (!obj.equals(textFields.get(1)) && !seccionMaterialesActiva && !obj.equals(tbEmpleados)) {
                ocultarComponenteTabbedPane("Empleados");
            }
        }

        if (obj instanceof JTextField) {
            JTextField textField = (JTextField) obj;
            if (textField.equals(textFields.get(1))) {
                //FOCUS EN EL TXT DE EMPLEADO
                seccionEmpleadosActiva = true;
                mostrarTablaEmpleado();
            }
            if (textField.equals(textFields.get(3))) {
                seccionMaterialesActiva = true;
                mostrarTablaMaterial();
            }
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        Object obj = e.getSource();
        if (obj instanceof JTextField) {
            JTextField textField = (JTextField) obj;
            if (textField.equals(textFields.get(0))) {
                if (textFields.get(0).getText().isBlank()) {

                    if (enter == false) {
                        Objetos.eventoComun.remarcarLabel(labels.get(0), "Ingresa la cantidad de salida:", Color.red);
                    } else {
                        enter = false;
                    }

                } else {
                    Objetos.eventoComun.remarcarLabel(labels.get(0), "Cantidad:", COLOR_BASE);
                }
            }
        }
        if (obj instanceof JTextArea) {
            JTextArea area = (JTextArea) obj;
            if (area.equals(txtAreaConcepto)) {
                if (txtAreaConcepto.getText().isBlank()) {
                    Objetos.eventoComun.remarcarLabel(labels.get(1), "Ingresa el concepto:", Color.red);
                } else {
                    Objetos.eventoComun.remarcarLabel(labels.get(1), "Concepto:", COLOR_BASE);
                }
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Object obj = e.getSource();
        if (obj instanceof JTable) {
            JTable tb = (JTable) obj;
            if (tb.equals(tbSalidas)) {
                if (tbSalidas.getSelectedRows().length > 0) {
                    if (seccionAgregarSalida) {
                        obtenerRegistro();
                    } else {
                        obtenerSalida();
                    }
                }
            }
            if (tb.equals(tbEmpleados)) {
                if (tbEmpleados.getSelectedRows().length > 0) {
                    obtenerEmpleado();
                    empleadoSeleccionado = true;
                }
            }
            if (tb.equals(tbMateriales)) {
                if (tbMateriales.getSelectedRows().length > 0) {
                    obtenerMaterial();
                    materialSeleccionado = true;
                }
            }
        }
    }

    //FIN DE LOS EVENTOS
    private void reestablecer() {
        accion = "insert";
        salidas = new SalidaDAO().salidas();
        if (!salidas.isEmpty()) {
            paginador = new Paginador<>(salidas, labels.get(6), rows);
        }
        textFields.get(0).setText("");
        textFields.get(1).setText("");
        textFields.get(2).setText("");
        textFields.get(3).setText("");
        textFields.get(4).setText("");
        txtAreaConcepto.setText("");
        textFields.get(0).setEditable(true);
        textFields.get(1).setEditable(true);
        textFields.get(3).setEditable(true);
        textFields.get(5).setText("");
        txtAreaConcepto.setEditable(true);
        Objetos.eventoComun.remarcarLabel(labels.get(0), "Cantidad salida:", Color.black);
        Objetos.eventoComun.remarcarLabel(labels.get(1), "Concepto:", Color.black);
        Objetos.eventoComun.remarcarLabel(labels.get(2), "Empleado solicitante:", Color.black);
        Objetos.eventoComun.remarcarLabel(labels.get(3), "Area del empleado:", Color.black);
        Objetos.eventoComun.remarcarLabel(labels.get(4), "Material solicitado", Color.black);
        Objetos.eventoComun.remarcarLabel(labels.get(5), "Unidad del material", Color.black);
        Objetos.eventoComun.remarcarLabel(labels.get(6), "Paginas", Color.black);
        labels.get(7).setVisible(false);
        labels.get(8).setVisible(false);
        Objetos.eventoComun.remarcarLabel(labels.get(8), "", Color.black);
        Objetos.eventoComun.remarcarLabel(labels.get(7), "", Color.black);
        SpinnerNumberModel numberModel = new SpinnerNumberModel(10, 1, 100, 1);
        spinner.setModel(numberModel);

        buscar("");
        mostrarRegistrosPorPagina();
        buttons.get(1).setVisible(true);

        salida = null;
        empleado = null;
        material = null;
        if (seccionEmpleadosActiva) {
            ocultarComponenteTabbedPane("Empleados");
        } else if (seccionMaterialesActiva) {
            ocultarComponenteTabbedPane("Materiales");
        }
        materialSeleccionado = empleadoSeleccionado = false;
        textFields.get(5).requestFocus();
    }

    private void buscar(String data) {
        Collections.sort(salidas);
        List<Salida> filter;
        String titulos[] = {
            "ID",
            "Material",
            "Cantidad de salida",
            "Unidad",
            "Concepto",
            "Fecha salida",
            "Empleado",
            "Area",
            "Usuario"
        };
        tableModelSalidas = new TableModel(null, titulos);
        int start = (pagNum - 1) * rows;
        if (data.equals("")) {
            filter = salidas.stream().skip(start).limit(rows).collect(Collectors.toList());
        } else {

            filter = salidas.stream().filter(salida
                    -> getNombreEmpleado(salida.getIdEmpleado()).startsWith(data) || getNombreMaterial(salida.getIdMaterial()).startsWith(data)
            ).skip(start).limit(rows).collect(Collectors.toList());
        }
        if (!filter.isEmpty()) {
            filter.forEach(
                    salida -> {
                        Object[] objects = {
                            salida.getIdSalida(),
                            getNombreMaterial(salida.getIdMaterial()),
                            salida.getCantidadSalida(),
                            getNombreUnidad(salida.getIdUnidad()),
                            salida.getConceptoSalida(),
                            salida.getFechaHoraSalida(),
                            getNombreEmpleado(salida.getIdEmpleado()),
                            getNombreArea(salida.getIdArea()),
                            getNombreUsuarioConfirmante(salida.getIdUsuario())
                        };
                        tableModelSalidas.addRow(objects);
                    }
            );
        }
        tbSalidas.setModel(tableModelSalidas);
        tbSalidas.getColumnModel().getColumn(5).setPreferredWidth(200);
        tbSalidas.setRowHeight(30);
        tbSalidas.getColumnModel().getColumn(0).setMaxWidth(0);
        tbSalidas.getColumnModel().getColumn(0).setMinWidth(0);
        tbSalidas.getColumnModel().getColumn(0).setPreferredWidth(0);

    }

    private String getNombreEmpleado(int id) {
        return new EmpleadoDAO().empleados().stream().filter(empleado -> empleado.getIdEmpleado() == id).collect(Collectors.toList()).get(0).getNombre();
    }

    private String getNombreMaterial(int id) {
        return new MaterialDAO().materiales().stream().filter(material
                -> material.getIdMaterial() == id
        ).collect(Collectors.toList()).get(0).getNombreMaterial();
    }

    private String getNombreArea(int id) {
        return new AreaDAO().areas().stream().filter(area
                -> area.getId() == id
        ).collect(Collectors.toList()).get(0).getNombre();
    }

    private String getNombreUnidad(int id) {
        return new UnidadDAO().unidades().stream().filter(unidad
                -> unidad.getId() == id
        ).collect(Collectors.toList()).get(0).getNombre();
    }

    private String getNombreUsuarioConfirmante(int id) {
        return new UsuarioDAO().usuarios().stream().filter(material
                -> material.getIdUsuario() == id
        ).collect(Collectors.toList()).get(0).getUsuario();
    }

    private void mostrarRegistrosPorPagina() {
        pagNum = 1;
        Number box = (Number) spinner.getValue();
        rows = box.intValue();
        if (!salidas.isEmpty()) {
            paginador = new Paginador<>(salidas, labels.get(6), rows);
        }
        buscar("");
    }

    private void obtenerRegistro() {

        accion = "update";
        salida = new Salida();
        int row = tbSalidas.getSelectedRow();
        String nombreMaterial = (String) tableModelSalidas.getValueAt(row, 1);
        String nombreUnidad = (String) tableModelSalidas.getValueAt(row, 3);
        String concepto = (String) tableModelSalidas.getValueAt(row, 4);
        int cantidadSalida = (Integer) tableModelSalidas.getValueAt(row, 2);
        String fechaSalida = (String) tableModelSalidas.getValueAt(row, 5);
        String nombreEmpleado = (String) tableModelSalidas.getValueAt(row, 6);
        String nombreArea = (String) tableModelSalidas.getValueAt(row, 7);
        String nombreUsuario = (String) tableModelSalidas.getValueAt(row, 8);

        int idMaterial = new MaterialDAO().materiales().stream().filter(
                material -> material.getNombreMaterial().equals(nombreMaterial))
                .collect(Collectors.toList()).get(0).getIdMaterial();
        int idUnidad = new UnidadDAO().unidades().stream().filter(
                unidad -> unidad.getNombre().equals(nombreUnidad)
        ).collect(Collectors.toList()).get(0).getId();
        int idEmpleado = new EmpleadoDAO().empleados().stream().filter(
                empleado -> empleado.getNombre().equals(nombreEmpleado)
        ).collect(Collectors.toList()).get(0).getIdEmpleado();
        int idArea = new AreaDAO().areas().stream().filter(
                area -> area.getNombre().equals(nombreArea)
        ).collect(Collectors.toList()).get(0).getId();
        int idUsuario = new UsuarioDAO().usuarios().stream().filter(
                usuario -> usuario.getUsuario().equals(nombreUsuario)
        ).collect(Collectors.toList()).get(0).getIdUsuario();

        salida.setIdSalida((Integer) tableModelSalidas.getValueAt(row, 0));
        salida.setIdMaterial(idMaterial);
        salida.setCantidadSalida(cantidadSalida);
        salida.setIdUnidad(idUnidad);
        salida.setConceptoSalida(concepto);
        salida.setFechaHoraSalida(fechaSalida);
        salida.setIdEmpleado(idEmpleado);
        salida.setIdArea(idArea);
        salida.setIdUsuario(idUsuario);

        textFields.get(0).setText(String.valueOf(salida.getCantidadSalida()));
        textFields.get(0).setForeground(COLOR_TEXTO);
        textFields.get(1).setText(nombreEmpleado);
        textFields.get(1).setForeground(COLOR_TEXTO);
        textFields.get(2).setText(nombreArea);
        textFields.get(2).setForeground(COLOR_TEXTO);
        textFields.get(3).setText(nombreMaterial);
        textFields.get(3).setForeground(COLOR_TEXTO);
        textFields.get(4).setText(nombreArea);
        textFields.get(4).setForeground(COLOR_TEXTO);

        textFields.get(0).setEditable(false);
        textFields.get(1).setEditable(false);
        textFields.get(2).setEditable(false);
        textFields.get(3).setEditable(false);
        textFields.get(4).setEditable(false);

        txtAreaConcepto.setText(concepto);

        txtAreaConcepto.setForeground(COLOR_TEXTO);
        txtAreaConcepto.setEditable(false);
        Objetos.eventoComun.remarcarLabel(labels.get(0), "Cantidad salida:", COLOR_BASE);
        Objetos.eventoComun.remarcarLabel(labels.get(1), "Concepto:", COLOR_BASE);
        Objetos.eventoComun.remarcarLabel(labels.get(2), "Empleado solicitante:", COLOR_BASE);
        Objetos.eventoComun.remarcarLabel(labels.get(3), "Area del empleado:", COLOR_BASE);
        Objetos.eventoComun.remarcarLabel(labels.get(4), "Material solicitado", COLOR_BASE);
        Objetos.eventoComun.remarcarLabel(labels.get(5), "Unidad del material", COLOR_BASE);
        labels.get(7).setVisible(true);
        Objetos.eventoComun.remarcarLabel(labels.get(7), salida.getFechaHoraSalida(), COLOR_BASE);
        labels.get(8).setVisible(true);
        Objetos.eventoComun.remarcarLabel(labels.get(8), "Fecha de salida:", COLOR_BASE);
    }

    private void buscarEmpleado(String data) {
        empleados = new EmpleadoDAO().empleados();
        List<Empleado> filter;
        String titulos[] = {
            "ID",
            "Nombre",
            "Apellido paterno",
            "Apellido materno",
            "Teléfono",
            "Correo electrónico",
            "Area",
            "Contratado"
        };
        tableModelEmpleados = new TableModel(null, titulos);
        if (data.equals("")) {
            filter = empleados.stream().collect(Collectors.toList());
        } else {
            filter = empleados.stream().filter(empleado
                    -> empleado.getNombre().startsWith(data) || empleado.getApellidoPaterno().startsWith(data)
            ).collect(Collectors.toList());
        }
        if (!filter.isEmpty()) {
            filter = ordenamiento(filter, 0);
            filter.forEach(
                    empleado -> {
                        boolean contratado = empleado.isContratado();
                        if (contratado) {
                            String area = new AreaDAO().areas().stream().filter(
                                    obj -> obj.getId() == empleado.getIdArea()
                            ).collect(Collectors.toList()).get(0).getNombre();
                            Object[] objects = {
                                empleado.getIdEmpleado(),
                                empleado.getNombre(),
                                empleado.getApellidoPaterno(),
                                empleado.getApellidoMaterno(),
                                empleado.getTelefono(),
                                empleado.getEmail(),
                                area,
                                contratado};
                            tableModelEmpleados.addRow(objects);
                        }
                    }
            );

        }

        tbEmpleados.setModel(tableModelEmpleados);
        tbEmpleados.setRowHeight(30);
        tbEmpleados.getColumnModel().getColumn(0).setMaxWidth(0);
        tbEmpleados.getColumnModel().getColumn(0).setMinWidth(0);
        tbEmpleados.getColumnModel().getColumn(0).setPreferredWidth(0);
        tbEmpleados.getColumnModel().getColumn(7).setCellRenderer(new RenderCheckBox());
    }

    private List<Empleado> ordenamiento(List<Empleado> filter, int modoOrdenamiento) {
        switch (modoOrdenamiento) {
            case 0:
                filter.sort(new Comparator<Empleado>() {
                    @Override
                    public int compare(Empleado o1, Empleado o2) {
                        return o1.getNombre().compareToIgnoreCase(o2.getNombre());
                    }

                });
                break;

            case 1:
                filter.sort(new Comparator<Empleado>() {
                    @Override
                    public int compare(Empleado o1, Empleado o2) {
                        return o1.getApellidoPaterno().compareToIgnoreCase(o2.getApellidoPaterno());
                    }

                });
                break;

        }

        return filter;
    }

    private void obtenerEmpleado() {
        int rowS = tbEmpleados.getSelectedRow();
        int idEmpleado = (Integer) tableModelEmpleados.getValueAt(rowS, 0);
        //OBTENER EL ID
        int idArea = new AreaDAO().areas().stream().filter(
                area -> area.getNombre().equals((String) tableModelEmpleados.getValueAt(rowS, 6)
                )).collect(Collectors.toList()).get(0).getId();

        empleado = new Empleado(
                idEmpleado,
                (String) tableModelEmpleados.getValueAt(rowS, 1),
                (String) tableModelEmpleados.getValueAt(rowS, 2),
                (String) tableModelEmpleados.getValueAt(rowS, 3),
                (String) tableModelEmpleados.getValueAt(rowS, 3),
                (String) tableModelEmpleados.getValueAt(rowS, 5),
                (Boolean) tableModelEmpleados.getValueAt(rowS, 7),
                idArea
        );
        textFields.get(1).setText(empleado.getNombre());
        textFields.get(2).setText(getNombreArea(empleado.getIdArea()));
        Objetos.eventoComun.remarcarLabel(labels.get(2), "Empleado solicitante:", COLOR_BASE);
        Objetos.eventoComun.remarcarLabel(labels.get(3), "Area del empleado:", COLOR_BASE);
        ocultarComponenteTabbedPane("Empleados");
        seccionEmpleadosActiva = false;
    }

    private void buscarMaterial(String data) {
        materiales = new MaterialDAO().materiales();
        List<Material> filter = materiales;
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
        tableModelMateriales = new TableModel(null, titulos);
        if (data.equals("")) {
            filter = materiales.stream().collect(Collectors.toList());
        } else {
            filter = materiales.stream().filter(material
                    -> material.getNombreMaterial().startsWith(data) || material.getSku().startsWith(data)
            ).collect(Collectors.toList());
        }
        if (!filter.isEmpty()) {
            filter.forEach(
                    material -> {
                        String clasificacion = new ClasificacionDAO().clasificaciones().stream().filter(
                                obj -> obj.getId() == material.getIdClasificacion()
                        ).collect(Collectors.toList()).get(0).getNombre();
                        String tienda = new TiendaDAO().tiendas().stream().filter(
                                obj -> obj.getId() == material.getIdTienda()
                        ).collect(Collectors.toList()).get(0).getNombre();
                        Object[] objects = {
                            material.getIdMaterial(),
                            material.getNombreMaterial(),
                            material.getCantidad(),
                            material.getLimiteMinimo(),
                            material.getSku(),
                            material.getFechaIngreso(),
                            getNombreUnidad(material.getIdUnidad()),
                            clasificacion,
                            tienda,
                            getNombreUsuarioConfirmante(material.getIdUsuario())
                        };
                        tableModelMateriales.addRow(objects);
                    }
            );
        }
        tbMateriales.setModel(tableModelMateriales);
        tbMateriales.getColumnModel().getColumn(5).setPreferredWidth(200);
        tbMateriales.setRowHeight(30);
        tbMateriales.getColumnModel().getColumn(0).setMaxWidth(0);
        tbMateriales.getColumnModel().getColumn(0).setMinWidth(0);
        tbMateriales.getColumnModel().getColumn(0).setPreferredWidth(0);
    }

    private void obtenerMaterial() {
        int row = tbMateriales.getSelectedRow();
        int idMaterial = (Integer) tableModelMateriales.getValueAt(row, 0);
        //OBTENEMOS LOS IDS
        int idUnidad = new UnidadDAO().unidades().stream().filter(
                unidad -> unidad.getNombre().equals((String) tableModelMateriales.getValueAt(row, 6))
        ).collect(Collectors.toList()).get(0).getId();
        int idClasificacion = new ClasificacionDAO().clasificaciones().stream().filter(
                clasificacion -> clasificacion.getNombre().equals((String) tableModelMateriales.getValueAt(row, 7)
                )).collect(Collectors.toList()).get(0).getId();
        int idTienda = new TiendaDAO().tiendas().stream().filter(
                tienda -> tienda.getNombre().equals((String) tableModelMateriales.getValueAt(row, 8)
                )).collect(Collectors.toList()).get(0).getId();
        //FIN 
        String nombreMaterial = (String) tableModelMateriales.getValueAt(row, 1);
        int cantidad = (Integer) tableModelMateriales.getValueAt(row, 2);
        int limiteMinimo = (Integer) tableModelMateriales.getValueAt(row, 3);
        String sku = (String) tableModelMateriales.getValueAt(row, 4);
        String fechaIngreso = (String) tableModelMateriales.getValueAt(row, 5);
        material = new Material(idMaterial, nombreMaterial, cantidad, limiteMinimo, sku, fechaIngreso, idUnidad, idClasificacion, idTienda, usuario.getIdUsuario());
        textFields.get(3).setText(material.getNombreMaterial());
        textFields.get(4).setText(getNombreUnidad(material.getIdUnidad()));
        Objetos.eventoComun.remarcarLabel(labels.get(4), "Material solicitado", new Color(0, 153, 51));
        Objetos.eventoComun.remarcarLabel(labels.get(5), "Unidad del material", new Color(0, 153, 51));
        ocultarComponenteTabbedPane("Materiales");
        seccionMaterialesActiva = false;
    }

    private boolean validarEntrada() {
        if (textFields.get(0).getText().isBlank() && txtAreaConcepto.getText().isBlank() && textFields.get(1).getText().isBlank()
                && textFields.get(3).getText().isBlank()) {
            reestablecer();
            Objetos.eventoComun.remarcarLabel(labels.get(0), "Ingresa la cantidad de salida:", Color.red);
            Objetos.eventoComun.remarcarLabel(labels.get(2), "Ingresa el empleado solicitante:", Color.red);
            Objetos.eventoComun.remarcarLabel(labels.get(3), "Area del empleado:", Color.red);
            Objetos.eventoComun.remarcarLabel(labels.get(4), "Material solicitado", Color.red);
            Objetos.eventoComun.remarcarLabel(labels.get(5), "Unidad del material", Color.red);
            return false;
        } else if (textFields.get(0).getText().isBlank()) {
            Objetos.eventoComun.remarcarLabel(labels.get(0), "Ingresa la cantidad de salida:", Color.red);
            textFields.get(0).requestFocus();
            return false;
        } else if (txtAreaConcepto.getText().isBlank()) {
            Objetos.eventoComun.remarcarLabel(labels.get(1), "Ingresa el concepto:", Color.red);
            txtAreaConcepto.requestFocus();
            return false;
        } else if (textFields.get(1).getText().isBlank()) {
            Objetos.eventoComun.remarcarLabel(labels.get(2), "Ingresa el empleado solicitante:", Color.red);
            Objetos.eventoComun.remarcarLabel(labels.get(3), "Area del empleado:", Color.red);
            textFields.get(1).requestFocus();
            return false;
        } else if (textFields.get(3).getText().isBlank()) {
            Objetos.eventoComun.remarcarLabel(labels.get(4), "Material solicitado", Color.red);
            Objetos.eventoComun.remarcarLabel(labels.get(5), "Unidad del material", Color.red);
            textFields.get(3).requestFocus();
            return false;
        }
        return true;
    }

    private void insertarSalida() {
        try {
            if (Integer.parseInt(textFields.get(0).getText()) <= material.getCantidad()) {

                Object[] data = {
                    textFields.get(0).getText(),
                    txtAreaConcepto.getText(),
                    getFecha(),
                    empleado.getIdEmpleado(),
                    empleado.getIdArea(),
                    material.getIdMaterial(),
                    material.getIdUnidad(),
                    usuario.getIdUsuario()
                };
                new SalidaDAO().insert(data);
                material.setCantidad(material.getCantidad() - Integer.parseInt(textFields.get(0).getText()));
                Object[] materialData = {material.getCantidad()};
                new MaterialDAO().updateCantidad(material.getIdMaterial(), materialData);
                reestablecer();
            } else {
                JOptionPane.showMessageDialog(null, "La cantidad de stock del material es insuficiente");
                Objetos.eventoComun.remarcarLabel(labels.get(0), "Cantidad de salida invalida:", Color.red);
                textFields.get(0).requestFocus();
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    private void pager(String method) {
        switch (method) {
            case METHOD_FIRST -> {
                if (!salidas.isEmpty()) {
                    pagNum = paginador.primero();
                }
            }
            case METHOD_LAST -> {
                if (!salidas.isEmpty()) {
                    pagNum = paginador.anterior();
                }
            }
            case METHOD_NEXT -> {
                if (!salidas.isEmpty()) {
                    pagNum = paginador.siguiente();
                }
            }
            case METHOD_LATEST -> {
                if (!salidas.isEmpty()) {
                    pagNum = paginador.ultimo();
                }
            }
        }
        buscar("");
    }

    private void mostrarTablaEmpleado() {
        if (tabbedPaneSalidas.getTabCount() < 2) {
            tabbedPaneSalidas.addTab("Empleados", componentEmpleados);
            tabbedPaneSalidas.setSelectedIndex(tabbedPaneSalidas.getTabCount() - 1);
            buscarEmpleado("");
        }
    }

    private void mostrarTablaMaterial() {
        if (tabbedPaneSalidas.getTabCount() < 2) {
            tabbedPaneSalidas.addTab("Materiales", componentMateriales);
            tabbedPaneSalidas.setSelectedIndex(tabbedPaneSalidas.getTabCount() - 1);
            buscarMaterial("");
        }
    }

    public void reestablecerReporte() {
        listModel = new DefaultListModel();
        lstSalidas.setModel(listModel);
        Objetos.eventoComun.remarcarLabel(labels.get(9), "Empleado que reporta:", COLOR_BASE);
        Objetos.eventoComun.remarcarLabel(labels.get(10), getNombreEmpleado(usuario.getIdEmpleado()), COLOR_BASE);
        Objetos.eventoComun.remarcarLabel(labels.get(11), "Fecha:", COLOR_BASE);
        Objetos.eventoComun.remarcarLabel(labels.get(12), getFecha(), COLOR_BASE);
        Objetos.eventoComun.remarcarLabel(labels.get(13), "Salidas a reportar:", COLOR_BASE);
        textFields.get(5).requestFocus();
    }

    public void obtenerSalida() {
        salida = new Salida();
        int row = tbSalidas.getSelectedRow();
        String nombreMaterial = (String) tableModelSalidas.getValueAt(row, 1);
        String nombreUnidad = (String) tableModelSalidas.getValueAt(row, 3);
        String concepto = (String) tableModelSalidas.getValueAt(row, 4);
        int cantidadSalida = (Integer) tableModelSalidas.getValueAt(row, 2);
        String fechaSalida = (String) tableModelSalidas.getValueAt(row, 5);
        String nombreEmpleado = (String) tableModelSalidas.getValueAt(row, 6);
        String nombreArea = (String) tableModelSalidas.getValueAt(row, 7);
        String nombreUsuario = (String) tableModelSalidas.getValueAt(row, 8);
        int idMaterial = new MaterialDAO().materiales().stream().filter(
                material -> material.getNombreMaterial().equals(nombreMaterial))
                .collect(Collectors.toList()).get(0).getIdMaterial();
        int idUnidad = new UnidadDAO().unidades().stream().filter(
                unidad -> unidad.getNombre().equals(nombreUnidad)
        ).collect(Collectors.toList()).get(0).getId();
        int idEmpleado = new EmpleadoDAO().empleados().stream().filter(
                empleado -> empleado.getNombre().equals(nombreEmpleado)
        ).collect(Collectors.toList()).get(0).getIdEmpleado();
        int idArea = new AreaDAO().areas().stream().filter(
                area -> area.getNombre().equals(nombreArea)
        ).collect(Collectors.toList()).get(0).getId();
        int idUsuario = new UsuarioDAO().usuarios().stream().filter(
                usuario -> usuario.getUsuario().equals(nombreUsuario)
        ).collect(Collectors.toList()).get(0).getIdUsuario();
        salida.setIdSalida((Integer) tableModelSalidas.getValueAt(row, 0));
        salida.setIdMaterial(idMaterial);
        salida.setCantidadSalida(cantidadSalida);
        salida.setIdUnidad(idUnidad);
        salida.setConceptoSalida(concepto);
        salida.setFechaHoraSalida(fechaSalida);
        salida.setIdEmpleado(idEmpleado);
        salida.setIdArea(idArea);
        salida.setIdUsuario(idUsuario);
        boolean dentro = false;
        if (listModel.isEmpty()) {
            listModel.addElement(salida);
        } else {
            for (int i = 0; i < listModel.size(); i++) {
                if (salida.getIdSalida() == listModel.getElementAt(i).getIdSalida()) {
                    dentro = true;
                    listModel.removeElementAt(i);
                }
            }
            if (!dentro) {
                listModel.addElement(salida);
            }
        }
    }

    public String getFecha() {
        String strFormat = "hh: mm: ss a dd-MM-YYYY";
        SimpleDateFormat dateFormat = new SimpleDateFormat(strFormat);
        Date fecha = new Date();
        return dateFormat.format(fecha).toString();
    }

    public String getApellidoEmpleado(int id) {
        return new EmpleadoDAO().empleados().stream().filter(emp -> emp.getIdEmpleado() == id).
                collect(Collectors.toList()).get(0).getApellidoPaterno();
    }

    public String getContactoEmpleado(int id) {
        return new EmpleadoDAO().empleados().stream().filter(emp -> emp.getIdEmpleado() == id).
                collect(Collectors.toList()).get(0).getEmail();
    }
}
