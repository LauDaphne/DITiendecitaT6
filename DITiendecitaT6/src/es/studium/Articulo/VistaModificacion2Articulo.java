package es.studium.Articulo;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

/**
 * <h1>Clase VistaModificacion2Articulo </h1>
 * <p>Clase que hereda de {@link JFrame}, creando la segunda parte gráfica de la modificación de artículos. </p>
 * <p><b>Variables:</b></p>
 * <ul>
 *  <li>Tipo Componente: 
 * 		<ul>
 * 			<li>{@link #contentPane}</li>
 * 			<li>{@link #txtNombreModificacion}</li>
 *  		<li>{@link #txtPrecioModificacion}</li>
 *   		<li>{@link #txtStockModificacion}</li>
 *    		<li>{@link #btnCambiarArticulo}</li>
 *   		<li>{@link #btnBorrarCambio}</li>
 *    		<li>{@link #btnCancelarCambio}</li>
 *    		<li>{@link #txtAreaDescripcionCambio}</li>
 * 		</ul>
 * 	</li>
 * </ul>
 * <p><b>Metodos:</b></p>
 * <ul>
 * 	<li>{@link #VistaModificacion2Articulo()}</li>
 * </ul>
 * @author Laura M. P.
 * @since 28/02/2020
 * @version 1.0
 */
public class VistaModificacion2Articulo extends JFrame {

	/** 
	 * <h1>Número de serie</h1>
	 * <p>Número de serie automático perteneciente a la clase {@link VistaModificacion2Articulo}</p>  
	 */
	private static final long serialVersionUID = 1L;
	
	/** 
	 * <h1>Componente contentPane</h1>
	 * <p>Componente de tipo {@link JPanel}</p>
	 */
	private JPanel contentPane;
	
	/** 
	 * <h1>Componente txtNombreModificacion</h1>
	 * <p>Componente de tipo {@link JTextField}. Nombre del artículo.</p>
	 * */
	public JTextField txtNombreModificacion;
	
	/** 
	 * <h1>Componente txtPrecioModificacion</h1>
	 * <p>Componente de tipo {@link JTextField}. Precio del artículo.</p>
	 * */
	public JTextField txtPrecioModificacion;
	
	/** 
	 * <h1>Componente txtStockModificacion</h1>
	 * <p>Componente de tipo {@link JTextField}. Stock del artículo.</p>
	 * */
	public JTextField txtStockModificacion;
	
	/** 
	 * <h1>Componente btnCambiarArticulo</h1>
	 * <p>Componente de tipo {@link JButton}. Llama al método que hace la modificación del artículo.</p>
	 * */
	public JButton btnCambiarArticulo;
	
	/** 
	 * <h1>Componente btnBorrarCambio</h1>
	 * <p>Componente de tipo {@link JButton}. Llama al método que reinicia los campos.</p>
	 * */
	public JButton btnBorrarCambio;
	
	/** 
	 * <h1>Componente btnCancelarCambio</h1>
	 * <p>Componente de tipo {@link JButton}. Llama al método que cierra la ventana.</p>
	 * */
	public JButton btnCancelarCambio;
	
	/** 
	 * <h1>Componente txtAreaDescripcionCambio</h1>
	 * <p>Componente de tipo {@link JTextArea}. Descripción del artículo.</p>
	 * */
	public JTextArea txtAreaDescripcionCambio;


	/**
	 * <h1>Constructor por defecto</h1>
	 * <p>Constructor por defecto de la clase {@link VistaModificacion2Articulo}.<br> Crea una ventana con diferentes campos y botones que permitirán modificar un artículo.</p>
	 */
	public VistaModificacion2Articulo() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Modificaci\u00F3n Art\u00EDculo");
		setResizable(false);
		setBounds(100, 100, 375, 407);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel label = new JLabel("Modificaci\u00F3n Art\u00EDculo");
		label.setOpaque(true);
		label.setHorizontalTextPosition(SwingConstants.CENTER);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD, 25));
		label.setFocusable(false);
		label.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		label.setBackground(new Color(0, 139, 139));
		label.setBounds(0, 0, 359, 49);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("*Nombre:");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_1.setBounds(39, 74, 67, 14);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Descripci\u00F3n:");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_2.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_2.setBounds(23, 105, 84, 14);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("*Precio:");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_3.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_3.setBounds(39, 234, 67, 14);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("*Stock:");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_4.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_4.setBounds(49, 264, 57, 14);
		contentPane.add(label_4);
		
		txtNombreModificacion = new JTextField();
		txtNombreModificacion.setColumns(10);
		txtNombreModificacion.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 139, 139)));
		txtNombreModificacion.setBackground(SystemColor.menu);
		txtNombreModificacion.setBounds(118, 71, 195, 20);
		contentPane.add(txtNombreModificacion);
		
		txtPrecioModificacion = new JTextField();
		txtPrecioModificacion.setColumns(10);
		txtPrecioModificacion.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 139, 139)));
		txtPrecioModificacion.setBackground(SystemColor.menu);
		txtPrecioModificacion.setBounds(118, 231, 60, 20);
		contentPane.add(txtPrecioModificacion);
		
		txtStockModificacion = new JTextField();
		txtStockModificacion.setColumns(10);
		txtStockModificacion.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 139, 139)));
		txtStockModificacion.setBackground(SystemColor.menu);
		txtStockModificacion.setBounds(118, 261, 60, 20);
		contentPane.add(txtStockModificacion);
		
		JLabel label_5 = new JLabel("\u20AC");
		label_5.setBounds(186, 234, 20, 14);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("Ud./Uds.");
		label_6.setBounds(186, 264, 52, 14);
		contentPane.add(label_6);
		
		btnCambiarArticulo = new JButton("Cambiar");
		btnCambiarArticulo.setBorder(new LineBorder(new Color(0, 139, 139)));
		btnCambiarArticulo.setBounds(23, 305, 100, 25);
		contentPane.add(btnCambiarArticulo);
		
		btnBorrarCambio = new JButton("Borrar");
		btnBorrarCambio.setBorder(new LineBorder(new Color(0, 139, 139)));
		btnBorrarCambio.setBounds(141, 305, 90, 25);
		contentPane.add(btnBorrarCambio);
		
		btnCancelarCambio = new JButton("Cancelar");
		btnCancelarCambio.setBorder(new LineBorder(new Color(0, 139, 139)));
		btnCancelarCambio.setBounds(250, 305, 90, 25);
		contentPane.add(btnCancelarCambio);
		
		JLabel label_7 = new JLabel("* Datos obligatorios");
		label_7.setBounds(127, 335, 121, 14);
		contentPane.add(label_7);
		
		txtAreaDescripcionCambio = new JTextArea();
		txtAreaDescripcionCambio.setBorder(new LineBorder(Color.GRAY));
		txtAreaDescripcionCambio.setBounds(118, 105, 195, 115);
		contentPane.add(txtAreaDescripcionCambio);
		setVisible(true);
	}

}
