package edu.konrad.bd;

import java.util.ArrayList;
import java.util.List;

import edu.konrad.modelo.Usuario;

public class BaseDatos {
	
	private static BaseDatos instancia;
	private List<Usuario> listaUsuarios;

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    	
	public BaseDatos() {
		listaUsuarios = new ArrayList<Usuario>();
		
		Usuario user1 = new Usuario("user1", "13579");
		Usuario user2 = new Usuario("user2", "24680");
		
		listaUsuarios.add(user1);
		listaUsuarios.add(user2);
	}
	
	public static BaseDatos getInstancia() {
		if(instancia == null) {
			instancia = new BaseDatos();
		}
		return instancia;
	}
	
	public List<Usuario> getListaUsuarios(){
		return listaUsuarios;
	}
    public void addUsuario(Usuario usuarioAgregar ) {
        this.listaUsuarios.add(usuarioAgregar);
        
    }
}
