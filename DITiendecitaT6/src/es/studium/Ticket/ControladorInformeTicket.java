package es.studium.Ticket;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import es.studium.DITiendecitaT6.Modelo;

public class ControladorInformeTicket implements ActionListener {

	VistaInformeTicket objVista = new VistaInformeTicket();
	Modelo objModelo = new Modelo();
	String fechaI, fechaF;

	public ControladorInformeTicket() {
		// Añadimos los escuchadores
		objVista.bttnGenerarInforme.addActionListener(this);
		objVista.bttnLimpiar.addActionListener(this);
		objVista.bttnCancelar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(objVista.bttnGenerarInforme)) {
				fechaI = objVista.txtFechaInicio.getText();
				fechaF = objVista.txtFechaFin.getText();
				fechaI = objModelo.formatoFechaJasper(fechaI);
				fechaF = objModelo.formatoFechaJasper(fechaF);
				objModelo.generarJasperTicket(objVista, fechaI, fechaF);
				objVista.dispose();
		}
		
		if(e.getSource().equals(objVista.bttnLimpiar)) {
			objVista.txtFechaInicio.setText("");
			objVista.txtFechaFin.setText("");
		}
		
		if(e.getSource().equals(objVista.bttnCancelar)) {
			objVista.dispose();
		}

	}

}
