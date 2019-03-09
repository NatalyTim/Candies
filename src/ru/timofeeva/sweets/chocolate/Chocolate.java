package ru.timofeeva.sweets.chocolate;

import ru.timofeeva.sweets.Sweet;

/**
 * @author Timofeeva Natalia
 * @see #Chocolate(double, double, String, ChocolateType)
 * @see #toString()
 */

public class Chocolate extends Sweet {

    private ChocolateType type;

    public Chocolate(double price, double weight, String name, ChocolateType type) {
        super(price, weight, name);
        this.type = type;
    }

    @Override
    public String toString() {
        return super.toString() +", type - " + getType();
    }

    /*
     *Создаем метод для получения значения переменной type.
     */
    public ChocolateType getType() {
        return type;
    }

}
