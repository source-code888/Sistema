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
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
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
import static main.library.Objetos.*;
import static main.library.EventoComun.*;
import main.library.RenderCheckBox;

public class SalidaController extends MouseAdapter
        implements ActionListener, ChangeListener, KeyListener, FocusListener {

    // ELEMENTOS VISUALES
    private final JTabbedPane tabbedPaneSalidas;
    private final JTable tbSalidas;
    private final JTable tbEmpleados;
    private final JTable tbMateriales;

    private final List<JLabel> labels;
    private final List<JButton> buttons;
    private final List<JTextField> textFields;
    private final JSpinner spinner;
    private final JTextArea txtAreaConcepto;

    // ELEMENTOS DE LA CLASE
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
    private int selectedRowSalida = -1;
    private boolean enter = false;
    private boolean seccionEmpleadosActiva = false;
    private boolean seccionMaterialesActiva = false;

    private final boolean administrador;

    // ELEMENTOS DEL PAGINADOR
    private Paginador<Salida> paginador;
    private int rows = MAX_REGISTROS_SECCIONES;
    private int pagNum = 1;

    public SalidaController(Object object, JTabbedPane tabbedPaneSalidas, JTable tbSalidas, JTable tbEmpleados,
            JTable tbMateriales, List<JLabel> labels, List<JButton> buttons, List<JTextField> textFields,
            JSpinner spinner, JTextArea txtAreaConcepto) {
        if (object instanceof Usuario) {
            usuario = (Usuario) object;
            administrador = usuario.isAdministrador();
        } else {
            administrador = false;
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
     * Titulos
     * </p>
     * <ul>
     * <li>
     * <p>
     * Empleados: Oculta el panel empleados
     * </p>
     * </li>
     * <li>
     * <p>
     * Materiales: Oculta el panel materiales
     * </p>
     * </li>
     * <li>
     * <p>
     * Todos: Oculta todos los paneles
     * </p>
     * </li>
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

    // EVENTOS
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
        }
        if (obj instanceof JSpinner) {
            JSpinner sp = (JSpinner) obj;
            if (sp.equals(spinner)) {
                mostrarRegistrosPorPagina();
                buscar(textFields.get(5).getText());
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
                    obtenerRegistro();
                }
            }

            if (tb.equals(tbEmpleados)) {
                if (tbEmpleados.getSelectedRows().length > 0) {
                    if (administrador) {
                        obtenerEmpleado();
                    } else {
                        obtenerEmpleadoPorOperador();
                    }
                }
            }
            if (tb.equals(tbMateriales)) {
                if (tbMateriales.getSelectedRows().length > 0) {
                    if (administrador) {
                        obtenerMaterial();
                    } else {
                        obtenerMaterialPorOperador();
                    }
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
                        actionPerformed(new ActionEvent(buttons.get(0), 1001, "", e.getWhen(), 16));
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
                    if (administrador) {
                        buscarEmpleado(textFields.get(1).getText().toLowerCase());
                    } else {
                        buscarEmpleadoPorOperador(textFields.get(1).getText().toLowerCase());
                    }
                } else {
                    if (tbEmpleados.getRowCount() > 0) {
                        tbEmpleados.setRowSelectionInterval(0, 0);
                        if (administrador) {
                            obtenerEmpleado();
                        } else {
                            obtenerEmpleadoPorOperador();
                        }
                        textFields.get(3).requestFocus();
                    }
                }
            }
            if (txt.equals(textFields.get(3))) {
                if (e.getKeyChar() != '\n') {
                    material = null;
                    labels.get(4).setForeground(Color.BLACK);
                    labels.get(5).setForeground(Color.BLACK);

                    textFields.get(4).setText("");
                    if (administrador) {
                        buscarMaterial(textFields.get(3).getText());
                    } else {
                        buscarMaterialPorOperador(textFields.get(3).getText());
                    }
                } else {
                    if (tbMateriales.getRowCount() > 0) {
                        tbMateriales.setRowSelectionInterval(0, 0);

                        if (administrador) {
                            obtenerMaterial();
                        } else {
                            obtenerMaterialPorOperador();
                        }
                        textFields.get(0).requestFocus();
                    }
                }
            }
            if (txt.equals(textFields.get(5))) {
                if (e.getKeyChar() != '\n') {
                    buscar(textFields.get(5).getText());
                    mostrarRegistrosPorPagina();
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
                // FOCUS EN EL TXT DE EMPLEADO
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
                if (selectedRowSalida != tbSalidas.getSelectedRow()) {
                    if (tbSalidas.getSelectedRows().length > 0) {
                        obtenerRegistro();
                        selectedRowSalida = tbSalidas.getSelectedRow();
                    }
                } else {
                    reestablecer();
                }
            }
            if (tb.equals(tbEmpleados)) {
                if (tbEmpleados.getSelectedRows().length > 0) {
                    if (administrador) {
                        obtenerEmpleado();
                    } else {
                        obtenerEmpleadoPorOperador();
                    }
                }
            }
            if (tb.equals(tbMateriales)) {
                if (tbMateriales.getSelectedRows().length > 0) {
                    if (administrador) {
                        obtenerMaterial();
                    } else {
                        obtenerMaterialPorOperador();
                    }
                }
            }
        }
    }

    // FIN DE LOS EVENTOS
    private void reestablecer() {
        accion = "insert";
        salidas = SalidaDAO.getInstance().getSalidas();
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
        SpinnerNumberModel numberModel = new SpinnerNumberModel(20, 1, 100, 1);
        spinner.setModel(numberModel);
        mostrarRegistrosPorPagina();
        buscar("");
        buttons.get(1).setVisible(true);

        salida = null;
        empleado = null;
        material = null;
        if (seccionEmpleadosActiva) {
            ocultarComponenteTabbedPane("Empleados");
        } else if (seccionMaterialesActiva) {
            ocultarComponenteTabbedPane("Materiales");
        }
        textFields.get(5).requestFocus();
        selectedRowSalida = -1;
    }

    private void buscar(String data) {
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
        filter = salidaLst(data).stream().skip(start).limit(rows).collect(Collectors.toList());
        Collections.sort(filter);
        if (!filter.isEmpty()) {
            filter.forEach(
                    sa -> {
                        Object[] objects = {
                            sa.getIdSalida(),
                            sa.getNombreMaterial(),
                            sa.getCantidadSalida(),
                            sa.getUnidadMaterial(),
                            sa.getConceptoSalida(),
                            sa.getFechaHoraSalida(),
                            sa.getNombreEmpleado(),
                            sa.getAreaEmpleado(),
                            getNombreUsuarioConfirmante(sa.getIdUsuario())
                        };
                        tableModelSalidas.addRow(objects);
                    });
        }
        tbSalidas.setModel(tableModelSalidas);
        tbSalidas.getColumnModel().getColumn(5).setPreferredWidth(200);
        tbSalidas.setRowHeight(30);
        tbSalidas.getColumnModel().getColumn(0).setMaxWidth(0);
        tbSalidas.getColumnModel().getColumn(0).setMinWidth(0);
        tbSalidas.getColumnModel().getColumn(0).setPreferredWidth(0);

    }

    private String getNombreEmpleado(int id) {
        Empleado empleadoTemp = EmpleadoDAO.getInstance().getEmpleados().stream()
                .filter(emp -> emp.getIdEmpleado() == id).collect(Collectors.toList()).get(0);
        // String nombre = new EmpleadoDAO().empleados().stream().filter(empleado ->
        // empleado.getIdEmpleado() ==
        // id).collect(Collectors.toList()).get(0).getNombre();
        String nombre = empleadoTemp.getNombre() + " " + empleadoTemp.getApellidoPaterno() + " "
                + empleadoTemp.getApellidoMaterno();
        return nombre;
    }

    private String getNombreMaterial(int id) {
        return MaterialDAO.getInstance().getMateriales().stream().filter(mat -> mat.getIdMaterial() == id)
                .collect(Collectors.toList()).get(0).getNombreMaterial();
    }

    private String getNombreArea(int id) {
        return AreaDAO.getInstance().getAreas().stream().filter(area -> area.getId() == id).collect(Collectors.toList()).get(0)
                .getNombre();
    }

    private String getNombreUnidad(int id) {
        return UnidadDAO.getInstance().getUnidades().stream().filter(unidad -> unidad.getId() == id).collect(Collectors.toList())
                .get(0).getNombre();
    }

    private String getNombreUsuarioConfirmante(int id) {
        return UsuarioDAO.getInstance().getUsuarios().stream().filter(us -> us.getIdUsuario() == id)
                .collect(Collectors.toList()).get(0).getUsuario();
    }

    private void mostrarRegistrosPorPagina() {
        pagNum = 1;
        Number box = (Number) spinner.getValue();
        rows = box.intValue();
        List<Salida> lista = salidaLst(textFields.get(5).getText());
        if (!lista.isEmpty()) {
            paginador = new Paginador<>(lista, labels.get(6), rows);
        }
    }

    private void obtenerRegistro() {
        accion = "update";
        int row = tbSalidas.getSelectedRow();
        String nombreMaterial = (String) tableModelSalidas.getValueAt(row, 1);
        String nombreUnidad = (String) tableModelSalidas.getValueAt(row, 3);
        String concepto = (String) tableModelSalidas.getValueAt(row, 4);
        int cantidadSalida = (Integer) tableModelSalidas.getValueAt(row, 2);
        String fechaSalida = (String) tableModelSalidas.getValueAt(row, 5);
        String nombreEmpleado = (String) tableModelSalidas.getValueAt(row, 6);
        String nombreArea = (String) tableModelSalidas.getValueAt(row, 7);
        String nombreUsuario = (String) tableModelSalidas.getValueAt(row, 8);
        int idUsuario = UsuarioDAO.getInstance().getUsuarios().stream().filter(
                us -> us.getUsuario().equals(nombreUsuario)).collect(Collectors.toList()).get(0)
                .getIdUsuario();
        salida = new Salida.SalidaBuilder()
                .idSalida((Integer) tableModelSalidas.getValueAt(row, 0))
                .nombreMaterial(nombreMaterial)
                .cantidadSalida(cantidadSalida)
                .unidadMaterial(nombreUnidad)
                .conceptoSalida(concepto)
                .fechaHoraSalida(fechaSalida)
                .nombreEmpleado(nombreEmpleado)
                .areaEmpleado(nombreArea)
                .idUsuario(idUsuario)
                .build();
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
        empleados = EmpleadoDAO.getInstance().getEmpleados();
        Collections.sort(empleados);
        List<Empleado> filter;
        String titulos[] = {
            "ID",
            "NID",
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
            filter = empleados.stream()
                    .filter(empleado -> (empleado.getNombre() + " " + empleado.getApellidoPaterno() + " "
                    + empleado.getApellidoMaterno()).toLowerCase().startsWith(data)
                    || empleado.getApellidoPaterno().toLowerCase().startsWith(data)
                    || empleado.getNid().startsWith(data))
                    .collect(Collectors.toList());
        }
        if (!filter.isEmpty()) {
            filter.forEach(
                    empleado -> {
                        boolean contratado = empleado.isContratado();
                        if (contratado) {
                            String area = AreaDAO.getInstance().getAreas().stream().filter(
                                    obj -> obj.getId() == empleado.getIdArea()).collect(Collectors.toList()).get(0)
                                    .getNombre();
                            Object[] objects = {
                                empleado.getIdEmpleado(),
                                empleado.getNid(),
                                empleado.getNombre(),
                                empleado.getApellidoPaterno(),
                                empleado.getApellidoMaterno(),
                                empleado.getTelefono(),
                                empleado.getEmail(),
                                area,
                                contratado};
                            tableModelEmpleados.addRow(objects);
                        }
                    });

        }

        tbEmpleados.setModel(tableModelEmpleados);
        tbEmpleados.setRowHeight(30);
        tbEmpleados.getColumnModel().getColumn(0).setMaxWidth(0);
        tbEmpleados.getColumnModel().getColumn(0).setMinWidth(0);
        tbEmpleados.getColumnModel().getColumn(0).setPreferredWidth(0);
        tbEmpleados.getColumnModel().getColumn(8).setCellRenderer(new RenderCheckBox());
    }

    private void buscarEmpleadoPorOperador(String data) {
        empleados = EmpleadoDAO.getInstance().getEmpleados();
        Collections.sort(empleados);
        List<Empleado> filter;
        String titulos[] = {
            "ID",
            "Nombre",
            "Apellido paterno",
            "Apellido materno",
            "Teléfono",
            "Correo electrónico",
            "Area"
        };
        tableModelEmpleados = new TableModel(null, titulos);
        if (data.equals("")) {
            filter = empleados.stream().collect(Collectors.toList());
        } else {
            filter = empleados.stream()
                    .filter(empleado -> (empleado.getNombre() + " " + empleado.getApellidoPaterno() + " "
                    + empleado.getApellidoMaterno()).toLowerCase().startsWith(data)
                    || empleado.getApellidoPaterno().toLowerCase().startsWith(data)
                    || empleado.getNid().startsWith(data))
                    .collect(Collectors.toList());
        }
        if (!filter.isEmpty()) {
            filter.forEach(
                    empleado -> {
                        boolean contratado = empleado.isContratado();
                        if (contratado) {
                            String area = AreaDAO.getInstance().getAreas().stream().filter(
                                    obj -> obj.getId() == empleado.getIdArea()).collect(Collectors.toList()).get(0)
                                    .getNombre();
                            Object[] objects = {
                                empleado.getIdEmpleado(),
                                empleado.getNombre(),
                                empleado.getApellidoPaterno(),
                                empleado.getApellidoMaterno(),
                                empleado.getTelefono(),
                                empleado.getEmail(),
                                area
                            };
                            tableModelEmpleados.addRow(objects);
                        }
                    });

        }

        tbEmpleados.setModel(tableModelEmpleados);
        tbEmpleados.setRowHeight(30);
        tbEmpleados.getColumnModel().getColumn(0).setMaxWidth(0);
        tbEmpleados.getColumnModel().getColumn(0).setMinWidth(0);
        tbEmpleados.getColumnModel().getColumn(0).setPreferredWidth(0);
    }

    private void obtenerEmpleado() {
        int rowS = tbEmpleados.getSelectedRow();
        int idEmpleado = (Integer) tableModelEmpleados.getValueAt(rowS, 0);
        // OBTENER EL ID
        int idArea = AreaDAO.getInstance().getAreas().stream().filter(
                area -> area.getNombre().equals((String) tableModelEmpleados.getValueAt(rowS, 7)))
                .collect(Collectors.toList()).get(0).getId();
        empleado = new Empleado.EmpleadoBuilder()
                .idEmpleado(idEmpleado)
                .nid((String) tableModelEmpleados.getValueAt(rowS, 1))
                .nombre((String) tableModelEmpleados.getValueAt(rowS, 2))
                .apellidoPaterno((String) tableModelEmpleados.getValueAt(rowS, 3))
                .apellidoMaterno((String) tableModelEmpleados.getValueAt(rowS, 4))
                .telefono((String) tableModelEmpleados.getValueAt(rowS, 5))
                .email((String) tableModelEmpleados.getValueAt(rowS, 6))
                .contratado((Boolean) tableModelEmpleados.getValueAt(rowS, 8))
                .idArea(idArea)
                .build();
        textFields.get(1).setText(getNombreEmpleado(idEmpleado));
        textFields.get(2).setText(getNombreArea(empleado.getIdArea()));
        Objetos.eventoComun.remarcarLabel(labels.get(2), "Empleado solicitante:", COLOR_BASE);
        Objetos.eventoComun.remarcarLabel(labels.get(3), "Area del empleado:", COLOR_BASE);
        ocultarComponenteTabbedPane("Empleados");
        seccionEmpleadosActiva = false;
    }

    private void obtenerEmpleadoPorOperador() {
        int rowS = tbEmpleados.getSelectedRow();
        int idEmpleado = (Integer) tableModelEmpleados.getValueAt(rowS, 0);
        // OBTENER EL ID
        int idArea = AreaDAO.getInstance().getAreas().stream().filter(
                area -> area.getNombre().equals((String) tableModelEmpleados.getValueAt(rowS, 6)))
                .collect(Collectors.toList()).get(0).getId();
        empleado = new Empleado.EmpleadoBuilder()
                .idEmpleado(idEmpleado)
                .nid((String) tableModelEmpleados.getValueAt(rowS, 1))
                .nombre((String) tableModelEmpleados.getValueAt(rowS, 2))
                .apellidoPaterno((String) tableModelEmpleados.getValueAt(rowS, 3))
                .apellidoMaterno((String) tableModelEmpleados.getValueAt(rowS, 4))
                .telefono((String) tableModelEmpleados.getValueAt(rowS, 5))
                .idArea(idArea)
                .build();
        textFields.get(1).setText(getNombreEmpleado(idEmpleado));
        textFields.get(2).setText(getNombreArea(empleado.getIdArea()));
        Objetos.eventoComun.remarcarLabel(labels.get(2), "Empleado solicitante:", COLOR_BASE);
        Objetos.eventoComun.remarcarLabel(labels.get(3), "Area del empleado:", COLOR_BASE);
        ocultarComponenteTabbedPane("Empleados");
        seccionEmpleadosActiva = false;
    }

    private void buscarMaterial(String data) {
        materiales = MaterialDAO.getInstance().getMateriales();
        Collections.sort(materiales);
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
            filter = materiales.stream().filter(
                    material -> material.getNombreMaterial().startsWith(data) || material.getSku().startsWith(data))
                    .collect(Collectors.toList());
        }
        if (!filter.isEmpty()) {
            filter.forEach(
                    material -> {
                        String clasificacion = ClasificacionDAO.getInstance().getClasificaciones().stream().filter(
                                obj -> obj.getId() == material.getIdClasificacion()).collect(Collectors.toList()).get(0)
                                .getNombre();
                        String tienda = TiendaDAO.getInstance().getTiendas().stream().filter(
                                obj -> obj.getId() == material.getIdTienda()).collect(Collectors.toList()).get(0)
                                .getNombre();
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
                    });
        }
        tbMateriales.setModel(tableModelMateriales);
        tbMateriales.getColumnModel().getColumn(5).setPreferredWidth(200);
        tbMateriales.setRowHeight(30);
        tbMateriales.getColumnModel().getColumn(0).setMaxWidth(0);
        tbMateriales.getColumnModel().getColumn(0).setMinWidth(0);
        tbMateriales.getColumnModel().getColumn(0).setPreferredWidth(0);
    }

    private void buscarMaterialPorOperador(String data) {
        materiales = MaterialDAO.getInstance().getMateriales();
        Collections.sort(materiales);
        List<Material> filter = materiales;
        String titulos[] = {
            "ID",
            "Nombre",
            "Cantidad",
            "Minimo",
            "Unidad",
            "Usuario"
        };
        tableModelMateriales = new TableModel(null, titulos);
        if (data.equals("")) {
            filter = materiales.stream().collect(Collectors.toList());
        } else {
            filter = materiales.stream().filter(
                    material -> material.getNombreMaterial().startsWith(data) || material.getSku().startsWith(data))
                    .collect(Collectors.toList());
        }
        if (!filter.isEmpty()) {
            filter.forEach(
                    material -> {
                        Object[] objects = {
                            material.getIdMaterial(),
                            material.getNombreMaterial(),
                            material.getCantidad(),
                            material.getLimiteMinimo(),
                            getNombreUnidad(material.getIdUnidad()),
                            getNombreUsuarioConfirmante(material.getIdUsuario())
                        };
                        tableModelMateriales.addRow(objects);
                    });
        }
        tbMateriales.setModel(tableModelMateriales);
        tbMateriales.setRowHeight(30);
        tbMateriales.getColumnModel().getColumn(0).setMaxWidth(0);
        tbMateriales.getColumnModel().getColumn(0).setMinWidth(0);
        tbMateriales.getColumnModel().getColumn(0).setPreferredWidth(0);
        tbMateriales.getColumnModel().getColumn(3).setMaxWidth(0);
        tbMateriales.getColumnModel().getColumn(3).setMinWidth(0);
        tbMateriales.getColumnModel().getColumn(3).setPreferredWidth(0);
    }

    private void obtenerMaterial() {
        int row = tbMateriales.getSelectedRow();
        int idMaterial = (Integer) tableModelMateriales.getValueAt(row, 0);
        // OBTENEMOS LOS IDS
        int idUnidad = UnidadDAO.getInstance().getUnidades().stream().filter(
                unidad -> unidad.getNombre().equals((String) tableModelMateriales.getValueAt(row, 6)))
                .collect(Collectors.toList()).get(0).getId();
        int idClasificacion = ClasificacionDAO.getInstance().getClasificaciones().stream().filter(
                clasificacion -> clasificacion.getNombre().equals((String) tableModelMateriales.getValueAt(row, 7)))
                .collect(Collectors.toList()).get(0).getId();
        int idTienda = TiendaDAO.getInstance().getTiendas().stream().filter(
                tienda -> tienda.getNombre().equals((String) tableModelMateriales.getValueAt(row, 8)))
                .collect(Collectors.toList()).get(0).getId();
        // FIN
        String nombreMaterial = (String) tableModelMateriales.getValueAt(row, 1);
        int cantidad = (Integer) tableModelMateriales.getValueAt(row, 2);
        int limiteMinimo = (Integer) tableModelMateriales.getValueAt(row, 3);
        String sku = (String) tableModelMateriales.getValueAt(row, 4);
        String fechaIngreso = (String) tableModelMateriales.getValueAt(row, 5);
        material = new Material.MaterialBuilder()
                .idMaterial(idMaterial)
                .nombreMaterial(nombreMaterial)
                .cantidad(cantidad)
                .limiteMinimo(limiteMinimo)
                .sku(sku)
                .fechaIngreso(fechaIngreso)
                .idUnidad(idUnidad)
                .idClasificacion(idClasificacion)
                .idTienda(idTienda)
                .idUsuario(usuario.getIdUsuario())
                .build();
        textFields.get(3).setText(material.getNombreMaterial());
        textFields.get(4).setText(getNombreUnidad(material.getIdUnidad()));
        Objetos.eventoComun.remarcarLabel(labels.get(4), "Material solicitado", COLOR_BASE);
        Objetos.eventoComun.remarcarLabel(labels.get(5), "Unidad del material", COLOR_BASE);
        ocultarComponenteTabbedPane("Materiales");
        seccionMaterialesActiva = false;
    }

    private void obtenerMaterialPorOperador() {
        /**
         * "ID", "Nombre", "Cantidad", "Unidad", "Usuario"
         */
        int row = tbMateriales.getSelectedRow();
        int idMaterial = (Integer) tableModelMateriales.getValueAt(row, 0);
        // OBTENEMOS LOS IDS
        int idUnidad = UnidadDAO.getInstance().getUnidades().stream().filter(
                unidad -> unidad.getNombre().equals((String) tableModelMateriales.getValueAt(row, 4)))
                .collect(Collectors.toList()).get(0).getId();
        // FIN
        String nombreMaterial = (String) tableModelMateriales.getValueAt(row, 1);
        int cantidad = (Integer) tableModelMateriales.getValueAt(row, 2);
        material = new Material.MaterialBuilder()
                .idMaterial(idMaterial)
                .nombreMaterial(nombreMaterial)
                .cantidad(cantidad)
                .idUnidad(idUnidad)
                .idUsuario(usuario.getIdUsuario())
                .build();
        textFields.get(3).setText(material.getNombreMaterial());
        textFields.get(4).setText(getNombreUnidad(material.getIdUnidad()));
        Objetos.eventoComun.remarcarLabel(labels.get(4), "Material solicitado", COLOR_BASE);
        Objetos.eventoComun.remarcarLabel(labels.get(5), "Unidad del material", COLOR_BASE);
        ocultarComponenteTabbedPane("Materiales");
        seccionMaterialesActiva = false;
    }

    private boolean validarEntrada() {
        if (textFields.get(0).getText().isBlank() && txtAreaConcepto.getText().isBlank()
                && textFields.get(1).getText().isBlank()
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
                    empleado.getNombre() + " " + empleado.getApellidoPaterno() + " " + empleado.getApellidoPaterno(),
                    getNombreArea(empleado.getIdArea()),
                    getNombreMaterial(material.getIdMaterial()),
                    getNombreUnidad(material.getIdUnidad()),
                    usuario.getIdUsuario()
                };
                SalidaDAO.getInstance().insert(data);
                material.setCantidad(material.getCantidad() - Integer.parseInt(textFields.get(0).getText()));
                Object[] materialData = {material.getCantidad()};
                MaterialDAO.getInstance().updateCantidad(material.getIdMaterial(), materialData, false);
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
        String filtro = textFields.get(5).getText();
        if (salidaLst(filtro).isEmpty()) {
            return;
        }
        switch (method) {
            case METHOD_FIRST -> {
                pagNum = paginador.primero();
            }
            case METHOD_LAST -> {
                pagNum = paginador.anterior();
            }
            case METHOD_NEXT -> {
                pagNum = paginador.siguiente();
            }
            case METHOD_LATEST -> {
                pagNum = paginador.ultimo();
            }
        }
        buscar(filtro);
    }

    private void mostrarTablaEmpleado() {
        if (tabbedPaneSalidas.getTabCount() < 2) {
            tabbedPaneSalidas.addTab("Empleados", componentEmpleados);
            tabbedPaneSalidas.setSelectedIndex(tabbedPaneSalidas.getTabCount() - 1);
            if (administrador) {
                buscarEmpleado("");
            } else {
                buscarEmpleadoPorOperador("");
            }
        }
    }

    private void mostrarTablaMaterial() {
        if (tabbedPaneSalidas.getTabCount() < 2) {
            tabbedPaneSalidas.addTab("Materiales", componentMateriales);
            tabbedPaneSalidas.setSelectedIndex(tabbedPaneSalidas.getTabCount() - 1);
            if (administrador) {
                buscarMaterial("");
            } else {
                buscarMaterialPorOperador("");
            }
        }
    }

    private List<Salida> salidaLst(String filtro) {
        if (filtro.isBlank()) {
            return salidas;
        }
        return salidas.stream()
                .filter(salida -> salida.getNombreEmpleado().toLowerCase().startsWith(filtro.toLowerCase())
                || salida.getNombreMaterial().toLowerCase().startsWith(filtro.toLowerCase())
                || salida.getFechaHoraSalida().toLowerCase().startsWith(filtro.toLowerCase()))
                .collect(Collectors.toList());
    }
}
