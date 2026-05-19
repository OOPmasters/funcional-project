package utils;

import exception.PlacaInvalidaException;
import java.util.ArrayList;
import model.Recibo;

public class Validaciones {

    public static void validarPlaca(
            String placa,
            String tipo)

            throws PlacaInvalidaException {

        placa = placa.toUpperCase();

        if (placa.length() != 6) {

            throw new PlacaInvalidaException(
                "La placa debe tener 6 caracteres"
            );
        }

        if(tipo.equalsIgnoreCase("MOTO")){

            if(!placa.matches("[A-Z]{3}[0-9]{2}[A-Z]{1}")){

                throw new PlacaInvalidaException(
                "Moto: 3 letras, 2 números y 1 letra"
                );
            }
        }

        if(tipo.equalsIgnoreCase("CARRO")){

            if(!placa.matches("[A-Z]{3}[0-9]{3}")){

                throw new PlacaInvalidaException(
                "Carro: 3 letras y 3 números"
                );
            }
        }
    }

    public static boolean placaExiste(
            String placa,
            ArrayList<Recibo> listaRecibos) {

        for (Recibo recibo : listaRecibos) {
            if (recibo.vehiculo.getPlaca().equalsIgnoreCase(placa)) {
                return true;
            }
        }
        return false;
    }

}
