package es.studium.Ticket;

import java.awt.Font;
import java.awt.Label;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 * <h1>Clase VistaInformeTicket </h1>
 * <p>Clase que hereda de {@link JFrame}, creando la parte gráfica donde se especifica las fechas delimitantes para buscar los tickets y crear el informe.</p>
 * <p><b>Variables:</b></p>
 * <ul>
 *  <li>Tipo Componente: 
 * 		<ul>
 * 			<li>{@link #contentPane}</li>
 * 			<li>{@link #bttnGenerarInforme}</li>
 *  		<li>{@link #txtFechaInicio}</li>
 *   		<li>{@link #txtFechaFin}</li>
 *    		<li>{@link #bttnLimpiar}</li>
 *     		<li>{@link #bttnCancelar}</li>
 * 		</ul>
 * 	</li>
 * </ul>
 * <p><b>Metodos:</b></p>
 * <ul>
 * 	<li>{@link #VistaInformeTicket()}</li>
 * </ul>
 * @author Laura M. P.
 * @since 28/02/2020
 * @version 1.0
 */
public class VistaInformeTicket extends JFrame {

	/** 
	 * <h1>Número de serie</h1>
	 * <p>Número de serie automático perteneciente a la clase {@link VistaInformeTicket}</p>  
	 */
	private static final long serialVersionUID = 1L;
	
	/** 
	 * <h1>Componente contentPane</h1>
	 * <p>Componente de tipo {@link JPanel}</p>
	 */
	private JPanel contentPane;
	
	/** 
	 * <h1>Componente bttnGenerarInforme</h1>
	 * <p>Componente de tipo {@link JButton}. Llama al método que genera el informe de los tickets.</p>
	 * */
	public JButton bttnGenerarInforme;
	
	/** 
	 * <h1>Componente txtFechaInicio</h1>
	 * <p>Componente de tipo {@link JTextField}. La fecha de inicio para la busqueda de tickets.</p>
	 * */
	public JTextField txtFechaInicio;
	
	/** 
	 * <h1>Componente txtFechaFin</h1>
	 * <p>Componente de tipo {@link JTextField}. La fecha final para la busqueda de tickets.</p>
	 * */
	public JTextField txtFechaFin;
	
	/** 
	 * <h1>Componente bttnLimpiar</h1>
	 * <p>Componente de tipo {@link JButton}. Llama al método que reinicia los campos.</p>
	 * */
	public JButton bttnLimpiar;
	
	/** 
	 * <h1>Componente bttnCancelar</h1>
	 * <p>Componente de tipo {@link JButton}. Llama al método que cierra la ventana.</p>
	 * */
	public JButton bttnCancelar;

	

	/**
	 * <h1>Constructor por defecto</h1>
	 * <p>Constructor por defecto de la clase {@link VistaInformeTicket}.<br> Crea una ventana con diferentes campos y botones que permitirán generar un informe de tickets según dos fechas facilitadas.</p>
	 */
	public VistaInformeTicket() {
		setTitle("Informe Tickets");
		setResizable(false);
		setBounds(100, 100, 304, 193);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		Label label = new Label("Fecha Desde:");
		label.setFont(new Font("Dialog", Font.PLAIN, 12));
		label.setBounds(31, 20, 90, 22);
		contentPane.add(label);
		
		Label label_1 = new Label("Fecha Hasta:");
		label_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		label_1.setBounds(33, 69, 90, 22);
		contentPane.add(label_1);
		
		bttnGenerarInforme = new JButton("Generar");
		bttnGenerarInforme.setName("bttnGenerarTicket");
		bttnGenerarInforme.setBounds(10, 120, 88, 22);
		contentPane.add(bttnGenerarInforme);
		
		txtFechaInicio = new JTextField();
		txtFechaInicio.setName("");
		txtFechaInicio.setBounds(123, 20, 127, 20);
		contentPane.add(txtFechaInicio);
		txtFechaInicio.setColumns(10);
		
		txtFechaFin = new JTextField();
		txtFechaFin.setBounds(123, 69, 127, 20);
		contentPane.add(txtFechaFin);
		txtFechaFin.setColumns(10);
		
		Label label_2 = new Label("*Formato: dd/mm/yyyy");
		label_2.setFont(new Font("Dialog", Font.PLAIN, 10));
		label_2.setBounds(141, 92, 127, 22);
		contentPane.add(label_2);
		
		Label label_3 = new Label("*Formato: dd/mm/yyyy");
		label_3.setFont(new Font("Dialog", Font.PLAIN, 10));
		label_3.setBounds(140, 41, 127, 22);
		contentPane.add(label_3);
		
		bttnLimpiar = new JButton("Limpiar");
		bttnLimpiar.setName("bttnGenerarTicket");
		bttnLimpiar.setBounds(100, 120, 82, 22);
		contentPane.add(bttnLimpiar);
		
		bttnCancelar = new JButton("Cancelar");
		bttnCancelar.setName("bttnGenerarTicket");
		bttnCancelar.setBounds(185, 120, 90, 22);
		contentPane.add(bttnCancelar);
		
		setVisible(true);
	}
}
