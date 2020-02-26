package es.studium.Articulo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import es.studium.DITiendecitaT6.Modelo;

public class ControladorAltaArticulo implements ActionListener {

	VistaAltaArticulo objVista = new VistaAltaArticulo();
	Modelo objModelo = new Modelo();

	public ControladorAltaArticulo() {
		// Añadimos los escuchadores
		objVista.btnAltaArticulo.addActionListener(this);
		objVista.btnBorrarAltaArticulo.addActionListener(this);
		objVista.btnCancelarAltaArticulo.addActionListener(this);
	}

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
