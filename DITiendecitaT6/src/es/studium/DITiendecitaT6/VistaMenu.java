package es.studium.DITiendecitaT6;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

/**
 * <h1>Clase VistaMenu </h1>
 * <p>Clase que hereda de {@link JFrame}, creando la parte gráfica del Menú. </p>
 * <p><b>Variables:</b></p>
 * <ul>
 *  <li>Tipo Componente: 
 * 		<ul>
 * 			<li>{@link #contentPane}</li>
 * 			<li>{@link #itemAltaArticulo}</li>
 *  		<li>{@link #itemBajaArticulo}</li>
 *   		<li>{@link #itemModificacionArticulo}</li>
 *    		<li>{@link #itemConsultaArticulo}</li>
 *     		<li>{@link #itemAltaTicket}</li>
 *      	<li>{@link #itemConsultaTicket}</li>
 *      	<li>{@link #itemInformeTickets}</li>
 *      	<li>{@link #itemInformeArtculos}</li>
 * 		</ul>
 * 	</li>
 * </ul>
 * <p><b>Metodos:</b></p>
 * <ul>
 * 	<li>{@link #VistaMenu()}</li>
 * </ul>
 * @author Laura M. P.
 * @since 28/02/2020
 * @version 1.0
 */
public class VistaMenu extends JFrame {

	/** 
	 * <h1>Número de serie</h1>
	 * <p>Número de serie automático perteneciente a la clase {@link VistaMenu}</p>  
	 */
	private static final long serialVersionUID = 1L;
	
	/** 
	 * <h1>Componente contentPane</h1>
	 * <p>Componente de tipo {@link JPanel}</p>
	 * */
	private JPanel contentPane;
	
	/** 
	 * <h1>Componente itemAltaArticulo</h1>
	 * <p>Componente de tipo {@link JMenuItem}. Pertenece al {@link JMenu} de Artículos.</p>
	 * */
	public JMenuItem itemAltaArticulo;
	
	/** 
	 * <h1>Componente itemBajaArticulo</h1>
	 * <p>Componente de tipo {@link JMenuItem}. Pertenece al {@link JMenu} de Artículos.</p>
	 * */
	public JMenuItem itemBajaArticulo;
	
	/** 
	 * <h1>Componente itemModificacionArticulo</h1>
	 * <p>Componente de tipo {@link JMenuItem}. Pertenece al {@link JMenu} de Artículos.</p>
	 * */
	public JMenuItem itemModificacionArticulo;
	
	/** 
	 * <h1>Componente itemConsultaArticulo</h1>
	 * <p>Componente de tipo {@link JMenuItem}. Pertenece al {@link JMenu} de Artículos.</p>
	 * */
	public JMenuItem itemConsultaArticulo;
	
	/** 
	 * <h1>Componente itemAltaTicket</h1>
	 * <p>Componente de tipo {@link JMenuItem}. Pertenece al {@link JMenu} de Tickets.</p>
	 * */
	public JMenuItem itemAltaTicket;
	
	/** 
	 * <h1>Componente itemConsultaTicket</h1>
	 * <p>Componente de tipo {@link JMenuItem}. Pertenece al {@link JMenu} de Tickets.</p>
	 * */
	public JMenuItem itemConsultaTicket;
	
	/** 
	 * <h1>Componente itemInformeTickets</h1>
	 * <p>Componente de tipo {@link JMenuItem}. Pertenece al {@link JMenu} de Tickets.</p>
	 * */
	public JMenuItem itemInformeTickets;
	
	/** 
	 * <h1>Componente itemInformeArtculos</h1>
	 * <p>Componente de tipo {@link JMenuItem}. Pertenece al {@link JMenu} de Artículos.</p>
	 * */
	public JMenuItem itemInformeArtculos;


	/**
	 * <h1>Constructor por defecto</h1>
	 * <p>Constructor por defecto de la clase {@link VistaMenu}.<br> Crea una ventana para una tienda, con un menú integrado. El menú contiene dos secciones, la parte de Artículos y la parte de Tickets. Estas, a su vez, contienen algunas o todas las operaciones <b>CRUD</b>.</p>
	 */
	public VistaMenu() {
		setTitle("La Tiendecita");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnArtculos = new JMenu("Art\u00EDculos");
		menuBar.add(mnArtculos);
		
		itemAltaArticulo = new JMenuItem("Alta Art\u00EDculo...");
		mnArtculos.add(itemAltaArticulo);
		
		itemBajaArticulo = new JMenuItem("Baja Art\u00EDculo...");
		mnArtculos.add(itemBajaArticulo);
		
		itemModificacionArticulo = new JMenuItem("Modificaci\u00F3n Art\u00EDculo...");
		mnArtculos.add(itemModificacionArticulo);
		
		itemConsultaArticulo = new JMenuItem("Consulta Art\u00EDculos...");
		mnArtculos.add(itemConsultaArticulo);
		
		itemInformeArtculos = new JMenuItem("Informe Art\u00EDculos...");
		mnArtculos.add(itemInformeArtculos);
		
		JMenu mnTickets = new JMenu("Tickets");
		menuBar.add(mnTickets);
		
		itemAltaTicket = new JMenuItem("Alta Ticket...");
		mnTickets.add(itemAltaTicket);
		
		itemConsultaTicket = new JMenuItem("Consulta Ticket...");
		mnTickets.add(itemConsultaTicket);
		
		itemInformeTickets = new JMenuItem("Informe Tickets...");
		mnTickets.add(itemInformeTickets);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("La Tiendecita");
		lblNewLabel.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(112, 128, 144)));
		lblNewLabel.setForeground(new Color(0, 139, 139));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 34));
		lblNewLabel.setBounds(124, 54, 193, 35);
		contentPane.add(lblNewLabel);
		
		JLabel lbltuTiendaDe = new JLabel("<HTML><CENTER><p>Tu tienda de <u><i>confianza</i></u><br> y cada d\u00EDa <br> la de m\u00E1s gente</p></CENTER></HTML>");
		lbltuTiendaDe.setFont(new Font("HP Simplified Light", Font.BOLD, 20));
		lbltuTiendaDe.setHorizontalTextPosition(SwingConstants.CENTER);
		lbltuTiendaDe.setHorizontalAlignment(SwingConstants.CENTER);
		lbltuTiendaDe.setBounds(124, 100, 193, 92);
		contentPane.add(lbltuTiendaDe);
		
		setVisible(true);
	}
}
