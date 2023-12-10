/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Frames;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ListaPersonasFrame extends JFrame {

    public ListaPersonasFrame(List<Usuario> usuarios) {
        setTitle("Lista de Personas Registradas");
        setSize(800, 400);
        setLocationRelativeTo(null);

        JTable table = new JTable(new UsuarioTableModel(usuarios));

        // Configura el renderizador de celdas para la columna "Color"
        table.getColumnModel().getColumn(4).setCellRenderer(new ColorRenderer());


        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
    }

    public static class UsuarioTableModel extends AbstractTableModel {
        private static final String[] COLUMNAS = {"ID", "Nombre", "Número de Sorteo", "Dirección", "Color"};
        private List<Usuario> usuarios;

        public UsuarioTableModel(List<Usuario> usuarios) {
            this.usuarios = usuarios;
        }

        @Override
        public int getRowCount() {
            return usuarios.size();
        }

        @Override
        public int getColumnCount() {
            return COLUMNAS.length;
        }

        @Override
        public String getColumnName(int columnIndex) {
            return COLUMNAS[columnIndex];
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Usuario usuario = usuarios.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    return usuario.getNumero();
                case 1:
                    return usuario.getNombre();
                case 2:
                    return usuario.getNumero();
                case 3:
                    return usuario.getDireccion();
                case 4:
                    return usuario.getColor(); 
                default:
                    return null;
            }
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            if (columnIndex == 4) {
                return Color.class;
            }
            return super.getColumnClass(columnIndex);
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return columnIndex == 4;
        }

        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            if (columnIndex == 4) {
                if (aValue instanceof Color) {
                    usuarios.get(rowIndex).setColor((Color) aValue);
                    fireTableCellUpdated(rowIndex, columnIndex);
                }
            }
        }
    }
}