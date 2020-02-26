package es.studium.Articulo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import es.studium.DITiendecitaT6.Modelo;

public class ControladorModificacion2Articulo implements ActionListener {

	VistaModificacion2Articulo objVista = new VistaModificacion2Articulo();
	Modelo objModelo = new Modelo();
	ResultSet resultado;
	String idArticulo;

	ControladorModificacion2Articulo(String idArticulo) {
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
