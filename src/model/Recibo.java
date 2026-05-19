package model;
import java.time.LocalDate;
import java.time.LocalTime;

public class Recibo {
    private static int contadorRecibos = 1;
    private int numeroRecibo;
    private String fecha;
    private String horaIngreso;
    public Vehiculo vehiculo;
    private double tarifa;
   

    public Recibo(Vehiculo vehiculo) {
        this.numeroRecibo = contadorRecibos++;
        this.fecha = LocalDate.now().toString();
        this.horaIngreso = LocalTime.now().toString();
        this.vehiculo = vehiculo;
        this.tarifa = vehiculo.calcularTarifa();
    }

    @Override
    public String toString() {
        return "Recibo #" + numeroRecibo + "\n" +
               "Fecha: " + fecha + "\n" +
               "Hora Ingreso: " + horaIngreso + "\n" +
               "Placa: " + vehiculo.getPlaca() + "\n" +
               "Tipo: " + vehiculo.getTipo() + "\n" +
               "Tarifa: $" + tarifa + "\n";
    }
}
