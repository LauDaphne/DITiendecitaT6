package es.studium.Articulo;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

public class VistaAltaArticulo extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField txtNombreAlta;
	public JTextField txtPrecioArticulo;
	public JTextField txtStockArticulo;
	public JButton btnAltaArticulo;
	public JButton btnBorrarAltaArticulo;
	public JButton btnCancelarAltaArticulo;
	public JTextArea txtAreaDescripcionArticulo;

	/**
	 * Create the frame.
	 */
	public VistaAltaArticulo() {
		setTitle("Alta Art\u00EDculo");
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 384, 396);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblAltaArtculo = new JLabel("Alta Art\u00EDculo");
		lblAltaArtculo.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		lblAltaArtculo.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblAltaArtculo.setForeground(new Color(255, 255, 255));
		lblAltaArtculo.setOpaque(true);
		lblAltaArtculo.setHorizontalTextPosition(SwingConstants.CENTER);
		lblAltaArtculo.setFocusable(false);
		lblAltaArtculo.setBackground(new Color(0, 139, 139));
		lblAltaArtculo.setHorizontalAlignment(SwingConstants.CENTER);
		lblAltaArtculo.setBounds(-3, 0, 371, 49);
		contentPane.add(lblAltaArtculo);
		
		JLabel lblNombre = new JLabel("*Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNombre.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		lblNombre.setBounds(40, 74, 67, 14);
		contentPane.add(lblNombre);
		
		JLabel lblDescripcin = new JLabel("Descripci\u00F3n:");
		lblDescripcin.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDescripcin.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		lblDescripcin.setBounds(24, 105, 84, 14);
		contentPane.add(lblDescripcin);
		
		JLabel lblPrecio = new JLabel("*Precio:");
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPrecio.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		lblPrecio.setBounds(49, 229, 67, 14);
		contentPane.add(lblPrecio);
		
		JLabel lblStock = new JLabel("*Stock:");
		lblStock.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblStock.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		lblStock.setBounds(59, 259, 57, 14);
		contentPane.add(lblStock);
		
		txtNombreAlta = new JTextField();
		txtNombreAlta.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 139, 139)));
		txtNombreAlta.setBackground(SystemColor.menu);
		txtNombreAlta.setBounds(119, 71, 195, 20);
		contentPane.add(txtNombreAlta);
		txtNombreAlta.setColumns(10);
		
		txtPrecioArticulo = new JTextField();
		txtPrecioArticulo.setColumns(10);
		txtPrecioArticulo.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 139, 139)));
		txtPrecioArticulo.setBackground(SystemColor.menu);
		txtPrecioArticulo.setBounds(128, 226, 60, 20);
		contentPane.add(txtPrecioArticulo);
		
		txtStockArticulo = new JTextField();
		txtStockArticulo.setColumns(10);
		txtStockArticulo.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 139, 139)));
		txtStockArticulo.setBackground(SystemColor.menu);
		txtStockArticulo.setBounds(128, 256, 60, 20);
		contentPane.add(txtStockArticulo);
		
		JLabel label = new JLabel("\u20AC");
		label.setBounds(196, 229, 20, 14);
		contentPane.add(label);
		
		JLabel lblUduds = new JLabel("Ud./Uds.");
		lblUduds.setBounds(196, 259, 52, 14);
		contentPane.add(lblUduds);
		
		btnAltaArticulo = new JButton("Dar de Alta");
		btnAltaArticulo.setBorder(new LineBorder(new Color(0, 139, 139)));
		btnAltaArticulo.setBounds(33, 300, 100, 25);
		contentPane.add(btnAltaArticulo);
		
		btnBorrarAltaArticulo = new JButton("Borrar");
		btnBorrarAltaArticulo.setBorder(new LineBorder(new Color(0, 139, 139)));
		btnBorrarAltaArticulo.setBounds(151, 300, 90, 25);
		contentPane.add(btnBorrarAltaArticulo);
		
		btnCancelarAltaArticulo = new JButton("Cancelar");
		btnCancelarAltaArticulo.setBorder(new LineBorder(new Color(0, 139, 139)));
		btnCancelarAltaArticulo.setBounds(260, 300, 90, 25);
		contentPane.add(btnCancelarAltaArticulo);
		
		JLabel lblObligatorios = new JLabel("* Datos obligatorios");
		lblObligatorios.setBounds(139, 336, 121, 14);
		contentPane.add(lblObligatorios);
		
		txtAreaDescripcionArticulo = new JTextArea();
		txtAreaDescripcionArticulo.setBorder(new LineBorder(Color.GRAY));
		txtAreaDescripcionArticulo.setBounds(118, 105, 195, 115);
		contentPane.add(txtAreaDescripcionArticulo);
		
		setVisible(true);
	}
}
