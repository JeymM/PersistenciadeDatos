package Servicios;

import java.util.List;

import Entidades.Cuenta;
import Persistencia.CuentaBaseDatos;
import Persistencia.Repositorio;

public class Services {
	private Repositorio repositorioCuenta;

	 public Services() {
	      repositorioCuenta =new CuentaBaseDatos();  
	   
	}
	
	public List<?> Listar() {
		// TODO Auto-generated method stub
		return null;
	}
	

	public void Guardar(Cuenta cuenta) {
		   repositorioCuenta.Guardar(cuenta);
		
	}
	

	public Object Buscar(String numCuenta) {
		Object cuenta = repositorioCuenta.Buscar(numCuenta);
        if(cuenta == null) {
            System.out.println("No se encontro la cuenta");
        }
        return (Cuenta) cuenta;
	}
		
	
	
	
}
