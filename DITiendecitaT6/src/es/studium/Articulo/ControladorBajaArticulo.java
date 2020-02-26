package es.studium.Articulo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import es.studium.DITiendecitaT6.Modelo;

public class ControladorBajaArticulo implements ActionListener, MouseListener {

	VistaBajaArticulo objVista = new VistaBajaArticulo();
	Modelo objModelo = new Modelo();
	// RELLENAR LISTA ARTÍCULOS
	String sentenciaRellenarArticulos = "SELECT idArticulo, nombreArticulo, precioArticulo, stockArticulo FROM articulos ORDER BY 2;";

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

	@Override
	public void mouseClicked(MouseEvent e) {

		if (e.getSource().equals(objVista.listBajaArticulo)) {
			objVista.txtBajaArticuloElegido.setText(objVista.listBajaArticulo.getSelectedValue());
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

}
