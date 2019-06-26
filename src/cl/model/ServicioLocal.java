package cl.model;

import java.util.ArrayList;

import javax.ejb.Local;

/**
 * 
 *@author Paulina
 *@version 20-06-2019 v0.1
 */

@Local
public interface ServicioLocal {
	void addCliente(Cliente cli);
	ArrayList <Cliente> getClientes();
	Cliente getClienteByRut(String rut); 
	String eliminar (String rut);
	
	void actualizar(Cliente cli);
}
