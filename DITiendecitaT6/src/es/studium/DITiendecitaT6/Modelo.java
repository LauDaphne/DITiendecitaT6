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

import java.awt.Desktop;
import java.io.File;
import java.util.HashMap;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

public class Modelo {

	/* ############### */
	/* ## VARIABLES ## */
	/* ############### */

	/* >> BASE DE DATOS << */
	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/tiendecita?autoReconnect=true&useSSL=false";
	Connection connection = null;
	Statement statement = null;
	ResultSet rs = null;
	// USUARIO BASE DE DATOS
	String loginBD = "root";
	String passwordBD = "Studium2018;";

	/* ############# */
	/* ## METODOS ## */
	/* ############# */

	/* >> METODOS BASE DE DATOS << */
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

	// DA DE ALTA, BAJA y MODIFICA LOS DATOS EN MYSQL
	public void datosABM(String sent) {
		try {
			statement.executeUpdate(sent);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// JLIST ARTÃ�CULOS SEGUN MYSQL
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
	// JTEXTFIELD
	public void borrarTxt(JTextField txt) {
		txt.selectAll();
		txt.setText("");
	}

	// JTEXTAREA
	public void borrarTxtArea(JTextArea txt) {
		txt.selectAll();
		txt.setText("");
	}

	// ESCRIBE LA FECHA EN FORMATO MYSQL
	public String formatoFechaSQL(String fecha) {
		String[] listaFecha = fecha.split("-");
		String newFecha = listaFecha[2] + "/" + listaFecha[1] + "/" + listaFecha[0];
		return newFecha;
	}

	// ESCRIBE DECIMAL EN FORMATO MYSQL
	public String formatoDecimalSQL(String decimal) {
		String[] listaFecha = decimal.split(",");
		String nuevoDecimal = listaFecha[0] + "." + listaFecha[1];
		return nuevoDecimal;
	}
	
	// ESCRIBE LA FECHA EN FORMATO JASPER
		public String formatoFechaJasper(String fecha) {
			String[] listaFecha = fecha.split("/");
			String newFecha = listaFecha[2] + "/" + listaFecha[1] + "/" + listaFecha[0];
			return newFecha;
		}

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
