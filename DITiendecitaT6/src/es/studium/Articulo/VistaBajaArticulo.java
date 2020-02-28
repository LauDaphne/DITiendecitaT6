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

/**
 * <h1>Clase VistaBajaArticulo </h1>
 * <p>Clase que hereda de {@link JFrame}, creando la parte gráfica de la baja de artículos. </p>
 * <p><b>Variables:</b></p>
 * <ul>
 *  <li>Tipo Componente: 
 * 		<ul>
 * 			<li>{@link #contentPane}</li>
 * 			<li>{@link #txtBuscarBajaArticulo}</li>
 *  		<li>{@link #txtBajaArticuloElegido}</li>
 *   		<li>{@link #btnBuscar}</li>
 *    		<li>{@link #btnDarDeBaja}</li>
 *     		<li>{@link #btnBorrarBajaArticulo}</li>
 *      	<li>{@link #btnCancelarBajaArticulo}</li>
 *      	<li>{@link #modeloListaArticulos}</li>
 *      	<li>{@link #listBajaArticulo}</li>
 *     		<li>{@link #scrollBaja}</li>
 * 		</ul>
 * 	</li>
 * </ul>
 * <p><b>Metodos:</b></p>
 * <ul>
 * 	<li>{@link #VistaBajaArticulo()}</li>
 * </ul>
 * @author Laura M. P.
 * @since 28/02/2020
 * @version 1.0
 */
public class VistaBajaArticulo extends JFrame {


	/** 
	 * <h1>Número de serie</h1>
	 * <p>Número de serie automático perteneciente a la clase {@link VistaBajaArticulo}</p>  
	 */
	private static final long serialVersionUID = 1L;
	
	/** 
	 * <h1>Componente contentPane</h1>
	 * <p>Componente de tipo {@link JPanel}</p>
	 */
	private JPanel contentPane;
	
	/** 
	 * <h1>Componente txtBuscarBajaArticulo</h1>
	 * <p>Componente de tipo {@link JTextField}. Nombre del artículo para buscar.</p>
	 * */
	public JTextField txtBuscarBajaArticulo;
	
	/** 
	 * <h1>Componente txtBajaArticuloElegido</h1>
	 * <p>Componente de tipo {@link JTextField}. Nombre del artículo para eliminar.</p>
	 * */
	public JTextField txtBajaArticuloElegido;
	
	/** 
	 * <h1>Componente btnBuscar</h1>
	 * <p>Componente de tipo {@link JButton}. Llama al método que busca un artículo.</p>
	 * */
	public JButton btnBuscar;
	
	/** 
	 * <h1>Componente btnDarDeBaja</h1>
	 * <p>Componente de tipo {@link JButton}. Llama al método que da de baja un artículo.</p>
	 * */
	public JButton btnDarDeBaja;
	
	/** 
	 * <h1>Componente btnBorrarBajaArticulo</h1>
	 * <p>Componente de tipo {@link JButton}. Llama al método que reinicia los campos.</p>
	 * */
	public JButton btnBorrarBajaArticulo;
	
	/** 
	 * <h1>Componente btnCancelarBajaArticulo</h1>
	 * <p>Componente de tipo {@link JButton}. Llama al método que cierra la ventana.</p>
	 * */
	public JButton btnCancelarBajaArticulo;
	
	/** 
	 * <h1>Componente modeloListaArticulos</h1>
	 * <p>Componente de tipo {@link DefaultListModel}.</p>
	 * */
	public DefaultListModel<String> modeloListaArticulos = new DefaultListModel<String>();
	
	/** 
	 * <h1>Componente listBajaArticulo</h1>
	 * <p>Componente de tipo {@link JList}. Contiene una lista de artículos.</p>
	 * */
	public JList<String> listBajaArticulo = new JList<String>(modeloListaArticulos);
	
	/** 
	 * <h1>Componente scrollBaja</h1>
	 * <p>Componente de tipo {@link JScrollPane}. Añadido a una lista de artículos.</p>
	 * */
	public JScrollPane scrollBaja = new JScrollPane(listBajaArticulo);



	/**
	 * <h1>Constructor por defecto</h1>
	 * <p>Constructor por defecto de la clase {@link VistaBajaArticulo}.<br> Crea una ventana con diferentes campos y botones que permitirán dar de baja un artículo.</p>
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
