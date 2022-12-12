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
                if (String.valueOf(txtPassword.getPassword()).isBlank() && txtUsuario.getText().isBlank()) {
                    labels.get(0).setText("Ingresa tu nombre de usuario");
                    labels.get(0).setForeground(Color.red);
                    labels.get(1).setText("Ingresa tu contraseña");
                    labels.get(1).setForeground(Color.red);
                    txtUsuario.requestFocus();
                } else if (String.valueOf(txtPassword.getPassword()).isBlank()) {
                    labels.get(1).setText("Ingresa tu ncontraseña");
                    labels.get(1).setForeground(Color.red);
                    txtPassword.requestFocus();
                } else if (txtUsuario.getText().isBlank()) {
                    labels.get(0).setText("Ingresa tu nombre de usuario");
                    labels.get(0).setForeground(Color.red);
                    txtUsuario.requestFocus();
                } else {
                    String password = String.valueOf(txtPassword.getPassword());
                    String usuarioTxt = txtUsuario.getText();
                    int count = usuario.usuarios().stream().filter(
                            usuario -> usuario.getUsuario().equals(usuarioTxt)
                            && usuario.getPassword().equals(password)
                    ).collect(Collectors.toList()).size();
                    if (count == 1) {
                        //Quiere decir q el usuario existe
                        txtUsuario.setText("");
                        txtPassword.setText("");
                        //Lo que vayamos a implementar
                    } else {
                        //El label mensaje
                        txtUsuario.setText("");
                        txtPassword.setText("");
                        labels.get(2).setVisible(true);
                        labels.get(2).setText("Usuario no encontrado");
                        labels.get(2).setForeground(Color.red);
                        txtUsuario.requestFocus();
                    }
                }
            }
        }
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
