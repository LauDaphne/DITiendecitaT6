package es.studium.Articulo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

import es.studium.DITiendecitaT6.Modelo;

/**
 * <h1>Clase ControladorModificacion2Articulo</h1>
 * <p>Clase que controla {@link VistaModificacion2Articulo} y le da funcionalidad.</p>
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
 * 			<li>{@link #idArticulo}</li>
 * 		</ul>
 * 	</li>
 * <li>Otros: 
 * 		<ul>
 * 			<li>{@link #resultado}</li>
 * 		</ul>
 * 	</li>
 * </ul>
 * <p><b>Metodos:</b></p>
 * <ul>
 * 	<li>{@link #ControladorModificacion2Articulo()}</li>
 * 	<li>{@link #actionPerformed(ActionEvent)}</li>
 * </ul>
 * @author Laura M. P.
 * @since 28/02/2020
 * @version 1.0
 */
public class ControladorModificacion2Articulo implements ActionListener {

	/** 
	 * <h1>Objeto objVista </h1>
	 * <p>Objeto de la clase {@link VistaModificacion2Articulo}</p>
	 * */
	VistaModificacion2Articulo objVista = new VistaModificacion2Articulo();
	
	/** 
	 * <h1>Objeto objModelo </h1>
	 * <p>Objeto de la clase {@link Modelo}</p>
	 * */
	Modelo objModelo = new Modelo();
	
	/** 
	 * <h1>Variable resultado</h1>
	 * <p>Variable de tipo {@link ResultSet}, resultado de una consulta en la base de datos.</p>
	 */
	ResultSet resultado;
	
	/** 
	 * <h1>Variable idArticulo</h1>
	 * <p>Variable de tipo {@link String} que contine el ID de un artículo de la base de datos.</p>
	 */
	String idArticulo;

	/**
	 * <h1>Constructor por defecto</h1>
	 * <p>Constructor por defecto de la clase {@link ControladorModificacion2Articulo}.</p>
	 * <p>Rellena los campos la clase {@link VistaModificacion2Articulo} con los datos de la base de datos. <br> Añade {@link ActionListener} a los siguientes componentes de la clase {@link VistaModificacion2Articulo}:</p>
	 * <ul>
	 * 	<li>{@link VistaModificacion2Articulo#btnCambiarArticulo btnCambiarArticulo}</li>
	 * 	<li>{@link VistaModificacion2Articulo#btnBorrarCambio btnBorrarCambio}</li>
	 * 	<li>{@link VistaModificacion2Articulo#btnCancelarCambio btnCancelarCambio}</li>
	 * </ul>
	 * @param idArticulo ({@link String}) - ID de un artículo de la base de datos
	 */
	public ControladorModificacion2Articulo(String idArticulo) {
		this.idArticulo=idArticulo;
		// Rellenar campos
		try {
			String sentenciaRellenarCampos = "SELECT nombreArticulo, descripcionArticulo, precioArticulo, stockArticulo FROM articulos WHERE idArticulo LIKE '"
					+ idArticulo + "';";
			objModelo.conectaBase();
			resultado = objModelo.buscarDatos(sentenciaRellenarCampos);
			resultado.next();
			objVista.txtNombreModificacion.setText(resultado.getString(1));
			objVista.txtAreaDescripcionCambio.setText(resultado.getString(2));
			objVista.txtPrecioModificacion.setText(resultado.getString(3));
			objVista.txtStockModificacion.setText(resultado.getString(4));
			objModelo.desconectaBase();

		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(objVista, "Algo ha fallado. Revise la base de datos y vuelva a intentarlo.",
					"Mensaje de ERROR", JOptionPane.ERROR_MESSAGE);
		}
		// Añadimos los escuchadores
		objVista.btnCambiarArticulo.addActionListener(this);
		objVista.btnBorrarCambio.addActionListener(this);
		objVista.btnCancelarCambio.addActionListener(this);
	}

	/**
	 * <h1>Action performed</h1>
	 * <p>Método de la interfaz {@link ActionListener}. Según el componente de la clase {@link VistaModificacion2Articulo} pulsado:</p>
	 * <ul>
	 * 	<li>- Hará la <u>modificación</u> de un artículo en la base de datos.</li>
	 *  <li>- Reiniciará los campos de la ventana con los datos de la base de datos.</li>
	 *  <li>- Cerrará la ventana</li>
	 * </ul>
	 * @param e - Parámetro de tipo {@link ActionEvent}
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		if (objVista.btnCambiarArticulo.equals(e.getSource())) {
			if (objVista.txtNombreModificacion.getText().equals("")
					| objVista.txtPrecioModificacion.getText().equals("")
					| objVista.txtStockModificacion.getText().equals("")) {
				JOptionPane.showMessageDialog(objVista,
						"Uno o varios de los campos obligatorios NO han sido rellenados ", "Mensaje de ERROR",
						JOptionPane.ERROR_MESSAGE);
			} else {
				try {
					int opcion = JOptionPane.showConfirmDialog(objVista, "¿Está seguro de modificar este artículo?",
							"Modificar", JOptionPane.YES_NO_OPTION);
					if (opcion == JOptionPane.YES_OPTION) {
						objModelo.conectaBase();
						String sentenciaModificar ="UPDATE articulos SET nombreArticulo='"+objVista.txtNombreModificacion.getText()+"', descripcionArticulo='"+objVista.txtAreaDescripcionCambio.getText()+"', precioArticulo='"+Double.parseDouble(objVista.txtPrecioModificacion.getText())+"', stockArticulo='"+Integer.parseInt(objVista.txtStockModificacion.getText())+"' WHERE idArticulo='"+idArticulo+"';";
						objModelo.datosABM(sentenciaModificar);
						objModelo.desconectaBase();
						int opcion2 = JOptionPane.showConfirmDialog(objVista,
								"El artículo ha sido modificado correctamente.¿Desea hacer otra modificación?",
								"Confirmación", JOptionPane.YES_NO_OPTION);
						if (opcion2 == JOptionPane.YES_OPTION) {
							new ControladorModificacion1Articulo();
							// Elimina la ventana
							objVista.setVisible(false);
							objVista.dispose();
						} else {
							// Elimina la ventana
							objVista.dispose();
						}
					}
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(objVista,
							"No se ha podido realizar la modificación correctamente. Revise los datos y vuelva a intentarlo.",
							"Mensaje de ERROR", JOptionPane.ERROR_MESSAGE);
				}

			}

		}

		if (objVista.btnBorrarCambio.equals(e.getSource())) {
			// Rellenar campos
			try {
				String sentenciaRellenarCampos = "SELECT nombreArticulo, descripcionArticulo, precioArticulo, stockArticulo FROM articulos WHERE idArticulo LIKE '"
						+ idArticulo + "';";
				objModelo.conectaBase();
				resultado = objModelo.buscarDatos(sentenciaRellenarCampos);
				resultado.next();
				objVista.txtNombreModificacion.setText(resultado.getString(1));
				objVista.txtAreaDescripcionCambio.setText(resultado.getString(2));
				objVista.txtPrecioModificacion.setText(resultado.getString(3));
				objVista.txtStockModificacion.setText(resultado.getString(4));
				objModelo.desconectaBase();

			} catch (Exception e1) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(objVista,
						"Algo ha fallado. Revise la base de datos y vuelva a intentarlo.", "Mensaje de ERROR",
						JOptionPane.ERROR_MESSAGE);
			}
		}

		if (objVista.btnCancelarCambio.equals(e.getSource())) {
			new ControladorModificacion1Articulo();
			// Elimina la ventana
			objVista.setVisible(false);
			objVista.dispose();

		}

	}
}
