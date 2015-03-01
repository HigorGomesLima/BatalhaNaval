/**
 * @author Edwin Tumax
 */

package org.edwintumax.sistema;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;

import javax.swing.JOptionPane;

import org.edwintumax.db.GestorDeClientes;
import org.edwintumax.iu.VentanaPedidos;
import org.edwintumax.observadores.Observador;
import org.edwintumax.util.Util;
public class PrincipalCliente {
    public static void main(String args[]){
    	Observador observador = null;
    	try {
    		System.setProperty("java.security.policy","file:./seguridad.policy");

			observador = new Observador();
			GestorDeClientes.getInstancia().agregar(Util.getIp());
			Naming.bind("//localhost/tasa_dolar", observador);
		}catch(AlreadyBoundException abe){
			try {
				Naming.rebind("//localhost/tasa_dolar", observador);
			} catch (Exception e) {
				mostrarError(e);
			}			
		}catch (Exception e) {
			mostrarError(e);
		}
        new VentanaPedidos();
    }
    
    public static void mostrarError(Exception e){
		System.err.println("Error de RMI" + e);
		System.err.println("Verifique que el comando rmiregistry est� corriendo en este momento");
		e.printStackTrace();
		JOptionPane.showMessageDialog(null, "Error de ejecici�n: " + e +"\nVerifique el rmiregistry est� corriendo y que el archivo configuracion.properties contiene la informaci�n correcta para conectar a la DB","Error al iniciar", JOptionPane.ERROR_MESSAGE);

    }
}
