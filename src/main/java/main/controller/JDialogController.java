/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.controller;

import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import main.view.Estructura;
import main.view.TablasBase;

public class JDialogController extends JDialog implements ActionListener, MouseMotionListener, MouseListener {

    private Estructura estructura;
    private boolean modal;
    private JButton boton;
    private int xMouse;
    private int yMouse;

    public JDialogController(Estructura estructura, boolean modal, String nombre) {
        super(estructura, modal);
        this.setUndecorated(true);
        TablasBase tablaBase = new TablasBase(nombre);
        this.getContentPane().add(tablaBase.getComponent(0));
        boton = (JButton) ((JPanel) (((JPanel) ((JLayeredPane) (((JRootPane) (this.getContentPane().getComponent(0))).getComponent(1))).getComponent(0)).getComponent(2))).getComponent(0);
        boton.addActionListener(this);
        this.pack();
        this.setLocationRelativeTo(estructura);
        this.getContentPane().addMouseMotionListener(this);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            if (e.getSource().equals(boton)) {
                this.dispose();
            }
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        int x = e.getXOnScreen();
        int y = e.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        xMouse = e.getX();
        yMouse = e.getY();
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
