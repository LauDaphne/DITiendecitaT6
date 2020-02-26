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

public class VistaModificacion1Articulo extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField txtBuscarModificacion;
	public JTextField txtArticuloModificacion;
	public JButton btnBuscarModificacion;
	public JButton btnModificar;
	public JButton btnBorrarModificacion;
	public JButton btnCancelarModificacion;
	public DefaultListModel<String> modeloListaArticulosMod = new DefaultListModel<String>();
	public JList<String> listModificacion= new JList<String>(modeloListaArticulosMod);;
	public JScrollPane scrollMod = new JScrollPane(listModificacion);

	/**
	 * Create the frame.
	 */
	
	public VistaModificacion1Articulo() {
		setTitle("Modificaci\u00F3n Art\u00EDculo");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 374, 408);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblModificacinArtculo = new JLabel("Modificaci\u00F3n Art\u00EDculo");
		lblModificacinArtculo.setOpaque(true);
		lblModificacinArtculo.setHorizontalTextPosition(SwingConstants.CENTER);
		lblModificacinArtculo.setHorizontalAlignment(SwingConstants.CENTER);
		lblModificacinArtculo.setForeground(Color.WHITE);
		lblModificacinArtculo.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblModificacinArtculo.setFocusable(false);
		lblModificacinArtculo.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		lblModificacinArtculo.setBackground(new Color(0, 139, 139));
		lblModificacinArtculo.setBounds(0, 0, 358, 49);
		contentPane.add(lblModificacinArtculo);
		
		txtBuscarModificacion = new JTextField();
		txtBuscarModificacion.setColumns(10);
		txtBuscarModificacion.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 139, 139)));
		txtBuscarModificacion.setBackground(SystemColor.menu);
		txtBuscarModificacion.setBounds(21, 64, 219, 25);
		contentPane.add(txtBuscarModificacion);
		
		btnBuscarModificacion = new JButton("Buscar");
		btnBuscarModificacion.setBorder(new LineBorder(new Color(0, 139, 139)));
		btnBuscarModificacion.setBounds(250, 64, 90, 25);
		contentPane.add(btnBuscarModificacion);
		
		listModificacion.setBorder(new LineBorder(Color.GRAY));
		scrollMod.setBounds(21, 103, 319, 137);
		contentPane.add(scrollMod);
		
		JLabel label = new JLabel("Art\u00EDculo seleccionado:");
		label.setBounds(21, 253, 129, 14);
		contentPane.add(label);
		
		txtArticuloModificacion = new JTextField();
		txtArticuloModificacion.setHorizontalAlignment(SwingConstants.CENTER);
		txtArticuloModificacion.setEditable(false);
		txtArticuloModificacion.setColumns(10);
		txtArticuloModificacion.setBorder(new LineBorder(Color.GRAY));
		txtArticuloModificacion.setBounds(21, 277, 319, 25);
		contentPane.add(txtArticuloModificacion);
		
		btnModificar = new JButton("Modificar...");
		btnModificar.setBorder(new LineBorder(new Color(0, 139, 139)));
		btnModificar.setBounds(21, 325, 100, 25);
		contentPane.add(btnModificar);
		
		btnBorrarModificacion = new JButton("Borrar");
		btnBorrarModificacion.setBorder(new LineBorder(new Color(0, 139, 139)));
		btnBorrarModificacion.setBounds(139, 325, 90, 25);
		contentPane.add(btnBorrarModificacion);
		
		btnCancelarModificacion = new JButton("Cancelar");
		btnCancelarModificacion.setBorder(new LineBorder(new Color(0, 139, 139)));
		btnCancelarModificacion.setBounds(250, 325, 90, 25);
		contentPane.add(btnCancelarModificacion);
		setVisible(true);
	}
}
