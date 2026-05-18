
package app;

import exception.ReciboNoEncontradoException;
import model.Recibo;
import service.ParqueaderoService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ParqueaderoService parqueadero = new ParqueaderoService();

        int opcion;
        int numero = 1;

        do {

            System.out.println();
            System.out.println("=== SISTEMA DE PARQUEADERO ===");
            System.out.println("1. Registrar recibo");
            System.out.println("2. Mostrar recibos");
            System.out.println("3. Buscar por placa");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = sc.nextInt();
            sc.nextLine();

            try {

                switch (opcion) {

                    case 1:

                        System.out.print("Fecha: ");
                        String fecha = sc.nextLine();

                        System.out.print("Placa: ");
                        String placa = sc.nextLine();

                        System.out.print("Turno: ");
                        String turno = sc.nextLine();

                        System.out.print("Hora ingreso: ");
                        String hora = sc.nextLine();

                        System.out.print("Tarifa: ");
                        double tarifa = sc.nextDouble();
                        sc.nextLine();

                        Recibo recibo = new Recibo(
                                numero,
                                fecha,
                                placa,
                                turno,
                                hora,
                                tarifa
                        );

                        parqueadero.agregarRecibo(recibo);

                        System.out.println("Recibo registrado correctamente.");

                        numero++;

                        break;

                    case 2:

                        parqueadero.mostrarRecibos();

                        break;

                    case 3:

                        System.out.print("Ingrese la placa: ");
                        String buscar = sc.nextLine();

                        Recibo encontrado = parqueadero.buscarPorPlaca(buscar);

                        System.out.println(encontrado);

                        break;

                    case 4:

                        System.out.println("Programa finalizado.");

                        break;

                    default:

                        System.out.println("Opción inválida.");
                }

            } catch (ReciboNoEncontradoException ex) {

                System.out.println("Error: " + ex.getMessage());

            } catch (IllegalArgumentException ex) {

                System.out.println("Dato inválido: " + ex.getMessage());

            }

        } while (opcion != 4);

        sc.close();
    }
}

