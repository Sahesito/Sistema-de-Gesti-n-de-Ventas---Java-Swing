package Arreglos;
import java.util.ArrayList;
import Clases.Venta;

public class ArregloVenta {
	private ArrayList<Venta> listaVenta;
    private static int contadorCodigoVenta=3001;
    public ArregloVenta(){
        listaVenta = new ArrayList<>();
    }
    
    public void agregarVenta(int codigoCliente, int codigoProducto, int cantidad, double precio, String fecha) {
        Venta nuevaVenta = new Venta(codigoCliente, codigoProducto, cantidad, precio, fecha);
        nuevaVenta.setCodigoVenta(contadorCodigoVenta++);
        listaVenta.add(nuevaVenta);
        
    }

    public Venta consultarVenta(int codigoVenta){
        return buscarVentaPorCodigo(codigoVenta);
    }
   
    public ArrayList<Venta>getListaVenta(){
        return listaVenta;
    }
    private Venta buscarVentaPorCodigo(int codigoVenta){
        for (Venta venta:listaVenta){
            if (venta.getCodigoVenta()==codigoVenta){
                return venta;
            }
        }
        return null;
    }
    
    
    public void mostrarDatosVenta(Venta venta){
        if (venta != null){
            System.out.println("Código Venta: " + venta.getCodigoVenta() + "\n");
            System.out.println("Código Producto: " + venta.getCodigoProducto() + "\n");
            System.out.println("Código Cliente: " + venta.getCodigoCliente() + "\n");
            System.out.println("Cantidad: " + venta.getCantidad() + "\n");
            System.out.println("Precio: " + venta.getPrecio() + "\n");
            System.out.println("Fecha: " + venta.getFecha() + "\n");
            System.out.println("---------------------------------------" + "\n");
        } else{
            System.out.println("Venta no encontrada.");
        }
    }
}

