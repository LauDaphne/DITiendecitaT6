package es.studium.Articulo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import es.studium.DITiendecitaT6.Modelo;

/**
 * <h1>Clase ControladorConsultaArticulo</h1>
 * <p>Clase que controla {@link VistaConsultaArticulo} y le da funcionalidad.</p>
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
 * </ul>
 * <p><b>Metodos:</b></p>
 * <ul>
 * 	<li>{@link #ControladorConsultaArticulo()}</li>
 * 	<li>{@link #actionPerformed(ActionEvent)}</li>
 * </ul>
 * @author Laura M. P.
 * @since 28/02/2020
 * @version 1.0
 */
public class ControladorConsultaArticulo implements ActionListener {

	/** 
	 * <h1>Objeto objVista </h1>
	 * <p>Objeto de la clase {@link VistaConsultaArticulo}</p>
	 * */
	VistaConsultaArticulo objVista = new VistaConsultaArticulo();
	
	/** 
	 * <h1>Objeto objModelo </h1>
	 * <p>Objeto de la clase {@link Modelo}</p>
	 * */
	Modelo objModelo = new Modelo();
	
	/** 
	 * <h1>Variable sentenciaRellenarTabla</h1>
	 * <p>Variable de tipo {@link String} que contine una sentencia SQL.</p>
	 */
	// RELLENAR TABLA
	String sentenciaRellenarTabla = "SELECT idArticulo AS 'ID', nombreArticulo AS 'NOMBRE ARTICULO', precioArticulo AS 'PRECIO €', stockArticulo AS 'Nº STOCK' FROM articulos ORDER BY 1;";

	/**
	 * <h1>Constructor por defecto</h1>
	 * <p>Constructor por defecto de la clase {@link ControladorAltaArticulo}.</p>
	 * <p>Rellena la tabla la clase {@link VistaConsultaArticulo}.</p>
	 * <p>Añade {@link ActionListener} a los siguientes componentes de la clase {@link VistaConsultaArticulo}:</p>
	 * <ul>
	 * 	<li>{@link VistaConsultaArticulo#btnAceptarConsultaArticulo btnAceptarConsultaArticulo}</li>
	 * </ul>
	 */
	public ControladorConsultaArticulo() {
		//Añadimos datos a la tabla
		objModelo.conectaBase();
		objModelo.rellenarTabla(sentenciaRellenarTabla, objVista.tblConsultaArticulo);
		objModelo.desconectaBase();
		// Añadimos los escuchadores
		objVista.btnAceptarConsultaArticulo.addActionListener(this);

	}

	/**
	 * <h1>Action performed</h1>
	 * <p>Método de la interfaz {@link ActionListener}. Cerará la ventana de la clase {@link VistaConsultaArticulo}.</p>
	 * @param e - Parámetro de tipo {@link ActionEvent}
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (objVista.btnAceptarConsultaArticulo.equals(e.getSource())) {
			// Elimina la ventana
			objVista.dispose();
		}

	}

}
