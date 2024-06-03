package conversormoedas.modelos;

public class Moeda {
    private String currency;
    private double value;

    public Moeda(String currency, double value) {
        this.currency = currency;
        this.value = value;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getCurrency() {
        return currency;
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Moeda{" + value + " "+ currency +
                '}';
    }
}
