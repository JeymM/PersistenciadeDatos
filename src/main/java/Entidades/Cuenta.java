package Entidades;

public class Cuenta {

	String  numCuenta;
	float saldo;
	String nomPropietario;
	int tipoCuenta=0;

	// atributos usados como acumulador de deposito y retiro
	int cantDeposito = 0;
	int cantRetiros = 0;

	public Cuenta(String numCuenta, float saldo, String nomPropietario,int tipoCuenta) {
		super();
		this.numCuenta = numCuenta;
		this.saldo = saldo;
		this.nomPropietario = nomPropietario;
		this.tipoCuenta=tipoCuenta;

	}
	

	public Cuenta() {
		// TODO Auto-generated constructor stub
	}
	

	public int getTipoCuenta() {
		return tipoCuenta;
	}


	public void setTipoCuenta(int tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}


	public String getNumCuenta() {
		return numCuenta;
	}

	public void setNumCuenta(String  numCuenta) {
		this.numCuenta = numCuenta;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public String getNomPropietario() {
		return nomPropietario;
	}

	public void setNomPropietario(String nomPropietario) {
		this.nomPropietario = nomPropietario;
	}

	public int getCantDeposito() {
		return cantDeposito;
	}

	public void setCantDeposito(int cantDeposito) {
		this.cantDeposito = cantDeposito;
	}

	public int getCantRetiros() {
		return cantRetiros;
	}

	public void setCantRetiros(int cantRetiros) {
		this.cantRetiros = cantRetiros;
	}

	public void Imprimir() {
		String mensaje = "Numero de Cuenta" + this.numCuenta + "Nombre del propietario" + this.nomPropietario
				+ "Saldo de su cuenta:" + this.saldo;
		System.out.println(mensaje);
	}

}
