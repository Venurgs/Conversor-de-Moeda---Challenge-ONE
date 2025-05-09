package consola;

import conversorMonedas.CurrencyConverter;
import conversorMonedas.UserInteraction;

public class Consola {
        public static void main(String[] args) {
            try {
                String apiKey = "TU-API-KEY"; // Reemplazar con tu clave de ExchangeRate-API
                CurrencyConverter converter = new CurrencyConverter(apiKey);
                UserInteraction ui = new UserInteraction(converter);
                ui.mostrarMenu();
            } catch (Exception e) {
                System.out.println("Error al obtener las tasas de cambio: " + e.getMessage());
            }
        }
    }


