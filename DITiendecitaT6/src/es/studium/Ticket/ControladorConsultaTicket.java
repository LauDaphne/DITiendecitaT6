package es.studium.Ticket;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import es.studium.DITiendecitaT6.Modelo;

public class ControladorConsultaTicket implements ActionListener, MouseListener {

	VistaConsultaTicket objVista = new VistaConsultaTicket();
	Modelo objModelo = new Modelo();
	int celdaTabla = -1;
	// RELLENAR TABLA
	String sentenciaRellenarTabla = "SELECT idTicket AS 'ID', DATE_FORMAT(fechaTicket, \"%d-%m-%Y\") AS 'FECHA', SUM(cantidadCompraArticulo) AS 'CANTIDAD UDS', totalTicket AS 'PRECIO TOTAL' FROM tickets, compras WHERE idTicket=idTicketFK GROUP BY idTicketFK ORDER BY 1;";
	public ControladorConsultaTicket() {
		//Añadimos datos a la tabla
				objModelo.conectaBase();
				objModelo.rellenarTabla(sentenciaRellenarTabla, objVista.tblConsultaTicket);
				objModelo.desconectaBase();
		// Añadimos los escuchadores
		objVista.btnMostrarTicket.addActionListener(this);
		objVista.btnCancelar.addActionListener(this);
		objVista.tblConsultaTicket.addMouseListener(this);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (objVista.btnCancelar.equals(e.getSource())) {
			// Elimina la ventana
			objVista.dispose();
		}
		
		if (objVista.btnMostrarTicket.equals(e.getSource())) {
			celdaTabla=objVista.tblConsultaTicket.getSelectedRow();
			if(celdaTabla==-1) {
				JOptionPane.showMessageDialog(objVista, "NO ha sido seleccionado ningún ticket", "Mensaje de ERROR",
						JOptionPane.ERROR_MESSAGE);
			}else {
				new ControladorConsulta2Ticket((String) objVista.tblConsultaTicket.getValueAt(celdaTabla, 0),(String) objVista.tblConsultaTicket.getValueAt(celdaTabla,1),(String) objVista.tblConsultaTicket.getValueAt(celdaTabla,3));
			}
			
		}

	}


	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource().equals(objVista.tblConsultaTicket)) {
			celdaTabla = objVista.tblConsultaTicket.rowAtPoint(e.getPoint());
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
