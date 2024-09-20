package HotelGestion.MedioAmbiente;

import HotelGestion.Main;

import javax.swing.*;

public class ResiduosLiquidos extends MedioAmbiente
{
    private String tipoResiduo;
    private double volumen;

    public ResiduosLiquidos(String ubicacion, double nivelContaminacion, String tipoMedio, String tipoResiduo, double volumen)
    {
        super(ubicacion, nivelContaminacion, tipoMedio);
        this.tipoResiduo = tipoResiduo;
        this.volumen = volumen;
    }

    public void reducirContaminacion(double cantidad)
    {
        if (cantidad > 0)
        {
            setNivelContaminacion(getNivelContaminacion() - cantidad);
            JOptionPane.showMessageDialog(null, Main.sepLines + "Se redujo la contaminación de residuos líquidos en " + getUbicacion() + " en " + cantidad + " unidades." + Main.sepLines);
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

    public String getTipoResiduo()
    {
        return tipoResiduo;
    }

    public double getVolumen()
    {
        return volumen;
    }
}