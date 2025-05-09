package conversorMonedas;

import java.io.*;
import java.net.*;
import com.google.gson.*;

public class CurrencyConverter {
    private JsonObject conversionRates;

    public CurrencyConverter(String apiKey) throws Exception {
        String url_str = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/USD";

        URL url = new URL(url_str);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();

        Gson gson = new Gson();
        JsonObject jsonobj = gson.fromJson(response.toString(), JsonObject.class);
        this.conversionRates = jsonobj.getAsJsonObject("conversion_rates");
    }

    public double convertirMoneda(String monedaDestino, double monto) {
        double tasa = conversionRates.get(monedaDestino).getAsDouble();
        return monto * tasa;
    }
}