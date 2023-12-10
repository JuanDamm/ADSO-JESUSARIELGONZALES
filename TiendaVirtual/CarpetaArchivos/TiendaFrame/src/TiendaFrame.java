/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author JuanDa
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TiendaFrame extends JFrame {
    private DefaultTableModel productosModel;
    private JTable listaProductos;
    private JButton btnAgregarAlCarrito;
    private JButton btnComprar;
    private DefaultListModel<String> carritoModel;

    public TiendaFrame() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Tienda Online");

        productosModel = new DefaultTableModel(new Object[]{"Producto", "Descripción", "Precio"}, 0);
        productosModel.addRow(new Object[]{"Producto 1", "Descripción del Producto 1", 10.0});
        productosModel.addRow(new Object[]{"Producto 2", "Descripción del Producto 2", 15.0});
        productosModel.addRow(new Object[]{"Producto 3", "Descripción del Producto 3", 20.0});

        listaProductos = new JTable(productosModel);
        btnAgregarAlCarrito = new JButton("Agregar al Carrito");
        btnComprar = new JButton("Comprar");
        carritoModel = new DefaultListModel<>();

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JScrollPane(listaProductos), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(btnAgregarAlCarrito);
        buttonPanel.add(btnComprar);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        getContentPane().add(panel);

        btnAgregarAlCarrito.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                agregarAlCarrito();
            }
        });

        btnComprar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                comprar();
            }
        });

        pack();
    }

    private void agregarAlCarrito() {
        int filaSeleccionada = listaProductos.getSelectedRow();
        if (filaSeleccionada != -1) {
            String producto = (String) productosModel.getValueAt(filaSeleccionada, 0);
            carritoModel.addElement(producto);
        }
    }

    private void comprar() {
        if (carritoModel.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El carrito está vacío. Seleccione productos primero.");
        } else {
            double total = 0;
            for (int i = 0; i < carritoModel.size(); i++) {
                total += calcularPrecioProducto(carritoModel.getElementAt(i));
            }
            CarritoFrame carrito = new CarritoFrame(carritoModel, total);
            carrito.setVisible(true);
        }
    }

    private double calcularPrecioProducto(String producto) {
        if (producto.equals("Producto 1")) {
            return 10.0;
        } else if (producto.equals("Producto 2")) {
            return 15.0;
        } else if (producto.equals("Producto 3")) {
            return 20.0;
        }
        return 0.0;
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TiendaFrame().setVisible(true);
            }
        });
    }
}