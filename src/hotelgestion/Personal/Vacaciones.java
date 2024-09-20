package HotelGestion.Personal;

public class Vacaciones extends Personal
{
    private int duracion;
    private String destino;

    public Vacaciones(String nombre, int edad, double salario, int duracion, String destino)
    {
        super(nombre, edad, salario);
        this.duracion = duracion;
        this.destino = destino;
    }

    @Override
    public String notificar()
    {
        return getNombre() + " está de vacaciones en " + destino + " por " + duracion + " días.";
    }

    public int getDuracion() {
        return duracion;
    }

    public String getDestino() {
        return destino;
    }
}
