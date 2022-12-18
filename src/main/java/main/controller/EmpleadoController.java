package main.controller;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import main.library.Paginador;
import main.library.TableModel;
import main.model.Area;
import main.model.AreaDAO;
import main.model.Empleado;
import main.model.EmpleadoDAO;
import main.view.Estructura;

public class EmpleadoController implements FocusListener, KeyListener, ActionListener, MouseListener, TableCellRenderer {

    private TableModel defaultTableModel;
    private String accion = "insert";
    private Empleado empleado;
    private List<Empleado> empleados;
    private List<Area> areas;
    private int rowSelected;
    private int modoOrdenamiento = 0;

    //ELEMENTOS DE LA VISTA
    private List<JButton> buttons;
    private List<JTextField> textFields;
    private List<JLabel> labels;
    private List<JLabel> labelsColumn;
    private JComboBox cbxAreas;
    private JTable tbEmpleados;
    private Estructura estructura;

    //ELEMENTOS DEL PAGIANDOR
    private Paginador<Empleado> paginador;
    private int rows = 10;
    private int pagNum = 1;
    private JSpinner spinner;

    public EmpleadoController(List<JButton> buttons, List<JTextField> textFields, List<JLabel> labels, JComboBox cbxAreas, JSpinner spinner, JTable tbEmpleados, Estructura estructura, List<JLabel> labelsColumn) {
        this.buttons = buttons;
        this.textFields = textFields;
        this.labels = labels;
        this.cbxAreas = cbxAreas;
        this.spinner = spinner;
        this.tbEmpleados = tbEmpleados;
        this.estructura = estructura;
        this.labelsColumn = labelsColumn;
        reestablecer();
    }

