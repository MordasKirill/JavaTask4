package net.epam.study.main;

import net.epam.study.dao.STAXParserDAOImpl;
import net.epam.study.entity.Dish;

import java.util.ArrayList;
import java.util.List;

public class STAXParserRunner {
    public static void runner(){
        String fileName = "resources/MenuXML.xml";
        List<Dish> dishList = STAXParserDAOImpl.collectInformation(fileName);
        System.out.println("========================================");
        System.out.println("\n"+"Stax parser result: "+"\n");
        System.out.println("========================================");
        for (Dish dish : dishList) {
            System.out.println(dish.toString());
        }
    }
}
