package Persistencia;

import java.util.List;

public interface  Repositorio {
	
	public void Guardar(Object objeto);
	public Object Buscar(String numCuenta);
	public List<?>Listar();

}
