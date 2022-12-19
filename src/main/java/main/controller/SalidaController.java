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
import java.util.Comparator;
import java.util.Date;
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
import static main.library.Objetos.METHOD_FIRST;
import static main.library.Objetos.METHOD_LAST;
import static main.library.Objetos.METHOD_LATEST;
import static main.library.Objetos.METHOD_NEXT;

public class SalidaController extends MouseAdapter implements ActionListener, ChangeListener, KeyListener, FocusListener {

    //ELEMENTOS VISUALES
    private JTabbedPane tabbedPaneSalidas;
    private JTable tbSalidas;
    private JTable tbEmpleados;
    private JTable tbMateriales;

    private List<JLabel> labels;
    private List<JButton> buttons;
    private List<JTextField> textFields;
    private JSpinner spinner;
    private JTextArea txtAreaConcepto;
    //ELEMENTOS DE LA CLASE
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
    //ELEMENTOS DEL PAGINADOR
    private Paginador<Salida> paginador;
    private int rows = 10;
    private int pagNum = 1;
    private boolean tabbedEmpleado = false;
    private boolean seleccionado = false;

    public SalidaController(Object object, JTabbedPane tabbedPaneSalidas, JTable tbSalidas, JTable tbEmpleados, JTable tbMateriales, List<JLabel> labels, List<JButton> buttons, List<JTextField> textFields, JSpinner spinner, JTextArea txtAreaConcepto) {
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
        ocultarComponenteTabbedPane("Todos");
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

        if (titulo.equals("Empleados")) {
            componentEmpleados = tabbedPaneSalidas.getComponent(tabbedPaneSalidas.getTabCount() - 2);
            tabbedPaneSalidas.removeTabAt(tabbedPaneSalidas.getTabCount() - 2);
        } else if (titulo.equals("Materiales")) {
            componentMateriales = tabbedPaneSalidas.getComponent(tabbedPaneSalidas.getTabCount() - 1);
            tabbedPaneSalidas.removeTabAt(tabbedPaneSalidas.getTabCount() - 1);
        } else if (titulo.equals("Todos")) {
            componentMateriales = tabbedPaneSalidas.getComponent(tabbedPaneSalidas.getTabCount() - 1);
            componentEmpleados = tabbedPaneSalidas.getComponent(tabbedPaneSalidas.getTabCount() - 2);
            tabbedPaneSalidas.removeTabAt(tabbedPaneSalidas.getTabCount() - 1);
            tabbedPaneSalidas.removeTabAt(tabbedPaneSalidas.getTabCount() - 1);
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
                    obtenerEmpleado();
                }
            }
            if (tb.equals(tbMateriales)) {
                if (tbMateriales.getSelectedRows().length > 0) {
                    obtenerMaterial();
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
                }
            }
            if (txt.equals(textFields.get(1))) {
                buscarEmpleado(textFields.get(1).getText());
            }
            if (txt.equals(textFields.get(3))) {
                buscarMaterial(textFields.get(3).getText());
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
    public void focusGained(FocusEvent e) {
        Object obj = e.getSource();
        if (obj instanceof JTextField) {
            JTextField textField = (JTextField) obj;
            if (textField.equals(textFields.get(1))) {
                if (textFields.get(1).getText().isBlank()) {
                    tabbedEmpleado = true;
                    tabbedPaneSalidas.addTab("Empleados", componentEmpleados);
                    tabbedPaneSalidas.setSelectedIndex(tabbedPaneSalidas.getTabCount() - 1);
                    buscarEmpleado("");
                }
            }
            if (textField.equals(textFields.get(3))) {
                if (textFields.get(3).getText().isBlank()) {
                    if (seleccionado) {
                        tabbedEmpleado = false;
                        tabbedPaneSalidas.addTab("Materiales", componentMateriales);
                        tabbedPaneSalidas.setSelectedIndex(tabbedPaneSalidas.getTabCount() - 1);
                        buscarMaterial("");
                    }
                }
            }
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        Object obj = e.getSource();
        if (obj instanceof JTextField) {
            JTextField textField = (JTextField) obj;
            if (textField.equals(textFields.get(1))) {
                if (seleccionado) {
                    if (tabbedEmpleado) {
                        tabbedPaneSalidas.removeTabAt(tabbedPaneSalidas.getTabCount() - 1);
                    }
                    tabbedEmpleado = false;
                }
            }
            if (textField.equals(textFields.get(0))) {
                if (textFields.get(0).getText().isBlank()) {
                    Objetos.eventoComun.remarcarLabel(labels.get(0), "Ingresa la cantidad de salida:", Color.red);
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
                    obtenerRegistro();
                }
            }
            if (tb.equals(tbEmpleados)) {
                if (tbEmpleados.getSelectedRows().length > 0) {
                    obtenerEmpleado();
                    seleccionado = true;
                }
            }
            if (tb.equals(tbMateriales)) {
                if (tbMateriales.getSelectedRows().length > 0) {
                    obtenerMaterial();
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
        Objetos.eventoComun.remarcarLabel(labels.get(0), "Cantidad salida:", Color.black);
        Objetos.eventoComun.remarcarLabel(labels.get(1), "Concepto:", Color.black);
        Objetos.eventoComun.remarcarLabel(labels.get(2), "Empleado solicitante:", Color.black);
        Objetos.eventoComun.remarcarLabel(labels.get(3), "Area del empleado:", Color.black);
        Objetos.eventoComun.remarcarLabel(labels.get(4), "Material solicitado", Color.black);
        Objetos.eventoComun.remarcarLabel(labels.get(5), "Unidad del material", Color.black);
        Objetos.eventoComun.remarcarLabel(labels.get(6), "Paginas", Color.black);

        SpinnerNumberModel numberModel = new SpinnerNumberModel(10, 1, 100, 1);
        spinner.setModel(numberModel);

        buscar("");
        mostrarRegistrosPorPagina();
        buttons.get(1).setVisible(true);
        salida = null;
        empleado = null;
        material = null;
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
        pagNum = paginador.primero();
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
        textFields.get(1).setText(nombreEmpleado);
        textFields.get(2).setText(nombreArea);
        textFields.get(3).setText(nombreMaterial);
        textFields.get(4).setText(nombreArea);

        textFields.get(0).setEnabled(false);
        textFields.get(1).setEnabled(false);
        textFields.get(2).setEnabled(false);
        textFields.get(3).setEnabled(false);
        textFields.get(4).setEnabled(false);

        txtAreaConcepto.setText(concepto);
        txtAreaConcepto.setEnabled(false);
        Objetos.eventoComun.remarcarLabel(labels.get(0), "Cantidad salida:", new Color(0, 153, 51));
        Objetos.eventoComun.remarcarLabel(labels.get(1), "Concepto:", new Color(0, 153, 51));
        Objetos.eventoComun.remarcarLabel(labels.get(2), "Empleado solicitante:", new Color(0, 153, 51));
        Objetos.eventoComun.remarcarLabel(labels.get(3), "Area del empleado:", new Color(0, 153, 51));
        Objetos.eventoComun.remarcarLabel(labels.get(4), "Material solicitado", new Color(0, 153, 51));
        Objetos.eventoComun.remarcarLabel(labels.get(5), "Unidad del material", new Color(0, 153, 51));
        Objetos.eventoComun.remarcarLabel(labels.get(6), "Paginas", new Color(0, 153, 51));
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
            "Area",};
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
                            area,};
                        tableModelEmpleados.addRow(objects);
                    }
            );

        }

        tbEmpleados.setModel(tableModelEmpleados);
        tbEmpleados.setRowHeight(30);
        tbEmpleados.getColumnModel().getColumn(0).setMaxWidth(0);
        tbEmpleados.getColumnModel().getColumn(0).setMinWidth(0);
        tbEmpleados.getColumnModel().getColumn(0).setPreferredWidth(0);
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
                idArea
        );
        textFields.get(1).setText(empleado.getNombre());
        textFields.get(2).setText(getNombreArea(empleado.getIdArea()));
        Objetos.eventoComun.remarcarLabel(labels.get(2), "Empleado solicitante:", COLOR_BASE);
        Objetos.eventoComun.remarcarLabel(labels.get(3), "Area del empleado:", COLOR_BASE);
        textFields.get(1).requestFocus();
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
        if (!tabbedEmpleado) {
            tabbedPaneSalidas.removeTabAt(tabbedPaneSalidas.getTabCount() - 1);
        }
        seleccionado = false;
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
                String strFormat = "hh: mm: ss a dd-MM-YYYY";
                SimpleDateFormat dateFormat = new SimpleDateFormat(strFormat);
                Date fecha = new Date();
                String fechaCompleta = dateFormat.format(fecha).toString();
                Object[] data = {
                    textFields.get(0).getText(),
                    txtAreaConcepto.getText(),
                    fechaCompleta,
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
}
