package ru.timofeeva.sweets.marmalade;

import ru.timofeeva.sweets.Sweet;

/**
 *  @author Timofeeva Natalia
 *  @see #toString()
 * @see #Marmalade(MarmaladeTaste)
 */

public class Marmalade extends Sweet {
    private MarmaladeTaste taste;


     public Marmalade( MarmaladeTaste taste) {
        super(65, 100, "Marmalade");
        this.taste = taste;
    }

    /*
     *Создаем метод для получения значения переменной taste.
     */
    public MarmaladeTaste getTaste() {
         return taste;
    }

    @Override
    public String toString() {
        return super.toString()+ ", taste - " + getTaste() ;
    }
}
