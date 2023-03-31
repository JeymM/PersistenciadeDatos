package GUI;


import java.util.List;
import java.util.Scanner;

import Entidades.Cuenta;
//import Entidades.CuentaAhorro;
import Entidades.CuentaCorriente;
import Entidades.Movimientos;
import Excepciones.Limites;
import Servicios.Services;
import Entidades.CuentaAhorro;

public class GUI_Cuenta {
	private boolean run=true;
	
	private Services services;
	
	
	public GUI_Cuenta() {
	
		services= new Services();
	}
	
	 public void iniciar() throws Limites {
	        System.out.println("Bienvenido al sistema de persistencia de cuentas");

	        while (run) {
	            System.out.println("1. Crear cuenta");
	            System.out.println("2. Buscar cuenta");
	            System.out.println("3. Depositar cuenta");
	            System.out.println("4. Retirar");
	            System.out.println("5. Transferir");
	            System.out.println("6. Salir");
	          
	            Scanner scanner = new Scanner(System.in);
	            int opcion = scanner.nextInt();
	            seleccion(opcion);
	        }

	    }

	    private void seleccion(int seleccion) throws Limites {
	        switch (seleccion) {
	            case 1:
	                crearCuenta();
	                break;
	            
	            case 2:
	                buscarCuenta();
	                break;
	            case 3:
	            	  Depositar();
	                break;
	                
	            case 4: 
	            	Retirar();
	            	break;
	            case 5:
	            	Transferir();
	            	break;
	            case 6:
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
	        System.out.println("Ingrese a para  cuenta ahorro o c para cuenta corriente:");
	        String  tipoCuenta=scanner.nextLine();
	        scanner.nextLine();
	        if(tipoCuenta==null) {
	        	System.out.println("Cuenta no valida");
	        }else {
	        	if(tipoCuenta.equalsIgnoreCase("a")) {
	        		System.out.println("Numero de cuenta: ");
	    	        String  numcuenta = scanner.nextLine();
	    	        System.out.println("Saldo: ");
	    	        float saldo = scanner.nextFloat();
	    	        scanner.nextLine();
	    	        System.out.println("Nombre propietario: ");
	    	       	String  nomPropietario = scanner.nextLine();
	    	      
	    	        Cuenta cuentaa = new CuentaAhorro(numcuenta, saldo,nomPropietario,tipoCuenta);
	    	       services.Guardar(cuentaa);
	        	}
	        	else {
	        		if(tipoCuenta.equalsIgnoreCase("c"))
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

	    

	   private Cuenta buscarCuenta() {
	        System.out.println("Buscar cuenta");
	        Scanner scanner = new Scanner(System.in);
	        System.out.println("Ingrese el numero de la cuenta: ");
	        String  numCuenta = scanner.nextLine();
	        Cuenta cuenta=(Cuenta) services.Buscar(numCuenta);
	        if(cuenta != null){
	            String datosCuenta = "Tipo de cuenta: " + cuenta.getTipoCuenta() + "\n"
	                    + "Numero: " + cuenta.getSaldo()+ "\n"
	                    + "Propietario: " + cuenta.getNomPropietario() ;
	                  
	            System.out.println(datosCuenta);
	        } else {
	            System.out.println("La cuenta indicada no existe");
	        }
	        return cuenta;
	    }

	    private void Depositar() {
	    	Cuenta cuenta=buscarCuenta();
	    	if(cuenta!=null) {
	    		Scanner scanner=new Scanner(System.in);
	    		System.out.println("Ingrese el valor a depositar");
	    		float saldo=scanner.nextFloat();
	    		scanner.nextLine();
	    		if(cuenta.getTipoCuenta().equalsIgnoreCase("a")) {
	    			CuentaAhorro ahorro=(CuentaAhorro) cuenta;
	    			
	    			ahorro.Depositar(saldo);
	    			services.actualizarSaldo(ahorro.getNumCuenta(), ahorro.getSaldo());
	    			
	    		}else {
	    			CuentaCorriente cuentac=(CuentaCorriente) cuenta;
	    			
	    			cuentac.Depositar(saldo);
	    			
	    			services.actualizarSaldo(cuentac.getNumCuenta(),cuentac.getSaldo());
	    		}
	    				
	    			}
	    	
	    }
	    
	    private void Retirar() throws Limites {
	    	Cuenta cuenta=buscarCuenta();
	    	if(cuenta!=null) {
	    		Scanner scanner=new Scanner(System.in);
	    		System.out.println("Ingrese el valor a retirar");
	    		float saldo=scanner.nextFloat();
	    		scanner.nextLine();
	    		if(cuenta.getTipoCuenta().equalsIgnoreCase("a")) {
	    			CuentaAhorro ahorro=(CuentaAhorro) cuenta;
	    			
	    			ahorro.Retirar(saldo);
	    			services.actualizarSaldo(ahorro.getNumCuenta(), ahorro.getSaldo());
	    			
	    		}else {
	    			CuentaCorriente cuentac=(CuentaCorriente) cuenta;
	    			
	    			cuentac.Retirar(saldo);
	    			
	    			services.actualizarSaldo(cuentac.getNumCuenta(),cuentac.getSaldo());
	    		}
	    				
	    			}
	    	
	    }
	    
	    private void Transferir() throws Limites {
	    	System.out.println("Numero de cuenta desde donde hace la transferencia");
	    	Cuenta cuentaO=buscarCuenta();
	    	System.out.println("Cuenta  destino");
	    	Cuenta cuentaD=buscarCuenta();
	    	if(cuentaO!=null && cuentaD!=null) {
	    		Scanner scanner=new Scanner(System.in);
	    		System.out.println("Valor a transferir");
	    		float valor=scanner.nextFloat();
	    		scanner.nextLine();
	    		if(cuentaO.getTipoCuenta().equalsIgnoreCase("c")) {
	    			CuentaCorriente corriente=(CuentaCorriente) cuentaO;
	    			corriente.transferirDinero(cuentaO, cuentaD, valor);
	    			
	    			services.actualizarSaldo(corriente.getNumCuenta(), corriente.getSaldo());
	    			
	    			services.actualizarSaldo(cuentaD.getNumCuenta(), cuentaD.getSaldo());
	    		}else {
	    			CuentaAhorro ahorro=(CuentaAhorro)cuentaO;
	    			ahorro.transferirDinero(cuentaO, cuentaD, valor);
	    			
	    			services.actualizarSaldo(ahorro.getNumCuenta(),ahorro.getSaldo());
	    			
	    			services.actualizarSaldo(cuentaD.getNumCuenta(), cuentaD.getSaldo());
	    		}
	    	}
	    }

	    private void salir() {
	        System.out.println("Salir");
	        run = false;
	    }


}
