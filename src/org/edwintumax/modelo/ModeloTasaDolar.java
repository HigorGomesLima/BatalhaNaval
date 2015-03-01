package org.edwintumax.modelo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.table.AbstractTableModel;

import org.edwintumax.bean.TasaDolar;
import org.edwintumax.db.Conexion;
public class ModeloTasaDolar extends AbstractTableModel {
	private static ModeloTasaDolar instancia;
	private static final long serialVersionUID = 1L;
	private ArrayList<TasaDolar> listaTasaDolar;
    private String[] encabezados = {"idTasa","tasa","fecha"};
    
	public static synchronized ModeloTasaDolar getInstancia(){
		return instancia == null ? instancia = new ModeloTasaDolar() : instancia; 
	}

    private ModeloTasaDolar() {
        listaTasaDolar = new ArrayList<TasaDolar>();
    }
    public String getColumnName(int columna){
        return encabezados[columna];
    }
    public int getRowCount() {
        return listaTasaDolar.size();
    }
    public int getColumnCount() {
        return encabezados.length;
    }
    public Object getValueAt(int fila, int columna) {
        String resultado = "";
        TasaDolar tasaDolar = listaTasaDolar.get(fila);
        switch(columna){
            case 0:
                resultado = String.valueOf(tasaDolar.getIdTasa());
                break;
            case 1:
                resultado = String.valueOf(tasaDolar.getTasa());
                break;
            case 2:
                resultado = String.valueOf(tasaDolar.getFecha());
                break;
        }
        return resultado;
    }   
    public void setListaTasaDolar(ArrayList<TasaDolar> listaTasaDolar) {
        this.listaTasaDolar = listaTasaDolar;
        fireTableDataChanged();
    }
    public void agregar(TasaDolar tasa){
        Conexion.getInstancia().
                ejecutarSentencia("insert into tasadolar values(0," + 
                        tasa.getTasa() + ",'" + obtenerFecha(tasa.getFecha()) + "')");
        actualizarDatos();        
    }
    public void actualizarDatos(){
        try{
            listaTasaDolar.removeAll(listaTasaDolar);
            ResultSet resultado = Conexion.getInstancia().obtenerConsulta("select * from tasadolar");
            while(resultado.next()){
                listaTasaDolar.add(new TasaDolar(resultado.getInt("idTasa"),resultado.getDouble("tasa"),resultado.getDate("fecha")));
            }
        }catch(SQLException e){
        	System.err.println("Error de conexión a base de datos: " + e);
            e.printStackTrace();
        }
        fireTableDataChanged();
    }
    public static String obtenerFecha(Date fecha){
        String patron = "yyyy-MM-dd";
        SimpleDateFormat formato = new SimpleDateFormat(patron);
        String resultado = "";
        try{
            resultado = formato.format(fecha);
        }catch(Exception e){
            e.printStackTrace();
        }
        return resultado;
    }
}