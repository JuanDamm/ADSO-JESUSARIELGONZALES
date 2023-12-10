/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity.Banco;
import Utils.FunctionNumeric;
import Utils.FunctionString;
import View.Cajero;
import java.text.ParseException;
/**
 *
 * @author JuanDa
 */
import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaccion extends Cajero{

    FunctionNumeric fn = new FunctionNumeric();
    FunctionString fs = new FunctionString();

    
    private Date fecha;
    private double monto;

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public double getMonto() {
        return monto;
    }

    public Transaccion(Date fecha, double monto) {
        this.fecha = fecha;
        this.monto = monto;
    }

    

}
