package Calculations;

public class USD extends Coin {
    final private double value = 3.52;  //השער מעודכן ל: 27-02-2021  USD1 = 3.52 ILS

    @Override
    public double getValue() {
        return value;
    }

    @Override
    public double calculate(double amount) {
        return amount * getValue();
    }

}