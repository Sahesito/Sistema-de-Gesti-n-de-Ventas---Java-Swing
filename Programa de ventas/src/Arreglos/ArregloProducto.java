package Arreglos;
import java.util.ArrayList;
import Clases.Producto;

public class ArregloProducto {
	private ArrayList<Producto> listaProducto;
    private static int contadorCodigo=2001;

    public ArregloProducto(){
        this.listaProducto = new ArrayList<>();
    }
    
    public void agregarProducto(String nombre,double precio, int stockActual, int stockMinimo, int stockMaximo) {
        Producto nuevoProducto=new Producto(nombre, precio, stockActual, stockMinimo, stockMaximo);
        nuevoProducto.setCodigoProducto(contadorCodigo++);
        listaProducto.add(nuevoProducto);
        System.out.println("Producto agregado con código: " + nuevoProducto.getCodigoProducto());
    }
    
    public void modificarProducto(int codigo, String nuevoNombre, double nuevoPrecio, int nuevoStockActual, int nuevoStockMinimo, int nuevoStockMaximo) {
        Producto producto=buscarProductoPorCodigo(codigo);
        if (producto != null){
        	producto.setNombre(nuevoNombre);
        	producto.setPrecio(nuevoPrecio);
        	producto.setStockActual(nuevoStockActual);
        	producto.setStockMinimo(nuevoStockMinimo);
        	producto.setStockMaximo(nuevoStockMaximo);
            System.out.println("Producto modificado con éxito.");
        } else{
            System.out.println("Producto no encontrado.");
        }
    }
    public Producto consultarProducto(int codigoProducto) {
        for (Producto producto : listaProducto) {
            if (producto.getCodigoProducto() == codigoProducto) {
                return producto;
            }
        }
        return null;
    }
    
    public void eliminarProducto(int codigo){
        Producto producto = buscarProductoPorCodigo(codigo);
        if (producto != null){
            listaProducto.remove(producto);
            System.out.println("Producto eliminado con éxito.");
        } else{
            System.out.println("Producto no encontrado.");
        }
    }

    public ArrayList<Producto>getListaProducto(){
        return listaProducto;
    }
    public Producto buscarProductoPorCodigo(int codigo){
        for (Producto producto:listaProducto){
            if (producto.getCodigoProducto()==codigo){
                return producto;
            }
        }
        return null;
    }

    public void mostrarDatosProducto(Producto producto){
        if (producto != null){
            System.out.println("Código Producto: " + producto.getCodigoProducto() + "\n");
            System.out.println("Nombre: " + producto.getNombre() + "\n");
            System.out.println("Precio: " + producto.getPrecio() + "\n");
            System.out.println("Stock Actual: " + producto.getStockActual() + "\n");
            System.out.println("Stock Minimo: " + producto.getStockMinimo() + "\n");
            System.out.println("Stock Maximo: " + producto.getStockMaximo() + "\n");
            System.out.println("---------------------------------------" + "\n");
        } else{
            System.out.println("Producto no encontrado.");
        }
    }
    public ArrayList<Producto> listarProductosConStockBajo() {
        ArrayList<Producto> productosBajoStock = new ArrayList<>();
        
        for (Producto producto : listaProducto) {
            if (producto.getStockActual() < producto.getStockMinimo()) {
                productosBajoStock.add(producto);
            }
        }
        return productosBajoStock;
    }
}
