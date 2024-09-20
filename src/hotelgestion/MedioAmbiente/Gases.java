package HotelGestion.MedioAmbiente;

import HotelGestion.Main;

import javax.swing.*;

public class Gases extends MedioAmbiente
{
    private String tipoGas;
    private double emisiones;

    public Gases(String ubicacion, double nivelContaminacion, String tipoMedio, String tipoGas, double emisiones)
    {
        super(ubicacion, nivelContaminacion, tipoMedio);
        this.tipoGas = tipoGas;
        this.emisiones = emisiones;
    }

    public void reducirContaminacion(double cantidad)
    {
        if (cantidad > 0)
        {
            setNivelContaminacion(getNivelContaminacion() - cantidad);
            JOptionPane.showMessageDialog(null, Main.sepLines + "Se redujo la contaminación de gases en " + getUbicacion() + " en " + cantidad + " unidades." + Main.sepLines);
        }
        else
        {
            JOptionPane.showMessageDialog(null, Main.sepLines + "La cantidad de reducción debe ser mayor que cero." + Main.sepLines);
        }
    }

    private double setNivelContaminacion(double cantidad)
    {
        return cantidad;
    }

    public String getTipoGas()
    {
        return tipoGas;
    }

    public double getEmisiones()
    {
        return emisiones;
    }
}