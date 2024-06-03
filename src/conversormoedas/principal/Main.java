package conversormoedas.principal;

import conversormoedas.modelos.ConsultaAPIConversao;
import conversormoedas.modelos.Moeda;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("""
    Conversor de Moedas ExchangeRate.
    
    *****************************************************
    
    Tabela referência de códigos de moedas:
    ARS - Peso argentino    BOB - Boliviano boliviano   BRL - Real brasileiro
    CLP - Peso chileno      COP - Peso colombiano       USD - Dólar americano
    JPY - Japanese Yen      KRW - South Korean Won      CNY - Chinese Renminbi
    
    *****************************************************
      
    """);

        Scanner leitura = new Scanner(System.in);

        System.out.println("Digite o valor original");
        var valueIn = leitura.nextDouble();

        System.out.println("Digite o código da moeda original");
        String currencyIn = leitura.next().toUpperCase();

        System.out.println("Digite o código da moeda para conversão");
        String currencyOut = leitura.next().toUpperCase();

        Moeda moeda = new Moeda(currencyIn, valueIn);

        System.out.println("Valor original:" + moeda);

        ConsultaAPIConversao conversao = new ConsultaAPIConversao(moeda, currencyOut);

        System.out.println("Valor convertido:" + moeda);



    }
}
