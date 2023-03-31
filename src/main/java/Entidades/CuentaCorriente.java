package Entidades;

import java.util.ArrayList;
import java.util.List;

import Excepciones.Limites;
import Persistencia.CuentaBaseDatos;
import Persistencia.Repositorio;
import Servicios.Services;


public class CuentaCorriente extends Cuenta implements Movimientos {
	
	int numTransferen;
		
	private Repositorio repositorioCuenta;
	private Services services;
	
	
	public CuentaCorriente(String numCuenta, float saldo, String nomPropietario,String tipoCuenta) {
		super(numCuenta, saldo, nomPropietario,tipoCuenta);
		repositorioCuenta = new CuentaBaseDatos();
		services =new Services();
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
	public Cuenta[] transferirDinero(Cuenta cuentaO, Cuenta cuentaD, float transferencia) throws Limites{
        double cobroAdicional = 0, cantidadRealARestar =transferencia;
        CuentaCorriente corriente;
        if(cuentaO.getTipoCuenta() != cuentaD.getTipoCuenta()){
            cobroAdicional += (transferencia*2)/100;
            transferencia += cobroAdicional;
           
        }
        if(cantidadRealARestar > cuentaO.getSaldo()){
            System.out.println("No se puede realziar la operación, porque la cantida a transferir es mayor al saldo de la cuenta");
        } else {
        	if(this.numTransferen<2) {
        		((Movimientos) cuentaO).Retirar(transferencia);
                ((Movimientos) cuentaD).Depositar(transferencia);
        	}
        }
        	
        Cuenta[] cuentasBancaria = new Cuenta[]{
                cuentaO, cuentaD
               
        }; return cuentasBancaria;
        }
        
	
				
			
			
			
}
