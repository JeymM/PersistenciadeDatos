package Entidades;

import java.util.List;

import Excepciones.Limites;
import Persistencia.CuentaBaseDatos;
import Persistencia.Repositorio;

public class CuentaAhorro extends Cuenta implements Movimientos{

	private Repositorio repositorioCuenta;
	
	
	public CuentaAhorro(double numCuenta, float saldo, String nomPropietario, String tipoCuenta) {
		super(numCuenta, saldo, nomPropietario, tipoCuenta);
		repositorioCuenta = new CuentaBaseDatos();
	}
	
	
	  public void guardarCuenta(CuentaAhorro ahorro) {
		   repositorioCuenta.Guardar(ahorro);
		   
	   }
	  
	  
	  
	  
	  
	  
	public void Retirar(double valor) throws Limites {
		this.cantRetiros++;
		if (this.cantRetiros > 3) {
			if (this.saldo >= valor) {
				double interes = (valor * 1) / 100;

				valor += interes;
				System.out.println("Ha retirado:" + valor);
			     System.out.println(this.saldo -= valor);
			}else {
				this.saldo-=valor;
			}
		}

		
	}

	public void Depositar(double valor) {
		if (this.cantDeposito < 2) {
			double incremento = (valor * 0.05);
			valor += incremento;
			System.out.println("Incremento es :" + incremento);
			System.out.println("Nuevo saldo: " + (this.saldo + valor) + "pesos");
		} else {
			System.out.println("Nuevo saldo: " + (this.saldo + valor) + "pesos");
		}
		this.cantDeposito++;

		
	}

	@Override
	public void Imprimir() {
		
		
	}


	

}
