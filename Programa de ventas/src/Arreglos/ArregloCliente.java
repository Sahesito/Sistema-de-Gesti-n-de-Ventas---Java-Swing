package Arreglos;
import java.util.ArrayList;
import Clases.Cliente;

public class ArregloCliente{
    private ArrayList<Cliente> listaClientes;
    private static int contadorCodigo=1001;

    public ArregloCliente(){
        this.listaClientes = new ArrayList<>();
    }

    public void agregarCliente(String nombres, String apellidos, String direccion, String telefono, String dni) {
        Cliente nuevoCliente=new Cliente(nombres, apellidos, direccion, telefono, dni);
        nuevoCliente.setCodigoCliente(contadorCodigo++);
        listaClientes.add(nuevoCliente);
    }

    public void modificarCliente(int codigo, String nuevosNombres, String nuevosApellidos, String nuevaDireccion, String nuevoTelefono, String nuevoDni) {
        Cliente cliente=buscarClientePorCodigo(codigo);
        if (cliente != null){
            cliente.setNombres(nuevosNombres);
            cliente.setApellidos(nuevosApellidos);
            cliente.setDireccion(nuevaDireccion);
            cliente.setTelefono(nuevoTelefono);
            cliente.setDni(nuevoDni);
            System.out.println("Cliente modificado con éxito.");
        } else{
            System.out.println("Cliente no encontrado.");
        }
    }

    public Cliente consultarCliente(int codigo){
        return buscarClientePorCodigo(codigo);
    }

    public void eliminarCliente(int codigo){
        Cliente cliente = buscarClientePorCodigo(codigo);
        if (cliente != null){
            listaClientes.remove(cliente);
            System.out.println("Cliente eliminado con éxito.");
        } else{
            System.out.println("Cliente no encontrado.");
        }
    }

    public ArrayList<Cliente>getListaClientes(){
        return listaClientes;
    }

    private Cliente buscarClientePorCodigo(int codigo){
        for (Cliente cliente:listaClientes){
            if (cliente.getCodigoCliente()==codigo){
                return cliente;
            }
        }
        return null;
    }

    public void mostrarDatosCliente(Cliente cliente){
        if (cliente != null){
            System.out.println("Código: " + cliente.getCodigoCliente() + "\n");
            System.out.println("Nombre: " + cliente.getNombres() + " " + cliente.getApellidos() + "\n");
            System.out.println("Dirección: " + cliente.getDireccion() + "\n");
            System.out.println("Teléfono: " + cliente.getTelefono() + "\n");
            System.out.println("DNI: " + cliente.getDni() + "\n");
            System.out.println("---------------------------------------" + "\n");
        } else{
            System.out.println("Cliente no encontrado.");
        }
    }
}
