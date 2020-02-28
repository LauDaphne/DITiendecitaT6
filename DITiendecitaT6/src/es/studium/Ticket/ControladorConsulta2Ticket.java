package es.studium.Ticket;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import es.studium.DITiendecitaT6.Modelo;

/**
 * <h1>Clase ControladorConsulta2Ticket</h1>
 * <p>Clase que controla {@link VistaConsulta2Ticket} y le da funcionalidad.</p>
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
 * 	<li>{@link #ControladorConsulta2Ticket(String, String, String)}</li>
 * 	<li>{@link #actionPerformed(ActionEvent)}</li>
 * </ul>
 * @author Laura M. P.
 * @since 28/02/2020
 * @version 1.0
 */
public class ControladorConsulta2Ticket implements ActionListener{
	
	/** 
	 * <h1>Objeto objVista </h1>
	 * <p>Objeto de la clase {@link VistaConsulta2Ticket}</p>
	 * */
	VistaConsulta2Ticket objVista = new VistaConsulta2Ticket();
	
	/** 
	 * <h1>Objeto objModelo </h1>
	 * <p>Objeto de la clase {@link Modelo}</p>
	 * */
	Modelo objModelo = new Modelo();
	
	/**
	 * <h1>Constructor por defecto</h1>
	 * <p>Constructor por defecto de la clase {@link ControladorConsulta2Ticket}.</p>
	 * <p>Rellena la tabla la clase {@link VistaConsulta2Ticket}. <br> Añade {@link ActionListener} a los siguientes componentes de la clase {@link ControladorConsulta2Ticket}:</p>
	 * <ul>
	 * 	<li>{@link VistaConsulta2Ticket#btnCancelar btnCancelar}</li>
	 * </ul>
	 * @param idTicket ({@link String}) - ID de un ticket.
	 * @param fecha ({@link String}) - Fecha de un ticket.
	 * @param total ({@link String}) - Precio total de un ticket.
	 */
	ControladorConsulta2Ticket(String idTicket, String fecha, String total){
		String sentencia ="SELECT idArticulo AS 'ID', nombreArticulo AS 'ARTICULO', cantidadCompraArticulo AS 'CANTIDAD', precioArticulo AS 'PRECIO' FROM articulos, compras WHERE idArticulo=idArticuloFK AND idTicketFK='"+idTicket+"';";
		//Rellenamos la tabla
		objModelo.conectaBase();
		objModelo.rellenarTabla(sentencia, objVista.tblConsultaArtTicket);
		objModelo.desconectaBase();
		//Rellenamos los labels
		objVista.lblTitulo.setText("Ticket: "+idTicket);
		objVista.lblFechaTicket.setText(fecha);
		objVista.lblTotalTicket.setText(total);
		// Añadimos los escuchadores
		objVista.btnCancelar.addActionListener(this);
	}

	/**
	 * <h1>Action performed</h1>
	 * <p>Método de la interfaz {@link ActionListener}. Cerrará la ventana.</p>
	 * @param e - Parámetro de tipo {@link ActionEvent}
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (objVista.btnCancelar.equals(e.getSource())) {
			// Elimina la ventana
			objVista.dispose();
		}
	}
}
