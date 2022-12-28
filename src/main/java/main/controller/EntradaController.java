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
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import static main.library.EventoComun.*;
import main.library.Objetos;
import static main.library.Objetos.*;
import main.library.Paginador;
import main.library.TableModel;
import main.model.ClasificacionDAO;
import main.model.Empleado;
import main.model.EmpleadoDAO;
import main.model.Entrada;
import main.model.EntradaDAO;
import main.model.Material;
import main.model.MaterialDAO;
import main.model.TiendaDAO;
import main.model.UnidadDAO;
import main.model.Usuario;
import main.model.UsuarioDAO;

/**
 *
 * @author heber
 */
public class EntradaController extends MouseAdapter implements ActionListener, ChangeListener, KeyListener, FocusListener {

    //ELEMENTOS VISUALES
    private JTabbedPane tabbedPaneEntradas;
    private JTable tbMateriales;
    private JTable tbEntradas;
    private JSpinner spinner;
    private List<JLabel> labels;
    private List<JButton> buttons;
    private List<JTextField> textFields;

    //ELEMENTOS DEL PAGINADOR
    private Paginador<Entrada> paginador;
    private int rows = 20;
    private int pagNum = 1;

    //ELEMENTOS DE LA CLASE
    private TableModel tableModelEntradas;
    private TableModel tableModelMateriales;
    private Component componentMateriales;
    private int selectedRow = -1;

    private List<Entrada> entradas;
    private List<Material> materiales;
    private Usuario usuario;
    private Entrada entrada;
    private Material material;
    private final boolean administrador;
    private boolean seccionMaterialesActiva;
    private String accion;

