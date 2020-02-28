package es.studium.Ticket;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

/**
 * <h1>Clase VistaAltaTicket </h1>
 * <p>Clase que hereda de {@link JFrame}, creando la parte gráfica del alta de tickets. </p>
 * <p><b>Variables:</b></p>
 * <ul>
 *  <li>Tipo Componente: 
 * 		<ul>
 * 			<li>{@link #contentPane}</li>
 * 			<li>{@link #txtBuscarTickettxt}</li>
 *  		<li>{@link #CantidadTicket}</li>
 *   		<li>{@link #lblFechaTicket}</li>
 *    		<li>{@link #modeloListaArticulosTicket}</li>
 *    		<li>{@link #listaArticulosTicket}</li>
 *  		<li>{@link #scrollArtTicket}</li>
 *   		<li>{@link #btnBuscarTicket}</li>
 *    		<li>{@link #lblArticuloSeleccionadoTicket}</li>
 *    		<li>{@link #btnAgregarArticulo}</li>
 *  		<li>{@link #modeloTablaCompraTicket}</li>
 *   		<li>{@link #tablaCompraTicket}</li>
 *    		<li>{@link #scrollCompTicket}</li>
 *    		<li>{@link #lblTotalTicket}</li>
 *  		<li>{@link #btnEliminarArticuloTicket}</li>
 *   		<li>{@link #btnAltaTicket}</li>
 *    		<li>{@link #btnBorrarTicket}</li>
 *    		<li>{@link #btnCancelarTicket}</li>
 * 		</ul>
 * 	</li>
 * </ul>
 * <p><b>Metodos:</b></p>
 * <ul>
 * 	<li>{@link #VistaAltaTicket()}</li>
 * </ul>
 * @author Laura M. P.
 * @since 28/02/2020
 * @version 1.0
 */
public class VistaAltaTicket extends JFrame {

	/** 
	 * <h1>Número de serie</h1>
	 * <p>Número de serie automático perteneciente a la clase {@link VistaAltaTicket}</p>  
	 */
	private static final long serialVersionUID = 1L;
	
	/** 
	 * <h1>Componente contentPane</h1>
	 * <p>Componente de tipo {@link JPanel}</p>
	 */
	private JPanel contentPane;
	
	/** 
	 * <h1>Componente txtBuscarTicket</h1>
	 * <p>Componente de tipo {@link JTextField}. Nombre del artículo para buscar.</p>
	 * */
	public JTextField txtBuscarTicket;
	
	/** 
	 * <h1>Componente txtCantidadTicket</h1>
	 * <p>Componente de tipo {@link JTextField}. Cantidad del artículo que compra.</p>
	 * */
	public JTextField txtCantidadTicket;
	
	/** 
	 * <h1>Componente lblFechaTicket</h1>
	 * <p>Componente de tipo {@link JLabel}. Fecha de la creación del ticket.</p>
	 * */
	public JLabel lblFechaTicket;
	
	/** 
	 * <h1>Componente modeloListaArticulosTicket</h1>
	 * <p>Componente de tipo {@link DefaultListModel}.</p>
	 * */
	public DefaultListModel<String> modeloListaArticulosTicket = new DefaultListModel<String>();
	
	/** 
	 * <h1>Componente listaArticulosTicket</h1>
	 * <p>Componente de tipo {@link JList}. Contiene una lista de artículos.</p>
	 * */
	public JList<String> listaArticulosTicket = new JList<String>(modeloListaArticulosTicket);;
	
	/** 
	 * <h1>Componente scrollArtTicket</h1>
	 * <p>Componente de tipo {@link JScrollPane}. Añadido a una lista de artículos.</p>
	 * */
	public JScrollPane scrollArtTicket = new JScrollPane(listaArticulosTicket);
	
	/** 
	 * <h1>Componente btnBuscarTicket</h1>
	 * <p>Componente de tipo {@link JButton}. Llama al método que busca un artículo.</p>
	 * */
	public JButton btnBuscarTicket;
	
