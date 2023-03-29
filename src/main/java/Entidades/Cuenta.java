package Entidades;


	public abstract class Cuenta {

		double numCuenta;
		float saldo;
		String nomPropietario;
		String tipoCuenta;
		int cantDeposito = 0;
		int cantRetiros = 0;

		public Cuenta(double numCuenta, float saldo, String nomPropietario,String tipoCuenta) {
			super();
			this.numCuenta = numCuenta;
			this.saldo = saldo;
			this.nomPropietario = nomPropietario;
			this.tipoCuenta=tipoCuenta;

		}
		

		public double getNumCuenta() {
			return numCuenta;
		}


		public void setNumCuenta(double numCuenta) {
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
		

		public String getTipoCuenta() {
			return tipoCuenta;
		}


		public void setTipoCuenta(String tipoCuenta) {
			this.tipoCuenta = tipoCuenta;
		}
		public abstract void Imprimir();

	}



