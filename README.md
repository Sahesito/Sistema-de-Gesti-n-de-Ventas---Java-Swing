# 🧾 Sistema de Programa de ventas

**Programa de ventas** es una aplicación de escritorio desarrollada en **Java Swing**, que simula un sistema de ventas con registro de clientes, productos, ventas, control de stock y reportes. Está diseñada con un enfoque educativo para enseñar conceptos clave como POO, estructuras dinámicas (`ArrayList`), arquitectura en capas y manejo de interfaces tipo MDI.

---

## 📌 Descripción general

Esta aplicación te permite:

- Registrar y consultar **clientes**
- Agregar, editar y consultar **productos**
- Gestionar **ventas** con cálculo automático de subtotales, IGV y totales
- Verificar **stock mínimo** automáticamente
- Generar reportes de ventas, unidades e importes
- Configurar fácilmente los datos del sistema

---

## ⚙️ Tecnologías usadas

| Tecnología | Descripción                          |
|------------|--------------------------------------|
| Java       | Lenguaje principal                   |
| Java Swing | Toolkit para interfaz gráfica        |
| JDK 8+     | Requiere Java Development Kit 8 o superior |
| IDE        | Compatible con IntelliJ, NetBeans o Eclipse |

---

## 🚀 Funcionalidades principales

### 👤 Clientes
- Registro de clientes con nombre, apellidos, dirección, teléfono y DNI
- Consulta por código
- Modificación y eliminación

### 📦 Productos
- Registro de productos con nombre, precio, stock actual, mínimo y máximo
- Consulta por código
- Listado general
- Alerta de **stock bajo**
- Modificación y eliminación

### 🛒 Ventas
- Registro de ventas con:
  - Código cliente
  - Código producto
  - Cantidad
  - Precio por unidad (automático)
  - Fecha
- Cálculo automático de:
  - Subtotal
  - IGV (18%)
  - Total
- Listado general de ventas
- Consulta por código de venta

### 📊 Reportes
- Reporte de productos con stock bajo
- Unidades vendidas por producto
- Importe total por producto
- Estadísticas personalizadas (según necesidad)

---

## 🧩 Estructura del Proyecto
src/<br>
├── Clases/<br>
│ ├── Cliente.java<br>
│ ├── Producto.java<br>
│ ├── Venta.java<br>
│ └── Almacen.java<br>
├── Datos/<br>
│ └── Datos.java # Carga inicial de datos<br>
├── Arreglos/<br>
│ ├── ArregloCliente.java<br>
│ ├── ArregloProducto.java<br>
│ ├── ArregloVenta.java<br>
│ ├── ArregloAlmacen.java<br>
│ └── ArregloReporte.java (opcional)<br>
├── GUI/<br>
│ ├── frmVenta.java # Módulo de ventas<br>
│ ├── frmReporte.java # Módulo de reportes<br>
│ ├── frmProducto.java # Gestión de productos<br>
│ ├── frmCliente.java # Gestión de clientes<br>
│ ├── frmAlmacen.java # Control de stock<br>
│ ├── frmprincipal.java # Ventana principal (MDI)<br>


## 📸 Capturas de pantalla

![image](https://github.com/user-attachments/assets/d403193f-2e39-4482-8c9c-e96f89747f9f)
![image](https://github.com/user-attachments/assets/5f1cff28-32f3-454d-9686-3a8157826272)
![image](https://github.com/user-attachments/assets/a96633d9-dbeb-4f79-a777-b417cd67a9c7)
![image](https://github.com/user-attachments/assets/35ea5fb5-7c7c-491f-9172-b34832f4c6b1)
![image](https://github.com/user-attachments/assets/d8014133-858f-423e-a130-ff7792398f0c)
![image](https://github.com/user-attachments/assets/7d74125d-6d47-4f51-a424-f7c2501bb0d5)

