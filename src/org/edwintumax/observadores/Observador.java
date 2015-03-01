/**
 * @author Edwin Tumax
 */

package org.edwintumax.observadores;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import org.edwintumax.interfaces.Observer;
import org.edwintumax.modelo.ModeloTasaDolar;

public class Observador extends UnicastRemoteObject implements Observer{

	private static final long serialVersionUID = 1L;
	
	public Observador() throws RemoteException{

	}

	@Override
	public void actualizar() throws RemoteException {
		System.out.println("actualizando");
		ModeloTasaDolar.getInstancia().actualizarDatos();
		
	}

}
