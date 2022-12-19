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
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import main.library.Paginador;
import main.model.Empleado;
import main.model.Salida;
import main.library.Objetos;
import main.library.TableModel;
import main.model.AreaDAO;
import main.model.EmpleadoDAO;
import main.model.Material;
import main.model.MaterialDAO;
import main.model.SalidaDAO;
import main.model.UnidadDAO;
import main.model.Usuario;
import main.model.UsuarioDAO;

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
    //ELEMENTOS DEL PAGINADOR
    private Paginador<Salida> paginador;
    private int rows = 10;
    private int pagNum = 1;

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

            }

            if (button.equals(buttons.get(1))) {

            }
            if (button.equals(buttons.get(2))) {

            }
            if (button.equals(buttons.get(3))) {

            }
            if (button.equals(buttons.get(4))) {

            }
            if (button.equals(buttons.get(5))) {

            }
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void focusGained(FocusEvent e) {
    }

    @Override
    public void focusLost(FocusEvent e) {
    }

    //FIN DE LOS EVENTOS
    private void reestablecer() {
        accion = "insert";
        salidas = new SalidaDAO().salidas();
        textFields.get(0).setText("");
        textFields.get(1).setText("");
        textFields.get(2).setText("");
        textFields.get(3).setText("");
        textFields.get(4).setText("");
        textFields.get(5).setText("");

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
        pagNum = 1;
        Number box = (Number) spinner.getValue();
        rows = box.intValue();
        if (!materiales.isEmpty()) {
            paginador = new Paginador<>(salidas, labels.get(6), rows);
        }
        buscar("");
    }

    private void obtenerRegistro() {
        /*
        "ID",
            "Material",
            "Cantidad de salida",
            "Unidad",
            "Concepto",
            "Fecha salida",
            "Empleado",
            "Area",
            "Usuario"
         */
        accion = "update";
        salida = new Salida();
        int row = tbSalidas.getSelectedRow();
        String nombreMaterial = (String) tableModelSalidas.getValueAt(row, 1);
        String 
        int idMaterial = new MaterialDAO().materiales().stream().filter(
                material -> material.getNombreMaterial().equals(nombreMaterial))
                .collect(Collectors.toList()).get(0).getIdMaterial();
        int idUnidad = new UnidadDAO().unidades().stream().filter(
                unidad -> unidad.getNombre().equals((String) tableModelSalidas.getValueAt(row, 3))
        ).collect(Collectors.toList()).get(0).getId();
        salida.setIdSalida((Integer) tableModelSalidas.getValueAt(row, 0));
        salida.setIdMaterial(idMaterial);
        salida.setCantidadSalida((Integer) tableModelSalidas.getValueAt(row, 2));
        salida.setIdUnidad(idUnidad);
        
    }
}
