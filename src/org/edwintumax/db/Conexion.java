/**
 * @author Edwin Tumax
 */

package org.edwintumax.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.edwintumax.configuracion.GestorDeConfiguracion;
public class Conexion {
    private Connection conexion;
    private Statement stm;
    private static Conexion instancia;	
    private GestorDeConfiguracion config;
    public static synchronized Conexion getInstancia(){
        return (instancia==null)? new Conexion():instancia;		
    }//			EVALUACION LOGICA | VERDADERO 	| FALSO	
    public Conexion(){
        try {
        	config = GestorDeConfiguracion.getInstancia();
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conexion=DriverManager.getConnection("jdbc:mysql://"+ config.getConfig("direccion_bd")+"/"+config.getConfig("bd")+"?user="+config.getConfig("usuario_bd")+"&password="+config.getConfig("clave_bd"));
            stm=conexion.createStatement();
        } catch (Exception  e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public Connection getConexion() {
        return conexion;
    }
    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }       
    public void ejecutarSentencia(String consulta){
        try{
            stm.execute(consulta);
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    public ResultSet obtenerConsulta(String Consulta){
        ResultSet resultado=null;
        try{
            resultado=stm.executeQuery(Consulta); 
        }catch(SQLException e){
            e.printStackTrace();
        }
        return resultado;
    }    
}