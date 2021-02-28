package Calculations;

public class ILS extends Coin{
    final private double value = 0.28; //השער מעודכן ל: 27-02-2021  ILS1 = 0.28 USD

    @Override
    public double getValue() {
        return value;
    }

    @Override
    public double calculate(double amount) {
        return amount * getValue();


    }


}