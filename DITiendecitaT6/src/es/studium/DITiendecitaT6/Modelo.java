package es.studium.DITiendecitaT6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import es.studium.Ticket.ControladorInformeTicket;
import es.studium.Ticket.VistaAltaTicket;

import java.awt.Desktop;
import java.io.File;
import java.util.HashMap;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 * <h1>Clase Modelo </h1>
 * <p>Clase que contine métodos necesarios para dar funcionalidad al programa.</p>
 * <p><b>Variables:</b></p>
 * <ul>
 *  <li>Tipo String: 
 * 		<ul>
 * 			<li>{@link #driver}</li>
 * 			<li>{@link #url}</li>
 *  		<li>{@link #loginBD}</li>
 *   		<li>{@link #passwordBD}</li>
 * 		</ul>
 * 	</li>
 *  <li>Otros: 
 * 		<ul>
 * 			<li>{@link #connection}</li>
 * 			<li>{@link #statement}</li>
 *  		<li>{@link #rs}</li>
 * 		</ul>
 * 	</li>
 * </ul>
 * <p><b>Metodos:</b></p>
 * <ul>
 * 	<li>{@link #conectaBase()}</li>
 *  <li>{@link #desconectaBase()}</li>
 *  <li>{@link #datosABM(String)}</li>
 *  <li>{@link #rellenarLista(String, DefaultListModel)}</li>
 *  <li>{@link #buscarDatos(String)}</li>
 *  <li>{@link #rellenarColumnaTabla(String, JTable)}</li>
 *  <li>{@link #rellenarTabla(String, JTable)}</li>
 *  <li>{@link #rellenarFilaTabla(String, String, JTable)}</li>
 *  <li>{@link #agregarArtCompra(String, String, JTable)}</li>
 *  <li>{@link #borrarTxt(JTextField)}</li>
 *  <li>{@link #borrarTxtArea(JTextArea)}</li>
 *  <li>{@link #formatoFechaSQL(String)}</li>
 *  <li>{@link #formatoDecimalSQL(String)}</li>
 *  <li>{@link #formatoFechaJasper(String)}</li>
 *  <li>{@link #esNumero(String)}</li>
 *  <li>{@link #generarJasperArticulo(JFrame)}</li>
 *  <li>{@link #generarJasperTicket(JFrame, String, String)}</li>
 * </ul>
 * @author Laura M. P.
 * @since 28/02/2020
 * @version 1.0
 */
public class Modelo {

	/* ############### */
	/* ## VARIABLES ## */
	/* ############### */

	/** 
	 * <h1>Variable driver</h1>
	 * <p>Variable de tipo {@link String} que contine nombre del driver que usa el programa para conectarse a la base de datos.</p>
	 */
	/* >> BASE DE DATOS << */
	String driver = "com.mysql.jdbc.Driver";
	
	/** 
	 * <h1>Variable url</h1>
	 * <p>Variable de tipo {@link String} que contine la url que usa el programa para conectarse a la base de datos.</p>
	 */
	String url = "jdbc:mysql://localhost:3306/tiendecita?autoReconnect=true&useSSL=false";
	
	/** 
	 * <h1>Variable connection</h1>
	 * <p>Variable de tipo {@link Connection}, necesaria para que el programa pueda conectarse a la base de datos.</p>
	 */
	Connection connection = null;
	
	/** 
	 * <h1>Variable statement</h1>
	 * <p>Variable de tipo {@link Statement}, necesaria para ejecutar sentencias en la base de datos y devolver resultados.</p>
	 */
	Statement statement = null;
	
	/** 
	 * <h1>Variable rs</h1>
	 * <p>Variable de tipo {@link ResultSet}, es donde se guarda el resultado de la consulta a la base de datos.</p>
	 */
	ResultSet rs = null;
	
	/** 
	 * <h1>Variable loginBD</h1>
	 * <p>Variable de tipo {@link String}, contiene el nombre de usuario de la base de datos.</p>
	 */
	// USUARIO BASE DE DATOS
	String loginBD = "root";
	
	/** 
	 * <h1>Variable passwordBD</h1>
	 * <p>Variable de tipo {@link String}, contiene la contraseña del usuario de la base de datos.</p>
	 */
	String passwordBD = "Studium2018;";

	/* ############# */
	/* ## METODOS ## */
	/* ############# */

	/* >> METODOS BASE DE DATOS << */
	/** 
	 * <h1>Conectar Base de Datos</h1>
	 * <p>Método que realiza la conexión a la base de datos.</p>
	 */
	// CONECTA MYSQL
	public void conectaBase() {
		try {
			// CARGAR LOS CONTROLADORES PARA EL ACCESO A LA BASE DE DATOS
			Class.forName(driver);
			// ESTABLECER LA CONEXIÃ“N CON LA BASE DE DATOS
			connection = DriverManager.getConnection(url, loginBD, passwordBD);
			// CREAR UNA SENTENCIA
			statement = connection.createStatement();
		} catch (ClassNotFoundException cnfe) {
			System.out.println("Error 1: " + cnfe.getMessage());
		} catch (SQLException sqle) {
			System.out.println("Error 2: " + sqle.getMessage());
		}
	}
	
	/** 
	 * <h1>Desconecta Base de Datos</h1>
	 * <p>Método que  desconecta la base de datos.</p>
	 */
	// DESCONECTA MYSQL
	public void desconectaBase() {
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			System.out.println("Error 3: " + e.getMessage());
		}
	}

	/**
	 * <h1>Datos ABM</h1>
	 * <p>Método que recibe una sentencia SQL y realiza, de los metodos CRUD, el <b>alta</b>, <b>baja</b> y <b>modificación</b>.</p>
	 * @param sent ({@link String}) - Contine una sentencia SQL.
	 */
	// DA DE ALTA, BAJA y MODIFICA LOS DATOS EN MYSQL
	public void datosABM(String sent) {
		try {
			statement.executeUpdate(sent);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * <h1>Rellenar lista</h1>
	 * <p>Método que  rellena un componente de tipo {@link JList} con los datos devueltos por una sentencia SQL.</p>
	 * @param sent ({@link String}) - Contine una sentencia SQL.
	 * @param lista ({@link DefaultListModel}) - Modelo por defecto de un {@link JList}.
	 */
	// JLIST ARTÍCULOS SEGUN MYSQL
	public void rellenarLista(String sent, DefaultListModel<String> lista) {
		try {
			rs = statement.executeQuery(sent);
			while (rs.next()) {
				lista.addElement(" " + rs.getString(1) + " - " + rs.getString(2) + " (" + rs.getString(3) + " €) "
						+ rs.getString(4) + " Ud/Uds");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * <h1>Buscar datos</h1>
	 * <p>Método que  devuelve datos según una sentencia SQL.</p>
	 * @param sent ({@link String}) - Contine una sentencia SQL.
	 * @return {@link ResultSet}
	 */
	// BUSCA DATOS EN MYSQL MEDIANTE SELECT
	public ResultSet buscarDatos(String sent) {
		try {
			rs = statement.executeQuery(sent);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	/**
	 * <h1>Rellenar columna tabla</h1>
	 * <p>Método que  rellena la cabecera de cualquier componente de tipo {@link JTable} con los datos devueltos según una sentencia SQL.</p>
	 * @param sent ({@link String}) - Contine una sentencia SQL.
	 * @param tabla ({@link JTable}) - Componente tabla que será rellenado.
	 */
	// NOMBRE COLUMNA TABLA SEGUN MYSQL
	public void rellenarColumnaTabla(String sent, JTable tabla) {
		try {
			DefaultTableModel modeloTabla = (DefaultTableModel) tabla.getModel();
			rs = statement.executeQuery(sent);
			int columnas = rs.getMetaData().getColumnCount();
			for (int i = 0; i < columnas; i++) {
				modeloTabla.addColumn(rs.getMetaData().getColumnLabel(i + 1));
			}
			modeloTabla.addColumn("CANTIDAD");

		} catch (SQLException e) {
			System.out.println("Error rellenar columnas tabla");
			e.printStackTrace();
		}
	}

	/**
	 * <h1>Rellenar tabla</h1>
	 * <p>Método que  rellena el cuerpo de cualquier componente de tipo {@link JTable} con los datos devueltos según una sentencia SQL.</p>
	 * @param sent ({@link String}) - Contine una sentencia SQL.
	 * @param tabla ({@link JTable}) - Componente tabla que será rellenado.
	 */
	// TABLA CONSULTA SEGUN MYSQL
	public void rellenarTabla(String sent, JTable tabla) {
		try {
			TableColumnModel columnModel = tabla.getColumnModel();
			DefaultTableModel modeloTabla = (DefaultTableModel) tabla.getModel();
			rs = statement.executeQuery(sent);
			int columnas = rs.getMetaData().getColumnCount();
			for (int i = 0; i < columnas; i++) {
				modeloTabla.addColumn(rs.getMetaData().getColumnLabel(i + 1));
			}
			columnModel.getColumn(0).setPreferredWidth(15);
			columnModel.getColumn(1).setPreferredWidth(150);
			while (rs.next()) {
				Object datos[] = new Object[columnas];
				for (int i = 0; i < columnas; i++) {
					datos[i] = rs.getString(i + 1);
				}
				modeloTabla.addRow(datos);
			}
		} catch (SQLException e) {
			System.out.println("Error rellenar tabla");
			e.printStackTrace();
		}
	}

	/**
	 * <h1>Rellenar fila tabla</h1>
	 * <p>Método que  añade una fila al cuerpo un componente de tipo {@link JTable}.</p>
	 * @param sent ({@link String}) - Contine una sentencia SQL.
	 * @param cantidadAAdjuntar ({@link String}) - Cantidad de objetos comprados en Tickets. Dato que se añadirá a la tabla junto con los devueltos por la base de datos.
	 * @param tabla ({@link JTable}) - Componente tabla que será rellenado.
	 */
	// FILA TABLA SEGUN MYSQL
	public void rellenarFilaTabla(String sent, String cantidadAAdjuntar, JTable tabla) {
		try {
			DefaultTableModel modeloTabla = (DefaultTableModel) tabla.getModel();
			rs = statement.executeQuery(sent);
			int columnas = rs.getMetaData().getColumnCount();
			rs.next();
			if (rs.getInt(columnas - 1) < (Integer.parseInt(cantidadAAdjuntar))) {
				JOptionPane.showMessageDialog(tabla, "NO hay suficiente stock", "Mensaje de ERROR",
						JOptionPane.ERROR_MESSAGE);

			} else {
				Object datos[] = new Object[columnas + 1];
				do {
					for (int i = 0; i < columnas; i++) {
						datos[i] = rs.getString(i + 1);
					}
				} while (rs.next());
				datos[columnas] = cantidadAAdjuntar;
				modeloTabla.addRow(datos);
			}
		} catch (SQLException e) {
			System.out.println("Error rellenar tabla");
			e.printStackTrace();
		}
	}

	/**
	 * <h1>Agregar artículo compra</h1>
	 * <p>Método que  añade una fila al cuerpo del componente de tipo {@link JTable} de la clase {@link VistaAltaTicket} si no está ya en la tabla el artículo. En el caso de estarlo, se actualizará la cantidad comprada.</p>
	 * @param idArticulo ({@link String}) - ID del artículo, que se quiere añadir a la tabla, en la base de datos.
	 * @param cantidadNueva ({@link String}) - Cantidad de artículos que de desean comprar. 
	 * @param tabla ({@link JTable}) - Componente tabla que será rellenado, si no está ya el artículo en la tabla.
	 * @return ({@link String}) - Devuelve el precio total de todos los artículos agregados al ticket, teniendo en cuenta sus cantidades.
	 */
	// AGREGAR COMPRA TICKET
	public String agregarArtCompra(String idArticulo, String cantidadNueva, JTable tabla) {
		DefaultTableModel modeloTabla = (DefaultTableModel) tabla.getModel();
		boolean existe = false;
		int filas = 0;
		filas = modeloTabla.getRowCount();
		for (int i = 0; i < filas; i++) {
			if (((String) modeloTabla.getValueAt(i, 0)).equals(idArticulo) && !existe) {

				int cantidadVieja = Integer.parseInt((String) modeloTabla.getValueAt(i, 4));
				cantidadVieja = cantidadVieja + Integer.parseInt(cantidadNueva);
				if (Integer.parseInt((String) modeloTabla.getValueAt(i, 2)) < cantidadVieja) {
					JOptionPane.showMessageDialog(tabla, "NO hay suficiente stock", "Mensaje de ERROR",
							JOptionPane.ERROR_MESSAGE);
					existe = true;
				} else {
					tabla.setValueAt("" + cantidadVieja, i, 4);
					existe = true;
				}
			}
		}
		if (!existe) {
			String sentencia = "SELECT idArticulo, nombreArticulo, stockArticulo, precioArticulo FROM articulos WHERE idArticulo='"
					+ idArticulo + "';";
			conectaBase();
			rellenarFilaTabla(sentencia, cantidadNueva, tabla);
			desconectaBase();
		}

		double total = 0.0;
		filas = modeloTabla.getRowCount();
		for (int i = 0; i < filas; i++) {
			total = total + (Double.parseDouble("" + modeloTabla.getValueAt(i, 3))
					* Double.parseDouble("" + modeloTabla.getValueAt(i, 4)));
		}
		DecimalFormat formatoDecimal = new DecimalFormat("#.00");
		return "" + formatoDecimal.format(total);
	}

	// BORRA EL CONTENIDO
	/**
	 * <h1>Borrar txt</h1>
	 * <p>Método que limpia un {@link JTextField}.</p>
	 * @param txt ({@link JTextField}) - Componente que perderá su texto.
	 */
	// JTEXTFIELD
	public void borrarTxt(JTextField txt) {
		txt.selectAll();
		txt.setText("");
	}

	/**
	 * <h1>Borrar txt area</h1>
	 * <p>Método que limpia un {@link JTextArea}.</p>
	 * @param txt ({@link JTextArea}) - Componente que perderá su texto.
	 */
	// JTEXTAREA
	public void borrarTxtArea(JTextArea txt) {
		txt.selectAll();
		txt.setText("");
	}

	/**
	 * <h1>Formato fecha SQL</h1>
	 * <p>Método que devuelve una fecha en formato americano.</p>
	 * @param fecha ({@link String}) - Fecha en formato europeo.
	 * @return ({@link String}) - - Fecha en formato americano.
	 */
	// ESCRIBE LA FECHA EN FORMATO MYSQL
	public String formatoFechaSQL(String fecha) {
		String[] listaFecha = fecha.split("-");
		String newFecha = listaFecha[2] + "/" + listaFecha[1] + "/" + listaFecha[0];
		return newFecha;
	}

	/**
	 * <h1>Formato decimal SQL</h1>
	 * <p>Método que devuelve un número decimal, cambiando la "," por un "."</p>
	 * @param decimal ({@link String}) - Número decimal con ","
	 * @return ({@link String}) - Número decimal con "."
	 */
	// ESCRIBE DECIMAL EN FORMATO MYSQL
	public String formatoDecimalSQL(String decimal) {
		String[] listaFecha = decimal.split(",");
		String nuevoDecimal = listaFecha[0] + "." + listaFecha[1];
		return nuevoDecimal;
	}
	
	/**
	 * <h1>Formato fecha jasper</h1>
	 * <p>Método que devuelve una fecha en formato americano teniendo en cuenta los simbolos usados en el apartado de JasperReport.</p>
	 * @param fecha ({@link String}) - Fecha en formato europeo.
	 * @return ({@link String}) - - Fecha en formato americano.
	 */
	// ESCRIBE LA FECHA EN FORMATO JASPER
		public String formatoFechaJasper(String fecha) {
			String[] listaFecha = fecha.split("/");
			String newFecha = listaFecha[2] + "/" + listaFecha[1] + "/" + listaFecha[0];
			return newFecha;
		}

	/**
	 * <h1>Es numero</h1>
	 * <p>Método que devuelve un true o false, dependiendo de si lo introducido es un número de tipo {@link Integer} y superior a 0</p>
	 * @param cantidad ({@link String}) - Valor introducido para revisar.
	 * @return ({@link Boolean}) - True si es un número entero mayor de 0.
	 */
	// COMPROBAR QUE ES UN NUMERO
	public boolean esNumero(String cantidad) {

		boolean resultado;

		try {
			int num = Integer.parseInt(cantidad);
			if (num > 0) {
				resultado = true;
			} else {
				resultado = false;
			}
		} catch (NumberFormatException excepcion) {
			resultado = false;
		}

		return resultado;
	}

	/**
	 * <h1>Generar jasper artículo</h1>
	 * <p>Método que genera y abre un pdf. El pdf contiene una tabla con los datos de todos los artículos de la base de datos.</p>
	 * @param pantalla ({@link JFrame}) - Ventana de referencia para abrir los mensajes informativos.
	 */
	// GENERAR JASPER
	public void generarJasperArticulo(JFrame pantalla) {
		try {
			// Compilar el informe generando fichero jasper
			JasperCompileManager.compileReportToFile("articulos.jrxml");
			JOptionPane.showMessageDialog(pantalla, "Informe generado correctamente", "Mensaje de CONFIRMACIÓN",JOptionPane.INFORMATION_MESSAGE);
			// Objeto para guardar parámetros necesarios para el informe
			HashMap<String, Object> parametros = new HashMap<String, Object>();
			// Cargar el informe compilado
			JasperReport report = (JasperReport) JRLoader.loadObjectFromFile("articulos.jasper");
			// Conectar a la base de datos para sacar la información
			Class.forName("com.mysql.jdbc.Driver");
			String servidor = "jdbc:mysql://localhost:3306/tiendecita?useSSL=false";
			String usuarioDB = "root";
			String passwordDB = "Studium2018;";
			Connection conexion = DriverManager.getConnection(servidor, usuarioDB, passwordDB);
			// Completar el informe con los datos de la base de datos
			JasperPrint print = JasperFillManager.fillReport(report, parametros, conexion);
			// Para exportarlo a pdf
			JasperExportManager.exportReportToPdfFile(print, "ArticuloInforme.pdf");
			// Abrir el fichero PDF generado
			File path = new File("ArticuloInforme.pdf");
			Desktop.getDesktop().open(path);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(pantalla, "ERROR al generar el informe. Vuelva a intentarlo.", "Mensaje de ERROR",JOptionPane.ERROR_MESSAGE);
			System.out.println("Error: " + e.toString());
		}
	}
	
	/**
	 * <h1>Generar jasper ticket</h1>
	 * <p>Método que genera y abre un pdf. El pdf contiene una tabla con los datos de todos los tickets de la base de datos entre dos fechas.</p>
	 * @param pantalla ({@link JFrame}) - Ventana de referencia para abrir los mensajes informativos.
	 * @param fechaI ({@link JFrame}) - Fecha de inicio del periodo donde de buscarán los tickets.
	 * @param fechaF ({@link JFrame}) - Fecha de fin del periodo donde de buscarán los tickets.
	 */
	public void generarJasperTicket(JFrame pantalla, String fechaI, String fechaF) {
		try {
			// Compilar el informe generando fichero jasper
			JasperCompileManager.compileReportToFile("tickets.jrxml");
			// Objeto para guardar parámetros necesarios para el informe
			HashMap<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("fechaInicio", fechaI);
			parametros.put("fechaFin", fechaF);
			// Cargar el informe compilado
			JasperReport report = (JasperReport) JRLoader.loadObjectFromFile("tickets.jasper");
			// Conectar a la base de datos para sacar la información
			Class.forName("com.mysql.jdbc.Driver");
			String servidor = "jdbc:mysql://localhost:3306/tiendecita?useSSL=false";
			String usuarioDB = "root";
			String passwordDB = "Studium2018;";
			Connection conexion = DriverManager.getConnection(servidor, usuarioDB, passwordDB);
			// Completar el informe con los datos de la base de datos
			JasperPrint print = JasperFillManager.fillReport(report, parametros, conexion);
			// Para exportarlo a pdf
			JasperExportManager.exportReportToPdfFile(print, "TicketInforme.pdf");
			JOptionPane.showMessageDialog(pantalla, "Informe generado correctamente", "Mensaje de CONFIRMACIÓN",JOptionPane.INFORMATION_MESSAGE);
			// Abrir el fichero PDF generado
			File path = new File("TicketInforme.pdf");
			Desktop.getDesktop().open(path);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(pantalla, "ERROR al generar el informe. Vuelva a intentarlo.", "Mensaje de ERROR",JOptionPane.ERROR_MESSAGE);
			System.out.println("Error: " + e.toString());
			new ControladorInformeTicket();
		}
	}
}
