package HotelGestion;

import HotelGestion.Economica.Creditos;
import HotelGestion.Economica.Gastos;
import HotelGestion.Economica.Ingresos;
import HotelGestion.MedioAmbiente.Gases;
import HotelGestion.MedioAmbiente.ResiduosLiquidos;
import HotelGestion.MedioAmbiente.ResiduosSolidos;
import HotelGestion.Personal.Horarios;
import HotelGestion.Personal.Vacaciones;

import javax.swing.JOptionPane;

public class Main
{
    public static String sepLines = "\n========================================\n";
    public static String thinLines = "\n----------------------------------------------------------------------\n";

    public static void main(String[] args)
    {
        boolean continuar = true;

        while (continuar)
        {
            int opcionPrincipal = Integer.parseInt(JOptionPane.showInputDialog(sepLines +
                    "    Gestion Hotelera" + thinLines +
                    "Seleccione una categoría:\n" +
                            "1. Personal\n" +
                            "2. Medio Ambiente\n" +
                            "3. Economía\n" +
                            "4. Salir" +
                    sepLines
            ));

            switch (opcionPrincipal)
            {
                case 1 -> gestionarPersonal();
                case 2 -> gestionarMedioAmbiente();
                case 3 -> gestionarEconomia();
                case 4 -> continuar = false;
                default -> JOptionPane.showMessageDialog(null, sepLines + "Opción no válida." + sepLines);
            }
        }
    }

