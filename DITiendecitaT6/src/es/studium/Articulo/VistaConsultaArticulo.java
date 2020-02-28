package es.studium.Articulo;

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
 * <h1>Clase VistaConsultaArticulo </h1>
 * <p>Clase que hereda de {@link JFrame}, creando la parte gráfica de la consulta de artículos. </p>
 * <p><b>Variables:</b></p>
 * <ul>
 *  <li>Tipo Componente: 
 * 		<ul>
 * 			<li>{@link #contentPane}</li>
 * 			<li>{@link #btnAceptarConsultaArticulo}</li>
 *  		<li>{@link #modeloTablaArticulo}</li>
 *   		<li>{@link #tblConsultaArticulo}</li>
 *    		<li>{@link #scrollTablaArticulo}</li>
 * 		</ul>
 * 	</li>
 * </ul>
 * <p><b>Metodos:</b></p>
 * <ul>
 * 	<li>{@link #VistaConsultaArticulo()}</li>
 * </ul>
 * @author Laura M. P.
 * @since 28/02/2020
 * @version 1.0
 */
public class VistaConsultaArticulo extends JFrame {


	/** 
	 * <h1>Número de serie</h1>
	 * <p>Número de serie automático perteneciente a la clase {@link VistaConsultaArticulo}</p>  
	 */
	private static final long serialVersionUID = 1L;
	
	/** 
	 * <h1>Componente contentPane</h1>
	 * <p>Componente de tipo {@link JPanel}</p>
	 */
	private JPanel contentPane;
	
	/** 
	 * <h1>Componente btnAceptarConsultaArticulo</h1>
	 * <p>Componente de tipo {@link JButton}. Llama al método que cierra la ventana de consulta de artículos.</p>
	 * */
	public JButton btnAceptarConsultaArticulo;
	
	/** 
	 * <h1>Componente modeloTablaArticulo</h1>
	 * <p>Componente de tipo {@link DefaultTableModel}.</p>
	 * */
	public DefaultTableModel modeloTablaArticulo= new DefaultTableModel();
	
	/** 
	 * <h1>Componente tblConsultaArticulo</h1>
	 * <p>Componente de tipo {@link JTable}. Contiene una tabla de artículos.</p>
	 * */
	public JTable tblConsultaArticulo= new JTable(modeloTablaArticulo);
	
	/** 
	 * <h1>Componente scrollTablaArticulo</h1>
	 * <p>Componente de tipo {@link JScrollPane}. Añadido a una tabla de artículos.</p>
	 * */
	public JScrollPane scrollTablaArticulo = new JScrollPane(tblConsultaArticulo);

	/**
	 * <h1>Constructor por defecto</h1>
	 * <p>Constructor por defecto de la clase {@link VistaConsultaArticulo}.<br> Crea una ventana con diferentes campos y botones que permitirán concultar los artículos.</p>
	 */
	public VistaConsultaArticulo() {
		setResizable(false);
		setTitle("Consulta Art\u00EDculo");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 317);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		
		JLabel lblConsultaArtculo = new JLabel("Consulta Art\u00EDculo");
		lblConsultaArtculo.setOpaque(true);
		lblConsultaArtculo.setHorizontalTextPosition(SwingConstants.CENTER);
		lblConsultaArtculo.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsultaArtculo.setForeground(Color.WHITE);
		lblConsultaArtculo.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblConsultaArtculo.setFocusable(false);
		lblConsultaArtculo.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		lblConsultaArtculo.setBackground(new Color(0, 139, 139));
		lblConsultaArtculo.setBounds(0, 0, 434, 49);
		contentPane.add(lblConsultaArtculo);
		
		tblConsultaArticulo.setBorder(new LineBorder(Color.GRAY));
		tblConsultaArticulo.setEnabled(false);
		contentPane.add(scrollTablaArticulo);
		scrollTablaArticulo.setBounds(10, 60, 412, 174);
		
		btnAceptarConsultaArticulo = new JButton("Aceptar");
		btnAceptarConsultaArticulo.setBorder(new LineBorder(new Color(0, 139, 139)));
		btnAceptarConsultaArticulo.setBounds(157, 245, 90, 25);
		contentPane.add(btnAceptarConsultaArticulo);
		setVisible(true);
	}
}
