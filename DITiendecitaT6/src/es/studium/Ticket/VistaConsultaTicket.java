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
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

public class VistaConsultaTicket extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JButton btnMostrarTicket;
	public DefaultTableModel modeloTablaTicket= new DefaultTableModel();
	public JTable tblConsultaTicket= new JTable(modeloTablaTicket){
		private static final long serialVersionUID = 1L;
		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}
	};
	public JScrollPane scrollTablaTicket = new JScrollPane(tblConsultaTicket);
	public JButton btnCancelar = new JButton("Cancelar");
	
	/**
	 * Create the frame.
	 */
	public VistaConsultaTicket() {
		setResizable(false);
		setTitle("Consulta Ticket");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 322);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblConsultaTicket = new JLabel("Consulta Ticket");
		lblConsultaTicket.setOpaque(true);
		lblConsultaTicket.setHorizontalTextPosition(SwingConstants.CENTER);
		lblConsultaTicket.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsultaTicket.setForeground(Color.WHITE);
		lblConsultaTicket.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblConsultaTicket.setFocusable(false);
		lblConsultaTicket.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		lblConsultaTicket.setBackground(new Color(0, 139, 139));
		lblConsultaTicket.setBounds(0, 0, 434, 49);
		contentPane.add(lblConsultaTicket);
		
		tblConsultaTicket.setBorder(new LineBorder(Color.GRAY));

		
		contentPane.add(scrollTablaTicket);
		scrollTablaTicket.setBounds(10, 60, 412, 174);
		
		btnMostrarTicket = new JButton("Mostrar Ticket");
		btnMostrarTicket.setBorder(new LineBorder(new Color(0, 139, 139)));
		btnMostrarTicket.setBounds(95, 245, 97, 25);
		contentPane.add(btnMostrarTicket);
		btnCancelar.setBorder(new LineBorder(new Color(0, 139, 139)));
		btnCancelar.setBounds(241, 245, 97, 25);
		
		contentPane.add(btnCancelar);
		setVisible(true);
	}

}