	/** 
	 * <h1>Componente lblArticuloSeleccionadoTicket</h1>
	 * <p>Componente de tipo {@link JLabel}. Muestra el artículo seleccionado.</p>
	 * */
	public JLabel lblArticuloSeleccionadoTicket;
	
	/** 
	 * <h1>Componente btnAgregarArticulo</h1>
	 * <p>Componente de tipo {@link JButton}. Agrega un artículo al ticket.</p>
	 * */
	public JButton btnAgregarArticulo;
	
	/** 
	 * <h1>Componente modeloTablaCompraTicket</h1>
	 * <p>Componente de tipo {@link DefaultTableModel}. No permite la edición de la tabla pero si la pulsación de una fila.</p>
	 * */
	public DefaultTableModel modeloTablaCompraTicket = new DefaultTableModel(){
		private static final long serialVersionUID = 1L;
		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}
	};
	
	/** 
	 * <h1>Componente tablaCompraTicket</h1>
	 * <p>Componente de tipo {@link JTable}. Contiene una tabla de artículos.</p>
	 * */
	public JTable tablaCompraTicket= new JTable(modeloTablaCompraTicket);
	
	/** 
	 * <h1>Componente scrollCompTicket</h1>
	 * <p>Componente de tipo {@link JScrollPane}. Añadido a una tabla de artículos.</p>
	 * */
	public JScrollPane scrollCompTicket = new JScrollPane(tablaCompraTicket);
	
	/** 
	 * <h1>Componente lblTotalTicket</h1>
	 * <p>Componente de tipo {@link JLabel}. Muestra el precio total de un ticket.</p>
	 * */
	public JLabel lblTotalTicket;
	
	/** 
	 * <h1>Componente btnEliminarArticuloTicket</h1>
	 * <p>Componente de tipo {@link JButton}. Elimina un artículo de la tabla de compra.</p>
	 * */
	public JButton btnEliminarArticuloTicket;
	
	/** 
	 * <h1>Componente btnAltaTicket</h1>
	 * <p>Componente de tipo {@link JButton}. Llama al método que da de alta un ticket.</p>
	 * */
	public JButton btnAltaTicket;
	
	/** 
	 * <h1>Componente btnBorrarTicket</h1>
	 * <p>Componente de tipo {@link JButton}. Llama al método que reinicia los campos.</p>
	 * */
	public JButton btnBorrarTicket;
	
	/** 
	 * <h1>Componente btnCancelarTicket</h1>
	 * <p>Componente de tipo {@link JButton}. Llama al método que cierra la ventana.</p>
	 * */
	public JButton btnCancelarTicket;


	/**
	 * <h1>Constructor por defecto</h1>
	 * <p>Constructor por defecto de la clase {@link VistaAltaTicket}.<br> Crea una ventana con diferentes campos y botones que permitirán dar alta un ticket.</p>
	 */
	public VistaAltaTicket() {
		setResizable(false);
		setTitle("Alta Ticket");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 496);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAltaArtculo = new JLabel("Alta Ticket");
		lblAltaArtculo.setOpaque(true);
		lblAltaArtculo.setHorizontalTextPosition(SwingConstants.CENTER);
		lblAltaArtculo.setHorizontalAlignment(SwingConstants.CENTER);
		lblAltaArtculo.setForeground(Color.WHITE);
		lblAltaArtculo.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblAltaArtculo.setFocusable(false);
		lblAltaArtculo.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		lblAltaArtculo.setBackground(new Color(0, 139, 139));
		lblAltaArtculo.setBounds(0, 0, 684, 49);
		contentPane.add(lblAltaArtculo);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		lblFecha.setBounds(275, 75, 48, 14);
		contentPane.add(lblFecha);
		
		lblFechaTicket = new JLabel("");
		lblFechaTicket.setHorizontalAlignment(SwingConstants.CENTER);
		lblFechaTicket.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 139, 139)));
		lblFechaTicket.setBounds(327, 68, 67, 20);
		contentPane.add(lblFechaTicket);
		
		listaArticulosTicket.setBorder(new LineBorder(Color.GRAY));
		scrollArtTicket.setBounds(20, 128, 228, 202);
		contentPane.add(scrollArtTicket);
		
		txtBuscarTicket = new JTextField();
		txtBuscarTicket.setBounds(20, 97, 140, 20);
		contentPane.add(txtBuscarTicket);
		txtBuscarTicket.setColumns(10);
		
		btnBuscarTicket = new JButton("Buscar");
		btnBuscarTicket.setBorder(new LineBorder(new Color(0, 139, 139)));
		btnBuscarTicket.setBounds(170, 92, 78, 25);
		contentPane.add(btnBuscarTicket);
		
		JLabel lblArticulo = new JLabel("Art\u00EDculo:");
		lblArticulo.setBounds(18, 345, 59, 15);
		contentPane.add(lblArticulo);
		
		lblArticuloSeleccionadoTicket = new JLabel();
		lblArticuloSeleccionadoTicket.setHorizontalAlignment(SwingConstants.CENTER);
		lblArticuloSeleccionadoTicket.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 139, 139)));
		lblArticuloSeleccionadoTicket.setBounds(75, 345, 173, 15);
		contentPane.add(lblArticuloSeleccionadoTicket);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setBounds(20, 379, 72, 15);
		contentPane.add(lblCantidad);
		
		txtCantidadTicket = new JTextField();
		txtCantidadTicket.setBounds(78, 376, 73, 20);
		contentPane.add(txtCantidadTicket);
		txtCantidadTicket.setColumns(10);
		
		JLabel lblUduds = new JLabel("Ud./Uds.");
		lblUduds.setBounds(155, 379, 48, 14);
		contentPane.add(lblUduds);
		
		btnAgregarArticulo = new JButton("Agregar");
		btnAgregarArticulo.setBorder(new LineBorder(new Color(0, 139, 139)));
		btnAgregarArticulo.setBounds(82, 415, 78, 25);
		contentPane.add(btnAgregarArticulo);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(265, 66, 8, 374);
		contentPane.add(separator);
		
		JLabel lblTicket = new JLabel("Ticket");
		lblTicket.setBounds(283, 100, 48, 15);
		contentPane.add(lblTicket);
		
		tablaCompraTicket.setBorder(new LineBorder(Color.GRAY));
		scrollCompTicket.setBounds(280, 127, 379, 202);
		contentPane.add(scrollCompTicket);
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setBounds(519, 340, 48, 14);
		contentPane.add(lblTotal);
		
		lblTotalTicket = new JLabel("");
		lblTotalTicket.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTotalTicket.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalTicket.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 139, 139)));
		lblTotalTicket.setBounds(556, 340, 73, 17);
		contentPane.add(lblTotalTicket);
		
		JLabel label_3 = new JLabel("\u20AC");
		label_3.setBounds(639, 340, 20, 14);
		contentPane.add(label_3);
		
		btnEliminarArticuloTicket = new JButton("Eliminar art\u00EDculo del ticket\r\n");
		btnEliminarArticuloTicket.setBorder(new LineBorder(new Color(0, 139, 139)));
		btnEliminarArticuloTicket.setBounds(387, 370, 167, 25);
		contentPane.add(btnEliminarArticuloTicket);
		
		btnAltaTicket = new JButton("Dar de Alta");
		btnAltaTicket.setBorder(new LineBorder(new Color(0, 139, 139)));
		btnAltaTicket.setBounds(276, 415, 100, 25);
		contentPane.add(btnAltaTicket);
		
		btnBorrarTicket = new JButton("Borrar");
		btnBorrarTicket.setBorder(new LineBorder(new Color(0, 139, 139)));
		btnBorrarTicket.setBounds(430, 415, 90, 25);
		contentPane.add(btnBorrarTicket);
		
		btnCancelarTicket = new JButton("Cancelar");
		btnCancelarTicket.setBorder(new LineBorder(new Color(0, 139, 139)));
		btnCancelarTicket.setBounds(569, 415, 90, 25);
		contentPane.add(btnCancelarTicket);
		setVisible(true);
	}
}
