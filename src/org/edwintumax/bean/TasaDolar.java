/**
 * @author Edwin Tumax
 */


package org.edwintumax.bean;
import java.util.Date;
public class TasaDolar {
	private int idTasa;
    private double tasa;
    private Date fecha;
    public TasaDolar() {
    }
    public TasaDolar(int idTasa, double tasa, Date fecha) {
        this.idTasa = idTasa;
        this.tasa = tasa;
        this.fecha = fecha;
    }
    public TasaDolar(double tasa, Date fecha){
       this.tasa = tasa;
       this.fecha = fecha;    
    }
    public int getIdTasa() {
        return idTasa;
    }
    public void setIdTasa(int idTasa) {
        this.idTasa = idTasa;
    }
    public double getTasa() {
        return tasa;
    }
    public void setTasa(double tasa) {
        this.tasa = tasa;
    }
    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
