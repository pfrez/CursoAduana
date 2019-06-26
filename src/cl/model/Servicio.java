package cl.model;

import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;

/**
 * Session Bean implementation class Servicio
 */
@Singleton
@LocalBean
public class Servicio implements ServicioLocal {

	private ArrayList<Cliente> lista =new  ArrayList();
    /**
     * Default constructor. 
     */
    public Servicio() {
    	lista.add(new Cliente("Juan", "Perez", "1-1"));
    	lista.add(new Cliente("Diego", "Fuentes", "2-0"));
    }

	@Override
	public void addCliente(Cliente cli) {
		lista.add(cli);
		
	}

	@Override
	public ArrayList<Cliente> getClientes() {
		
		return lista;
	} 
	

	@Override
	public Cliente getClienteByRut(String rut) {
		for(Cliente cli :lista){
			if(cli.getRut().equals(rut))
				return cli;
		}
		return null;
	} 
	
	@Override
	public String eliminar(String rut) {
		Cliente cli = getClienteByRut(rut);
		if(cli == null){
			return "rut no encontrado";
		}else{
			lista.remove(cli);
			return "Cliente eliminado";
		}
			
	}

	@Override
	public void actualizar(Cliente cli) {
		Cliente cliente = getClienteByRut(cli.getRut());
		lista.remove(cliente);
		lista.add(cli);
	}
}
