package es.studium.Articulo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import es.studium.DITiendecitaT6.Modelo;

/**
 * <h1>Clase ControladorModificacion1Articulo</h1>
 * <p>Clase que controla {@link VistaModificacion1Articulo} y le da funcionalidad.</p>
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
 * 	<li>{@link #ControladorModificacion1Articulo()}</li>
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
public class ControladorModificacion1Articulo implements ActionListener, MouseListener {

	/** 
	 * <h1>Objeto objVista </h1>
	 * <p>Objeto de la clase {@link VistaModificacion1Articulo}</p>
	 * */
	VistaModificacion1Articulo objVista = new VistaModificacion1Articulo();
	
	/** 
	 * <h1>Objeto objModelo </h1>
	 * <p>Objeto de la clase {@link Modelo}</p>
	 * */
	Modelo objModelo = new Modelo();
	
	/** 
	 * <h1>Variable sentenciaRellenarArticulos</h1>
	 * <p>Variable de tipo {@link String} que contine una sentencia SQL.</p>
	 */
	String sentenciaRellenarArticulos = "SELECT idArticulo, nombreArticulo, precioArticulo, stockArticulo FROM articulos ORDER BY 2;";

	/**
	 * <h1>Constructor por defecto</h1>
	 * <p>Constructor por defecto de la clase {@link ControladorModificacion1Articulo}.</p>
	 * <p>Rellena la lista la clase {@link VistaModificacion1Articulo}. <br> Añade {@link ActionListener} a los siguientes componentes de la clase {@link VistaModificacion1Articulo}:</p>
	 * <ul>
	 * 	<li>{@link VistaModificacion1Articulo#btnBuscarModificacion btnBuscarModificacion}</li>
	 * 	<li>{@link VistaModificacion1Articulo#btnModificar btnModificar}</li>
	 * 	<li>{@link VistaModificacion1Articulo#btnBorrarModificacion btnBorrarModificacion}</li>
	 * 	<li>{@link VistaModificacion1Articulo#btnCancelarModificacion btnCancelarModificacion}</li>
	 * </ul>
	 * <p>Añade {@link MouseListener} a los siguientes componentes de la clase {@link VistaModificacion1Articulo}:</p>
	 * <ul>
	 * 	<li>{@link VistaModificacion1Articulo#listModificacion listModificacion}</li>
	 * </ul>
	 */
	public ControladorModificacion1Articulo() {
		// AÃ±adimos Articulos a la lista
		try {
			objModelo.conectaBase();
			objModelo.rellenarLista(sentenciaRellenarArticulos, objVista.modeloListaArticulosMod);
			objModelo.desconectaBase();
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(objVista, "Algo ha fallado. Revise la base de datos y vuelva a intentarlo.",
					"Mensaje de ERROR", JOptionPane.ERROR_MESSAGE);
		}
		// AÃ±adimos los escuchadores
		objVista.btnBuscarModificacion.addActionListener(this);
		objVista.listModificacion.addMouseListener(this);
		objVista.btnModificar.addActionListener(this);
		objVista.btnBorrarModificacion.addActionListener(this);
		objVista.btnCancelarModificacion.addActionListener(this);

	}

	/**
	 * <h1>Mouse clicked</h1>
	 * <p>Método de la interfaz {@link MouseListener}. Capta cuando se pulsa sobre la lista de la clase {@link VistaModificacion1Articulo}</p>
	 * @param e - Parámetro de tipo {@link MouseEvent}
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource().equals(objVista.listModificacion)) {
			objVista.txtArticuloModificacion.setText(objVista.listModificacion.getSelectedValue());
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

	/**
	 * <h1>Action performed</h1>
	 * <p>Método de la interfaz {@link ActionListener}. Según el componente de la clase {@link VistaModificacion1Articulo} pulsado:</p>
	 * <ul>
	 * 	<li>- Buscará un artículo en la lista.</li>
	 *  <li>- Abrirá un objeto de la clase {@link ControladorModificacion2Articulo}.</li>
	 *  <li>- Reiniciará los campos de la ventana</li>
	 *  <li>- Cerrará la ventana</li>
	 * </ul>
	 * @param e - Parámetro de tipo {@link ActionEvent}
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		if (objVista.btnBuscarModificacion.equals(e.getSource())) {
			objVista.modeloListaArticulosMod.removeAllElements();
			String sentenciaBuscarBaja = "SELECT idArticulo, nombreArticulo, precioArticulo, stockArticulo FROM articulos WHERE concat(idArticulo, nombreArticulo, precioArticulo) LIKE '%"
					+ objVista.txtBuscarModificacion.getText() + "%' ORDER BY 2;";
			objModelo.conectaBase();
			objModelo.buscarDatos(sentenciaBuscarBaja);
			objModelo.rellenarLista(sentenciaBuscarBaja, objVista.modeloListaArticulosMod);
			objModelo.desconectaBase();
		}

		if (objVista.btnModificar.equals(e.getSource())) {
			if (!objVista.txtArticuloModificacion.getText().equals("")) {
				String[] listaDato = objVista.txtArticuloModificacion.getText().split(" ");
				new ControladorModificacion2Articulo(listaDato[1]);
				// Elimina la ventana
				objVista.setVisible(false);
				objVista.dispose();
			} else {
				JOptionPane.showMessageDialog(objVista, "NO ha sido seleccionado ningún artículo", "Mensaje de ERROR",
						JOptionPane.ERROR_MESSAGE);
			}

		}

		if (objVista.btnBorrarModificacion.equals(e.getSource())) {
			try {
				objModelo.borrarTxt(objVista.txtBuscarModificacion);
				objVista.modeloListaArticulosMod.removeAllElements();
				objModelo.conectaBase();
				objModelo.rellenarLista(sentenciaRellenarArticulos, objVista.modeloListaArticulosMod);
				objModelo.desconectaBase();
				objModelo.borrarTxt(objVista.txtArticuloModificacion);
			} catch (Exception e2) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(objVista,
						"Algo ha fallado. Revise la base de datos y vuelva a intentarlo.", "Mensaje de ERROR",
						JOptionPane.ERROR_MESSAGE);
			}
				
		}

		if (objVista.btnCancelarModificacion.equals(e.getSource())) {
			// Elimina la ventana
			objVista.dispose();
		}

	}

}
