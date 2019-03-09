package ru.timofeeva.comparators;

import ru.timofeeva.sweets.Sweet;

import java.util.Comparator;

/**
 * @author Timofeeva Natalia
 * @see #compare(Sweet, Sweet)
 */
public class SweetComparatorByPrice implements Comparator<Sweet> {
    /*
     *Создаем метод для сравнения элементов массива.
     */
    @Override
    public int compare(Sweet sweet1, Sweet sweet2) {
        if (sweet1 == null && sweet2 == null) {
            return 0;
        } else if (sweet1 == null) {
            return -1;
        } else if (sweet2 == null) {
            return 1;
        } else if (sweet1.getPrice() == sweet2.getPrice()) {
            return 0;
        } else if (sweet1.getPrice() > sweet2.getPrice()) {
            return 1;
        } else {
            return -1;
        }
    }
}
