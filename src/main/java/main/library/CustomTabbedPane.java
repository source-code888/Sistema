package main.library;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JTabbedPane;

public class CustomTabbedPane extends JTabbedPane {

    private CustomTabbedPaneUI blackTabbedPaneUI;
    private final static Color FOREGROUND = new Color(0, 0, 0);
    private final static Color COLOR_SEL = Color.WHITE;
    private final static Color COLOR_UN_SEL = Color.LIGHT_GRAY;

    /**
     * Constructor por defecto.
     */
    public CustomTabbedPane() {
        this.setPreferredSize(new Dimension(500, 500));
        this.setForeground(FOREGROUND);
        blackTabbedPaneUI = new CustomTabbedPaneUI(COLOR_SEL, COLOR_UN_SEL);
        this.setUI(blackTabbedPaneUI);
        this.setFocusable(false);
        this.setVisible(true);
    }

    /**
     * Constructor para darle color personalizado.
     *
     * @param colorSel color de la seleccion
     * @param colorUnSel color de deseleccion
 * @param foreground color de la letra.
     */
    public CustomTabbedPane(Color colorSel, Color colorUnSel, Color foreground) {
        this.setPreferredSize(new Dimension(100, 100));
        this.setForeground(foreground);
        blackTabbedPaneUI = new CustomTabbedPaneUI(colorSel, colorUnSel);
        this.setUI(blackTabbedPaneUI);
        this.setFocusable(false);
        this.setVisible(true);
    }

    public void setTabSelectedColor(Color color) {
        blackTabbedPaneUI.colorSel = color;
        blackTabbedPaneUI.colorContentBorder = color;
    }

    public Color getTabSelectedColor() {
        return (blackTabbedPaneUI.colorSel == null) ? new Color(43, 87, 117) : blackTabbedPaneUI.colorSel;
    }

    public void setTabUnselectedColor(Color color) {
        blackTabbedPaneUI.colorUnSel = color;
    }

    public Color getTabUnselectedColor() {
        return (blackTabbedPaneUI.colorUnSel == null) ? new Color(48, 98, 130) : blackTabbedPaneUI.colorUnSel;
    }    
}
