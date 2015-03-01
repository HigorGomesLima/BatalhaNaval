package org.edwintumax.configuracion;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class GestorDeConfiguracion {
	private static GestorDeConfiguracion instancia;
	private Properties propiedades;
	
	public static synchronized GestorDeConfiguracion getInstancia(){
		return instancia == null ? instancia = new GestorDeConfiguracion() : instancia; 
	}

	
	private GestorDeConfiguracion(){
		propiedades = new Properties();
		try {
			propiedades.load(new FileReader("configuracion.properties"));
		} catch (IOException e) {
			System.err.println("Error al leer archivo de configuración");
			e.printStackTrace();
		}
	}
	
	public String getConfig(String llave){
		return propiedades.getProperty(llave);
	}

}
