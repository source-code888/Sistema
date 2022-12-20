package main.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import main.view.Estructura;

public class EstructuraController extends MouseAdapter implements ActionListener {

    private Estructura estructura;

    public EstructuraController(Estructura estructura) {

        super();
        this.estructura = estructura;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

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

}
