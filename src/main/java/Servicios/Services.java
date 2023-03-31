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
	

	public void Guardar(Object object) {
		   repositorioCuenta.Guardar(object);
		
	}
	
	  public  Cuenta  Buscar ( String  numeroDeCuenta ){
	        return ( Cuenta ) repositorioCuenta . Buscar ( numeroDeCuenta );
	    }
	
	
	
	 public void actualizarSaldo(String numCuenta, float saldoConsignación){
	        repositorioCuenta.actualizar(numCuenta, saldoConsignación);
	    }	
	
	
	
}
