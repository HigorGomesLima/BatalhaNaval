/**
 * @author Raydelto Hernández Perera
 */

package org.edwintumax.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GestorDeClientes {
	private PreparedStatement ppdAgregarCliente;
	private PreparedStatement ppdRemoverCliente;
	private PreparedStatement ppdObtenerClientes;
	private Connection conexion;	
	private static GestorDeClientes instancia;
	
	public static synchronized GestorDeClientes getInstancia(){
		return instancia == null ? instancia = new GestorDeClientes() : instancia; 
	}

	
	
	private GestorDeClientes(){
		conexion = Conexion.getInstancia().getConexion();
		
		try {
			ppdAgregarCliente = conexion.prepareStatement("insert into clientes(ip) values (?)");
			ppdObtenerClientes = conexion.prepareStatement("select ip from clientes");
			ppdRemoverCliente = conexion.prepareStatement("delete from clientes where ip = ?");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void agregar(String ip){
		try {
			ppdAgregarCliente.setString(1, ip);
			ppdAgregarCliente.execute();
		} catch (Exception e) {
			System.err.println("Error mientras agregaba IP");
			e.printStackTrace();
		}		
	}
	
	public void remover(String ip){
		try {
			ppdRemoverCliente.setString(1, ip);
			ppdRemoverCliente.execute();
		} catch (Exception e) {
			System.err.println("Error mientras remov�a IP");
			e.printStackTrace();
		}		
	}

	
	
	public ArrayList<String> getTodos(){
		ArrayList<String> listado = new ArrayList<String>();
		try {
			ResultSet resultados = ppdObtenerClientes.executeQuery();
			while(resultados.next()){
				listado.add(resultados.getString("ip"));
			}
		} catch (SQLException e) {
			System.err.println("Error mientras se obtenia el listado de clientes");
			e.printStackTrace();
		}		
		return listado;
	}

}
