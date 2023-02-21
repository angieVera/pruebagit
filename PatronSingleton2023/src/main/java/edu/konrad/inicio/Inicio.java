package edu.konrad.inicio;

import edu.konrad.vista.UsuarioVista;

public class Inicio {

    public static void main(String[] args) {

        UsuarioVista vista = new UsuarioVista();
        while (true) {
            vista.mostrarMenuPrincipal();
        }
    }

}
