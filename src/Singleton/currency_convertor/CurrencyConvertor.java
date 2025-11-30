package Singleton.currency_convertor;


public class CurrencyConvertor {
    private ExchangeRate[] _exchangeRates;

    public CurrencyConvertor() {
        loadExchangeRates();
    }
    private void loadExchangeRates() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("Sleep interrupted");
        }
        _exchangeRates = new ExchangeRate[]{
                new ExchangeRate("USD", "SAR", 3.75),
                new ExchangeRate("USD", "EGP", 47.45),
                new ExchangeRate("SAR", "EGP", 12.65),

        };
    }

    public double convert(double amount, String from, String to) {
        for(var  rate : _exchangeRates)
            if(rate.baseCurrency().equals(from) && rate.targetCurrency().equals(to))
                return amount * rate.rate();
        return 0.0;
    }
}
