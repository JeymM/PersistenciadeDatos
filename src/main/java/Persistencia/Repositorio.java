package Persistencia;

import java.util.List;

import Entidades.Cuenta;
import Excepciones.Limites;

public interface  Repositorio {
	
	public void Guardar(Cuenta cuenta);
	public Object Buscar(String numCuenta);
	
	
	///////////////////////////////////////7
	
	

}
