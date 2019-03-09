package ru.timofeeva.box;

import ru.timofeeva.comparators.SweetComparatorByPrice;
import ru.timofeeva.comparators.SweetComparatorByWeight;
import ru.timofeeva.sweets.Sweet;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Timofeeva Natalia
 * @see #add(Sweet)
 * @see #createLargestSweet()
 * @see #getBoxPrice()
 * @see #getBoxWeight()
 * @see #optimizePrice(double)
 * @see #optimizeWeight(double)
 * @see #printBox()
 */

public class PresentBox implements Box {
    private Sweet[] sweets = new Sweet[10];

    /*
     * Создаем метод для заполнения массива.
     */
    @Override
    public void add(Sweet sweet) {
        boolean flag = true;
        for (int i = 0; i < sweets.length; i++) {

            if (sweets[i] == null) {
                flag = false;
                sweets[i] = sweet;
                break;
            }
        }
        if (flag) {
            Sweet[] largerSweets = createLargestSweet();
            largerSweets[sweets.length] = sweet;
            sweets = largerSweets;
        }

    }

    /*
     * Создаем метод для вывода массива.
     */
    @Override
    public void printBox() {
        for (Sweet s : sweets) {
            System.out.println(s);
        }
    }

    /*
     * Создаем метод для вычисления веса.
     */
    @Override
    public double getBoxWeight() {
        double boxWeight = 0;
        for (int i = 0; i < sweets.length; i++) {
            if (sweets[i] != null) {
                boxWeight += sweets[i].getWeight();
            }
        }
        return boxWeight;
    }

    /*
     * Создаем метод для вычисления цены.
     */
    @Override
    public double getBoxPrice() {
        double boxPrice = 0;
        for (int i = 0; i < sweets.length; i++) {
            if (sweets[i] != null) {
                boxPrice += sweets[i].getPrice();
            }
        }
        return boxPrice;
    }

    /*
     *Создаем метод для оптимизции массива по весу.
     */
    @Override
    public void optimizeWeight(double maxWeight) {
        double difference = getBoxWeight() - maxWeight;
        if (difference > 0) {
            sweets = arraySort(new SweetComparatorByWeight());
            for (int i = sweets.length - 1; difference > 0; i--) {
                if (sweets[i] != null) {
                    difference -= sweets[i].getWeight();
                    delete(i);

                }
            }
        }
        System.out.println("Present box weight after optimisation is " + getBoxWeight() + " grams");
    }

    /*
     *Создаем метод для оптимизции массива по цене.
     */
    @Override
    public void optimizePrice(double maxPrice) {
        double difference = getBoxPrice() - maxPrice;
        if (difference > 0) {
            sweets = arraySort(new SweetComparatorByPrice());
            for (int i = sweets.length - 1; difference > 0; i--) {
                if (sweets[i] != null) {
                    difference -= sweets[i].getPrice();
                    delete(i);
                }
            }
        }
        System.out.println("Present box price after optimisation is " + getBoxPrice() + " rubles");
    }

    /*
     *Создаем метод для удаления элементов из массива.
     */
    @Override
    public void delete(int index) {

        sweets[index] = null;
    }

    /*
     *Создаем метод для увеличения массива.
     */
    private Sweet[] createLargestSweet() {
        return Arrays.copyOf(sweets, sweets.length + 5);
    }

    /*
     *Создаем метод для сортировки массива по убыванию.
     */
    private Sweet[] arraySort(Comparator<Sweet> sweetComparator) {
        boolean isSorted = false;
        Sweet buf;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < sweets.length - 1; i++) {
                if (sweetComparator.compare(sweets[i], sweets[i + 1]) == -1) {
                    isSorted = false;

                    buf = sweets[i];
                    sweets[i] = sweets[i + 1];
                    sweets[i + 1] = buf;
                }
            }
        }
        return sweets;
    }

}




