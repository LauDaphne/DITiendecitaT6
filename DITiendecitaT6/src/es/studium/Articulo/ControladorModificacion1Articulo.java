package es.studium.Articulo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import es.studium.DITiendecitaT6.Modelo;

public class ControladorModificacion1Articulo implements ActionListener, MouseListener {

	VistaModificacion1Articulo objVista = new VistaModificacion1Articulo();
	Modelo objModelo = new Modelo();
	String sentenciaRellenarArticulos = "SELECT idArticulo, nombreArticulo, precioArticulo, stockArticulo FROM articulos ORDER BY 2;";

	public ControladorModificacion1Articulo() {
		// AÃ±adimos Articulos a la lista
		try {
			objModelo.conectaBase();
			objModelo.rellenarLista(sentenciaRellenarArticulos, objVista.modeloListaArticulosMod);
			objModelo.desconectaBase();
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(objVista, "Algo ha fallado. Revise la base de datos y vuelva a intentarlo.",
					"Mensaje de ERROR", JOptionPane.ERROR_MESSAGE);
		}
		// AÃ±adimos los escuchadores
		objVista.btnBuscarModificacion.addActionListener(this);
		objVista.listModificacion.addMouseListener(this);
		objVista.btnModificar.addActionListener(this);
		objVista.btnBorrarModificacion.addActionListener(this);
		objVista.btnCancelarModificacion.addActionListener(this);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource().equals(objVista.listModificacion)) {
			objVista.txtArticuloModificacion.setText(objVista.listModificacion.getSelectedValue());
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

		if (objVista.btnBuscarModificacion.equals(e.getSource())) {
			objVista.modeloListaArticulosMod.removeAllElements();
			String sentenciaBuscarBaja = "SELECT idArticulo, nombreArticulo, precioArticulo, stockArticulo FROM articulos WHERE concat(idArticulo, nombreArticulo, precioArticulo) LIKE '%"
					+ objVista.txtBuscarModificacion.getText() + "%' ORDER BY 2;";
			objModelo.conectaBase();
			objModelo.buscarDatos(sentenciaBuscarBaja);
			objModelo.rellenarLista(sentenciaBuscarBaja, objVista.modeloListaArticulosMod);
			objModelo.desconectaBase();
		}

		if (objVista.btnModificar.equals(e.getSource())) {
			if (!objVista.txtArticuloModificacion.getText().equals("")) {
				String[] listaDato = objVista.txtArticuloModificacion.getText().split(" ");
				new ControladorModificacion2Articulo(listaDato[1]);
				// Elimina la ventana
				objVista.setVisible(false);
				objVista.dispose();
			} else {
				JOptionPane.showMessageDialog(objVista, "NO ha sido seleccionado ningún artículo", "Mensaje de ERROR",
						JOptionPane.ERROR_MESSAGE);
			}

		}

		if (objVista.btnBorrarModificacion.equals(e.getSource())) {
			try {
				objModelo.borrarTxt(objVista.txtBuscarModificacion);
				objVista.modeloListaArticulosMod.removeAllElements();
				objModelo.conectaBase();
				objModelo.rellenarLista(sentenciaRellenarArticulos, objVista.modeloListaArticulosMod);
				objModelo.desconectaBase();
				objModelo.borrarTxt(objVista.txtArticuloModificacion);
			} catch (Exception e2) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(objVista,
						"Algo ha fallado. Revise la base de datos y vuelva a intentarlo.", "Mensaje de ERROR",
						JOptionPane.ERROR_MESSAGE);
			}
				
		}

		if (objVista.btnCancelarModificacion.equals(e.getSource())) {
			// Elimina la ventana
			objVista.dispose();
		}

	}

}
