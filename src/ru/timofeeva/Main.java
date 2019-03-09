package ru.timofeeva;

import ru.timofeeva.box.PresentBox;
import ru.timofeeva.sweets.*;
import ru.timofeeva.sweets.chocolate.*;
import ru.timofeeva.sweets.gingerbread.Filling;
import ru.timofeeva.sweets.gingerbread.Gingerbread;
import ru.timofeeva.sweets.marmalade.Marmalade;
import ru.timofeeva.sweets.marmalade.MarmaladeTaste;

public class Main {

    public static void main(String[] args) {
        PresentBox box = new PresentBox();
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

        box.printBox();
        System.out.println("Box weight is "+ box.getBoxPrice());
        System.out.println("________________________________________________");
        box.optimizePrice( 1000);
        box.printBox();
        System.out.println("________________________________________________");
        box.optimizeWeight(500);
        box.printBox();
        System.out.println("________________________________________________");



    }
}
