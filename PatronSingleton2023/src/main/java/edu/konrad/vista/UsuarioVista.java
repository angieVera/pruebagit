package edu.konrad.vista;

import java.util.Scanner;

import edu.konrad.controlador.UsuarioLogica;
import edu.konrad.modelo.Usuario;

public class UsuarioVista {

    private static int opcion;
    private static Scanner sc = new Scanner(System.in);
    private Usuario user;
    private final UsuarioLogica logica = new UsuarioLogica();

    public void mostrarMenuPrincipal() {
        user = null;
        System.out.println("");
        System.out.println("----------------------------------------------");
        System.out.println("*** BIENVENIDO AL SISTEMA SINGLETON ***");
        System.out.println("Por favor ingresar una opción: ");
        System.out.println("1. Ingresar al sistema");
        System.out.println("2. Crear usuario");
        System.out.println("3. Salir de la aplicación");
        opcion = Integer.parseInt(sc.nextLine());
        switch (opcion) {
            case 1:
                if (logging()) {
                    while (true) {
                        mostrarMenuInterno();
                    }
                }
                break;
            case 2:
                crearUsuario();
                break;
            case 3:
                System.exit(0);
                break;

        }
    }

    public boolean logging() {
        System.out.println("");
        System.out.println("----------------------------------------------");
        System.out.println("Por favor ingresar usuario: ");
        String usuarioLeido = sc.nextLine();
        System.out.println("Por favor ingresar contrasena: ");
        String contrasenaLeida = sc.nextLine();
        String mensajeRespuesta = logica.autenticar(usuarioLeido, contrasenaLeida);

        System.out.println(mensajeRespuesta);
        if (mensajeRespuesta.equals("Autenticacion exitosa")) {
            user = new Usuario(usuarioLeido, contrasenaLeida);
            return true;
        }
        return false;
    }

    private void modificarUsuario() {
        System.out.println("");
        System.out.println("----------------------------------------------");
        System.out.println("Ingrese la opción del dato que desea modificar");
        System.out.println("1. Cambiar contraseña");
        System.out.println("2. Cambiar usuario");
        System.out.println("3. Volver al menú de opciones");
        int op = Integer.parseInt(sc.nextLine());
        String cambio;
        Usuario antiguoUser = new Usuario(user.getUsuario(),user.getContrasena());
        System.out.println("");
        System.out.println("----------------------------------------------");
        switch (op) {
            case 1:
                System.out.println("Ingrese la nueva contraseña");
                cambio = sc.nextLine();
                user.setContrasena(cambio);
                System.out.println(logica.actualizar(antiguoUser, user));
                break;
            case 2:
                System.out.println("Ingrese el nuevo nombre de usuario");
                cambio = sc.nextLine();
                user.setUsuario(cambio);
                System.out.println(logica.actualizar(antiguoUser, user));
                break;
            case 3:
                mostrarMenuInterno();
                break;
        }
    }

    //se crea el metodo crear usuario...
    private void crearUsuario() {
        System.out.println("");
        System.out.println("----------------------------------------------");
        System.out.println("Ingrese el nombre del nuevo usuario");
        String nuevoUsuario = sc.nextLine();
        System.out.println("Ingrese la contraseña del nuevo usuario");
        String nuevaContrasena = sc.nextLine();
        Usuario nuevoUser = new Usuario(nuevoUsuario, nuevaContrasena);
        System.out.println(logica.crear(nuevoUser));
}
    
    

    private void eliminarUsuario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void mostrarMenuInterno() {
        System.out.println("");
        System.out.println("----------------------------------------------");
        System.out.println("Elija una opción:");
        System.out.println("1. Crear usuario:");
        System.out.println("2. Modificar usuario");
        
        System.out.println("3. Eliminar usuario");
        
        System.out.println("4. Cerrar sesión");
        int op = Integer.parseInt(sc.nextLine());
        switch (op) {
            case 1:
               crearUsuario();
                break;
            case 2:
                modificarUsuario();
                break;
            case 3:
                eliminarUsuario();
                break;
            case 4:
                mostrarMenuPrincipal();
                System.out.println("ha cerrado sesión de forma correcta");
        }
    }

}
