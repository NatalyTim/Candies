package ru.timofeeva;

import ru.timofeeva.box.Box;
import ru.timofeeva.box.PresentBox;
import ru.timofeeva.sweets.*;
import ru.timofeeva.sweets.chocolate.*;
import ru.timofeeva.sweets.gingerbread.Filling;
import ru.timofeeva.sweets.gingerbread.Gingerbread;
import ru.timofeeva.sweets.marmalade.Marmalade;
import ru.timofeeva.sweets.marmalade.MarmaladeTaste;

public class Main {

    public static void main(String[] args) {
        Box box = new PresentBox();
        System.out.println("***************Tests for empty box*****************");
        System.out.println("\t Test case: Delete empty position.");
        box.delete(1);
        System.out.println();

        System.out.println("\t Test case: Print empty box.");
        box.printBox();
        System.out.println();

        System.out.println("\t Test case: Optimize empty box by price.");
        box.optimizePrice(100);
        System.out.println();

        System.out.println("\t Test case: Invalid input parameter for price optimisation.");
        box.optimizePrice(-1);
        System.out.println();

        System.out.println("\t Test case: Optimize empty box by weight.");
        box.optimizeWeight(500);
        System.out.println();

        System.out.println("\t Test case: Invalid input parameter for weight optimisation.");
        box.optimizeWeight(-1);
        System.out.println();

        System.out.println("***************Tests for filled box*****************");
        box.add(new Nuts());
        box.add(new Snickers());
        box.add(new Mars());
        box.add(new WhiteChocolate(60, "Alpen Gold"));
        box.add(new BlackChocolate(200, "President"));
        box.add(new MilkChocolate(70, "Milka"));
        box.add(new MilkChocolate(250, "King"));
        box.add(new Marmalade(MarmaladeTaste.PEAR));
        box.add(new Gingerbread(110, Filling.CLASSIC_GINGERBREAD));
        box.add(new Gingerbread(145, Filling.GINGERBREAD_WITH_APPLE));

        System.out.println("\t Test case: Print filled box.");
        box.printBox();
        System.out.println();

        System.out.println("\t Test case: Get box weight.");
        System.out.println("Box weight is "+ box.getBoxPrice());
        System.out.println();

        System.out.println("\t Test case: Optimize filled box by price.");
        box.optimizePrice( 1000);
        box.printBox();
        System.out.println();

        System.out.println("\t Test case: Optimize filled box by weight.");
        box.optimizeWeight(500);
        box.printBox();
        System.out.println();

        System.out.println("\t Test case: Delete filled position.");
        box.delete(1);




    }
}
