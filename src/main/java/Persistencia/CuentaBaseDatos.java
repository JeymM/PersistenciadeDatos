package Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Entidades.Cuenta;
import Excepciones.Limites;

public class CuentaBaseDatos implements Repositorio {

	String con;

	public CuentaBaseDatos() {
		try {
			DriverManager.registerDriver(new org.sqlite.JDBC());
			con = "jdbc:sqlite:ensayo.db";
			CrearTabla();

		} catch (SQLException e) {
			System.out.println("Error de conexion con la base de datos " + e);

		}
	}

	private void CrearTabla() {
		try (Connection conexion = DriverManager.getConnection(con)) {
			String sql = "CREATE TABLE IF NOT EXISTS Cuentas (\n" + " id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
					+ " numCuenta TEXT NOT NULL UNIQUE\n" + " saldo float NOT NULL,\n" +" nombrePropietario TEXT NOT NULL,\n" + "tipoCuenta INTEGER NOT NULL,\\n\");";

			Statement sentencia = conexion.createStatement();
			sentencia.execute(sql);
		} catch (SQLException e) {
			System.out.println("Error de conexión: " + e.getMessage());
		}
	}

	public void Guardar(Object objeto) {
		try (Connection conexion = DriverManager.getConnection(con)) {
			Cuenta cuenta = (Cuenta) objeto;
			String sentenciaSql = "INSERT INTO cuentas (numCuenta,saldo , nomPropietario,tipoCuenta) "
					+ " VALUES('" + cuenta.getNumCuenta() + "', " + cuenta.getSaldo() + ", '"
					+ cuenta.getNomPropietario() + "',"+cuenta.getTipoCuenta() + ");";
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
		try(Connection conexion=DriverManager.getConnection(con)){
			String sentenciaSQL= "SELECT * FROM personas WHERE identificacion = ?";
			PreparedStatement sentencia=conexion.prepareStatement(sentenciaSQL);
			sentencia.setString(1, numCuenta);
			ResultSet resultadoConsulta=sentencia.executeQuery();
			if (resultadoConsulta != null && resultadoConsulta.next()) {
				Cuenta cuentaBancaria=null;
				String numCuentaResultado=resultadoConsulta.getString("numCuenta");
				float saldo=resultadoConsulta.getFloat("saldo");
				String nomPropietario=resultadoConsulta.getString("nomPropietario");
				int tipoCuenta=resultadoConsulta.getInt("tipoCuenta");
				
				cuentaBancaria=new Cuenta(numCuentaResultado,saldo,nomPropietario,tipoCuenta) ;
					
					
				return cuentaBancaria;
			}
			
		
	}catch(SQLException e) {
		System.err.println("Error de conexion: "+e);
	}
		return null;
	}

	/*@Override
	public List<?> Listar() {
		List<Cuenta>cuentas=new ArrayList<Cuenta>();
		
		try (Connection conexion = DriverManager.getConnection(con)) {
            String sentenciaSql = "SELECT * FROM personas";
            PreparedStatement sentencia = conexion.prepareStatement(sentenciaSql);
            ResultSet resultadoConsulta = sentencia.executeQuery();

            if (resultadoConsulta != null) {
                while (resultadoConsulta.next()) {
                    Cuenta cuenta  = null;
                    String numCuenta = resultadoConsulta.getString("numCuenta");
                    float saldo = resultadoConsulta.getFloat("saldo");  
                    String nomPropietario = resultadoConsulta.getString("nomPropietario");
                   int tipoCuenta=resultadoConsulta.getInt("tipoCuenta");

                    cuenta = new Cuenta(numCuenta,saldo,nomPropietario,tipoCuenta);
                    cuentas.add(cuenta);
                }
                return cuentas;
            }
        } catch (SQLException e) {
            System.err.println("Error de conexión: " + e);
        }
        return null;

}*/
	public void ActualizarSaldo() {
		/*try (Connection conexion = DriverManager.getConnection(con)) {
				Cuenta cuenta=new Cuenta();
		}
			 String sentenciaSql = "Update cuentas + SET saldo= " +Cuenta.class ;
	          //  PreparedStatement sentencia = con.prepareStatement(sentenciaSql);
	        //    ResultSet resultadoConsulta = sentencia.executeQuery();
	}*/
	}

	@Override
	public void Guardar(Cuenta cuenta) {
		// TODO Auto-generated method stub
		
	}


	
	

}
