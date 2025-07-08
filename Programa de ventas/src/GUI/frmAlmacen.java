package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Datos.Datos;
import Arreglos.ArregloAlmacen;
import Clases.Producto;

public class frmAlmacen extends JInternalFrame implements ActionListener {
    private JTextField textCodigoProducto;
    private JTextField textCantidad;
    private JTextArea textR;
    private ArregloAlmacen arregloAlmacen;
    private JButton btnIngresar;

    public frmAlmacen() {
        setTitle("INGRESO ALMACEN");
        setIconifiable(true);
        setMaximizable(true);
        setClosable(true);
        setBounds(100, 100, 444, 289);
        getContentPane().setLayout(null);

        JLabel lblCodigoProducto = new JLabel("Código Producto:");
        lblCodigoProducto.setBounds(10, 14, 120, 14);
        getContentPane().add(lblCodigoProducto);

        textCodigoProducto = new JTextField();
        textCodigoProducto.setBounds(130, 11, 86, 20);
        getContentPane().add(textCodigoProducto);
        textCodigoProducto.setColumns(10);

        JLabel lblCantidad = new JLabel("Cantidad:");
        lblCantidad.setBounds(10, 39, 120, 14);
        getContentPane().add(lblCantidad);

        textCantidad = new JTextField();
        textCantidad.setBounds(130, 36, 86, 20);
        getContentPane().add(textCantidad);
        textCantidad.setColumns(10);

        textR = new JTextArea();
        textR.setBounds(10, 98, 414, 152);
        getContentPane().add(textR);
        
        btnIngresar = new JButton("Ingresar Stock");
        btnIngresar.addActionListener(this);
        btnIngresar.setBounds(10, 64, 120, 23);
        getContentPane().add(btnIngresar);

        arregloAlmacen = Datos.arregloAlmacen;
    }

    public void actionPerformed(ActionEvent e) {
    	if (e.getSource() == btnIngresar) {
    		actionPerformedBtnIngresar(e);
    	}
    }

    protected void actionPerformedBtnIngresar(ActionEvent e) {
    	    int codigoProducto = Integer.parseInt(textCodigoProducto.getText());
    	    int cantidadIngreso = Integer.parseInt(textCantidad.getText());

    	    Producto producto = Datos.arregloProducto.consultarProducto(codigoProducto);
    	    
    	    if (producto != null) {
    	        int nuevoStockActual = producto.getStockActual() + cantidadIngreso;

    	        if (nuevoStockActual > producto.getStockMaximo()) {
    	            textR.setText("Error: El stock máximo es " + producto.getStockMaximo() + ", no se puede exceder." + "\n");
    	            return;
    	        }

    	        producto.setStockActual(nuevoStockActual);
    	        textR.setText("Stock ingresado correctamente." + "\n");
    	        
    	    } else {
    	        textR.setText("Error: Producto no encontrado." + "\n");
    	    }
    	}


}
