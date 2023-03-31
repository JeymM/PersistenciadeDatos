package Entidades;

import java.util.ArrayList;

import Excepciones.Limites;

public interface Movimientos {
	public abstract void Retirar(double valor) throws Limites;

	public abstract void Depositar(double valor);
	
	public abstract Cuenta[]  transferirDinero ( Cuenta cuentaO , Cuenta  cuentaD , float transferencia)  throws Limites; 
	
	
	
}
