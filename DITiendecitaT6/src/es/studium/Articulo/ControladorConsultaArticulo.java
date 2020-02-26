package es.studium.Articulo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import es.studium.DITiendecitaT6.Modelo;

public class ControladorConsultaArticulo implements ActionListener {

	VistaConsultaArticulo objVista = new VistaConsultaArticulo();
	Modelo objModelo = new Modelo();
	// RELLENAR TABLA
	String sentenciaRellenarTabla = "SELECT idArticulo AS 'ID', nombreArticulo AS 'NOMBRE ARTICULO', precioArticulo AS 'PRECIO €', stockArticulo AS 'Nº STOCK' FROM articulos ORDER BY 1;";

	public ControladorConsultaArticulo() {
		//Añadimos datos a la tabla
		objModelo.conectaBase();
		objModelo.rellenarTabla(sentenciaRellenarTabla, objVista.tblConsultaArticulo);
		objModelo.desconectaBase();
		// Añadimos los escuchadores
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
