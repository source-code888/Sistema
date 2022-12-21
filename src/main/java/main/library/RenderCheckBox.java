/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.library;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class RenderCheckBox extends JCheckBox implements TableCellRenderer {
    
    private final JComponent component = new JCheckBox();
    private Color colorSel = new Color(0, 200, 0);
    private Color colorUnSel = new Color(204, 204, 204);

    public RenderCheckBox() {
        setOpaque(true);
    }
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        //obtiene valor boolean y coloca valor en el JCheckBox
        boolean b = ((Boolean) value).booleanValue();
        JCheckBox box = (JCheckBox) component;
        box.setSelected(b);
        if (box.isSelected()) {
            box.setBackground(colorSel);
        } else {
            box.setBackground(colorUnSel);
        }
        return ((JCheckBox) component);
    }
}
