package Persistencia;

import java.util.List;

import Entidades.Cuenta;
import Excepciones.Limites;

public interface  Repositorio {
	
	public void Guardar(Object object);
	public Object Buscar(String numCuenta);
	  public void actualizar(String numeroDeCuenta, float saldo);
	
	///////////////////////////////////////7
	
	

}
