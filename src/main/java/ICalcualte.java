//This command so that I can connect the "ICalcualte" class found in the "SRC" main directory
// to the "Coin" class found in the "Calculations" directory
package MyPackage;

public interface ICalcualte {     //Make Coin class implement ICalcualte and add calculate() method.
    public double calculate (double amount);  //Add calculate() to both USD and ILS classes.
}

