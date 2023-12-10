/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Frames;

import Frames.ListaPersonasFrame.UsuarioTableModel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Marlon Torres
 */

public class Airfiney extends JFrame {

    private JTextField nombreField;
    private JTextField[] cancionesField;
    private JTextField[] artistasField;
    private JButton registrarButton;
    private JButton sortearButton; 
    private JButton verPersonasButton;
     private JTextField direccionField;

    private List<Usuario> usuarios = new ArrayList<>();
    private Set<Integer> numerosAsignados = new HashSet<>();
    private int proximoNumero = 1;

    public Airfiney() {
        setTitle("Registro de Usuarios");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400); 
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(10, 3));
        

            
        panel.add(new JLabel("Nombre del oyente:"));
        nombreField = new JTextField();
        panel.add(nombreField);

        cancionesField = new JTextField[3];
        artistasField = new JTextField[3];
        
        panel.add(new JLabel("Dirección:")); 
        direccionField = new JTextField();
        panel.add(direccionField);

        for (int i = 0; i < 3; i++) {
            panel.add(new JLabel("Canción " + (i + 1) + ":"));
            cancionesField[i] = new JTextField();
            panel.add(cancionesField[i]);

            panel.add(new JLabel("Artista " + (i + 1) + ":"));
            artistasField[i] = new JTextField();
            panel.add(artistasField[i]);
        }
        
        
        
         verPersonasButton = new JButton("Ver Personas");
    panel.add(verPersonasButton);

    verPersonasButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            mostrarListaDePersonas();
        }
    });

        registrarButton = new JButton("Registrar");
        panel.add(registrarButton);

        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarOyente();
            }
        });

        sortearButton = new JButton("Realizar Sorteo"); 
        panel.add(sortearButton);

        sortearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarSorteo();
            }
        });

        add(panel);

       

        setVisible(true);
    }

    private void mostrarListaDePersonas() {
    // Crear una nueva instancia de la clase ListaPersonasFrame
    new ListaPersonasFrame(usuarios).setVisible(true);
}
    
    private void registrarOyente() {
        String nombre = nombreField.getText();
        String[] canciones = new String[3];
        String[] artistas = new String[3];

        for (int i = 0; i < 3; i++) {
            canciones[i] = cancionesField[i].getText();
            artistas[i] = artistasField[i].getText();
        }

        String direccion = direccionField.getText(); 

        if (!nombre.isEmpty() && !canciones[0].isEmpty() && !canciones[1].isEmpty() && !canciones[2].isEmpty()
                && !artistas[0].isEmpty() && !artistas[1].isEmpty() && !artistas[2].isEmpty() && !direccion.isEmpty()) {
            if (numerosAsignados.size() < 3) {
                int numeroUsuario = asignarNumeroUsuario();

                Color color = obtenerColorAleatorio();

                Usuario usuario = new Usuario(numeroUsuario, nombre, canciones, artistas, direccion, color);
                usuarios.add(usuario);

                JOptionPane.showMessageDialog(this, "Te registraste con éxito. Tu número es: " + numeroUsuario);
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(this, "Ya se han registrado los 3 usuarios disponibles.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.");
        }
    }
    
    private Color obtenerColorAleatorio() {

    int red = (int) (Math.random() * 256);
    int green = (int) (Math.random() * 256);
    int blue = (int) (Math.random() * 256);


    return new Color(red, green, blue);
}

    private void realizarSorteo() {
        if (usuarios.size() >= 3) {
            int indiceGanador = (int) (Math.random() * usuarios.size());
            Usuario ganador = usuarios.get(indiceGanador);
            JOptionPane.showMessageDialog(this, "¡El ganador es el Usuario #" + ganador.getNumero() + "!\n" +
                    "Nombre: " + ganador.getNombre() + "\n" +
                    "Canciones: " + String.join(", ", ganador.getCanciones()) + "\n" +
                    "Artistas: " + String.join(", ", ganador.getArtistas()));
        } else {
            JOptionPane.showMessageDialog(this, "Debe haber al menos 3 usuarios registrados para realizar el sorteo.");
        }
    }

    private int asignarNumeroUsuario() {
        int numeroAsignado = proximoNumero;
        numerosAsignados.add(numeroAsignado);
        proximoNumero++;

        return numeroAsignado;
    }

    private void limpiarCampos() {
        nombreField.setText("");
        direccionField.setText("");
        for (int i = 0; i < 3; i++) {
            cancionesField[i].setText("");
            artistasField[i].setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Airfiney();
            }
        });
    }
}

class Usuario {
   private int numero;
    private String nombre;
    private String[] canciones;
    private String[] artistas;
    private String direccion;
    private Color color;

    public Usuario(int numero, String nombre, String[] canciones, String[] artistas, String direccion, Color color) {
        this.numero = numero;
        this.nombre = nombre;
        this.canciones = canciones;
        this.artistas = artistas;
        this.direccion = direccion;
        this.color = color;
    }

     public String getNombre() {
        return nombre;
    }

    public int getNumero() {
        return numero;
    }

    public String getDireccion() {
        return direccion;
    }

    public Color getColor() {
        return color;
    }

    public String[] getCanciones() {
        return canciones;
    }

    public String[] getArtistas() {
        return artistas;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCanciones(String[] canciones) {
        this.canciones = canciones;
    }

    public void setArtistas(String[] artistas) {
        this.artistas = artistas;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    

}


    

