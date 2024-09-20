package HotelGestion.MedioAmbiente;

import HotelGestion.Main;

import javax.swing.*;

public class ResiduosSolidos extends MedioAmbiente
{
    private String tipoResiduo;
    private int cantidad;

    public ResiduosSolidos(String ubicacion, double nivelContaminacion, String tipoMedio, String tipoResiduo, int cantidad)
    {
        super(ubicacion, nivelContaminacion, tipoMedio);
        this.tipoResiduo = tipoResiduo;
        this.cantidad = cantidad;
    }

    public void reducirContaminacion(double cantidad)
    {
        if (cantidad > 0)
        {
            setNivelContaminacion(getNivelContaminacion() - cantidad);
            JOptionPane.showMessageDialog(null, Main.sepLines+ "Se redujo la contaminación de residuos sólidos en " + getUbicacion() + " en " + cantidad + " unidades." + Main.sepLines);
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

    public int getCantidad()
    {
        return cantidad;
    }
}
