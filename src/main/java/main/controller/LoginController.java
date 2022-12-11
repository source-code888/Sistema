package main.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import main.model.EmpleadoDAO;
import main.model.UsuarioDAO;
import main.view.Login;

public class LoginController implements ActionListener {

    private Login login;
    private JButton btnAceptar;
    private UsuarioDAO usuario;
    private EmpleadoDAO empleado;
    public LoginController(Login login, JButton btnAceptar) {
        super();
        this.login = login;
        this.btnAceptar = btnAceptar;
        usuario = new UsuarioDAO();
        empleado = new EmpleadoDAO();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if(obj instanceof JButton){
            JButton btn = (JButton) obj;
            if(btn.getText().equals("Aceptar")){
                System.out.println(usuario.usuarios().get(0));
                System.out.println(empleado.empleados().get(0));
            }
        }
    }

}
