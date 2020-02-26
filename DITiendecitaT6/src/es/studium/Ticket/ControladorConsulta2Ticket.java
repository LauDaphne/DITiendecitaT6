package es.studium.Ticket;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import es.studium.DITiendecitaT6.Modelo;

public class ControladorConsulta2Ticket implements ActionListener{
	
	VistaConsulta2Ticket objVista = new VistaConsulta2Ticket();
	Modelo objModelo = new Modelo();
	
	ControladorConsulta2Ticket(String idTicket, String fecha, String total){
		String sentencia ="SELECT idArticulo AS 'ID', nombreArticulo AS 'ARTICULO', cantidadCompraArticulo AS 'CANTIDAD', precioArticulo AS 'PRECIO' FROM articulos, compras WHERE idArticulo=idArticuloFK AND idTicketFK='"+idTicket+"';";
		//Rellenamos la tabla
		objModelo.conectaBase();
		objModelo.rellenarTabla(sentencia, objVista.tblConsultaArtTicket);
		objModelo.desconectaBase();
		//Rellenamos los labels
		objVista.lblTitulo.setText("Ticket: "+idTicket);
		objVista.lblFechaTicket.setText(fecha);
		objVista.lblTotalTicket.setText(total);
		// Añadimos los escuchadores
		objVista.btnCancelar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (objVista.btnCancelar.equals(e.getSource())) {
			// Elimina la ventana
			objVista.dispose();
		}
	}
}
