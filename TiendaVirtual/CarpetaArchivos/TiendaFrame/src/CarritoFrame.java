/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author JuanDa
 */
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class CarritoFrame extends JFrame {
    public CarritoFrame(DefaultListModel<String> carritoModel, double total) {
        setTitle("Carrito de Compras");

       JList<String> carritoList = new JList<>(carritoModel);
        JLabel totalLabel = new JLabel("Total: $" + total);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JScrollPane(carritoList), BorderLayout.CENTER);
        panel.add(totalLabel, BorderLayout.SOUTH);

        getContentPane().add(panel);

        pack();
    }
}
