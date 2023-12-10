/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package simulacion;

import java.util.ArrayList;
import java.util.List;

class Cliente {
    int id;
    String nombre;
    String apellido;

    public Cliente(int id, String nombre, String apellido) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
    }
}

class Seguridad {
    int idUsuario;
    String nombreUsuario;
    String contraseña;

    public Seguridad(int idUsuario, String nombreUsuario, String contraseña) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
    }
}

class MetodoPago {
    int id;
    String tipoPago;

    public MetodoPago(int id, String tipoPago) {
        this.id = id;
        this.tipoPago = tipoPago;
    }
}

class Factura {
    int id;
    double total;

    public Factura(int id, double total) {
        this.id = id;
        this.total = total;
    }
}

class Producto {
    int id;
    String nombre;
    double precio;

    public Producto(int id, String nombre, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }
}

class Proveedor {
    int id;
    String nombre;

    public Proveedor(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
}

class Devolucion {
    int id;
    int idVenta;
    int idProducto;

    public Devolucion(int id, int idVenta, int idProducto) {
        this.id = id;
        this.idVenta = idVenta;
        this.idProducto = idProducto;
    }
}

public class SimulacionBaseDeDatos {
    public static void main(String[] args) {
        // Simular datos para las entidades
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente(1, "Juan", "Pérez"));
        clientes.add(new Cliente(2, "Ana", "González"));

        List<Seguridad> usuarios = new ArrayList<>();
        usuarios.add(new Seguridad(1, "usuario1", "contraseña1"));
        usuarios.add(new Seguridad(2, "usuario2", "contraseña2"));

        List<MetodoPago> metodosPago = new ArrayList<>();
        metodosPago.add(new MetodoPago(1, "Tarjeta de crédito"));
        metodosPago.add(new MetodoPago(2, "PayPal"));

        List<Factura> facturas = new ArrayList<>();
        facturas.add(new Factura(1, 100.0));
        facturas.add(new Factura(2, 75.5));

        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto(1, "Producto A", 10.0));
        productos.add(new Producto(2, "Producto B", 20.0));

        List<Proveedor> proveedores = new ArrayList<>();
        proveedores.add(new Proveedor(1, "Proveedor X"));
        proveedores.add(new Proveedor(2, "Proveedor Y"));

        List<Devolucion> devoluciones = new ArrayList<>();
        devoluciones.add(new Devolucion(1, 1, 1));
        devoluciones.add(new Devolucion(2, 2, 2));

        // Puedes acceder y utilizar los datos simulados en tu programa Java
        for (Cliente cliente : clientes) {
            System.out.println("Cliente: " + cliente.nombre + " " + cliente.apellido);
        }

        // Continúa simulando datos para las otras entidades aquí
        for (Seguridad usuario : usuarios) {
            System.out.println("Usuario: " + usuario.nombreUsuario);
        }

        for (MetodoPago metodo : metodosPago) {
            System.out.println("Método de Pago: " + metodo.tipoPago);
        }

        for (Factura factura : facturas) {
            System.out.println("Factura #" + factura.id + ", Total: $" + factura.total);
        }

        for (Producto producto : productos) {
            System.out.println("Producto: " + producto.nombre + ", Precio: $" + producto.precio);
        }

        for (Proveedor proveedor : proveedores) {
            System.out.println("Proveedor: " + proveedor.nombre);
        }

        for (Devolucion devolucion : devoluciones) {
            System.out.println("Devolución #" + devolucion.id + " de Venta #" + devolucion.idVenta);
        }
    }
}