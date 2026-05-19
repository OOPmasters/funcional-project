package model;

public class Vehiculo {
    private String placa;
    private String tipo;

    public Vehiculo(String placa, String tipo) {
        this.placa = placa;
        this.tipo = tipo;
    }

    public String getPlaca() {
        return placa;
    }

    public String getTipo() {
        return tipo;
    }

    // Polimorfismo: se sobrescribe en las subclases
    public double calcularTarifa() {
        return 0; // Tarifa base, se redefinirá
    }
}
