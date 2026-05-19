package app;
import java.util.ArrayList;
import java.util.Scanner;
import exception.PlacaInvalidaException;
import model.*;
import utils.Validaciones;

public class ParqueaderoApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Recibo> listaRecibos = new ArrayList<>();

        while (true) {
            System.out.println("===== PARQUEADERO =====");
            System.out.println("1. Registrar vehículo");
            System.out.println("2. Consultar recibos");
            System.out.println("3. Buscar recibo por placa");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); 

            if (opcion == 1) {
                String placa;
                String tipo;

                while (true) {
                    System.out.print("Ingrese tipo (Moto/Carro): ");
                    tipo = scanner.nextLine().toUpperCase();

                    if (!tipo.equals("MOTO") && !tipo.equals("CARRO")) {
                        System.out.println("Tipo no válido. Debe ser Moto o Carro.");
                        continue;
                    }

                    System.out.print("Ingrese placa: ");
                    placa = scanner.nextLine().toUpperCase();

                    try {
                        Validaciones.validarPlaca(placa, tipo);
                    } catch (PlacaInvalidaException e) {
                        System.out.println("Error: " + e.getMessage());
                        continue;
                    }

                    if (Validaciones.placaExiste(placa, listaRecibos)) {
                        System.out.println("La placa ya existe");
                        System.out.print("¿Sobrescribir? (S/N): ");
                        String respuesta = scanner.nextLine();

                        if (respuesta.equalsIgnoreCase("S")) {
                            break;
                        } else {
                            continue;
                        }
                    }

                    break;
                }

                Vehiculo vehiculo;
                if (tipo.equals("MOTO")) {
                    vehiculo = new Moto(placa);
                } else {
                    vehiculo = new Carro(placa);
                }

                Recibo recibo = new Recibo(vehiculo);
                listaRecibos.add(recibo);
                System.out.println("Recibo generado exitosamente:\n" + recibo);

            } else if (opcion == 2) {
                if (listaRecibos.isEmpty()) {
                    System.out.println("No hay recibos registrados.");
                } else {
                    for (Recibo r : listaRecibos) {
                        System.out.println(r);
                    }
                }

            } else if (opcion == 3) {
                System.out.print("Ingrese placa a buscar: ");
                String placaBuscar = scanner.nextLine().toUpperCase();
                boolean encontrado = false;

                for (Recibo r : listaRecibos) {
                    if (r.vehiculo.getPlaca().equals(placaBuscar)) {
                        System.out.println(r);
                        encontrado = true;
                    }
                }

                if (!encontrado) {
                    System.out.println("No se encontró ningún recibo con esa placa.");
                }

            } else if (opcion == 4) {
                System.out.println("Saliendo del sistema. ¡Hasta luego!");
                break;
            } else {
                System.out.println("Opción no válida, intente de nuevo.");
            }
        }

        scanner.close();
    }
}
