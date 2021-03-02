package Calculations;

import java.io.Serializable;

public class ILS extends Coin implements Serializable {
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