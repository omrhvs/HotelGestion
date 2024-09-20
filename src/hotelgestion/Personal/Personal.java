package HotelGestion.Personal;

public abstract class Personal
{
    private String nombre;
    private int edad;
    private double salario;

    public Personal(String nombre, int edad, double salario)
    {
        this.nombre = nombre;
        this.edad = edad;
        this.salario = salario;
    }

    public abstract String notificar();

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public double getSalario() {
        return salario;
    }

}
