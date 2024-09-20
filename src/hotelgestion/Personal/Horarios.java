package HotelGestion.Personal;

public class Horarios extends Personal
{
    private String jornada;
    private int horasTrabajo;

    public Horarios(String nombre, int edad, double salario, String jornada, int horasTrabajo)
    {
        super(nombre, edad, salario);
        this.jornada = jornada;
        this.horasTrabajo = horasTrabajo;
    }

    public String notificar()
    {
        return getNombre() + " trabaja " + horasTrabajo + " horas en jornada " + jornada;
    }

    public String getJornada()
    {
        return jornada;
    }

    public int getHorasTrabajo()
    {
        return horasTrabajo;
    }
}
