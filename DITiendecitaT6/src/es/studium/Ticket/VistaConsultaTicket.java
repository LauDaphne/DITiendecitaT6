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
 * <h1>Clase VistaConsultaTicket </h1>
 * <p>Clase que hereda de {@link JFrame}, creando la primera parte gráfica de la consulta de tickets.</p>
 * <p><b>Variables:</b></p>
 * <ul>
 *  <li>Tipo Componente: 
 * 		<ul>
 * 			<li>{@link #contentPane}</li>
 * 			<li>{@link #btnMostrarTicket}</li>
 *  		<li>{@link #modeloTablaTicket}</li>
 *   		<li>{@link #tblConsultaTicket}</li>
 *    		<li>{@link #scrollTablaTicket}</li>
 *     		<li>{@link #btnCancelar}</li>
 * 		</ul>
 * 	</li>
 * </ul>
 * <p><b>Metodos:</b></p>
 * <ul>
 * 	<li>{@link #VistaConsultaTicket()}</li>
 * </ul>
 * @author Laura M. P.
 * @since 28/02/2020
 * @version 1.0
 */
public class VistaConsultaTicket extends JFrame {


	/** 
	 * <h1>Número de serie</h1>
	 * <p>Número de serie automático perteneciente a la clase {@link VistaConsultaTicket}</p>  
	 */
	private static final long serialVersionUID = 1L;
	
	/** 
	 * <h1>Componente contentPane</h1>
	 * <p>Componente de tipo {@link JPanel}</p>
	 */
	private JPanel contentPane;
	
	/** 
	 * <h1>Componente btnMostrarTicket</h1>
	 * <p>Componente de tipo {@link JButton}. Llama a un método que abre un objeto de la clase {@link ControladorConsulta2Ticket}.</p>
	 * */
	public JButton btnMostrarTicket;
	
	/** 
	 * <h1>Componente modeloTablaArtTicket</h1>
	 * <p>Componente de tipo {@link DefaultTableModel}.</p>
	 * */
	public DefaultTableModel modeloTablaTicket= new DefaultTableModel();
	
	/** 
	 * <h1>Componente tblConsultaTicket</h1>
	 * <p>Componente de tipo {@link JTable}. Contiene una tabla de tickets. No permite la edición de la tabla pero si la pulsación de una fila.</p>
	 * */
	public JTable tblConsultaTicket= new JTable(modeloTablaTicket){
		private static final long serialVersionUID = 1L;
		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}
	};
	
	/** 
	 * <h1>Componente scrollTablaTicket</h1>
	 * <p>Componente de tipo {@link JScrollPane}. Añadido a una tabla de tickets.</p>
	 * */
	public JScrollPane scrollTablaTicket = new JScrollPane(tblConsultaTicket);
	
	/** 
	 * <h1>Componente btnCancelar</h1>
	 * <p>Componente de tipo {@link JButton}. Llama al método que cierra la ventana de consulta de artículos.</p>
	 * */
	public JButton btnCancelar = new JButton("Cancelar");
	
	/**
	 * <h1>Constructor por defecto</h1>
	 * <p>Constructor por defecto de la clase {@link VistaConsultaTicket}.<br> Crea una ventana que permite consultar los tickets.</p>
	 */
	public VistaConsultaTicket() {
		setResizable(false);
		setTitle("Consulta Ticket");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 322);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblConsultaTicket = new JLabel("Consulta Ticket");
		lblConsultaTicket.setOpaque(true);
		lblConsultaTicket.setHorizontalTextPosition(SwingConstants.CENTER);
		lblConsultaTicket.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsultaTicket.setForeground(Color.WHITE);
		lblConsultaTicket.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblConsultaTicket.setFocusable(false);
		lblConsultaTicket.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		lblConsultaTicket.setBackground(new Color(0, 139, 139));
		lblConsultaTicket.setBounds(0, 0, 434, 49);
		contentPane.add(lblConsultaTicket);
		
		tblConsultaTicket.setBorder(new LineBorder(Color.GRAY));

		
		contentPane.add(scrollTablaTicket);
		scrollTablaTicket.setBounds(10, 60, 412, 174);
		
		btnMostrarTicket = new JButton("Mostrar Ticket");
		btnMostrarTicket.setBorder(new LineBorder(new Color(0, 139, 139)));
		btnMostrarTicket.setBounds(95, 245, 97, 25);
		contentPane.add(btnMostrarTicket);
		btnCancelar.setBorder(new LineBorder(new Color(0, 139, 139)));
		btnCancelar.setBounds(241, 245, 97, 25);
		
		contentPane.add(btnCancelar);
		setVisible(true);
	}

}
