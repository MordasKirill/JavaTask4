package net.epam.study.dao;

import net.epam.study.entity.Dish;
import org.w3c.dom.*;
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
                            element.getElementsByTagName("region").item(0).getTextContent()));
                }
            }
        }
    }
}
