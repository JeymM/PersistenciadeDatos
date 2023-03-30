package Entidades;

import Excepciones.Limites;

public interface Movimientos {
	public abstract void Retirar(double valor) throws Limites;

	public abstract void Depositar(double valor);
	
	public abstract void  Transferir(String tipoCuenta,double valor) throws Limites; 
		
	
	
}
