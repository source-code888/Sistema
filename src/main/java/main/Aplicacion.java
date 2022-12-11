package main;

import main.view.Login;

public class Aplicacion {

    public static void main(String[] args) {
       //FUNCIONA
       //Hola
       Login l = new Login();
       l.setResizable(false);
       l.setLocationRelativeTo(l);
       l.setVisible(true);
    }
}
