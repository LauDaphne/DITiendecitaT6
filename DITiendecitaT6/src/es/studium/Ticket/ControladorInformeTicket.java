package es.studium.Ticket;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import es.studium.DITiendecitaT6.Modelo;

/**
 * <h1>Clase ControladorInformeTicket</h1>
 * <p>Clase que controla {@link VistaInformeTicket} y le da funcionalidad.</p>
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
 * 			<li>{@link #fechaI}</li>
 * 			<li>{@link #fechaF}</li>
 * 		</ul>
 * 	</li>
 * </ul>
 * <p><b>Metodos:</b></p>
 * <ul>
 * 	<li>{@link #ControladorInformeTicket()}</li>
 * 	<li>{@link #actionPerformed(ActionEvent)}</li>
 * </ul>
 * @author Laura M. P.
 * @since 28/02/2020
 * @version 1.0
 */
public class ControladorInformeTicket implements ActionListener {

	/** 
	 * <h1>Objeto objVista </h1>
	 * <p>Objeto de la clase {@link VistaInformeTicket}</p>
	 * */
	VistaInformeTicket objVista = new VistaInformeTicket();
	
	/** 
	 * <h1>Objeto objModelo </h1>
	 * <p>Objeto de la clase {@link Modelo}</p>
	 * */
	Modelo objModelo = new Modelo();
	
	/** 
	 * <h1>Variables fechaI y fechaF</h1>
	 * <p>Variables de tipo {@link String} que continen la fecha de inicio y fin por la que se hará una busqueda de tickets.</p>
	 */
	String fechaI, fechaF;

	/**
	 * <h1>Constructor por defecto</h1>
	 * <p>Constructor por defecto de la clase {@link ControladorInformeTicket}.</p>
	 * <p>Añade {@link ActionListener} a los siguientes componentes de la clase {@link VistaInformeTicket}:</p>
	 * <ul>
	 * 	<li>{@link VistaInformeTicket#bttnGenerarInforme bttnGenerarInforme}</li>
	 * 	<li>{@link VistaInformeTicket#bttnLimpiar bttnLimpiar}</li>
	 * 	<li>{@link VistaInformeTicket#bttnCancelar bttnCancelar}</li>
	 * </ul>
	 */
	public ControladorInformeTicket() {
		// Añadimos los escuchadores
		objVista.bttnGenerarInforme.addActionListener(this);
		objVista.bttnLimpiar.addActionListener(this);
		objVista.bttnCancelar.addActionListener(this);
	}

	/**
	 * <h1>Action performed</h1>
	 * <p>Método de la interfaz {@link ActionListener}. Según el componente de la clase {@link VistaInformeTicket} pulsado:</p>
	 * <ul>
	 * 	<li>- Generará un pdf con un listado de tickets de la base de datos en función de dos fechas.</li>
	 *  <li>- Reiniciará los campos de la ventana con los datos de la base de datos.</li>
	 *  <li>- Cerrará la ventana</li>
	 * </ul>
	 * @param e - Parámetro de tipo {@link ActionEvent}
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(objVista.bttnGenerarInforme)) {
				fechaI = objVista.txtFechaInicio.getText();
				fechaF = objVista.txtFechaFin.getText();
				fechaI = objModelo.formatoFechaJasper(fechaI);
				fechaF = objModelo.formatoFechaJasper(fechaF);
				objModelo.generarJasperTicket(objVista, fechaI, fechaF);
				objVista.dispose();
		}
		
		if(e.getSource().equals(objVista.bttnLimpiar)) {
			objVista.txtFechaInicio.setText("");
			objVista.txtFechaFin.setText("");
		}
		
		if(e.getSource().equals(objVista.bttnCancelar)) {
			objVista.dispose();
		}

	}

}
