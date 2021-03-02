import Calculations.Coin;
import Calculations.Coins;
import Calculations.CoinsFactory;
import Calculations.Conversion;
import ResultWriter.ConversionResultWriter;

import java.util.ArrayList;
import java.util.Scanner;

public class MainScreen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String times;
        ArrayList<Conversion> conversions = new ArrayList<>();
        System.out.println("Welcome to currency convertor");
        do {

            // Show the Welcome screen
            printWelcomeScreen();

            //Read currency to convert from
            int currency = -1;
            do {
                try {
                    currency = scanner.nextInt();
                }
                catch (Exception e){
                    currency = -1;
                    scanner.nextLine();
                }
                if((currency < 1) || (currency > 2)){
                    System.out.println("Invalid Choice, please try again");
                }
            }
            while ((currency < 1) || (currency > 2));

            //Read the value to convert
            double amount;
            while(true){
                try {

                    System.out.println("Please enter an amount to convert");
                    amount = scanner.nextDouble();
                    break;
                }
                catch (Exception e){
                    System.out.println("Invalid Choice, please try again");
                    scanner.nextLine();
                }
            }

            //Create the Currency instance
            Conversion conversion = new Conversion();
            conversion.setCurrencyToConvertFrom(currency == 1 ? Coins.USD : Coins.ILS);
            conversion.setCurrencyToConvertTo(currency == 1 ? Coins.ILS : Coins.USD);
            conversion.setValueToConvert(amount);
            conversions.add(conversion);

            //Start Conversion

            //Get the Coin to convert from
            Coin originalCoin = CoinsFactory.getCoinInstance(conversion.getCurrencyToConvertFrom());

            //Convert the value
            double value = originalCoin.calculate(amount);
            conversion.setConvertedValue(value);

            //Print the result
            System.out.println("" + conversion.getValueToConvert() + conversion.getCurrencyToConvertFrom() + " = " + conversion.getConvertedValue() + conversion.getCurrencyToConvertTo());

            //Ask user if to convert more or exit
            do{
                System.out.println("Interested In Starting Over? Please Enter Y/N");
                times=scanner.next();
            }
            while (!times.equalsIgnoreCase("Y") && !times.equalsIgnoreCase("N"));

        }while (times.equalsIgnoreCase("Y"));

        //Fourth Screen
        System.out.println("Thanks for using our currency convertor.");
        System.out.println(conversions);

        //Print the result to the result.txt file
        ConversionResultWriter conversionResultWriter = new ConversionResultWriter();
        conversionResultWriter.writeResult(conversions);
    }



    private static void printWelcomeScreen() {
        System.out.println("Please choose an option (1/2):");
        System.out.println("1. Dollars to Shekels");
        System.out.println("2. Shekels to Dollars");
    }
}