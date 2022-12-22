/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import main.library.Paginador;
import main.model.Entrada;
import main.model.EntradaDAO;
import main.model.Material;
import main.model.Usuario;

/**
 *
 * @author heber
 */
public class EntradaController extends MouseAdapter implements ActionListener, ChangeListener, KeyListener, FocusListener {
    //ELEMENTOS VISUALES
    private JTabbedPane tabbedEntradas;
    private JTable tbMateriales;
    private JTable tbEntradas;
    private JSpinner spinner;
    private List<JLabel> labels;
    private List<JButton> buttons;
    private List<JTextField> textFields;
    
    //ELEMENTOS DE LA CLASE
    private Component componentMateriales;
    private List<Entrada> entradas;
    private List<Material> materiales;
    private Usuario usuario;
    private final boolean administrador;
    private String accion;
    
    //ELEMENTOS DEL PAGINADOR
    private Paginador<Entrada> paginador;
    private int rows = 10;
    private int pagNum = 1;

    public EntradaController(JTabbedPane tabbedEntradas, JTable tbMateriales, JTable tbEntradas, JSpinner spinner, List<JLabel> labels, List<JButton> buttons, List<JTextField> textFields, Object object) {
        this.tabbedEntradas = tabbedEntradas;
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
        componentMateriales = tabbedEntradas.getComponent(tabbedEntradas.getComponentCount()-1);
        tabbedEntradas.removeTabAt(tabbedEntradas.getComponentCount()-1);
        reestablecer();
        
    }

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

    private void reestablecer() {
        accion = "insert";
        entradas = new EntradaDAO().entradas();
        if (!entradas.isEmpty()) {
            paginador = new Paginador<>(entradas, labels.get(6), rows);
        }
    }
    
    
}