    private static void gestionarPersonal()
    {
        boolean continuar = true;
        boolean personalCreado = false;
        String nombre = JOptionPane.showInputDialog(sepLines + "Ingrese el nombre completo del personal" + sepLines);
        int edad = Integer.parseInt(JOptionPane.showInputDialog(sepLines + "Ingrese la edad del personal" + sepLines));
        double salario = Double.parseDouble(JOptionPane.showInputDialog(sepLines + "Ingrese el salario del personal" + sepLines));
        personalCreado = true;

        while (continuar && personalCreado)
        {
            int opcionPersonal = Integer.parseInt(JOptionPane.showInputDialog(sepLines +
                    "Gestión de Personal:\n" + thinLines +
                    "1. Registrar nuevo horario\n" +
                    "2. Registrar vacaciones\n" +
                    "3. Volver al menú principal" +
                    sepLines
            ));

            switch (opcionPersonal)
            {
                case 1:
                    if (personalCreado)
                    {
                        String jornada = JOptionPane.showInputDialog(sepLines + "Jornada de trabajo (Completa / Parcial)" + sepLines);
                        int horasTrabajo = Integer.parseInt(JOptionPane.showInputDialog(sepLines + "Ingrese las horas de trabajo por día" + sepLines));

                        Horarios horarios = new Horarios(nombre, edad, salario, jornada, horasTrabajo);
                        JOptionPane.showMessageDialog(null, sepLines + "Creado un horario para " + nombre + thinLines +
                                "- Detalles" +
                                "\nJornada: " + horarios.getJornada() +
                                "\nHoras laborales: " + horarios.getHorasTrabajo() + thinLines +
                                horarios.notificar() +
                                sepLines
                        );
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, sepLines + "Debe crear un personal primero." + sepLines);
                    }
                    break;

                case 2:
                    if (personalCreado)
                    {
                        int duracion = Integer.parseInt(JOptionPane.showInputDialog(sepLines + "Ingrese la duración de las vacaciones (días)" + sepLines));
                        String destino = JOptionPane.showInputDialog(sepLines + "Destino de las vacaciones" + sepLines);

                        Vacaciones vacaciones = new Vacaciones(nombre, edad, salario, duracion, destino);
                        JOptionPane.showMessageDialog(null, "Vacaciones registradas para " + nombre + thinLines +
                                "- Detalles " + thinLines +
                                "\nDuracion: " + vacaciones.getDuracion() +
                                "\nDestino: " + vacaciones.getDestino() + thinLines +
                                vacaciones.notificar() +
                                sepLines
                        );
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, sepLines + "Debe crear un personal primero." + sepLines);
                    }
                    break;

                case 3:
                    continuar = false;
                    break;

                default:
                    JOptionPane.showMessageDialog(null, sepLines + "Opción no válida." + sepLines);
            }
        }
    }

    private static void gestionarMedioAmbiente()
    {
        boolean continuar = true;

        boolean ambienteCreado = false;
        String ubicacion = JOptionPane.showInputDialog(sepLines + "Ingrese la ubicacion" + sepLines);
        double nivelContaminacion = Double.parseDouble(JOptionPane.showInputDialog(sepLines + "Ingrese el nivel de contaminacion (%)" + sepLines));
        String tipoMedio = JOptionPane.showInputDialog(sepLines + "Ingrese el tipo de medio" + sepLines);
        ambienteCreado = true;

        while (continuar && ambienteCreado)
        {
            int opcionPersonal = Integer.parseInt(JOptionPane.showInputDialog(sepLines +
                    "Gestión de Medio Ambiente:\n" + thinLines +
                    "1. Gestionar Gases\n" +
                    "2. Gestionar Residuos liquidos\n" +
                    "3. Gestionar Residuos Solidos\n" +
                    "3. Volver al menú principal" +
                    sepLines
            ));

            switch (opcionPersonal)
            {
                case 1:
                    if (ambienteCreado)
                    {
                        String tipoGas = JOptionPane.showInputDialog(sepLines + "Ingrese el tipo de gas" + sepLines);
                        double emisiones = Double.parseDouble(JOptionPane.showInputDialog(sepLines + "Ingrese las emisiones emitidas" + sepLines));
                        double nivel = Double.parseDouble(JOptionPane.showInputDialog(sepLines + "Ingrese el nivel que desea reducirlas" + sepLines));
                        Gases gases = new Gases(ubicacion, nivelContaminacion, tipoMedio, tipoGas, emisiones);
                        gases.reducirContaminacion(nivel);

                        JOptionPane.showMessageDialog(null, sepLines + "Registrado emision de gases " + tipoGas + thinLines +
                                "- Detalles" +
                                "\nTipo: " + gases.getTipoGas() +
                                "\nEmisiones: " + gases.getEmisiones() + thinLines +
                                "\nReducidas en un %" + nivel +
                                sepLines
                        );
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, sepLines + "Debe crear un personal primero." + sepLines);
                    }
                    break;

                case 2:
                    if (ambienteCreado)
                    {
                        String tipoResiduoLiquido = JOptionPane.showInputDialog(sepLines + "Ingrese el tipo de residuo liquido" + sepLines);
                        double volumen = Double.parseDouble(JOptionPane.showInputDialog(sepLines + "Ingrese el volumen" + sepLines));
                        double nivel = Double.parseDouble(JOptionPane.showInputDialog(sepLines + "Ingrese el nivel que desea reducirlas" + sepLines));
                        ResiduosLiquidos residuosLiquidos = new ResiduosLiquidos(ubicacion, nivelContaminacion, tipoMedio, tipoResiduoLiquido, volumen);
                        residuosLiquidos.reducirContaminacion(nivel);

                        JOptionPane.showMessageDialog(null, "Registrado residuo liquido" + tipoResiduoLiquido + thinLines +
                                "- Detalles " +
                                "\nTipo: " + residuosLiquidos.getTipoResiduo() +
                                "\nVolumen: " + residuosLiquidos.getVolumen() + thinLines +
                                "\nReducidas en un %" + nivel +
                                sepLines
                        );
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, sepLines + "Debe registrar un area primero." + sepLines);
                    }
                    break;

                case 3:
                    if (ambienteCreado)
                    {
                        String tipoResiduoSolido = JOptionPane.showInputDialog(sepLines + "Ingrese el tipo de residuo solido" + sepLines);
                        int cantidad = Integer.parseInt(JOptionPane.showInputDialog(sepLines + "Ingrese el volumen" + sepLines));
                        double nivel = Double.parseDouble(JOptionPane.showInputDialog(sepLines + "Ingrese el nivel que desea reducirlas" + sepLines));
                        ResiduosSolidos residuosSolidos = new ResiduosSolidos(ubicacion, nivelContaminacion, tipoMedio, tipoResiduoSolido, cantidad);
                        residuosSolidos.reducirContaminacion(nivel);

                        JOptionPane.showMessageDialog(null, "Registrado residuo liquido" + tipoResiduoSolido + thinLines +
                                "- Detalles " +
                                "\nTipo: " + residuosSolidos.getTipoResiduo() +
                                "\nVolumen: " + residuosSolidos.getCantidad() + thinLines +
                                "\nReducidas en un %" + nivel +
                                sepLines
                        );
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, sepLines + "Debe registrar un area primero." + sepLines);
                    }
                    break;

                case 4:
                    continuar = false;
                    break;

                default:
                    JOptionPane.showMessageDialog(null, sepLines + "Opción no válida." + sepLines);
            }
        }
    }

    private static void gestionarEconomia()
    {
        boolean continuar = true;
        boolean economiaCreado = false;

        double saldo = Double.parseDouble(JOptionPane.showInputDialog(sepLines + "Ingrese el saldo" + sepLines));
        String entidadFinanciera = JOptionPane.showInputDialog(sepLines + "Ingrese la entidad financiera" + sepLines);
        String tipoCuenta = JOptionPane.showInputDialog(sepLines + "Ingrese el tipo de cuenta" + sepLines);
        economiaCreado = true;

        while (continuar && economiaCreado)
        {
            int opcionPersonal = Integer.parseInt(JOptionPane.showInputDialog(sepLines +
                    "Gestión Economica:\n" + thinLines +
                    "1. Añadir ingresos\n" +
                    "2. Realizar gasto\n" +
                    "3. Solicitar credito\n" +
                    "3. Volver al menú principal" +
                    sepLines
            ));

            switch (opcionPersonal)
            {
                case 1:
                    if (economiaCreado)
                    {
                        String fuente = JOptionPane.showInputDialog(sepLines + "Ingrese la fuente del ingreso" + sepLines);
                        String concepto = JOptionPane.showInputDialog(sepLines + "Ingrese el concepto del ingreso" + sepLines);
                        double monto = Double.parseDouble(JOptionPane.showInputDialog(sepLines + "Ingrese el monto a ingresar" + sepLines));
                        Ingresos ingresos = new Ingresos(saldo, entidadFinanciera, tipoCuenta, fuente, concepto);
                        ingresos.realizarTransaccion(monto);

                        JOptionPane.showMessageDialog(null, sepLines + "Registrado nuevo ingreso por $" + monto + thinLines +
                                "\n- Detalles" + thinLines +
                                "\nSaldo: $" + ingresos.getSaldo() +
                                "\nEntidad Bancaria: " + ingresos.getEntidadBancaria() +
                                "\nTipo de Cuenta: " + ingresos.getTipoCuenta() +
                                "\nFuente: " + ingresos.getFuente() +
                                "\nConcepto: " + ingresos.getConcepto() +
                                sepLines
                        );
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, sepLines + "Debe realizar registrar una cuenta bancaria primero." + sepLines);
                    }
                    break;

                case 2:
                    if (economiaCreado)
                    {
                        String categoria = JOptionPane.showInputDialog(sepLines + "Ingrese la categoria del gasto" + sepLines);
                        String descripcion = JOptionPane.showInputDialog(sepLines + "Ingrese la descripcion del gasto" + sepLines);
                        double monto = Double.parseDouble(JOptionPane.showInputDialog(sepLines + "Ingrese el monto del gasto" + sepLines));
                        Gastos gastos = new Gastos(saldo, entidadFinanciera, tipoCuenta, categoria, descripcion);
                        gastos.realizarTransaccion(monto);

                        JOptionPane.showMessageDialog(null, "Registrado un gasto por $" + monto + thinLines +
                                "- Detalles " + thinLines +
                                "\nCategoria: " + gastos.getCategoria() +
                                "\nDescripcion: " + gastos.getDescripcion() +
                                sepLines
                        );
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, sepLines + "Debe realizar registrar una cuenta bancaria primero." + sepLines);
                    }
                    break;
                case 3:
                    if (economiaCreado)
                    {
                        String entidadPrestamista = JOptionPane.showInputDialog(sepLines + "Ingrese la entidad prestamista" + sepLines);
                        double tasaInteres = Double.parseDouble(JOptionPane.showInputDialog(sepLines + "Ingrese la tasa de interes" + sepLines));
                        double monto = Double.parseDouble(JOptionPane.showInputDialog(sepLines + "Ingrese el monto del credito" + sepLines));

                        Creditos creditos = new Creditos(saldo, entidadFinanciera, tipoCuenta, entidadPrestamista, tasaInteres);
                        creditos.realizarTransaccion(monto);

                        JOptionPane.showMessageDialog(null, "Registrado un prestamo  por $" + monto + thinLines +
                                "- Detalles " + thinLines +
                                "\nEntidad Financiera: " + creditos.getEntidadPrestamista() +
                                "\nTasa de Interes: " + creditos.getTasaInteres() +
                                sepLines
                        );
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, sepLines + "Debe realizar registrar una cuenta bancaria primero." + sepLines);
                    }
                    break;

                case 4:
                    continuar = false;
                    break;

                default:
                    JOptionPane.showMessageDialog(null, sepLines + "Opción no válida." + sepLines);
            }
        }
    }
}
