package GUI;

import java.util.List;
import java.util.Scanner;

import Entidades.Cuenta;
//import Entidades.CuentaAhorro;
import Entidades.CuentaCorriente;
import Entidades.Movimientos;
import Servicios.Services;
import Entidades.CuentaAhorro;

public class GUI_Cuenta {
	private boolean run=true;
	
	private Services services;
	
	
	public GUI_Cuenta() {
	
		services= new Services();
	}
	
	 public void iniciar() {
	        System.out.println("Bienvenido al sistema de persistencia de cuentas");

	        while (run) {
	            System.out.println("1. Crear cuenta");
	            System.out.println("2. Listar cuenta");
	            System.out.println("3. Buscar cuenta");
	            System.out.println("4. Depositar");
	            System.out.println("5. Retirar");
	            System.out.println("6. Transferir");
	            System.out.println("7. Salir");
	            Scanner scanner = new Scanner(System.in);
	            int opcion = scanner.nextInt();
	            seleccion(opcion);
	        }

	    }

	    private void seleccion(int seleccion) {
	        switch (seleccion) {
	            case 1:
	                crearCuenta();
	                break;
	            
	            case 3:
	                buscarCuenta();
	                break;
	            case 4:
	            	  salir();
	                break;
	            default:
	                System.out.println("Opcion no valida");
	                break;
	        }
	    }

	    /**
	     * 
	     */
	    private void crearCuenta() {
	        System.out.println("Crear cuenta");
	        Scanner scanner = new Scanner(System.in);
	        System.out.println("Ingrese 1 cuenta ahorro o 2 cuenta corriente:");
	        int  tipoCuenta=scanner.nextInt();
	        scanner.nextLine();
	        if(tipoCuenta<0) {
	        	System.out.println("Cuenta no valida");
	        }else {
	        	if(tipoCuenta==1) {
	        		System.out.println("Numero de cuenta: ");
	    	        String  numcuenta = scanner.nextLine();
	    	        System.out.println("Saldo: ");
	    	        float saldo = scanner.nextFloat();
	    	        scanner.nextLine();
	    	        System.out.println("Nombre propietario: ");
	    	       	String  nomPropietario = scanner.nextLine();
	    	        scanner.nextLine();
	    	        Cuenta cuentaa = new CuentaAhorro(numcuenta, saldo,nomPropietario,tipoCuenta);
	    	       services.Guardar(cuentaa);
	        	}
	        	else {
	        		if(tipoCuenta==2)
	        		{
	        			System.out.println("Numero de cuenta: ");
	        	        String  numcuenta = scanner.nextLine();
	        	        System.out.println("Saldo: ");
	        	        float saldo = scanner.nextFloat();
	        	        scanner.nextLine();
	        	        System.out.println("Nombre propietario: ");
	        	       	String  nomPropietario = scanner.nextLine();
	        	        scanner.nextLine();
	        	        Cuenta cuentac = new CuentaCorriente(numcuenta, saldo,nomPropietario,tipoCuenta);
	        	       services.Guardar(cuentac);
	        		}
	        	}
	        }
	        

	    }

	    

	   private void buscarCuenta() {
	        System.out.println("Buscar cuenta");
	        Scanner scanner = new Scanner(System.in);
	        System.out.println("Ingrese el numero de la cuenta: ");
	        String  numCuenta = scanner.nextLine();
	        scanner.nextLine();
	        try {
	            Cuenta encontrada =  (Cuenta) services.Buscar(numCuenta);
	            System.out.println("Cuenta encontrada: " + encontrada.getNomPropietario());
	            System.out.println(encontrada.getSaldo());
	            System.out.println(encontrada.getTipoCuenta());
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
	    }

	    private void Depositar() {
	    	System.out.println("Depositar a cuenta");
	    	Scanner scanner=new Scanner(System.in);
	    	 System.out.println("Ingrese el numero de la cuenta: ");
		        String  numCuenta = scanner.nextLine();
	    	System.out.println("Ingrese 1 si desea depositar a Ahorros y 2 a Corriente");
	    	int tipoCuenta=scanner.nextInt();
	    	scanner.nextLine();
	    	if(tipoCuenta<0) {
	    		System.out.println("Ingrese un tipo de cuenta valido");
	    	}else {
	    		if(tipoCuenta==1) {
	    			System.out.println("Ingrese el valor a depositar");
	    			double valor=scanner.nextDouble();
	    			scanner.nextLine();
	    			
	    		//	CuentaAhorro ahorro CuentaAhorro();;
	    		
	    			ahorro.Depositar(valor);
	    		}else {
	    			if(tipoCuenta==2) {
	    				System.out.println("Ingrese el valor a depositar");
		    			double valor=scanner.nextDouble();
		    			scanner.nextLine();
		    			
	    			}
	    		}
	    	}
	    }

	    private void salir() {
	        System.out.println("Salir");
	        run = false;
	    }


}
