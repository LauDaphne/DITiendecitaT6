package es.studium.Articulo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import es.studium.DITiendecitaT6.Modelo;

/**
 * <h1>Clase ControladorAltaArticulo</h1>
 * <p>Clase que controla {@link VistaAltaArticulo} y le da funcionalidad.</p>
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
 * 	<li>{@link #ControladorAltaArticulo()}</li>
 * 	<li>{@link #actionPerformed(ActionEvent)}</li>
 * </ul>
 * @author Laura M. P.
 * @since 28/02/2020
 * @version 1.0
 */
public class ControladorAltaArticulo implements ActionListener {

	/** 
	 * <h1>Objeto objVista </h1>
	 * <p>Objeto de la clase {@link VistaAltaArticulo}</p>
	 * */
	VistaAltaArticulo objVista = new VistaAltaArticulo();
	
	/** 
	 * <h1>Objeto objModelo </h1>
	 * <p>Objeto de la clase {@link Modelo}</p>
	 * */
	Modelo objModelo = new Modelo();

	/**
	 * <h1>Constructor por defecto</h1>
	 * <p>Constructor por defecto de la clase {@link ControladorAltaArticulo}.</p>
	 * <p>Añade {@link ActionListener} a los siguientes componentes de la clase {@link VistaAltaArticulo}:</p>
	 * <ul>
	 * 	<li>{@link VistaAltaArticulo#btnAltaArticulo btnAltaArticulo}</li>
	 * 	<li>{@link VistaAltaArticulo#btnBorrarAltaArticulo btnBorrarAltaArticulo}</li>
	 * 	<li>{@link VistaAltaArticulo#btnCancelarAltaArticulo btnCancelarAltaArticulo}</li>
	 * </ul>
	 */
	public ControladorAltaArticulo() {
		// Añadimos los escuchadores
		objVista.btnAltaArticulo.addActionListener(this);
		objVista.btnBorrarAltaArticulo.addActionListener(this);
		objVista.btnCancelarAltaArticulo.addActionListener(this);
	}

	/**
	 * <h1>Action performed</h1>
	 * <p>Método de la interfaz {@link ActionListener}. Según el componente de la clase {@link VistaAltaArticulo} pulsado:</p>
	 * <ul>
	 *  <li>- Hará el <u>alta</u> de un artículo en la base de datos.</li>
	 *  <li>- Reiniciará los campos de la ventana</li>
	 *  <li>- Cerrará la ventana</li>
	 * </ul>
	 * @param e - Parámetro de tipo {@link ActionEvent}
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		if (objVista.btnAltaArticulo.equals(e.getSource())) {
			if (objVista.txtNombreAlta.getText().equals("") | objVista.txtPrecioArticulo.getText().equals("")
					| objVista.txtStockArticulo.getText().equals("")) {
				JOptionPane.showMessageDialog(objVista,
						"Uno o varios de los campos obligatorios NO han sido rellenados ", "Mensaje de ERROR",
						JOptionPane.ERROR_MESSAGE);
			} else {
				try {
					String sentencia= "INSERT INTO articulos (nombreArticulo, descripcionArticulo, precioArticulo, stockArticulo) VALUES ('"+objVista.txtNombreAlta.getText()+"','"+objVista.txtAreaDescripcionArticulo.getText()+"','"+Double.parseDouble(objVista.txtPrecioArticulo.getText())+"','"+Integer.parseInt(objVista.txtStockArticulo.getText())+"');";
					objModelo.conectaBase();
					objModelo.datosABM(sentencia);
					objModelo.desconectaBase();
					int opcion = JOptionPane.showConfirmDialog(objVista,"El artículo ha sido dado de alta correctamente.¿Desea hacer otra alta?", "Confirmación",
							JOptionPane.YES_NO_OPTION);
					if (opcion == JOptionPane.YES_OPTION) {
						objModelo.borrarTxt(objVista.txtNombreAlta);
						objModelo.borrarTxtArea(objVista.txtAreaDescripcionArticulo);
						objModelo.borrarTxt(objVista.txtPrecioArticulo);
						objModelo.borrarTxt(objVista.txtStockArticulo);
					} else {
						// Elimina la ventana
						objVista.dispose();
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(objVista,
							"No se ha podido realizar el alta correctamente. Revise los datos y vuelva a intentarlo.",
							"Mensaje de ERROR", JOptionPane.ERROR_MESSAGE);
				}

			}

		}

		if (objVista.btnBorrarAltaArticulo.equals(e.getSource())) {
			// Elimina lo que este escrito en los diferentes campos
			objModelo.borrarTxt(objVista.txtNombreAlta);
			objModelo.borrarTxtArea(objVista.txtAreaDescripcionArticulo);
			objModelo.borrarTxt(objVista.txtPrecioArticulo);
			objModelo.borrarTxt(objVista.txtStockArticulo);
		}

		if (objVista.btnCancelarAltaArticulo.equals(e.getSource())) {
			// Elimina la ventana
			objVista.dispose();
		}

	}
}
