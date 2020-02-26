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

public class VistaMenu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JMenuItem itemAltaArticulo;
	public JMenuItem itemBajaArticulo;
	public JMenuItem itemModificacionArticulo;
	public JMenuItem itemConsultaArticulo;
	public JMenuItem itemAltaTicket;
	public JMenuItem itemConsultaTicket;
	public JMenuItem itemInformeTickets;
	public JMenuItem itemInformeArtculos;


	/**
	 * Create the frame.
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
