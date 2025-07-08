package GUI;

import java.awt.EventQueue;
import javax.swing.JInternalFrame;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import Clases.Cliente;
import Clases.Producto;
import Clases.Venta;
import Arreglos.ArregloCliente;
import Arreglos.ArregloProducto;
import Arreglos.ArregloVenta;
import Datos.Datos;

public class frmVenta extends JInternalFrame implements ActionListener {
    private JLabel lblCdigoVentas;
    private JTextField textCodigoVenta;
    private JTextField textCodigoCliente;
    private JLabel lblCodigoCliente;
    private JLabel lblCodigoProducto;
    private JTextField textCodigoProducto;
    private JTextField textCantidad;
    private JLabel lblCantidad;
    private JTextField textFecha;
    private JLabel lblFecha;
    private JScrollPane scrollPane;
    private JTextArea textR;
    private ArregloVenta arregloVenta;
    private ArregloCliente arregloCliente;
    private ArregloProducto arregloProducto;
    private JButton btnIngresar;
    private JButton btnConsulta;
    private JButton btnListado;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frmVenta frame = new frmVenta();
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
    public frmVenta() {
    	setMaximizable(true);
    	setIconifiable(true);
    	setClosable(true);
        setTitle("Ventas");
        setBounds(100, 100, 450, 348);
        getContentPane().setLayout(null);
        
        lblCdigoVentas = new JLabel("Código Venta:");
        lblCdigoVentas.setBounds(10, 14, 100, 14);
        getContentPane().add(lblCdigoVentas);
        
        textCodigoVenta = new JTextField();
        textCodigoVenta.setColumns(10);
        textCodigoVenta.setBounds(120, 11, 86, 20);
        getContentPane().add(textCodigoVenta);
        
        textCodigoCliente = new JTextField();
        textCodigoCliente.setColumns(10);
        textCodigoCliente.setBounds(120, 36, 86, 20);
        getContentPane().add(textCodigoCliente);
        
        lblCodigoCliente = new JLabel("Código Cliente:");
        lblCodigoCliente.setBounds(10, 39, 100, 14);
        getContentPane().add(lblCodigoCliente);
        
        lblCodigoProducto = new JLabel("Código Producto:");
        lblCodigoProducto.setBounds(10, 64, 100, 14);
        getContentPane().add(lblCodigoProducto);
        
        textCodigoProducto = new JTextField();
        textCodigoProducto.setColumns(10);
        textCodigoProducto.setBounds(120, 61, 86, 20);
        getContentPane().add(textCodigoProducto);
        
        textCantidad = new JTextField();
        textCantidad.setColumns(10);
        textCantidad.setBounds(120, 86, 86, 20);
        getContentPane().add(textCantidad);
        
        lblCantidad = new JLabel("Cantidad:");
        lblCantidad.setBounds(10, 89, 100, 14);
        getContentPane().add(lblCantidad);
        
        textFecha = new JTextField();
        textFecha.setColumns(10);
        textFecha.setBounds(120, 111, 86, 20);
        getContentPane().add(textFecha);
        
        lblFecha = new JLabel("Fecha:");
        lblFecha.setBounds(10, 114, 100, 14);
        getContentPane().add(lblFecha);
        
        scrollPane = new JScrollPane();
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(233, 14, 191, 286);
        getContentPane().add(scrollPane);
        
        textR = new JTextArea();
        textR.setEditable(false);
        scrollPane.setViewportView(textR);
        
        btnIngresar = new JButton("Ingresar");
        btnIngresar.addActionListener(this);
        btnIngresar.setBounds(10, 157, 89, 23);
        getContentPane().add(btnIngresar);
        
        btnConsulta = new JButton("Consulta");
        btnConsulta.addActionListener(this);
        btnConsulta.setBounds(10, 194, 89, 23);
        getContentPane().add(btnConsulta);
        
        btnListado = new JButton("Listado");
        btnListado.addActionListener(this);
        btnListado.setBounds(10, 228, 89, 23);
        getContentPane().add(btnListado);
        arregloProducto = Datos.arregloProducto;
        arregloVenta = Datos.arregloVenta;
        arregloCliente = Datos.arregloCliente;
    }

    public void actionPerformed(ActionEvent e) {
    	if (e.getSource() == btnListado) {
    		actionPerformedBtnListado(e);
    	}
    	if (e.getSource() == btnConsulta) {
    		actionPerformedBtnConsulta(e);
    	}
    	if (e.getSource() == btnIngresar) {
    		actionPerformedBtnIngresar(e);
    	}
    }

