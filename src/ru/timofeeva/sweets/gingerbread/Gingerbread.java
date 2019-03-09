package ru.timofeeva.sweets.gingerbread;

import ru.timofeeva.sweets.Sweet;

/**
 * @author Timofeeva Natalia
 * @see #toString()
 * @see #Gingerbread(double, Filling)
 * @see #getFilling()
 */

public class Gingerbread extends Sweet {
    private Filling filling;

    /*
     *Создаем метод для получения значения переменной filling.
     */
    public Filling getFilling() {
        return filling;
    }

    public Gingerbread(double price, Filling type) {
        super(price, 120, "Tylskii pryanik");
        this.filling = type;
    }

    @Override
    public String toString() {
        return super.toString() + ", filling - " + getFilling();
    }


}
