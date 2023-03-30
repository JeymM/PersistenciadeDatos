package Entidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import Excepciones.Limites;
import Persistencia.CuentaBaseDatos;
import Persistencia.Repositorio;

public class CuentaAhorro extends Cuenta implements Movimientos {

	private Repositorio repositorioCuenta;
	
	
	public CuentaAhorro(String numCuenta, float saldo, String nomPropietario,int tipoCuenta) {
		super(numCuenta, saldo, nomPropietario,tipoCuenta);
		repositorioCuenta = new CuentaBaseDatos();
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
	public void Transferir(String tipoCuenta, double valor) {
		//CuentaCorriente cuentac=new CuentaCorriente();
		if(tipoCuenta=="Corriente") {
			double interes=(valor*0.015);
			valor+=interes;
			
			this.saldo-=valor;
			//cuentac.Depositar(valor);
			
		}else {
			this.Depositar(valor);
		}
		
	}

	


	

}
