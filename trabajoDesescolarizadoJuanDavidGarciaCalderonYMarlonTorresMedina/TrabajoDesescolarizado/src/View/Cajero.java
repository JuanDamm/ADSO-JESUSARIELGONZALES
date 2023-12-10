/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

/**
 *
 * @author JuanDa
 */
import Utils.FunctionNumeric;
import Utils.FunctionString;
import Entity.Cuentas.Cuenta;
import Entity.Banco.Cliente;
import Entity.Banco.Transaccion;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Cajero {

    public static void main(String[] args) {
        FunctionNumeric fn = new FunctionNumeric();
        FunctionString fs = new FunctionString();

        int numClientes = fn.InputIntegerNumericPositiveScanner("Ingrese la cantidad de clientes: ");
        Cuenta[] Cu = new Cuenta[numClientes];
        Cliente[] C = new Cliente[numClientes];

        for (int i = 0; i < Cu.length; i++) {
            Cu[i] = new Cuenta();
            C[i] = new Cliente();
            C[i].setNombre(fs.InputScanner("Ingrese el nombre del cliente: "));
            Cu[i].setBanco(fs.InputScanner("Ingreese el nombre del banco: "));
            do {
                Cu[i].setTipo(fs.InputScanner("Ingrese su tipo de tarjeta (Credito o Debito): "));
            } while (!(Cu[i].getTipo().equals("Credito") || Cu[i].getTipo().equals("Debito")));

            Cu[i].setSaldo(fn.InputDoubleNumericPositiveScanner("Ingrese su saldo: "));

            String fechaStr = fs.InputScanner("Ingrese la fecha de la transacción (formato dd/MM/yyyy): ");
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date fechaTransaccion = null;
            try {
                fechaTransaccion = dateFormat.parse(fechaStr);
            } catch (ParseException e) {
                e.printStackTrace();
            }
                   
            Cu[i].retirar(1000, fechaTransaccion);
            fs.ShowScanner("Fecha: "+fechaStr + " ");
            C[i].setCuenta(Cu[i]);
        }
        for (int i = 0; i < Cu.length; i++) {
            Cliente clienteActual = C[i];
            Cuenta cuentaActual = Cu[i];

            String nombreNormalizado = clienteActual.normalizarNombre(clienteActual.getNombre());
            String nombreBancoNormalizado = cuentaActual.getBanco();
            
            fs.ShowScanner(nombreNormalizado + " - Banco " + nombreBancoNormalizado + " - " + cuentaActual.getTipo());

            // Obtener y mostrar las transacciones del cliente
           List<Transaccion> transacciones = clienteActual.getTransacciones();
            for (Transaccion transaccion : transacciones) {
                fs.ShowScanner("Fecha de transacción: " + transaccion.getFecha() +
                                   " - Monto retirado: " + transaccion.getMonto());
            }

        }
    }
}


