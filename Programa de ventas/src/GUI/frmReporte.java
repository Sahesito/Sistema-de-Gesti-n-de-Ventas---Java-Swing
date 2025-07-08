package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

import Datos.Datos;
import Clases.Venta;
import Clases.Producto;
import Clases.Reporte;

public class frmReporte extends JInternalFrame implements ActionListener {
    private JButton btnListadoVentas;
    private JButton btnStockBajo;
    private JButton btnUnidadesVendidas;
    private JButton btnImporteTotal;
    private JTextArea textR;
    private JScrollPane scrollPane;

    public frmReporte() {
        setTitle("Reportes");
        setIconifiable(true);
        setMaximizable(true);
        setClosable(true);
        setBounds(100, 100, 450, 300);
        getContentPane().setLayout(null);

        btnListadoVentas = new JButton("Listado de Ventas");
        btnListadoVentas.setBounds(10, 11, 150, 23);
        btnListadoVentas.addActionListener(this);
        getContentPane().add(btnListadoVentas);

        btnStockBajo = new JButton("Stock Bajo");
        btnStockBajo.setBounds(10, 45, 150, 23);
        btnStockBajo.addActionListener(this);
        getContentPane().add(btnStockBajo);

        btnUnidadesVendidas = new JButton("Unidades Vendidas");
        btnUnidadesVendidas.setBounds(10, 79, 150, 23);
        btnUnidadesVendidas.addActionListener(this);
        getContentPane().add(btnUnidadesVendidas);

        btnImporteTotal = new JButton("Importe Total");
        btnImporteTotal.setBounds(10, 113, 150, 23);
        btnImporteTotal.addActionListener(this);
        getContentPane().add(btnImporteTotal);
        
        scrollPane = new JScrollPane();
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(10, 150, 414, 109);
        getContentPane().add(scrollPane);
        
                textR = new JTextArea();
                scrollPane.setViewportView(textR);
                textR.setEditable(false);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnListadoVentas) {
            mostrarListadoVentas();
        } else if (e.getSource() == btnStockBajo) {
            mostrarListadoStockMinimo();
        } else if (e.getSource() == btnUnidadesVendidas) {
            mostrarListadoUnidadesVendidas();
        } else if (e.getSource() == btnImporteTotal) {
            mostrarListadoImporteTotal();
        }
    }

    private void mostrarListadoVentas(){
    	textR.setText("");
        StringBuilder listado = new StringBuilder();
        
        for (Venta venta : Datos.arregloVenta.getListaVenta()) {
            listado.append("Código de Venta: " + venta.getCodigoVenta() + "\n")
                   .append("Código de Cliente: " + venta.getCodigoCliente() + "\n")
                   .append("Código de Producto: " + venta.getCodigoProducto() + "\n")
                   .append("Fecha: " + venta.getFecha() + "\n")
                   .append("Importe Subtotal: " + venta.getImporteSubtotal() + "\n")
                   .append("Importe IGV: " + venta.getImporteIGV() + "\n")
                   .append("Importe Total: " + venta.getImporteTotal() + "\n")
                   .append("---------------------------------------------" + "\n")
                   .append("\n");
        }

        textR.setText(listado.toString());
    }

    private void mostrarListadoStockMinimo() {
    	textR.setText("");

        ArrayList<Producto> productosBajoStock = Datos.arregloProducto.listarProductosConStockBajo();
        
        if (productosBajoStock.isEmpty()) {
            textR.setText("No hay productos con stock bajo.\n");
        } else {
            StringBuilder listado = new StringBuilder();
            for (Producto producto : productosBajoStock) {
                listado.append("Código Producto: " + producto.getCodigoProducto() + "\n")
                       .append("Nombre: " + producto.getNombre() + "\n")
                       .append("Stock Actual: " + producto.getStockActual() + "\n")
                       .append("Stock Mínimo: " + producto.getStockMinimo() + "\n")
                       .append("---------------------------------------------\n");
            }
            textR.setText(listado.toString());
        }
    }

    private void mostrarListadoUnidadesVendidas() {
        Map<Integer, Integer>unidadesVendidas=new HashMap<>();
        for (Venta venta:Datos.arregloVenta.getListaVenta()){
            unidadesVendidas.put(venta.getCodigoProducto(), unidadesVendidas.getOrDefault(venta.getCodigoProducto(), 0) + venta.getCantidad());
        }

        StringBuilder listado=new StringBuilder();
        listado.append("Unidades Vendidas:\n");
        for (Map.Entry<Integer, Integer> entry:unidadesVendidas.entrySet()) {
            listado.append("Código Producto: " + entry.getKey() + "\n")
                   .append("Cantidad Vendida: " + entry.getValue() + "\n")
                   .append("-------------------------------------------------" + "\n");
        }
        textR.setText(listado.toString());
    }

    private void mostrarListadoImporteTotal() {
        Map<Integer, Double>importeTotal=new HashMap<>();
        for (Venta venta:Datos.arregloVenta.getListaVenta()) {
            importeTotal.put(venta.getCodigoProducto(), importeTotal.getOrDefault(venta.getCodigoProducto(), 0.0) + (venta.getPrecio() * venta.getCantidad()));
        }

        StringBuilder listado=new StringBuilder();
        listado.append("Importe Total: " + "\n");
        for (Map.Entry<Integer, Double>entry:importeTotal.entrySet()) {
            listado.append("Código Producto: " + entry.getValue() + "\n")
                   .append("Importe Total Acumulado: " + entry.getValue() + "\n")
                   .append("-------------------------------------------------" + "\n");
        }
        textR.setText(listado.toString());
    }
}
