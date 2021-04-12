package net.epam.study.main;

import net.epam.study.dao.SAXParserDAOImpl;
import net.epam.study.entity.Dish;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class SAXParserRunner {
    public static void runner() throws ParserConfigurationException, SAXException, IOException{
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        SAXParserDAOImpl saxParserDAO = new SAXParserDAOImpl();
        parser.parse(new File("resources/MenuXML.xml"), saxParserDAO);
        System.out.println("========================================");
        System.out.println("\n"+"Sax parser result: "+"\n");
        System.out.println("========================================");
        for (Dish dish : SAXParserDAOImpl.dishes)
            System.out.println(String.format("Категория %s, имя блюда: %s, его стоимость: %s, время подачи: %s, сделан в: %s",
                    dish.getCategory(), dish.getName(), dish.getPrice(), dish.getFilingTime(), dish.getRegion()));
    }

}
