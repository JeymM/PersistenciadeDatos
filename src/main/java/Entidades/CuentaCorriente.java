package Entidades;

import java.util.List;

import Excepciones.Limites;
import Persistencia.CuentaBaseDatos;
import Persistencia.Repositorio;


public class CuentaCorriente extends Cuenta implements Movimientos {
		
	private Repositorio repositorioCuenta;
	
	public CuentaCorriente(double numCuenta, float saldo, String nomPropietario, String tipoCuenta) {
		super(numCuenta, saldo, nomPropietario, tipoCuenta);
		repositorioCuenta = new CuentaBaseDatos();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public void Retirar(double valor) throws Limites {
		this.cantRetiros++;
		try {
			if (this.cantRetiros > 5) {
				throw new Limites("No puede realizar mas de cinco retiros");
			} else {
				this.saldo -= valor;
			}
		} catch (Limites e) {

			e.printStackTrace();
		}
		
	}

	public void Depositar(double valor) {
		System.out.println("Nuevo saldo: " + (this.saldo + valor) + "pesos");
		
	}

	@Override
	public void Imprimir() {
		String mensaje = "Numero de Cuenta" + this.numCuenta + "Nombre del propietario" + this.nomPropietario
				+ "Saldo de su cuenta:" + this.saldo;
		System.out.println(mensaje);

	}

	



}
