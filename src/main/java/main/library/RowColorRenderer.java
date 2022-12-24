/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.library;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author heber
 */
public class RowColorRenderer extends JLabel implements TableCellRenderer {

    private int index;

    public RowColorRenderer(int index) {
        setOpaque(true);
        this.index = index;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table,
            Object value, boolean isSelected, boolean hasFocus,
            int row, int column) {

        // Establece el color de fondo de la fila en función del valor de la celda
        int actual;
        int limiteMinimo;
        
        try {
            actual = (int) value;
            limiteMinimo = (int) table.getValueAt(index, 3);
        } catch (Exception e) {
            actual = 1;
            limiteMinimo = 0;
        }

        if (actual <= limiteMinimo) {
            setBackground(Color.RED);
        } else {
            setBackground(Color.WHITE);
        }

        return this;
    }

}
