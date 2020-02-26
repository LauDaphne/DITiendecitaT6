package es.studium.Ticket;

import java.awt.Font;
import java.awt.Label;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

public class VistaInformeTicket extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JButton bttnGenerarInforme;
	public JTextField txtFechaInicio;
	public JTextField txtFechaFin;
	public JButton bttnLimpiar;
	public JButton bttnCancelar;

	

	/**
	 * Create the frame.
	 */
	public VistaInformeTicket() {
		setTitle("Informe Tickets");
		setResizable(false);
		setBounds(100, 100, 304, 193);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		Label label = new Label("Fecha Desde:");
		label.setFont(new Font("Dialog", Font.PLAIN, 12));
		label.setBounds(31, 20, 90, 22);
		contentPane.add(label);
		
		Label label_1 = new Label("Fecha Hasta:");
		label_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		label_1.setBounds(33, 69, 90, 22);
		contentPane.add(label_1);
		
		bttnGenerarInforme = new JButton("Generar");
		bttnGenerarInforme.setName("bttnGenerarTicket");
		bttnGenerarInforme.setBounds(10, 120, 88, 22);
		contentPane.add(bttnGenerarInforme);
		
		txtFechaInicio = new JTextField();
		txtFechaInicio.setName("");
		txtFechaInicio.setBounds(123, 20, 127, 20);
		contentPane.add(txtFechaInicio);
		txtFechaInicio.setColumns(10);
		
		txtFechaFin = new JTextField();
		txtFechaFin.setBounds(123, 69, 127, 20);
		contentPane.add(txtFechaFin);
		txtFechaFin.setColumns(10);
		
		Label label_2 = new Label("*Formato: dd/mm/yyyy");
		label_2.setFont(new Font("Dialog", Font.PLAIN, 10));
		label_2.setBounds(141, 92, 127, 22);
		contentPane.add(label_2);
		
		Label label_3 = new Label("*Formato: dd/mm/yyyy");
		label_3.setFont(new Font("Dialog", Font.PLAIN, 10));
		label_3.setBounds(140, 41, 127, 22);
		contentPane.add(label_3);
		
		bttnLimpiar = new JButton("Limpiar");
		bttnLimpiar.setName("bttnGenerarTicket");
		bttnLimpiar.setBounds(100, 120, 82, 22);
		contentPane.add(bttnLimpiar);
		
		bttnCancelar = new JButton("Cancelar");
		bttnCancelar.setName("bttnGenerarTicket");
		bttnCancelar.setBounds(185, 120, 90, 22);
		contentPane.add(bttnCancelar);
		
		setVisible(true);
	}
}
