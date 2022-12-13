/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import main.view.TablasBase;

/**
 *
 * @author heber
 */
public class TablasBaseController implements ActionListener{

    TablasBase tablaBase;

    public TablasBaseController(TablasBase tablaBase) {
        this.tablaBase = tablaBase;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}
