package HotelGestion.Economica;

public abstract class Economica
{
    private double saldo;
    private String entidadBancaria;
    private String tipoCuenta;

    public Economica(double saldo, String entidadBancaria, String tipoCuenta)
    {
        this.saldo = saldo;
        this.entidadBancaria = entidadBancaria;
        this.tipoCuenta = tipoCuenta;
    }

    public abstract void realizarTransaccion(double monto);

    public double getSaldo()
    {
        return saldo;
    }

    public String getEntidadBancaria()
    {
        return entidadBancaria;
    }

    public String getTipoCuenta()
    {
        return tipoCuenta;
    }
}
