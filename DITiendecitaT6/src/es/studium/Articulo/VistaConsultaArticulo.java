package es.studium.Articulo;

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

public class VistaConsultaArticulo extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JButton btnAceptarConsultaArticulo;
	public DefaultTableModel modeloTablaArticulo= new DefaultTableModel();
	public JTable tblConsultaArticulo= new JTable(modeloTablaArticulo);
	public JScrollPane scrollTablaArticulo = new JScrollPane(tblConsultaArticulo);

	/**
	 * Create the frame.
	 */
	public VistaConsultaArticulo() {
		setResizable(false);
		setTitle("Consulta Art\u00EDculo");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 317);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		
		JLabel lblConsultaArtculo = new JLabel("Consulta Art\u00EDculo");
		lblConsultaArtculo.setOpaque(true);
		lblConsultaArtculo.setHorizontalTextPosition(SwingConstants.CENTER);
		lblConsultaArtculo.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsultaArtculo.setForeground(Color.WHITE);
		lblConsultaArtculo.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblConsultaArtculo.setFocusable(false);
		lblConsultaArtculo.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		lblConsultaArtculo.setBackground(new Color(0, 139, 139));
		lblConsultaArtculo.setBounds(0, 0, 434, 49);
		contentPane.add(lblConsultaArtculo);
		
		tblConsultaArticulo.setBorder(new LineBorder(Color.GRAY));
		tblConsultaArticulo.setEnabled(false);
		contentPane.add(scrollTablaArticulo);
		scrollTablaArticulo.setBounds(10, 60, 412, 174);
		
		btnAceptarConsultaArticulo = new JButton("Aceptar");
		btnAceptarConsultaArticulo.setBorder(new LineBorder(new Color(0, 139, 139)));
		btnAceptarConsultaArticulo.setBounds(157, 245, 90, 25);
		contentPane.add(btnAceptarConsultaArticulo);
		setVisible(true);
	}
}
