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
        boolean isEmpty = true;
        for (Sweet s : sweets) {
            if (s != null) {
                isEmpty = false;
                System.out.println(s);
            }
        }
        if (isEmpty){
            System.out.println("Present box is empty!");
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
        if (maxWeight < 0) {
            System.out.println("Max weight can not be negative!");
            return;
        }
        if (isEmpty()) {
            System.out.println("The box is empty!");
            return;
        }
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
        if (maxPrice < 0) {
            System.out.println("Max price can not be negative!");
            return;
        }
        if (isEmpty()) {
            System.out.println("The box is empty!");
            return;
        }
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
        if (index >= sweets.length || index < 0){
            System.out.println("Invalid index was entered!");
            return;
        }
        if (sweets[index] == null) {
            System.out.println("Position at index " + index + " is empty!");
            return;
        }
        Sweet element = sweets[index];
        sweets[index] = null;
        System.out.println("Element " + element.getClass().getSimpleName()+ " "
                + element.getName()+ " at position " + index + " is deleted.");

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

    /*
     * Проверяем пустая ли коробка.
     */
    private boolean isEmpty() {
        boolean isEmpty = true;
        if (sweets == null ||sweets.length == 0){
            return true;
        }
        for (int i = 0; i < sweets.length; i++) {
            if (sweets[i] != null) {
                isEmpty = false;
                break;
            }
        }
        return isEmpty;
    }

}




