package es.studium.DITiendecitaT6;

import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import es.studium.Articulo.ControladorAltaArticulo;
import es.studium.Articulo.ControladorBajaArticulo;
import es.studium.Articulo.ControladorConsultaArticulo;
import es.studium.Articulo.ControladorModificacion1Articulo;
import es.studium.Ticket.ControladorAltaTicket;
import es.studium.Ticket.ControladorConsultaTicket;
import es.studium.Ticket.ControladorInformeTicket;

/**
 * <h1>Clase ControladorMenu </h1>
 * <p>Clase que controla {@link VistaMenu} y le da funcionalidad.</p>
 * <p><b>Variables:</b></p>
 * <ul>
 *  <li>Tipo Objeto: 
 * 		<ul>
 * 			<li>{@link #objVista}</li>
 * 			<li>{@link #objModelo}</li>
 * 		</ul>
 * 	</li>
 * </ul>
 * <p><b>Metodos:</b></p>
 * <ul>
 * 	<li>{@link #ControladorMenu()}</li>
 * 	<li>{@link #actionPerformed(ActionEvent)}</li>
 * </ul>
 * @author Laura M. P.
 * @since 28/02/2020
 * @version 1.0
 */
public class ControladorMenu implements ActionListener{
	
	/** 
	 * <h1>Objeto objVista </h1>
	 * <p>Objeto de la clase {@link VistaMenu}</p>
	 * */
	VistaMenu objVista = new VistaMenu();
	
	/** 
	 * <h1>Objeto objModelo </h1>
	 * <p>Objeto de la clase {@link Modelo}</p>
	 * */
	Modelo objModelo = new Modelo();
	
	/**
	 * <h1>Constructor por defecto</h1>
	 * <p>Constructor por defecto de la clase {@link ControladorMenu}.</p>
	 * <p>Añade {@link ActionListener} a los siguientes componentes de la clase {@link VistaMenu}:</p>
	 * <ul>
	 * 	<li>{@link VistaMenu#itemAltaArticulo itemAltaArticulo}</li>
	 * 	<li>{@link VistaMenu#itemBajaArticulo itemBajaArticulo}</li>
	 * 	<li>{@link VistaMenu#itemModificacionArticulo itemModificacionArticulo}</li>
	 * 	<li>{@link VistaMenu#itemConsultaArticulo itemConsultaArticulo}</li>
	 * 	<li>{@link VistaMenu#itemAltaTicket itemAltaTicket}</li>
	 * 	<li>{@link VistaMenu#itemConsultaTicket itemConsultaTicket}</li>
	 * 	<li>{@link VistaMenu#itemInformeTickets itemInformeTickets}</li>
	 * 	<li>{@link VistaMenu#itemInformeArtculos itemInformeArtculos}</li>
	 * </ul>
	 */
	public ControladorMenu(){
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

	/**
	 * <h1>Action performed</h1>
	 * <p>Método de la interfaz {@link ActionListener}. Según el {@link MenuItem} pulsado en {@link VistaMenu}, se inicializará el objeto correspondiente.</p>
	 * @param e - Parámetro de tipo {@link ActionEvent}
	 */
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
