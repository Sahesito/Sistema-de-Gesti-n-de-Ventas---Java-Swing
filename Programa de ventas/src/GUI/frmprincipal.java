package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Arreglos.*;
public class frmprincipal extends JFrame implements ActionListener{
	public static ArregloCliente misClientes=new ArregloCliente();
	public static double sumventas=0;
	public static int cantventas=0;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnMantenimiento;
	private JMenu mnVentas;
	private JMenu mnAlmacen;
	private JMenu mnReportes;
	private JMenuItem mntmClientes;
	private JMenuItem mntmProductos;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmRegistroAlmacen;
	private JMenuItem mntmRegistroReportes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmprincipal frame = new frmprincipal();
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
	public frmprincipal() {
		setTitle("PROGRAMA DE VENTAS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnMantenimiento = new JMenu("Mantenimiento");
		menuBar.add(mnMantenimiento);
		
		mntmClientes = new JMenuItem("Clientes");
		mntmClientes.addActionListener(this);
		mnMantenimiento.add(mntmClientes);
		
		mntmProductos = new JMenuItem("Productos");
		mntmProductos.addActionListener(this);
		mnMantenimiento.add(mntmProductos);
		
		mnVentas = new JMenu("Ventas");
		menuBar.add(mnVentas);
		
		mntmNewMenuItem = new JMenuItem("Ventas");
		mntmNewMenuItem.addActionListener(this);
		mnVentas.add(mntmNewMenuItem);
		
		mnAlmacen = new JMenu("Almac\u00E9n");
		menuBar.add(mnAlmacen);
		
		mntmRegistroAlmacen = new JMenuItem("Registro Almacen");
		mntmRegistroAlmacen.addActionListener(this);
		mnAlmacen.add(mntmRegistroAlmacen);
		
		mnReportes = new JMenu("Reportes");
		menuBar.add(mnReportes);
		
		mntmRegistroReportes = new JMenuItem("Registro Reportes");
		mntmRegistroReportes.addActionListener(this);
		mnReportes.add(mntmRegistroReportes);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == mntmRegistroReportes) {
			actionPerformedMntmRegistroReportes(arg0);
		}
		if (arg0.getSource() == mntmRegistroAlmacen) {
			actionPerformedMntmRegistroAlmacen(arg0);
		}
		if (arg0.getSource() == mntmNewMenuItem) {
			actionPerformedMntmNewMenuItem(arg0);
		}
		if (arg0.getSource() == mntmProductos) {
			actionPerformedMntmProductos(arg0);
		}
		if (arg0.getSource() == mntmClientes) {
			actionPerformedMntmClientes(arg0);
		}
	}
	protected void actionPerformedMntmClientes(ActionEvent arg0) {
	frmCliente frm=new frmCliente();
	getContentPane().add(frm);
	frm.show();
	}
	protected void actionPerformedMntmProductos(ActionEvent arg0) {
	frmProducto frm=new frmProducto();
	getContentPane().add(frm);
	frm.show();
	}
	protected void actionPerformedMntmNewMenuItem(ActionEvent arg0) {
	frmVenta frm=new frmVenta();
	getContentPane().add(frm);
	frm.show();
	}
	protected void actionPerformedMntmRegistroAlmacen(ActionEvent arg0) {
	frmAlmacen frm=new frmAlmacen();
	getContentPane().add(frm);
	frm.show();
	}
	protected void actionPerformedMntmRegistroReportes(ActionEvent arg0) {
	frmReporte frm=new frmReporte();
	getContentPane().add(frm);
	frm.show();
	}
}
