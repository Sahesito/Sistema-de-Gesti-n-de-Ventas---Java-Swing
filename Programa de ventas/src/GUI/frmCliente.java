package GUI;

import java.awt.EventQueue;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import Arreglos.ArregloCliente;
import Clases.Cliente;
import Datos.Datos;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ScrollPaneConstants;

public class frmCliente extends JInternalFrame implements ActionListener{
    private JLabel lblNewLabel;
    private JLabel lblNewLabel_1;
    private JLabel lblNewLabel_2;
    private JLabel lblNewLabel_3;
    private JLabel lblNewLabel_4;
    private JTextField textCodigo;
    private JTextField textNombres;
    private JTextField textApellidos;
    private JTextField textDireccion;
    private JTextField textDni;
    private JScrollPane scrollPane;
    private JTextArea textR;
    private JButton btnIngreso;
    private JButton btnModificacion;
    private JButton btnConsulta;
    private JButton btnEliminicacion;
    private JButton btnListado;

    private ArregloCliente arregloClientes;
    private JLabel lblTelfono;
    private JTextField textTelefono;
    private JLabel label;
    private JLabel lblNewLabel_5;
    private JLabel lblNewLabel_6;
    private JLabel lblNewLabel_7;
    private JLabel lblNewLabel_8;
    private JLabel lblNewLabel_9;
    
