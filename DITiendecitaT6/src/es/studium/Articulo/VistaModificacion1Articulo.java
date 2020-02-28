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
 * <h1>Clase VistaModificacion1Articulo </h1>
 * <p>Clase que hereda de {@link JFrame}, creando la primera parte gráfica de la modificación de artículos. </p>
 * <p><b>Variables:</b></p>
 * <ul>
 *  <li>Tipo Componente: 
 * 		<ul>
 * 			<li>{@link #contentPane}</li>
 * 			<li>{@link #txtBuscarModificacion}</li>
 *  		<li>{@link #txtArticuloModificacion}</li>
 *   		<li>{@link #btnBuscarModificacion}</li>
 *    		<li>{@link #btnModificar}</li>
 *   		<li>{@link #btnBorrarModificacion}</li>
 *    		<li>{@link #btnCancelarModificacion}</li>
 *    		<li>{@link #modeloListaArticulosMod}</li>
 *    		<li>{@link #listModificacion}</li>
 *    		<li>{@link #scrollMod}</li>
 * 		</ul>
 * 	</li>
 * </ul>
 * <p><b>Metodos:</b></p>
 * <ul>
 * 	<li>{@link #VistaModificacion1Articulo()}</li>
 * </ul>
 * @author Laura M. P.
 * @since 28/02/2020
 * @version 1.0
 */
public class VistaModificacion1Articulo extends JFrame {


	/** 
	 * <h1>Número de serie</h1>
	 * <p>Número de serie automático perteneciente a la clase {@link VistaModificacion1Articulo}</p>  
	 */
	private static final long serialVersionUID = 1L;
	
	/** 
	 * <h1>Componente contentPane</h1>
	 * <p>Componente de tipo {@link JPanel}</p>
	 */
	private JPanel contentPane;
	
	/** 
	 * <h1>Componente txtBuscarModificacion</h1>
	 * <p>Componente de tipo {@link JTextField}. Nombre del artículo para buscar.</p>
	 * */
	public JTextField txtBuscarModificacion;
	
	/** 
	 * <h1>Componente txtArticuloModificacion</h1>
	 * <p>Componente de tipo {@link JTextField}. Nombre del artículo para modificar.</p>
	 * */
	public JTextField txtArticuloModificacion;
	
	/** 
	 * <h1>Componente btnBuscarModificacion</h1>
	 * <p>Componente de tipo {@link JButton}. Llama al método que busca un artículo.</p>
	 * */
	public JButton btnBuscarModificacion;
	
	/** 
	 * <h1>Componente btnModificar</h1>
	 * <p>Componente de tipo {@link JButton}. Llama al método que abre el objeto {@link ControladorModificacion2Articulo}.</p>
	 * */
	public JButton btnModificar;
	
	/** 
	 * <h1>Componente btnBorrarModificacion</h1>
	 * <p>Componente de tipo {@link JButton}. Llama al método que reinicia los campos.</p>
	 * */
	public JButton btnBorrarModificacion;
	
	/** 
	 * <h1>Componente btnCancelarModificacion</h1>
	 * <p>Componente de tipo {@link JButton}. Llama al método que cierra la ventana.</p>
	 * */
	public JButton btnCancelarModificacion;
	
	/** 
	 * <h1>Componente modeloListaArticulosMod</h1>
	 * <p>Componente de tipo {@link DefaultListModel}.</p>
	 * */
	public DefaultListModel<String> modeloListaArticulosMod = new DefaultListModel<String>();
	
	/** 
	 * <h1>Componente listModificacion</h1>
	 * <p>Componente de tipo {@link JList}. Contiene una lista de artículos.</p>
	 * */
	public JList<String> listModificacion= new JList<String>(modeloListaArticulosMod);;
	
	/** 
	 * <h1>Componente scrollMod</h1>
	 * <p>Componente de tipo {@link JScrollPane}. Añadido a una lista de artículos.</p>
	 * */
	public JScrollPane scrollMod = new JScrollPane(listModificacion);

	/**
	 * <h1>Constructor por defecto</h1>
	 * <p>Constructor por defecto de la clase {@link VistaModificacion1Articulo}.<br> Crea una ventana con diferentes campos y botones que permitirán buscar un artículo para modificarlo.</p>
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
