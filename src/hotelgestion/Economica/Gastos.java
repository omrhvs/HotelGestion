package HotelGestion.Economica;

import HotelGestion.Main;

import javax.swing.*;

public class Gastos extends Economica
{
    private String categoria;
    private String descripcion;

    public Gastos(double saldo, String entidadBancaria, String tipoCuenta, String categoria, String descripcion)
    {
        super(saldo, entidadBancaria, tipoCuenta);
        this.categoria = categoria;
        this.descripcion = descripcion;
    }

    public void realizarTransaccion(double monto)
    {
        if (monto > 0)
        {
            setSaldo(getSaldo() - monto);
            JOptionPane.showMessageDialog(null, Main.sepLines + "Se registró un gasto de $" + monto + " en la categoría " + categoria + ": " + descripcion + Main.sepLines);
        }
        else
        {
            JOptionPane.showMessageDialog(null, Main.sepLines + "El monto del gasto debe ser mayor que cero." + Main.sepLines);
        }
    }

    private double setSaldo(double saldo)
    {
        return saldo;
    }

    public String getCategoria()
    {
        return categoria;
    }

    public String getDescripcion()
    {
        return descripcion;
    }
}