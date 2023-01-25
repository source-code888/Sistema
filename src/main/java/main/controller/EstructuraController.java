package main.controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import main.model.Usuario;
import main.view.Estructura;

public class EstructuraController extends MouseAdapter implements ActionListener {

    private Estructura estructura;
    private Usuario usuario;
    private Component seccionMateriales;
    private Component seccionEntradas;
    private Component seccionSalidas;
    private Component seccionEmpleados;
    private boolean administrador;
    private JTabbedPane tabbedPanePrincipal;

    public EstructuraController(Estructura estructura, Object object, JTabbedPane tabbedPanePrincipal) {
        super();
        this.estructura = estructura;
        this.tabbedPanePrincipal = tabbedPanePrincipal;
        if (object instanceof Usuario) {
            this.usuario = (Usuario) object;
        }
        administrador = usuario.isAdministrador();
        guardarPaneles();
        inicializarTabbedPane();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (administrador) {
            if (source instanceof JMenuItem) {//Si es un JMenuItem entra aqui 
                //System.out.println("MENU ITEM");  VERIFICANDO QUE FUNCIONE
                switch (((JMenuItem) source).getText()) {
                    case "Areas":
                        //Areas
                        tablaBase("Area");
                        break;
                    case "Clasificaciones":
                        //clasificacioes
                        tablaBase("Clasificacion");
                        break;
                    case "Tiendas":
                        //Tiendas
                        tablaBase("Tienda");
                        break;
                    case "Unidades":
                        //Unidad
                        tablaBase("Unidad");
                        break;
                }

            }
        }
    }

    public void tablaBase(String nombre) {
        JDialogController frame = new JDialogController(estructura, true, nombre);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Object source = e.getSource();//el objeto que fue clickeado
        if (source instanceof JMenu) {//si es un JMenu entra aqui
            if (((JMenu) source).getText().equals("Cerrar")) {
                //Le pregunta si esta seguro de cerrar con un JOption pane
                if (JOptionPane.showConfirmDialog(estructura, "¿Estas seguro de cerrar el programa?", "Aviso", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE) == 0) {
                    System.exit(0);
                }
            }
        }
    }

    private void inicializarTabbedPane() {
        if (administrador) {
            tabbedPanePrincipal.addTab("Materiales", seccionMateriales);
            tabbedPanePrincipal.addTab("Entradas", seccionEntradas);
            tabbedPanePrincipal.addTab("Salidas", seccionSalidas);
            tabbedPanePrincipal.addTab("Empleados", seccionEmpleados);
        } else {
            tabbedPanePrincipal.addTab("Entradas", seccionEntradas);
            tabbedPanePrincipal.addTab("Salidas", seccionSalidas);
        }
    }

    private void guardarPaneles() {
        seccionEmpleados = tabbedPanePrincipal.getComponent(tabbedPanePrincipal.getTabCount() - 1);
        seccionSalidas = tabbedPanePrincipal.getComponent(tabbedPanePrincipal.getTabCount() - 2);
        seccionEntradas = tabbedPanePrincipal.getComponent(tabbedPanePrincipal.getTabCount() - 3);
        seccionMateriales = tabbedPanePrincipal.getComponent(tabbedPanePrincipal.getTabCount() - 4);
        tabbedPanePrincipal.removeAll();
    }

}
