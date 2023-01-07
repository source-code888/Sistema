package main.library;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JLabel;
import javax.swing.JTextField;
import main.model.*;

public class EventoComun {

    public static final Color COLOR_BASE = new Color(0, 153, 51);
    public static final Color COLOR_TEXTO = new Color(0, 0, 0);

    public void textKeyPressed(KeyEvent evt) {
        char caracter = evt.getKeyChar();
        if ((caracter < 'a' || caracter > 'z') && (caracter < 'A' || caracter > 'Z')
                && (caracter != (char) KeyEvent.VK_BACK_SPACE) && (caracter != (char) KeyEvent.VK_SPACE)) {
            evt.consume();
        }
    }

    // Por si se llegan a ocupar
    public void mayusculasKeyPressed(KeyEvent evt) {
    }

    public void minusculasKeyPressed(KeyEvent evt) {

    }

    //
    public void numberKeyPressed(KeyEvent evt) {
        char caracter = evt.getKeyChar();
        if ((caracter < '0' || caracter > '9') && (caracter != (char) KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
        }
    }

    public boolean isEmail(String email) {
        Pattern patt = Pattern.compile("^[\\w\\-\\_\\+]+(\\.[\\w\\-\\_]+)*@([A-Za-z0-9-]+\\.)+[A-Za-z]{2,4}$");
        Matcher matc = patt.matcher(email);
        return matc.find();
    }

    /**
     * Remarcar un label especificado del color seleccionado.
     *
     * @param label label que se desea remarcar
     * @param string cadena que se desea mostrar
     * @param color color del texto
     */
    public void remarcarLabel(JLabel label, String string, Color color) {
        label.setText(string);
        label.setForeground(color);
    }

    public static boolean existente(boolean skip, Object[] elements, Object element, JTextField request) {
        if (elements == null || element == null) {
            throw new IllegalArgumentException("Argumentos invalidos.");
        }
        if (elements[0] instanceof Material) {
            List<Material> materiales = new ArrayList<>();
            Material material = (Material) element;
            for (Object obj : elements) {
                materiales.add((Material) obj);
            }
            for (Material mat : materiales) {
                if (skip) {
                    if (mat.getIdMaterial() != material.getIdMaterial()) {
                        if (mat.getSku().equals(material.getSku())) {
                            return true;
                        }
                    }
                    continue;
                } else {
                    if (mat.getSku().equals(material.getSku())) {
                        return true;
                    }
                }
            }

        }
        return false;
    }

    public static String getFecha() {
        String strFormat = "yyyy/MM/dd - hh: mm: ss a";
        SimpleDateFormat dateFormat = new SimpleDateFormat(strFormat);
        Date fecha = new Date();
        return dateFormat.format(fecha).toString();
    }

    public static Calendar establecerFecha(String fechCompleta) {
        String subCad = fechCompleta.substring(0, 8);
        /*int dia = Integer.parseInt(subCad.substring(0, 2));
        int mes = Integer.parseInt(subCad.substring(3, 5));
        int anio = Integer.parseInt(subCad.substring(6, 8));*/
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        Calendar calendar = Calendar.getInstance();
        try {
            var date = format.parse(subCad);
            calendar.setTime(date);
        } catch (ParseException e) {
            e.printStackTrace(System.out);
        }
        return calendar;
    }

    public static Calendar establecerFecha() {
        return new GregorianCalendar();
    }
    
    public static String establecerHora(String fechaCompleta){
        return fechaCompleta.substring(11, fechaCompleta.length());
    }
}
