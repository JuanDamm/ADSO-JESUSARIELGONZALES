/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity.Cuentas;

import Entity.Banco.Cliente;
import Utils.FunctionNumeric;
import Utils.FunctionString;
import java.util.Date;
import Entity.Banco.Transaccion;
import java.util.ArrayList;
import java.util.List;


public class Cuenta {

    private Double saldo;
    private String tipo;
    private String banco;
    private Cliente cliente;
    private List<Transaccion> transacciones;
    
    

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    FunctionNumeric fn = new FunctionNumeric();
    FunctionString fs = new FunctionString();
    
    public Cuenta() {
        transacciones = new ArrayList<>();
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = normalizarNombreBanco(banco);
    }

     private String normalizarNombreBanco(String nombreBanco) {
        return nombreBanco.toLowerCase(); //convierte en minuscula
    }
     
    public boolean verificarSaldo(double monto) {
       
        if (this.getTipo().equals("Credito")) {
            return this.getSaldo() >= monto;

        } else if (this.getTipo().equals("Debito")) {
            return true;
        }
        return false;
    }

    public boolean retirar(double monto, Date fechaTransaccion) {

        if (verificarSaldo(monto)) {
            if (this.getTipo().equals("Credito")) {
                // Actualizar el saldo restando el monto de la cuenta de crédito
                this.setSaldo(this.getSaldo() - monto);
                this.setTipo((" Retiro exitoso. Nuevo saldo: " + this.getSaldo()));
            } else if (this.getTipo().equals("Debito")) {
                double montoConComision = monto * 1.05;
                // Actualizar el saldo restando el monto más la comisión de la cuenta de débito
                this.setSaldo(this.getSaldo() - montoConComision);
                this.setTipo((" Retiro exitoso. Nuevo saldo: " + this.getSaldo() +"  "));
            } else {
                this.setTipo((" Tipo de tarjeta no válido."));
            }
             if (getCliente() != null) {
                getCliente().registrarTransaccion(new Transaccion(new Date(), monto));
            }
              Transaccion transaccion = new Transaccion(fechaTransaccion, monto);
            transacciones.add(transaccion);
            return true;
        } else {
            this.setTipo((" saldo insufisiente."));
            return false;
        }
        
        
    }
          public List<Transaccion> getTransacciones() {
        return transacciones;
    }

   
    
}
 

