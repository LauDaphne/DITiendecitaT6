package es.studium.Articulo;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

public class VistaBajaArticulo extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField txtBuscarBajaArticulo;
	public JTextField txtBajaArticuloElegido;
	public JButton btnBuscar;
	public JButton btnDarDeBaja;
	public JButton btnBorrarBajaArticulo;
	public JButton btnCancelarBajaArticulo;
	public DefaultListModel<String> modeloListaArticulos = new DefaultListModel<String>();
	public JList<String> listBajaArticulo = new JList<String>(modeloListaArticulos);
	public JScrollPane scrollBaja = new JScrollPane(listBajaArticulo);



	/**
	 * Create the frame.
	 */
	public VistaBajaArticulo() {
		setResizable(false);
		setTitle("Baja Art\u00EDculo");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 354, 399);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblBajaArtculo = new JLabel("Baja Art\u00EDculo");
		lblBajaArtculo.setOpaque(true);
		lblBajaArtculo.setHorizontalTextPosition(SwingConstants.CENTER);
		lblBajaArtculo.setHorizontalAlignment(SwingConstants.CENTER);
		lblBajaArtculo.setForeground(Color.WHITE);
		lblBajaArtculo.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblBajaArtculo.setFocusable(false);
		lblBajaArtculo.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		lblBajaArtculo.setBackground(new Color(0, 139, 139));
		lblBajaArtculo.setBounds(0, 0, 342, 49);
		contentPane.add(lblBajaArtculo);
		
		txtBuscarBajaArticulo = new JTextField();
		txtBuscarBajaArticulo.setBackground(SystemColor.menu);
		txtBuscarBajaArticulo.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 139, 139)));
		txtBuscarBajaArticulo.setBounds(10, 60, 219, 25);
		contentPane.add(txtBuscarBajaArticulo);
		txtBuscarBajaArticulo.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBorder(new LineBorder(new Color(0, 139, 139)));
		btnBuscar.setBounds(239, 60, 90, 25);
		contentPane.add(btnBuscar);
		
		
		listBajaArticulo.setBorder(new LineBorder(Color.GRAY));
		scrollBaja.setBounds(10, 99, 319, 137);
		contentPane.add(scrollBaja);
		
		JLabel lblArtculoSeleccionado = new JLabel("Art\u00EDculo seleccionado:");
		lblArtculoSeleccionado.setBounds(10, 249, 129, 14);
		contentPane.add(lblArtculoSeleccionado);
		
		txtBajaArticuloElegido = new JTextField();
		txtBajaArticuloElegido.setHorizontalAlignment(SwingConstants.CENTER);
		txtBajaArticuloElegido.setEditable(false);
		txtBajaArticuloElegido.setBorder(new LineBorder(Color.GRAY));
		txtBajaArticuloElegido.setBounds(10, 273, 319, 25);
		contentPane.add(txtBajaArticuloElegido);
		txtBajaArticuloElegido.setColumns(10);
		
		btnDarDeBaja = new JButton("Dar de Baja");
		btnDarDeBaja.setBorder(new LineBorder(new Color(0, 139, 139)));
		btnDarDeBaja.setBounds(10, 321, 100, 25);
		contentPane.add(btnDarDeBaja);
		
		btnBorrarBajaArticulo = new JButton("Borrar");
		btnBorrarBajaArticulo.setBorder(new LineBorder(new Color(0, 139, 139)));
		btnBorrarBajaArticulo.setBounds(128, 321, 90, 25);
		contentPane.add(btnBorrarBajaArticulo);
		
		btnCancelarBajaArticulo = new JButton("Cancelar");
		btnCancelarBajaArticulo.setBorder(new LineBorder(new Color(0, 139, 139)));
		btnCancelarBajaArticulo.setBounds(239, 321, 90, 25);
		contentPane.add(btnCancelarBajaArticulo);
		setVisible(true);
	}
}