    public EntradaController(JTabbedPane tabbedEntradas, JTable tbMateriales, JTable tbEntradas, JSpinner spinner, List<JLabel> labels, List<JButton> buttons, List<JTextField> textFields, Object object) {
        this.tabbedPaneEntradas = tabbedEntradas;
        this.tbMateriales = tbMateriales;
        this.tbEntradas = tbEntradas;
        this.spinner = spinner;
        this.labels = labels;
        this.buttons = buttons;
        this.textFields = textFields;
        if (object instanceof Usuario) {
            usuario = (Usuario) object;
            administrador = usuario.isAdministrador();
        } else {
            administrador = false;
        }

        componentMateriales = tabbedPaneEntradas.getComponent(tabbedPaneEntradas.getTabCount() - 1);
        tabbedPaneEntradas.removeTabAt(tabbedEntradas.getTabCount() - 1);
        reestablecer();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source instanceof JButton) {
            JButton button = (JButton) source;
            if (button.equals(buttons.get(0))) {
                reestablecer();
            }
            if (button.equals(buttons.get(1))) {
                if(accion.equals("insert")){
                    insertarEntrada();
                }
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
            if (pane.equals(tabbedPaneEntradas)) {
                if (tabbedPaneEntradas.getTabCount() > 1) {
                    tabbedPaneEntradas.setSelectedIndex(1);
                }
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        Object obj = e.getSource();
        if (obj.equals(textFields.get(1))) {
            Objetos.eventoComun.numberKeyPressed(e);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        Object source = e.getSource();
        if (source instanceof JTextField) {
            JTextField textField = (JTextField) source;

            if (textField.equals(textFields.get(0))) {
                if (e.getKeyChar() != '\n') {
                    material = null;
                    labels.get(0).setForeground(Color.BLACK);

                    //if (administrador) {
                    buscarMaterial(textFields.get(0).getText());
                    /*} else {
                        buscarMaterialPorOperador(textFields.get(0).getText());
                    }*/
                } else {
                    if (tbMateriales.getRowCount() > 0) {
                        tbMateriales.setRowSelectionInterval(0, 0);

                        //if (administrador) {
                        obtenerMaterial();
                        /*} else {
                            obtenerMaterialPorOperador();
                        }*/
                    }
                }
            }
        }

        if (source instanceof JTable) {
            JTable table = (JTable) source;

            if (table.equals(tbEntradas)) {
                if (selectedRow != tbEntradas.getSelectedRow()) {
                    if (tbEntradas.getSelectedRows().length > 0) {
                        obtenerRegistro();
                        selectedRow = tbEntradas.getSelectedRow();
                    }
                } else {
                    selectedRow = -1;
                    reestablecer();
                }
            }
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        Object source = e.getSource();

        if (seccionMaterialesActiva) {
            if (!source.equals(textFields.get(0)) && !source.equals(tbMateriales)) {
                ocultarComponenteTabbedPane("Materiales");
            }
        }

        if (source instanceof JTextField) {
            JTextField textField = (JTextField) source;
            if (textField.equals(textFields.get(0))) {
                seccionMaterialesActiva = true;
                mostrarTablaMaterial();
            }
        }
    }

    @Override
    public void focusLost(FocusEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Object obj = e.getSource();
        if (obj instanceof JTable) {
            JTable tb = (JTable) obj;
            if (tb.equals(tbEntradas)) {
                if (selectedRow != tbEntradas.getSelectedRow()) {
                    if (tbEntradas.getSelectedRows().length > 0) {
                        obtenerRegistro();
                        selectedRow = tbEntradas.getSelectedRow();
                    }
                } else {
                    selectedRow = -1;
                    reestablecer();
                }
            }
            if (tb.equals(tbMateriales)) {
                if (tbMateriales.getSelectedRows().length > 0) {
                    //if(administrador){
                    obtenerMaterial();
                    //}else{
                    //    obtenerMaterialPorOperador();
                    //}
                }
            }
        }
    }

    private void reestablecer() {
        accion = "insert";
        entradas = new EntradaDAO().entradas();
        if (!entradas.isEmpty()) {
            paginador = new Paginador<>(entradas, labels.get(3), rows);
        }

        textFields.get(0).setText("");
        textFields.get(1).setText("");
        textFields.get(2).setText("");
        textFields.get(0).setEditable(true);
        textFields.get(1).setEditable(true);

        Objetos.eventoComun.remarcarLabel(labels.get(0), "Nombre del material", Color.black);
        Objetos.eventoComun.remarcarLabel(labels.get(1), "Cantidad", Color.BLACK);
        labels.get(2).setVisible(false);
        labels.get(4).setVisible(false);
        labels.get(5).setVisible(false);
        labels.get(6).setVisible(false);

        SpinnerNumberModel numberModel = new SpinnerNumberModel(20, 1, 100, 1);
        spinner.setModel(numberModel);

        buscar("");
        mostrarRegistrosPorPagina();

        buttons.get(0).setVisible(true);
        entrada = null;
        material = null;

        if (seccionMaterialesActiva) {
            ocultarComponenteTabbedPane("Materiales");
        }
        textFields.get(2).requestFocus();
    }

    private void buscar(String data) {
        Collections.sort(entradas);
        List<Entrada> filter;
        String titulos[] = {
            "ID",
            "Material",
            "Cantidad",
            "Fecha",
            "Recibio"
        };
        tableModelEntradas = new TableModel(null, titulos);
        int start = (pagNum - 1) * rows;
        if (data.equals("")) {
            filter = entradas.stream().skip(start).limit(rows).collect(Collectors.toList());
        } else {
            filter = entradas.stream().filter(entrada
                    -> getNombreEmpleado(entrada.getIdEmpleado()).startsWith(data) || getNombreMaterial(entrada.getIdMaterial()).startsWith(data)
            ).skip(start).limit(rows).collect(Collectors.toList());
        }
        if (!filter.isEmpty()) {
            filter.forEach(
                    entrada -> {
                        Object[] objects = {
                            entrada.getIdEntrada(),
                            getNombreMaterial(entrada.getIdMaterial()),
                            entrada.getCantidadEntrada(),
                            entrada.getFechaEntrada(),
                            getNombreEmpleado(entrada.getIdEmpleado()),};
                        tableModelEntradas.addRow(objects);
                    }
            );
        }
        tbEntradas.setModel(tableModelEntradas);
        tbEntradas.getColumnModel().getColumn(3).setPreferredWidth(200);
        tbEntradas.setRowHeight(30);
        tbEntradas.getColumnModel().getColumn(0).setMaxWidth(0);
        tbEntradas.getColumnModel().getColumn(0).setMinWidth(0);
        tbEntradas.getColumnModel().getColumn(0).setPreferredWidth(0);
    }

    private String getNombreEmpleado(int id) {
        Empleado empleadoTemp = new EmpleadoDAO().empleados().stream().filter(empleado -> empleado.getIdEmpleado() == id).collect(Collectors.toList()).get(0);
        //String nombre = new EmpleadoDAO().empleados().stream().filter(empleado -> empleado.getIdEmpleado() == id).collect(Collectors.toList()).get(0).getNombre();
        String nombre = empleadoTemp.getNombre() + " " + empleadoTemp.getApellidoPaterno() + " " + empleadoTemp.getApellidoMaterno();
        return nombre;
    }

    private String getNombreMaterial(int id) {
        return new MaterialDAO().materiales().stream().filter(material
                -> material.getIdMaterial() == id
        ).collect(Collectors.toList()).get(0).getNombreMaterial();
    }

    private void mostrarRegistrosPorPagina() {
        pagNum = 1;
        Number box = (Number) spinner.getValue();
        rows = box.intValue();
        if (!entradas.isEmpty()) {
            paginador = new Paginador<>(entradas, labels.get(3), rows);
        }
        buscar("");
    }

    private void ocultarComponenteTabbedPane(String titulo) {
        if (tabbedPaneEntradas.getTabCount() > 1) {
            if (titulo.equals("Materiales")) {
                componentMateriales = tabbedPaneEntradas.getComponent(tabbedPaneEntradas.getTabCount() - 1);
                tabbedPaneEntradas.removeTabAt(tabbedPaneEntradas.getTabCount() - 1);
                seccionMaterialesActiva = false;
            }
        }
    }

    private void insertarEntrada() {
        try {
            Object[] data = {
                textFields.get(1).getText(),
                getFecha(),
                material.getIdMaterial(),
                usuario.getIdEmpleado()
            };
            new EntradaDAO().insert(data);
            material.setCantidad(material.getCantidad() + Integer.parseInt(textFields.get(1).getText()));
            Object[] materialData = {material.getCantidad(), getFecha(), material.getIdUsuario()};
            new MaterialDAO().updateCantidad(material.getIdMaterial(), materialData, true);
            reestablecer();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    private void mostrarTablaMaterial() {
        if (tabbedPaneEntradas.getTabCount() < 2) {
            tabbedPaneEntradas.addTab("Materiales", componentMateriales);
            tabbedPaneEntradas.setSelectedIndex(tabbedPaneEntradas.getTabCount() - 1);
            //if(administrador){
            buscarMaterial("");
        }
    }

    private void buscarMaterial(String data) {
        materiales = new MaterialDAO().materiales();
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
        textFields.get(0).setText(material.getNombreMaterial());
        //textFields.get(4).setText(getNombreUnidad(material.getIdUnidad()));
        Objetos.eventoComun.remarcarLabel(labels.get(0), "Material solicitado", COLOR_BASE);
        //Objetos.eventoComun.remarcarLabel(labels.get(0), "Unidad del material", COLOR_BASE);

        ocultarComponenteTabbedPane("Materiales");
        seccionMaterialesActiva = false;

        textFields.get(1).requestFocus();

    }

    private void obtenerRegistro() {
        accion = "update";
        entrada = new Entrada();
        int row = tbEntradas.getSelectedRow();
        String nombreMaterial = (String) tableModelEntradas.getValueAt(row, 1);
        int cantidad = (Integer) tableModelEntradas.getValueAt(row, 2);
        String fechaEntrada = (String) tableModelEntradas.getValueAt(row, 3);
        String recibio = (String) tableModelEntradas.getValueAt(row, 4);

        int idMaterial = new MaterialDAO().materiales().stream().filter(
                material -> material.getNombreMaterial().equals(nombreMaterial))
                .collect(Collectors.toList()).get(0).getIdMaterial();
        int idEmpleado = new EmpleadoDAO().empleados().stream().filter(
                empleado -> (empleado.getNombre() + " " + empleado.getApellidoPaterno() + " " + empleado.getApellidoMaterno()).equals(recibio)
        ).collect(Collectors.toList()).get(0).getIdEmpleado();

        entrada.setCantidadEntrada(cantidad);
        entrada.setFechaEntrada(fechaEntrada);
        entrada.setIdEmpleado(idEmpleado);
        entrada.setIdMaterial(idMaterial);

        textFields.get(0).setText(nombreMaterial);
        textFields.get(0).setForeground(COLOR_TEXTO);
        textFields.get(1).setText(String.valueOf(entrada.getCantidadEntrada()));
        textFields.get(1).setForeground(COLOR_TEXTO);
        textFields.get(0).setEditable(false);
        textFields.get(1).setEditable(false);

        Objetos.eventoComun.remarcarLabel(labels.get(0), "Nombre del material:", COLOR_BASE);
        Objetos.eventoComun.remarcarLabel(labels.get(1), "Cantidad:", COLOR_BASE);
        labels.get(2).setVisible(true);
        labels.get(4).setVisible(true);
        labels.get(5).setVisible(true);
        labels.get(6).setVisible(true);
        Objetos.eventoComun.remarcarLabel(labels.get(6), fechaEntrada, COLOR_BASE);
        Objetos.eventoComun.remarcarLabel(labels.get(5), recibio, COLOR_BASE);
    }

    private void pager(String method) {
        switch (method) {
            case METHOD_FIRST -> {
                if (!entradas.isEmpty()) {
                    pagNum = paginador.primero();
                }
            }
            case METHOD_LAST -> {
                if (!entradas.isEmpty()) {
                    pagNum = paginador.anterior();
                }
            }
            case METHOD_NEXT -> {
                if (!entradas.isEmpty()) {
                    pagNum = paginador.siguiente();
                }
            }
            case METHOD_LATEST -> {
                if (!entradas.isEmpty()) {
                    pagNum = paginador.ultimo();
                }
            }
        }
        buscar("");
    }
}
