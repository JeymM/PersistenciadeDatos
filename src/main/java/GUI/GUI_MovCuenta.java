package GUI;

import java.util.Scanner;

import Entidades.CuentaAhorro;

public class GUI_MovCuenta {
	
	private boolean run=true;

	GUI_Cuenta op=new GUI_Cuenta();
	CuentaAhorro ahorro;
	 public void seleccionTipoCuenta() {
	        System.out.println("Bienvenido al sistema de persistencia de cuentas");

	        while (run) {
	            System.out.println("1. Cuenta Ahorro");
	            System.out.println("2. Cuenta Corriente ");
	            System.out.println("3. Salir");
	            Scanner scanner = new Scanner(System.in);
	            int opcion = scanner.nextInt();
	            seleccion(opcion);
	        }

	    }

	    private void seleccion(int seleccion) {
	        switch (seleccion) {
	            case 1:
	            	
	                op.iniciar();
	                break;
	            case 2:
	               op.iniciar();
	                break;
	            case 3:
	            	  salir();
		                break;
	            case 4:
	            	
	            default:
	                System.out.println("Opcion no valida");
	                break;
	        }
	    }

		private void salir() {
	        System.out.println("Salir");
	        run = false;
	    }

}
