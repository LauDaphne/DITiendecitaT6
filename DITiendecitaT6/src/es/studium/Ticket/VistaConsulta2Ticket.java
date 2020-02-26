package es.studium.Ticket;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;

public class VistaConsulta2Ticket extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public DefaultTableModel modeloTablaArtTicket= new DefaultTableModel();
	public JTable tblConsultaArtTicket= new JTable(modeloTablaArtTicket);
	public JLabel lblTitulo;
	public JLabel lblFechaTicket;
	public JLabel lblTotalTicket;
	public JButton btnCancelar;

	/**
	 * Create the frame.
	 */
	public VistaConsulta2Ticket() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 381);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		lblTitulo = new JLabel();
		lblTitulo.setOpaque(true);
		lblTitulo.setHorizontalTextPosition(SwingConstants.CENTER);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblTitulo.setFocusable(false);
		lblTitulo.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		lblTitulo.setBackground(new Color(0, 139, 139));
		lblTitulo.setBounds(0, 0, 434, 49);
		contentPane.add(lblTitulo);
		
		JScrollPane scrollPane = new JScrollPane(tblConsultaArtTicket);
		scrollPane.setBounds(10, 87, 412, 185);
		contentPane.add(scrollPane);
		tblConsultaArtTicket.setEnabled(false);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(10, 62, 46, 14);
		contentPane.add(lblFecha);
		
		lblFechaTicket = new JLabel();
		lblFechaTicket.setBounds(49, 62, 97, 14);
		contentPane.add(lblFechaTicket);
		
		lblTotalTicket = new JLabel();
		lblTotalTicket.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotalTicket.setBounds(335, 284, 87, 14);
		contentPane.add(lblTotalTicket);
		
		JLabel lblTotal = new JLabel("TOTAL:");
		lblTotal.setBounds(294, 284, 46, 14);
		contentPane.add(lblTotal);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBorder(new LineBorder(new Color(0, 139, 139)));
		btnCancelar.setBounds(165, 302, 97, 25);
		contentPane.add(btnCancelar);
		setVisible(true);
	}
}
