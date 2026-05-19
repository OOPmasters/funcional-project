package model;
public class Carro extends Vehiculo {
    public Carro(String placa) {
        super(placa, "Carro");
    }

    @Override
    public double calcularTarifa() {
        return 5000; // Tarifa específica de carro
    }
}
