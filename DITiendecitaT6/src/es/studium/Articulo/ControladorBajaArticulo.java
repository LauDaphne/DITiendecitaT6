package es.studium.Articulo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import es.studium.DITiendecitaT6.Modelo;

/**
 * <h1>Clase ControladorBajaArticulo</h1>
 * <p>Clase que controla {@link VistaBajaArticulo} y le da funcionalidad.</p>
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
 * 			<li>{@link #sentenciaRellenarArticulos}</li>
 * 		</ul>
 * 	</li>
 * </ul>
 * <p><b>Metodos:</b></p>
 * <ul>
 * 	<li>{@link #ControladorBajaArticulo()}</li>
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
public class ControladorBajaArticulo implements ActionListener, MouseListener {

	/** 
	 * <h1>Objeto objVista </h1>
	 * <p>Objeto de la clase {@link VistaBajaArticulo}</p>
	 * */
	VistaBajaArticulo objVista = new VistaBajaArticulo();
	
	/** 
	 * <h1>Objeto objModelo </h1>
	 * <p>Objeto de la clase {@link Modelo}</p>
	 * */
	Modelo objModelo = new Modelo();
	
	/** 
	 * <h1>Variable sentenciaRellenarArticulos</h1>
	 * <p>Variable de tipo {@link String} que contine una sentencia SQL.</p>
	 */
	// RELLENAR LISTA ARTÍCULOS
	String sentenciaRellenarArticulos = "SELECT idArticulo, nombreArticulo, precioArticulo, stockArticulo FROM articulos ORDER BY 2;";

	/**
	 * <h1>Constructor por defecto</h1>
	 * <p>Constructor por defecto de la clase {@link ControladorBajaArticulo}.</p>
	 * <p>Rellena la lista la clase {@link VistaBajaArticulo}. <br> Añade {@link ActionListener} a los siguientes componentes de la clase {@link VistaBajaArticulo}:</p>
	 * <ul>
	 * 	<li>{@link VistaBajaArticulo#btnBuscar btnBuscar}</li>
	 * 	<li>{@link VistaBajaArticulo#btnDarDeBaja btnDarDeBaja}</li>
	 * 	<li>{@link VistaBajaArticulo#btnBorrarBajaArticulo btnBorrarBajaArticulo}</li>
	 * 	<li>{@link VistaBajaArticulo#btnCancelarBajaArticulo btnCancelarBajaArticulo}</li>
	 * </ul>
	 * <p>Añade {@link MouseListener} a los siguientes componentes de la clase {@link VistaBajaArticulo}:</p>
	 * <ul>
	 * 	<li>{@link VistaBajaArticulo#listBajaArticulo listBajaArticulo}</li>
	 * </ul>
	 */
	public ControladorBajaArticulo() {
		// Añadimos Articulos a la lista
		try {
			objModelo.conectaBase();
			objModelo.rellenarLista(sentenciaRellenarArticulos, objVista.modeloListaArticulos);
			objModelo.desconectaBase();
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(objVista, "Algo ha fallado. Revise la base de datos y vuelva a intentarlo.",
					"Mensaje de ERROR", JOptionPane.ERROR_MESSAGE);
		}

		// Añadimos los escuchadores
		objVista.btnBuscar.addActionListener(this);
		objVista.listBajaArticulo.addMouseListener(this);
		objVista.btnDarDeBaja.addActionListener(this);
		objVista.btnBorrarBajaArticulo.addActionListener(this);
		objVista.btnCancelarBajaArticulo.addActionListener(this);
	}


	/**
	 * <h1>Action performed</h1>
	 * <p>Método de la interfaz {@link ActionListener}. Según el componente de la clase {@link VistaBajaArticulo} pulsado:</p>
	 * <ul>
	 * 	<li>- Buscará un artículo en la lista.</li>
	 *  <li>- Hará la <u>baja</u> de un artículo en la base de datos.</li>
	 *  <li>- Reiniciará los campos de la ventana</li>
	 *  <li>- Cerrará la ventana</li>
	 * </ul>
	 * @param e - Parámetro de tipo {@link ActionEvent}
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		if (objVista.btnBuscar.equals(e.getSource())) {
			objVista.modeloListaArticulos.removeAllElements();
			String sentenciaBuscarBaja = "SELECT idArticulo, nombreArticulo, precioArticulo, stockArticulo FROM articulos WHERE concat(idArticulo, nombreArticulo, precioArticulo) LIKE '%"
					+ objVista.txtBuscarBajaArticulo.getText() + "%' ORDER BY 2;";
			objModelo.conectaBase();
			objModelo.buscarDatos(sentenciaBuscarBaja);
			objModelo.rellenarLista(sentenciaBuscarBaja, objVista.modeloListaArticulos);
			objModelo.desconectaBase();
		}

		if (objVista.btnDarDeBaja.equals(e.getSource())) {
			if (!objVista.txtBajaArticuloElegido.getText().equals("")) {
				try {
					int opcion = JOptionPane.showConfirmDialog(objVista, "¿Está seguro de eliminar este artículo?",
							"Dar de Baja", JOptionPane.YES_NO_OPTION);
					if (opcion == JOptionPane.YES_OPTION) {
						String[] listaDato = objVista.txtBajaArticuloElegido.getText().split(" ");
						String sentencia = "DELETE FROM articulos WHERE idArticulo = '" + listaDato[1] + "';";
						objModelo.conectaBase();
						objModelo.datosABM(sentencia);
						objModelo.desconectaBase();
						int opcion2 = JOptionPane.showConfirmDialog(objVista,
								"El artículo ha sido eliminado correctamente.¿Desea hacer otra baja?", "Confirmación",
								JOptionPane.YES_NO_OPTION);
						if (opcion2 == JOptionPane.YES_OPTION) {
							objModelo.borrarTxt(objVista.txtBuscarBajaArticulo);
							objVista.modeloListaArticulos.removeAllElements();
							objModelo.conectaBase();
							objModelo.rellenarLista(sentenciaRellenarArticulos, objVista.modeloListaArticulos);
							objModelo.desconectaBase();
							objModelo.borrarTxt(objVista.txtBajaArticuloElegido);
						} else {
							// Elimina la ventana
							objVista.dispose();
						}
					}
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(objVista,
							"Algo ha fallado. Revise la base de datos y vuelva a intentarlo.", "Mensaje de ERROR",
							JOptionPane.ERROR_MESSAGE);
				}

			} else {
				JOptionPane.showMessageDialog(objVista, "NO ha sido seleccionado ningún artículo", "Mensaje de ERROR",
						JOptionPane.ERROR_MESSAGE);
			}
		}

		if (objVista.btnBorrarBajaArticulo.equals(e.getSource())) {
			try {
				objModelo.borrarTxt(objVista.txtBuscarBajaArticulo);
				objVista.modeloListaArticulos.removeAllElements();
				objModelo.conectaBase();
				objModelo.rellenarLista(sentenciaRellenarArticulos, objVista.modeloListaArticulos);
				objModelo.desconectaBase();
				objModelo.borrarTxt(objVista.txtBajaArticuloElegido);
			} catch (Exception e2) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(objVista,
						"Algo ha fallado. Revise la base de datos y vuelva a intentarlo.", "Mensaje de ERROR",
						JOptionPane.ERROR_MESSAGE);
			}

		}

		if (objVista.btnCancelarBajaArticulo.equals(e.getSource())) {
			// Elimina la ventana
			objVista.dispose();
		}

	}

	/**
	 * <h1>Mouse clicked</h1>
	 * <p>Método de la interfaz {@link MouseListener}. Capta cuando se pulsa sobre la lista de la clase {@link VistaBajaArticulo}</p>
	 * @param e - Parámetro de tipo {@link MouseEvent}
	 */
	@Override
	public void mouseClicked(MouseEvent e) {

		if (e.getSource().equals(objVista.listBajaArticulo)) {
			objVista.txtBajaArticuloElegido.setText(objVista.listBajaArticulo.getSelectedValue());
		}

	}

	/**
	 * <h1>Mouse pressed</h1>
	 * <p>Método vacío de la interfaz {@link MouseListener}.</p>
	 * @param e - Parámetro de tipo {@link MouseEvent}
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * <h1>Mouse released</h1>
	 * <p>Método vacío de la interfaz {@link MouseListener}.</p>
	 * @param e - Parámetro de tipo {@link MouseEvent}
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * <h1>Mouse entered</h1>
	 * <p>Método vacío de la interfaz {@link MouseListener}.</p>
	 * @param e - Parámetro de tipo {@link MouseEvent}
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * <h1>Mouse exited</h1>
	 * <p>Método vacío de la interfaz {@link MouseListener}.</p>
	 * @param e - Parámetro de tipo {@link MouseEvent}
	 */
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
