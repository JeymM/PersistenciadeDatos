package Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import Entidades.Cuenta;

public class CuentaBaseDatos implements Repositorio {
	
	String con;
	
	

	public CuentaBaseDatos() {
		try {
			DriverManager.registerDriver(new org.sqlite.JDBC());
			con="jdbc:sqlite:ensayo.db";
			CrearTabla();
			
		}catch(SQLException e) { 	
			System.out.println("Error de conexion con la base de datos " + e);
			
		}
	}
	
	private void CrearTabla() {
		try(Connection conexion=DriverManager.getConnection(con)){
			 String sql = "CREATE TABLE IF NOT EXISTS Cuentas (\n"
	                    + " id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
	                    + " nombrePropietario TEXT NOT NULL,\n"
	                    + " TipoCuenta TEXT NOT NULL,\n"
	                    + " numCuenta TEXT NOT NULL UNIQUE\n"
	                     + ");";
			 
			 Statement sentencia=conexion.createStatement();
			 sentencia.execute(sql);
		}catch (SQLException e) {
			 System.out.println("Error de conexión: " + e.getMessage());
		}
	}

	public void Guardar(Object objeto) {
		  try (Connection conexion = DriverManager.getConnection(con)) {
	           Cuenta cuenta  = (Cuenta) objeto;
	            String sentenciaSql = "INSERT INTO personas (nombre, apellido, edad, identificacion, celular) " +
	                    " VALUES('" + cuenta.getNumCuenta()+ "', '" +cuenta.getSaldo()
	                    + "', " + cuenta.getNomPropietario() + ", '" + cuenta.getTipoCuenta()
	                    + "');";
	            Statement sentencia = conexion.createStatement();
	            sentencia.execute(sentenciaSql);
	        } catch (SQLException e) {
	            System.err.println("Error de conexión: " + e);
	        } catch (Exception e) {
	            System.err.println("Error " + e.getMessage());
	        }

		
	}

	@Override
	public Object Buscar(String numCuenta) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<?> Listar() {
		// TODO Auto-generated method stub
		return null;
	}

	
	

}
