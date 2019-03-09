package ru.timofeeva.sweets.chocolate;

/**
 * @author Timofeeva Natalia
 * @see #MilkChocolate(double, String)
 */


public class MilkChocolate extends Chocolate {
    public MilkChocolate(double price, String name) {
        super(price, 200, name, ChocolateType.MILK_CHOCOLATE_TILE);
    }
}
