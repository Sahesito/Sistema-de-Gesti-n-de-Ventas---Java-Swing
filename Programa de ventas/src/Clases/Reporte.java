package Clases;

public class Reporte {
    private int codigoVenta;
    private int codigoCliente;
    private int codigoProducto;
    private String fecha;
    private double importeSubtotal;
    private double importeIGV;
    private double importeTotal;

    public Reporte(int codigoVenta, int codigoCliente, int codigoProducto, String fecha, double importeSubtotal, double importeIGV, double importeTotal) {
        this.codigoVenta=codigoVenta;
        this.codigoCliente=codigoCliente;
        this.codigoProducto=codigoProducto;
        this.fecha=fecha;
        this.importeSubtotal=importeSubtotal;
        this.importeIGV=importeIGV;
        this.importeTotal=importeTotal;
    }

    public int getCodigoVenta(){return codigoVenta;}
    public int getCodigoCliente(){return codigoCliente;}
    public int getCodigoProducto(){return codigoProducto;}
    public String getFecha(){return fecha;}
    public double getImporteSubtotal(){return importeSubtotal;}
    public double getImporteIGV(){return importeIGV;}
    public double getImporteTotal(){return importeTotal;}
}
