/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity.Banco;
import Entity.Cuentas.Cuenta;
import Utils.FunctionNumeric;
import Utils.FunctionString;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Cliente {

    private String nombre;
    private Double saldo;
    private Cuenta cuenta;
    private String tipo;
    private List<Transaccion> transacciones;
    
    public  Cliente() {
       transacciones = new ArrayList<>();
    }
    
    
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    FunctionNumeric fn = new FunctionNumeric();
    FunctionString fs = new FunctionString();

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre =  normalizarNombre(nombre);
    }
    
    public void registrarTransaccion(Transaccion transaccion) {
        transacciones.add(transaccion);
    }
     
    public List<Transaccion> getTransacciones() {
        return transacciones;
    }
    
    public void registrarTransaccion(double monto, Date fechaTransaccion) {
        Transaccion transaccion = new Transaccion(fechaTransaccion, monto);
        transacciones.add(transaccion);
    }
    
     public String normalizarNombre(String nombre) {
        String[] partesNombre = nombre.toLowerCase().split(" ");
        StringBuilder nombreFinal = new StringBuilder();
        for (String parte : partesNombre) {
            nombreFinal.append(parte.substring(0, 1).toUpperCase()).append(parte.substring(1)).append(" ");
        }
        return nombreFinal.toString().trim();
    }
    

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
        cuenta.setCliente(this); // Establecer la referencia al cliente en la cuenta
    }

  

    public Double verSaldo() {
        return null;
    }

  

}
