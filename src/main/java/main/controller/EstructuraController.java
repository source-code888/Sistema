package main.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import main.view.Estructura;
import main.view.TablasBase;

public class EstructuraController extends MouseAdapter implements ActionListener {

    private Estructura estructura;
    private JMenu ajustes;
    private JMenu cerrar;

    public EstructuraController(Estructura estructura) {

        super();
        this.estructura = estructura;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source instanceof JMenuItem) {//Si es un JMenuItem entra aqui 
            //System.out.println("MENU ITEM");  VERIFICANDO QUE FUNCIONE
            if (((JMenuItem) source).getText().equals("Area")) {
                //POR HACER PROCEDIMIENTO PARA HACER EL INGESO, EDICION Y AJUSTES DE LAS AREAS
            }
            switch (((JMenuItem) source).getText()) {
                case "Areas":
                    //Areas
                    TablasBase tablaArea = new TablasBase("Area");
                    tablaArea.setLocationRelativeTo(estructura);
                    tablaArea.setResizable(false);
                    tablaArea.setVisible(true);
                    break;
                case "Clasificaciones":
                    //clasificacioes
                    TablasBase tablaBase = new TablasBase("Clasificacion");
                    tablaBase.setLocationRelativeTo(estructura);
                    tablaBase.setResizable(false);
                    tablaBase.setVisible(true);
                    break;
                case "Tiendas":
                    //Tiendas
                    TablasBase tablaTienda = new TablasBase("Tienda");
                    tablaTienda.setLocationRelativeTo(estructura);
                    tablaTienda.setResizable(false);
                    tablaTienda.setVisible(true);
                    break;
                case "Unidades":
                    //Unidad
                    TablasBase tablaUnidad = new TablasBase("Unidad");
                    tablaUnidad.setLocationRelativeTo(estructura);
                    tablaUnidad.setResizable(false);
                    tablaUnidad.setVisible(true);
                    break;
            }

        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Object source = e.getSource();//el objeto que fue clickeado
        if (source instanceof JMenu) {//si es un JMenu entra aqui
            if (((JMenu) source).getText().equals("Cerrar")) {
                //Le pregunta si esta seguro de cerrar con un JOption pane
                if (JOptionPane.showConfirmDialog(estructura, "¿Estas seguro de cerrar el programa?", "Aviso", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE) == 0) {
                    estructura.dispose();
                }
            }
        }
    }

}
