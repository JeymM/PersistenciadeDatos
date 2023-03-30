package Entidades;

import java.util.List;

import Excepciones.Limites;
import Persistencia.CuentaBaseDatos;
import Persistencia.Repositorio;


public class CuentaCorriente extends Cuenta implements Movimientos {
	
	int numTransferen;
		
	private Repositorio repositorioCuenta;
	
	
	public CuentaCorriente(String numCuenta, float saldo, String nomPropietario,int tipoCuenta) {
		super(numCuenta, saldo, nomPropietario,tipoCuenta);
		repositorioCuenta = new CuentaBaseDatos();
	}
	
	

	public void Retirar(double valor) throws Limites {
		this.cantRetiros++;
		try {
			if (this.cantRetiros > 5) {
				throw new Limites("No puede realizar mas de cinco retiros");
			} else {
				if(valor<=this.saldo) {
				this.saldo -= valor;
				}else {
					throw new Limites("No se puede realizar el retiro,el valor excede su saldo");
				}
			}
		} catch (Limites e) {

			e.printStackTrace();
		}
		
	}

	public void Depositar(double valor) {
		if(valor>0) {
		System.out.println("Nuevo saldo: " + (this.saldo + valor) + "pesos");
		}else {
			throw new ArithmeticException("valor negativo");
		}
	}

	@Override
	public void Imprimir() {
		String mensaje = "Numero de Cuenta" + this.numCuenta + "Nombre del propietario" + this.nomPropietario
				+ "Saldo de su cuenta:" + this.saldo;
		System.out.println(mensaje);

	}

	@Override
	public void Transferir(String tipoCuenta, double valor) throws Limites {
		this.numTransferen++;
		if(tipoCuenta.equalsIgnoreCase("ahorro")) {
			if(this.numTransferen>2) {
				System.out.println("No tiene permitido realizar más transferencias");
			}else {
				//CuentaAhorro cuentaa=new CuentaAhorro();
				//cuentaa.Depositar(valor);
			}
		}else {
			this.Depositar(valor);
		}
		
	}

	



}
