package Arreglos;

import java.util.ArrayList;
import Clases.Reporte;

public class ArregloReporte{
    private ArrayList<Reporte>listaReportes;

    public ArregloReporte(){
        this.listaReportes=new ArrayList<>();
    }

    public void agregarReporte(int codigoVenta, int codigoCliente, int codigoProducto, String fecha,
                double importeSubtotal, double importeIGV, double importeTotal){
        Reporte nuevoReporte=new Reporte(codigoVenta, codigoCliente, codigoProducto, fecha, importeSubtotal, importeIGV, importeTotal);
        listaReportes.add(nuevoReporte);
    }

    public ArrayList<Reporte>getListaReportes(){
        return listaReportes;
    }
    public ArrayList<Reporte>obtenerListadoVentas(){
        return listaReportes;
    }
}
