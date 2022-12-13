/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import main.view.Estructura;
import main.view.TablasBase;

/**
 *
 * @author heber
 */
public class EstructuraController implements ActionListener, MouseListener {
    
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
            switch (((JMenuItem) source).getText()){
                case "Areas":
                    System.out.println("AREA");
                    TablasBase tablaArea = new TablasBase();
                    tablaArea.setLocationRelativeTo(estructura);
                    tablaArea.setResizable(false);
                    tablaArea.setVisible(true);
                    break;
                case "Clasificaciones":
                    System.out.println("CLASIFICACIONES");
                    //FALTA HACER EL INGRESO DE TODAS ESTAS A LA BASE DE DATOS
                    //HACER VISTA
                    break;
                case "Tiendas":
                    System.out.println("TIENDAS");
                    //FALTA HACER EL INGRESO DE TODAS ESTAS A LA BASE DE DATOS
                    //HACER VISTA
                    break;
                case "Unidades":
                    System.out.println("UNIDADES");
                    //FALTA HACER EL INGRESO DE TODAS ESTAS A LA BASE DE DATOS
                    //HACER VISTA
                    break;
                default:
                    System.out.println(((JMenuItem) source).getText());
                    
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
    
    
    
}
