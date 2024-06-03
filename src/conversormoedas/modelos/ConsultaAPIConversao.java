package conversormoedas.modelos;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import java.lang.Math;


public class ConsultaAPIConversao {
    private String currencyIn;
    private double valueIn;
    private String currencyOut;
    private double valueOut;
    private double exchangeRate;
    final String apiKey = "046943d1f480cb4add108ac5";
    private String json;

    public ConsultaAPIConversao(Moeda moeda, String currencyOut) {
        this.currencyOut = currencyOut;
        currencyIn = moeda.getCurrency();
        valueIn = moeda.getValue();

        exchangeRate = buscaExchange();

        System.out.println("Taxa de conversão consultada:" + exchangeRate);

        this.valueOut =  valueIn * exchangeRate;
        moeda.setCurrency(currencyOut);
        moeda.setValue(this.valueOut);

    }

    public double buscaExchange() {

        String endereco = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + currencyIn;

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endereco))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            this.json = response.body();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        JsonParser jsonParser = new JsonParser();
        JsonElement jsonTree = jsonParser.parse(json);

        JsonObject jsonObject = jsonTree.getAsJsonObject();

        JsonElement jsonConversion = jsonObject.get("conversion_rates");
        JsonObject jsonObject2 = jsonConversion.getAsJsonObject();


        JsonElement rate = jsonObject2.get(currencyOut);

        return rate.getAsDouble();


    }
}

