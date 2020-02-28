package es.studium.Ticket;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import es.studium.DITiendecitaT6.Modelo;

/**
 * <h1>Clase ControladorAltaTicket</h1>
 * <p>Clase que controla {@link VistaAltaTicket} y le da funcionalidad.</p>
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
 * 			<li>{@link #sentenciaRellenarColumnas}</li>
 * 		</ul>
 * 	</li>
 *  <li>Tipo Integer: 
 * 		<ul>
 * 			<li>{@link #celdaTabla}</li>
 * 		</ul>
 * 	</li>
 * <li>Otros: 
 * 		<ul>
 * 			<li>{@link #resultado}</li>
 * 			<li>{@link #fechaHora}</li>
 * 			<li>{@link #fechaHoraFormato}</li>
 * 		</ul>
 * 	</li>
 * </ul>
 * <p><b>Metodos:</b></p>
 * <ul>
 * 	<li>{@link #ControladorAltaTicket()}</li>
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
public class ControladorAltaTicket implements ActionListener, MouseListener {

	/** 
	 * <h1>Objeto objVista </h1>
	 * <p>Objeto de la clase {@link VistaAltaTicket}</p>
	 * */
	VistaAltaTicket objVista = new VistaAltaTicket();
	
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
	 * <h1>Variable celdaTabla</h1>
	 * <p>Variable de tipo {@link Integer} que contine el ID de una celda en una tabla.</p>
	 */
	int celdaTabla = -1;
	
	/** 
	 * <h1>Variable fechaHora</h1>
	 * <p>Variable de tipo {@link Date}.</p>
	 */
	/* >> FECHA ORDENADOR << */
	Date fechaHora = new Date();
	
	/** 
	 * <h1>Variable fechaHoraFormato</h1>
	 * <p>Variable de tipo {@link DateFormat} que determina el formato que tendrá la fecha.</p>
	 */
	DateFormat fechaHoraFormato = new SimpleDateFormat("dd-MM-yyyy");
	
	/** 
	 * <h1>Variable sentenciaRellenarArticulos</h1>
	 * <p>Variable de tipo {@link String} que contine una sentencia SQL.</p>
	 */
	// RELLENAR LISTA ARTÍCULOS
	String sentenciaRellenarArticulos = "SELECT idArticulo, nombreArticulo, precioArticulo, stockArticulo FROM articulos ORDER BY 2;";
	
	/** 
	 * <h1>Variable sentenciaRellenarColumnas</h1>
	 * <p>Variable de tipo {@link String} que contine una sentencia SQL.</p>
	 */
	// RELLENAR LISTA ARTÍCULOS
	String sentenciaRellenarColumnas = "SELECT idArticulo AS 'ID', nombreArticulo AS 'ARTICULO', stockArticulo AS 'STOCK', precioArticulo AS 'PRECIO €' FROM articulos;";

	/**
	 * <h1>Constructor por defecto</h1>
	 * <p>Constructor por defecto de la clase {@link ControladorAltaTicket}.</p>
	 * <p>Rellena la lista y la tabla la clase {@link VistaAltaTicket}. <br> Añade {@link ActionListener} a los siguientes componentes de la clase {@link VistaAltaTicket}:</p>
	 * <ul>
	 * 	<li>{@link VistaAltaTicket#btnBuscarTicket btnBuscarTicket}</li>
	 * 	<li>{@link VistaAltaTicket#btnAgregarArticulo btnAgregarArticulo}</li>
	 * 	<li>{@link VistaAltaTicket#btnEliminarArticuloTicket btnEliminarArticuloTicket}</li>
	 * 	<li>{@link VistaAltaTicket#btnAltaTicket btnAltaTicket}</li>
	 *  <li>{@link VistaAltaTicket#btnBorrarTicket btnBorrarTicket}</li>
	 *  <li>{@link VistaAltaTicket#btnCancelarTicket btnCancelarTicket}</li>
	 * </ul>
	 * <p>Añade {@link MouseListener} a los siguientes componentes de la clase {@link VistaAltaTicket}:</p>
	 * <ul>
	 * 	<li>{@link VistaAltaTicket#listaArticulosTicket listaArticulosTicket}</li>
	 *  <li>{@link VistaAltaTicket#tablaCompraTicket tablaCompraTicket}</li>
	 * </ul>
	 */
	public ControladorAltaTicket() {
		// Añadimos la fecha actual
		objVista.lblFechaTicket.setText(fechaHoraFormato.format(fechaHora));
		// Añadimos Articulos a la lista
		try {
			objModelo.conectaBase();
			objModelo.rellenarLista(sentenciaRellenarArticulos, objVista.modeloListaArticulosTicket);
			objModelo.desconectaBase();
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(objVista, "Algo ha fallado. Revise la base de datos y vuelva a intentarlo.",
					"Mensaje de ERROR", JOptionPane.ERROR_MESSAGE);
		}
		// Añadimos los nombres a las columnas
		objModelo.conectaBase();
		objModelo.rellenarColumnaTabla(sentenciaRellenarColumnas, objVista.tablaCompraTicket);
		objModelo.desconectaBase();
		// Añadimos los escuchadores
		objVista.btnBuscarTicket.addActionListener(this);
		objVista.listaArticulosTicket.addMouseListener(this);
		objVista.btnAgregarArticulo.addActionListener(this);
		objVista.tablaCompraTicket.addMouseListener(this);
		objVista.btnEliminarArticuloTicket.addActionListener(this);
		objVista.btnAltaTicket.addActionListener(this);
		objVista.btnBorrarTicket.addActionListener(this);
		objVista.btnCancelarTicket.addActionListener(this);
	}

	/**
	 * <h1>Mouse clicked</h1>
	 * <p>Método de la interfaz {@link MouseListener}. Capta cuando se pulsa sobre la lista o la tabla de la clase {@link VistaAltaTicket}</p>
	 * @param e - Parámetro de tipo {@link MouseEvent}
	 */
	@Override
	public void mouseClicked(MouseEvent e) {

		if (e.getSource().equals(objVista.listaArticulosTicket)) {
			objVista.lblArticuloSeleccionadoTicket.setText(objVista.listaArticulosTicket.getSelectedValue());
		}
		if (e.getSource().equals(objVista.tablaCompraTicket)) {
			celdaTabla = objVista.tablaCompraTicket.rowAtPoint(e.getPoint());
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
	 * <p>Método de la interfaz {@link ActionListener}. Según el componente de la clase {@link VistaAltaTicket} pulsado:</p>
	 * <ul>
	 * 	<li>- Buscará un artículo en la lista.</li>
	 *  <li>- Agregará un artículo a la tabla de compra.</li>
	 *  <li>- Eliminará un artículo a la tabla de compra.</li>
	 *  <li>- Hará el <u>alta</u> de un ticket a la base de datos.</li>
	 *  <li>- Reiniciará los campos de la ventana</li>
	 *  <li>- Cerrará la ventana</li>
	 * </ul>
	 * @param e - Parámetro de tipo {@link ActionEvent}
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		if (objVista.btnBuscarTicket.equals(e.getSource())) {
			objVista.modeloListaArticulosTicket.removeAllElements();
			String sentenciaBuscarBaja = "SELECT idArticulo, nombreArticulo, precioArticulo, stockArticulo FROM articulos WHERE concat(idArticulo, nombreArticulo, precioArticulo) LIKE '%"
					+ objVista.txtBuscarTicket.getText() + "%' ORDER BY 2;";
			objModelo.conectaBase();
			objModelo.buscarDatos(sentenciaBuscarBaja);
			objModelo.rellenarLista(sentenciaBuscarBaja, objVista.modeloListaArticulosTicket);
			objModelo.desconectaBase();
		}

		if (objVista.btnAgregarArticulo.equals(e.getSource())) {
			if (objVista.lblArticuloSeleccionadoTicket.getText().equals("")) {
				JOptionPane.showMessageDialog(objVista, "NO ha sido seleccionado ningún artículo", "Mensaje de ERROR",
						JOptionPane.ERROR_MESSAGE);
			} else if (objVista.txtCantidadTicket.getText().equals("")
					|| (objModelo.esNumero(objVista.txtCantidadTicket.getText())) == false) {
				JOptionPane.showMessageDialog(objVista, "NO ha introducido ninguna cantidad", "Mensaje de ERROR",
						JOptionPane.ERROR_MESSAGE);
			} else {
				String[] listaDato = objVista.lblArticuloSeleccionadoTicket.getText().split(" ");
				String total = objModelo.agregarArtCompra(listaDato[1], objVista.txtCantidadTicket.getText(),
						objVista.tablaCompraTicket);
				objVista.lblTotalTicket.setText(total);
				objVista.lblArticuloSeleccionadoTicket.setText("");
				objModelo.borrarTxt(objVista.txtBuscarTicket);
				objModelo.borrarTxt(objVista.txtCantidadTicket);
				objVista.modeloListaArticulosTicket.removeAllElements();
				try {
					objModelo.conectaBase();
					objModelo.rellenarLista(sentenciaRellenarArticulos, objVista.modeloListaArticulosTicket);
					objModelo.desconectaBase();
				} catch (Exception e1) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(objVista,
							"Algo ha fallado. Revise la base de datos y vuelva a intentarlo.", "Mensaje de ERROR",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		}

		if (objVista.btnEliminarArticuloTicket.equals(e.getSource())) {
			if (objVista.tablaCompraTicket.getSelectedRow() == -1) {
				JOptionPane.showMessageDialog(objVista, "NO ha sido seleccionado ningún artículo", "Mensaje de ERROR",
						JOptionPane.ERROR_MESSAGE);
			} else {
				int opcion = JOptionPane.showConfirmDialog(objVista,
						"Â¿EstÃ¡ seguro de eliminar este artículo del ticket?", "Eliminar artículo",
						JOptionPane.YES_NO_OPTION);
				if (opcion == JOptionPane.YES_OPTION) {
					objVista.modeloTablaCompraTicket.removeRow(celdaTabla);
					JOptionPane.showMessageDialog(objVista, "El artículo ha sido eliminado correctamente",
							"ConfirmaciÃ³n", JOptionPane.INFORMATION_MESSAGE);
				}
			}

		}

		if (objVista.btnAltaTicket.equals(e.getSource())) {
			if (objVista.modeloTablaCompraTicket.getRowCount() < 1) {
				JOptionPane.showMessageDialog(objVista, "NO hay ningún artículo en el ticket", "Mensaje de ERROR",
						JOptionPane.ERROR_MESSAGE);
			} else {
				String sentenciaAltaTicket = "INSERT INTO tickets (fechaTicket, totalTicket) VALUES ('"
						+ objModelo.formatoFechaSQL(objVista.lblFechaTicket.getText()) + "','" + objModelo.formatoDecimalSQL(objVista.lblTotalTicket.getText()) + "');";
				String sentenciaIdTicket = "SELECT idTicket FROM tickets ORDER BY 1 DESC LIMIT 1;";
				
				try {
					objModelo.conectaBase();
					objModelo.datosABM(sentenciaAltaTicket);
					resultado = objModelo.buscarDatos(sentenciaIdTicket);
					resultado.next();
					String idTicket = resultado.getString(1);
					for(int i=0; i<objVista.modeloTablaCompraTicket.getRowCount();i++) {
						String sentenciaAltaCompra = "INSERT INTO compras (idTicketFK, idArticuloFK, cantidadCompraArticulo) VALUES('"+idTicket+"','"+objVista.modeloTablaCompraTicket.getValueAt(i, 0)+"','"+objVista.modeloTablaCompraTicket.getValueAt(i, 4)+"');";
						objModelo.datosABM(sentenciaAltaCompra);
						int stockNuevo = Integer.parseInt((String) objVista.modeloTablaCompraTicket.getValueAt(i, 2))-Integer.parseInt((String)objVista.modeloTablaCompraTicket.getValueAt(i, 4));
						String sentenciaModificar ="UPDATE articulos SET stockArticulo='"+stockNuevo+"' WHERE idArticulo='"+objVista.modeloTablaCompraTicket.getValueAt(i, 0)+"';";
						objModelo.datosABM(sentenciaModificar);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				objModelo.desconectaBase();
				int opcion2 = JOptionPane.showConfirmDialog(objVista,
						"El ticket ha sido dado de alta correctamente.¿Desea realizar otro alta?", "Alta ticket",
						JOptionPane.YES_NO_OPTION);
				if (opcion2 == JOptionPane.YES_OPTION) {
					objVista.modeloListaArticulosTicket.removeAllElements();
					try {
						objModelo.conectaBase();
						objModelo.rellenarLista(sentenciaRellenarArticulos, objVista.modeloListaArticulosTicket);
						objModelo.desconectaBase();
					} catch (Exception e1) {
						// TODO: handle exception
						JOptionPane.showMessageDialog(objVista,
								"Algo ha fallado. Revise la base de datos y vuelva a intentarlo.", "Mensaje de ERROR",
								JOptionPane.ERROR_MESSAGE);
					}
					objVista.modeloTablaCompraTicket.setRowCount(0);
					objModelo.borrarTxt(objVista.txtBuscarTicket);
					objVista.lblTotalTicket.setText("");
					objVista.lblArticuloSeleccionadoTicket.setText("");
					objVista.lblTotalTicket.setText("");
				} else {
					// Elimina la ventana
					objVista.dispose();
				}
			}
		}

		if (objVista.btnBorrarTicket.equals(e.getSource())) {
			objVista.modeloListaArticulosTicket.removeAllElements();
			try {
				objModelo.conectaBase();
				objModelo.rellenarLista(sentenciaRellenarArticulos, objVista.modeloListaArticulosTicket);
				objModelo.desconectaBase();
			} catch (Exception e1) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(objVista,
						"Algo ha fallado. Revise la base de datos y vuelva a intentarlo.", "Mensaje de ERROR",
						JOptionPane.ERROR_MESSAGE);
			}
			objVista.modeloTablaCompraTicket.setRowCount(0);
			objModelo.borrarTxt(objVista.txtBuscarTicket);
			objVista.lblTotalTicket.setText("");
			objVista.lblArticuloSeleccionadoTicket.setText("");
			objVista.lblTotalTicket.setText("");
		}

		if (objVista.btnCancelarTicket.equals(e.getSource())) {
			// Elimina la ventana
			objVista.dispose();
		}

	}

}
