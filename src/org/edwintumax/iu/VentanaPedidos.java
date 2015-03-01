/**
 * @author Edwin Tumax
 */

package org.edwintumax.iu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import org.edwintumax.bean.TasaDolar;
import org.edwintumax.db.GestorDeClientes;
import org.edwintumax.interfaces.Observable;
import org.edwintumax.interfaces.Observer;
import org.edwintumax.modelo.ModeloTasaDolar;
import org.edwintumax.util.Util;
public class VentanaPedidos extends JFrame implements Observable {
	private static final long serialVersionUID = 1L;
	private JScrollPane scrollPanel;
    private JTable tabla;
    private ModeloTasaDolar modelo;    
    private JButton btnAgregar;
    private GestorDeClientes clientes;
    public VentanaPedidos() {
        this.setTitle("Ventana de Pedidos");
        this.setLayout(null);
        modelo = ModeloTasaDolar.getInstancia();
        clientes = GestorDeClientes.getInstancia();
        tabla = new JTable();
        tabla.setModel(modelo);
        modelo.actualizarDatos();        
        btnAgregar = new JButton("Actualizar Tasa");
        btnAgregar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String nuevoValor = javax.swing.JOptionPane.showInputDialog("Nuevo valor");
				modelo.agregar(new TasaDolar(Double.parseDouble(nuevoValor),new Date()));
				notificar();
            }
        });
        btnAgregar.setBounds(5,270,160,40);
        this.getContentPane().add(btnAgregar);
        scrollPanel = new JScrollPane();
        scrollPanel.setViewportView(tabla);
        scrollPanel.setBounds(5,5,470,250);
        this.getContentPane().add(scrollPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,350);
        this.setVisible(true);
    }

    @Override
	public void agregar(Observer observador) {
		clientes.agregar(Util.getIp());	
		
	}
	@Override
	public void eliminar(Observer observador) {
		clientes.remover(Util.getIp());	
		
	}
	@Override
	public void notificar() {
		for(String ip: clientes.getTodos()){
			System.out.println("Notificando a :" + ip);
	        System.setSecurityManager(new RMISecurityManager());

	        try 
	        { 
	        	Observer observador = (Observer) Naming.lookup( "//" +ip + "/tasa_dolar");         //objectname in registry 
	           observador.actualizar(); 
	        } 
	        catch (Exception e) 
	        { 
	        	System.err.println("Error al notificar al ip " + ip + " (" + e + ")");
	        	e.printStackTrace(); 
	        } 
			
		}
		
	}
}