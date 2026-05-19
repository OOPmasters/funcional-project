package model;
public class Moto extends Vehiculo {
    public Moto(String placa) {
        super(placa, "Moto");
    }

    @Override
    public double calcularTarifa() {
        return 3000; // Tarifa específica de moto
    }
}
