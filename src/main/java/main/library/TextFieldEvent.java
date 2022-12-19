package main.library;

import java.awt.event.KeyEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextFieldEvent {

    public void textKeyPressed(KeyEvent evt) {
        char caracter = evt.getKeyChar();
        if ((caracter < 'a' || caracter > 'z') && (caracter < 'A' || caracter > 'Z')
                && (caracter != (char) KeyEvent.VK_BACK_SPACE) && (caracter != (char) KeyEvent.VK_SPACE)) {
            evt.consume();
        }
    }

    //Por si se llegan a ocupar
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

}
