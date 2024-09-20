package HotelGestion.Economica;

import HotelGestion.Main;

import javax.swing.*;

public class Creditos extends Economica
{
    private String entidadPrestamista;
    private double tasaInteres;

    public Creditos(double saldo, String entidadBancaria, String tipoCuenta, String entidadPrestamista, double tasaInteres)
    {
        super(saldo, entidadBancaria, tipoCuenta);
        this.entidadPrestamista = entidadPrestamista;
        this.tasaInteres = tasaInteres;
    }

    public void realizarTransaccion(double monto)
    {
        if (monto > 0)
        {
            double montoAdeudado = monto + (monto * tasaInteres / 100);
            setSaldo(getSaldo() + montoAdeudado);
            JOptionPane.showMessageDialog(null, Main.sepLines +"Se registró un préstamo de $" + monto + " con " + entidadPrestamista + ". Deberás pagar $" + montoAdeudado + " en total." + Main.sepLines);
        }
        else
        {
            JOptionPane.showMessageDialog(null, Main.sepLines+ "El monto del préstamo debe ser mayor que cero." + Main.sepLines);
        }
    }

    private double setSaldo(double saldo)
    {
        return saldo;
    }

    public String getEntidadPrestamista()
    {
        return entidadPrestamista;
    }

    public double getTasaInteres()
    {
        return tasaInteres;
    }
}
