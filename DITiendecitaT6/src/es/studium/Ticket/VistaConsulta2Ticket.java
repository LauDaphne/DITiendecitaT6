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

/**
 * <h1>Clase VistaConsulta2Ticket </h1>
 * <p>Clase que hereda de {@link JFrame}, creando la segunda parte gráfica de la consulta de tickets. En la que vemos los detalles de un ticket especifico. </p>
 * <p><b>Variables:</b></p>
 * <ul>
 *  <li>Tipo Componente: 
 * 		<ul>
 * 			<li>{@link #contentPane}</li>
 * 			<li>{@link #modeloTablaArtTicket}</li>
 *  		<li>{@link #tblConsultaArtTicket}</li>
 *   		<li>{@link #lblTitulo}</li>
 *    		<li>{@link #lblFechaTicket}</li>
 *     		<li>{@link #lblTotalTicket}</li>
 *      	<li>{@link #btnCancelar}</li>
 * 		</ul>
 * 	</li>
 * </ul>
 * <p><b>Metodos:</b></p>
 * <ul>
 * 	<li>{@link #VistaConsulta2Ticket()}</li>
 * </ul>
 * @author Laura M. P.
 * @since 28/02/2020
 * @version 1.0
 */
public class VistaConsulta2Ticket extends JFrame {

	/** 
	 * <h1>Número de serie</h1>
	 * <p>Número de serie automático perteneciente a la clase {@link VistaConsulta2Ticket}</p>  
	 */
	private static final long serialVersionUID = 1L;
	
	/** 
	 * <h1>Componente contentPane</h1>
	 * <p>Componente de tipo {@link JPanel}</p>
	 */
	private JPanel contentPane;
	
	/** 
	 * <h1>Componente modeloTablaArtTicket</h1>
	 * <p>Componente de tipo {@link DefaultTableModel}.</p>
	 * */
	public DefaultTableModel modeloTablaArtTicket= new DefaultTableModel();
	
	/** 
	 * <h1>Componente tblConsultaArtTicket</h1>
	 * <p>Componente de tipo {@link JTable}. Contiene una tabla de artículos.</p>
	 * */
	public JTable tblConsultaArtTicket= new JTable(modeloTablaArtTicket);
	
	/** 
	 * <h1>Componente lblTitulo</h1>
	 * <p>Componente de tipo {@link JLabel}. Título de la ventana.</p>
	 * */
	public JLabel lblTitulo;
	
	/** 
	 * <h1>Componente lblFechaTicket</h1>
	 * <p>Componente de tipo {@link JLabel}. Fecha de creación del ticket.</p>
	 * */
	public JLabel lblFechaTicket;
	
	/** 
	 * <h1>Componente lblTotalTicket</h1>
	 * <p>Componente de tipo {@link JLabel}. Precio total del ticket.</p>
	 * */
	public JLabel lblTotalTicket;
	
	/** 
	 * <h1>Componente btnCancelar</h1>
	 * <p>Componente de tipo {@link JButton}. Llama al método que cierra la ventana.</p>
	 * */
	public JButton btnCancelar;

	/**
	 * <h1>Constructor por defecto</h1>
	 * <p>Constructor por defecto de la clase {@link VistaConsulta2Ticket}.<br> Crea una ventana con diferentes campos y botones que permitirán consultar los artículo que tiene un ticket.</p>
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
