package Calculations;

import java.io.Serializable;

public class USD extends Coin implements Serializable {
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