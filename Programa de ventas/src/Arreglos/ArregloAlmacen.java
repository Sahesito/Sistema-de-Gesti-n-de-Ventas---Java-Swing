package Arreglos;
import java.util.ArrayList;
import Clases.Almacen;

public class ArregloAlmacen{
    private ArrayList<Almacen> listaAlmacen;
    public ArregloAlmacen(){
        this.listaAlmacen = new ArrayList<>();
    }
    public void ingresarStock(int codigoProducto, int cantidad) {
        Almacen almacenExistente = consultarAlmacen(codigoProducto);
        if (almacenExistente != null) {
            int nuevaCantidad = almacenExistente.getCantidad() + cantidad;
            almacenExistente.setCantidad(nuevaCantidad);
            System.out.println("Stock actualizado: Producto " + codigoProducto + "\n" + "Nueva Cantidad: " + nuevaCantidad);
        } else {
            listaAlmacen.add(new Almacen(codigoProducto, cantidad));
            System.out.println("Stock ingresado: Producto " + codigoProducto + "\n" + "Cantidad: " + cantidad);
        }
    }
    public ArrayList<Almacen>getListaAlmacen(){
        return listaAlmacen;
    }
    public Almacen consultarAlmacen(int codigoProducto){
        for (Almacen almacen:listaAlmacen){
            if (almacen.getCodigoProducto()==codigoProducto){
                return almacen;
            }
        }
        return null;
    }
}
