package Clases;

public class Almacen {
    private int codigoProducto;
    private int cantidad;

    public Almacen(int codigoProducto, int cantidad) {
        this.codigoProducto = codigoProducto;
        this.cantidad = cantidad;
    }

    public int getCodigoProducto(){return codigoProducto;}
    public void setCodigoProducto(int codigoProducto){this.codigoProducto=codigoProducto;}

    public int getCantidad(){return cantidad;}
    public void setCantidad(int cantidad){this.cantidad = cantidad;}
}
