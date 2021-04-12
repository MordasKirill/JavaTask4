package net.epam.study.dao;

import jdk.internal.org.xml.sax.SAXException;
import net.epam.study.entity.Dish;
import org.w3c.dom.*;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.util.ArrayList;

public class DOMParserDAOImpl {
    public static ArrayList<Dish> dishes = new ArrayList<>();

    public static void collectInformation(Document document, ArrayList<String> categoryList) {
        for (String category : categoryList) {
            NodeList elementsByCategoryName = document.getDocumentElement().getElementsByTagName(category);
            for (int j = 0; j < elementsByCategoryName.getLength(); j++) {
                Node node = elementsByCategoryName.item(j);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    dishes.add(new Dish(category, element.getElementsByTagName("name").item(0).getTextContent(),
                            element.getElementsByTagName("price").item(0).getTextContent(),
                            element.getElementsByTagName("filing-time").item(0).getTextContent(),
                            element.getElementsByTagName("region").item(0).getTextContent()));
                }
            }
        }
    }
}
