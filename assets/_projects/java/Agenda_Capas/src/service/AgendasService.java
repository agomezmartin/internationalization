package service;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Locale;
import java.util.ResourceBundle;

public class AgendasService {

	/*
	 *					==========
	 * 					 Métodos
	 *					==========
	 */
	
	HashMap<String, String> agenda = new HashMap<>();
	

	// añadir contacto
	public boolean agregarContacto(String email, String nombre) {
		
		if(!agenda.containsKey(email)) {
			agenda.put(email, nombre);
			return true;
		}

		return false;
	}

	// eliminar contacto
	public boolean eliminarContacto(String email) {
		
		if(agenda.containsKey(email)) {
			agenda.remove(email);
			return true;
		}

		return false;
	}

	// buscar contacto
	public String buscarContacto(String email) {
		
		return agenda.get(email);
	}

	// mostrar todos los contactos
	public Collection<String> mostrarContactos() {
		
		return agenda.values();
	}


}