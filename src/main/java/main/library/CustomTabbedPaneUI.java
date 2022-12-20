package main.library;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import static javax.swing.SwingConstants.BOTTOM;
import static javax.swing.SwingConstants.LEFT;
import static javax.swing.SwingConstants.RIGHT;
import static javax.swing.SwingConstants.TOP;
import javax.swing.plaf.basic.BasicTabbedPaneUI;

public class CustomTabbedPaneUI extends BasicTabbedPaneUI{
    public Color colorSel;
    public Color colorUnSel;
    public Color colorContentBorder = colorSel;

    public CustomTabbedPaneUI(Color colorSel, Color colorUnSel) {
        this.colorSel = colorSel;
        this.colorUnSel = colorUnSel;
    }

    public CustomTabbedPaneUI() {

    }

    @Override
    protected void paintTabBackground(Graphics g, int tabPlacement, int tabIndex, int x, int y, int w, int h, boolean isSelected) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor((isSelected) ? colorSel : colorUnSel);
        g2.fillRect(rects[tabIndex].x, rects[tabIndex].y,
                rects[tabIndex].width, rects[tabIndex].height);
    }

    @Override
    protected void paintTabBorder(Graphics g, int tabPlacement, int tabIndex, int x, int y, int w, int h, boolean isSelected) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor((isSelected) ? colorUnSel : colorSel);
        g2.drawRect(x, y, w, h);
    }

    @Override
    protected void paintContentBorder(Graphics g, int tabPlacement, int selectedIndex) {
        int width = tabPane.getWidth();
        int height = tabPane.getHeight();
        Insets insets = tabPane.getInsets();

        int x = insets.left;
        int y = insets.top;
        int w = width - insets.right - insets.left;
        int h = height - insets.top - insets.bottom;

        switch (tabPlacement) {
            case LEFT:
                x += calculateTabAreaWidth(tabPlacement, runCount, maxTabWidth);
                x -= tabAreaInsets.right;
                w -= (x - insets.left);
                break;
            case RIGHT:
                w -= calculateTabAreaWidth(tabPlacement, runCount, maxTabWidth);
                w += tabAreaInsets.left;
                break;
            case BOTTOM:
                h -= calculateTabAreaHeight(tabPlacement, runCount, maxTabHeight);
                h += tabAreaInsets.top;
                break;
            case TOP:
            default:
                y += calculateTabAreaHeight(tabPlacement, runCount, maxTabHeight);
                y -= tabAreaInsets.bottom;
                h -= (y - insets.top);
        }

        if (tabPane.getTabCount() > 0) {
            Color color = colorSel;
            if (color != null) {
                g.setColor(color);
            } else if (colorContentBorder == null || selectedIndex == -1) {
                g.setColor(tabPane.getBackground());
            } else {
                g.setColor(colorContentBorder);
            }
            g.fillRect(x, y, w, h);
        }
    }
}
