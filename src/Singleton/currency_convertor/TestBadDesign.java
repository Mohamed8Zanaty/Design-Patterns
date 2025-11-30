package Singleton.currency_convertor;

import java.util.Scanner;


public class TestBadDesign {
    static void main(){
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Please enter your currency code:");
            String baseCurrency = scanner.next();
            System.out.println("Please enter your target currency:");
            String targetCurrency = scanner.next();
            System.out.println("Please enter the amount:");
            double amount = scanner.nextDouble();
            var convertor = new CurrencyConvertor();
            var exchangedAmount = convertor.convert(amount,baseCurrency,targetCurrency);
            System.out.println(amount + " " + baseCurrency + " = " + exchangedAmount + " " + targetCurrency);
            System.out.println("=============================================================================");
        }
    }
}
