package es.studium.Ticket;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import es.studium.DITiendecitaT6.Modelo;

/**
 * <h1>Clase ControladorConsultaTicket</h1>
 * <p>Clase que controla {@link VistaConsultaTicket} y le da funcionalidad.</p>
 * <p><b>Variables:</b></p>
 * <ul>
 *  <li>Tipo Objeto: 
 * 		<ul>
 * 			<li>{@link #objVista}</li>
 * 			<li>{@link #objModelo}</li>
 * 		</ul>
 * 	</li>
 *  <li>Tipo String: 
 * 		<ul>
 * 			<li>{@link #sentenciaRellenarTabla}</li>
 * 		</ul>
 * 	</li>
 *  <li>Tipo Integer: 
 * 		<ul>
 * 			<li>{@link #celdaTabla}</li>
 * 		</ul>
 * 	</li>
 * </ul>
 * <p><b>Metodos:</b></p>
 * <ul>
 * 	<li>{@link #ControladorConsultaTicket()}</li>
 * 	<li>{@link #actionPerformed(ActionEvent)}</li>
 *  <li>{@link #mouseClicked(MouseEvent)}</li>
 *  <li>{@link #mousePressed(MouseEvent)}</li>
 *  <li>{@link #mouseReleased(MouseEvent)}</li>
 *  <li>{@link #mouseEntered(MouseEvent)}</li>
 *  <li>{@link #mouseExited(MouseEvent)}</li>
 * </ul>
 * @author Laura M. P.
 * @since 28/02/2020
 * @version 1.0
 */
public class ControladorConsultaTicket implements ActionListener, MouseListener {

	/** 
	 * <h1>Objeto objVista </h1>
	 * <p>Objeto de la clase {@link VistaConsultaTicket}</p>
	 * */
	VistaConsultaTicket objVista = new VistaConsultaTicket();
	
	/** 
	 * <h1>Objeto objModelo </h1>
	 * <p>Objeto de la clase {@link Modelo}</p>
	 * */
	Modelo objModelo = new Modelo();
	
	/** 
	 * <h1>Variable celdaTabla</h1>
	 * <p>Variable de tipo {@link Integer} que contine el ID de celda de una tabla.</p>
	 */
	int celdaTabla = -1;
	
	/** 
	 * <h1>Variable sentenciaRellenarTabla</h1>
	 * <p>Variable de tipo {@link String} que contine una sentencia SQL.</p>
	 */
	// RELLENAR TABLA
	String sentenciaRellenarTabla = "SELECT idTicket AS 'ID', DATE_FORMAT(fechaTicket, \"%d-%m-%Y\") AS 'FECHA', SUM(cantidadCompraArticulo) AS 'CANTIDAD UDS', totalTicket AS 'PRECIO TOTAL' FROM tickets, compras WHERE idTicket=idTicketFK GROUP BY idTicketFK ORDER BY 1;";
	
	/**
	 * <h1>Constructor por defecto</h1>
	 * <p>Constructor por defecto de la clase {@link ControladorConsultaTicket}.</p>
	 * <p>Rellena la tabla la clase {@link VistaConsultaTicket} con los datos de la base de datos. <br> Añade {@link ActionListener} a los siguientes componentes de la clase {@link VistaConsultaTicket}:</p>
	 * <ul>
	 * 	<li>{@link VistaConsultaTicket#btnMostrarTicket btnMostrarTicket}</li>
	 * 	<li>{@link VistaConsultaTicket#btnCancelar btnCancelar}</li>
	 * 	<li>{@link VistaConsultaTicket#tblConsultaTicket tblConsultaTicket}</li>
	 * </ul>
	 */
	public ControladorConsultaTicket() {
		//Añadimos datos a la tabla
				objModelo.conectaBase();
				objModelo.rellenarTabla(sentenciaRellenarTabla, objVista.tblConsultaTicket);
				objModelo.desconectaBase();
		// Añadimos los escuchadores
		objVista.btnMostrarTicket.addActionListener(this);
		objVista.btnCancelar.addActionListener(this);
		objVista.tblConsultaTicket.addMouseListener(this);
	}


	/**
	 * <h1>Action performed</h1>
	 * <p>Método de la interfaz {@link ActionListener}. Según el componente de la clase {@link VistaConsultaTicket} pulsado:</p>
	 * <ul>
	 * 	<li>- abrirá un objeto de la clase {@link ControladorConsulta2Ticket}.</li>
	 *  <li>- Cerrará la ventana</li>
	 * </ul>
	 * @param e - Parámetro de tipo {@link ActionEvent}
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (objVista.btnCancelar.equals(e.getSource())) {
			// Elimina la ventana
			objVista.dispose();
		}
		
		if (objVista.btnMostrarTicket.equals(e.getSource())) {
			celdaTabla=objVista.tblConsultaTicket.getSelectedRow();
			if(celdaTabla==-1) {
				JOptionPane.showMessageDialog(objVista, "NO ha sido seleccionado ningún ticket", "Mensaje de ERROR",
						JOptionPane.ERROR_MESSAGE);
			}else {
				new ControladorConsulta2Ticket((String) objVista.tblConsultaTicket.getValueAt(celdaTabla, 0),(String) objVista.tblConsultaTicket.getValueAt(celdaTabla,1),(String) objVista.tblConsultaTicket.getValueAt(celdaTabla,3));
			}
			
		}

	}


	/**
	 * Mouse clicked.
	 *
	 * @param e the e
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource().equals(objVista.tblConsultaTicket)) {
			celdaTabla = objVista.tblConsultaTicket.rowAtPoint(e.getPoint());
		}
	}


	/**
	 * Mouse pressed.
	 *
	 * @param e the e
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	/**
	 * Mouse released.
	 *
	 * @param e the e
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	/**
	 * Mouse entered.
	 *
	 * @param e the e
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	/**
	 * Mouse exited.
	 *
	 * @param e the e
	 */
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
