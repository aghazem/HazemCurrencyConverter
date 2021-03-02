package Calculations;

public abstract class Coin implements MyPackage.ICalcualte {
    public abstract double getValue ();

    @Override
    public double calculate(double amount) {

        return amount;
    }
}