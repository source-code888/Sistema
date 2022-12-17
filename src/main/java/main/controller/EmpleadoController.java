package main.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import main.library.Paginador;
import main.library.TableModel;
import main.model.Area;
import main.model.AreaDAO;
import main.model.Empleado;
import main.model.EmpleadoDAO;
import main.model.MaterialDAO;

public class EmpleadoController implements FocusListener, KeyListener, ActionListener {

    private TableModel defaultTableModel;
    private String accion = "insert";
    private Empleado empleado;
    private List<Empleado> empleados;
    private List<Area> areas;

    //ELEMENTOS DE LA VISTA
    private List<JButton> buttons;
    private List<JTextField> textFields;
    private List<JLabel> labels;
    private JComboBox cbxAreas;
    private JTable tbEmpleados;

    //ELEMENTOS DEL PAGIANDOR
    private Paginador<Empleado> paginador;
    private int rows = 10;
    private int pagNum = 1;
    private JSpinner spinner;

    public EmpleadoController(List<JButton> buttons, List<JTextField> textFields, List<JLabel> labels, JComboBox cbxAreas, JSpinner spinner, JTable tbEmpleados) {
        this.buttons = buttons;
        this.textFields = textFields;
        this.labels = labels;
        this.cbxAreas = cbxAreas;
        this.spinner = spinner;
        this.tbEmpleados = tbEmpleados;
        reestablecer();
    }

    private void reestablecer() {
        accion = "insert";
        iniciarListas();
        /*
        if (!empleados.isEmpty()) {
            System.out.println(labels.get(6).getText());
            paginador = new Paginador<>(empleados, labels.get(6), rows);
        }
         */
        for (int i = 0; i < textFields.size(); i++) {
            textFields.get(i).setText("");
        }

        comboModel();

        SpinnerNumberModel spinnerModel = new SpinnerNumberModel(10, 1, 100, 1);
        spinner.setModel(spinnerModel);
        buscar("");
        mostrarRegistrosPorPagina();
        buttons.get(1).setVisible(false);
        empleado = null;
        //labels.get(8).setText("");
        //labels.get(9).setText("");
        //System.out.println(empleados.toString());
    }

    private void iniciarListas() {
        areas = new AreaDAO().areas();
        empleados = new EmpleadoDAO().empleados();
    }

    private void comboModel() {
        iniciarListas();
        String[] objetosUnidad = new String[areas.size()];
        for (int i = 0; i < areas.size(); i++) {
            objetosUnidad[i] = areas.get(i).getNombre();
        }
        DefaultComboBoxModel boxModelU = new DefaultComboBoxModel(objetosUnidad);
        boxModelU.setSelectedItem(null);
        cbxAreas.setModel(boxModelU);
    }

    private void buscar(String data) {
        List<Empleado> filter;
        String titulos[] = {
            "ID",
            "Nombre",
            "Apellido paterno",
            "Apellido materno",
            "Teléfono",
            "Correo electrónico",
            "Area",};
        defaultTableModel = new TableModel(null, titulos);

        int start = (pagNum - 1) * rows;
        if (data.equals("")) {
            filter = empleados.stream().skip(start).limit(rows).collect(Collectors.toList());
        } else {
            filter = empleados.stream().filter(empleado
                    -> empleado.getNombre().startsWith(data) || empleado.getApellidoPaterno().startsWith(data)
            ).skip(start).limit(rows).collect(Collectors.toList());
        }

        if (!filter.isEmpty()) {
            filter.forEach(
                    empleado -> {
                        String area = areas.stream().filter(
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

                        defaultTableModel.addRow(objects);
                    }
            );

        }

        tbEmpleados.setModel(defaultTableModel);
        tbEmpleados.setRowHeight(30);
        tbEmpleados.getColumnModel().getColumn(0).setMaxWidth(0);
        tbEmpleados.getColumnModel().getColumn(0).setMinWidth(0);
        tbEmpleados.getColumnModel().getColumn(0).setPreferredWidth(0);

    }

    private void mostrarRegistrosPorPagina() {
        pagNum = 1;
        Number box = (Number) spinner.getValue();
        rows = box.intValue();
        if (!empleados.isEmpty()) {
            System.out.println(labels.get(6).getText());
            paginador = new Paginador<>(empleados, labels.get(6), rows);
            System.out.println(labels.get(6).getText());
        }
        buscar("");
    }

    @Override
    public void focusGained(FocusEvent e) {
        Object source = e.getSource();
        if (source instanceof JComboBox) {
            if (source.equals(cbxAreas)) {
                comboModel();
            }
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
        Object source = e.getSource();
        if (source instanceof JTextField) {
            JTextField textField = (JTextField) source;
            for (int i = 0; i < 3; i++) {
                if (textField.equals(textFields.get(i))) {
                    validarLetra(e);
                }
            }
            if (textField.equals(textFields.get(3))) {
                validarNumero(e);
                if (textFields.get(3).getText().length() == 10) {
                    e.consume();
                }
            }

        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        Object source = e.getSource();
        if (source instanceof JTextField) {
            if (e.getKeyChar() == '\n') {
                nextTextField((JTextField) source, e);
            }

        }
    }

    private void validarLetra(KeyEvent e) {
        if (!(e.getKeyChar() >= 'A' && e.getKeyChar() <= 'Z') && !(e.getKeyChar() >= 'a' && e.getKeyChar() <= 'z') && (e.getKeyChar() != ' ')) {
            e.consume();
        }
    }

    private void validarNumero(KeyEvent e) {
        if (!(e.getKeyChar() >= '0' && e.getKeyChar() <= '9')) {
            e.consume();
        }
    }

    private void nextTextField(JTextField textField, KeyEvent e) {
        for (int i = 0; i < textFields.size(); i++) {
            if (textField.equals(textFields.get(i))) {
                if (i < textFields.size() - 2) {
                    textFields.get(i + 1).requestFocus();
                } else {
                    this.cbxAreas.requestFocus();
                }
            }
        }

    }

    private void insertarEmpleado() {
        if (accion.equals("insert")) {
            try {
                
                int idArea = areas.stream().filter(
                        area -> area.getNombre().equals(cbxAreas.getSelectedItem().toString()
                        )).collect(Collectors.toList()).get(0).getId();
                
                Object[] data = {
                    textFields.get(0).getText(),
                    textFields.get(1).getText(),
                    textFields.get(2).getText(),
                    textFields.get(3).getText(),
                    textFields.get(4).getText(),
                    idArea
                };
                new EmpleadoDAO().insert(data);
                reestablecer();
            } catch (SQLException ex) {
                System.out.println("ERROR " + ex);
            }

        }
    }

    /*
    List<JButton> buttonsEmpleados = new ArrayList<>();
    buttonsEmpleados.add(this.btnAgregarNuevoEmpleado);
    buttonsEmpleados.add(this.btnEliminarEmpleado);
    buttonsEmpleados.add(this.btnPrimeroEmpleados);
    buttonsEmpleados.add(this.btnAnteriorEmpleados);
    buttonsEmpleados.add(this.btnSiguienteEmpleados);
    buttonsEmpleados.add(this.btnUltimoEmpleados);
    
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source.equals(buttons.get(0))) {
            insertarEmpleado();
        }
    }

}
