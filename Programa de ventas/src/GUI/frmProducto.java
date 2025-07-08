package GUI;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Arreglos.ArregloProducto;
import Clases.Producto;
import javax.swing.ScrollPaneConstants;
import Datos.Datos;
public class frmProducto extends JInternalFrame implements ActionListener {
	private JLabel lblCdigoProducto;
	private JLabel lblNombre;
	private JLabel lblPrecio;
	private JLabel lblStockActual;
	private JLabel lblStockMinimo;
	private JLabel lblStockMaximo;
	private JTextField textCodigoProducto;
	private JTextField textNombre;
	private JTextField textPrecio;
	private JTextField textStockActual;
	private JTextField textStockMinimo;
	private JTextField textStockMaximo;
	private JScrollPane scrollPane;
	private JButton btnIngreso;
	private JButton btnModificacion;
	private JButton btnConsulta;
	private JButton btnEliminacion;
	private JButton btnListado;
	private JTextArea textR;
	private ArregloProducto arregloProducto;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmProducto frame = new frmProducto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frmProducto() {
		setTitle("Productos");
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 450, 334);
		getContentPane().setLayout(null);
		
		lblCdigoProducto = new JLabel("C\u00F3digo Producto:");
		lblCdigoProducto.setBounds(10, 14, 100, 14);
		getContentPane().add(lblCdigoProducto);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 39, 100, 14);
		getContentPane().add(lblNombre);
		
		lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(10, 64, 100, 14);
		getContentPane().add(lblPrecio);
		
		lblStockActual = new JLabel("Stock Actual: ");
		lblStockActual.setBounds(10, 89, 100, 14);
		getContentPane().add(lblStockActual);
		
		lblStockMinimo = new JLabel("Stock Minimo: ");
		lblStockMinimo.setBounds(10, 114, 100, 14);
		getContentPane().add(lblStockMinimo);
		
		lblStockMaximo = new JLabel("Stock Maximo:");
		lblStockMaximo.setBounds(10, 139, 100, 14);
		getContentPane().add(lblStockMaximo);
		
		textCodigoProducto = new JTextField();
		textCodigoProducto.setColumns(10);
		textCodigoProducto.setBounds(120, 11, 86, 20);
		getContentPane().add(textCodigoProducto);
		
		textNombre = new JTextField();
		textNombre.setColumns(10);
		textNombre.setBounds(120, 36, 86, 20);
		getContentPane().add(textNombre);
		
		textPrecio = new JTextField();
		textPrecio.setColumns(10);
		textPrecio.setBounds(120, 61, 86, 20);
		getContentPane().add(textPrecio);
		
		textStockActual = new JTextField();
		textStockActual.setColumns(10);
		textStockActual.setBounds(120, 86, 86, 20);
		getContentPane().add(textStockActual);
		
		textStockMinimo = new JTextField();
		textStockMinimo.setColumns(10);
		textStockMinimo.setBounds(120, 111, 86, 20);
		getContentPane().add(textStockMinimo);
		
		textStockMaximo = new JTextField();
		textStockMaximo.setColumns(10);
		textStockMaximo.setBounds(120, 136, 86, 20);
		getContentPane().add(textStockMaximo);
		
		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(212, 14, 212, 248);
		getContentPane().add(scrollPane);
		
		textR = new JTextArea();
		textR.setEditable(false);
		scrollPane.setViewportView(textR);
		
		btnIngreso = new JButton("Ingreso");
		btnIngreso.addActionListener(this);
		btnIngreso.setBounds(10, 165, 111, 23);
		getContentPane().add(btnIngreso);
		
		btnModificacion = new JButton("Modificaci\u00F3n");
		btnModificacion.addActionListener(this);
		btnModificacion.setBounds(10, 190, 111, 23);
		getContentPane().add(btnModificacion);
		
		btnConsulta = new JButton("Consulta");
		btnConsulta.addActionListener(this);
		btnConsulta.setBounds(10, 215, 111, 23);
		getContentPane().add(btnConsulta);
		
		btnEliminacion = new JButton("Eliminaci\u00F3n");
		btnEliminacion.addActionListener(this);
		btnEliminacion.setBounds(10, 240, 111, 23);
		getContentPane().add(btnEliminacion);
		
		btnListado = new JButton("Listado");
		btnListado.addActionListener(this);
		btnListado.setBounds(10, 265, 111, 23);
		getContentPane().add(btnListado);
		arregloProducto = Datos.arregloProducto;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnListado) {
			actionPerformedBtnListado(e);
		}
		if (e.getSource() == btnEliminacion) {
			actionPerformedBtnEliminacion(e);
		}
		if (e.getSource() == btnConsulta) {
			actionPerformedBtnConsulta(e);
		}
		if (e.getSource() == btnModificacion) {
			actionPerformedBtnModificacion(e);
		}
		if (e.getSource() == btnIngreso) {
			actionPerformedBtnIngreso(e);
		}
	}
	protected void actionPerformedBtnIngreso(ActionEvent e) {
        String nombre = textNombre.getText();
        double precio = Double.parseDouble(textPrecio.getText());
        int stockActual = Integer.parseInt(textStockActual.getText());
        int stockMinimo = Integer.parseInt(textStockMinimo.getText());
        int stockMaximo = Integer.parseInt(textStockMaximo.getText());

        Datos.arregloProducto.agregarProducto(nombre, precio, stockActual, stockMinimo, stockMaximo);
        textR.setText("Producto agregado con éxito." + "\n");
        actualizarDatos();
    }
    
    protected void actionPerformedBtnModificacion(ActionEvent e) {
        int codigo = Integer.parseInt(textCodigoProducto.getText());
        String nuevoNombre = textNombre.getText();
        double nuevoPrecio = Double.parseDouble(textPrecio.getText());
        int nuevoStockActual = Integer.parseInt(textStockActual.getText());
        int nuevoStockMinimo = Integer.parseInt(textStockMinimo.getText());
        int nuevoStockMaximo = Integer.parseInt(textStockMaximo.getText());

        arregloProducto.modificarProducto(codigo, nuevoNombre, nuevoPrecio, nuevoStockActual, nuevoStockMinimo, nuevoStockMaximo);
        textR.setText("Producto modificado con éxito." + "\n");
        actualizarDatos();
    }

    protected void actionPerformedBtnConsulta(ActionEvent e) {
        int codigo = Integer.parseInt(textCodigoProducto.getText());
        Producto producto = arregloProducto.consultarProducto(codigo);
        if (producto != null) {
            textR.setText("Producto encontrado: " + "\n");
            textR.append("Código Producto: " + producto.getCodigoProducto() + "\n");
            textR.append("Nombre: " + producto.getNombre() + "\n");
            textR.append("Precio: " + producto.getPrecio() + "\n");
            textR.append("Stock Actual: " + producto.getStockActual() + "\n");  
            textR.append("Stock Mínimo: " + producto.getStockMinimo() + "\n");
            textR.append("Stock Máximo: " + producto.getStockMaximo() + "\n");
            textR.append("---------------------------------------------" + "\n");
        } else {
            textR.setText("Producto no encontrado" + "\n");
        }
    }

    protected void actionPerformedBtnEliminacion(ActionEvent e) {
        int codigo = Integer.parseInt(textCodigoProducto.getText());
        arregloProducto.eliminarProducto(codigo);
        textR.setText("Producto eliminado con éxito." + "\n");
        actualizarDatos();
    }

    protected void actionPerformedBtnListado(ActionEvent e) {
        actualizarDatos();
    }
    
    public void actualizarDatos() {
        textR.setText("");
        textNombre.setText("");
        textPrecio.setText("");
        textStockActual.setText("");
        textStockMinimo.setText("");
        textStockMaximo.setText("");
        
        StringBuilder listado = new StringBuilder();
        for (Producto producto : Datos.arregloProducto.getListaProducto()) {
            listado.append("Código Producto: " + producto.getCodigoProducto() + "\n")
                   .append("Nombre: " + producto.getNombre() + "\n")
                   .append("Precio: " + producto.getPrecio() + "\n")
                   .append("Stock Actual: " + producto.getStockActual() + "\n")
                   .append("Stock Minimo: " + producto.getStockMinimo() + "\n")
                   .append("Stock Maximo: " + producto.getStockMaximo() + "\n")
                   .append("\n")
                   .append("---------------------------------------------" + "\n")
                   .append("\n");
        }
        textR.setText(listado.toString());
    }
}