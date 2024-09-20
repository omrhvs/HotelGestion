package HotelGestion.Economica;

import HotelGestion.Main;

import javax.swing.*;

public class Ingresos extends Economica
{
    private String fuente;
    private String concepto;

    public Ingresos(double saldo, String entidadBancaria, String tipoCuenta, String fuente, String concepto)
    {
        super(saldo, entidadBancaria, tipoCuenta);
        this.fuente = fuente;
        this.concepto = concepto;
    }

    public void realizarTransaccion(double monto)
    {
        if (monto > 0)
        {
            setSaldo(getSaldo() + monto);
            JOptionPane.showMessageDialog(null, Main.sepLines+ "Se registró un ingreso de $" + monto + " desde la fuente " + fuente + "\nConcepto: " + concepto + Main.sepLines);
        }
        else
        {
            JOptionPane.showMessageDialog(null, Main.sepLines + "El monto del ingreso debe ser mayor que cero." + Main.sepLines);
        }
    }

    private double setSaldo(double saldo)
    {
        return saldo;
    }

    public String getFuente()
    {
        return fuente;
    }

    public String getConcepto()
    {
        return concepto;
    }
}