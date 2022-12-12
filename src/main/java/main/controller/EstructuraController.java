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
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import main.view.Estructura;

/**
 *
 * @author heber
 */
public class EstructuraController implements ActionListener, MenuListener, MouseListener {
    
    private Estructura estructura;
    private JMenu ajustes;
    private JMenu cerrar;
    private JPopupMenu menuAjustes;

    public EstructuraController(Estructura estructura, JMenu ajustes, JMenu cerrar, JPopupMenu menuAjustes ) {
        
        super();
        this.estructura = estructura;
        this.ajustes = ajustes;
        this.cerrar = cerrar;
        this.menuAjustes = menuAjustes;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       Object source = e.getSource();
        System.out.println("hola");
        if (source instanceof JMenu) {
            System.out.println("sisisi");
            if (((JMenu) source).getText().equals("cerrar")) {
                estructura.dispose();
            }
        }
    }

    @Override
    public void menuSelected(MenuEvent e) {
        JMenu source = (JMenu) e.getSource();
        if (source.getText().equals("Ajustes")) {
            source.setComponentPopupMenu(menuAjustes);
        }
    }

    @Override
    public void menuDeselected(MenuEvent e) {
        
    }

    @Override
    public void menuCanceled(MenuEvent e) {
        //POR HACER
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Object source = e.getSource();
        if (source instanceof JMenu) {
            if (((JMenu) source).getText().equals("Cerrar")) {
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
