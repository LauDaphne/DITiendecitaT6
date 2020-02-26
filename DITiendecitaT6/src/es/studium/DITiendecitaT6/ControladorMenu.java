package es.studium.DITiendecitaT6;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import es.studium.Articulo.ControladorAltaArticulo;
import es.studium.Articulo.ControladorBajaArticulo;
import es.studium.Articulo.ControladorConsultaArticulo;
import es.studium.Articulo.ControladorModificacion1Articulo;
import es.studium.Ticket.ControladorAltaTicket;
import es.studium.Ticket.ControladorConsultaTicket;
import es.studium.Ticket.ControladorInformeTicket;

public class ControladorMenu implements ActionListener{
	
	VistaMenu objVista = new VistaMenu();
	Modelo objModelo = new Modelo();
	
	ControladorMenu(){
		//Añadimos los escuchadores
		objVista.itemAltaArticulo.addActionListener(this);
		objVista.itemBajaArticulo.addActionListener(this);
		objVista.itemModificacionArticulo.addActionListener(this);
		objVista.itemConsultaArticulo.addActionListener(this);
		objVista.itemAltaTicket.addActionListener(this);
		objVista.itemConsultaTicket.addActionListener(this);
		objVista.itemInformeTickets.addActionListener(this);
		objVista.itemInformeArtculos.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(objVista.itemAltaArticulo.equals(e.getSource())) {
			new ControladorAltaArticulo();
		}
		
		if(objVista.itemBajaArticulo.equals(e.getSource())) {
			new ControladorBajaArticulo();
		}
		
		if(objVista.itemModificacionArticulo.equals(e.getSource())) {
			new ControladorModificacion1Articulo();
		}
		
		if(objVista.itemConsultaArticulo.equals(e.getSource())) {
			new ControladorConsultaArticulo();
		}
		
		if(objVista.itemAltaTicket.equals(e.getSource())) {
			new ControladorAltaTicket();
		}
		
		if(objVista.itemConsultaTicket.equals(e.getSource())) {
			new ControladorConsultaTicket();
		}
		
		if(objVista.itemInformeTickets.equals(e.getSource())) {
			new ControladorInformeTicket();
		}
		
		if(objVista.itemInformeArtculos.equals(e.getSource())) {
			objModelo.generarJasperArticulo(objVista);
		}
		
	}

}
