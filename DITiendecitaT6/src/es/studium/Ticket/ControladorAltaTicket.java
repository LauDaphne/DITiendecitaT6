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

public class ControladorAltaTicket implements ActionListener, MouseListener {

	VistaAltaTicket objVista = new VistaAltaTicket();
	Modelo objModelo = new Modelo();
	ResultSet resultado;
	int celdaTabla = -1;
	/* >> FECHA ORDENADOR << */
	Date fechaHora = new Date();
	DateFormat fechaHoraFormato = new SimpleDateFormat("dd-MM-yyyy");
	// RELLENAR LISTA ARTÍCULOS
	String sentenciaRellenarArticulos = "SELECT idArticulo, nombreArticulo, precioArticulo, stockArticulo FROM articulos ORDER BY 2;";
	// RELLENAR LISTA ARTÍCULOS
	String sentenciaRellenarColumnas = "SELECT idArticulo AS 'ID', nombreArticulo AS 'ARTICULO', stockArticulo AS 'STOCK', precioArticulo AS 'PRECIO €' FROM articulos;";

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

	@Override
	public void mouseClicked(MouseEvent e) {

		if (e.getSource().equals(objVista.listaArticulosTicket)) {
			objVista.lblArticuloSeleccionadoTicket.setText(objVista.listaArticulosTicket.getSelectedValue());
		}
		if (e.getSource().equals(objVista.tablaCompraTicket)) {
			celdaTabla = objVista.tablaCompraTicket.rowAtPoint(e.getPoint());
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

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
