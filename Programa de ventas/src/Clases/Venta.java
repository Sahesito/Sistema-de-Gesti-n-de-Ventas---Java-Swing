package Clases;

public class Venta {
    private int codigoVenta;
    private int codigoCliente;
    private int codigoProducto;
    private int cantidad;
    private double precio;
    private double importeSubtotal;
    private double importeIGV;
    private double importeTotal;
    private String fecha;

    public Venta(int codigoCliente, int codigoProducto, int cantidad, double precio, String fecha) {
        this.codigoVenta = 0; 
        this.codigoCliente = codigoCliente;
        this.codigoProducto = codigoProducto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.fecha = fecha;
        this.importeSubtotal = calcularImporteSubtotal(); 
        this.importeIGV = calcularImporteIGV(); 
        this.importeTotal = calcularImporteTotal(); 
    }

 
    private double calcularImporteSubtotal() {
        return precio * cantidad;
    }

    private double calcularImporteIGV() {
        return importeSubtotal * 0.18;
    }

    private double calcularImporteTotal() {
        return importeSubtotal + importeIGV;
    }

    public int getCodigoVenta() {
        return codigoVenta;
    }
    public void setCodigoVenta(int codigoVenta) {
        this.codigoVenta = codigoVenta;
    }
    public int getCodigoCliente() {
        return codigoCliente;
    }
    public void setCodigoCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
    }
    public int getCodigoProducto() {
        return codigoProducto;
    }
    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
        this.importeSubtotal = calcularImporteSubtotal();
        this.importeIGV = calcularImporteIGV();
        this.importeTotal = calcularImporteTotal();
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
        this.importeSubtotal = calcularImporteSubtotal();
        this.importeIGV = calcularImporteIGV();
        this.importeTotal = calcularImporteTotal();
    }
    public double getImporteSubtotal() {
        return importeSubtotal;
    }
    public double getImporteIGV() {
        return importeIGV;
    }
    public double getImporteTotal() {
        return importeTotal;
    }
    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
