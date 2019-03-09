package ru.timofeeva.sweets.chocolate;

/**
 * @author Timofeeva Natalia
 * @see #BlackChocolate(double, String)
 */
public class BlackChocolate extends Chocolate {

    public BlackChocolate( double price, String name) {

        super(price, 200, name, ChocolateType.BLACK_CHOCOLATE_TILE);
    }
}
