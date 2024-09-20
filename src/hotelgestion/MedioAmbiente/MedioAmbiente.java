package HotelGestion.MedioAmbiente;

public abstract class MedioAmbiente
{
    private String ubicacion;
    private double nivelContaminacion;
    private String tipoMedio;

    public MedioAmbiente(String ubicacion, double nivelContaminacion, String tipoMedio)
    {
        this.ubicacion = ubicacion;
        this.nivelContaminacion = nivelContaminacion;
        this.tipoMedio = tipoMedio;
    }

    public abstract void reducirContaminacion(double cantidad);

    public String getUbicacion()
    {
        return ubicacion;
    }

    public double getNivelContaminacion()
    {
        return nivelContaminacion;
    }

    public String getTipoMedio()
    {
        return tipoMedio;
    }
}