    /**
	 * Launch the application.
	 */
    public static void main(String[]args){
        EventQueue.invokeLater(new Runnable(){
            public void run(){
                try {
                    frmCliente frame=new frmCliente();
                    frame.setVisible(true);
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    public frmCliente() {
        setIconifiable(true);
        setClosable(true);
        setTitle("Cliente");
        setMaximizable(true);
        setBounds(100, 100, 452, 330);
        getContentPane().setLayout(null);

        label = new JLabel("Código Cliente:");
        label.setBounds(10, 11, 100, 14);
        getContentPane().add(label);

        lblNewLabel_5 = new JLabel("Nombres:");
        lblNewLabel_5.setBounds(10, 36, 100, 14);
        getContentPane().add(lblNewLabel_5);

        lblNewLabel_6 = new JLabel("Apellidos:");
        lblNewLabel_6.setBounds(10, 61, 100, 14);
        getContentPane().add(lblNewLabel_6);

        lblNewLabel_7 = new JLabel("Dirección:");
        lblNewLabel_7.setBounds(10, 86, 100, 14);
        getContentPane().add(lblNewLabel_7);

        lblNewLabel_8 = new JLabel("Teléfono:");
        lblNewLabel_8.setBounds(10, 111, 100, 14);
        getContentPane().add(lblNewLabel_8);

        lblNewLabel_9 = new JLabel("DNI:");
        lblNewLabel_9.setBounds(10, 136, 100, 14);
        getContentPane().add(lblNewLabel_9);

        textCodigo = new JTextField();
        textCodigo.setBounds(120, 8, 86, 20);
        getContentPane().add(textCodigo);
        textCodigo.setColumns(10);

        textNombres = new JTextField();
        textNombres.setBounds(120, 33, 86, 20);
        getContentPane().add(textNombres);
        textNombres.setColumns(10);

        textApellidos = new JTextField();
        textApellidos.setBounds(120, 58, 86, 20);
        getContentPane().add(textApellidos);
        textApellidos.setColumns(10);

        textDireccion = new JTextField();
        textDireccion.setBounds(120, 83, 86, 20);
        getContentPane().add(textDireccion);
        textDireccion.setColumns(10);

        textTelefono = new JTextField();
        textTelefono.setBounds(120, 108, 86, 20);
        getContentPane().add(textTelefono);
        textTelefono.setColumns(10);

        textDni = new JTextField();
        textDni.setBounds(120, 133, 86, 20);
        getContentPane().add(textDni);
        textDni.setColumns(10);

        scrollPane = new JScrollPane();
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(212, 11, 212, 248);
        getContentPane().add(scrollPane);

        textR = new JTextArea();
        textR.setEditable(false);
        scrollPane.setViewportView(textR);

        btnIngreso = new JButton("Ingreso");
        btnIngreso.addActionListener(this);
        btnIngreso.setBounds(10, 162, 111, 23);
        getContentPane().add(btnIngreso);

        btnModificacion = new JButton("Modificación");
        btnModificacion.addActionListener(this);
        btnModificacion.setBounds(10, 187, 111, 23);
        getContentPane().add(btnModificacion);

        btnConsulta = new JButton("Consulta");
        btnConsulta.addActionListener(this);
        btnConsulta.setBounds(10, 212, 111, 23);
        getContentPane().add(btnConsulta);

        btnEliminicacion = new JButton("Eliminación");
        btnEliminicacion.addActionListener(this);
        btnEliminicacion.setBounds(10, 237, 111, 23);
        getContentPane().add(btnEliminicacion);

        btnListado = new JButton("Listado");
        btnListado.addActionListener(this);
        btnListado.setBounds(10, 262, 111, 23);
        getContentPane().add(btnListado);
        arregloClientes = Datos.arregloCliente;

    }

    public void actionPerformed(ActionEvent arg0){
        if (arg0.getSource() == btnListado){
            actionPerformedBtnListado(arg0);
        }
        if (arg0.getSource() == btnEliminicacion){
            actionPerformedBtnEliminicacion(arg0);
        }
        if (arg0.getSource() == btnConsulta){
            actionPerformedBtnConsulta(arg0);
        }
        if (arg0.getSource() == btnModificacion){
            actionPerformedBtnModificacion(arg0);
        }
        if (arg0.getSource() == btnIngreso){
            actionPerformedBtnIngreso(arg0);
        }
    }

    protected void actionPerformedBtnIngreso(ActionEvent arg0){
        String nombres=textNombres.getText();
        String apellidos=textApellidos.getText();
        String direccion=textDireccion.getText();
        String telefono=textTelefono.getText();
        String dni=textDni.getText();
        arregloClientes.agregarCliente(nombres, apellidos, direccion, telefono, dni);

        textR.setText("Cliente agregado con éxito." + "\n");
        
    }

    protected void actionPerformedBtnModificacion(ActionEvent arg0){
        int codigo=Integer.parseInt(textCodigo.getText());
        String nuevosNombres=textNombres.getText();
        String nuevosApellidos=textApellidos.getText();
        String nuevaDireccion=textDireccion.getText();
        String nuevoTelefono=textTelefono.getText();
        String nuevoDni=textDni.getText();

        arregloClientes.modificarCliente(codigo, nuevosNombres, nuevosApellidos, nuevaDireccion, nuevoTelefono, nuevoDni);
        textR.setText("Cliente modificado con éxito." + "\n");
    }

    protected void actionPerformedBtnConsulta(ActionEvent arg0){
        int codigo=Integer.parseInt(textCodigo.getText());
        Cliente cliente=arregloClientes.consultarCliente(codigo);
        if (cliente!=null) {
            textR.setText("Cliente encontrado: " + "\n");
            textR.append("Codigo Cliente: " + cliente.getCodigoCliente() + "\n");
            textR.append("Nombre: " + cliente.getNombres() + "\n");
            textR.append("Apellidos: " + cliente.getApellidos() + "\n");
            textR.append("Dirección: " + cliente.getDireccion() + "\n");  
            textR.append("Teléfono: " + cliente.getTelefono() + "\n");
            textR.append("DNI: " + cliente.getDni() + "\n");
            textR.append("---------------------------------------------" + "\n");
        } else {
            textR.setText("Cliente no encontrado" + "\n");
        }
    }

    protected void actionPerformedBtnEliminicacion(ActionEvent arg0){
        int codigo=Integer.parseInt(textCodigo.getText());
        arregloClientes.eliminarCliente(codigo);
        textR.setText("Cliente eliminado con éxito." + "\n");
        
    }

    protected void actionPerformedBtnListado(ActionEvent arg0){
    	textCodigo.setText("");
    	textNombres.setText("");
    	textApellidos.setText("");
    	textDireccion.setText("");
    	textTelefono.setText("");
    	textDni.setText("");
    	textR.setText("");
        StringBuilder listado=new StringBuilder();
        for (Cliente cliente:arregloClientes.getListaClientes()){
            listado.append("Código Cliente: " + cliente.getCodigoCliente() + "\n")
                   .append("Nombre: " + cliente.getNombres() + "\n")
                   .append("Apellidos: " + cliente.getApellidos() + "\n")
                   .append("Dirección: " + cliente.getDireccion() + "\n")
                   .append("Teléfono: " + cliente.getTelefono() + "\n")
                   .append("DNI: " + cliente.getDni() + "\n")
                   .append("\n")
                   .append("-----------------------------------------" + "\n")
                   .append("\n");
            	
        }
        textR.setText(listado.toString());
    }
}
