package es.studium.Articulo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import es.studium.DITiendecitaT6.Modelo;

public class ControladorConsultaArticulo implements ActionListener {

	VistaConsultaArticulo objVista = new VistaConsultaArticulo();
	Modelo objModelo = new Modelo();
	// RELLENAR TABLA
	String sentenciaRellenarTabla = "SELECT idArticulo AS 'ID', nombreArticulo AS 'NOMBRE ARTICULO', precioArticulo AS 'PRECIO �', stockArticulo AS 'N� STOCK' FROM articulos ORDER BY 1;";

	public ControladorConsultaArticulo() {
		//A�adimos datos a la tabla
		objModelo.conectaBase();
		objModelo.rellenarTabla(sentenciaRellenarTabla, objVista.tblConsultaArticulo);
		objModelo.desconectaBase();
		// A�adimos los escuchadores
		objVista.btnAceptarConsultaArticulo.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (objVista.btnAceptarConsultaArticulo.equals(e.getSource())) {
			// Elimina la ventana
			objVista.dispose();
		}

	}

}
