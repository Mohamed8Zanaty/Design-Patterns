package Singleton.currency_convertor;

public class ExchangeRate {
    public ExchangeRate(
            String baseCurrency,
            String targetCurrency,
            double rate
    ) {
        _baseCurrency =  baseCurrency;
        _targetCurrency = targetCurrency;
        _rate = rate;
    }
    private String _baseCurrency;
    private String _targetCurrency;
    private double _rate;

    public String baseCurrency() {return _baseCurrency;}
    public String targetCurrency() {return _targetCurrency;}
    public double rate() {return _rate;}
}
