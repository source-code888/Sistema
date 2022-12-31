package main.controller;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.*;
import main.model.UsuarioDAO;
import main.view.Estructura;
import main.view.Login;

public class LoginController extends MouseAdapter implements ActionListener, KeyListener, FocusListener {

    private Login login;
    private UsuarioDAO usuario;

    //ELEMENTOS VISIBLES EN EL JFRAME
    private JButton btnAceptar;
    private JButton btnClose;
    private JTextField txtUsuario;
    private JPasswordField txtPassword;
    private List<JLabel> labels;
    private JPanel header;
    private int xMouse;
    private int yMouse;
    private Estructura estructura = new Estructura();
    private JButton btnMinimizar;

    public LoginController(Login login, JButton btnAceptar, JButton btnClose, JButton btnMinimizar, JTextField txtUsuario, JPasswordField txtPassword, List<JLabel> labels, JPanel header) {
        super();
        this.login = login;
        this.btnAceptar = btnAceptar;
        this.btnClose = btnClose;
        this.btnMinimizar = btnMinimizar;
        this.txtUsuario = txtUsuario;
        this.txtPassword = txtPassword;
        this.labels = labels;
        this.header = header;
        usuario = new UsuarioDAO();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj instanceof JButton) {
            JButton btn = (JButton) obj;
            if (btn.getText().equals("Aceptar")) {
                //System.out.println(e.getActionCommand() + " \\\\ " + e.getID());
                if (String.valueOf(txtPassword.getPassword()).isBlank() && txtUsuario.getText().isBlank()) {
                    labels.get(0).setText("Ingresa tu nombre de usuario");
                    labels.get(0).setForeground(Color.red);
                    labels.get(1).setText("Ingresa tu contraseña");
                    labels.get(1).setForeground(Color.red);
                    txtUsuario.requestFocus();
                } else if (String.valueOf(txtPassword.getPassword()).isBlank()) {
                    labels.get(1).setText("Ingresa tu contraseña");
                    labels.get(1).setForeground(Color.red);
                    txtPassword.requestFocus();
                } else if (txtUsuario.getText().isBlank()) {
                    labels.get(0).setText("Ingresa tu nombre de usuario");
                    labels.get(0).setForeground(Color.red);
                    txtUsuario.requestFocus();
                } else {
                    String password = String.valueOf(txtPassword.getPassword());
                    String usuarioTxt = txtUsuario.getText();
                    var existeUsuario = usuario.usuarios().stream().filter(
                            usuario -> usuario.getUsuario().equals(usuarioTxt)
                    ).collect(Collectors.toList());
                    if (existeUsuario.size() == 1) {
                        boolean aprobado = existeUsuario.stream().filter(
                                usuario -> usuario.getUsuario().equals(usuarioTxt)
                                && usuario.getPassword().equals(password)
                        ).collect(Collectors.toList()).size() == 1;
                        if (aprobado) {
                            //La contraseña y el usuario corresponden a una cuenta
                            limpiarLoginText();
                            //System.out.println("Inicio de sesion exitoso");
                            long timeInit = System.currentTimeMillis();
                            //Estructura estructura = new Estructura(existeUsuario.get(0));
                            estructura.iniciaSesion(existeUsuario.get(0));
                            System.out.println( "Tiempo de Estructura: " + ((Double.valueOf(String.valueOf(( System.currentTimeMillis() - timeInit))))/1000) + " segundos");
                            estructura.setVisible(true);
                            //estructura.setLocationRelativeTo(estructura);
                            estructura.setExtendedState(Frame.MAXIMIZED_BOTH);
                            
                            login.dispose();
                            
                        } else {
                            limpiarLoginText();
                            labels.get(2).setText("Contraseña incorrecta");
                            labels.get(2).setVisible(true);
                            labels.get(2).setForeground(Color.red);
                            txtUsuario.requestFocus();
                        }
                    } else {
                        //El label mensaje
                        limpiarLoginText();
                        labels.get(2).setText("El usuario no existe");
                        labels.get(2).setVisible(true);
                        labels.get(2).setForeground(Color.red);
                        txtUsuario.requestFocus();
                    }
                }
            }
            if (btn.equals(btnClose)) {
                System.exit(0);
            }
            if (btn.equals(btnMinimizar)) {
                login.setExtendedState(JFrame.ICONIFIED);
            }
        }
    }

    private void limpiarLoginText() {
        txtUsuario.setText("");
        txtPassword.setText("");
        usuario = new UsuarioDAO();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        Object obj = e.getSource();
        if (obj instanceof JPasswordField) {
            JPasswordField pwd = (JPasswordField) obj;
            if (pwd.equals(txtPassword)) {
                if (String.valueOf(txtPassword.getPassword()).length() > 7) {
                    e.consume();
                }
            }

        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        Object obj = e.getSource();
        if (obj instanceof JTextField) {
            JTextField txt = (JTextField) obj;
            if (txt.equals(txtUsuario)) {
                if (!txtUsuario.getText().isBlank()) {
                    if (!labels.get(2).getText().equals("")) {
                        labels.get(2).setText("");
                        labels.get(2).setVisible(false);
                    }
                    labels.get(0).setText("Usuario");
                    labels.get(0).setForeground(new Color(102, 102, 102));
                } else {
                    labels.get(0).setText("Ingresa tu nombre de usuario");
                    labels.get(0).setForeground(Color.red);
                }
                if (e.getKeyChar() == '\n') {
                    txtPassword.requestFocus();
                }

            }
        }
        if (obj instanceof JPasswordField) {
            JPasswordField pwd = (JPasswordField) obj;

            if (pwd.equals(txtPassword)) {
                if (!String.valueOf(txtPassword.getPassword()).isBlank()) {
                    labels.get(1).setText("Contraseña");
                    labels.get(1).setForeground(new Color(102, 102, 102));
                } else {
                    labels.get(1).setText("Ingresa tu contraseña");
                    labels.get(1).setForeground(Color.red);
                }
            }
            if (e.getKeyChar() == '\n') {
                actionPerformed(new ActionEvent(btnAceptar, 1001, "Aceptar"));

            }
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
    }

    @Override
    public void focusLost(FocusEvent e) {
        Object obj = e.getSource();
        if (obj instanceof JTextField) {
            JTextField txt = (JTextField) obj;
            if (txt.equals(txtUsuario)) {
                if (txtUsuario.getText().isBlank()) {
                    labels.get(0).setText("Ingresa tu nombre de usuario");
                    labels.get(0).setForeground(Color.red);
                }
            }
        }
        if (obj instanceof JPasswordField) {
            JPasswordField pwd = (JPasswordField) obj;
            if (pwd.equals(txtPassword)) {
                if (String.valueOf(txtPassword.getPassword()).isBlank()) {
                    labels.get(1).setText("Ingresa tu contraseña");
                    labels.get(1).setForeground(Color.red);
                }
            }
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Object obj = e.getSource();
        if (obj instanceof JPanel) {
            JPanel panel = (JPanel) obj;
            if (panel.equals(header)) {
                int x = e.getXOnScreen();
                int y = e.getYOnScreen();
                login.setLocation(x - xMouse, y - yMouse);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Object obj = e.getSource();
        if (obj instanceof JPanel) {
            JPanel panel = (JPanel) obj;
            if (panel.equals(header)) {
                xMouse = e.getX();
                yMouse = e.getY();
            }
        }
    }
}
