package net.epam.study.main;

import net.epam.study.dao.DOMParserDAOImpl;
import net.epam.study.entity.Dish;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.xml.sax.SAXException;

public class DOMParserRunner {
    public static void runner() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File("resources/MenuXML.xml"));
        ArrayList<String> categoryList = new ArrayList<>();
        categoryList.add("appetizer");
        categoryList.add("soup");
        categoryList.add("meat-dish");
        categoryList.add("poultry");
        categoryList.add("fish-and-sea-dish");
        categoryList.add("desert");
        categoryList.add("drink");
        DOMParserDAOImpl.collectInformation(document, categoryList);
        System.out.println("========================================");
        System.out.println("\n"+"Dom parser result: "+"\n");
        System.out.println("========================================");
        for (Dish dish : DOMParserDAOImpl.dishes)
            System.out.println(String.format("Категория: %s, название блюда: %s, стоимость: %s, время подачи: %s, сделан в: %s.",
                    dish.getCategory(), dish.getName(), dish.getPrice(), dish.getFilingTime(), dish.getRegion()));

    }
}