    private void reestablecer() {

        rowSelected = -1;
        accion = "insert";
        iniciarListas();

        if (!empleados.isEmpty()) {
            paginador = new Paginador<>(empleados, labels.get(6), rows);
        }

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

        labels.get(0).setText("Nombre:");
        labels.get(1).setText("Apellido paterno:");
        labels.get(2).setText("Apellido materno:");
        labels.get(3).setText("Teléfono:");
        labels.get(4).setText("Correo electrónico");
        labels.get(5).setText("Area:");
        for (int i = 0; i < 6; i++) {
            labels.get(i).setForeground(Color.black);
        }
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

            filter = ordenamiento(filter);

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
            paginador = new Paginador<>(empleados, labels.get(6), rows);
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

    private void remarcarLabel(JLabel label, String string, Color color) {
        label.setText(string);
        label.setForeground(color);
    }

    @Override
    public void focusLost(FocusEvent e) {
        Object source = e.getSource();
        if (source instanceof JTextField) {
            JTextField textField = (JTextField) source;
            if (textField.equals(textFields.get(0))) {
                if (textFields.get(0).getText().isBlank()) {
                    remarcarLabel(labels.get(0), "Ingresa un nombre", Color.red);
                }
            }
            if (textField.equals(textFields.get(1))) {
                if (textFields.get(1).getText().isBlank()) {
                    remarcarLabel(labels.get(1), "Ingresa un apellido paterno", Color.red);
                }
            }
            if (textField.equals(textFields.get(2))) {
                if (textFields.get(2).getText().isEmpty()) {
                    remarcarLabel(labels.get(2), "Ingresa un apellido materno", Color.red);
                }
            }
            if (textField.equals(textFields.get(3))) {
                if (textFields.get(3).getText().isBlank()) {
                    remarcarLabel(labels.get(3), "Ingresa un teléfono", Color.red);
                }
            }
            if (textField.equals(textFields.get(4))) {
                if (textFields.get(4).getText().isBlank()) {
                    remarcarLabel(labels.get(4), "Ingresa un correo electrónico", Color.red);
                }
            }
            /*if (cbxAreas.getSelectedItem() == null) {
                remarcarLabel(labels.get(5), "Selecciona una area", Color.red);
            }*/

        }
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
            JTextField textField = (JTextField) source;

            if (e.getKeyChar() == '\n') {
                nextTextField((JTextField) source, e);
            }

            if (textField.equals(textFields.get(0))) {
                if (!textFields.get(0).getText().isBlank()) {
                    remarcarLabel(labels.get(0), "Nombre", new Color(0, 153, 51));
                } else {
                    remarcarLabel(labels.get(0), "Ingresa un nombre", Color.RED);
                }
            }
            if (textField.equals(textFields.get(1))) {
                if (!textFields.get(1).getText().isBlank()) {
                    remarcarLabel(labels.get(1), "Apellido paterno", new Color(0, 153, 51));
                } else {
                    remarcarLabel(labels.get(1), "Ingresa un apellido paterno", Color.RED);
                }
            }
            if (textField.equals(textFields.get(2))) {
                if (!textFields.get(2).getText().isEmpty()) {
                    remarcarLabel(labels.get(2), "Apellido materno", new Color(0, 153, 51));
                } else {
                    remarcarLabel(labels.get(2), "Ingresa un apellido materno", Color.RED);
                }
            }
            if (textField.equals(textFields.get(3))) {
                if (!textFields.get(3).getText().isBlank()) {
                    remarcarLabel(labels.get(3), "Teléfono", new Color(0, 153, 51));
                } else {
                    remarcarLabel(labels.get(3), "Ingresa un teléfono", Color.RED);
                }
            }
            if (textField.equals(textFields.get(4))) {
                if (!textFields.get(4).getText().isBlank()) {
                    remarcarLabel(labels.get(4), "Correo electrónico", new Color(0, 153, 51));
                } else {
                    remarcarLabel(labels.get(4), "Ingresa un correo electrónico", Color.RED);
                }
            }

            if (textField.equals(textFields.get(5))) {
                if (textField.equals(textFields.get(5))) {
                    if (!textFields.get(0).getText().equals("")) {
                        reestablecer();
                    }
                    textFields.get(5).requestFocus();
                    buscar(textFields.get(5).getText());
                }

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
            if (accion.equals("insert")) {
                if (validarEntradas()) {
                    insertarEmpleado();
                }
            } else if (accion.equals("update")) {
                if (validarEntradas()) {
                    updateEmpleado();
                }
            }
        }
        if (source.equals(buttons.get(1))) {
            try {
                new EmpleadoDAO().remove(empleado.getIdEmpleado());
                reestablecer();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "No se puede eliminar este material.");
            }
        }
        if (true) {

        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Object obj = e.getSource();
        if (obj instanceof JTable) {
            JTable tb = (JTable) obj;
            
            if (tb.equals(tbEmpleados)) {
                if (rowSelected != tbEmpleados.getSelectedRow()) {
                    rowSelected = tbEmpleados.getSelectedRow();
                    if (tbEmpleados.getSelectedRows().length > 0) {
                        obtenerRegistro();
                    }
                } else {
                    reestablecer();
                }
            }
        }
        if (obj instanceof JLabel) {
            //System.out.println("AJUUUA");
        }
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    private void obtenerRegistro() {
        accion = "update";
        int row = tbEmpleados.getSelectedRow();
        int idEmpleado = (Integer) defaultTableModel.getValueAt(row, 0);
        textFields.get(0).setText((String) defaultTableModel.getValueAt(row, 1));
        textFields.get(1).setText((String) defaultTableModel.getValueAt(row, 2));
        textFields.get(2).setText((String) defaultTableModel.getValueAt(row, 3));
        textFields.get(3).setText((String) defaultTableModel.getValueAt(row, 4));
        textFields.get(4).setText((String) defaultTableModel.getValueAt(row, 5));
        this.cbxAreas.setSelectedItem((String) defaultTableModel.getValueAt(row, 6));
        textFields.get(0).requestFocus();
        buttons.get(1).setVisible(true);

        //OBTENER EL ID
        int idArea = areas.stream().filter(
                area -> area.getNombre().equals(cbxAreas.getSelectedItem().toString()
                )).collect(Collectors.toList()).get(0).getId();

        empleado = new Empleado(
                idEmpleado,
                textFields.get(0).getText(),
                textFields.get(1).getText(),
                textFields.get(2).getText(),
                textFields.get(3).getText(),
                textFields.get(4).getText(),
                idArea
        );

        if (!textFields.get(5).getText().equals("")) {
            textFields.get(5).setText("");
        }

        for (int i = 0; i < 6; i++) {
            labels.get(i).setForeground(new Color(0, 153, 51));
        }

    }

    private void updateEmpleado() {
        int idArea = areas.stream().filter(
                area -> area.getNombre().equals(cbxAreas.getSelectedItem().toString())
        ).collect(Collectors.toList()).get(0).getId();

        try {

            empleado.setNombre(textFields.get(0).getText());
            empleado.setApellidoPaterno(textFields.get(1).getText());
            empleado.setApellidoMaterno(textFields.get(2).getText());
            empleado.setTelefono(textFields.get(3).getText());
            empleado.setEmail(textFields.get(4).getText());
            empleado.setIdArea(idArea);
            Object[] data = {
                empleado.getNombre(),
                empleado.getApellidoPaterno(),
                empleado.getApellidoMaterno(),
                empleado.getTelefono(),
                empleado.getEmail(),
                empleado.getIdArea()
            };
            new EmpleadoDAO().update(empleado.getIdEmpleado(), data);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Hubo un error.");
        }

        reestablecer();
    }

    public boolean validarEntradas() {
        if (textFields.get(0).getText().isBlank()) {
            JOptionPane.showMessageDialog(estructura, "Ingresa un nombre", "Validacion de entrada", JOptionPane.WARNING_MESSAGE);
            textFields.get(0).requestFocus();
            return false;
        } else if (textFields.get(1).getText().isBlank()) {
            JOptionPane.showMessageDialog(estructura, "Ingresa un apellido", "Validacion de entrada", JOptionPane.WARNING_MESSAGE);
            textFields.get(1).requestFocus();
            return false;
        } else if (textFields.get(2).getText().isEmpty()) {
            JOptionPane.showMessageDialog(estructura, "Ingresa un apelldio materno", "Validacion de entrada", JOptionPane.WARNING_MESSAGE);
            textFields.get(2).requestFocus();
            return false;
        } else if (textFields.get(3).getText().isBlank()) {
            JOptionPane.showMessageDialog(estructura, "Ingresa un teléfono", "Validacion de entrada", JOptionPane.WARNING_MESSAGE);
            textFields.get(3).requestFocus();
            return false;
        } else if (textFields.get(4).getText().isBlank()) {
            JOptionPane.showMessageDialog(estructura, "Ingresa un correo electrónico", "Validacion de entrada", JOptionPane.WARNING_MESSAGE);
            textFields.get(4).requestFocus();
            return false;
        } else if (cbxAreas.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(estructura, "Selecciona una area", "Validacion de entrada", JOptionPane.WARNING_MESSAGE);
            cbxAreas.requestFocus();
            return false;
        }
        return true;
    }

    private List<Empleado> ordenamiento(List<Empleado> filter) {
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

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
     return new JLabel();
    }

}
