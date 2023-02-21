package edu.konrad.controlador;

import edu.konrad.dao.UsuarioDAO;
import edu.konrad.modelo.Usuario;

public class UsuarioLogica {

    private UsuarioDAO dao = new UsuarioDAO();

    public String autenticar(String user, String pwd) {
        Usuario usuario = new Usuario(user, pwd);

        boolean respuesta = dao.readUsuario(usuario);

        if (respuesta) {
            return "Autenticacion exitosa";
        }
        return "Credenciales incorrectas";
    }

    public String actualizar(Usuario oldUser, Usuario newUser) {
        boolean respuesta = dao.updateUsuario(oldUser, newUser);
        if (respuesta) {
            return "El cambio se aplicó correctamente";
        }
        return "El cambio no se aplicó correctamente";

    }
//Se realiza el codigo de crear usuario

    public String crear(Usuario nuevoUser) {
        boolean respuesta = dao.createUsuario(nuevoUser);
        if (respuesta) {
            return "Se agrego correctamente";
        }
        return "No se creo";
    }

}
