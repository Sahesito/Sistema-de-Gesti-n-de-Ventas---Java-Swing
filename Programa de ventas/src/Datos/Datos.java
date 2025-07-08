package Datos;
import Arreglos.ArregloCliente;
import Arreglos.ArregloReporte;
import Arreglos.ArregloProducto;
import Arreglos.ArregloVenta;
import Arreglos.ArregloAlmacen;

public class Datos {
    public static ArregloCliente arregloCliente = new ArregloCliente();
    public static ArregloProducto arregloProducto = new ArregloProducto();
    public static ArregloVenta arregloVenta = new ArregloVenta();
    public static ArregloAlmacen arregloAlmacen = new ArregloAlmacen();
    public static ArregloReporte arregloReporte = new ArregloReporte();
    
    static {
        inicializarClientes();
        inicializarProductos();
    }

    public static void inicializarClientes() {
        arregloCliente.agregarCliente("Juan", "Pérez", "Av. Principal 123", "987654321", "12345678");
        arregloCliente.agregarCliente("María", "Gómez", "Calle Secundaria 456", "976543210", "23456789");
        arregloCliente.agregarCliente("Luis", "Martínez", "Pasaje Tercero 789", "965432109", "34567890");
        arregloCliente.agregarCliente("Ana", "López", "Av. Cuarta 321", "954321098", "45678901");
        arregloCliente.agregarCliente("Carlos", "Fernández", "Calle Quinto 654", "943210987", "56789012");
        arregloCliente.agregarCliente("Laura", "Torres", "Calle Sábado 987", "932109876", "67890123");
        arregloCliente.agregarCliente("Pedro", "Ramírez", "Av. Domingo 135", "921098765", "78901234");
        arregloCliente.agregarCliente("Carmen", "Hernández", "Calle Martes 246", "910987654", "89012345");
        arregloCliente.agregarCliente("Jorge", "Castillo", "Av. Jueves 357", "909876543", "90123456");
        arregloCliente.agregarCliente("Patricia", "Vásquez", "Calle Viernes 468", "898765432", "01234567");
    }

    public static void inicializarProductos() {
        arregloProducto.agregarProducto("Leche", 2.50, 100, 10, 200);
        arregloProducto.agregarProducto("Pan", 1.00, 50, 5, 100);
        arregloProducto.agregarProducto("Arroz", 3.00, 30, 5, 60);
        arregloProducto.agregarProducto("Azúcar", 1.50, 80, 10, 150);
        arregloProducto.agregarProducto("Sal", 0.80, 60, 5, 100);
        arregloProducto.agregarProducto("Harina", 2.00, 50, 10, 80);
        arregloProducto.agregarProducto("Aceite", 3.20, 40, 5, 70);
        arregloProducto.agregarProducto("Café", 4.00, 20, 5, 50);
        arregloProducto.agregarProducto("Té", 2.80, 25, 5, 60);
        arregloProducto.agregarProducto("Mantequilla", 3.50, 30, 5, 50);
    }
}

