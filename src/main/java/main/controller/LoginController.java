package main.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.*;
import main.model.UsuarioDAO;
import main.view.Estructura;
import main.view.Login;

public class LoginController implements ActionListener, KeyListener, FocusListener {

    private Login login;
    private UsuarioDAO usuario;

    //ELEMENTOS VISIBLES EN EL JFRAME
    private JButton btnAceptar;
    private JTextField txtUsuario;
    private JPasswordField txtPassword;
    private List<JLabel> labels;

    public LoginController(Login login, JButton btnAceptar, JTextField txtUsuario, JPasswordField txtPassword, List<JLabel> labels) {
        super();
        this.login = login;
        this.btnAceptar = btnAceptar;
        this.txtUsuario = txtUsuario;
        this.txtPassword = txtPassword;
        this.labels = labels;
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
                    boolean existeUsuario = usuario.usuarios().stream().filter(
                            usuario -> usuario.getUsuario().equals(usuarioTxt)
                    //&& usuario.getPassword().equals(password)
                    ).collect(Collectors.toList()).size() == 1;
                    if (existeUsuario) {
                        //Quiere decir q el usuario existe
                        boolean contrasenaCorrecta = usuario.usuarios().stream().filter(
                                usuario -> usuario.getUsuario().equals(usuarioTxt)
                                        && usuario.getPassword().equals(password)
                        ).collect(Collectors.toList()).size() == 1;
                        if (contrasenaCorrecta) {
                            //La contraseña y el usuario corresponden a una cuenta
                            limpiarLoginText();
                            System.out.println("Inicio de sesion exitoso");
                            Estructura estructura = new Estructura();
                            System.out.println("kakaka");
                            estructura.setResizable(false);
                            estructura.setLocationRelativeTo(estructura);
                            estructura.setVisible(true);
                            login.dispose();
                        }else{
                            txtPassword.setText("");
                            labels.get(2).setVisible(true);
                            labels.get(2).setText("Contraseña incorrecta");
                            labels.get(2).setForeground(Color.red);
                        }
                    } else {
                        //El label mensaje
                        limpiarLoginText();
                        labels.get(2).setVisible(true);
                        labels.get(2).setText("El usuario no existe");
                        labels.get(2).setForeground(Color.red);
                        txtUsuario.requestFocus();
                    }
                }
            }
        }
    }

    private void limpiarLoginText() {
        txtUsuario.setText("");
        txtPassword.setText("");
    }

    @Override
    public void keyTyped(KeyEvent e) {
        Object obj = e.getSource();
        if (obj instanceof JPasswordField) {
            JPasswordField pwd = (JPasswordField) obj;
            if (pwd.equals(txtPassword)) {
                if (String.valueOf(txtPassword.getPassword()).length() > 8) {
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
                    labels.get(0).setForeground(Color.black);
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
                    labels.get(1).setForeground(Color.black);
                } else {
                    labels.get(1).setText("Ingresa tu contraseña");
                    labels.get(1).setForeground(Color.red);
                }
            }
            if (e.getKeyChar() == '\n') {
                actionPerformed(new ActionEvent(btnAceptar, 1001 , "Aceptar"));
                
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

}