	protected void actionPerformedBtnIngresar(ActionEvent e) {
		   int codigoCliente = Integer.parseInt(textCodigoCliente.getText());
	        int codigoProducto = Integer.parseInt(textCodigoProducto.getText());
	        int cantidad = Integer.parseInt(textCantidad.getText());
	        String fecha = textFecha.getText();

	        Producto producto = Datos.arregloProducto.buscarProductoPorCodigo(codigoProducto);
	        if (producto == null) {
	            JOptionPane.showMessageDialog(this, "Producto no encontrado");
	            return;
	        }
	        double precio = producto.getPrecio();

	        Venta nuevaVenta = new Venta(codigoCliente, codigoProducto, cantidad, precio, fecha);

	        Datos.arregloVenta.agregarVenta(codigoCliente, codigoProducto, cantidad, precio, fecha);

	        JOptionPane.showMessageDialog(this, "Venta registrada correctamente.");
	}
	protected void actionPerformedBtnConsulta(ActionEvent e) {
	    try {
	        int codigoVenta = Integer.parseInt(textCodigoVenta.getText());
	     
	        Venta venta = Datos.arregloVenta.consultarVenta(codigoVenta);
	        
	        if (venta != null) {
	            int codigoCliente = venta.getCodigoCliente();
	            Cliente cliente = Datos.arregloCliente.consultarCliente(codigoCliente);
	            
	            int codigoProducto = venta.getCodigoProducto();
	            Producto producto = Datos.arregloProducto.consultarProducto(codigoProducto);
	            
	            double subtotal = venta.getPrecio() * venta.getCantidad();
	            double igv = subtotal * 0.18;
	            double total = subtotal + igv;

	            StringBuilder sb = new StringBuilder();
	            sb.append("Código Cliente: ").append(codigoCliente).append("\n")
	              .append("Nombres y Apellidos: ").append(cliente.getNombres()).append(" ").append(cliente.getApellidos()).append("\n")
	              .append("Código Producto: ").append(codigoProducto).append("\n")
	              .append("Nombre Producto: ").append(producto.getNombre()).append("\n")
	              .append("Cantidad: ").append(venta.getCantidad()).append("\n")
	              .append("Precio: ").append(venta.getPrecio()).append("\n")
	              .append("Importe Subtotal: ").append(subtotal).append("\n")
	              .append("Importe IGV: ").append(igv).append("\n")
	              .append("Importe Total: ").append(total).append("\n");
	            
	            textR.setText(sb.toString());
	        } else {
	            JOptionPane.showMessageDialog(this, "Venta no encontrada.");
	        }
	    } catch (NumberFormatException ex) {
	        JOptionPane.showMessageDialog(this, "Por favor ingresa un código de venta válido.");
	    }
	}

	protected void actionPerformedBtnListado(ActionEvent e) {
		StringBuilder sb = new StringBuilder();
	    

	    ArrayList<Venta> listaVentas = Datos.arregloVenta.getListaVenta();
	    
	    if (listaVentas.isEmpty()) {
	        sb.append("No hay ventas registradas.");
	    } else {
	        for (Venta venta : listaVentas) {
	     
	            Cliente cliente = Datos.arregloCliente.consultarCliente(venta.getCodigoCliente());

	            Producto producto = Datos.arregloProducto.consultarProducto(venta.getCodigoProducto());
	            
	           
	            double subtotal = venta.getPrecio() * venta.getCantidad();
	            double igv = subtotal * 0.18;
	            double total = subtotal + igv;


	            sb.append("Código Venta: ").append(venta.getCodigoVenta()).append("\n")
	              .append("Código Cliente: ").append(venta.getCodigoCliente()).append("\n")
	              .append("Nombres y Apellidos: ").append(cliente.getNombres()).append(" ").append(cliente.getApellidos()).append("\n")
	              .append("Código Producto: ").append(venta.getCodigoProducto()).append("\n")
	              .append("Nombre Producto: ").append(producto.getNombre()).append("\n")
	              .append("Cantidad: ").append(venta.getCantidad()).append("\n")
	              .append("Precio: ").append(venta.getPrecio()).append("\n")
	              .append("Importe Subtotal: ").append(subtotal).append("\n")
	              .append("Importe IGV: ").append(igv).append("\n")
	              .append("Importe Total: ").append(total).append("\n")
	              .append("---------------------------------------\n");
	        }
	    }
	  
	    textR.setText(sb.toString());
	}
}
