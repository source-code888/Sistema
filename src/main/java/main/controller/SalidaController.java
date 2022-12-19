package main.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.util.List;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import main.library.Paginador;
import main.model.Empleado;
import main.model.Salida;
import main.library.Objetos;

public class SalidaController extends MouseAdapter implements ActionListener, ChangeListener, KeyListener, FocusListener {

    //ELEMENTOS VISUALES
    private JTabbedPane tabbedPaneSalidas;
    private JTable tbSalidas;
    private JTable tbEmpleados;
    private List<JLabel> labels;
    private List<JButton> buttons;
    private List<JTextField> textFields;
    private JSpinner spinner;

    //ELEMENTOS DE LA CLASE
    private List<Salida> salidas;
    private List<Empleado> empleados;

    //ELEMENTOS DEL PAGINADOR
    private Paginador<Salida> paginador;
    private int rows = 10;
    private int pagNum = 1;

    public SalidaController(JTabbedPane tabbedPaneSalidas, JTable tbSalidas, JTable tbEmpleados, List<JLabel> labels, List<JButton> buttons, List<JTextField> textFields, JSpinner spinner) {
        this.tabbedPaneSalidas = tabbedPaneSalidas;
        this.tbSalidas = tbSalidas;
        this.tbEmpleados = tbEmpleados;
        this.labels = labels;
        this.buttons = buttons;
        this.textFields = textFields;
        this.spinner = spinner;
    }

    //EVENTOS
    @Override
    public void actionPerformed(ActionEvent e) {
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
}
