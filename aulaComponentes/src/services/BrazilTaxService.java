package services;

public class BrazilTaxService extends TaxService{ //SUBCLASSE

    @Override
    public Double tax(double amount) {
        return amount * 0.3;
    }
}
